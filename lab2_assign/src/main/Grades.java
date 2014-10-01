package main;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/** Calculates the grades for a student, given a name and a list of integers.
 * @author Haley, K.
 * */
public class Grades {

	// Container for all of the students grades. 
	private List<Integer> grades;

	private String studentName;
	
	private int minimumGrade = 0;
	
	private int maximumGrade = 0;
	
	// Number of grades supplied into the object.
	private int length = 0;
	
	private float medianGrade = 0;
	
	private float averageGrade = 0;
	
	/** Takes a {@link java.lang.String String} representing a student's
	 * name and a {@link java.util.List List} of {@link java.lang.Integer 
	 * Integer}'s representing the student's individual grades.
	 * @param studentName The student's name.
	 * @param grades A {@link java.util.List List} of {@link java.lang.Integer 
	 * Integer}'s representing the student's individual grades  
	 * */
	public Grades(String studentName, List<Integer> grades){
		this.studentName = studentName;
		this.grades = grades;
		// Calls a method to begin initializing the data
		// that needs to be loaded on class creation.
		this.init();
	}
	
	private void init(){
		// If the supplied List of student grades is NOT null,
		// call methods to calculate maximum grade, minimum grade, median 
		// grade, average grade, and total number of all grades supplied
		// for this student.
		// If the supplied List of student grades IS null, class defaults
		// will take precedence as defined in the class field members.
		if (this.grades != null){
			this.length = this.grades.size();
			this.calculateMaximum();
			this.calculateMinimum();
			this.calculateMedian();
			this.calculateAverage();
		}
		// If the student's name is null, protect the class
		// by supplying a default, meaningful value.
		if (this.studentName == null || this.studentName.isEmpty()){
			this.studentName = "No Name Provided";
		}
	}
	
	/** Calculates the maximum grade supplied in the list of Integers.
	 * */
	private void calculateMaximum(){
		// Load smallest possible, acceptable value.
		int tempMax = 0;
		int index = 0;
		// Iterate over the list of integers and discover the maximum value.
		while (index < this.length()){
			// If the number is greater, load. This will ignore negative 
			// numbers.
			if (this.grades.get(index) > tempMax){
				tempMax = this.grades.get(index);
			}
			index++;
		}
		this.maximumGrade = tempMax;
	} // End private method definition for calculateMaximum.
	
	/** Calculates the minimum grade supplied in the list of Integers
	 * representing student grades. {@link Grades#calculateMaximum() 
	 * calculateMaximum} MUST be called first in this object in order
	 * for this method to function properly.
	 * */
	private void calculateMinimum(){
		// Load current maximum grade. This is the baseline for calculating
		// the minimum.
		int tempMax = this.maximumGrade;
		int index = 0;
		int tempMin = 0;
		// Iterate over all existing grades and discover the minimum.
		while (index < this.length()){
			if (this.grades.get(index) < tempMax){
				tempMax = this.grades.get(index);
				tempMin = tempMax;
			}
			index++;
		}
		this.minimumGrade = tempMin;
	} // End private method definition for calculateMinimum.
	
	/** Calculate the median value of all grades supplied. Will only be called
	 * if the total number of grades is greater than zero.
	 * */
	private void calculateMedian(){
		// If the list of student grades is greater than zero, start 
		// calculation.
		if (this.length() > 0){
			// Load a temporary list to avoid altering class field.
			List<Integer> tmpSortedList = new LinkedList<Integer>(this.grades);
			// Leverage existing library to sort the temporary list in
			// ascending order.
			Collections.sort(tmpSortedList);
			// Initialize an integer, but do not assign value. This
			// integer is shared between the conditional branches below.
			int tempMiddle;
			// If the number is even.
			if (this.length() % 2 == 0){
				// Create a divisor as a float.
				float tempDivisor = 2;
				// Calculate the middle index
				tempMiddle = this.length() / 2;
				// Add the two middle values and divide them by 2.
				float tempMedian = 
						(tmpSortedList.get(tempMiddle).floatValue() +
							tmpSortedList.get(tempMiddle - 1).floatValue()) / 
								tempDivisor;
				this.medianGrade = tempMedian;
			} else { // If the number is odd.
				// Subtract 1 from odd number and divide by two
				// to target the middle index.
				tempMiddle = ((this.length() - 1) / 2);
				this.medianGrade = tmpSortedList.get(tempMiddle).floatValue();
			}
		}
	} // End private method definition for calculateMedian.
	
	/** Calculate the average of all grades supplied. Will only be called
	 * if the total number of grades is greater than zero.
	 * */
	private void calculateAverage(){
		// Initialize container for calculating a total.
		int total = 0;
		// Container for the temporary calculation of the average.
		float tempCalculationContainer = 0;
		// Initialize an index for the iterator.
		int index = 0;
		// Check the total number of supplied grades. If zero, do not
		// calculate average and return default average grade.
		// If length is greater than 0...
		if(this.length() > 0){
			// Sum all integers.
			while (index < this.length()){
				total += this.grades.get(index);
				index++;
			}
			// Cast the total to a float and then get total number of grades, 
			// cast the int to a float and then divide by each other.
			tempCalculationContainer = (float) total / (float) this.length();
			// load this value into the appropriate class field.
			this.averageGrade = tempCalculationContainer;
		}
	} // End private method definition for calculateAverage.
	
	/** Returns the total number of grades supplied for this student.
	 * */
	public int length(){
		return this.length;
	} 
	
	/** Returns the name of the student. If the supplied name is null, 
	 * this value will be "No Name Provided".
	 * */
	public String getName(){
		return this.studentName;
	} 
	
	/** Calculates the average of all supplied grades. If no grades supplied,
	 * will return 0.
	 * */
	public float average(){
		return this.averageGrade;
	} 
	
	/** Returns the median value of all supplied grades. If no grades supplied,
	 * will return 0. 
	 * */
	public float median(){
		return this.medianGrade;
	}
	
	/** Returns the maximum value of all supplied grades. If no grades 
	 * supplied, will return 0. 
	 * */
	public int maximum(){
		return this.maximumGrade;
	}
	
	/** Returns the minimum value of all supplied grades. If no grades 
	 * supplied, will return 0. 
	 * */
	public int minimum(){
		return this.minimumGrade;
	}
	
	/** Return the student name and then a comma separated list of supplied
	 * grades in the order they were given encapsulated by "[" and "]".
	 * */
	@Override
	public String toString(){
		return this.getName() 
				+ " " + ((this.grades != null) 
					? this.grades.toString()
							: "[ no grades ]");
	} // End definition for toString override.
} // End class definition for Grades.
