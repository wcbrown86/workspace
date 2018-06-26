import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class TimerTester 
{
    
    private JFrame testFrame;
    private JPanel jpCenter;
    private JLabel jlComponentValue;
    private JButton jbRed;
    private JButton jbGreen;
    private JButton jbBlue;
    Timer redTimer;
    Timer greenTimer;
    Timer blueTimer;
    
    public TimerTester()
    {
        testFrame = new JFrame();
        testFrame.setLocation(100,100);
        testFrame.setSize(400,400);
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testFrame.setTitle("Component Tester");

        initializeComponents();
        
        testFrame.pack();
        testFrame.setVisible(true);
    }
    
    public void enableButton(String color)
    {
        if (color.equals("Red"))
        {
            jbRed.setEnabled(true);
        }
        else if (color.equals("Green"))
        {
            jbGreen.setEnabled(true);
        }
        else if (color.equals("Blue"))
        {
            jbBlue.setEnabled(true);
        }
        
        this.updateColor();
    }

    public void buttonClicked(JButton button)
    {
        final String color = button.getText();
        
        if (color.equals("Red"))
        {
            jbRed.setEnabled(false);
            redTimer.restart();

        }
        else if (color.equals("Green"))
        {
            jbGreen.setEnabled(false);
            greenTimer.restart();
            
        }
        else if (color.equals("Blue"))
        {
            jbBlue.setEnabled(false);
            blueTimer.restart();
        }

        updateColor();
    }
     
    public void updateColor()
    {
        int red = 0;
        int green = 0;
        int blue = 0;
        
        String colorValue = "";
        if (!jbRed.isEnabled())
        {
            colorValue += "Red ";
            red = 200;
        }
        if (!jbGreen.isEnabled())
        {
            colorValue += "Green ";
            green = 200;
        }
        if (!jbBlue.isEnabled())
        {
            colorValue += "Blue ";
            blue = 200;
        }
        
        if (colorValue.equals(""))
        {
            colorValue = "None";
        }
        
        jpCenter.setBackground(new Color(red,green,blue));
        jlComponentValue.setText("Active Colors: "+ colorValue);
        
        
    }
    
    public void addTimers()
    {
        redTimer = new javax.swing.Timer(
                2000, 
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        enableButton("Red");
                    }
        });
        
        greenTimer = new javax.swing.Timer(
                2000, 
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        enableButton("Green");
                    }
        });
        
        blueTimer = new javax.swing.Timer(
                2000, 
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        enableButton("Blue");
                    }
        });
    }

    public void initializeComponents()
    {
        JPanel jpNorth = new JPanel();
        jpCenter = new JPanel();
        JPanel jpSouth = new JPanel();

        jlComponentValue = new JLabel("");
        jpNorth.add(jlComponentValue);
        
        jpCenter.setPreferredSize(new Dimension(300,300));

        //Using a method to create and add buttons
        //Parameters are:
        //  panel to put this button into 
        //  group to associate with 
        //  text to appear next to button
        //  true means this button should be selected on startup
        jbRed = addButton(jpSouth, "Red");
        jbGreen = addButton(jpSouth, "Green");
        jbBlue = addButton(jpSouth, "Blue");
        
        addTimers();
        updateColor();
        
        testFrame.add(jpNorth, BorderLayout.PAGE_START);
        testFrame.add(jpCenter, BorderLayout.CENTER);
        testFrame.add(jpSouth, BorderLayout.PAGE_END);
    }
    
    
    public JButton addButton(JPanel panel, String buttonText)
    {
 
        JButton jb = new JButton(buttonText);
        jb.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e){
                buttonClicked((JButton)e.getSource());
            }
        });

        panel.add(jb);
        return jb;
    }
    
    public static void main(String[] args)
    {
        new TimerTester();
    }
}
