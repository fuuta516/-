package baiten.db;
//ふじいです＾＾このクラスはそれぞれのテーブルに指示を飛ばして実行するヤツです。
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DbOperation {
	String url = "jdbc:postgresql://localhost:5432/postgres" ;	//DBのURL
	String user = "postgres" ;		//DBのユーザー名
	String password = "postgrestest" ;	//DBのパスワード
	SimpleDateFormat df = new SimpleDateFormat("yyyy MM dd");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;

	//-------------------------------------------------------------------------------------------------

	public ArrayList<DbInfoall> dbSales(){//購入履歴
		ArrayList<DbInfoall> a = new ArrayList<>();
		String sql = "select * from 購入履歴";

		try{con=DriverManager.getConnection(url, user, password );
		pstmt = con.prepareStatement(sql);  {
			result = pstmt.executeQuery ();

			while(result.next()) {
				int col1 = result.getInt(1);
				Date col2 = result.getDate(2);
				String col3 = result.getString(3);
				int col4 = result.getInt(4);
				int col5 = result.getInt(5);
				String col6 = result.getString(6);
				String col7 = result.getString(7);
				a.add(new DbInfoall(col1,col2,col3,col4,col5,col6,col7));
			}
		}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return a;
	}

	//-------------------------------------------------------------------------------------------------

	public ArrayList<DbInfoall> dbGoods() {//商品一覧表示

		ArrayList<DbInfoall> a = new ArrayList<>();

		String sql = "select * from 商品一覧";

		try{con=DriverManager.getConnection(url, user, password );
		pstmt = con.prepareStatement(sql);  {
			result = pstmt.executeQuery ();

			while(result.next()) {//テーブルの中身

				int col1 = result.getInt(1);
				String col2 = result.getString(2);
				int col3 = result.getInt(3);
				String col4 = result.getString(4);
				a.add(new DbInfoall(col1,col2,col3,col4));
			}
		}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return a;
	}
	
	public ArrayList<DbInfoall> dbGoodsonly() {//商品一覧表示

		ArrayList<DbInfoall> a = new ArrayList<>();

		String sql = "select 商品名 from 商品一覧";

		try{con=DriverManager.getConnection(url, user, password );
		pstmt = con.prepareStatement(sql);  {
			result = pstmt.executeQuery ();

			while(result.next()) {//テーブルの中身

				String col1 = result.getString(1);
				
				a.add(new DbInfoall(col1));
			}
		}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return a;
	}

	public void dbGoodsIn(int id,String gname,int price,String cat){//商品一覧追加
		String sql = "insert into 商品一覧(共通id,商品名,価格,カテゴリー) = (?,?,?,?)";

		try(Connection con=DriverManager.getConnection(url, user, password );
				PreparedStatement pstmt = con.prepareStatement(sql); ) {

			pstmt.setInt(1,id);
			pstmt.setString(2,gname);
			pstmt.setInt(3,price);
			pstmt.setString(4,cat);

			pstmt.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	//-------------------------------------------------------------------------------------------------

	public ArrayList<DbInfoall> dbCashRegi() {//レジ

		ArrayList<DbInfoall> a = new ArrayList<>();

		String sql = "select * from レジ";

		try{con=DriverManager.getConnection(url, user, password );
		pstmt = con.prepareStatement(sql);  {
			result = pstmt.executeQuery ();

			while(result.next()) {//テーブルの中身

				Date col1 = result.getDate(1);
				String col2 = result.getString(2);
				String col3 = result.getString(3);
				String col4 = result.getString(4);

				a.add(new DbInfoall(col1,col2,col3,col4));
			}
		}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return a;
	}

	public void dbCashRegiIn(Date date,String user,String cust,String gname){//レジ追加
		String sql = "insert into レジ(日付,担当,顧客名,商品名) values (?,?,?,?)";

		try(Connection con=DriverManager.getConnection(url, user, password );
				PreparedStatement pstmt = con.prepareStatement(sql); ) {

			pstmt.setDate(1,date);
			pstmt.setString(2,user);
			pstmt.setString(3,cust);
			pstmt.setString(4,gname);

			pstmt.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	//-------------------------------------------------------------------------------------------------

	public ArrayList<DbInfoall> dbStock() {//在庫数

		ArrayList<DbInfoall> a = new ArrayList<>();

		String sql = "select * from 在庫数";

		try{con=DriverManager.getConnection(url, user, password );
		pstmt = con.prepareStatement(sql);  {
			result = pstmt.executeQuery ();

			while(result.next()) {//テーブルの中身

				int col1 = result.getInt(1);
				String col2 = result.getString(2);
				int col3 = result.getInt(3);

				a.add(new DbInfoall(col1,col2,col3));
			}
		}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return a;
	}

	public void dbStockIn(int id,String gname,int stock){//在庫数追加
		String sql = "insert into 商品一覧(共通id,商品名,在庫数) values (?,?,?)";

		try(Connection con=DriverManager.getConnection(url, user, password );
				PreparedStatement pstmt = con.prepareStatement(sql); ) {

			pstmt.setInt(1,id);
			pstmt.setString(2,gname);
			pstmt.setInt(3,stock);

			pstmt.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void dbStockUp(int id,String gname,int stock){//在庫数更新
		String sql = "update 在庫数 set 在庫数 = ? where 商品名 = ?";

		try(Connection con=DriverManager.getConnection(url, user, password );
				PreparedStatement pstmt = con.prepareStatement(sql); ) {

			pstmt.setInt(1,stock);
			pstmt.setString(2,gname);
		
			pstmt.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	//-------------------------------------------------------------------------------------------------

	public ArrayList<DbInfoall> dbCust() {//顧客名管理

		ArrayList<DbInfoall> a = new ArrayList<>();

		String sql = "select * from 顧客名管理";

		try{con=DriverManager.getConnection(url, user, password );
		pstmt = con.prepareStatement(sql);  {
			result = pstmt.executeQuery ();

			while(result.next()) {//テーブルの中身

				int col1 = result.getInt(1);
				String col2 = result.getString(2);
				String col3 = result.getString(3);
				String col4 = result.getString(4);

				a.add(new DbInfoall(col1,col2,col3,col4));
			}
		}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return a;
	}

	public void dbCustIn(int id,String ad,String cust,String gen){//顧客名追加
		String sql = "insert into 商品一覧(共通id,入学年月,顧客名,性別) values (?,?,?,?)";

		try(Connection con=DriverManager.getConnection(url, user, password );
				PreparedStatement pstmt = con.prepareStatement(sql); ) {

			pstmt.setInt(1,id);
			pstmt.setString(2,ad);
			pstmt.setString(3,cust);
			pstmt.setString(4,gen);

			pstmt.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}