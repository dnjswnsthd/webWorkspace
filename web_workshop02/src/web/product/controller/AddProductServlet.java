package web.product.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.product.model.Product;
import web.product.model.ProductDAOImpl;

@WebServlet("/AddProduct")
public class AddProductServlet extends HttpServlet {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset-utf-8");
		Product vo = new Product(request.getParameter("name"), Integer.parseInt(request.getParameter("price")), request.getParameter("description"));
		ProductDAOImpl dao = ProductDAOImpl.getInstance();
		try {
			int id = dao.AddPrdouct(vo);
			request.setAttribute("id", id);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.getRequestDispatcher("register_result.jsp").forward(request, response);
	}

}
