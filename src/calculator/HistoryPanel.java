package calculator;

import javax.swing.*;
import java.awt.*;

public class HistoryPanel extends JPanel{
	public HistoryPanel() {
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
