package baiten;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class sample extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public sample() {
		
		JButton btnNewButton_2 = new JButton("New button");
		add(btnNewButton_2);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		add(panel);
		
		JButton btnNewButton_1 = new JButton("New button");
		add(btnNewButton_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton);

	}

}
