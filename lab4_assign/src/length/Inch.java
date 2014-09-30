package length;

/** This subclass of {@link Length} represents the length supplied 
 * in the constructor in inches, with conversion abilities to meters.
 * @author Haley, K.
 * */
public class Inch extends Length {
	
	/** 1 inch = 0.0254 meters
	 * */
	public static final double METERS_PER_INCH = 0.0254;

	/** Converts the length supplied into inches.
	 * @param length Length to be converted to inches.
	 * */
	public Inch(double length) {
		super(length);
	}

	@Override
	public void add(Length other) {
		double tempLength = this.getLength();
		tempLength += (other.toMeters() / Inch.METERS_PER_INCH);
		this.setLength(tempLength);
	}

	@Override
	public String getUnit() {
		if (!this.isLengthOne()){
			return "inches";
		} else {
			return "inch";
		}
	}

	@Override
	public double toMeters() {
		return this.getLength() * Inch.METERS_PER_INCH;
	}

}
