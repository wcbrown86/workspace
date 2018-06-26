import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class DrawExample 
{
    
    private JFrame testFrame;
    private DrawPanel jpCenter;
    private JSlider jsDiameter;
    private JLabel jlComponentValue;
    
    public DrawExample()
    {
        testFrame = new JFrame();
        testFrame.setLocation(100,100);
        testFrame.setSize(400,400);
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testFrame.setTitle("Component Tester");

        initializeComponents();
        
        testFrame.pack();
        testFrame.setVisible(true);
        testFrame.repaint();
    }
    
    public void sliderChanged()
    {
        jlComponentValue.setText("Slider value: "+jsDiameter.getValue());
        jpCenter.setDiameter(jsDiameter.getValue());
        testFrame.repaint();
    }

    public void initializeComponents()
    {
        JPanel jpNorth = new JPanel();
        
        //MUST extend panel with our own if we want to draw on it.
        jpCenter = new DrawPanel(150,150,20);
        
        jlComponentValue = new JLabel("");
        jpNorth.add(jlComponentValue);
        
        //Make the center panel big so we can draw on it.
        jpCenter.setPreferredSize(new Dimension(300,300));
        
        jsDiameter = new JSlider();
        jsDiameter.setMaximum(255);
        jsDiameter.setValue(200);
        jsDiameter.setPaintTicks(true);
        jsDiameter.setPaintLabels(true);
        jsDiameter.setMinorTickSpacing(5);
        jsDiameter.setMajorTickSpacing(50);
        
        jsDiameter.addChangeListener( new ChangeListener() {
            public void stateChanged(ChangeEvent e){
                sliderChanged();
            }
        });
        
                
        
        JButton jbUp = new JButton("Up");
        jbUp.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                jpCenter.moveCircle(0, -5);
                testFrame.repaint();
            }
        });
        
        JButton jbDown = new JButton("Down");
        jbDown.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                jpCenter.moveCircle(0, 5);
                testFrame.repaint();
            }
        });
        
        JButton jbLeft = new JButton("Left");
        jbLeft.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                jpCenter.moveCircle(-5, 0);
                testFrame.repaint();
            }
        });
        
        JButton jbRight = new JButton("Right");
        jbRight.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                jpCenter.moveCircle(5, 0);
                testFrame.repaint();
            }
        });


        //Create the south panel and set it to a vertical BoxLayout
        JPanel jpSouth = new JPanel();
        jpSouth.setLayout(new BoxLayout(jpSouth,BoxLayout.Y_AXIS));

        //Put the buttons in a panel
        JPanel jpButton = new JPanel();
        jpButton.add(jbUp);
        jpButton.add(jbDown);
        jpButton.add(jbLeft);
        jpButton.add(jbRight);
        
        //Add the slider to the south panel making it the top
        //item in the BoxLayout
        jpSouth.add(jsDiameter);
        
        //Add the button panel to the south panel making it the 
        //bottom item in the BoxLayout
        jpSouth.add(jpButton);
        
        
        //Update slider this first time
        sliderChanged();
        testFrame.add(jpNorth, BorderLayout.PAGE_START);
        testFrame.add(jpCenter, BorderLayout.CENTER);
        testFrame.add(jpSouth, BorderLayout.PAGE_END);
    }
    
    public static void main(String[] args)
    {
        new DrawExample();
    }
}
