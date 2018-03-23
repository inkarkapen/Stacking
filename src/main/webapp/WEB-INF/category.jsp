<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2><c:out value = "${category.name}"/></h2>
	
	<form method="POST" action="/category/addProduct">
		<input type = "hidden" value = "${category.id}"/>
		<select>
			<c:forEach items = "${products}" var = "product">
				<option value = "${product.id}">
					<c:out value = "${product.name}"/>
				<option>
			</c:forEach>
		</select>
		<input type = "submit" value = "Submit">
	</form>
</body>
</html>