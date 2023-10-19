import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Dictionary;
import java.util.Hashtable;

class create_gui extends JFrame{
    JFrame frame = new JFrame();
    Dictionary<String, JPanel> panelDictionary = new Hashtable<>();
    Dictionary<String, JButton> buttonDictionary = new Hashtable<>();
    Dictionary<String, JTextField> textfieldDictionary = new Hashtable<>();
    Dictionary<String, JLabel> labelDictionary = new Hashtable<>();
    Dictionary<String, JComboBox> comboBoxDictionary = new Hashtable<>();

    create_gui(int width, int height, String name){
        frame.setSize(width,height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(name);
    }
    create_gui(int width, int height, int row, int column, String name){
        frame.setSize(width,height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(name);
        frame.setLayout(new GridLayout(row,column));
    }
    public void add_panel(String key,String direction){
        JPanel panels = new JPanel();
        panels.setLayout(null);
        panelDictionary.put(key,panels);
        frame.add(panelDictionary.get(key));
    }
    public void add_panel(String key,int row,int column){
        JPanel panels = new JPanel();
        panels.setLayout(new GridLayout(row,column));
        panelDictionary.put(key,panels);
        frame.add(panelDictionary.get(key));
    }

    public void add_panel(String key,int row,int column,int hgap,int vgap,String direction){
        JPanel panels = new JPanel();
        panels.setLayout(new GridLayout(row,column,hgap,vgap));
        panelDictionary.put(key,panels);
        if(direction == "NORTH"){
            frame.add(panelDictionary.get(key),BorderLayout.NORTH);

        }else if(direction == "SOUTH"){
            frame.add(panelDictionary.get(key),BorderLayout.SOUTH);

        }else if(direction == "EAST"){
            frame.add(panelDictionary.get(key),BorderLayout.EAST);

        }else if(direction == "WEST"){
            frame.add(panelDictionary.get(key),BorderLayout.WEST);

        }else if(direction == "CENTER"){
            frame.add(panelDictionary.get(key),BorderLayout.CENTER);

        }else{
            frame.add(panelDictionary.get(key));
        }


    }
    public void add_panel_to_panel(String key,String key_panel,String direction){
        JPanel panels = new JPanel();
        panels.setLayout(null);
        panelDictionary.put(key,panels);
        panelDictionary.get(key_panel).add(panelDictionary.get(key));
    }
    public void add_button(String text,String key,int x,int y,int width,int height,String key_panel){
        JButton button = new JButton();
        button.setText(text);
        button.setBounds(x,y,width,height);
        buttonDictionary.put(text,button);
        panelDictionary.get(key_panel).add(buttonDictionary.get(key));

    }
    public void add_button(String text,String key,String key_panel){
        JButton button = new JButton();
        button.setText(text);
        buttonDictionary.put(key,button);
        panelDictionary.get(key_panel).add(buttonDictionary.get(key));
    }
    public void add_button(String text,String key){
        JButton button = new JButton();
        button.setText(text);
        buttonDictionary.put(key,button);
        frame.add(buttonDictionary.get(key));
    }
    public void add_button(String text,String direction,String key,String key_panel){
        JButton button = new JButton();
        button.setText(text);
        buttonDictionary.put(key,button);
        if(direction == "NORTH"){

            panelDictionary.get(key_panel).add(buttonDictionary.get(key),BorderLayout.NORTH);

        }else if(direction == "SOUTH"){
            panelDictionary.get(key_panel).add(buttonDictionary.get(key),BorderLayout.SOUTH);

        }else if(direction == "EAST"){
            panelDictionary.get(key_panel).add(buttonDictionary.get(key),BorderLayout.EAST);

        }else if(direction == "WEST"){
            panelDictionary.get(key_panel).add(buttonDictionary.get(key),BorderLayout.WEST);

        }else if(direction == "CENTER"){
            panelDictionary.get(key_panel).add(buttonDictionary.get(key),BorderLayout.CENTER);

        }else{
            panelDictionary.get(key_panel).add(buttonDictionary.get(key),new BorderLayout());

        }
    }
    public void set_jframe_visible(boolean open){
        frame.setVisible(open);
    }
    public void add_field_text(String name,String key,int x,int y,int width,int height,String key_panel){
        JTextField t1 = new JTextField(name);
        t1.setBounds(x,y,width,height);
        textfieldDictionary.put(key,t1);
        panelDictionary.get(key_panel).add(textfieldDictionary.get(key));
    }
    public void add_field_text(String name,String key,int x,int y,int width,int height){
        JTextField t1 = new JTextField(name);
        t1.setBounds(x,y,width,height);
        textfieldDictionary.put(key,t1);
        frame.add(t1);

    }
    public void add_field_text(String name,int width,int height,String key,String key_panel){
        JTextField t1 = new JTextField(name);
        t1.setSize(width,height);
        textfieldDictionary.put(key,t1);
        panelDictionary.get(key_panel).add(textfieldDictionary.get(key));

    }
    public void add_ComboBox(String key,int x,int y,int width,int height,String[] choice,String key_panel){
        JComboBox combo = new JComboBox(choice);
        combo.setBounds(x,y,width,height);
        comboBoxDictionary.put(key,combo);
        panelDictionary.get(key_panel).add(comboBoxDictionary.get(key));
    }
    public void add_field_text(String name,String direction,String key,String key_panel){
        JTextField t1 = new JTextField(name);
        textfieldDictionary.put(key, t1);
        if(direction == "NORTH"){
            panelDictionary.get(key_panel).add( textfieldDictionary.get(key),BorderLayout.NORTH);

        }else if(direction == "SOUTH"){
            panelDictionary.get(key_panel).add( textfieldDictionary.get(key),BorderLayout.SOUTH);

        }else if(direction == "EAST"){
            panelDictionary.get(key_panel).add( textfieldDictionary.get(key),BorderLayout.EAST);

        }else if(direction == "WEST"){
            panelDictionary.get(key_panel).add( textfieldDictionary.get(key),BorderLayout.WEST);

        }else if(direction == "CENTER"){
            panelDictionary.get(key_panel).add( textfieldDictionary.get(key),BorderLayout.CENTER);

        }else{
            panelDictionary.get(key_panel).add(textfieldDictionary.get(key));

        }
    }
    public void add_label(String title,String key,int x,int y,int width,int height,String key_panel){
        JLabel text = new JLabel(title);
        text.setBounds(x,y,width,height);
        labelDictionary.put(key,text);
        panelDictionary.get(key_panel).add(labelDictionary.get(key));

    }
    public void add_label(String title,String key,String borderlayout){
        JLabel text = new JLabel(title);
        labelDictionary.put(key,text);
        frame.add(labelDictionary.get(key),borderlayout);
    }
    public void add_label(String title,String key,int x,int y,int width,int height){
        JLabel text = new JLabel(title);
        text.setBounds(x,y,width,height);
        labelDictionary.put(key,text);
        frame.add(labelDictionary.get(key),BorderLayout.NORTH);
    }
    public void add_label(String title,int width,int height,String key,String key_panel){
        JLabel text = new JLabel(title);
        text.setSize(width,height);
        labelDictionary.put(key,text);
        panelDictionary.get(key_panel).add(labelDictionary.get(key));

    }
    public void add_label(String title,String direction,String key,String key_panel){
        JLabel text = new JLabel(title);
        labelDictionary.put(key,text);
        if(direction == "NORTH"){
            panelDictionary.get(key_panel).add(labelDictionary.get(key),BorderLayout.NORTH);

        }else if(direction == "SOUTH"){
            panelDictionary.get(key_panel).add(labelDictionary.get(key),BorderLayout.SOUTH);

        }else if(direction == "EAST"){
            panelDictionary.get(key_panel).add(labelDictionary.get(key),BorderLayout.EAST);

        }else if(direction == "WEST"){
            panelDictionary.get(key_panel).add(labelDictionary.get(key),BorderLayout.WEST);

        }else if(direction == "CENTER"){
            panelDictionary.get(key_panel).add(labelDictionary.get(key),BorderLayout.CENTER);

        }else{
            panelDictionary.get(key_panel).add(labelDictionary.get(key));

        }
    }
    public JButton get_button(String key){
        return buttonDictionary.get(key);
    }
    public JTextField get_textfield(String key){
        return textfieldDictionary.get(key);
    }
    public JLabel get_label(String key){
        return labelDictionary.get(key);
    }

}