package dao;

import java.util.List;

import bean.Book;

public interface BookDao {
	public List findAllBooks() throws Exception;
	public Book findById(int id) throws Exception;
}
