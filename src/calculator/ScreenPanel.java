package calculator;
import javax.swing.*;
import java.awt.*;

public class ScreenPanel extends JPanel {
	public ScreenPanel() {
		addTextField();
	}
	public void addTextField() {
		 JTextField textField = new JTextField();
		textField.setBounds(45, 6, 235, 41);
		this.add(textField);
		textField.setColumns(10);
	}

}
