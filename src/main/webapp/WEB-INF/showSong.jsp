<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><c:out value="${song.name}"/> Details</title>
	<link rel="stylesheet" type="text/css" href="css/dashboardView.css">
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<p>Title: ${song.name}</p>
	<p>Artist: ${song.artist}</p>
	<p>Rating (1-10): ${song.rating}</p>
	<a href="/songs/delete/${song.id}">Delete</a>
</body>