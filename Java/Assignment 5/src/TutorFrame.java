
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Stack;

public class TutorFrame extends JFrame
{   
   private String message;
   public static JLabel label;
   public String[] level = {"Easy", "Moderate", "Difficult"};
   public String[] option = {"Addition", "Subtraction", "Multiplication", "Division"};
   public int x = 0;
   public int y = 0;
   public int userA = 0;
   public Random rand = new Random();
   public Stack<AnswerHistory> historyStack = new Stack<AnswerHistory>();

   
   private static int FRAME_WIDTH = 500;
   private static int FRAME_HEIGHT = 300;
   private static int DEFAULT_SIZE = 30;
   
   public TutorFrame()
   {
	  
      message = "Choose Options";
      label = new JLabel(message);
      label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
      setLayout(new BorderLayout());
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      
      
      JTextArea answer = new JTextArea(2  , 20);
      JButton submit = new JButton("Submit");
      
      JPanel north = new JPanel();
      north.add(label);
      north.add(answer);
      north.add(submit);
      
      add(north, BorderLayout.NORTH);

      JComboBox<String> levels = new JComboBox<String>(level);
      JComboBox<String> options = new JComboBox<String>(option);
      JButton history = new JButton("History");
      
      JPanel south = new JPanel();
      south.add(levels);
      south.add(options);
      south.add(history);
      
      add(south, BorderLayout.SOUTH);
      
      
      

 
	   
	  class ComboListener implements ActionListener{
		   
		   public void actionPerformed(ActionEvent e){
			   if(levels.getSelectedItem().toString().equals("Easy")){
				   switch(options.getSelectedIndex()){
				   	case 0:
				   		x = rand.nextInt(49) + 1;
				   		y = rand.nextInt(49) + 1;
				   		label.setText(x + " + " + y + " =");
				   		break;
				   	case 1:
				   		x = rand.nextInt(49) + 1;
				   		y = rand.nextInt(49) + 1;
				   		
				   		if(x > y)
				   			label.setText(x + " - " + y + " =");
				   		else
				   			label.setText(y + " - " + y + " =");
				   		
				   		break;
				   	case 2:
				   		x = rand.nextInt(11) + 1;
				   		y = rand.nextInt(11) + 1;
				   		label.setText(x + " * " + y + " =");
				   		
				   		break;
				   	case 3:
				   		x = rand.nextInt(11) + 1;
				   		y = rand.nextInt(11) + 1;
				   		
				   		if(x > y)
				   			label.setText(x + " / " + y + " =");
				   		else
				   			label.setText(y + " / " + y + " =");
				   		
				   		break;
				   	default:
				   		break;
				   }
			   }
			   else if(levels.getSelectedItem().toString().equals("Moderate")){
				   switch(options.getSelectedIndex()){
				   	case 0:
				   		x = rand.nextInt(90) + 10;
				   		y = rand.nextInt(90) + 10;
				   		label.setText(x + " + " + y + " =");
				   		break;
				   	case 1:
				   		x = rand.nextInt(90) + 10;
				   		y = rand.nextInt(90) + 10;
				   		
				   		if(x > y)
				   			label.setText(x + " - " + y + " =");
				   		else
				   			label.setText(y + " - " + y + " =");
				   		
				   		break;
				   	case 2:
				   		x = rand.nextInt(40) + 10;
				   		y = rand.nextInt(40) + 10;
				   		label.setText(x + " * " + y + " =");
				   		
				   		break;
				   	case 3:
				   		x = rand.nextInt(40) + 10;
				   		y = rand.nextInt(40) + 10;
				   		
				   		if(x > y)
				   			label.setText(x + " / " + y + " =");
				   		else
				   			label.setText(y + " / " + y + " =");
				   		
				   		break;
				   	default:
				   		break;
				   }
			   }
			   else if(levels.getSelectedItem().toString().equals("Difficult")){
				   switch(options.getSelectedIndex()){
				   	case 0:
				   		x = rand.nextInt(900) + 100;
				   		y = rand.nextInt(900) + 100;
				   		label.setText(x + " + " + y + " =");
				   		break;
				   	case 1:
				   		x = rand.nextInt(900) + 100;
				   		y = rand.nextInt(900) + 100;
				   		
				   		if(x > y)
				   			label.setText(x + " - " + y + " =");
				   		else
				   			label.setText(y + " - " + y + " =");
				   		
				   		break;
				   	case 2:
				   		x = rand.nextInt(990) + 10;
				   		y = rand.nextInt(990) + 10;
				   		label.setText(x + " * " + y + " =");
				   		
				   		break;
				   	case 3:
				   		x = rand.nextInt(990) + 10;
				   		y = rand.nextInt(990) + 10;
				   		
				   		if(x > y)
				   			label.setText(x + " / " + y + " =");
				   		else
				   			label.setText(y + " / " + y + " =");
				   		
				   		break;
				   	default:
				   		break;
				   }
			   }
		   }
	   }
	   
	  ActionListener comboListener = new ComboListener();
      submit.addActionListener(comboListener);
      levels.addActionListener(comboListener);
      options.addActionListener(comboListener);
      history.addActionListener(comboListener);
      
      class ButtonListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			String s = "";
			if(options.getSelectedIndex() == 0){
				if((x+y) == Integer.parseInt(answer.getText().trim())){
					s = "Correct!!";
					historyStack.push(new AnswerHistory(x, y, options.getSelectedIndex(), Integer.parseInt(answer.getText().trim()), true));
				}
				else{
					s = "Incorrect!!";
					historyStack.push(new AnswerHistory(x, y, options.getSelectedIndex(), Integer.parseInt(answer.getText().trim()), false));
				}
			}
			else if(options.getSelectedIndex() == 1){
				if(((x-y) == Integer.parseInt(answer.getText().trim())) || ((y-x) == Integer.parseInt(answer.getText().trim()))){
					s = "Correct!!";
					historyStack.push(new AnswerHistory(x, y, options.getSelectedIndex(), Integer.parseInt(answer.getText().trim()), true));
				}
				else{
					s = "Incorrect!!";
					historyStack.push(new AnswerHistory(x, y, options.getSelectedIndex(), Integer.parseInt(answer.getText().trim()), false));
				}
			}
			else if(options.getSelectedIndex() == 2){
				if((x*y) == Integer.parseInt(answer.getText().trim())){
					s = "Correct!!";
					historyStack.push(new AnswerHistory(x, y, options.getSelectedIndex(), Integer.parseInt(answer.getText().trim()), true));
				}
				else{
					s = "Incorrect!!";
					historyStack.push(new AnswerHistory(x, y, options.getSelectedIndex(), Integer.parseInt(answer.getText().trim()), false));
				}
			}
			else if(options.getSelectedIndex() == 3){
				if(((x/y) == Integer.parseInt(answer.getText().trim())) || ((y/x) == Integer.parseInt(answer.getText().trim()))){
					s = "Correct!!";
					historyStack.push(new AnswerHistory(x, y, options.getSelectedIndex(), Integer.parseInt(answer.getText().trim()), true));
				}
				else{
					s = "Incorrect!!";
					historyStack.push(new AnswerHistory(x, y, options.getSelectedIndex(), Integer.parseInt(answer.getText().trim()), false));
				}
			}
			
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			JOptionPane.showMessageDialog(frame, s, "Solution", JOptionPane.PLAIN_MESSAGE);
		}
		
		
    	  
      }
      ActionListener buttonListener = new ButtonListener();
      submit.addActionListener(buttonListener);
      
      class HistoryButton implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			JFrame historyFrame = new JFrame("History");
			historyFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			historyFrame.setSize(300,300);
			
			JTextArea historyList = new JTextArea(200,200);
			
			historyFrame.add(historyList,BorderLayout.CENTER);
			String list = "";
			while(!historyStack.empty()){
				list += historyStack.pop().toString() + "\n";
			}
			
			historyList.setText(list);
			historyFrame.setVisible(true);
		}
    	  
      }
      
      ActionListener historyButton = new HistoryButton();
      history.addActionListener(historyButton);
   }  
   
}