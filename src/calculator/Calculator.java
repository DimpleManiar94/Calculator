package calculator;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Calculator {

	private JFrame frame;

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
		
		KeyboardPanel keyBoardPanel = new KeyboardPanel();
		keyBoardPanel.setBounds(6, 445, 338, 267);
		frame.getContentPane().add(keyBoardPanel);
		keyBoardPanel.setLayout(null);
		
		HistoryPanel historyPanel = new HistoryPanel();
		historyPanel.setBounds(6, 222, 338, 159);
		frame.getContentPane().add(historyPanel);
		historyPanel.setLayout(null);
				
		EquationPanel equationPanel = new EquationPanel();
		equationPanel.setBounds(6, 6, 338, 189);
		frame.getContentPane().add(equationPanel);
		equationPanel.setLayout(null);
			
		ScreenPanel screenPanel_1 = new ScreenPanel();
		screenPanel_1.setBounds(6, 393, 338, 47);
		frame.getContentPane().add(screenPanel_1);
		screenPanel_1.setLayout(null);	
			
	}
}
