import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Lab3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner in = null;
		try {
		    in = new Scanner(new File("dates.txt"));
		} catch (FileNotFoundException exception) {
		    System.err.println("failed to open dates.txt");
		    System.exit(1);
		}
		while (in.hasNextLine()) {
		    String line = in.nextLine();
		    Date date = new Date(line);
		    System.out.println(date);
		    // need more code for DateRange objects
		} 
	} // End of main method and program execution.
} // End of class definition of Lab3.
