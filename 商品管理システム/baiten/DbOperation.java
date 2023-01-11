package baiten;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DbOperation {


	String url = "jdbc:postgresql://localhost:5432/postgres" ;	//DBのURL
	String user = "postgres" ;		//DBのユーザー名
	String password = "postgrestest" ;	//DBのパスワード
	SimpleDateFormat df = new SimpleDateFormat("yyyy MM dd");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;

	public void dbSalesSelect() {//購入履歴を引っ張って表示

		String sql = "select * from 購入履歴";//テーブル名は後ほど編集

		try{con=DriverManager.getConnection(url, user, password );
		pstmt = con.prepareStatement(sql);  {
			result = pstmt.executeQuery ( sql );

			while(result.next()) {//テーブルの中身
				int col1 = result.getInt(1);
				Date col2 = result.getTimestamp(2);
				String col3 = result.getString(3);
				int col4 = result.getInt(4);
				int col5 = result.getInt(5);
				String col6 = result.getString(6);
				String col7 = result.getString(7);
			}
		}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void dbUserSelect() {//ユーザー管理系を引っ張って表示

		String sql = "select * from ユーザー管理系";//テーブル名は後ほど編集

		try{con=DriverManager.getConnection(url, user, password );
		pstmt = con.prepareStatement(sql);  {
			result = pstmt.executeQuery ( sql );

			while(result.next()) {//テーブルの中身
				int col1 = result.getInt(1);
				String col2 = result.getString(2);
				String col3 = result.getString(3);
				String col4 = result.getString(4);
			}

		}

		}catch (SQLException e) {

			e.printStackTrace();
		}

	}
public void dbUserInsert(int id,String nyuugaku,String name,String seibetu) {
		
		String sql = "INSERT INTO ユーザー管理 values(?, ?, ?, ?)";

		try 
		(Connection con=DriverManager.getConnection(url, user, password ) ;
				PreparedStatement pstmt = con.prepareStatement(sql); ) {
			//？に値をセット
			pstmt.setInt(1,id);//(順番、引数で受け取った値)
			pstmt.setString(2,nyuugaku);
			pstmt.setString(3,name);
			pstmt.setString(4,seibetu);

			pstmt.execute();//実行 
			//Query,update,等用途は様々
			
		} catch ( SQLException e ) {
			e.printStackTrace() ;

		}

	}

}

