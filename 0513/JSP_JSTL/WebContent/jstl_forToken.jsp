<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String source = "a,b,c,d,e,f,g";

	out.println("String.split():JAVA <br/>");
	String[] split = source.split(",");
	if(split !=null) for(String str : split){
		out.println(str+"<br/>");
	}
	
	out.println("<hr/>");
	out.println("StringTokenizer");
	
	
	StringTokenizer tokens = new StringTokenizer(source,",");
	while(tokens.hasMoreTokens()){
		out.println(tokens.nextToken()+"<br/>");
	}
%>

<hr/>
String.split() : JSTL <br>
<c:set var="source" value="a,b,c,d,e,f,g" />
<c:set var="split" value="${source.split(',')}"/>
<c:forEach items="${split}" var="str">
	${str }<br>
</c:forEach>

<hr/>
StringTokenizer : JSTL<br>
<c:forTokens var="str" items="a,b,c,d,e,f,g" delims="," varStatus="sta">
	${str }<br/>
</c:forTokens>
















