
/** Prints out the range between two {@link Date} objects.
 * @author Haley, K.
 * */
public class DateRange {
	
	// First supplied date in constructor.
	private Date date1;
	
	// Second supplied date in constructor.
	private Date date2;
	
	/** Takes two {@link Date} objects and prints out
	 * the comparison between the two of them. If either are null
	 * 
	 * @param date1 The first {@link Date} to be printed.
	 * @param date2 The second {@link Date} to be printed.
	 * */
	public DateRange(Date date1, Date date2){
		this.date1 = date1;
		this.date2 = date2;
	} // End of two parameter constructor.
	
	/** If either dates supplied are null or invalid, will return an empty 
	 * String. 
	 * @return Empty string if either dates are invalid or null, otherwise
	 * will print the following format:
	 * <pre>
	 * 	DateRange: Date: date1 - Date: date2
	 * 	Example:
	 * 		DateRange: Date: January 3, 1984 - Date: April 3, 1985
	 * </pre>
	 * */
	@Override
	public String toString(){
		String temp = "";
		// Verify that both date1 and date2 are not null.
		if(this.date1 != null && this.date2 != null){
			// If not null, verify that they are valid dates. If so, load
			// the expected string. If not, keep default.
			if(this.date1.isValidDate() && this.date2.isValidDate()){
				temp = "DateRange: " + this.date1
						+ " - " + this.date2; 
			}
		}
		return temp;
	} // End of public method definition toString.
}
