package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Book;
import servlet.model.BookDAOImpl;

@WebServlet("/book.do")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		String path = "index.html";
		if (command.equals("addBook")) {
			path = addBook(request, response);
		} else if (command.equals("allBook")) {
			path = allBook(request, response);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	private String addBook(HttpServletRequest request, HttpServletResponse response) {
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
		return path;
	}

	private String allBook(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.html"; 
		try {
			ArrayList<Book> list = BookDAOImpl.getInstance().allBook();
			path = "Book/bookList.jsp";
			request.setAttribute("list", list);
		} catch (SQLException e) {
			path = "error/error.html";
		}		
		return path;
	}
}
