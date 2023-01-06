package baiten;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ccc extends JPanel{
	private JTextField textField;
	
	Ccc(){
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
		
	}

}
