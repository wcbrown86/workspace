import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ComboBoxTester 
{
    
    private JFrame testFrame;
    private JPanel jpCenter;
    private JComboBox jcbColor;
    private JLabel jlComponentValue;
    
    public ComboBoxTester()
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
    
    public void comboBoxChanged()
    {
        String color = jcbColor.getSelectedItem().toString();
        jlComponentValue.setText("ComboBox Value: "+color);
        
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
        
        //Make center panel big for color changing
        jpCenter.setPreferredSize(new Dimension(300,300));
        
        jcbColor = new JComboBox();
        jcbColor.addItem("Red");
        jcbColor.addItem("Blue");
        jcbColor.addItem("Green");
        jcbColor.setSelectedIndex(0);  //Default anyway
        
        //Set center color on startup according to default selection
        comboBoxChanged();
        
        jcbColor.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e){
                comboBoxChanged();
            }
        });
        jpSouth.add(jcbColor);
        
        testFrame.add(jpNorth, BorderLayout.PAGE_START);
        testFrame.add(jpCenter, BorderLayout.CENTER);
        testFrame.add(jpSouth, BorderLayout.PAGE_END);
    }
    
    public static void main(String[] args)
    {
        new ComboBoxTester();
    }
}
