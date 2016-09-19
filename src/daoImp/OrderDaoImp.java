package daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.CartList;
import bean.OrdersBean;
import dao.OrderDao;

public class OrderDaoImp implements OrderDao {
	String URL = "jdbc:mysql://localhost/cathyebk?autoReconnect=true&useSSL=false";
	String Driver = "com.mysql.jdbc.Driver";
	String username = "root";
	String pass = "qian940712";

	@Override
	public List findAll(OrdersBean order) throws Exception {
		// TODO Auto-generated method stub
		List orders = new ArrayList();
		Class.forName(Driver);
		Connection con = DriverManager.getConnection(URL, username, pass);
		String sql = "select * from orders where uid = " + order.getUid();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			OrdersBean o = new OrdersBean();
			o.setId(new Integer(rs.getString("id")));
			o.setBuyDate(rs.getString("buyDate"));
			o.setTotalPrice(new Float(rs.getString("totalPrice")));
			orders.add(o);
		}
		return orders;
	}

	@Override
	public OrdersBean getDetail(String id) throws Exception {
		// TODO Auto-generated method stub
		Class.forName(Driver);
		Connection con = DriverManager.getConnection(URL, username, pass);
		String sql = "select * from orders where id = " + id;
		OrdersBean o = new OrdersBean();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			o.setId(new Integer(rs.getString("id")));
			o.setBuyDate(rs.getString("buyDate"));
			o.setTotalPrice(new Float(rs.getString("totalPrice")));
			o.setBookDetail(rs.getString("bookDetail"));
			o.setReceiver(rs.getString("receiver"));
			o.setrAddress(rs.getString("rAddress"));
			o.setrPhone(rs.getString("rPhone"));
		}
		return o;
	}
}
