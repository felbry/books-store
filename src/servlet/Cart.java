package servlet;

import bean.CartList;
import bean.ObjectToBean;
import bean.OrdersBean;
import dao.CartDao;
import daoImp.CartDaoImp;
import net.sf.json.JSONArray;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Cart extends HttpServlet {
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String flags = request.getParameter("flags");
		if(flags.equals("add")){
			String book = request.getParameter("book");
			ObjectToBean otb = new ObjectToBean();
			CartList cartList = (CartList) otb.getObj(book, CartList.class);
			CartDao cartDao = new CartDaoImp();
			try {
				cartDao.bookAdd(cartList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(flags.equals("get")){
			String book = request.getParameter("book");
			ObjectToBean otb = new ObjectToBean();
			CartList cartList = (CartList) otb.getObj(book, CartList.class);
			List booksCart = new ArrayList();
			CartDao cartDao = new CartDaoImp();
			try {
				booksCart = cartDao.findAll(cartList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONArray booksJson = JSONArray.fromObject(booksCart);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(booksJson.toString());
			response.getWriter().close();
		}
		if(flags.equals("subtract")){
			String book = request.getParameter("book");
			ObjectToBean otb = new ObjectToBean();
			CartList cartList = (CartList) otb.getObj(book, CartList.class);
			CartDao cartDao = new CartDaoImp();
			try {
				cartDao.bookSubtract(cartList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().write("subtract successfully");
			response.getWriter().close();
		}
		if(flags.equals("del")){
			String book = request.getParameter("book");
			ObjectToBean otb = new ObjectToBean();
			CartList cartList = (CartList) otb.getObj(book, CartList.class);
			CartDao cartDao = new CartDaoImp();
			try {
				cartDao.bookDel(cartList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().write("del successfully");
			response.getWriter().close();
		}
		if(flags.equals("settlement")){
			String orders = request.getParameter("order");
			ObjectToBean otb = new ObjectToBean();
			OrdersBean order = (OrdersBean) otb.getObj(orders, OrdersBean.class);
			SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			System.out.println(myFmt.format(new Date()));
			order.setBuyDate(myFmt.format(new Date()));
			CartDao cartDao = new CartDaoImp();
			try {
				cartDao.settlement(order);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//重定向到orders.jsp
		}
	}
}
