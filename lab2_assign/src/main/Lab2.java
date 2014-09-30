package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** This lab is intended to test the student's ability to parse a file
 * and meaningfully interpret a pre-formatted file representing a grouping
 * of student names and their corresponding grades. Each individual supplied
 * in the file should be printed out according to the {@link 
 * Lab2#testGrades(Grades) testGrades} signature.
 * */
public class Lab2 {

	/** Entry point for the program.
	 * @param args
	 */
	public static void main(String[] args) {
		// store file name in a String.
		String targetFile = "data.txt";
		// load file, capture exception if occurred and exit program.
		Scanner in = null;
		try {
		    in = new Scanner(new File(targetFile));
		} catch (FileNotFoundException exception) {
		    System.err.println("failed to open " + targetFile);
		    System.exit(1);
		}
		// If file loaded successfully, instantiates empty lists
		// for loading individual grades and Grades objects to represent
		// each student.
		List<Integer> studentsGrades = new ArrayList<Integer>();
		List<Grades> allStudents = new ArrayList<Grades>();
		// If the loaded file has another value, then:
		while (in.hasNext()) {
			// Load the first value as a string.
		    String studentsName = in.next();
		    // For every next value that is an integer, load them
		    // into a list of Integers.
		    while (in.hasNextInt()) {
		        int grade = in.nextInt();
		        studentsGrades.add(grade);
		    }
		    // Create a Grades object for the corresponding student name
		    // and the list of integers that represent their grades.
		    Grades thisStudent = 
		    		new Grades(studentsName, 
		    				new ArrayList<Integer>(studentsGrades));
		    // Add that Grades object to the list of Grades objects
		    // representing each individual student.
		    allStudents.add(thisStudent);
		    // Clear the list for next iteration.
		    studentsGrades.clear();
		}
		// Set starting index to 0.
		int index = 0;
		// Iterate over list of Grades objects and call testGrades static
		// method within main to print out each Grades objects values.
		while(index < allStudents.size()){
			Lab2.testGrades(allStudents.get(index));
			index++;
		}
	} // End main method for Lab2.
	
	/** Supplied test method by instructor. This method signature must be
	 * adhered to, which defined the creation of the {@link Grades} object.
	 * */
	public static void testGrades(Grades grades) {
	    System.out.println(grades.toString()); 
	    System.out.printf("\tName:    %s\n", grades.getName());
	    System.out.printf("\tLength:  %d\n", grades.length());
	    System.out.printf("\tAverage: %.2f\n", grades.average());
	    System.out.printf("\tMedian:  %.1f\n", grades.median());
	    System.out.printf("\tMaximum: %d\n", grades.maximum());
	    System.out.printf("\tMininum: %d\n", grades.minimum());
	} // End method definition for testGrades.
} // End class definition for Lab2.
