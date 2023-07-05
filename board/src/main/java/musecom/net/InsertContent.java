package musecom.net;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BBSDDL;


public class InsertContent extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String userid = (String) session.getAttribute("user");
		
		String bbstitle = req.getParameter("bbstitle");
		String bbscontnet = req.getParameter("bbscontent");
		
		boolean isSuccess = BBSDDL.insert(bbstitle, bbscontnet, userid);
	
		if(isSuccess) {
			System.out.println("게시물 인서트 성공");
			res.sendRedirect("index.jsp?fname=list04");
		}else {
			System.out.println("게시물 인서트 실패");
		}
	}

}
