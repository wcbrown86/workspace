import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class SpinnerTester 
{
    
    private JFrame testFrame;
    private JPanel jpCenter;
    private JSpinner jsColorSpinner;
    private SpinnerNumberModel spinnerNumberModel;
    private JLabel jlcomponentValue;
    
    public SpinnerTester()
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
        //Two ways of getting the value i and j below
        
        //Using the spinner 
        String s = jsColorSpinner.getValue().toString();
        int i = Integer.parseInt(s);        
        
        //Using the model
        int j = spinnerNumberModel.getNumber().intValue();

        jlcomponentValue.setText("Spinner value: "+i);
        Color bg = new Color(j,0,0);
        jpCenter.setBackground(bg);
    }

    public void initializeComponents()
    {
        JPanel jpNorth = new JPanel();
        jpCenter = new JPanel();
        JPanel jpSouth = new JPanel();

        jlcomponentValue = new JLabel("");
        jpNorth.add(jlcomponentValue);
        
        jpCenter.setPreferredSize(new Dimension(300,300));
        
        jsColorSpinner = new JSpinner();
        //                                    (value, min, max, step);
        spinnerNumberModel = new SpinnerNumberModel(50, 0, 250, 1);
        jsColorSpinner.setModel(spinnerNumberModel);
        
        jsColorSpinner.addChangeListener( new ChangeListener() {
            public void stateChanged(ChangeEvent e){
                sliderChanged();
            }
        });
        jpSouth.add(jsColorSpinner);
        
        //Update center panel color using the sliders value as if
        //the slider had been changed.
        sliderChanged();
        
        testFrame.add(jpNorth, BorderLayout.PAGE_START);
        testFrame.add(jpCenter, BorderLayout.CENTER);
        testFrame.add(jpSouth, BorderLayout.PAGE_END);
    }
    
    public static void main(String[] args)
    {
        new SpinnerTester();
    }
}
