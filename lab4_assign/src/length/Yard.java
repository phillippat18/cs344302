package length;

/** This subclass of {@link Length} represents the length supplied 
 * in the constructor in yards, with conversion abilities to meters.
 * @author Haley, K.
 * */
public class Yard extends Length {
	
	/** 1 yard = 0.9144 meters
	 * */
	public static final double METERS_PER_YARD = 0.9144;

	/** Converts the length supplied into yards.
	 * @param length Length to be converted to yards.
	 * */
	public Yard(double length) {
		super(length);
	}

	@Override
	public void add(Length other) {
		// Load the existing length for this object
		// into a temporary container.
		double tempLength = this.getLength();
		// Sum the supplied value from the other Length object, normalizing
		// using meters.
		tempLength += (other.toMeters() / Yard.METERS_PER_YARD);
		// Set the new length for this object.
		this.setLength(tempLength);
	}

	@Override
	public String getUnit() {
		// If the length is not 1, return the plural of the unit. Otherwise,
		// return the singular.
		if (!this.isLengthOne()){
			return "yards";
		} else {
			return "yard";
		}
	}

	@Override
	public double toMeters() {
		return this.getLength() * Yard.METERS_PER_YARD;
	}
}
