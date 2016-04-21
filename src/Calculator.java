/*
 * DLSU Term GPA Calculator
 * Gan, Patrick 
 * Contact: patrickcuagan@gmail.com
 */

public class Calculator {
	public static void main(String[] args) {
		CalculatorModel model = new CalculatorModel(); 
		CalculatorController controller = new CalculatorController(model);
		CalculatorView view = new CalculatorView(controller);
	}
}
