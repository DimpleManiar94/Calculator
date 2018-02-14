package calculator;

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

public class EquationPanel extends JPanel {
	
	public EquationPanel() {
		addKeys();
	}
	
	public void addKeys() {
		JButton btnLoad = new JButton("LOAD");
		btnLoad.setBounds(63, 117, 93, 36);
		this.add(btnLoad);
		
		JList list = new JList();
		list.setBounds(66, 27, 204, 89);
		this.add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(255, 27, 15, 89);
		this.add(scrollBar);
		
		JLabel lblHistory = new JLabel("History :-");
		lblHistory.setBounds(66, 6, 75, 16);
		this.add(lblHistory);
	}

}
