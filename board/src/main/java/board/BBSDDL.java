package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class BBSDDL {
	public static boolean insert(String bbstitle, String content, String userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		int flag = 0;
		String sql = "insert into bbs_content (title, content, userid) "
				+ "values (?, ?, ?)";
		
		try {
			conn = new DBConnect().getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, bbstitle);
			ps.setString(2, content);
			ps.setString(3, userid);
			flag =ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(ps != null) ps.close();
				
			}catch(SQLException e) {}
		}
		
		if(flag > 0) {
			return true;
		}else {
			return false;
		}
	}

	public static Vector <BBSDTO> selectAll(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from bbs_content";
			
		BBSDTO dto = new BBSDTO();
		Vector <BBSDTO> data = new Vector <BBSDTO> ();
		try {
			conn = new DBConnect().getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				dto.setUserid(rs.getString("userid"));
				dto.setWdate(rs.getString("wdate"));
				dto.setCount(rs.getInt("count"));
				data.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(ps != null) ps.close();
				
			}catch(SQLException e) {}
		}
		
		return data;
	}
}
