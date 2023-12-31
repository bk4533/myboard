package musecom.net;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.MemberDDL;
import board.MembersDTO;

public class MembersOk extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		MembersDTO dto = new MembersDTO();
		MemberDDL ddl = new MemberDDL();
		
		String ip = req.getRemoteAddr();
	      //업로드 설정
	      //1.업로드 경로
	    String dir = req.getSession().getServletContext().getRealPath("/upload/users");

		
		
	    //2. 업로드 파일 용량 설정 - 최대 10메가
	      int max = 10 * 1024 * 1024;
	      try {
	         MultipartRequest m = new MultipartRequest(req, dir, max, "UTF-8",
	         new DefaultFileRenamePolicy());
	         
	         String photo = m.getFilesystemName("photo");
	         dto.setUserid(m.getParameter("userid"));
	         dto.setUserpass(m.getParameter("userpass"));
	         dto.setUsername(m.getParameter("username"));
	         dto.setUseremail(m.getParameter("useremail"));
	         dto.setPostcode(Integer.parseInt(m.getParameter("postcode")));
	         dto.setAddr(m.getParameter("addr"));
	         dto.setDetailaddr(m.getParameter("detailaddr"));
	         dto.setTel(m.getParameter("tel"));
	         dto.setUip();
	         dto.setPhoto(m.getFilesystemName("photo"));
	    }catch(Exception e) {
	    	
	    }
		
	    boolean isSuccess = ddl.insert(dto);
		if(isSuccess) {
			System.out.println("인서트 성공");
		}else {
			System.out.println("인서트 실패");
		}
		doGet(req, res);
	}
	

}
