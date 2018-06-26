import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class SliderTester 
{
    
    private JFrame testFrame;
    private JPanel jpCenter;
    private JSlider jsColorSlider;
    private JLabel jlComponentValue;
    
    public SliderTester()
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
    
    public void sliderChanged()
    {
        jlComponentValue.setText("Slider value: "+jsColorSlider.getValue());
        Color bg = new Color(jsColorSlider.getValue(),0,0);
        jpCenter.setBackground(bg);
    }

    public void initializeComponents()
    {
        JPanel jpNorth = new JPanel();
        jpCenter = new JPanel();
        JPanel jpSouth = new JPanel();

        jlComponentValue = new JLabel("");
        jpNorth.add(jlComponentValue);
        
        //Make the center panel big for color changing.
        jpCenter.setPreferredSize(new Dimension(300,300));
        
        jsColorSlider = new JSlider();
        jsColorSlider.setMaximum(255);
        jsColorSlider.setValue(200);
        jsColorSlider.setPaintTicks(true);
        jsColorSlider.setPaintLabels(true);
        jsColorSlider.setMinorTickSpacing(5);
        jsColorSlider.setMajorTickSpacing(50);
        
        //ChangeListener very similar to ActionListener.
        jsColorSlider.addChangeListener( new ChangeListener() {
            public void stateChanged(ChangeEvent e){
                sliderChanged();
            }
        });
        jpSouth.add(jsColorSlider);
        
        //Update center color on startup according to default slider position
        sliderChanged();
        
        testFrame.add(jpNorth, BorderLayout.PAGE_START);
        testFrame.add(jpCenter, BorderLayout.CENTER);
        testFrame.add(jpSouth, BorderLayout.PAGE_END);
    }
    
    public static void main(String[] args)
    {
        new SliderTester();
    }
}
