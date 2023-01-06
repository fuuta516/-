package baiten;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private JPanel contentPane;
	JTabbedPane tabbedpane; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedpane = new JTabbedPane();
		JPanel tabPanel1 = new MainPanel();
		JPanel tabPanel2 = new GoodsPanel();
		JPanel tabPanel3 = new UserPanel();
		JPanel tabPanel4 = new SalesPanel();
		
		tabbedpane.addTab("tab1", tabPanel1);
		tabbedpane.addTab("tab2", tabPanel2);
		tabbedpane.addTab("tab3", tabPanel3);
		tabbedpane.addTab("tab4", tabPanel4);
		
		contentPane.add(tabbedpane);
	}

}
