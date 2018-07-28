import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Morse {

	public static void main(String[] args) throws FileNotFoundException {
		
		Code code = new Code();
		
		Scanner file = new Scanner(new File("Morse.txt"));
		
		while(file.hasNextLine()){
			
			code.add(file.nextLine());
		}
		
		
		int cont;
		do{
			
			String str;
			String translation;
			
			str = JOptionPane.showInputDialog("Please enter a word or phrase to tranlate: ");
			translation = code.translate(str);
			
			JOptionPane.showMessageDialog(null, "Phrase entered: " + str + "\nIn morse code: " + translation);
			
			cont = JOptionPane.showConfirmDialog(null, "Would you like to translate another word?", "Confirmation", JOptionPane.YES_NO_OPTION);
			
		}while(cont != JOptionPane.NO_OPTION);

	}

}
