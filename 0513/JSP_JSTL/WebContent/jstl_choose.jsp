<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% 
	 int a = 95;
	 
	 if (a > 90) {
	 	out.println("A입니다");
	 } else if (a >80){
		 out.println("B입니다");
	 }else {
		 out.println("C입니다");
	 }
%>
<hr>
<c:set var="a" value="95"/>
<c:choose>
	<c:when test="${a gt 90 }">
		A입니다.
	</c:when>
	<c:when test="${a gt 80 }">
		B입니다.
	</c:when>
	<c:otherwise>
		C입니다.
	</c:otherwise>
</c:choose>