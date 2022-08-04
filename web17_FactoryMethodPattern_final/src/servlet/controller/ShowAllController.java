package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class ShowAllController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		try {
			ArrayList<MemberVO> list = MemberDAOImpl.getInstance().showAllMember();
			path = "AllView.jsp";
			request.setAttribute("list", list);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return new ModelAndView(path);
	}

}
