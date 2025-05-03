<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Category Form</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div class="container">
        <h1>${category.id != null ? 'Edit Category' : 'Add New Category'}</h1>
        
        <form:form action="${category.id != null ? '/categories/update/' + category.id : '/categories'}" method="post" modelAttribute="category">
            <div class="form-group">
                <label for="name">Name:</label>
                <form:input path="name" class="form-control" required="true" />
            </div>
            
            <div class="form-group">
                <label for="description">Description:</label>
                <form:textarea path="description" class="form-control" rows="3" />
            </div>
            
            <button type="submit" class="btn btn-primary">${category.id != null ? 'Update' : 'Save'}</button>
            <a href="/categories" class="btn">Cancel</a>
        </form:form>
    </div>
</body>
</html>