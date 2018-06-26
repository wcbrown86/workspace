
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloFrame extends JFrame
{   
   private String message;
   public static JLabel label;
   
   private static int FRAME_WIDTH = 300;
   private static int FRAME_HEIGHT = 300;
   private static int DEFAULT_SIZE = 20;
   public HelloFrame()
   {
	  
      message = "Hello, World!";
      label = new JLabel(message);
      label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
      add(label, BorderLayout.CENTER);
      
      setSize(FRAME_WIDTH, FRAME_HEIGHT);

      createSouthPanel();

   }

   private void createSouthPanel() {
	   
	   JRadioButton helloButton = new JRadioButton("Hello");
	   JRadioButton goodbyeButton = new JRadioButton("Goodbye");
	   JCheckBox cruelCheckBox = new JCheckBox("Cruel");
	   
	   ButtonGroup group = new ButtonGroup();
	   group.add(helloButton);
	   group.add(goodbyeButton);
	   
	   JPanel southPanel = new JPanel();
	   southPanel.add(helloButton);
	   southPanel.add(goodbyeButton);
	   southPanel.add(cruelCheckBox);
	   
	   add(southPanel, BorderLayout.SOUTH);
	   
	   helloButton.setSelected(true);
	   
	   class MessageListener implements ActionListener{
		   
		   public void actionPerformed(ActionEvent e){
			   
			   String message = "";
			   if(helloButton.isSelected())
				   message = "Hello";
			   else if(goodbyeButton.isSelected())
				   message = "Goodbye";
			   
			   if(cruelCheckBox.isSelected())
				   message += " cruel";
			   
			   message += ", World!";
			   label.setText(message);
		   }
	   }
	   
	   ActionListener messageListener = new MessageListener();
	   helloButton.addActionListener(messageListener);
	   goodbyeButton.addActionListener(messageListener);
	   cruelCheckBox.addActionListener(messageListener);
	   
   }
}