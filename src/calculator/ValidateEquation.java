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
			else if (temp != "")
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
		return Double.parseDouble(result);
	}
	
	public static double evaulateTrignometricExpression(String equation ) {
		if (equation.contains("sin")) {
			String expression = getExpressionInTrigEquation("sin", equation);
			double expressionValue = evaluateExpression(expression);
			return Math.sin(expressionValue);
			
		}
		if (equation.contains("cosec")) {
			String expression = getExpressionInTrigEquation("cosec", equation);
			double expressionValue = evaluateExpression(expression);
			return 1 / Math.cos(expressionValue);
			
		}
		if (equation.contains("cos")) {
			String expression = getExpressionInTrigEquation("cos", equation);
			double expressionValue = evaluateExpression(expression);
			return Math.cos(expressionValue);
			
		}
		if (equation.contains("tan")) {
			String expression = getExpressionInTrigEquation("tan", equation);
			double expressionValue = evaluateExpression(expression);
			return Math.tan(expressionValue);
			
		}
		if (equation.contains("sec")) {
			String expression = getExpressionInTrigEquation("sec", equation);
			double expressionValue = evaluateExpression(expression);
			return 1 / Math.sin(expressionValue);
			
		}
		if (equation.contains("cot")) {
			String expression = getExpressionInTrigEquation("cot", equation);
			double expressionValue = evaluateExpression(expression);
			return 1 / Math.tan(expressionValue);
			
		}
		return evaluateExpression(equation);
	}
	
	private static String getExpressionInTrigEquation(String trigType, String equation) {
		// All trig functions are 3 letter. Eg. sin, cos, tan, sec, cosec, 
		return equation.substring(trigType.length() + 1, equation.length() - 1);
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
	 
	 private static boolean isTrignometricEquation(String equation) {
		 return equation.contains("sin") || equation.contains("cos") || equation.contains("tan") || equation.contains("cot")
				 || equation.contains("sec") || equation.contains("cosec");
	 }
	 

}
