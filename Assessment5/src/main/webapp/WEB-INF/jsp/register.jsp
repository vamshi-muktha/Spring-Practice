<h1>Registration</h1>

<form action="/register" method="POST">
    <!-- CSRF token -->
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    Username: <input type="text" name="username" /><br/>
    Password: <input type="password" name="password" /><br/>
	Confirm Password: <input type="password" name="cpassword" /><br/>
	Details: <input type="text" name="details" /><br/>
    <input type="submit" value="Login" />
</form>
