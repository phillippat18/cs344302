package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** Takes in a defined file path or file object, parses it and reports
 * on the contents of the file using default whitespace delimiter. 
 * <pre>
 * Project: Lab 1
 * Due Date: 09/09/2014
 * Class: CS 3443.002
 * Professor: Zhang, W.
 * </pre>
 * @author Haley, K.
 * */
public class ParseFileFindDoubles {

	// Container for java.io.File object once initialized.
	private File file;
	
	// Initialized primitive double to represent the total value of doubles
	// within the supplied file.
	private double totalDoubleValue = 0.0;

	// Represents the total count of all doubles within the supplied file.
	private int doubleCount = 0;
	
	// Represents the total count of all non-doubles within the supplied file.
	private int nonDoubleCount = 0;
	
	/** Takes a {@link java.io.File File} object, checks for its existence
	 * and then parses the file if it exists.
	 * @param file A {@link java.io.File File} object representing the 
	 * target file.
	 * @author Haley, K.
	 * */
	public ParseFileFindDoubles(File file) {
		// Check for existence of file.
		if(file.exists()){
			// Use the toString() method of the java.io.File object to return
			// the file name of the file since it exists. Use this file name 
			// to create a new java.io.File object to avoid reference clashes.
			this.file = new File(file.toString());
			// Parse the file by calling a private class method.
			this.findDoubles();
		} else {
			// If the file does not exist, notify the user.
			System.out.println("Supplied file does not exist.");
			return;
		}
	} // End constructor using java.io.File overload.
	
	/** Takes a {@link java.lang.String String} object, checks for 
	 * the existence of a file by the given name, and then parses the file if
	 * it exists.
	 * @param fileName A {@link java.lang.String String} object representing
	 * @author Haley, K.
	 * the target file name.
	 * */
	public ParseFileFindDoubles(String fileName){
		// Load a java.io.File object using the supplied name.
		this.file = new File(fileName);
		// Check for that file's existence.
		if(this.file.exists()){
			// If exists, call private class member findDoubles() 
			// to parse file.
			this.findDoubles();
		} else {
			// If not exist, inform the user.
			System.out.println("Supplied file does not exist.");
			return;
		}
	} // End constructor using String overload.
	
	/** Loads the existing file into a {@link java.util.Scanner Scanner} 
	 * object and then iterates over the file token by token, using the 
	 * default whitespace delimiter ({@link java.util.Scanner#delimiter()}),
	 * counting doubles and non-doubles, while summing existing doubles.
	 * */
	private void findDoubles(){
		try {
			// Load the file into a java.util.Scanner object to prepare 
			// for parsing.
			Scanner scanner = new Scanner(this.file);
			// Iterate over each token in the file using java.util.Scanner's
			// default whitespace delimiter. Use the hasNext() method to 
			// determine if the file contents additional tokens.
			while(scanner.hasNext()){
				// If the next value is a double, increment total double count
				// and add new double value to existing total double value
				// in the totalDoubleValue class field.
				if(scanner.hasNextDouble()){
					this.doubleCount++;
					this.totalDoubleValue += scanner.nextDouble();
				} else { // If not a double
					// Increment total double value.
					this.nonDoubleCount++;
					// Move to next token.
					scanner.next();
				}
			}
			// Once the action is complete, close the 
			// java.util.Scanner object.
			scanner.close();
		} catch (FileNotFoundException e) { // If file not found exception
			// Give the user an informative message.
			System.out.println("The required file was not found.");
			// Print the stack trace for debugging.
			e.printStackTrace();
		} catch (Exception ex){
			// Give the user an informative message.
			System.out.println("A generic exception occurred while " +
					"attempting to load file the file for parsing.");
			// Print the stack trace for debugging.
			ex.printStackTrace();
		}
	} // End method definition for findDoubles.
	
	/** Returns the contents of the file with respect to doubles by returning 
	 * a {@link java.lang.String String} with a single whitespace between three
	 * numbers, where the first represents the total number of doubles, the 
	 * second representing the total number of non-doubles and the third 
	 * representing the total value of all doubles in the target file.
	 * @return Returns a whitespace delimited string with the following values:
	 * <ol>
	 * 	<li><strong>First Number</strong>: Total Number of Doubles.</li>
	 * 	<li><strong>Second Number</strong>: Total Number of Non-Doubles.</li>
	 * 	<li><strong>Third Number</strong>: Total Value of All Doubles in 
	 * the Target File.</li>
	 * </ol>
	 * */
	public String getFileContents(){
		return this.doubleCount 
				+ " " + this.nonDoubleCount 
				+ " " + this.totalDoubleValue;
	} // End method definition for getFileContents.
} // End class definition for ParseFileFindDoubles.