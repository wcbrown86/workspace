import javax.swing.JOptionPane;

/**
 * JOptionTester.java
 *
 * Put description here.
 *
 * @author Joel Swanson
 * @version 0.1
 */

public class JOptionTester {
    
    public JOptionTester()
    {
        String s = JOptionPane.showInputDialog("Enter your name.");
        JOptionPane.showMessageDialog(null,"Hello "+ s);
        JOptionPane.showMessageDialog(null, "Warning Message.", "Title Text Warning", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null, "Question Message.", "Title Text Question", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Error Message.", "Title Text Error", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null, "Plain Message with title.", "Just Title Text", JOptionPane.PLAIN_MESSAGE); 
        //JOptionPane.showMessageDialog(null, "Message", "Title Text", JOptionPane.INFORMATION_MESSAGE, icon);

        int n;
        boolean done = false;
        while (!done)
        {
            n = JOptionPane.showOptionDialog(null, "Are you tired of looping?", "A Silly Question", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
            if (n==JOptionPane.YES_OPTION)
            {
                JOptionPane.showMessageDialog(null, "Ok.  This is the last time.");
                done=true;
            }
            else if (n==JOptionPane.NO_OPTION)
            {
                JOptionPane.showMessageDialog(null, "Joy!  I LOVE looping!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Well which is it?");
            }
        }

        n = JOptionPane.showOptionDialog(null, "Are you happy?", "A Silly Question", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
        if (n==JOptionPane.YES_OPTION)
        {
            JOptionPane.showMessageDialog(null, "I'm glad you are happy.");
        }
        else if (n==JOptionPane.NO_OPTION)
        {
            JOptionPane.showMessageDialog(null, "I'm sorry you are NOT happy.");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Well which is it?");
        }
        
        n = JOptionPane.showOptionDialog(null, "Are you happy?", "A Silly Question", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
        if (n==JOptionPane.YES_OPTION)
        {
            JOptionPane.showMessageDialog(null, "I'm glad you are happy.");
        }
        else if (n==JOptionPane.NO_OPTION)
        {
            JOptionPane.showMessageDialog(null, "I'm sorry you are NOT happy.");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Well which is it?");
        }
        
        n = JOptionPane.showOptionDialog(null, "Are you happy? (No Cancel)", "A Silly Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
        Object[] options = {"Red", "Blue", "Green"}; 
        n = JOptionPane.showOptionDialog(null, "What is your favorite color?", "A Silly Question", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
        
        JOptionPane.showMessageDialog(null,"You chose "+n+". I think that was the number for orange.");
        
        
    }
    
    public static void main(String[] args)
    {
        new JOptionTester();
    }
}
