<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<br>
	<br>
	<a href="springmvc/HelloSpring">Test RequestMapping</a>

	<br>
	<br>
	<form action="springmvc/TestRest/98" method="post">
		<input type="hidden" name="_method" value="DELETE" /> <input
			type="submit" value="Rest Delete" />
	</form>

	<br>
	<br>
	<form action="springmvc/TestRest/120" method="post">
		<input type="hidden" name="_method" value="PUT" /> <input
			type="submit" value="Rest Put" />
	</form>

	<br>
	<br>
	<form action="springmvc/TestRest/133" method="post">
		<input type="submit" value="Rest Post" />
	</form>

</body>
</html>