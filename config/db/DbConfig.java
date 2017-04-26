/**
 *
 */
package db;

import java.sql.Connection;

/**
 * @author ohs60275
 *
 */
public interface DbConfig {

	/**
	 * DB情報を定義するフィールド
	 * public static finalをつけなくても同じ意味として捉えられる
	 */
	String DB_NAME = "taiken";
	String USER_ID = "";
	String USER_PASS = "";
	String JENDI_NAME ="java:comp/env/jdbc/";

	Connection getConnection();
}
