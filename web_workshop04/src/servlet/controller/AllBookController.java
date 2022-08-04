package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Book;
import servlet.model.BookDAOImpl;

public class AllBookController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.html"; 
		try {
			ArrayList<Book> list = BookDAOImpl.getInstance().allBook();
			path = "Book/bookList.jsp";
			request.setAttribute("list", list);
		} catch (SQLException e) {
			path = "error/error.html";
		}		
		return new ModelAndView(path);
	}

}
