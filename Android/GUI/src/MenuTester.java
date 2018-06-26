import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MenuTester implements ActionListener
{
    
    private JFrame testFrame;
    private JPanel jpCenter;
    private JLabel jlComponentValue;
    
    public MenuTester()
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
    
    public void menuSelected (String menuText)
    {
        jlComponentValue.setText("Menu selection is "+ menuText);
        
        if (menuText.toLowerCase().equals("red"))
        {
            jpCenter.setBackground(Color.RED);
        }
        else if (menuText.toLowerCase().equals("blue"))
        {
            jpCenter.setBackground(Color.BLUE);
        }
        else if (menuText.toLowerCase().equals("green"))
        {
            jpCenter.setBackground(Color.GREEN);            
        }
        else if (menuText.toLowerCase().equals("exit"))
        {
            int reallyExit = JOptionPane.showConfirmDialog(
                    testFrame, 
                    "Do you really want to exit?", 
                    "Exit",
                    JOptionPane.YES_NO_OPTION
            );
            
            if (reallyExit==JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
        }
        else if (menuText.toLowerCase().equals("add"))
        {
            JOptionPane.showMessageDialog(testFrame, "Sorry.  This option has not been implemented yet.");
        }
        else if (menuText.toLowerCase().equals("remove"))
        {
            JOptionPane.showMessageDialog(testFrame, "Sorry.  This option has not been implemented yet.");
        }
        else if (menuText.toLowerCase().equals("open"))
        {
            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(testFrame);
        }        
        else if (menuText.toLowerCase().equals("save"))
        {
            JFileChooser jfc = new JFileChooser();
            jfc.showSaveDialog(testFrame);
        }


    }
    
    //Implemented ActionListener therefore had to override static
    //method actionPerformed.
    public void actionPerformed(ActionEvent e)
    {
        JMenuItem menuItem = (JMenuItem) e.getSource();
        String menuText = menuItem.getText();
        menuSelected(menuText);
    }
    
    public void initializeComponents()
    {
        createMenu();
        
        JPanel jpNorth = new JPanel();
        jpCenter = new JPanel();
        JPanel jpSouth = new JPanel();

        jlComponentValue = new JLabel("");
        jpNorth.add(jlComponentValue);
        
        jpCenter.setPreferredSize(new Dimension(300,300));
        
        JLabel jlInstructions = new JLabel("Change the color using the menus above.");
        jpSouth.add(jlInstructions);
        
        //Initialize by calling menuSelected as if a menu item had actually been clicked.
        menuSelected("Green");
        
        testFrame.add(jpNorth, BorderLayout.PAGE_START);
        testFrame.add(jpCenter, BorderLayout.CENTER);
        testFrame.add(jpSouth, BorderLayout.PAGE_END);
    }
    
    public void createMenu()
    {
        JMenuBar menuBar;
        JMenu menu;
        JMenu menu2;
        JMenuItem menuItem;
        
        menuBar = new JMenuBar();
        menu = new JMenu("File"); 
        menu.setMnemonic(KeyEvent.VK_F);

        menuItem = new JMenuItem("Open");
        
        //Since this class implemented ActionListener AND
        //this class has an overridden actionPerformed, we
        //can add this class as the ActionListener and this
        //classes actionPerformed method will get called 
        //when this menu item is selected.
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Save");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menu.addSeparator();
        
        menuItem = new JMenuItem("Exit");
        menuItem.addActionListener(this);
        menuItem.setMnemonic(KeyEvent.VK_X);
        menu.add(menuItem);
        
        menuBar.add(menu);
        
        menu = new JMenu("Edit"); 
        menu.setMnemonic(KeyEvent.VK_D);

        menuItem = new JMenuItem("Add");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Remove");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menu.addSeparator();
        menu2 = new JMenu("Change Color");
        menu2.setMnemonic(KeyEvent.VK_C);
        
        menuItem = new JMenuItem("Red");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_R, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        menu2.add(menuItem);
        
        menuItem = new JMenuItem("Green");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_G, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        menu2.add(menuItem);
        
        menuItem = new JMenuItem("Blue");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_B, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        menu2.add(menuItem);
        
        menu.add(menu2);
        
        menuBar.add(menu);
        testFrame.setJMenuBar(menuBar);

    }
    
    public static void main(String[] args)
    {
        new MenuTester();
    }
}
