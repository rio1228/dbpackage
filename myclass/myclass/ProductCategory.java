package myclass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectMySQL;

public class ProductCategory {
	private Statement stmt;
	private Connection con = null;
	private ConnectMySQL cd = null;

	public ProductCategory(){
		this.cd =  new ConnectMySQL();//データベース接続
		this.con = cd.getConnection();
		try {
			this.stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**
	 *商品一覧をテーブルに持つ
	 * @param sql
	 * @return ArrayList<ArrayList<String>> array
	 */
	public ArrayList<ArrayList<String>> strArray(String sql){

		ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();

		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();//ここ後で調べる
			while(rs.next())
			{
				// 1行のレコードを取得した

				ArrayList<String> rec = new ArrayList<String>();
				for(int i = 1; i <= rsmd.getColumnCount(); i++) {
					rec.add( rs.getString( i ) );
					rec.add( rs.getString( i+1 ) );
				}
				array.add( rec );
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return array;
	}

}
