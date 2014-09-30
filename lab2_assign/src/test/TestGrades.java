package test;

import java.util.ArrayList;

import main.Grades;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGrades {
	
	// Testing Grades.median() method.

	@Test
	public void test_Median_SecondParam_IsNull() {
		ArrayList<Integer> validGrades = null;
		Grades grades = new Grades("Null Grades", validGrades);
		assertTrue("Grades.median() did not return zero with a null list.", 
				grades.median() == 0.0);
	}
	
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
	
	@Test
	public void test_Median_EmptyGradeList(){
		ArrayList<Integer> invalidGrades = new ArrayList<Integer>();
		Grades grades = new Grades("No Grades", invalidGrades);
		assertTrue("Empty list was evaluated to something that was not zero " +
				"with Grades.median().", grades.median() == 0.0);
	}
	
	// Testing Grades.average() method.
	
	@Test
	public void test_Average_SecondParam_IsNull() {
		ArrayList<Integer> validGrades = null;
		Grades grades = new Grades("Null Grades", validGrades);
		assertTrue("Grades.average() did not return zero with a null list.", 
				grades.average() == 0.0);
	}
	
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
	
	@Test
	public void test_Average_EmptyGradeList(){
		ArrayList<Integer> invalidGrades = new ArrayList<Integer>();
		Grades grades = new Grades("No Grades", invalidGrades);
		assertTrue("Empty list was evaluated to something that was not zero " +
				"with Grades.average().", grades.average() == 0.0);
	}
	
	// Testing Grades.minimum() method
	
	@Test
	public void test_Minimum_SecondParam_IsNull() {
		ArrayList<Integer> validGrades = null;
		Grades grades = new Grades("Null Grades", validGrades);
		assertTrue("Grades.minimum() did not return zero with a null list.", 
				grades.minimum() == 0.0);
	}
	
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
	
	@Test
	public void test_Minimum_EmptyGradeList(){
		ArrayList<Integer> invalidGrades = new ArrayList<Integer>();
		Grades grades = new Grades("No Grades", invalidGrades);
		assertTrue("Empty list was evaluated to something that was not zero " +
				"with Grades.minimum().", grades.minimum() == 0.0);
	}
}
