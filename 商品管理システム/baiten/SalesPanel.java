package baiten;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import baiten.db.DbInfoall;
import baiten.db.DbOperation;



public class SalesPanel extends JPanel  {
	
	private JTable table;
	private JTextField textField;
	private JScrollPane scroll;

	Object[][] aaaaa;

	String[] column = {"共通ID","日付","商品名","個数","合計金額","顧客名","担当者名"};
	/**
	 * Create the panel.
	 */
	public SalesPanel() {
		//リストの取得
		aaaaa = dbSales();
		DefaultTableModel tablemodel = new DefaultTableModel(aaaaa,column);
		table = new JTable(tablemodel);
		table.setFont(new Font("メイリオ", Font.PLAIN, 12));

		JScrollPane sp = new JScrollPane(table);
		sp.setPreferredSize(new Dimension(300,100));

		
		
		textField = new JTextField();
		textField.setFont(new Font("メイリオ", Font.PLAIN, 16));
		textField.setText("◆購入履歴◆");
		textField.setColumns(7);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(10)
										.addComponent(sp, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(46, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(8)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(sp, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(205, Short.MAX_VALUE))
				);
		setLayout(groupLayout);
		

	}
	public  Object[][] dbSales() {//DbGoodsSelectの戻り値受け取り
		DbOperation db = new DbOperation();//DbOperationクラスをnew
		//DBからArrayListの取得
		ArrayList<DbInfoall> sales = db.dbSales();


		//listの内容をObject[][]に変換する
		Object[][] ob = new Object[sales.size()][column.length];
		for(int i=0;i<sales.size();i++) {
			ob[i][0] = sales.get(i).getId();
			ob[i][1] = sales.get(i).getDate();
			ob[i][2] = sales.get(i).getGname();
			ob[i][3] = sales.get(i).getKo();
			ob[i][4] = sales.get(i).getSum();
			ob[i][5] = sales.get(i).getCust();
			ob[i][6] = sales.get(i).getUser();
			
		}

		return ob;

	}
}