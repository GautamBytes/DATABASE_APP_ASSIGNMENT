<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Form</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div class="container">
        <h1>${product.id != null ? 'Edit Product' : 'Add New Product'}</h1>
        
        <form:form action="${product.id != null ? '/products/update/' + product.id : '/products'}" method="post" modelAttribute="product">
            <div class="form-group">
                <label for="name">Name:</label>
                <form:input path="name" class="form-control" required="true" />
            </div>
            
            <div class="form-group">
                <label for="description">Description:</label>
                <form:textarea path="description" class="form-control" rows="3" />
            </div>
            
            <div class="form-group">
                <label for="price">Price:</label>
                <form:input path="price" type="number" step="0.01" class="form-control" required="true" />
            </div>
            
            <div class="form-group">
                <label for="category">Category:</label>
                <form:select path="category" class="form-control" required="true">
                    <form:option value="" label="-- Select Category --" />
                    <c:forEach items="${categories}" var="category">
                        <form:option value="${category.id}" label="${category.name}" />
                    </c:forEach>
                </form:select>
            </div>
            
            <button type="submit" class="btn btn-primary">${product.id != null ? 'Update' : 'Save'}</button>
            <a href="/products" class="btn">Cancel</a>
        </form:form>
    </div>
</body>
</html>