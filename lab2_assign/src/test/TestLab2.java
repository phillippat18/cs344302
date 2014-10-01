package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import main.Grades;
import main.Lab2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/** Implements methods to test the static method testGrades in Lab2 class.
 * */
public class TestLab2 {
	
	/** Create ByteArrayOutputStream's to capture content
	 * from System.out.print and its variations.
	 * */
	private final ByteArrayOutputStream outContent = 
			new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = 
			new ByteArrayOutputStream();
	
	/** Redirect the standard out and standard error to their respective
	 *  ByteArrayOutputStream so that it can be captured and compared 
	 *  before each test.
	 * */
	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	/** Reset standard out and standard error back to normal after each test
	 * runs.
	 * */
	@After
	public void tearDown() throws Exception {
		System.setOut(null);
	    System.setErr(null);
	}

	/** Test the {@link main.Lab2#testGrades(Grades) testGrades(Grades)}
	 * method in the Lab2 class with an odd number of valid grades and 
	 * a valid name.
	 * */
	@Test
	public void test_TestGradesMethodLab2_Valid_GradesAndName_Odd() {
		String tempName = "Valid Grades";
		ArrayList<Integer> validGrades = new ArrayList<Integer>();
		validGrades.add(80);
		validGrades.add(90);
		validGrades.add(100);
		Grades grades = new Grades(tempName, validGrades);
		Lab2.testGrades(grades);
		String stringValidation = "Valid Grades [80, 90, 100]\n";
		stringValidation += String.format("\tName:    %s\n", tempName);
		stringValidation += String.format("\tLength:  %d\n", 3);
		stringValidation += String.format("\tAverage: %.2f\n", 90.00);
		stringValidation += String.format("\tMedian:  %.1f\n", 90.0);
		stringValidation += String.format("\tMaximum: %d\n", 100);
		stringValidation += String.format("\tMininum: %d\n", 80);
		assertEquals("Output stream did not match test case.", 
				stringValidation, outContent.toString());
		assertEquals("Error stream did not match test case.", 
				"", errContent.toString());
	}
	
	/** Test the {@link main.Lab2#testGrades(Grades) testGrades(Grades)}
	 * method in the Lab2 class with an even number of valid grades and 
	 * a valid name.
	 * */
	@Test
	public void test_TestGradesMethodLab2_Valid_GradesAndName_Even() {
		String tempName = "Valid Grades";
		ArrayList<Integer> validGrades = new ArrayList<Integer>();
		validGrades.add(80);
		validGrades.add(90);
		validGrades.add(100);
		validGrades.add(100);
		Grades grades = new Grades(tempName, validGrades);
		Lab2.testGrades(grades);
		String stringValidation = "Valid Grades [80, 90, 100, 100]\n";
		stringValidation += String.format("\tName:    %s\n", tempName);
		stringValidation += String.format("\tLength:  %d\n", 4);
		stringValidation += String.format("\tAverage: %.2f\n", 92.50);
		stringValidation += String.format("\tMedian:  %.1f\n", 95.0);
		stringValidation += String.format("\tMaximum: %d\n", 100);
		stringValidation += String.format("\tMininum: %d\n", 80);
		assertEquals("Output stream did not match test case.", 
				stringValidation, outContent.toString());
		assertEquals("Error stream did not match test case.", 
				"", errContent.toString());
	}
	
	/** Test the {@link main.Lab2#testGrades(Grades) testGrades(Grades)}
	 * method in the Lab2 class with a null list of grades and a null name.
	 * */
	@Test
	public void test_TestGradesMethodLab2_Null_GradesAndName() {
		String tempName = null;
		ArrayList<Integer> nullGrades = null;
		Grades grades = new Grades(tempName, nullGrades);
		Lab2.testGrades(grades);
		String stringValidation = "No Name Provided [ no grades ]\n";
		stringValidation += String.format("\tName:    %s\n", 
				"No Name Provided");
		stringValidation += String.format("\tLength:  %d\n", 0);
		stringValidation += String.format("\tAverage: %.2f\n", 0.00);
		stringValidation += String.format("\tMedian:  %.1f\n", 0.0);
		stringValidation += String.format("\tMaximum: %d\n", 0);
		stringValidation += String.format("\tMininum: %d\n", 0);
		assertEquals("Output stream did not match test case.", 
				stringValidation, outContent.toString());
		assertEquals("Error stream did not match test case.", 
				"", errContent.toString());
	}

}
