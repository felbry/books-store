package servlet;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.ObjectToBean;
import bean.Users;
import dao.UserDao;
import daoImp.UserDaoImp;

public class Login extends HttpServlet{
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String userInfo = request.getParameter("userInfomation");
		ObjectToBean otb = new ObjectToBean();
		Users user = (Users) otb.getObj(userInfo, Users.class);
		
		UserDao userDao = new UserDaoImp();
		try {
			if(userDao.validate(user)) {
				HttpSession session = request.getSession(true);
				session.setAttribute("userInstance", user);	// sessionÖÜÆÚµÄJavabean
				response.getWriter().write("istrue");
				response.getWriter().close();
			}
			response.getWriter().write("isfalse");
			response.getWriter().close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
