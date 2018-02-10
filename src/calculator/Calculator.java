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
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 445, 338, 267);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAnswer = new JButton("ANSWER");
		btnAnswer.setBounds(44, 160, 117, 40);
		panel.add(btnAnswer);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnter.setBounds(160, 160, 117, 40);
		panel.add(btnEnter);
		
		
		//Row 1
		
		JButton btnDot = new JButton(".");
		btnDot.setBounds(42, 120, 40, 40);
		panel.add(btnDot);
		
		JButton btn0 = new JButton("0");
		btn0.setBounds(81, 120, 40, 40);
		panel.add(btn0);
		
		JButton btnC = new JButton("C");
		btnC.setBounds(120, 120, 40, 40);
		panel.add(btnC);
		
		JButton btnStar = new JButton("*");
		btnStar.setBounds(159, 120, 40, 40);
		panel.add(btnStar);
		
		JButton btnPi = new JButton("π");
		btnPi.setBounds(198, 120, 40, 40);
		panel.add(btnPi);
		
		JButton btnLn = new JButton("ln");
		btnLn.setBounds(237, 120, 40, 40);
		panel.add(btnLn);
		
		//Row 2
		
		JButton btn3 = new JButton("3");
		btn3.setBounds(42, 80, 40, 40);
		panel.add(btn3);
		
		JButton btn2 = new JButton("2");
		btn2.setBounds(81, 80, 40, 40);
		panel.add(btn2);
		
		JButton btn1 = new JButton("1");
		btn1.setBounds(120, 80, 40, 40);
		panel.add(btn1);
		
		JButton btnDivide = new JButton("/");
		btnDivide.setBounds(159, 80, 40, 40);
		panel.add(btnDivide);
		
		JButton btnE = new JButton("e");
		btnE.setBounds(198, 80, 40, 40);
		panel.add(btnE);
		
		JButton btnTan = new JButton("tan");
		btnTan.setBounds(237, 80, 40, 40);
		panel.add(btnTan);
		
		//Row 3
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn6.setBounds(42, 40, 40, 40);
		panel.add(btn6);
		
		JButton btn5 = new JButton("5");
		btn5.setBounds(81, 40, 40, 40);
		panel.add(btn5);
		
		JButton btn4 = new JButton("4");
		btn4.setBounds(120, 40, 40, 40);
		panel.add(btn4);
		
		JButton btnMinus = new JButton("-");
		btnMinus.setBounds(159, 40, 40, 40);
		panel.add(btnMinus);
		
		JButton btnSqRt = new JButton("√");
		btnSqRt.setBounds(198, 40, 40, 40);
		panel.add(btnSqRt);
		
		JButton btnCos = new JButton("cos");
		btnCos.setBounds(237, 40, 40, 40);
		panel.add(btnCos);
		
		//Row 4
		
		JButton btn9 = new JButton("9");
		btn9.setBounds(42, 0, 40, 40);
		panel.add(btn9);
		
		JButton btn8 = new JButton("8");
		btn8.setBounds(81, 0, 40, 40);
		panel.add(btn8);
		
		JButton btn7 = new JButton("7");
		btn7.setBounds(120, 0, 40, 40);
		panel.add(btn7);
		
		JButton btnPlus = new JButton("+");
		btnPlus.setBounds(159, 0, 40, 40);
		panel.add(btnPlus);
		
		JButton btnPower = new JButton("^");
		btnPower.setBounds(198, 0, 40, 40);
		panel.add(btnPower);
		
		JButton btnSin = new JButton("sin");
		btnSin.setBounds(237, 0, 40, 40);
		panel.add(btnSin);
		
		// End of keyboard
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 222, 338, 159);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.setBounds(63, 117, 93, 36);
		panel_2.add(btnLoad);
		
		JList list = new JList();
		list.setBounds(66, 27, 204, 89);
		panel_2.add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(255, 27, 15, 89);
		panel_2.add(scrollBar);
		
		JLabel lblHistory = new JLabel("History :-");
		lblHistory.setBounds(66, 6, 75, 16);
		panel_2.add(lblHistory);
		

		
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
