package calculator;

import javax.swing.*;
import java.awt.event.*;
;

public class KeyboardPanel extends JPanel {
	
	public KeyboardPanel() {
		addAnswerKeys();
		addKeys();
	}
	
	public void addAnswerKeys() {
		JButton btnAnswer = new JButton("ANSWER");
		btnAnswer.setBounds(44, 160, 117, 40);
		this.add(btnAnswer);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnter.setBounds(160, 160, 117, 40);
		this.add(btnEnter);
	}
	
	public void addKeys() {
		
		// Add all keys here
		JButton btnDot = new JButton(".");
		btnDot.setBounds(42, 120, 40, 40);
		this.add(btnDot);
		
		JButton btn0 = new JButton("0");
		btn0.setBounds(81, 120, 40, 40);
		this.add(btn0);
		
		JButton btnC = new JButton("C");
		btnC.setBounds(120, 120, 40, 40);
		this.add(btnC);
		
		JButton btnStar = new JButton("*");
		btnStar.setBounds(159, 120, 40, 40);
		this.add(btnStar);
		
		JButton btnPi = new JButton("π");
		btnPi.setBounds(198, 120, 40, 40);
		this.add(btnPi);
		
		JButton btnLn = new JButton("ln");
		btnLn.setBounds(237, 120, 40, 40);
		this.add(btnLn);
		
		//Row 2
		
		JButton btn3 = new JButton("3");
		btn3.setBounds(42, 80, 40, 40);
		this.add(btn3);
		
		JButton btn2 = new JButton("2");
		btn2.setBounds(81, 80, 40, 40);
		this.add(btn2);
		
		JButton btn1 = new JButton("1");
		btn1.setBounds(120, 80, 40, 40);
		this.add(btn1);
		
		JButton btnDivide = new JButton("/");
		btnDivide.setBounds(159, 80, 40, 40);
		this.add(btnDivide);
		
		JButton btnE = new JButton("e");
		btnE.setBounds(198, 80, 40, 40);
		this.add(btnE);
		
		JButton btnTan = new JButton("tan");
		btnTan.setBounds(237, 80, 40, 40);
		this.add(btnTan);
		
		//Row 3
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn6.setBounds(42, 40, 40, 40);
		this.add(btn6);
		
		JButton btn5 = new JButton("5");
		btn5.setBounds(81, 40, 40, 40);
		this.add(btn5);
		
		JButton btn4 = new JButton("4");
		btn4.setBounds(120, 40, 40, 40);
		this.add(btn4);
		
		JButton btnMinus = new JButton("-");
		btnMinus.setBounds(159, 40, 40, 40);
		this.add(btnMinus);
		
		JButton btnSqRt = new JButton("√");
		btnSqRt.setBounds(198, 40, 40, 40);
		this.add(btnSqRt);
		
		JButton btnCos = new JButton("cos");
		btnCos.setBounds(237, 40, 40, 40);
		this.add(btnCos);
		
		//Row 4
		
		JButton btn9 = new JButton("9");
		btn9.setBounds(42, 0, 40, 40);
		this.add(btn9);
		
		JButton btn8 = new JButton("8");
		btn8.setBounds(81, 0, 40, 40);
		this.add(btn8);
		
		JButton btn7 = new JButton("7");
		btn7.setBounds(120, 0, 40, 40);
		this.add(btn7);
		
		JButton btnPlus = new JButton("+");
		btnPlus.setBounds(159, 0, 40, 40);
		this.add(btnPlus);
		
		JButton btnPower = new JButton("^");
		btnPower.setBounds(198, 0, 40, 40);
		this.add(btnPower);
		
		JButton btnSin = new JButton("sin");
		btnSin.setBounds(237, 0, 40, 40);
		this.add(btnSin);
	}

}
