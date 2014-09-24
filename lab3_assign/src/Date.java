
/** Class created for manually parsing and comparing dates without
 * using built in Java libraries to accomplish the task. Implements
 * {@link Comparable}.
 * @author Haley, K.
 * */
public class Date implements Comparable<Date>{

	// Store originally supplied string.
	private String originalDateString;
	
	// Container to hold the lowercase, split on space version
	// of the original String.
	private String[] lowerCaseDateStringSplitOnSpace;
	
	// Represents the parsed numeric day. Default value represents 
	// an invalid value.
	private int numericDay = -1;
	
	// Represents the parsed numeric month. Default value represents 
	// an invalid value.
	private int numericMonth = -1;
	
	// Represents the parsed numeric year. Default value represents 
	// an invalid value.
	private int numericYear = -1;
	
	// Container for the full month name to be used in the toString
	// method.
	private String fullMonthName;
	
	// Leap year comparison used when validating days in February.
	private boolean isLeapYear = false;
	
	// Used to determine whether or not to return "Invalid Date" in the
	// toString method.
	private boolean isValidDate = false;
	
	/** Object to represent and compare date strings supplied in the following
	 * format: MMM d, yyyy
	 * <pre>
	 * Examples:
	 * 	1) Jan 3, 1976
	 * 	2) Jan. 3, 1976
	 * 	3) January 3, 1976
	 * </pre>
	 * All non-numeric values will be ignored in the calculation. Any 
	 * additional spaces between characters will result in an invalid date 
	 * being reported.
	 * @param originalDateString The string to be parsed and represented
	 *  by this date object.
	 * */
	public Date(String originalDateString){
		// Verify that the string is not null or not empty.
		if(originalDateString != null && !originalDateString.isEmpty()){
			// If not null or empty, store the original value.
			this.originalDateString = originalDateString;
			// Split the value on multi-space after trimming and setting to
			// lower case.
			this.lowerCaseDateStringSplitOnSpace = 
					this.originalDateString.toLowerCase().trim().split("\\s+");
			// Call cleaner method to prepare the data for parsing.
			this.cleanLowerCaseDateStringArray();
			this.parseNumericDateFromString();
			this.validateNumericDate();
		}
	} // End of single String parameter constructor.
	
	/** This method iterates over the 
	 * {@link Date#lowerCaseDateStringSplitOnSpace 
	 * lowerCaseDateStringSplitOnSpace} array and cleans the values,
	 * replacing non-numeric characters for the day and year portions of the
	 * date string and also replacing non-word characters for the month part.
	 * The purpose of this function is to clean for parsing.
	 * */
	private void cleanLowerCaseDateStringArray(){
		// The first index in the split array should contain the month.
		// If it does not, the validation methods later on will catch.
		// Replace all non-word characters with an empty space.
		this.lowerCaseDateStringSplitOnSpace[0] =
				this.lowerCaseDateStringSplitOnSpace[0]
						.replaceAll("[^\\w]+", "");
		// Prepare an index to iterate over the rest of the array, 
		// regardless of its length. Increment by 1 since the first container
		// has already been cleaned.
		int index = 1;
		// Verify that the date string supplied was not so malformed
		// that attempting to iterate over a split will result in an exception.
		if(this.lowerCaseDateStringSplitOnSpace.length > 1){
			// Iterate over the array and replace any non-digit characters
			// with an empty space. Containers in the array after the first
			// should contain only numbers with punctuation. Negative values
			// are not treated as valid and are removed.
			while(index < this.lowerCaseDateStringSplitOnSpace.length){
				this.lowerCaseDateStringSplitOnSpace[index] = 
						this.lowerCaseDateStringSplitOnSpace[index]
								.replaceAll("[^\\d]+", "");
				index++;
			}
		}
	} // End of private method definition cleanLowerCaseDateStringArray.
	
	/** Wrapper method that parses the values from the supplied date string
	 * for each potential value. If the second and third container in the
	 * {@link Date#lowerCaseDateStringSplitOnSpace 
	 * lowerCaseDateStringSplitOnSpace} field are not numbers, the
	 * date will be treated as invalid.
	 * */
	private void parseNumericDateFromString(){
		// Retrieve numeric month value from specialized method.
		this.numericMonth = this.parseNumericMonth();
		// Verify that the next container ONLY contains a number. If it does
		// not, it will not update the default, invalid value of numericDay.
		if(this.lowerCaseDateStringSplitOnSpace[1].matches("^\\d+$")){
			this.numericDay = Integer.parseInt(
					this.lowerCaseDateStringSplitOnSpace[1]);
		}
		// Verify that the next container ONLY contains a number. If it does
		// not, it will not update the default, invalid value of numericYear.
		if(this.lowerCaseDateStringSplitOnSpace[2].matches("^\\d+$")){
			this.numericYear = Integer.parseInt(
					this.lowerCaseDateStringSplitOnSpace[2]);
		}
	} // End of private method definition parseNumericDateFromString.
	
