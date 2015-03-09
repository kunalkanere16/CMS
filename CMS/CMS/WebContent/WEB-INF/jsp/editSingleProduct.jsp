<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/jsp/header.jsp"%>
<%@include file="/WEB-INF/jsp/navigation.jsp"%>
	
	
<br/>
<br/>

<form:form modelAttribute="product"  method="post" 
	action="updateProduct.do" enctype="multipart/form-data">	
	<div align="center">
		<img src='${pageContext.request.contextPath}/showImageByPath.do?imagePath=${product.imagePath}' 
				    	alt='No image found' height='100' width='100' />
		
		<br/>
		<br/>
		<form:hidden path="productId" id="productId" />
		<form:hidden path="name" id="name" />
		<form:hidden path="imagePath" id="imagePath" />
		<br/>
		<table>
			<tr>
				<td width="132px"><form:label path="imageData" >New image</form:label></td>
				<td><form:input path="imageData" type="file"/><br/>
	    			<font style="color: #C11B17;"><form:errors path="imageData"/></font>
	    		</td>
			</tr>
			<tr>
				<td><form:label path="price" >* Price</form:label></td>
				<td><form:input path="price"/><br/>
					<font style="color: #C11B17;"><form:errors path="price"/></font>
				</td>
			</tr>
			<tr>
				<td><form:label path="description" >* Description</form:label></td>
				<td><form:textarea path="description" rows="6" cols="40"/><br/>
					<font style="color: #C11B17;"><form:errors path="description"/></font>
				</td>
			</tr>
			<tr>
				<td><form:label path="stockNumber" >Stock Number </form:label></td>
				<td><%-- ${product.stockNumber} --%>
					<form:input path="stockNumber" readonly="true"/><br/>
					<font style="color: #C11B17;"><form:errors path="stockNumber"/></font>
				</td>
			</tr>
			<tr>
				<td><form:label path="availability" >* Availability</form:label></td>
				<td >
					<label for="yes">
					<form:radiobutton path="availability" name="availList" value="Yes" id="yes"/>Yes</label>&nbsp;&nbsp;&nbsp;
					<label for="no">
					<form:radiobutton path="availability" name="availList" value="No" id="no"/>No</label><br />
					<font style="color: #C11B17;"><form:errors path="availability"/></font>
				</td>
				
			</tr>
			
		</table>
		<br/>
		<div align="center"><input type="submit" value="Update Product"/></div>
	
	</div>
</form:form>

<%@include file="/WEB-INF/jsp/footer.jsp"%>