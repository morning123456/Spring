<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	Date today = new Date();
	out.println(today+"<br/>");
	String todayStr
		= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(today);
	out.println(todayStr);
%>

<c:set var="today" value="<%=new Date() %>"/> <br>
<fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm:ss"/>