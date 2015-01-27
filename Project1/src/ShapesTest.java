import java.io.*;
import java.util.*;
import javax.swing.JFrame;

public class ShapesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int tileChoice=2;
		int tileSize=50;
		Scanner input;
		try{
			input=new Scanner(new File("truchet.txt"));
			tileChoice=input.nextInt();
			tileSize=input.nextInt();
			System.out.println(tileChoice);
			System.out.println(tileSize);
			input.close();
		}
		catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
		
		Shapes panel = new Shapes(tileChoice, tileSize);
		
		JFrame application = new JFrame("Shapes");
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(300,300);
		application.setVisible(true);
	}

}