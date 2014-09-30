package length;

/** This subclass of {@link Length} represents the length supplied 
 * in the constructor in meters.
 * @author Haley, K.
 * */
public class Meter extends Length {

	/** Converts the length supplied into meters.
	 * @param length Length to be converted to meters.
	 * */
	public Meter(double length) {
		super(length);
	}

	@Override
	public void add(Length other) {
		// Load the existing length for this object
		// into a temporary container.
		double tempLength = this.getLength();
		// Add the value from toMeters to existing temporary length.
		tempLength += other.toMeters();
		// Set the new length.
		this.setLength(tempLength);
	}

	@Override
	public String getUnit() {
		// If the length is not 1, return the plural of the unit. Otherwise,
		// return the singular.
		if (!this.isLengthOne()){
			return "meters";
		} else {
			return "meter";
		}
	}

	@Override
	public double toMeters() {
		return this.getLength();
	}

}
