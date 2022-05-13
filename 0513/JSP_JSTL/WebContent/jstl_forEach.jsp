<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
   int sum = 0;
   for(int i=1; i<11; i++){
	   sum+=i;
   }
   out.println(sum);

%>

<hr>

<c:set var="sum" value="0"/>
<c:forEach var="i" begin="1" end="10" step="1" varStatus="status">
	<c:set var="sum" value="${sum+i }"/>
	${status.count } 회 반복 : ${sum }<br>
</c:forEach>
${sum}

<hr>

<%
	List<Integer> intList = new ArrayList<Integer>();
	intList.add(1);
	intList.add(2);
	
	if(intList!=null) for(int k : intList){
		out.println(k);
	}
%>

<hr/>
<c:set var="intList" value="<%=new ArrayList<Integer>() %>"/>
<c:set var ="temp" value="${intList.add(1) }" />
<c:set var ="temp" value="${intList.add(2) }" />

<c:forEach items="${intList }" var="k">
${k }
</c:forEach>