	/** Parses the data from the date string and stores them in class
	 * members to be validated and compared later. Uses the first three letters
	 * of each month to determine if a month exists. If a month exists,
	 * will store the full name for that month in the 
	 * {@link Date#fullMonthName fullMonthName} field for later use.
	 * Does not validate.
	 * @return -1 represents a date that could not be determined. 1-12 
	 * are valid, numeric month values representing the order of the months
	 * on a calendar.
	 * */
	private int parseNumericMonth(){
		// Create array of strings representing the first three letters
		// of each month in order.
		String[] validMonthPrefixes = {
			"jan",
			"feb",
			"mar",
			"apr",
			"may",
			"jun",
			"jul",
			"aug",
			"sep",
			"oct",
			"nov",
			"dec"
		};
		
		// Set a default, non-valid value for the month. If no values match,
		// this will inform the validation methods that this 
		// is an invalid date.
		int month = -1;
		int index = 0;
		// Iterate over pre-formatted string of date prefixes against
		// the first container in the lowerCaseDateStringSplitOnSpace array.
		while(index < validMonthPrefixes.length){
			// If there is a match, and since the months are in order in
			// the array, set the "month" value to the value of the current
			// index + 1 to represent the current numeric month and
			// break out of the loop.
			if(this.lowerCaseDateStringSplitOnSpace[0]
					.startsWith(validMonthPrefixes[index])){
				month = index + 1;
				break;
			}
			index++;
		}
		// If the month is valid, load the full month name
		// into the class for potential later use if the date is
		// fully valid.
		if(month > 0){
			String[] fullMonthNames = {
					"January",
					"February",
					"March",
					"April",
					"May",
					"June",
					"July",
					"August",
					"September",
					"October",
					"November",
					"December"
			};
			this.fullMonthName = fullMonthNames[(month - 1)];
		}
		return month;
	} // End of private method definition parseNumericMonth.
	
	/** Method that operates on the existing parsed values from the date
	 * string and determines whether or not the date string is valid. If
	 * the numeric values could not be parsed or validated, 
	 * the date is treated as invalid.
	 * */
	private void validateNumericDate(){
		// If any of the parsed dates were treated as invalid by their
		// parsing functions, return and break out of the function.
		if(this.numericDay < 1 
				|| this.numericMonth < 1
				|| this.numericYear < 1){
			return;
		}
		// Check if the year is a leap year for the Feb 29 special case.
		if(this.numericYear % 400 == 0
				&& this.numericYear % 100 == 0){
			this.isLeapYear = true;
		}
		// Verify that the supplied day of the month is a valid day.
		this.isValidDate = this.validateNumericDay();
	} // End of private method definition validateNumericDate.
	
	/** Validates the day supplied in the date string, taking leap years into
	 * account for the month of February.
	 * @return True if the day in the date string is valid, false otherwise.
	 * */
	private boolean validateNumericDay(){
		// Generate valid end dates in order of the months of the year.
		// This will allow us to use the numeric month as an index for
		// checking.
		int[] validMonthEndDays = {
			31, //jan
			28, //feb
			31, //mar
			30, //apr
			31, //may
			30, //jun
			31, //jul
			31, //aug
			30, //sep
			31, //oct
			30, //nov
			31 //dec
		};
		// If this is a leap year, replace existing feb container with 29
		// as the new max.
		if(this.isLeapYear){
			validMonthEndDays[1] = 29;
		}
		// Use the existing numericMonth value, decrement 1, to find
		// the max day of the month. If the max day of the month is less
		// than the supplied day, return false.
		if(validMonthEndDays[(this.numericMonth - 1)] < this.numericDay){
			return false;
		}
		// Return true as default.
		return true;
	} // End of private method definition validateNumericDate.
	
	/** Returns whether or not the date string supplied is considered a valid
	 *  date.
	 *  @return True if date string is valid, false otherwise.
	 * */
	public boolean isValidDate(){
		return this.isValidDate;
	} // End of public method definition isValidDate.
	
	/** Compares one {@link Date} object to another. If the 
	 * calling object represents a date before the compared object,
	 * it will return -1. If the calling object is occurred after the compared
	 * object, it will return 1. If they are equal, 0 will be returned.
	 * @param otherDate The {@link Date} object to be compared.
	 * @return An integer value of -1 if caller occurred before compared,
	 *  1 if caller occurred after compared and 0 if the dates are equal.
	 * */
	@Override
	public int compareTo(Date otherDate) {
		if(this.numericYear < otherDate.numericYear){
			return -1;
		} else if (this.numericYear > otherDate.numericYear){
			return 1;
		} else { // Years are equal.
			if(this.numericMonth < otherDate.numericMonth){
				return -1;
			} else if (this.numericMonth > otherDate.numericMonth){
				return 1;
			} else { // Months are equal.
				if(this.numericDay < otherDate.numericDay){
					return -1;
				} else if (this.numericDay > otherDate.numericDay){
					return 1;
				} else { // Days are equal, therefore the dates are equal.
					return 0;
				}
			}
		}
	} // End of public method definition compareTo.
	
	@Override
	public String toString(){
		if(this.isValidDate){
			return "Date: " + this.fullMonthName 
					+ " " + this.numericDay
					+ ", " + this.numericYear;
		} else {
			return "Invalid Date";
		}
	} // End of public method definition toString.
}
