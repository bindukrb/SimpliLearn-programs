<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<body>

<h1>Displaying the Product Details....</h1>
<hr>
<%= "Product Id : " + session.getAttribute("p_id") %> <br> <br>

<%= "Product Name : " + session.getAttribute("name") %> <br> <br>

<%= "Product Price : " + session.getAttribute("price") %>


</body>
</html>
