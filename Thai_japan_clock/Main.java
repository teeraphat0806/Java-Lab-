import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.Timer;


class ClockAnimation extends JFrame {
    private StillClock Thailand = new StillClock();
    private StillClock Japan = new StillClock();
    private JPanel panel = new JPanel();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JLabel thai_japan = new JLabel("Thai Japan");
    protected JButton ok = new JButton("ok");
    protected JTextField input = new JTextField(3);
    protected boolean japan_time,us_time;
      public ClockAnimation() {
          panel1.setLayout(new GridLayout(1,2));
            japan_time = false;
            us_time = false;
          add(panel,BorderLayout.NORTH);
          add(panel1,BorderLayout.CENTER);
          add(panel2,BorderLayout.SOUTH);

          JLabel input_country = new JLabel("Input Country");

          input.setSize(100,20);
          ok.setSize(50,50);
          ok.addActionListener(new TimerListener());
          panel.add(thai_japan);
          panel1.add(Thailand);
          panel1.add(Japan);
          panel2.add(input_country);
          panel2.add(input);
          panel2.add(ok);
          // Create a timer with delay 1000 ms
          Timer timer = new Timer(1000, new TimerListener());
          timer.start();
      }
      private class TimerListener implements ActionListener {
          public void reset_time(){
              japan_time = false;
              us_time = false;
          }
     @Override /** Handle the action event */
        public void actionPerformed(ActionEvent e) {
                    // Set new time and repaint the clock to display current time
                    Thailand.setCurrentTime();
                    Thailand.repaint();
                    Japan.repaint();
                    if(e.getSource() == ok){
                        if(input.getText().replaceAll("\\s", "").equalsIgnoreCase("japan")) {
                            reset_time();
                            japan_time = true;
                        }else if(input.getText().replaceAll("\\s", "").equalsIgnoreCase("us")){
                            reset_time();

                            us_time = true;
                        }
                    }
                    if(japan_time){
                        Japan.setJapantime();
                        thai_japan.setText("Thai Japan");
                    }else if(us_time){
                        Japan.setUstime();
                        thai_japan.setText("Thai US");}
                    else{
                        Japan.setCurrentTime();
                        thai_japan.setText("Thai Japan");
                    }
                    Japan.repaint();
                  }
        }

               /** Main method */
               public static void main(String[] args) {
                JFrame frame = new ClockAnimation();
               frame.setTitle("ClockAnimation");
              frame.setSize(200, 200);
              frame.setLocationRelativeTo(null); // Center the frame
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
               }
         }

  class StillClock extends JPanel {
private int hour;
private int minute;
 private int second;

     /** Construct a default clock with the current time*/
      public StillClock() {
     setCurrentTime();
   }

       /** Construct a clock with specified hour, minute, and second */
        public StillClock(int hour, int minute, int second) {
         this.hour = hour;
        this.minute = minute;
         this.second = second;
       }

        /** Return hour */
        public int getHour() {
         return hour;
       }

         /** Set a new hour */
         public void setHour(int hour) {
         this.hour = hour;
         repaint();
         }

         /** Return minute */
         public int getMinute() {
         return minute;
         }

        /** Set a new minute */
         public void setMinute(int minute) {
         this.minute = minute;
         repaint();
         }

         /** Return second */
         public int getSecond() {
         return second;
         }

         /** Set a new second */public void setSecond(int second) {
        this.second = second;
        repaint();
        }

        @Override /** Draw the clock */
        protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Initialize clock parameters
        int clockRadius = (int)(Math.min(getWidth(), getHeight()) * 0.8 * 0.5);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        // Draw circle
        g.setColor(Color.black);
        g.drawOval(xCenter - clockRadius, yCenter - clockRadius, 2 * clockRadius, 2 * clockRadius);
        g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
        g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
        g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
        g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);

        // Draw second hand
        int sLength = (int)(clockRadius * 0.8);
        int xSecond = (int)(xCenter + sLength * Math.sin(second * (2 * Math.PI / 60)));
        int ySecond = (int)(yCenter - sLength *  Math.cos(second * (2 * Math.PI / 60)));
        g.setColor(Color.red);
        g.drawLine(xCenter, yCenter, xSecond, ySecond);


         // Draw minute hand
         int mLength = (int)(clockRadius * 0.65);
         int xMinute = (int)(xCenter + mLength * Math.sin(minute * (2 * Math.PI / 60)));
         int yMinute = (int)(yCenter - mLength *
         Math.cos(minute * (2 * Math.PI / 60)));
         g.setColor(Color.blue);
         g.drawLine(xCenter, yCenter, xMinute, yMinute);

         // Draw hour hand
         int hLength = (int)(clockRadius * 0.5);
         int xHour = (int)(xCenter + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
         int yHour = (int)(yCenter - hLength *
                 Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
         g.setColor(Color.green);
         g.drawLine(xCenter, yCenter, xHour, yHour);
        }


    public void setCurrentTime() {
         // Construct a calendar for the current date and time
         Calendar calendar = new GregorianCalendar();

         // Set current hour, minute and second
         this.hour = calendar.get(Calendar.HOUR_OF_DAY);
         this.minute = calendar.get(Calendar.MINUTE);
         this.second = calendar.get(Calendar.SECOND);
         }
      public void setJapantime() {
          // Construct a calendar for the current date and time
          Calendar calendar = new GregorianCalendar();

          // Set current hour, minute and second
          this.hour = calendar.get(Calendar.HOUR_OF_DAY)+2;
          this.minute = calendar.get(Calendar.MINUTE);
          this.second = calendar.get(Calendar.SECOND);
      }
      public void setUstime() {
          // Construct a calendar for the current date and time
          Calendar calendar = new GregorianCalendar();

          // Set current hour, minute and second
          this.hour = calendar.get(Calendar.HOUR_OF_DAY)+8;
          this.minute = calendar.get(Calendar.MINUTE);
          this.second = calendar.get(Calendar.SECOND);
      }

         @Override
 public Dimension getPreferredSize() {
         return new Dimension(200, 200);
         }
 }