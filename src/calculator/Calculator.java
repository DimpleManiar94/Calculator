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
		initHistoryListeners();
		initKeyboardListeners();
			
	}
	
	private void initEquationListeners() {
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
		
	}
	
	private void initHistoryListeners() {
		historyPanel.getLoadButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String equation = historyPanel.getEquationOnLoadButtonClick();
				equation = equation.substring(11, equation.length());
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
					double result = Double.parseDouble(evaluateExpression(text));					
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
	
	public String evaluateExpression(String equation) {
		Stack<Integer> op  = new Stack<Integer>();
        Stack<Double> val = new Stack<Double>();
        Stack<Integer> optmp  = new Stack<Integer>();
        Stack<Double> valtmp = new Stack<Double>();
        String input = "0" + equation;
        input = input.replaceAll("-","+-");
        /* Store operands and operators in respective stacks */
        String temp = "";
        for (int i = 0;i < input.length();i++)
        {
            char ch = input.charAt(i);
            if (ch == '-')
                temp = "-" + temp;
            else if (ch != '+' &&  ch != '*' && ch != '/' && ch !='^')
               temp = temp + ch;
            else
            {
                val.push(Double.parseDouble(temp));
                op.push((int)ch);
                temp = "";
            }
        }
        val.push(Double.parseDouble(temp));
        /* Create char array of operators as per precedence */
        /* -ve sign is already taken care of while storing */
        char operators[] = {'^', '/','*','+'};
        /* Evaluation of expression */
        for (int i = 0; i < 4; i++)
        {
            boolean it = false;
            while (!op.isEmpty())
            {
                int optr = op.pop();
                double v1 = val.pop();
                double v2 = val.pop();
                if (optr == operators[i])
                {
                    /* if operator matches evaluate and store in temporary stack */
                	if( i == 0) {
                		valtmp.push(Math.pow(v2, v1));
                		it = true;
                		break;
                	}
                	else  if (i == 1)
                    {
                        valtmp.push(v2 / v1);
                        it = true;
                        break;
                    }
                    else if (i == 2)
                    {
                        valtmp.push(v2 * v1);
                        it = true;
                        break;
                    }
                    else if (i == 3)
                    {
                        valtmp.push(v2 + v1);
                        it = true;
                        break;
                    }                                        
                }
                else
                {
                    valtmp.push(v1);
                    val.push(v2);
                    optmp.push(optr);
                }                
            }    
            /* Push back all elements from temporary stacks to main stacks */            
            while (!valtmp.isEmpty())
                val.push(valtmp.pop());
            while (!optmp.isEmpty())
                op.push(optmp.pop());
            /* Iterate again for same operator */
            if (it)
                i--;                            
        }  
        String result = val.pop().toString();
        return result;
        
	}
}
