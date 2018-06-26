import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class RadioButtonTester 
{
    
    private JFrame testFrame;
    private JPanel jpCenter;
    private JLabel jlComponentValue;
    
    public RadioButtonTester()
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
    
    public void radioButtonChanged(JRadioButton radio)
    {
        String color = radio.getText();
        
        jlComponentValue.setText("Radio Button Selected: "+color);
        
        if (color.toLowerCase().equals("red"))
        {
            jpCenter.setBackground(Color.RED);
        }
        else if (color.toLowerCase().equals("blue"))
        {
            jpCenter.setBackground(Color.BLUE);
        }
        else
        {
            jpCenter.setBackground(Color.GREEN);            
        }
    }

    public void initializeComponents()
    {
        JPanel jpNorth = new JPanel();
        jpCenter = new JPanel();
        JPanel jpSouth = new JPanel();

        jlComponentValue = new JLabel("");
        jpNorth.add(jlComponentValue);
        
        jpCenter.setPreferredSize(new Dimension(300,300));
        
        //Button group makes radio buttons work as a unit
        ButtonGroup radioButtonGroup = new ButtonGroup();
        
        //Using a method to create and add buttons
        //Parameters are:
        //  panel to put this button into 
        //  group to associate with 
        //  text to appear next to button
        //  true means this button should be selected on startup
        addRadioButton(jpSouth, radioButtonGroup, "Red", false);
        addRadioButton(jpSouth, radioButtonGroup, "Blue", false);
        addRadioButton(jpSouth, radioButtonGroup, "Green", true);
        
        
        testFrame.add(jpNorth, BorderLayout.PAGE_START);
        testFrame.add(jpCenter, BorderLayout.CENTER);
        testFrame.add(jpSouth, BorderLayout.PAGE_END);
    }
    
    
    public void addRadioButton(JPanel panel, ButtonGroup group, String buttonText, boolean selected)
    {
 
        JRadioButton radioButton = new JRadioButton(buttonText);
        radioButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e){
                radioButtonChanged((JRadioButton)e.getSource());
            }
        });

        //Set this button to the selected button if passed in through 
        //parameter.  Note that last button set to true will be the 
        //Selected one if more than one.  Also note that NONE will be 
        //selected is at least one is not set to true.
        radioButton.setSelected(selected);
        group.add(radioButton);
        panel.add(radioButton);
        
        //If this button is selected update the center panel to initialize
        //to the appropriate value by running the method as if this radio
        //button had actually been clicked.
        if (selected) 
        {
            radioButtonChanged(radioButton);
        }
        
    }
    
    public static void main(String[] args)
    {
        new RadioButtonTester();
    }
}
