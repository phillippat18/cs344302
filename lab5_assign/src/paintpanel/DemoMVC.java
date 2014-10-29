package paintpanel;
import javax.swing.*;

/**
 * This demonstrates the model-view-controller design pattern.
 * Adapted from Figures 14.23 and 14.34.
 * @author Tom Bylander
 */
public class DemoMVC {
	/**
	 * main method starts the application
	 */
	public static void main(String[] args) {
		DemoModel model = new DemoModel();
		DemoView view = new DemoView(model);
		DemoController controller = new DemoController(model, view);
		
		// register controller as the listener
		view.registerListener(controller);
		
		// start it up
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(400, 300);
		view.setVisible(true);
	}
}
