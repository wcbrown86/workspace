import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class LabelChanger 
{
    
    private JFrame labelChangerFrame;
    private JLabel jlChangeMe;
    private JTextField jtfNewText;
    
    LabelChanger()
    {
        
        labelChangerFrame = new JFrame();
        labelChangerFrame.setLocation(100,100);
        labelChangerFrame.setSize(400,400);
        labelChangerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        labelChangerFrame.setTitle("My Simple Label Changer");

        initializeComponents();
        
        labelChangerFrame.pack();
        labelChangerFrame.setVisible(true);
    }
    public void updateClicked()
    {
        String t = jtfNewText.getText();
        if (!t.trim().equals(""))
        {
            jlChangeMe.setText(t);
        }
        
    }
    public void initializeComponents()
    {
        JButton jbUpdate = new JButton("Udate");
        jtfNewText = new JTextField(10);
        jlChangeMe = new JLabel("Change me");
        
        JPanel jpNorth = new JPanel();
        jpNorth.add(jlChangeMe);
        labelChangerFrame.add(jpNorth, BorderLayout.PAGE_START);
        
        JPanel jpCenter = new JPanel();
        jpCenter.add(jtfNewText);
        labelChangerFrame.add(jpCenter, BorderLayout.CENTER);
        
        JPanel jpSouth = new JPanel();
        jpSouth.add(jbUpdate);
        labelChangerFrame.add(jpSouth, BorderLayout.PAGE_END);
        
        jbUpdate.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e){
                updateClicked();
            }
        });
        
    }
    
    public static void main(String[] args)
    {
        new LabelChanger();
    }
}
