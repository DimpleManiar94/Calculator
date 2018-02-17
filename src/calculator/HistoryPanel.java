package calculator;

import javax.swing.*;
import java.awt.*;

public class HistoryPanel extends JPanel{
	private JButton btnLoad;
	private JList historyList;
	private JLabel lblHistory;
	private DefaultListModel<String> listModel;
	
	
	public HistoryPanel() {
		addKeys();
	}
	
	public void addKeys() {
		btnLoad = new JButton("LOAD");
		btnLoad.setBounds(63, 117, 93, 36);
		this.add(btnLoad);
		
		listModel =new DefaultListModel<String>();
		
		
		historyList = new JList(listModel);
		historyList.setBounds(66, 27, 204, 89);
		this.add(historyList);
		historyList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		historyList.setLayoutOrientation(JList.VERTICAL);
		historyList.setVisibleRowCount(2);
		
		
		/*JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(255, 27, 15, 89);
		this.add(scrollBar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(historyList);
		scrollPane.setBounds(66, 27, 204, 89);
		this.add(scrollPane);*/
		
		lblHistory = new JLabel("History :-");
		lblHistory.setBounds(66, 6, 75, 16);
		this.add(lblHistory);
	}
	
	public void addToHistory(String equation) {
		listModel.addElement(equation);
		
	}

	public void deleteFromHistory() {
		int index = historyList.getSelectedIndex();
		listModel.remove(index);
	}
	
	public JButton getLoadButton() {
		return btnLoad;
	}
	
	public String getEquationOnLoadButtonClick() {
		int index=historyList.getSelectedIndex();
		String equation = listModel.get(index);
		return equation;
	}
	/*public JList getHistoryList() {
		return historyList;
	}*/
	
	

}
