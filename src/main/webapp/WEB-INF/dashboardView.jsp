<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Lookify!</title>
	<link rel="stylesheet" type="text/css" href="css/dashboardView.css">
</head>
<body>
	<a href="/songs/new">Add New</a>
	<a href="/top">Top Songs</a>
	
	<form method="POST" action="/songs/search">
		<label>Search:
		<input type="text" name="searchQuery"></label>
		
		<input type="submit" value="Search">
	</form>

    <table class="table">
    		<tr>
    			<th>Name</th>
    			<th>Rating</th>
    			<th>Actions</th>
    		</tr>
    <c:forEach var="song" items="${songs}">
        <tr>        
            <td><a href="/songs/${song.id}"><c:out value="${song.name}"/></a></td>
            <td><c:out value="${song.rating}"/></td>
            <td><a href="/songs/delete/${song.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</body>