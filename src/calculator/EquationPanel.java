package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class EquationPanel extends JPanel {
	
	private JLabel lblEquation;
	private JTextField equationTextField;
	private JLabel lblYFx;
	private JButton btnAdd;
	private JButton btnDel;
	private JLabel lblSelectAColor;
	private JComboBox<String> colorComboBox;
	
	
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
		
		btnAdd = new JButton("ADD");
		btnAdd.setBounds(80, 73, 96, 35);
		this.add(btnAdd);
		
		btnDel = new JButton("DEL");
		btnDel.setBounds(183, 73, 96, 35);
		this.add(btnDel);
		
		JLabel lblSelectAColor = new JLabel("Select a color :-");
		lblSelectAColor.setBounds(80, 120, 123, 16);
		this.add(lblSelectAColor);
		
		String[] colors = {"BLACK", "BLUE", "GREEN", "RED", "YELLOW"};
		colorComboBox = new JComboBox<String>(colors);
		colorComboBox.setBounds(76, 139, 127, 27);
		this.add(colorComboBox);
		colorComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String color = colorComboBox.getSelectedItem().toString();
				changeColorOfText(color);
			}
		});
	}
	
	public String getEquation() {
		return equationTextField.getText();
	}
	
	public void setEquation(String equation) {
		equationTextField.setText(equation);
	}
	
	public JButton getAddButton() {
		return btnAdd;
	}
	
	public JButton getDeleteButton() {
		return btnDel;
	}
	
	public void changeColorOfText(String color) {
		switch(color) {
		case "BLACK":
			equationTextField.setForeground(Color.BLACK);
			break;
		case "BLUE":
			equationTextField.setForeground(Color.BLUE);
			break;
		case "RED":
			equationTextField.setForeground(Color.RED);
			break;
		case "GREEN":
			equationTextField.setForeground(Color.GREEN);
			break;
		case "YELLOW":
			equationTextField.setForeground(Color.YELLOW);
			break;
			default:
				equationTextField.setForeground(Color.BLACK);
				break;
		}
		
	}

}
