package dao;

import java.util.List;

import bean.CartList;
import bean.OrdersBean;

public interface OrderDao {
	public List findAll(OrdersBean order) throws Exception;
	public OrdersBean getDetail(String id) throws Exception;
}
