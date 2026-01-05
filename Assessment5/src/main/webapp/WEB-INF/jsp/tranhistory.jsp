<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transaction History</title>
</head>
<body>

<h2>Add Transaction</h2>

<form action="savetran" method="post">

    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}" />

    <label>Transaction ID:</label><br>
    <input type="number" name="tid" /><br><br>

    <label>Amount:</label><br>
    <input type="number" name="amt" /><br><br>

    <label>Date:</label><br>
    <input type="text" name="date" /><br><br>

    <!-- Account Number input -->
    <label>Account Number:</label><br>
    <input type="number" name="accNo" /><br><br>

    <input type="submit" value="Save Transaction" />

</form>

</body>
</html>
