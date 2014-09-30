import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import length.Foot;
import length.Inch;
import length.Length;
import length.Meter;
import length.Yard;

/** This represents the main entry point for the program for Lab4.
 * Class: CS 3443 02
 * Professor: W. Zhang
 * */
public class Lab4 {

	/** Main entry point and execution for Lab4.
	 * @param args
	 */
	// Add suppress warnings for resource not found if data.txt 
	// cannot be located.
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Generate Scanner object so that it is accessible
		// outside of the try/catch block.
		Scanner in = null;
		try {
		    in = new Scanner(new File("data.txt"));
		} catch (FileNotFoundException exception) {
		    throw new RuntimeException("failed to open data.txt");
		}
		// Create a container that will load supplied lengths
		// on a line by line basis from input file.
		ArrayList<Length> lengths = new ArrayList<Length>();
		
		// Create temporary containers for maximum and minimum lengths
		// given in input file. Initialize to null for entry
		// into the next while loop.
		Length tempMaxLength = null;
		Length tempMinLength = null;
		
		// Iterate over input file on a line by line basis.
		while (in.hasNextDouble()) {
			// Load the first double.
		    double value = in.nextDouble();
		    // Load remainder of line, expecting a unit.
		    String unit = in.next();
		    // Call static method getLengthSubclassType. If the unit is a 
		    // valid unit, the method will return the valid subclass.
		    // Otherwise, this will return null.
		    Length length = getLengthSubclassType(value, unit);
		    // Check if the line was a valid, accepted length.
		    if (length != null){
		    	// Add the length to the list.
		    	lengths.add(length);
		    	// Print out the object class, value and unit.
		    	System.out.println(length);
		    	// If tempMaxLength and tempMinLength are null,
		    	// this is the first iteration through the loop. Load them
		    	// with the existing values for comparison in next iteration.
		    	if (tempMaxLength == null && tempMinLength == null){
		    		tempMaxLength = length;
		    		tempMinLength = length;
		    	}
		    	// Check if this length is greater than existing max length.
		    	if(length.compareTo(tempMaxLength) == 1){
		    		// Load new maximum.
		    		tempMaxLength = length;
		    	// Check if this length is less than existing min length.
		    	} else if (length.compareTo(tempMinLength) == -1){
		    		// Load new minimum.
		    		tempMinLength = length;
		    	}
		    }
		}
		// Print out discovered minimum and maximum.
		System.out.println("\nMinimum is " + tempMinLength);
		System.out.println("Maximum is " + tempMaxLength);
		
		// Initialize new, temporary Length objects for summing.
		Inch tempInch = new Inch(0.0);
		Foot tempFoot = new Foot(0.0);
		Yard tempYard = new Yard(0.0);
		Meter tempMeter = new Meter(0.0);
		
		// Initialize an index for iteration.
		int index = 0;
		// Iterate over list from beginning to end.
		while(index < lengths.size()){
			// Load the value from the list into a temporary object
			// to avoid repeatedly calling it from the array.
			Length tempLength = lengths.get(index);
			// Add the length into each Length subclass.
			tempInch.add(tempLength);
			tempFoot.add(tempLength);
			tempYard.add(tempLength);
			tempMeter.add(tempLength);
			index++;
		}
		
		// Print out the sums for each subclass where the sum is
		// formed from summing from the beginning of the list to the end.
		System.out.println("\nSum of Lengths Adding from First to Last");
		System.out.println(tempMeter);
		System.out.println(tempInch);
		System.out.println(tempFoot);
		System.out.println(tempYard);
		
		// Re-initialize each temporary subclass to zero for later summing.
		tempInch = new Inch(0.0);
		tempFoot = new Foot(0.0);
		tempYard = new Yard(0.0);
		tempMeter = new Meter(0.0);
		
		// Set new value for index to iterate in reverse over the list.
		index = (lengths.size() - 1);
		// Add each value in lengths to each temporary subclass in reverse
		// order.
		while(index >= 0){
			// Create temporary container for repeated use within loop.
			Length tempLength = lengths.get(index);
			tempInch.add(tempLength);
			tempFoot.add(tempLength);
			tempYard.add(tempLength);
			tempMeter.add(tempLength);
			index--;
		}
		
		// Print out sums for each subclass from the lengths list
		// where the sum was formed by adding each value in the list in
		// reverse order.
		System.out.println("\nSum of Lengths Adding from Last to First");
		System.out.println(tempMeter);
		System.out.println(tempInch);
		System.out.println(tempFoot);
		System.out.println(tempYard);
	} // End definition for main method.
	
	/** Method to evaluate whether the supplied unit is a valid unit
	 *  that can be used in the {@link Length} subclasses {@link Meter},
	 *  {@link Yard}, {@link Foot}, and {@link Yard}.
	 *  @param value Value used to create the {@link Length} subclass
	 *  if it is a valid unit for the subclasses of {@link Length}.
	 *  @param unit Unit will be compared against various strings to determine
	 *  if it is a valid unit to be used in the creation of a subclass of
	 *  {@link Length}. The following case insensitive values will 
	 *  match and create the mentioned subclass.
	 *  <pre>
	 *  Meter - meter, meters, m., m
	 *  Yard - yard, yards, yd., yd
	 *  Inch - inch, inches, in., in
	 *  Foot - foot, feet, ft., ft
	 *  </pre>
	 *  If values other than those defined above are supplied, null will be
	 *  returned. 
	 *  @return Returns a subclass of {@link Length} ({@link Meter},
	 *  {@link Yard}, {@link Foot}, and {@link Yard}) if the unit is a valid
	 *  value. Null otherwise.
	 * */
	public static Length getLengthSubclassType(double value, String unit){
		// Trim the given value and set it to lower case in a temporary
		// container to normalize it for comparison.
		String tempUnit = unit.toLowerCase().trim();
		// For each ladder determines whether or not the value can be used
		// to create a Length subclass.
		if(tempUnit.trim().equals("meter")
				|| tempUnit.trim().equals("meters")
				|| tempUnit.trim().equals("m")
				|| tempUnit.trim().equals("m.")){
			return new Meter(value);
		} else if (tempUnit.trim().equals("yard")
				|| tempUnit.trim().equals("yards")
				|| tempUnit.trim().equals("yd")
				|| tempUnit.trim().equals("yd.")){
			return new Yard(value);
		} else if (tempUnit.trim().equals("foot") 
				|| tempUnit.trim().equals("feet")
				|| tempUnit.trim().equals("ft")
				|| tempUnit.trim().equals("ft.")){
			return new Foot(value);
		} else if (tempUnit.trim().equals("inch")
				|| tempUnit.trim().equals("inches")
				|| tempUnit.trim().equals("in")
				|| tempUnit.trim().equals("in.")){
			return new Inch(value);
		// If the supplied input is not a valid value, return null.
		} else {
			return null;
		}
	} // End public method definition for getLengthSubclassType
} // End class definition for Lab4.
