import java.util.ArrayList;

import javax.swing.JTextField;

// Knows about the view

public class CalculatorController {
	
	private CalculatorModel model;
	
	public CalculatorController(CalculatorModel model) {
		this.model = model;
	}
	
	public double getGPA(ArrayList<JTextField> units, ArrayList<JTextField> grade) {
		return model.computeForGPA(units, grade);
	}
	
}
