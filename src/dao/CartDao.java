package dao;

import java.util.List;

import bean.CartList;
import bean.OrdersBean;

public interface CartDao {
	public void bookAdd(CartList cart) throws Exception;
	public void bookSubtract(CartList cart) throws Exception;
	public void bookDel(CartList cart) throws Exception;
	public void settlement(OrdersBean order) throws Exception;
	public List findAll(CartList cart) throws Exception;
}
