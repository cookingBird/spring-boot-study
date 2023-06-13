package com.example.www.jdbc;

import org.jetbrains.annotations.NotNull;

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
    cursorQueryTest();
//    removeTest();
//    batchTest();
  }


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

  public static void readStreamTest() {

  }

  public static void removeTest() throws ClassNotFoundException, SQLException {
    Class.forName(JDBC_DRIVER);
    try (
        Connection con = DriverManager.getConnection(DB_URL, USER,PASSWORD);
        Statement st = con.createStatement();
        ){
        st.execute("DELETE FROM user WHERE userName LIKE 'test_'");
    }
  }

}
