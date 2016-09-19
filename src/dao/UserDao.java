package dao;
import bean.Users;

public interface UserDao {
	public void insert(Users user) throws Exception;
	public Boolean validate(Users user) throws Exception;
	public String getId(String u) throws Exception;
}
