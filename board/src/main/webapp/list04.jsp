<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, board.BBSDTO,board.MemberDDL, board.BBSDDL" %>
<jsp:useBean id="mem" class="board.MemberDDL" scope="page" />
<jsp:useBean id="bto" class="board.BBSDTO" scope="page" />
<%
	//한 페이지에 보여질 게시글 수
	int pagePerCount = 5;
	//request로 넘어오는 페이지 번호 즉 클릭한 페이지 번호
	String cilckedPage = request.getParameter("clickedPage");
	Vector <BBSDTO> bsd = BBSDDL.selectAll();
%>

<div class="container lmember">
   <h2 class="mt-3 mb-5 text-center">자유게시판</h2>
   <div class="row">
      <table class="table table-striped memberstbl">
         <thead>
            <tr>
               <th>게시글번호</th>
               <th>제목</th>
               <th>작성자</th>
               <th>작성일</th>
               <th>조회수</th>
            </tr>
         </thead>
         <tbody>
<%
	for(BBSDTO bd: bsd){
%>
         	<tr>
         		<td><%=bd.getNum() %></td>
         		<td><%=bd.getTitle() %></td>
         		<td><%=bd.getUserid() %></td>
         		<td><%=bd.getWdate() %></td>
         		<td><%=bd.getCount() %></td>
         	</tr>
<%
	}
%>
         </tbody>
       </table>
        <div class="btns text-center">
                <a href="index.jsp?fname=write" id="join">글쓰기</a>
            </div>
    </div>  
</div> 

