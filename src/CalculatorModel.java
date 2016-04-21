import java.awt.*;
import javax.swing.*;
import java.util.*;

public class CalculatorModel {
	
	public CalculatorModel() {
	}
	
	public double computeForGPA(ArrayList<JTextField> units, ArrayList<JTextField> grade) {
		double total_units = 0.0;
		double total_grade = 0.0;
		
		for(int i=0; i<units.size(); i++) {
			total_grade += Double.parseDouble(units.get(i).getText()) * Double.parseDouble(grade.get(i).getText());
			total_units += Double.parseDouble(units.get(i).getText());
		}
		
		return total_grade/total_units;
	}
}
