package calculator;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;


public class Calculator {

	private JFrame frame;
	private KeyboardPanel keyBoardPanel;
	private HistoryPanel historyPanel;
	private EquationPanel equationPanel;
	private ScreenPanel screenPanel;
	private GraphPanel graphPanel;
	
	boolean allowDot = true;
	double answer = 0;
	String state = "initial";

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
		frame.setBounds(100, 100, 1200, 700);
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
		equationPanel.setBounds(6, 6, 338, 204);
		frame.getContentPane().add(equationPanel);
		equationPanel.setLayout(null);
				
		screenPanel = new ScreenPanel();
		screenPanel.setBounds(6, 393, 338, 47);
		frame.getContentPane().add(screenPanel);
		screenPanel.setLayout(null);	
		
		graphPanel = new GraphPanel();
		graphPanel.setBounds(370, 35, 794, 600);
		frame.getContentPane().add(graphPanel);
		//graphPanel.setLayout(null);
		graphPanel.setBackground(Color.LIGHT_GRAY);
		
	
		initEquationListeners();
		initHistoryListeners();
		initKeyboardListeners();			
	}
	
	private void initEquationListeners() {
		equationPanel.getPlotButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String equation = equationPanel.getEquation();
//				graphPanel.setGraphEquation(equation);
				String xRange = equationPanel.getXRange();
				int xFrom = Integer.parseInt(xRange.substring(xRange.indexOf("[") + 1, xRange.indexOf(",")));
				int xTo = Integer.parseInt(xRange.substring(xRange.indexOf(",") + 1, xRange.indexOf("]")));
				graphPanel.setXRange(xTo - xFrom);
				String yRange = equationPanel.getYRange();
				int yFrom = Integer.parseInt(yRange.substring(yRange.indexOf("[") + 1, yRange.indexOf(",")));
				int yTo = Integer.parseInt(yRange.substring(yRange.indexOf(",") + 1, yRange.indexOf("]")));
				graphPanel.setYRange(yTo - yFrom);
				GraphPanel panel = new GraphPanel(equation, xTo - xFrom, yTo - yFrom);
				panel.setBounds(370, 35, 794, 600);
				frame.getContentPane().add(panel);
				//graphPanel.setLayout(null);
				panel.setBackground(Color.LIGHT_GRAY);
				historyPanel.addToHistory("PLOT: y = " + equation);
			}
		});
	}
	
	/*private void initEquationListeners() {
		equationPanel.getAddButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If this is a click
				String equation = "y = f(x) = " + equationPanel.getEquation();
				historyPanel.addToHistory(equation);
			}
		});
		
		equationPanel.getDeleteButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				historyPanel.deleteFromHistory();
			}
		});
		
	}*/
	
	private void initHistoryListeners() {
		historyPanel.getLoadButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String equation = historyPanel.getEquationOnLoadButtonClick();
				// load string from history list after =
				//eg Plot: y = x+1
				equation = equation.substring(equation.indexOf("=") + 2);
				//equation = equation.substring(11, equation.length());
				equationPanel.setEquation(equation);
			}
		});
	}
	
	private void initKeyboardListeners() {
		
		keyBoardPanel.getClearButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screenPanel.setText("0");
				allowDot = true;
				state = "initial";
			}
		});
		
		keyBoardPanel.getDotButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(allowDot) {
				String text = screenPanel.getText() + ".";
				screenPanel.setText(text);
				allowDot = false;
				}
			}
		});
		
		for(JButton numberButton: keyBoardPanel.getNumberButtons()) {
			numberButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String text = screenPanel.getText();
					if(state.equals("initial")) {
						if(String.valueOf(text.charAt(text.length()-1)).equals("0")) {
							text = "";							
						}
					}
					else if(state.equals("result") || state.equals("pi/e")) {
						String lastChar = String.valueOf(text.charAt(text.length()-1));
						while(text.length() != 0 && (!lastChar.equals("+") ^ !lastChar.equals("-") ^ !lastChar.equals("*") ^ !lastChar.equals("/") ^ !lastChar.equals("^") )) {
							text = text.substring(0, text.length()-1);
							if (text.length() > 0) {
								lastChar = String.valueOf(text.charAt(text.length()-1));
							}
						}
					}
					text = text + numberButton.getText();
					screenPanel.setText(text);
					state = "number";
				}
				
			});
		}
		
		for (JButton valueButton: keyBoardPanel.getValueButtons()) {
			valueButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String text = screenPanel.getText();
					if(state.equals("initial")) {
						if(String.valueOf(text.charAt(text.length()-1)).equals("0")) {
							text = "";							
						}
					}
					else if(state.equals("result") || state.equals("pi/e") || state.equals("number")) {
						String lastChar = String.valueOf(text.charAt(text.length()-1));
						while(text.length() != 0 && (!lastChar.equals("+") ^ !lastChar.equals("-") ^ !lastChar.equals("*") ^ !lastChar.equals("/") ^ !lastChar.equals("^") )) {
							text = text.substring(0, text.length()-1);
							if (text.length() > 0) {
								lastChar = String.valueOf(text.charAt(text.length()-1));
							}
						}
					}
					String btnText = valueButton.getText();
					if(btnText.equals("π")) {
						btnText = "3.14";
					}
					else if(btnText.equals("e")) {
						btnText = "2.72";
					}
					else if(btnText.equals("ANSWER")) {
						btnText = String.valueOf(answer);
					}
					screenPanel.setText(text + btnText);
					allowDot = false;
					state = "pi/e";
				}
			});
		}
		
		for(JButton resultOperationButton: keyBoardPanel.getresultOperations()) {
			resultOperationButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String text = screenPanel.getText();
					double result = ValidateEquation.evaluateExpression(text);					
					String operation = resultOperationButton.getText();
					switch(operation) {
					case "sin":
						result = Math.sin(Math.toRadians(result));
						break;
					case "cos":
						result = Math.cos(Math.toRadians(result));
						break;
					case "tan":
						result = Math.tan(Math.toRadians(result));
						break;
					case "ln":
						result = Math.log(result);
						break;
					case "√":
						result = Math.sqrt(result);
						break;
					}
					answer = result;
					String answer = String.valueOf(result);					
					screenPanel.setText(answer);
					allowDot = false;
					state = "result";
				}
			});
		}
		
		for(JButton operationButton: keyBoardPanel.getOperationButtons()) {
			operationButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String text=screenPanel.getText();
					String operation = operationButton.getText();
					if(text.length()>0) {
						String lastChar = String.valueOf(text.charAt(text.length()-1));
						if(lastChar.equals("+") || lastChar.equals("-") || lastChar.equals("*") || lastChar.equals("/") || lastChar.equals("^") ) {
							text = text.substring(0, text.length() - 1);
							}
					}
					text = text + operation;
					screenPanel.setText(text);
					allowDot = true;
					state = "operation";
				}
			});
		}
	}
}
