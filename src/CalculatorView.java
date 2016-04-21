import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.*;

public class CalculatorView extends JFrame {
	
	private CalculatorController calculator_controller;
	
	private Container main_pane;
	private JLabel header_lable;
	private JScrollPane entry_pane;
	private JButton add_grade_button;
	private JButton compute_gpa_button;
	private JTextField gpa_label;
	private Container entry_pane_container;
		
	/*
	 * These two arrays are for passing ALL the values at once to 
	 * the model.
	 */
	ArrayList<JTextField> unit_array = new ArrayList<JTextField> ();
	ArrayList<JTextField> grade_array = new ArrayList<JTextField> ();
		
	public CalculatorView(CalculatorController calculator_controller) {
		this.calculator_controller = calculator_controller;
		this.setSize(300, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		main_pane = new Container();
		main_pane = this.getContentPane();
		main_pane.setLayout(null);
		
		header_lable = new JLabel("DLSU GPA Calculator");
		header_lable.setBounds(80, 2, 300, 20);
		main_pane.add(header_lable);
		
		/*
		 * This is where the JTextField for unit entry and grade entry
		 * goes. There will be just 1 at first and more can be added
		 * through a button.
		 */
		entry_pane = new JScrollPane(null);
		entry_pane.setBounds(0, 25, 300, 250);
		main_pane.add(entry_pane);
		
		entry_pane_container = new Container();
		entry_pane_container.setLayout(null);

		JPanel panel = new JPanel(null);
		panel.setBounds(0, 0, 300, 20);
		
		JLabel grade_label = new JLabel("Grade:");
		grade_label.setBounds(30, 0, 50, 20);
		panel.add(grade_label);
		
		JTextField grade = new JTextField();
		grade_array.add(grade);
		grade.setBounds(75, 0, 50, 20);
		panel.add(grade);
		
		JLabel unit_label = new JLabel("Units:");
		unit_label.setBounds(145, 0, 50, 20);
		panel.add(unit_label);
		
		JTextField units = new JTextField();
		unit_array.add(units);
		units.setBounds(185, 0, 50, 20);
		panel.add(units);
		
		entry_pane_container.add(panel);
		entry_pane.getViewport().add(entry_pane_container);
		entry_pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		entry_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		/*
		 * End of the JScrollPane
		 */
		
		add_grade_button = new JButton("Add Grade");
		add_grade_button.setBounds(20, 295, 120, 20);
		main_pane.add(add_grade_button);
		add_grade_button.addActionListener(new addGrade_Action());
		
		compute_gpa_button = new JButton("Get GPA");
		compute_gpa_button.setBounds(20, 330, 120, 20);
		main_pane.add(compute_gpa_button);
		compute_gpa_button.addActionListener(new computeGrade_Action());
		
		gpa_label = new JTextField();
		gpa_label.setEditable(false);
		gpa_label.setBounds(165, 300, 120, 50);
		main_pane.add(gpa_label);
		
		this.setVisible(true);
	}
	
	/*
	 * Adds another set of grade JTextField and unit JTextField
	 * to the scrollpane.
	 */
	public class addGrade_Action implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JPanel panel = new JPanel(null);
			panel.setBounds(0, unit_array.size() * 20, 300, 20);
			
			JLabel grade_label = new JLabel("Grade:");
			grade_label.setBounds(30, 0, 50, 20);
			panel.add(grade_label);
			
			JTextField grade = new JTextField();
			grade_array.add(grade);
			grade.setBounds(75, 0, 50, 20);
			panel.add(grade);
			
			JLabel unit_label = new JLabel("Units:");
			unit_label.setBounds(145, 0, 50, 20);
			panel.add(unit_label);
			
			JTextField units = new JTextField();
			unit_array.add(units);
			units.setBounds(185, 0, 50, 20);
			panel.add(units);
			
			entry_pane_container.add(panel);
			entry_pane_container.validate();
			entry_pane_container.repaint();
			entry_pane.getViewport().add(entry_pane_container);
			entry_pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			entry_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		}
	}
	
	public class computeGrade_Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Decimal format used to round up the values
			DecimalFormat df = new DecimalFormat("#.000");
			gpa_label.setText(String.valueOf(df.format(calculator_controller.getGPA(unit_array, grade_array))));
		}
		
	}
}
