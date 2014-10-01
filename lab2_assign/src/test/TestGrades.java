package test;

import java.util.ArrayList;

import main.Grades;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGrades {
	
	// Testing Grades.median() method.

	/** This test covers the {@link main.Grades#median() median()} method
	 * when the supplied list of grades is null.
	 * */
	@Test
	public void test_Median_SecondParam_IsNull() {
		ArrayList<Integer> validGrades = null;
		Grades grades = new Grades("Null Grades", validGrades);
		assertTrue("Grades.median() did not return zero with a null list.", 
				grades.median() == 0.0);
	}
	
	/** This test covers the {@link main.Grades#median() median()} method
	 * when the supplied list of grades is valid.
	 * */
	@Test
	public void test_Median_ValidGrades(){
		ArrayList<Integer> validGrades = new ArrayList<Integer>();
		validGrades.add(80);
		validGrades.add(90);
		validGrades.add(100);
		Grades grades = new Grades("Valid Grades", validGrades);
		assertTrue("Valid grades were not evaluated properly with " +
				"Grades.median().",	grades.median() == 90.0);
	}
	
	/** This test covers the {@link main.Grades#median() median()} method
	 * when the supplied list of grades are all zero.
	 * */
	@Test
	public void test_Median_ZeroValueGrades(){
		ArrayList<Integer> validGrades = new ArrayList<Integer>();
		validGrades.add(0);
		validGrades.add(0);
		validGrades.add(0);
		Grades grades = new Grades("Zero ValueGrades", validGrades);
		assertTrue("Zero value grades were not evaluated properly with " +
				"Grades.median().",	grades.median() == 0.0);
	}
	
	/** This test covers the {@link main.Grades#median() median()} method
	 * when the supplied list of grades is an empty list.
	 * */
	@Test
	public void test_Median_EmptyGradeList(){
		ArrayList<Integer> invalidGrades = new ArrayList<Integer>();
		Grades grades = new Grades("No Grades", invalidGrades);
		assertTrue("Empty list was evaluated to something that was not zero " +
				"with Grades.median().", grades.median() == 0.0);
	}
	
	// Testing Grades.average() method.
	
	/** This test covers the {@link main.Grades#average() average()} method
	 * when the supplied list of grades is null.
	 * */
	@Test
	public void test_Average_SecondParam_IsNull() {
		ArrayList<Integer> validGrades = null;
		Grades grades = new Grades("Null Grades", validGrades);
		assertTrue("Grades.average() did not return zero with a null list.", 
				grades.average() == 0.0);
	}
	
	/** This test covers the {@link main.Grades#average() average()} method
	 * when the supplied list of grades is valid.
	 * */
	@Test
	public void test_Average_ValidGrades(){
		ArrayList<Integer> validGrades = new ArrayList<Integer>();
		validGrades.add(70);
		validGrades.add(80);
		validGrades.add(90);
		Grades grades = new Grades("Valid Grades", validGrades);
		assertTrue("Valid grades were not evaluated properly with " +
				"Grades.average().", grades.average() == 80.0);
	}
	
	/** This test covers the {@link main.Grades#average() average()} method
	 * when the supplied list of grades are all zero.
	 * */
	@Test
	public void test_Average_ZeroValueGrades(){
		ArrayList<Integer> validGrades = new ArrayList<Integer>();
		validGrades.add(0);
		validGrades.add(0);
		validGrades.add(0);
		Grades grades = new Grades("Zero ValueGrades", validGrades);
		assertTrue("Zero value grades were not evaluated properly with " +
				"Grades.average().", grades.average() == 0.0);
	}
	
	/** This test covers the {@link main.Grades#average() average()} method
	 * when the supplied list of grades is an empty list.
	 * */
	@Test
	public void test_Average_EmptyGradeList(){
		ArrayList<Integer> invalidGrades = new ArrayList<Integer>();
		Grades grades = new Grades("No Grades", invalidGrades);
		assertTrue("Empty list was evaluated to something that was not zero " +
				"with Grades.average().", grades.average() == 0.0);
	}
	
	// Testing Grades.minimum() method
	
	/** This test covers the {@link main.Grades#minimum() minimum()} method
	 * when the supplied list of grades is null.
	 * */
	@Test
	public void test_Minimum_SecondParam_IsNull() {
		ArrayList<Integer> validGrades = null;
		Grades grades = new Grades("Null Grades", validGrades);
		assertTrue("Grades.minimum() did not return zero with a null list.", 
				grades.minimum() == 0.0);
	}
	
	/** This test covers the {@link main.Grades#minimum() minimum()} method
	 * when the supplied list of grades is valid.
	 * */
	@Test
	public void test_Minimum_ValidGrades(){
		ArrayList<Integer> validGrades = new ArrayList<Integer>();
		validGrades.add(60);
		validGrades.add(70);
		validGrades.add(80);
		Grades grades = new Grades("Valid Grades", validGrades);
		assertTrue("Valid grades were not evaluated properly with " +
				"Grades.minimum().", grades.minimum() == 60.0);
	}
	
	/** This test covers the {@link main.Grades#minimum() minimum()} method
	 * when the supplied list of grades are all zero.
	 * */
	@Test
	public void test_Minimum_ZeroValueGrades(){
		ArrayList<Integer> validGrades = new ArrayList<Integer>();
		validGrades.add(0);
		validGrades.add(0);
		validGrades.add(0);
		Grades grades = new Grades("Zero ValueGrades", validGrades);
		assertTrue("Zero value grades were not evaluated properly with " +
				"Grades.minimum().", grades.minimum() == 0.0);
	}
	
	/** This test covers the {@link main.Grades#minimum() minimum()} method
	 * when the supplied list of grades is an empty list.
	 * */
	@Test
	public void test_Minimum_EmptyGradeList(){
		ArrayList<Integer> invalidGrades = new ArrayList<Integer>();
		Grades grades = new Grades("No Grades", invalidGrades);
		assertTrue("Empty list was evaluated to something that was not zero " +
				"with Grades.minimum().", grades.minimum() == 0.0);
	}
	
	// Testing Grades.maximum() method
	
	/** This test covers the {@link main.Grades#maximum() maximum()} method
	 * when the supplied list of grades is null.
	 * */
	@Test
	public void test_Maximum_SecondParam_IsNull() {
		ArrayList<Integer> validGrades = null;
		Grades grades = new Grades("Null Grades", validGrades);
		assertTrue("Grades.minimum() did not return zero with a null list.", 
				grades.maximum() == 0.0);
	}
	
	/** This test covers the {@link main.Grades#maximum() maximum()} method
	 * when the supplied list of grades is valid.
	 * */
	@Test
	public void test_Maximum_ValidGrades(){
		ArrayList<Integer> validGrades = new ArrayList<Integer>();
		validGrades.add(60);
		validGrades.add(70);
		validGrades.add(80);
		Grades grades = new Grades("Valid Grades", validGrades);
		assertTrue("Valid grades were not evaluated properly with " +
				"Grades.minimum().", grades.maximum() == 80.0);
	}
	
	/** This test covers the {@link main.Grades#maximum() maximum()} method
	 * when the supplied list of grades are all zero.
	 * */
	@Test
	public void test_Maximum_ZeroValueGrades(){
		ArrayList<Integer> validGrades = new ArrayList<Integer>();
		validGrades.add(0);
		validGrades.add(0);
		validGrades.add(0);
		Grades grades = new Grades("Zero ValueGrades", validGrades);
		assertTrue("Zero value grades were not evaluated properly with " +
				"Grades.minimum().", grades.maximum() == 0.0);
	}
	
	/** This test covers the {@link main.Grades#maximum() maximum()} method
	 * when the supplied list of grades is an empty list.
	 * */
	@Test
	public void test_Maximum_EmptyGradeList(){
		ArrayList<Integer> invalidGrades = new ArrayList<Integer>();
		Grades grades = new Grades("No Grades", invalidGrades);
		assertTrue("Empty list was evaluated to something that was not zero " +
				"with Grades.minimum().", grades.maximum() == 0.0);
	}
	
	// Testin Grades.length() method
	
	/** This test covers the {@link main.Grades#length() length()} method
	 * when the supplied list of grades is null.
	 * */
	@Test
	public void test_Length_SecondParam_IsNull() {
		ArrayList<Integer> validGrades = null;
		Grades grades = new Grades("Null Grades", validGrades);
		assertTrue("Grades.minimum() did not return zero with a null list.", 
				grades.length() == 0);
	}
	
	/** This test covers the {@link main.Grades#length() length()} method
	 * when the supplied list of grades is valid.
	 * */
	@Test
	public void test_Length_ValidGrades(){
		ArrayList<Integer> validGrades = new ArrayList<Integer>();
		validGrades.add(60);
		validGrades.add(70);
		validGrades.add(80);
		Grades grades = new Grades("Valid Grades", validGrades);
		assertTrue("Valid grades were not evaluated properly with " +
				"Grades.minimum().", grades.length() == 3);
	}
	
	/** This test covers the {@link main.Grades#length() length()} method
	 * when the supplied list of grades are all zero.
	 * */
	@Test
	public void test_Length_ZeroValueGrades(){
		ArrayList<Integer> validGrades = new ArrayList<Integer>();
		validGrades.add(0);
		validGrades.add(0);
		validGrades.add(0);
		Grades grades = new Grades("Zero ValueGrades", validGrades);
		assertTrue("Zero value grades were not evaluated properly with " +
				"Grades.minimum().", grades.length() == 3);
	}
	
	/** This test covers the {@link main.Grades#length() length()} method
	 * when the supplied list of grades is an empty list.
	 * */
	@Test
	public void test_Length_EmptyGradeList(){
		ArrayList<Integer> invalidGrades = new ArrayList<Integer>();
		Grades grades = new Grades("No Grades", invalidGrades);
		assertTrue("Empty list was evaluated to something that was not zero " +
				"with Grades.minimum().", grades.length() == 0);
	}
	
	// Testing Grades.getName() method
	
	/** This test covers the {@link main.Grades#getName() getName()} method
	 * when the supplied name is null. Grades list supplied is null.
	 * */
	@Test
	public void test_GetName_NameIsNull(){
		String tempName = null;
		Grades grades = new Grades(tempName, null);
		assertTrue("Default name provided was not given when name parameter" +
 				" was null with Grades.getName().", 
 				grades.getName().equals("No Name Provided"));
	}
	
	/** This test covers the {@link main.Grades#getName() getName()} method
	 * when the supplied name is valid. Grades list supplied is null.
	 * */
	@Test
	public void test_GetName_NameIsValid(){
		String tempName = "Valid Name";
		Grades grades = new Grades(tempName, null);
		assertTrue("Name given was not returned by the Grades.getName() " +
				"method.", grades.getName().equals(tempName));
	}
	
	/** This test covers the {@link main.Grades#getName() getName()} method
	 * when the supplied name is empty (""). Grades list supplied is null.
	 * */
	@Test
	public void test_GetName_NameIsEmpty(){
		String tempName = "";
		Grades grades = new Grades(tempName, null);
		assertTrue("Default name provided was not given when name parameter" +
 				" was empty with Grades.getName().", 
 				grades.getName().equals("No Name Provided"));
	}
}
