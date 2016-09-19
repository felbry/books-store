package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrdersBean;
import bean.ObjectToBean;
import dao.OrderDao;
import daoImp.OrderDaoImp;
import net.sf.json.JSONArray;

public class Orders extends HttpServlet {
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		String flags = request.getParameter("flags");
		if(flags.equals("all")) {
			//需要uid
			String order = request.getParameter("order");
			ObjectToBean otb = new ObjectToBean();
			OrdersBean o = (OrdersBean) otb.getObj(order, OrdersBean.class);
			OrderDao orderDao = new OrderDaoImp();
			List orders = new ArrayList();
			try {
				orders = orderDao.findAll(o);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONArray os = JSONArray.fromObject(orders);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(os.toString());
			response.getWriter().close();
		}
		if(flags.equals("detail")) {
			//此方法为get方法
			/*
			RequestDispatcher dispatcher = request.getRequestDispatcher("ordersDetail.jsp");
			dispatcher.forward(request, response);
			*/
		}
		if(flags.equals("getDetail")) {
			String id = request.getParameter("id");
			OrderDao orderDao = new OrderDaoImp();
			OrdersBean o1 = new OrdersBean();
			try {
				o1 = orderDao.getDetail(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONArray o1s = JSONArray.fromObject(o1);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(o1s.toString());
			response.getWriter().close();
		}
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("ordersDetail.jsp");
		dispatcher.forward(request, response);
	}
}
