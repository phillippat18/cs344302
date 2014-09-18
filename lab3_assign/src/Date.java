
public class Date implements Comparable<Date>{

	private String dateString;
	
	private long epochConversion;
	
	private boolean isValid = false;
	
	private int[] validEndDatesBasedOnYear;
	
	public Date(String dateString) {
		if (dateString != null){
			this.dateString = dateString.trim();
		}
	}

	private void convertDateToEpoch(){
		
	}
	
	private void generateDates(){
		// leap year = year % 100 == 0 && year % 400 == 0
	}
	
	public long getEpoch(){
		return this.epochConversion;
	}
	
	private String getProperMonth(){
		String[] monthPrefixes = 
			{"jan"
			, "feb"
			, "mar"
			, "apr"
			, "may"
			, "jun"
			, "jul"
			, "aug"
			, "sep"
			, "oct"
			, "nov"
			, "dec"};
		return null;
	}
	
	@Override
	public int compareTo(Date o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
