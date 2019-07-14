<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Course</title>
</head>
<body>
	<h3 align="center"> View All Course</h3>
	<center>
	<table border="1" >
	<tr align="center">
		<th> Course Name </th>
		<th> Course Fees </th>
		<th> Course Type </th>
	<tr> 
	<c:forEach items="${courseList}" var="course">
		<tr align="center">
			<td> <c:out value="${course.coursename}"></c:out> </td>
			<td> <c:out value="${course.coursefees}"></c:out> </td>
			<td> <c:out value="${course.coursetype}"></c:out> </td>
		</tr>		
	</c:forEach>
	</table>
	</center>
</body>
</html>