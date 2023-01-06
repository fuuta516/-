package baiten;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class aaaa extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public aaaa() {
		
		JButton btnNewButton = new JButton("ぼたん");
		add(btnNewButton);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);

	}
	
	

}
