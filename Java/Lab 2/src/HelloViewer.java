/** File HelloViewer.java */
import javax.swing.JFrame;
 
public class HelloViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new HelloFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("HelloViewer");
      frame.setVisible(true);
   }
}
