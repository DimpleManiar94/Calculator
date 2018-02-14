package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class Calculator {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		KeyboardPanel panel = new KeyboardPanel();
		panel.setBounds(6, 445, 338, 267);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		EquationPanel equationPanel = new EquationPanel();
		equationPanel.setBounds(6, 222, 338, 159);
		frame.getContentPane().add(equationPanel);
		equationPanel.setLayout(null);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(6, 6, 338, 189);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblEquation = new JLabel("Equation :-");
		lblEquation.setBounds(86, 18, 80, 22);
		panel_3.add(lblEquation);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Enter f(x) here");
		textField_1.setBounds(80, 41, 199, 26);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblYFx = new JLabel("y = f(x) =");
		lblYFx.setBounds(16, 46, 61, 16);
		panel_3.add(lblYFx);
		
		JButton btnNewButton_6 = new JButton("ADD");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_6.setBounds(80, 73, 96, 35);
		panel_3.add(btnNewButton_6);
		
		JButton btnDel = new JButton("DEL");
		btnDel.setBounds(183, 73, 96, 35);
		panel_3.add(btnDel);
		
		JLabel lblSelectAColor = new JLabel("Select a color :-");
		lblSelectAColor.setBounds(80, 120, 123, 16);
		panel_3.add(lblSelectAColor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(76, 139, 127, 27);
		panel_3.add(comboBox);
		
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(6, 393, 338, 47);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);
			
			textField = new JTextField();
			textField.setBounds(45, 6, 235, 41);
			panel_1.add(textField);
			textField.setColumns(10);
	}
}
