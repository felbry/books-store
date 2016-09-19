package servlet;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.ObjectToBean;
import bean.Users;
import dao.UserDao;
import daoImp.UserDaoImp;

public class LoginOut extends HttpServlet{
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession(true);
		session.removeAttribute("userInstance");	// sessionÖÜÆÚµÄJavabean
		response.sendRedirect("login.jsp");
	}
}
