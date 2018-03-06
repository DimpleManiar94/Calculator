package calculator;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
;

public class KeyboardPanel extends JPanel {
	private JButton btnAnswer;
	private JButton btnEnter;
	
	private JButton btnDot;
	private JButton btn0;
	private JButton btnC;
	private JButton btnStar;
	private JButton btnPi;
	private JButton btnLn;
	
	private JButton btn3;
	private JButton btn2;
	private JButton btn1;
	private JButton btnDivide;
	private JButton btnE;
	private JButton btnTan;
	
	private JButton btn6;
	private JButton btn5;
	private JButton btn4;
	private JButton btnMinus;
	private JButton btnSqRt;
	private JButton btnCos;
	
	private JButton btn9;
	private JButton btn8;
	private JButton btn7;
	private JButton btnPlus;
	private JButton btnPower;
	private JButton btnSin;
	
	ArrayList<JButton> numberButtonList;
	ArrayList<JButton> operationButtonList;
	ArrayList<JButton> resultOperations;
	ArrayList<JButton> valueButtons;
	
	public KeyboardPanel() {
		addAnswerKeys();
		addKeys();
	}
	
	public void addAnswerKeys() {
		btnAnswer = new JButton("ANSWER");
		btnAnswer.setBounds(44, 160, 117, 40);
		this.add(btnAnswer); //handle case
		valueButtons = new ArrayList<JButton>(3);
		valueButtons.add(btnAnswer);
		
		btnEnter = new JButton("ENTER");
		btnEnter.setBounds(160, 160, 117, 40);
		this.add(btnEnter);
		resultOperations = new ArrayList<JButton>(10);
		resultOperations.add(btnEnter);
	}
	
	public void addKeys() {
		
		// Add all keys here
		btnDot = new JButton(".");
		btnDot.setBounds(42, 120, 40, 40);
		this.add(btnDot); //Handle case
		
		btn0 = new JButton("0");
		btn0.setBounds(81, 120, 40, 40);
		this.add(btn0);
		numberButtonList = new ArrayList<JButton>(10);
		numberButtonList.add(btn0);
		
		btnC = new JButton("C");
		btnC.setBounds(120, 120, 40, 40);
		this.add(btnC);
		
		btnStar = new JButton("*");
		btnStar.setBounds(159, 120, 40, 40);
		this.add(btnStar);
		operationButtonList = new ArrayList<JButton>(10);
		operationButtonList.add(btnStar);
		
		btnPi = new JButton("π");
		btnPi.setBounds(198, 120, 40, 40);
		this.add(btnPi);
		//numberButtonList.add(btnPi); //Special case
		valueButtons.add(btnPi);
		
		btnLn = new JButton("ln");
		btnLn.setBounds(237, 120, 40, 40);
		this.add(btnLn);
		resultOperations.add(btnLn);
		
		//Row 2
		
		btn3 = new JButton("3");
		btn3.setBounds(42, 80, 40, 40);
		this.add(btn3);
		numberButtonList.add(btn3);
		
		btn2 = new JButton("2");
		btn2.setBounds(81, 80, 40, 40);
		this.add(btn2);
		numberButtonList.add(btn2);
		
		btn1 = new JButton("1");
		btn1.setBounds(120, 80, 40, 40);
		this.add(btn1);
		numberButtonList.add(btn1);
		
		btnDivide = new JButton("/");
		btnDivide.setBounds(159, 80, 40, 40);
		this.add(btnDivide);
		operationButtonList.add(btnDivide);
		
		btnE = new JButton("e");
		btnE.setBounds(198, 80, 40, 40);
		this.add(btnE);
		valueButtons.add(btnE);
		//numberButtonList.add(btnE); //Special case
		
		btnTan = new JButton("tan");
		btnTan.setBounds(237, 80, 40, 40);
		this.add(btnTan);
		resultOperations.add(btnTan);
		
		//Row 3
		
		btn6 = new JButton("6");
		btn6.setBounds(42, 40, 40, 40);
		this.add(btn6);
		numberButtonList.add(btn6);
		
		btn5 = new JButton("5");
		btn5.setBounds(81, 40, 40, 40);
		this.add(btn5);
		numberButtonList.add(btn5);
		
		btn4 = new JButton("4");
		btn4.setBounds(120, 40, 40, 40);
		this.add(btn4);
		numberButtonList.add(btn4);
		
		btnMinus = new JButton("-");
		btnMinus.setBounds(159, 40, 40, 40);
		this.add(btnMinus);
		operationButtonList.add(btnMinus);
		
		btnSqRt = new JButton("√");
		btnSqRt.setBounds(198, 40, 40, 40);
		this.add(btnSqRt);
		resultOperations.add(btnSqRt);
		
		btnCos = new JButton("cos");
		btnCos.setBounds(237, 40, 40, 40);
		this.add(btnCos);
		resultOperations.add(btnCos);
		
		//Row 4
		
		btn9 = new JButton("9");
		btn9.setBounds(42, 0, 40, 40);
		this.add(btn9);
		numberButtonList.add(btn9);
		
		btn8 = new JButton("8");
		btn8.setBounds(81, 0, 40, 40);
		this.add(btn8);
		numberButtonList.add(btn8);
		
		btn7 = new JButton("7");
		btn7.setBounds(120, 0, 40, 40);
		this.add(btn7);
		numberButtonList.add(btn7);
		
		btnPlus = new JButton("+");
		btnPlus.setBounds(159, 0, 40, 40);
		this.add(btnPlus);
		operationButtonList.add(btnPlus);
		
		btnPower = new JButton("^");
		btnPower.setBounds(198, 0, 40, 40);
		this.add(btnPower);
		operationButtonList.add(btnPower);
		
		btnSin = new JButton("sin");
		btnSin.setBounds(237, 0, 40, 40);
		this.add(btnSin);
		resultOperations.add(btnSin);
	}
	
	public ArrayList<JButton> getNumberButtons() {
		return numberButtonList;
	}
	
	public ArrayList<JButton> getOperationButtons(){
		return operationButtonList;
	}
	
	public ArrayList<JButton> getresultOperations(){
		return resultOperations;
	}
	
	public JButton getClearButton() {
		return btnC;
	}
	
	public JButton getDotButton() {
		return btnDot;
	}
	
	public ArrayList<JButton> getValueButtons(){
		return valueButtons;
	}
	
	

}
