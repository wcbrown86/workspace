/** File HelloViewer.java */
import javax.swing.JFrame;
 
public class TutorViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new TutorFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("HelloViewer");
      frame.setVisible(true);
   }
}