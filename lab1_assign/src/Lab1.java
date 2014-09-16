
package src;

import java.io.File;

/** Starting point for Lab 1. 
 * <pre>
 * Project: Lab 1
 * Due Date: 09/09/2014
 * Class: CS 3443.002
 * Professor: Zhang, W.
 * </pre>
 * @author kylehaley
 */
public class Lab1 {

	/** Entry point for the program.*/
	public static void main(String[] args) {
		// store file name in a String.
		String targetFile = "data.txt";
		// load file.
		File file1 = new File(targetFile);
		
		// Create ParseFileFindDoubles object using the constructor
		// which uses the java.io.File object.
		ParseFileFindDoubles parseFileFindDoubles1 = 
				new ParseFileFindDoubles(file1);
		// Get the string representing the number of doubles, non-doubles
		// and total value of doubles in the supplied file.
		String temp1 = parseFileFindDoubles1.getFileContents();
		
		// Print out returned contents to console.
		System.out.println(temp1);
		
	} // End main method for start of program.
} // End class definition for Lab1.
