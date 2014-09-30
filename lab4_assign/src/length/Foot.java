package length;

/** This subclass of {@link Length} represents the length supplied 
 * in the constructor in feet, with conversion abilities to meters.
 * @author Haley, K.
 * */
public class Foot extends Length {

	/** 1 foot = 0.3048 meters
	 * */
	public static final double METERS_PER_FOOT = 0.3048;
	
	/** Converts the length supplied into feet.
	 * @param length Length to be converted to feet.
	 * */
	public Foot(double length) {
		super(length);
	}

	@Override
	public void add(Length other) {
		double tempLength = this.getLength();
		tempLength += (other.toMeters() / Foot.METERS_PER_FOOT);
		this.setLength(tempLength);
	}

	@Override
	public String getUnit() {
		if (!this.isLengthOne()){
			return "feet";
		} else {
			return "foot";
		}
	}

	@Override
	public double toMeters() {
		return this.getLength() * Foot.METERS_PER_FOOT;
	}

}
