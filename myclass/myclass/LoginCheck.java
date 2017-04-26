/**
 *
 */
package myclass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connect.ConnectMySQL;

/**
 * @author ohs60275
 *
 */
public class LoginCheck {

	private Statement stmt;
	private Connection con = null;
	private ConnectMySQL cd = null;
	private static final String USER_ID_COLUMN = "k_id";
	private static final String USER_PASS_COLUMN = "k_pass";
	private static final String USER_NAME_COLUMN = "k_name";
	private static final String USER_INFO_TBL = "kyak";

	/**
	 * コンストラクタ
	 */
	public LoginCheck(){
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
	 *
	 * @param user_id
	 * @param pass
	 * @return result
	 */
	public boolean isNotNull(String user_id,String pass){
		boolean result = false;//初期値をfalseに設定

		if(!"".equals(user_id) && !"".equals(pass)){//user情報は空白でもなくnullでもないか
			result = true;
		}
//		}else if("".equals(user_id)){//user_idが空白ではない
//
//		}
		return result;

	}
	/**
	 * isExistメソッドは送られてきたユーザーIDとパスワードが一致するのかを調べるメソッド
	 * @param user_id
	 * @param pass
	 * @return true
	 */
	public String userName(String user_id,String pass){
		String user_name = null;
		ResultSet rs = null;
		String sql = " SELECT"+ USER_NAME_COLUMN +"FROM "+ USER_INFO_TBL +" WHERE "+ USER_ID_COLUMN +"  = " + user_id + USER_PASS_COLUMN + "="+pass;

			boolean is_sql = this.isSqlExist(sql);
			if(is_sql){
				try {
					rs = stmt.executeQuery(sql);
					if (rs.next()){user_name = rs.getString(USER_NAME_COLUMN);}
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}finally {
					try {
						stmt.close();
						this.cd.close();
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}

			}else{
				user_name = "not auth";
			}
		return user_name;
	}

	/**
	 * isExsistメソッドは送られてきたSQL文の中身が存在すればtrueを返すメソッド
	 * @param sql
	 * @return result
	 */
	private boolean isSqlExist(String sql){

		ResultSet rs = null;
		boolean result = false;
		try {
			rs = stmt.executeQuery(sql);
			if (rs.next()){result = true;}
		}catch (SQLException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
