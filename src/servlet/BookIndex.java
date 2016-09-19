package servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.BookDao;
import daoImp.BookDaoImp;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class BookIndex extends HttpServlet {
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		List books = new ArrayList();
		BookDao bookDao = new BookDaoImp();
		try {
			books = bookDao.findAllBooks();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray booksJson = JSONArray.fromObject(books);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(booksJson.toString());
		response.getWriter().close();
	}
}
