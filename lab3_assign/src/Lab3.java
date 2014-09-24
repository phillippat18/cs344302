import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/** Lab 3 for CS 3443.02 Fall 2014
 * Professor Zhang
 * */
public class Lab3 {

	/** Entry point for program to test Lab3.
	 * @param args
	 */
	public static void main(String[] args) {
		// Initialize Scanner to null outside of try/catch
		// to make it accessible once passed.
		Scanner in = null;
		try {
		    in = new Scanner(new File("dates.txt"));
		} catch (FileNotFoundException exception) {
		    System.err.println("failed to open dates.txt");
		    System.exit(1);
		}
		// Set an empty Date object for entry.
		Date previousDate = null;
		// While there is another line.
		while (in.hasNextLine()) {
			// For each line, set a temp String for use.
		    String line = in.nextLine();
		    // Create a date object.
		    Date date = new Date(line);
		    // Print out the date object using the toString method.
		    System.out.println(date);
		    // If previousDate is null, this is the first pass through
		    // the while loop, set the value.
		    if(previousDate == null){
		    	previousDate = date;
		    } else {
		    	// If previousDate is not null, verify that both dates are
		    	// valid. Once valid, verify that the 'previousDate' came
		    	// before the current 'date'. If so, create a new DateRange
		    	// object and load it with the 'previousDate' and 'date' 
		    	// in that order.
		    	if(date.isValidDate() && previousDate.isValidDate()){
		    		if(previousDate.compareTo(date) == -1){
		    			DateRange dateRange = 
		    					new DateRange(previousDate, date);
		    			System.out.println(dateRange);
		    		}
		    	}
		    	// Continuously set the previousDate to the current date
		    	// at the end of each pass through the loop.
		    	previousDate = date;
		    }
		    // need more code for DateRange objects
		} 
	} // End of main method and program execution.
} // End of class definition of Lab3.
