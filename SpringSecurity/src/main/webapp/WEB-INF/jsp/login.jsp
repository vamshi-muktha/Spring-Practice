<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

<h3>Custom Login Page</h3>

<form action="/login" method="POST">
    <!-- CSRF token -->
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    Username: <input type="text" name="username" /><br/>
    Password: <input type="password" name="password" /><br/>
    <input type="submit" value="Login" />
</form>

<br/>

<!-- Google OAuth button -->
<a href="/oauth2/authorization/google">
    <button type="button">Login with Google</button>
</a>

</body>
</html>

