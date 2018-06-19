<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index page</title>
</head>
<body>

	<br>
	<br>
	<a href="springmvc/HelloSpring?username=Mikeal&age=18">Hello spring mvc</a>
	<br>
	<br>
	<a href="springmvc/TestRequestParam?username=Mikeal&age=12">TestRequestParam</a>
	<br>
	<br>
	<a href="image">Test  image</a>



	<br>
	<br>

	<form action="springmvc/TestPOJO" method="post">
		name:<input type="text" name="name" /> <br> age:<input
			type="text" name="age" /> <br> password:<input type="password"
			name="password" /> <br> sex:<input type="text" name="sex" /> <br>
		Tel:<input type="text" name="tel" /> <br> city:<input type="text"
			name="address.city" /> <br> province:<input type="text"
			name="address.province" /> <br> <input type="reset"
			value="Reset" /> &nbsp;&nbsp;&nbsp;&nbsp; <input type="submit"
			value="Submit" />
	</form>



	<!-- 
	<br>
	<br>
	<form action="springmvc/TestRestPut/120" method="post">
		<input type="hidden" name="_method" value="PUT" /> <input
			type="submit" value="Rest Put" />
	</form>

	<br>
	<br>
	<form action="springmvc/TestRest/133" method="post">
		<input type="submit" value="Rest Post" />
	</form>
 -->

</body>
</html>