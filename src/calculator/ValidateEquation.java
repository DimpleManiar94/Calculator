package calculator;

import java.util.Stack;

import javax.swing.JOptionPane;

public class ValidateEquation {
	 
	 public static double evaluateExpression(String s) {
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
	        return Double.parseDouble(result);
	 }

}
