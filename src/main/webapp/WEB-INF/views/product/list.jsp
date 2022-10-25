<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록보기</title>
</head>
<body>
	<table border="1"  align="center">
	<caption>상품 목록 페이지</caption>
		<thead>
			<tr>
				<th>상품명</th>
				<th>상품가격</th>
				<th>상품수량</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product"  items="${product}">
				<tr>
					<td>${product.productName}</td>
					<td>${product.productPrice}</td>
					<td>${product.productPrice}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>