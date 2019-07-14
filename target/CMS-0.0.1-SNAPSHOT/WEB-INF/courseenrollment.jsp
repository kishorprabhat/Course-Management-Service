<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course Enroll</title>
<script type="text/javascript">
function validate(){
	var name = document.getElementById("name").value;
	var gender = document.getElementById("gender").value;
	if(name==""||name== null){
		alert("Name can't be empty");
		return false;
	}
	else if(gender==""||gender== null){
		alert("Select Gender");
		return false;
	}
	return true
}
</script>
</head>
<body>
	<center>
	<h3>Course Enrollment</h3>
	<form:form action="enrollStudent.htm" modelAttribute="student" onsubmit="return validate()">
		Student Name :<form:input path="studentName" id="name"/> <br>
		Course Name  :<form:select path="coursecode" >
						<form:options items="${CourseNameList}"></form:options>
						</form:select> <br>
		Gender       : <form:radiobutton path="gender" value="Male" id="gender"/> Male
						<form:radiobutton path="gender" value="Female" id="gender"/> Female <br>
    	Course Type  : <form:checkbox path="coursetype" value="e-learning"/> e-learning
    					<form:checkbox path="coursetype" value= "classroom"/> classroom <br>
		<input type="submit" value="Enroll" > <br>
		<font color="red">${msg}</font>
		<br>
		<br>
		<a href="home.htm"> Back </a>
	</form:form>
	</center>
</body>
</html>