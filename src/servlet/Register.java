package servlet;
import bean.ObjectToBean;
import bean.Users;
import dao.UserDao;
import daoImp.UserDaoImp;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import net.sf.json.JSONObject;
public class Register extends HttpServlet{
	
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String userInfo = request.getParameter("userInfomation");
		ObjectToBean otb = new ObjectToBean();
		Users user = (Users) otb.getObj(userInfo, Users.class);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("userInstance", user);	// sessionÖÜÆÚµÄJavabean
		
		UserDao userDao = new UserDaoImp();
		try {
			userDao.insert(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONObject json = new JSONObject();
		if(user != null){
			json.put("user", user.getUsername());
			json.put("password", user.getPassword());
		}
		
		//response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json.toString());
		response.getWriter().close();
		
	}

}