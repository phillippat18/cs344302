import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Grades {

	private List<Integer> grades;
	
	private String studentName;
	
	private int minimumGrade = 0;
	
	private int maximumGrade = 0;
	
	private int length = 0;
	
	private float medianGrade = 0;
	
	private float averageGrade = 0;
	
	public Grades(String studentName, List<Integer> grades){
		this.studentName = studentName;
		this.grades = grades;
		this.init();
	}
	
	private void init(){
		if (this.grades != null){
			this.calculateMaximum();
			this.calculateMinimum();
			this.length = this.grades.size();
		}
		if (this.studentName == null){
			this.studentName = "No Name Provided";
		}
	}
	
	private void calculateMaximum(){
		int tempMax = 0;
		int index = 0;
		while (index < this.length()){
			if (this.grades.get(index) > tempMax){
				tempMax = this.grades.get(index);
			}
			index++;
		}
		this.maximumGrade = tempMax;
	}
	
	private void calculateMinimum(){
		int tempMax = this.maximumGrade;
		int index = 0;
		int tempMin = 0;
		while (index < this.length()){
			if (this.grades.get(index) < tempMax){
				tempMax = this.grades.get(index);
				tempMin = tempMax;
			}
			index++;
		}
		this.minimumGrade = tempMin;
	}
	
	public int length(){
		return this.length;
	}
	
	public String getName(){
		return this.studentName;
	}
	
	public float average(){
		int total = 0;
		float tempCalculationContainer = 0;
		int index = 0;
		if(this.length() > 0){
			while (index < this.length()){
				total += this.grades.get(index);
				index++;
			}
			tempCalculationContainer = (float)total / (float)this.length();
			this.averageGrade = tempCalculationContainer;
		} else {
			this.averageGrade = 0;
		}
		return this.averageGrade;
	}
	
	public float median(){
		if (this.length() > 0){
			List<Integer> tmpSortedList = new LinkedList<Integer>(this.grades);
			Collections.sort(tmpSortedList);
			int tempMiddle;
			if (this.length() % 2 == 0){
				float tempMedian;
				float tempDivisor = 2;
				tempMiddle = this.length() / 2;
				tempMedian = (tmpSortedList.get(tempMiddle).floatValue() +
						tmpSortedList.get(tempMiddle - 1).floatValue()) / 
						tempDivisor;
				this.medianGrade = tempMedian;
			} else {
				tempMiddle = ((this.length() - 1) / 2);
				this.medianGrade = tmpSortedList.get(tempMiddle).floatValue();
			}
		}
		return this.medianGrade;
	}
	
	public int maximum(){
		return this.maximumGrade;
	}
	
	public int minimum(){
		return this.minimumGrade;
	}
	
	@Override
	public String toString(){
		return this.getName() 
				+ " " + ((this.grades != null) 
					? this.grades.toString()
							: "[ no grades ]");
	}
}
