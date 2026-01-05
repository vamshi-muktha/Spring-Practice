<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Form</title>
</head>
<body>

<h2>Create Account</h2>

<form action="saveacc" method="post">

    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}" />

    <label>Account Number:</label><br>
    <input type="number" name="accNo" /><br><br>

    <label>Account Name:</label><br>
    <input type="text" name="aname" /><br><br>

    <label>Balance:</label><br>
    <input type="number" name="bal" /><br><br>

    <label>Branch ID:</label><br>
    <input type="text" name="bid" /><br><br>

    <label>Area:</label><br>
    <input type="text" name="area" /><br><br>

    <label>Email:</label><br>
    <input type="email" name="email" /><br><br>

    <input type="submit" value="Save Account" />

</form>

</body>
</html>
