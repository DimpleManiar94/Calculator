package calculator;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Calculator {

	private JFrame frame;
	private KeyboardPanel keyBoardPanel;
	private HistoryPanel historyPanel;
	private EquationPanel equationPanel;
	private ScreenPanel screenPanel;

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
		
		keyBoardPanel = new KeyboardPanel();
		keyBoardPanel.setBounds(6, 445, 338, 267);
		frame.getContentPane().add(keyBoardPanel);
		keyBoardPanel.setLayout(null);
		
		historyPanel = new HistoryPanel();
		historyPanel.setBounds(6, 222, 338, 159);
		frame.getContentPane().add(historyPanel);
		historyPanel.setLayout(null);
				
		equationPanel = new EquationPanel();
		equationPanel.setBounds(6, 6, 338, 189);
		frame.getContentPane().add(equationPanel);
		equationPanel.setLayout(null);
		
			
		screenPanel = new ScreenPanel();
		screenPanel.setBounds(6, 393, 338, 47);
		frame.getContentPane().add(screenPanel);
		screenPanel.setLayout(null);	
	
		initEquationListeners();
			
	}
	
	private void initEquationListeners() {
		equationPanel.getAddButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If this is a click
				String equation = equationPanel.getText();
				historyPanel.addToHistory(equation);
			}
		});
		
		equationPanel.getDeleteButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: Get selected item from historyPanel. Something like
				// historyPanel.getSelectedItem();
				historyPanel.deleteFromHistory(""); // Replace with actual equation
			}
		});
	}
	
	
}
