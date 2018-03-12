package calculator;

import java.util.Stack;

import javax.swing.JOptionPane;

public class ValidateEquation {
	 
	public static double evaluateExpression(String s) {
		if (isTrignometricEquation(s)) {
			// This is a trignometric equation. Let's handle it separately
			return evaulateTrignometricExpression(s);
		}
		Stack<Integer> op  = new Stack<Integer>();
		Stack<Double> val = new Stack<Double>();
		Stack<Integer> optmp  = new Stack<Integer>();
		Stack<Double> valtmp = new Stack<Double>();
		String input = "0" + s;
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
			else if (temp != "") {
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
		return Double.parseDouble(result);
	}
	
	/**
	 * Function that implements the evaluation of trignometric equations.
	 * Only determines the type of trig function and delegates to another
	 * function
	 * 
	 * @param equation
	 * @return
	 */
	public static double evaulateTrignometricExpression(String equation ) {
		if (equation.contains("sin")) {
			return evaluateTrignometricExpression("sin", equation);
		}
		if (equation.contains("cosec")) {
			return evaluateTrignometricExpression("cosec", equation);
			
		}
		if (equation.contains("cos")) {
			return evaluateTrignometricExpression("cos", equation);
			
		}
		if (equation.contains("tan")) {
			return evaluateTrignometricExpression("tan", equation);
			
		}
		if (equation.contains("sec")) {
			return evaluateTrignometricExpression("sec", equation);
			
		}
		if (equation.contains("cot")) {
			return evaluateTrignometricExpression("cot", equation);
			
		}
		return evaluateExpression(equation);
	}
	
	/**
	 * Evaluates the trig equation given the trignometric type (sin, cos, etc.)
	 * 
	 * @param trigType
	 * @param equation
	 * @return
	 */
	public static double evaluateTrignometricExpression(String trigType, String equation) {
		// Get the trignometric equation and get it's corresponding trig value
		String expression = getExpressionInTrigEquation(trigType, equation);
		double expressionValue = evaluateExpression(expression);
		double trigValue = getTrignometricValue(trigType, expressionValue);
		
		// Get equation before the trignometric equation, if any
		String beforeExpression = getExpressionBeforeTrig(trigType, equation);
		double beforeValue = 0;
		if (beforeExpression != "") {
			// Get value of that equation
			beforeValue = evaluateExpression(beforeExpression);
			char op = getOperand(trigType, equation);
			// Evaluate the two and return
			return evaluateTwoValues(beforeValue, trigValue, op);
		}
		return trigValue;
	}
	
	/**
	 * Simple switch case to get the value depending on trignometric type (sin, cos, etc)
	 * @param trigType
	 * @param expressionValue
	 * @return
	 */
	private static double getTrignometricValue(String trigType, double expressionValue) {
		if (trigType == "sin") {
			return Math.sin(expressionValue);
		} else if (trigType == "cosec") {
			return 1/Math.sin(expressionValue);
		} else if (trigType == "cos") {
			return Math.cos(expressionValue);
		} else if (trigType == "tan") {
			return Math.tan(expressionValue);
		} else if (trigType == "cot") {
			return 1 / Math.tan(expressionValue);
		} else if (trigType == "sec") {
			return 1 / Math.cos(expressionValue);
		}
		return 1;
	}
	
	/**
	 * Returns the expression within the trig. i.e 
	 * sin(x+2) -> x+2
	 * @param trigType
	 * @param equation
	 * @return
	 */
	private static String getExpressionInTrigEquation(String trigType, String equation) {
		return equation.substring(equation.indexOf(trigType) + trigType.length() + 1, equation.length() - 1);
	}
	
	/**
	 * Returns the expression before trig expression if any
	 * Eg. x*sin(x) -> x
	 * Eg. x^2+sin(x) -> x^2
	 * @param trigType
	 * @param equation
	 * @return
	 */
	private static String getExpressionBeforeTrig(String trigType, String equation) {
		if (equation.indexOf(trigType) > 0) {
			// We do have something before the trig equation
			return equation.substring(0, equation.indexOf(trigType) - 1);
		}
		return "";
	}
	
	/**
	 * Get operand between two equations
	 * Eg. x+sin(x) -> '+'
	 * @param trigType
	 * @param equation
	 * @return
	 */
	private static char getOperand(String trigType, String equation) {
		return equation.charAt(equation.indexOf(trigType) - 1);
	}

	 public static boolean isEquationValid(String equation) {
		 for (int i = 0; i < equation.length(); i++) {
			 char individual = equation.charAt(i);
			 
			 if (individual != 'x' && individual > 96 && individual < 123 && !isTrignometricEquation(equation)) {
				 // We have something like z^2. Invalid
				 return false;
			 }
			 if (individual == 'x') {
				 if (i - 1 > -1) {
					 // Check previous character
					 char previous = equation.charAt(i - 1);
					 if (isNumber(previous)) {
						 // We have something like 3x. That's not valid
						 return false;
					 }
				 }
				 if (i + 1 < equation.length()) {
					 // Check the next character and make sure it's not a number or the same char
					 char next = equation.charAt(i + 1);
					 if (isNumber(next) || next == 'x') {
						 // We have something like 3x or xx. Not valid
						 return false;
					 }
				 }
				 
			 }
		 }
		 
		 return true;
	 }
	 
	 private static boolean isNumber(char character) {
		 try {
			 Integer.parseInt(String.valueOf(character));
			 return true;
		 } catch (Exception e) {
			 // Exception while parsing this character. Must not be a number
			 return false;
		 }
	 }
	 
	 /**
	  * Given two values and an operand, returns the result
	  * @param first
	  * @param second
	  * @param op
	  * @return
	  */
	 private static double evaluateTwoValues(double first, double second, char op) {
		 switch(op) {
		 	case '+':
		 		return first + second;
		 	case '*':
		 		return first*second;
		 	case '-':
		 		return first - second;
		 	case '/':
		 		return first/second;
		 	default: return first;
		 }
	 }
	 
	 /**
	  * Check if equation is trignometric or not
	  * @param equation
	  * @return
	  */
	 private static boolean isTrignometricEquation(String equation) {
		 return equation.contains("sin") || equation.contains("cos") || equation.contains("tan") || equation.contains("cot")
				 || equation.contains("sec") || equation.contains("cosec");
	 }
	 

}
