import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Lab2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// store file name in a String.
		String targetFile = "data.txt";
		// load file.
		Scanner in = null;
		try {
		    in = new Scanner(new File(targetFile));
		} catch (FileNotFoundException exception) {
		    System.err.println("failed to open " + targetFile);
		    System.exit(1);
		}
		List<Integer> studentsGrades = new ArrayList<Integer>();
		List<Grades> allStudents = new ArrayList<Grades>();
		while (in.hasNext()) {
		    String studentsName = in.next();
		    while (in.hasNextInt()) {
		        int grade = in.nextInt();
		        studentsGrades.add(grade);
		    }
		    Grades thisStudent = 
		    		new Grades(studentsName, 
		    				new ArrayList<Integer>(studentsGrades));
		    allStudents.add(thisStudent);
		    studentsGrades.clear();
		}
		int index = 0;
		while(index < allStudents.size()){
			Lab2.testGrades(allStudents.get(index));
			index++;
		}

	}
	
	public static void testGrades(Grades grades) {
	    System.out.println(grades.toString()); 
	    System.out.printf("\tName:    %s\n", grades.getName());
	    System.out.printf("\tLength:  %d\n", grades.length());
	    System.out.printf("\tAverage: %.2f\n", grades.average());
	    System.out.printf("\tMedian:  %.1f\n", grades.median());
	    System.out.printf("\tMaximum: %d\n", grades.maximum());
	    System.out.printf("\tMininum: %d\n", grades.minimum());
	}

}
