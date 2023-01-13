package baiten;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import baiten.db.DbInfoall;
import baiten.db.DbOperation;

public class CustPanel extends JPanel {

	//フィールド
	private JTable table;
	private JPanel contentPane;
	private JScrollPane scroll;
	ButtonGroup bg;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;
	private int id;//ID

	Object[][] aaaaa;

	String[] column = {"共通ID","入学年月","購入者名","性別"};//[列]
	private JTextField textField_3;


	/**
	 * Create the panel.
	 */
	public CustPanel() {
		
		//リストの取得
		aaaaa = DbCusta();
		DefaultTableModel tablemodel = new DefaultTableModel(aaaaa,column);
		table = new JTable(tablemodel);
		table.setFont(new Font("メイリオ", Font.PLAIN, 12));
		
		JScrollPane sp = new JScrollPane(table);
		sp.setPreferredSize(new Dimension(300,100));
	
		textField_3 = new JTextField();
		textField_3.setFont(new Font("メイリオ", Font.PLAIN, 16));
		textField_3.setText("◆顧客名管理◆");
		textField_3.setColumns(8);


		//入力欄
		JLabel lblNewLabel_1_1 = new JLabel("入学年月");
		JLabel lblNewLabel_1_1_1 = new JLabel("名前");
		JLabel lblNewLabel_1_1_2 = new JLabel("性別");

		//入学年月を入力
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		String nyuugaku = textField_2.getText();

		//名前を入力
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		String name = textField_1.getText();

		//性別を選択(ラジオボタン)
		JRadioButton rdbtnNewRadioButton = new JRadioButton("男");
		contentPane.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("女");
		contentPane.add(rdbtnNewRadioButton_1);

		//グループ化(ラジオボタン)
		bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);


		//実行ボタン
		JButton btnNewButton = new JButton("実行");
		//
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DbOperation db = new DbOperation();
				String ad = textField.getText();
				String cust =textField_1.getText();

				boolean status = rdbtnNewRadioButton.isSelected();
				boolean status2 = rdbtnNewRadioButton_1.isSelected();
				String gen = "";
				if(status) {
					gen="男性";

				}else if(status2) {
					gen="女性";
				}

				int id=3;

				db.dbCustIn(id,ad,cust,gen);
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(29, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(sp, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE))
							.addGap(27))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(47))))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtnNewRadioButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(211, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(sp, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_2)
						.addComponent(rdbtnNewRadioButton)
						.addComponent(rdbtnNewRadioButton_1))
					.addGap(22)
					.addComponent(btnNewButton)
					.addContainerGap(68, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

	//ArrayLIst→Objectに変換する
	public  Object[][] DbCusta() {//DbCustの戻り値受け取り
		DbOperation db = new DbOperation();//DbOperationクラスをnew
		//DBからArrayListの取得
		ArrayList<DbInfoall> cust1 = db.dbCust();


		//listの内容をObject[][]に変換する
		Object[][] ob = new Object[cust1.size()][column.length];
		//リストでループ処理
		for(int i=0; i<cust1.size(); i++) {
			ob[i][0] = cust1.get(i).getId();
			ob[i][1] = cust1.get(i).getAd();
			ob[i][2] = cust1.get(i).getCust();
			ob[i][3] = cust1.get(i).getGen();

		}


		return ob;

	}
}
