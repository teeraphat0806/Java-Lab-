import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class show_detail extends JFrame implements ActionListener {
    public create_gui gui;
    public Accounts account = new Accounts();


    show_detail(create_gui gui){
        String[] yearss = new String[123];
        String[] dayss = new String[32];
        int j =1;
        yearss[0]= "year";
        dayss[0]= "day";
        for (int k=1;k<32;k++){
            dayss[k] = String.valueOf(k);
        }
        for (int k = 1901;k<2023;k++){
            yearss[j] = String.valueOf(k);
            j+=1;
        }
        Date dates = new Date();
        Person persons = new Person();
        account.setObjPerson(persons);
        account.set_dateCreated(dates);
        gui.set_jframe_visible(true);
        gui.add_label("                                                 ACCOUNT MONEY","account",new BorderLayout().NORTH);
        gui.add_panel("panel","CENTER");
        gui.panelDictionary.get("panel").setBorder(new TitledBorder("Enter Data Account Money"));
        gui.add_label("   ID: "," ",10,47,100,20,"panel");
        gui.add_field_text(" ","id",50,47,100,20,"panel");
        gui.add_label("   MONEY: ","money",160,31,100,50,"panel");
        gui.add_field_text(" ","money",230,47,100,20,"panel");
        gui.add_label("   BATH: ","money",340,31,100,50,"panel");
        gui.add_label("  ANNUALINTERATE RATE: ","annual",10,80,170,50,"panel");
        gui.add_field_text(" ","annual",180,98,130,20,"panel");
        gui.add_label("  DAY OPEN ACCOUNT: ","day",9,130,150,50,"panel");
        gui.add_ComboBox("day",170,145,55,25,dayss,"panel");
        gui.comboBoxDictionary.get("day").setSelectedIndex(0);
        gui.add_ComboBox("month",240,145,80,25,new String[]{"month","January","September","February"},"panel");
        gui.comboBoxDictionary.get("month").setSelectedIndex(0);

        gui.add_ComboBox("year",12,190,80,25,yearss,"panel");
        gui.comboBoxDictionary.get("year").setSelectedIndex(0);
        gui.add_label("  FIRST NAME : ","firstname",100,180,100,50,"panel");
        gui.add_field_text(" ","firstname",200,195,170,20,"panel");
        gui.add_label("  LAST NAME    : ","annual",9,225,150,50,"panel");
        gui.add_field_text(" ","lastname",120,240,200,20,"panel");
        gui.add_label("   BIRTH DAY    : ","money",5,280,100,20,"panel");
        gui.add_ComboBox("days",130,280,55,25,dayss,"panel");
        gui.comboBoxDictionary.get("days").setSelectedIndex(0);
        gui.add_ComboBox("months",200,280,80,25,new String[]{"month","January","February","March","April","May","June","July","August","September","October","November","December"},"panel");
        gui.comboBoxDictionary.get("months").setSelectedIndex(0);

        gui.add_ComboBox("years",295,280,80,25,yearss,"panel");
        gui.comboBoxDictionary.get("years").setSelectedIndex(0);
        gui.add_label("  AGE  : ","age",9,320,100,20,"panel");
        gui.add_field_text(" ","age",70,320,70,20,"panel");
        gui.add_label("   YEAR","year",150,320,100,20,"panel");

        gui.add_panel("panel3","SOUTH");
        gui.add_button("SAVE","save","panel3");
        gui.buttonDictionary.get("save").setBounds(225,400,80,20);
        gui.buttonDictionary.get("save").setSize(80,20);
        gui.buttonDictionary.get("save").addActionListener(this);

        gui.add_button("SHOW","show","panel3");
        gui.buttonDictionary.get("show").setBounds(310,400,80,20);
        gui.buttonDictionary.get("show").setSize(80,20);
        gui.buttonDictionary.get("show").addActionListener(this);

        this.gui = gui;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        String months = (String) gui.comboBoxDictionary.get("months").getSelectedItem();
        if (obj == gui.buttonDictionary.get("save")) {
            Date bdate = new Date();
            String date = (String) gui.comboBoxDictionary.get("day").getSelectedItem();
            String month = (String) gui.comboBoxDictionary.get("month").getSelectedItem();
            String year = (String) gui.comboBoxDictionary.get("year").getSelectedItem();
            String dates = (String) gui.comboBoxDictionary.get("days").getSelectedItem();

            String years = (String) gui.comboBoxDictionary.get("years").getSelectedItem();
            bdate.set_day(Integer.parseInt(date.replaceAll("\\s", "")));
            bdate.set_month(month.replaceAll("\\s", ""));
            bdate.set_year(Integer.parseInt(year.replaceAll("\\s", "")));
            try{
                account.set_id(Integer.parseInt(gui.textfieldDictionary.get("id").getText().replaceAll("\\s", "")));}
            catch (NumberFormatException ex){
                gui.textfieldDictionary.get("id").setText("please input number");
            }try {
                account.set_balance(Double.parseDouble(gui.textfieldDictionary.get("money").getText().replaceAll("\\s", "")));
            }catch (NumberFormatException ex){
                gui.textfieldDictionary.get("money").setText("please input number");
            }try{
                account.set_annualInterestRate(Double.parseDouble(gui.textfieldDictionary.get("annual").getText().replaceAll("\\s", "")));
            }catch (NumberFormatException ex){
                gui.textfieldDictionary.get("annual").setText("please input number");
            }try {
                account.set_age(Integer.parseInt(gui.textfieldDictionary.get("age").getText().replaceAll("\\s", "")));
            }catch (NumberFormatException ex){
                gui.textfieldDictionary.get("age").setText("please input number");
            }


            account.getObjPerson().setName(gui.textfieldDictionary.get("firstname").getText().replaceAll("\\s", ""));
            account.getObjPerson().setSurname(gui.textfieldDictionary.get("lastname").getText().replaceAll("\\s", ""));

            account.get_dateCreated().set_day(Integer.parseInt(dates.replaceAll("\\s", "")));
            account.get_dateCreated().set_month(months.replaceAll("\\s", ""));
            account.get_dateCreated().set_year(Integer.parseInt(years.replaceAll("\\s", "")));
            account.getObjPerson().setbDate(bdate);
        }else if(obj == gui.buttonDictionary.get("show")){
            System.out.println("ID: "+account.get_id()+"\nFirstname:"+account.getObjPerson().get_name()+"\tSurname:"+account.getObjPerson().get_surname());
            System.out.println("Create Account Date: "+account.get_dateCreated().get_day()+"-"+account.get_dateCreated().get_month()+"-"+account.get_dateCreated().get_year());
            System.out.println("Birth Date: "+account.getObjPerson().getbDate().get_day()+"-"+account.getObjPerson().getbDate().get_month()+"-"+account.getObjPerson().getbDate().get_year()+"\tAge: "+account.get_age());
            System.out.println("MonthlyInterestRate: "+account.getMonthlyInterestRate() +"\tbalance: "+account.get_balance());
        }

    }
}
public class Main {
    public static void main(String[] args) {
        create_gui show = new create_gui(410,450,"Show Detail of Account");
        show_detail show_details = new show_detail(show);
    }
}