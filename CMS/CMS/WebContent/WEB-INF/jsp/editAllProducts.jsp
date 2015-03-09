<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="/WEB-INF/jsp/header.jsp"%>
<%@include file="/WEB-INF/jsp/navigation.jsp"%>
	
	
	<br/>
	<br/>
	<div align="center">
		<table border="1" style="width:90%">
		  <tr>
		    <th>Image</th>
		    <th>Price</th>
		    <th>Description</th>
		    <th>Stock Number</th>
		    <th>Availability</th>
		    <th>Edit</th>
		  </tr>
			<c:forEach var="product" items="${prodList}">
				<tr>
					<td><img src='${pageContext.request.contextPath}/showImageByPath.do?imagePath=${product.imagePath}' 
				    	alt='No image found' height='100' width='100' /></td>
				    <td>${product.price}</td>
				    <td>${product.description}</td>
				    <td>${product.stockNumber}</td>
				    <td>${product.availability}</td>
				    <td><a href="${pageContext.request.contextPath}/editSingleProduct.do?productId=${product.productId}">Edit</a></td>
			  	</tr>
			</c:forEach>
		</table>
	
	</div>

<%@include file="/WEB-INF/jsp/footer.jsp"%>