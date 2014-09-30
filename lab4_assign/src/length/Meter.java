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
		double tempLength = this.getLength();
		tempLength += other.toMeters();
		this.setLength(tempLength);
	}

	@Override
	public String getUnit() {
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
