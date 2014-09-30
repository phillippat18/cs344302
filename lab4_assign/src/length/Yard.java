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
		double tempLength = this.getLength();
		tempLength += (other.toMeters() / Yard.METERS_PER_YARD);
		this.setLength(tempLength);
	}

	@Override
	public String getUnit() {
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
