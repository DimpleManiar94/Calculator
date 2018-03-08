package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class EquationPanel extends JPanel {
	
	private JLabel lblEquation;
	private JTextField equationTextField;
	private JLabel lblYFx;
	/*private JButton btnAdd;
	private JButton btnDel;*/
	private JLabel lblSelectAColor;
	private JComboBox<String> colorComboBox;
	private JButton btnPlot;
	private JButton btnErase;
	JLabel lblYAxisRange;
	JLabel lblXrange;
	private JTextField txtXRange;
	private JTextField txtYRange;
	
	
	public EquationPanel() {
		addKeys();
	}
	
	public void addKeys() {
		lblEquation = new JLabel("Equation :-");
		lblEquation.setBounds(86, 18, 80, 22);
		this.add(lblEquation);
		
		equationTextField = new JTextField();
		equationTextField.setToolTipText("Enter f(x) here");
		equationTextField.setBounds(80, 41, 199, 26);
		this.add(equationTextField);
		equationTextField.setColumns(10);
		
		lblYFx = new JLabel("y = f(x) =");
		lblYFx.setBounds(16, 46, 61, 16);
		this.add(lblYFx);
		
		/*btnAdd = new JButton("ADD");
		btnAdd.setBounds(80, 73, 96, 35);
		this.add(btnAdd);
		
		btnDel = new JButton("DEL");
		btnDel.setBounds(183, 73, 96, 35);
		this.add(btnDel);*/
		
		btnPlot = new JButton("PLOT");
		btnPlot.setBounds(86, 122, 96, 35);
		this.add(btnPlot);
		
		btnErase = new JButton("ERASE");
		btnErase.setBounds(183, 122, 96, 35);
		this.add(btnErase);
		
		JLabel lblSelectAColor = new JLabel("Select a color :-");
		lblSelectAColor.setBounds(80, 157, 123, 16);
		this.add(lblSelectAColor);
		
		lblXrange = new JLabel("X axis Range");
		lblXrange.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblXrange.setBounds(6, 76, 80, 16);
		this.add(lblXrange);
		
		lblYAxisRange = new JLabel("Y axis Range ");
		lblYAxisRange.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblYAxisRange.setBounds(6, 100, 80, 16);
		this.add(lblYAxisRange);
		
		txtXRange = new JTextField();
		txtXRange.setBounds(80, 71, 199, 26);
		this.add(txtXRange);
		txtXRange.setColumns(10);
		
		txtYRange = new JTextField();
		txtYRange.setBounds(80, 95, 199, 26);
		this.add(txtYRange);
		txtYRange.setColumns(10);
		
		String[] colors = {"BLACK", "BLUE", "GREEN", "RED", "YELLOW"};
		colorComboBox = new JComboBox<String>(colors);
		colorComboBox.setBounds(76, 174, 127, 27);
		this.add(colorComboBox);
	}
	
	public String getEquation() {
		return equationTextField.getText();
	}
	
	public void setEquation(String equation) {
		equationTextField.setText(equation);
	}
	
	/*public JButton getAddButton() {
		return btnAdd;
	}
	
	public JButton getDeleteButton() {
		return btnDel;
	}*/
	
	public JButton getPlotButton() {
		return btnPlot;
	}
	
	public JButton getEraseButton() {
		return btnErase;
	}
	
	public String getXRange() {
		return txtXRange.getText();
	}
	
	public String getYRange() {
		return txtYRange.getText();
	}
	
	public JComboBox<String> getColorComboBox() {
		return colorComboBox;
	}
	
	public void changeColorOfText(Color color) {
		equationTextField.setForeground(color);	
		
	}

}
