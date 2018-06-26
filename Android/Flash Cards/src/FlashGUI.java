import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FlashGUI
{
	private JFrame frame;
	private JPanel head;
	private JPanel center;
	private JPanel footer;
	private JButton question;
	private JButton answer;
	private JButton next;
	private JButton random;
	private JTextArea label;
	private JLabel currentLabel;
	private JLabel totalLabel;
	private JLabel counterLabel;
	private JScrollPane scroll;
	private Random rand;
	private int current;
	private ArrayList<FlashCard> cards;
	private int [] viewed;
	
	public static void main(String[] args)
	{
		Reader reader = new Reader(args[0]);
		new FlashGUI(reader.readLines());
	}
	
	public FlashGUI(ArrayList<FlashCard> flash)
	{
		current = 0;
		cards = flash;
		frame = new JFrame();
		frame.setLocation(600, 300);
		frame.setSize(1000,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Flash Cards");
		
		initializeComponents();
		
		frame.pack();
		frame.setVisible(true);
		rand = new Random();
	}

	private void initializeComponents() 
	{
		head = new JPanel();
		center = new JPanel();
		center.setPreferredSize(new Dimension(500,200));
		footer = new JPanel();
		label = new JTextArea(cards.get(current).getQuestion(),10,30);
		label.setLineWrap(true);
		label.setWrapStyleWord(true);
		label.setEditable(false);
		label.setMargin(new Insets(2,2,2,2));
		label.setMaximumSize(new Dimension(200,200));
		label.setMinimumSize(new Dimension(200,200));
		scroll = new JScrollPane (label);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		currentLabel = new JLabel("" + current);
		counterLabel = new JLabel("");
		totalLabel = new JLabel("" + cards.size());
		head.add(currentLabel);
		head.add(counterLabel);
		head.add(totalLabel);
		center.add(scroll);
		question = new JButton("Question");
		answer = new JButton("Answer");
		next = new JButton("Next");
		random = new JButton("Random");
		footer.add(question);
		footer.add(answer);
		footer.add(next);
		footer.add(random);
		frame.add(head, BorderLayout.NORTH);
		frame.add(center, BorderLayout.CENTER);
		frame.add(footer, BorderLayout.SOUTH);
		
		
		question.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
				if(current < cards.size())
				{
					label.setText(showQuestion(current));
				}
				else
				{
					current = 0;
					label.setText(showQuestion(current));
				}
			}
		});
		
		answer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				if(current < cards.size())
				{
					label.setText(showAnswer(current));
				}
				else
				{
					current = 0;
					label.setText(showAnswer(current));
				}
			}
		});
		
		next.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				if(current < cards.size())
				{
					current++;
				}
				else 
				{
					current = 0;
				}
				label.setText(getNext(current));
				currentLabel.setText("" + current);
			}
		});
		
		random.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				current = rand.nextInt(cards.size());
				label.setText(getRandom(current));
				currentLabel.setText("" + current);
			}
		});
	}
	

	private String showQuestion(int current) 
	{
			return cards.get(current).getQuestion();
	}
	
	private String showAnswer(int current) 
	{
		return cards.get(current).getAnswer();
	}
	
	private String getRandom(int current) 
	{
		if(current < cards.size())
		{
			return cards.get(current).getQuestion();
		}
		else
		{
			for(; current < cards.size();)
			{
				current = rand.nextInt(cards.size());
			}
			return cards.get(current).getQuestion();
		}
	}
	
	private String getNext(int current) 
	{
		if(current < cards.size())
		{
			return cards.get(current).getQuestion();
		}
		else
		{
			current = 0;
			return cards.get(current).getQuestion();
		}
	}
}