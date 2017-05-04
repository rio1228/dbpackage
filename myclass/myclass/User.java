package myclass;

import java.io.Serializable;

/**
 *
 * @author ohs60275
 *
 */
public class User implements Serializable
{
  private static final long serialVersionUID = 1L;
  /** ユーザ名 */
  private String name;
  /** パスワード */
  private String path;

  /**
   * コンストラクタ
   *
   * @param name
   *          ユーザ名
   * @param path
   *          htmlのファイル名の.htmlより前
   */
  public User(String name, String path)
  {
    this.name = name;
    this.path = path;
  }

  // ---- setter/getter -----
  public String getName()
  {
    return this.name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public String getPath()
  {
    return this.path;
  }
  public void setPath(String path)
  {
	  this.path = path;
  }
}