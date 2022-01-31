<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple form</title>
</head>
<body>
	<h1> Enter your name and birth date </h1>
	
	<h3>${errorMsg}</h3>
	
	<form action="STest" method="post">
	
		<label for="firstname"> First name: </label>
		<input name="firstname" value="${firstname}"/> <br/>
		
		<label for="familyname"> Family name: </label>
		<input name="familyname" value="${familyname }"/><br/>
		
		<button type="submit" value="Submit form">
			Submit form
		</button>
	</form>
</body>
</html>