<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>getParameter : ${param.data }</h1>   <!-- request.getParameter("name") 과 같다. -->
	<h1>getAttribute : ${requestScope.data }</h1> <!-- requestScope.id == request.getAttribute("id")  -->
</body>
</html>