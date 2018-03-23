<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product</title>
</head>
<body>
	<h2><c:out value = "${product.name}"/></h2>
	<p><c:out value = "${product.description}"/></p>
	<p><c:out value = "${product.price}"/></p>
	<p><c:out value = "${product.id}"/></p>
	
	<form method="POST" action="/product/addCategory">
		<input type = "hidden" value = "${product.id}"/>
		<select>
			<c:forEach items = "${categories}" var = "category">
				<option value = "${category.id}">
					<c:out value = "${category.name}"/>
				</option>
			</c:forEach>
		</select>
		<input type = "submit" value = "Submit">
	</form>
</body>
</html>