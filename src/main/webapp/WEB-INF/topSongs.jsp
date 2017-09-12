<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Top 10</title>
	<link rel="stylesheet" type="text/css" href="css/topSongs.css">
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<ul>
	<c:forEach var="song" items="${songs}">
		<li>${song.rating} - <a href="/songs/${song.id}"><c:out value="${song.name}"/></a> - ${song.artist}</li>
	</c:forEach>
	</ul>
</body>