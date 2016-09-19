package daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Book;
import bean.CartList;
import bean.OrdersBean;
import dao.CartDao;

public class CartDaoImp implements CartDao {
	String URL = "jdbc:mysql://localhost/cathyebk?autoReconnect=true&useSSL=false";
	String Driver = "com.mysql.jdbc.Driver";
	String username = "root";
	String pass = "qian940712";
	
	@Override
	public void bookAdd(CartList cart) throws Exception {
		// TODO Auto-generated method stub
		Class.forName(Driver);
		Connection con = DriverManager.getConnection(URL, username, pass);
		String sql = "insert into cart(uid, price, counts, totalprice, bid, title, face) values(?, ?, ?, ?, ?, ?, ?)";
		String sqlUpdate = "update cart set counts = ?, totalprice = ? where id = ?";
		//Find 获取唯一id（uid和bid共同确定）
		String sqlFind = "select * from cart where bid = " + cart.getBid() + " and uid = " + cart.getUid();
				
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlFind);
		if(rs.next()){
			PreparedStatement ps = con.prepareStatement(sqlUpdate);
			int count = Integer.parseInt(rs.getString("counts"));
			int id = Integer.parseInt(rs.getString("id"));
			float price = new Float(rs.getString("price"));
			float totalPrice = new Float(rs.getString("totalprice"));
			ps.setInt(1, count + 1);
			ps.setFloat(2, totalPrice + price);
			ps.setInt(3, id);
			ps.execute();
		} else{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cart.getUid());
			ps.setFloat(2, cart.getPrice());
			ps.setInt(3, cart.getCounts());
			ps.setFloat(4, cart.getTotalPrice());
			ps.setInt(5, cart.getBid());
			ps.setString(6, cart.getTitle());
			ps.setString(7, cart.getFace());
			ps.execute();
		}
	}

	@Override
	public List findAll(CartList cart) throws Exception {
		// TODO Auto-generated method stub
		List cartBooks = new ArrayList();
		Class.forName(Driver);
		Connection con = DriverManager.getConnection(URL, username, pass);
		String sql = "select * from cart where uid = " + cart.getUid();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			CartList cl = new CartList();
			cl.setUid(new Integer(rs.getString("uid")));
			cl.setBid(new Integer(rs.getString("bid")));
			cl.setCounts(new Integer(rs.getString("counts")));
			cl.setTotalPrice(new Float(rs.getString("totalPrice")));
			cl.setTitle(rs.getString("title"));
			cl.setFace(rs.getString("face"));
			cl.setId(new Integer(rs.getString("id")));
			cl.setPrice(new Float(rs.getString("price")));
			cartBooks.add(cl);
		}
		return cartBooks;
	}

	@Override
	public void bookSubtract(CartList cart) throws Exception {
		// TODO Auto-generated method stub
		Class.forName(Driver);
		Connection con = DriverManager.getConnection(URL, username, pass);
		String sqlUpdate = "update cart set counts = ?, totalprice = ? where id = ?";
		//Find 获取唯一id（uid和bid共同确定）
		String sqlFind = "select * from cart where bid = " + cart.getBid() + " and uid = " + cart.getUid();
				
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlFind);
		if(rs.next()){
			PreparedStatement ps = con.prepareStatement(sqlUpdate);
			int count = Integer.parseInt(rs.getString("counts"));
			int id = Integer.parseInt(rs.getString("id"));
			float price = new Float(rs.getString("price"));
			float totalPrice = new Float(rs.getString("totalprice"));
			ps.setInt(1, count - 1);
			ps.setFloat(2, totalPrice - price);
			ps.setInt(3, id);
			ps.execute();
		}
	}

	@Override
	public void bookDel(CartList cart) throws Exception {
		// TODO Auto-generated method stub
		Class.forName(Driver);
		Connection con = DriverManager.getConnection(URL, username, pass);
		String sqlDel = "delete from cart where id = ?";
		String sqlFind = "select * from cart where bid = " + cart.getBid() + " and uid = " + cart.getUid();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlFind);
		while(rs.next()){
			PreparedStatement ps = con.prepareStatement(sqlDel);
			int id = Integer.parseInt(rs.getString("id"));
			ps.setInt(1, id);
			ps.execute();
		}
	}

	@Override
	public void settlement(OrdersBean order) throws Exception {
		// TODO Auto-generated method stub
		Class.forName(Driver);
		Connection con = DriverManager.getConnection(URL, username, pass);
		String sqlSettlement = "delete from cart where uid = " + order.getUid();
		String sqlSettlement2 = "insert into orders(uid, buyDate, totalPrice, receiver, rPhone, rAddress, bookDetail) values(?, ?, ?, ?, ?, ?, ?)";
		//先删除购物车中的有关数据
		Statement stmt = con.createStatement();
		stmt.execute(sqlSettlement);
		//将数据保存在orders表中
		PreparedStatement ps = con.prepareStatement(sqlSettlement2);
		ps.setInt(1, order.getUid());
		ps.setString(2, order.getBuyDate());
		ps.setFloat(3, order.getTotalPrice());
		ps.setString(4, order.getReceiver());
		ps.setString(5, order.getrPhone());
		ps.setString(6, order.getrAddress());
		ps.setString(7, order.getBookDetail());
		ps.execute();
	}

}
