<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = CmmUtil.nvl((String)session.getAttribute("id"));
%>
<div align="right">
<%if("".equals(id)){ %>
	<form action="/member/loginProc.do" method="post">
		<b>ID</b> <input type="text" name="id" /> 
		<input type="checkbox" name="keep" />로그인 상태 유지 
		<b>PASS</b> <input type="password" name="password" /> 
		<input type="submit" value="로그인" />
	</form>
<%}else{ %>
	<b><%=id + "님 환영합니다." %></b>
<%} %>
</div>