package servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import dao.BookDao;
import daoImp.BookDaoImp;
import net.sf.json.JSONObject;

public class BookDetail extends HttpServlet {
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		BookDao bookDao = new BookDaoImp();
		JSONObject bookObj = new JSONObject();
		try {
			bookObj = JSONObject.fromObject(bookDao.findById(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(bookObj.toString());
		response.getWriter().close();
	}
}
