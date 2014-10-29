package paintpanel;
import java.awt.*;
import java.util.ArrayList;

/**
 * The DemoModel class holds the information that is used by the GUI.
 * Ask yourself the question, what data would be needed to recreate
 * the state of the GUI?  This data is what should be stored in the
 * model.
 * <p>
 * The instance variables are from Fig. 14.34.
 * @author Tom Bylander
 */
public class DemoModel {
    /** 
     * The number of points 
     */
	private int pointCount;

	/** 
	 * An array of 10000 java.awt.Point references 
	 */
	private ArrayList<Point> points;
	
	private ArrayList<Color> selectedColors;
	
	/** 
	 * The color selected by the user 
	 */
	private Color selectedColor;
	
	public DemoModel() {
		pointCount = 0;
		points = new ArrayList<Point>();
		selectedColors = new ArrayList<Color>();
		selectedColor = Color.CYAN;
	}
	
	/**
	 * Add a Point to the points array.
	 * @param point the Point to be added to points.
	 */
	public void addPoint(Point point, Color color) {
		// doesn't avoid out-of-bounds errors
		points.add(point);
		selectedColors.add(color);
		pointCount++;
	}
	
	/**
	 * Returns point at index i.
	 * Returns null if no such point exists.
	 * @param i
	 */
	public Point getPoint(int i) {
		if (i >= 0 && i < pointCount) {
			return new Point(points.get(i));
		}
		return null;
	}
	
	/**
	 * Store the color that the user selected.
	 * @param color the color selected by the user
	 */
	public void setSelectedColor(Color color) {
		selectedColor = color;
	}
	
	/**
	 * @return the color selected by the user
	 */
	public Color getSelectedColor() {
		return selectedColor;
	}
	
	/** 
	 * @return The color at a given index.
	 * */
	public Color getColor(int index){
		if(index >= 0 && index < pointCount){
			return selectedColors.get(index);
		}
		return null;
	}
}
