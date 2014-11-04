package calculator;


/**
 * This is the model of this MVC implementation of a calculator.
 * It performs the functions of the calculator and keeps track
 * of what the user has entered.
 * 
 * @author Tom Bylander
 */
public class CalculatorModel {
	/**
	 * This is the numeric value of the number the user is entering,
	 * or the number that was just calculated.
	 */
    private double displayValue;
    
    /**
	 * This is the previous value entered or calculated.
	 */
	private double internalValue;
	
	/**
	 * This is the String corresponding to what the user.
	 * is entering
	 */
	private String displayString;
	
	/**
	 * This is the last operation entered by the user.
	 */
	private String operation;
	
	/**
	 * This is true if the next digit entered starts a new value.
	 */
	private boolean start;
	
	/**
     * This is true if a decimal dot has been entered for the current value.
     */
    private boolean dot;

	/**
	 * Initializes the instance variables.
	 */
	public CalculatorModel() {
		displayValue = 0.0;
		displayString = "" + displayValue;
		internalValue = 0;
		dot = false;
		start = true;
		operation = "";
	}

	/**
	 * @return the String value of what was just calculated
	 * or what the user is entering
	 */
	public String getValue() {
		return displayString;
	}

	/**
	 * Updates the values maintained by the calculator based on the
	 * button that the user has just clicked.
	 * 
	 * @param text is the name of the button that the user has just clicked
	 */
	public void update(String text) {
		if (start) {	
			internalValue = displayValue;
			displayString = "";
			start = false;
			dot = false;
		}
		/** Since these values need to be displayed immediately, they must be
		 * checked before the value of "operation" is checked or before the
		 * user has selected an additional digit. If these values are checked
		 * and the user selects a digit, it will be concatenated.
		 * 
		 * These checks are for:
		 * <pre> 
		 * 1) pi
		 * 2) 1/x
		 * 3) x^2
		 * 4) x^3
		 * 5) 10^x
		 * 6) +/-
		 * </pre>
		 * */
		if (text.equals("pi")) {
			displayValue = Math.PI;
			displayString = "" + displayValue;
		} else if(text.equals("1/x")) { 
			if(displayValue != 0){
				displayValue = 1 / displayValue;
			} else {
				displayValue = 0.0;
			}
			displayString = "" + displayValue;
			if(displayValue == 0){
				start = true;
			}
		} else if(text.equals("x^2")) {
			displayValue = Math.pow(displayValue, 2.0);
			displayString = "" + displayValue;
			if(displayValue == 0){
				start = true;
			}
		} else if(text.equals("+/-")) {
			if(displayValue != 0) {
				displayValue = displayValue * -1;
			} else {
				start = true;
			}
			displayString = "" + displayValue;
		} else if(text.equals("10^x")) {
			displayValue = Math.pow(10.0, displayValue);
			internalValue = displayValue;
			displayString = "" + displayValue;
		} else if(text.equals("x^3")) {
			displayValue = Math.pow(displayValue, 3.0);
			displayString = "" + displayValue;
			if(displayValue == 0){
				start = true;
			}
		} else if (text.length() == 1 && "0123456789".indexOf(text) >= 0) {
			displayString += text;
			displayValue = Double.valueOf(displayString);
		} else if (text.equals(".")) {
			if (! dot) {	
				dot = true;	
				if (displayString.equals("")) {
					displayString = "0";
				}
				displayString += ".";
			}
		} else {
			if (text.equals("Clear")) {
				displayValue = 0.0;
				internalValue = 0.0;
			} else if (operation.equals("+")) {
				displayValue = internalValue + displayValue;
			} else if (operation.equals("-")) {
				displayValue = internalValue - displayValue;
			} else if (operation.equals("*")) {
				displayValue = internalValue * displayValue;
			} else if (operation.equals("/")) {
				displayValue = internalValue / displayValue;
			} else if (operation.equals("y^x")) {
				displayValue = Math.pow(internalValue, displayValue);
			} else if (operation.equals("%")) {
				displayValue = internalValue % displayValue;
			}
			displayString = "" + displayValue;
			internalValue = displayValue;
			operation = text;
			start = true;
		}
	}
}
