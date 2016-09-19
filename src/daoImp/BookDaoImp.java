package daoImp;

import java.sql.*;
import java.util.*;

import bean.Book;
import dao.BookDao;

public class BookDaoImp implements BookDao {
	String URL = "jdbc:mysql://localhost/cathyebk?autoReconnect=true&useSSL=false";
	String Driver = "com.mysql.jdbc.Driver";
	String username = "root";
	String pass = "qian940712";
	
	@Override
	public List findAllBooks() throws Exception {
		// TODO Auto-generated method stub
		List books = new ArrayList();
		Class.forName(Driver);
		Connection con = DriverManager.getConnection(URL, username, pass);
		String sql = "select id, title, price, faceimg from book";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			Book book = new Book();
			book.setId(new Integer(rs.getString("id")));
			book.setTitle(rs.getString("title"));
			book.setPrice(new Float(rs.getString("price")));
			book.setFaceimg(rs.getString("faceimg"));
			books.add(book);
		}
		return books;
	}

	@Override
	public Book findById(int id) throws Exception {
		// TODO Auto-generated method stub
		Class.forName(Driver);
		Connection con = DriverManager.getConnection(URL, username, pass);
		String sql = "select * from book where id = '" + id + "'";	
		Book book = new Book();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			book.setId(new Integer(rs.getString("id")));
			book.setTitle(rs.getString("title"));
			book.setPrice(new Float(rs.getString("price")));
			book.setFaceimg(rs.getString("faceimg"));
			book.setAuthor(rs.getString("author"));
			book.setAmount(new Integer(rs.getString("amount")));
			book.setDescribe(rs.getString("describe"));
			book.setPublisher(rs.getString("publisher"));
		}
		return book;
	}

}
