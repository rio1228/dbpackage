package connect;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import db.DbConfig;

public class ConnectMySQL implements DbConfig{
	private static DataSource ds = null;
	private static Connection con = null;
//	private PreparedStatement ps = null;


	/**
	 *  デフォルトコンストラクタ
	 */
	public ConnectMySQL(){}

	/**
	 * データベース名を固定で使うメソッド。
	 * @return
	 */
	@Override
	public Connection getConnection(){
		// データソースの取得

		try
		{
			InitialContext ctx = new InitialContext();//JNDIで検索をするときの出発点です。ファイルシステムに例えると、ルートディレクトリに相当します。Contextは、ディレクトリに相当します。
			ds = (DataSource)ctx.lookup(JENDI_NAME + DB_NAME);//Contextのlookupというメソッドを使い、"java:comp/env/jdbc/db名"という名前からDataSource型のインスタンスを取得.この名前を「リソース参照名」といいます。Javaのコンポーネントは、"java:comp/env/"という文字列からはじまるリソース参照名を持つように定められています。
			con = ds.getConnection();//DataSource型のインスタンスからConnectionを取得しています。
		}catch (SQLException se) {
			// TODO: handle exception
			se.printStackTrace();
		}catch (NamingException ne) {
			// TODO: handle exception
			ne.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//throw new IllegalStateException(e);
		}
		return con;
	}

	/**
	 * データベース接続を切断する
	 */
	public void close() {
		try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


}
