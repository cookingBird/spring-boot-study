package com.example.www.jdbc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class HelloJDBC {
  static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  static final String USER = "root";
  static final String PASSWORD = "root123";
  static String DB_URL = "jdbc:mysql://localhost/spring_study";

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
//    queryTest();
//    cursorQueryTest();
//    removeTest();
//    batchTest();
    selectTest();
  }

  /**
   * @Description 查询测试
   */
  public static void queryTest() throws ClassNotFoundException, SQLException {
    // 1. 加载数据库驱动
    Class.forName(JDBC_DRIVER);
    Connection conn = null;
    Statement stmt = null;
    ResultSet resultSet = null;
    try {
      System.out.println("DB_URL: " + DB_URL);
      //2.建立数据库链接
      conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
      //3. 执行sql语句；
      stmt = conn.createStatement();
      resultSet = stmt.executeQuery("select * from user");
      //4.循环获取结果
      while (resultSet.next()) {
        System.out.println("Hello " + resultSet.getString(2) + " ID:" + resultSet.getInt(1));
      }
    } finally {
      if (conn != null)
        conn.close();
      if (stmt != null)
        stmt.close();
      if (resultSet != null)
        resultSet.close();
    }
  }

  /**
   * @Description 游标查询测试
   */
  public static void cursorQueryTest() throws ClassNotFoundException, SQLException {
    //1.加载驱动；
    Class.forName(JDBC_DRIVER);
    DB_URL = DB_URL + "?useCursorFetch=true";
    System.out.println("DB_URL: " + DB_URL);
    try (
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        PreparedStatement ps = conn.prepareStatement("select * from user");
    ) {
      ps.setFetchSize(10);
      ResultSet results = ps.executeQuery();
      while (results.next()) {
        System.out.println("Hello " + results.getString("userName") + " ID:" + results.getInt(1));
      }
      results.close();
    }
  }

  /**
   * @Description 批量插入测试
   */
  public static void batchTest() throws SQLException, ClassNotFoundException {
    LinkedList<String> users = new LinkedList<String>();
    users.add("test1");
    users.add("test2");
    users.add("test3");
    users.add("test4");
    users.add("test5");
    users.add("test6");
    users.add("test7");
    users.add("test8");
    users.add("test9");
    insertUsers(users);
  }

  /**
   * @Description 批量插入
   */
  public static void insertUsers(@NotNull LinkedList<String> users) throws SQLException, ClassNotFoundException {
    Class.forName(JDBC_DRIVER);
    try (
        Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        Statement st = con.createStatement();
    ) {
      for (String user : users) {
        System.out.println("addBatch" + user);
        st.addBatch("INSERT INTO user (`userName`) VALUES ('" + user + "')");
      }
      st.executeBatch();
      st.clearBatch();
    }
  }

  /**
   * @Description stream流读取测试
   */
  public static void readStreamTest() {

  }

  /**
   * @Description 删除测试
   */
  public static void removeTest() throws ClassNotFoundException, SQLException {
    Class.forName(JDBC_DRIVER);
    try (
        Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        Statement st = con.createStatement();
    ) {
      st.execute("DELETE FROM user WHERE userName LIKE 'test_'");
    }
  }

  public static void selectTest() throws SQLException {
    //todo mysql8 语法错误
    //System.out.println(getUser("LiSi';--", "12345") != null);
    System.out.println(getUser("LiSi", "12345") != null);
  }

  public static User getUser(@Nullable String username, @Nullable String password) throws SQLException {
    if (username == null || password == null) throw new IllegalArgumentException("缺少必要参数！");
    try (
        Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        Statement st = con.createStatement();
    ) {
      User user = null;
      ResultSet rs = st.executeQuery("select * from user where userName = '" + username + "' and password = '" + password + "'");
      while (rs.next()) {
        user = new User();
        user.setId(rs.getInt(1));
        user.setUserName(rs.getString(2));
        user.setPassword(rs.getString(3));
      }
      return user;
    }
  }
}


class User {
  long id;
  String userName;
  String password;

  public User() {
  }

  public User(long id, String userName, String password) {
    this.id = id;
    this.userName = userName;
    this.password = password;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}