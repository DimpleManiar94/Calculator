package calculator;
import javax.swing.*;
import java.awt.*;

public class ScreenPanel extends JPanel {
	private JTextField screen;
	
	public ScreenPanel() {
		addTextField();
	}
	public void addTextField() {
		screen = new JTextField("0");
		screen.setBounds(45, 6, 235, 41);
		this.add(screen);
		screen.setColumns(10);
		screen.setEditable(false);
	}
	
	public String getText() {
		return screen.getText();
	}
	
	public void setText(String result) {
		screen.setText(result);
	}

}
