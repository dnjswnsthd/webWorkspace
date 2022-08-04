package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Book;
import servlet.model.BookDAOImpl;

public class AddBookController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.html";
		String isbn = request.getParameter("bookNo1") + "-" + request.getParameter("bookNo2") + "-"
				+ request.getParameter("bookNo3");
		String title = request.getParameter("bookTitle");
		String catalogue = request.getParameter("bookCategory");
		String nation = request.getParameter("bookCountry");
		String publishDate = request.getParameter("bookDate");
		String publisher = request.getParameter("bookPublisher");
		String author = request.getParameter("bookAuthor");
		int price = 0;
		if (!request.getParameter("bookPrice").equals("")) {
			price = Integer.parseInt(request.getParameter("bookPrice"));
		}
		String currency = request.getParameter("bookPrice2");
		String description = request.getParameter("bookSummary");
		try {
			BookDAOImpl.getInstance().addBook(new Book(isbn, title, catalogue, nation, publishDate, publisher, author,
					price, currency, description));
			path = "Book/bookSuccess.jsp";
		} catch (SQLException e) {
			path = "error/error.html";
		}
		return new ModelAndView(path);
	}

}
