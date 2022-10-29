<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<h3>상품 목록 페이지</h3>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>상품명</th>
				<th>상품가격</th>
				<th>상품수량</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${product}">
				<tr>
					<td>${product.productName}</td>
					<td>${product.productPrice}</td>
					<td>${product.productQty}</td>
					<td>
						<ul class="navbar-nav">
							<li class="nav-item"><a class="nav-link" href="/product/{productId}">상세보기</a></li>
						</ul>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="../layout/footer.jsp"%>