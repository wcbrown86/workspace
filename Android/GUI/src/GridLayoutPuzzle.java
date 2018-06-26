import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class GridLayoutPuzzle {
    
    private JFrame testFrame;
    private JTextArea jtaText;
    private boolean showTurns = false;
    private int turns = 0;
    private ArrayList<JButton> buttons;
    
    public GridLayoutPuzzle()
    {
    	buttons = new ArrayList<JButton>();
        testFrame = new JFrame();
        testFrame.setLocation(100,100);
        testFrame.setSize(400,400);
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testFrame.setTitle("Puzzle");

        initializeComponents();
        
        //testFrame.pack();  
        testFrame.setVisible(true);
        randomizer();
    }
    
    public void randomizer(){
        int blankSpace = 0;
        for (int i=0;i<10000;i++){
            int direction = (int)(Math.random()*4);
            int index = 0;
            switch (direction)
            {
            case 0:
                index=blankSpace-1;
                break;
            case 1:
                index=blankSpace+1;
                break;
            case 2:
                index=blankSpace-5;
                break;
            case 3:
                index=blankSpace+5;
                break;
            }
            
            if (index>=0 && index <=24) 
            {
                puzzleButtonClicked(buttons.get(index));
                blankSpace=index;
            }
            
        }
        turns = 0;
        showTurns = true;
    }
    
    public void puzzleButtonClicked(JButton jb)
    {
    	int index = buttons.indexOf(jb);
    	int row = index / 5;
    	int col = index % 5;
    	
    	//Check Above
    	if (row - 1 >= 0 && getButtonText(row - 1, col).equals(" ")) 
    	{
    	    swapText(row, col, row - 1, col);
    	    turns++;
    	}
    	//Check Below
    	else if (row + 1 < 5 && getButtonText(row + 1, col).equals(" "))
    	{
    	    swapText(row, col, row + 1, col);
    	    turns++;
    	}
    	//Check to left
        else if (col - 1 >= 0 && getButtonText(row, col - 1).equals(" "))
        {
            swapText(row, col, row, col - 1);
            turns++;
        }
    	//Check to right
        else if (col + 1 < 5 && getButtonText(row, col + 1).equals(" "))
        {
            swapText(row, col, row, col + 1);
            turns++;
        }
    	if (showTurns)
    	{
    	    testFrame.setTitle("Puzzle - Turns "+turns);
    	}
    	
    }
    
    
    public String getButtonText(int row, int col)
    {
        //int index = row * 5 + col;
        //JButtion b = buttons.get(index);
        //String s = b.getText();
        //return s;
        
        return buttons.get(row * 5 + col).getText();
    }

    public void swapText(int row1, int col1, int row2, int col2)
    {
        int index1 = row1 * 5 + col1;
        int index2 = row2 * 5 + col2;
    	String temp = buttons.get(index1).getText();
    	buttons.get(index1).setText(buttons.get(index2).getText());
    	buttons.get(index2).setText(temp);
    }
    
    public void initializeComponents()
    {
        JPanel jpCenter = new JPanel();
        jpCenter.setLayout(new GridLayout(5,5));
        
        for (int i=0;i<25;i++)
        {
            JButton jb = new JButton("<html><h1>"+i+"</h1></html>");
            buttons.add(jb);
            jb.addActionListener( new ActionListener() {
                //Notice that ALL buttons call puzzleButtonClicked 
            	public void actionPerformed(ActionEvent e){
            	    JButton jb = (JButton)e.getSource();
            		puzzleButtonClicked(jb);
            	}
            });
            if(i==0) jb.setText(" ");
            jb.setFocusable(false);
            jpCenter.add(jb);
        }
        
        testFrame.add(jpCenter, BorderLayout.CENTER);        
    }
    
    public static void main(String[] args)
    {
        new GridLayoutPuzzle();
    }


}
