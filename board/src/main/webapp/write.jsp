<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, board.BBSDTO" %>
<div class="container lmember">
   <h2 class=" mt-3 mb-5 text-center">자유게시판</h2>
   <form action="/board/InsertContent" method="Post">
         <table class="table table-striped memberstbl">
			<tbody>
				<tr>
	               <td><input type="text" class="form-control" placeholder="글 제목" name="bbstitle" /></td>
				</tr>
				<tr>	
					<td><textarea type="text" class="form-control ttbox" placeholder="글 내용" name="bbscontent"></textarea></td>
	            </tr>	            
			</tbody>
   		</table>
   		<div class="text-center">
   			<input type="submit" class="btn btn-primary pull-right" value="글쓰기">
   		</div>
   		
   </form>
</div>