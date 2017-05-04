package myclass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
	// kakashi.exeのフルパス
	private String kakasi = "\"C:/kakasi/bin/kakasi\"";

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
				ArrayList<String> rec = new ArrayList<String>();
				// 1行のレコードを取得した
				for(int i = 1; i <= rsmd.getColumnCount(); i++) {
					rec.add(rs.getString( i ));
					String str = rs.getString(i);
					// コマンドプロンプトで実行するDOSコマンド
					String command = "cmd.exe /c echo " + str + " | " + kakasi + " -Ja |"
							+ " " + kakasi + " -Ka | " + kakasi + " -Ha";
					// コマンド実行
					Runtime rt = Runtime.getRuntime();
					Process proc = rt.exec(command);
					// 標準出力の読み込み
					java.io.InputStream is =  proc.getInputStream();
					BufferedReader in = new BufferedReader(new InputStreamReader(is));
					String line = null;
					while ((line = in.readLine()) != null) {
						rec.add(line);
					}
				}
				array.add(rec);
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
