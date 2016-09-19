package daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import bean.Users;
import dao.UserDao;
import java.sql.*;

public class UserDaoImp implements UserDao {
	String URL = "jdbc:mysql://localhost/cathyebk?autoReconnect=true&useSSL=false";
	String Driver = "com.mysql.jdbc.Driver";
	String username = "root";
	String pass = "qian940712";

	@Override
	public void insert(Users user) throws Exception {
		// TODO Auto-generated method stub
		Class.forName(Driver);
		Connection con = DriverManager.getConnection(URL, username, pass);
		String sql = "insert into user(username, password, phone) values('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getTel() + "')";
		Statement stmt = con.createStatement();
		stmt.execute(sql);
	}

	@Override
	public Boolean validate(Users user) throws Exception {
		// TODO Auto-generated method stub
		Class.forName(Driver);
		Connection con = DriverManager.getConnection(URL, username, pass);
		String sql = "select password from user where username = '" + user.getUsername() +"'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		return rs.next() ? (rs.getString(1).equals(user.getPassword()) ? true : false) : false;
	}

	@Override
	public String getId(String u) throws Exception {
		// TODO Auto-generated method stub
		Class.forName(Driver);
		Connection con = DriverManager.getConnection(URL, username, pass);
		String sql = "select id from user where username = '" + u + "'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		String id = "";
		while(rs.next()){
			id = rs.getString("id");
		}
		return id;
	}

}
