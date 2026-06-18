<%-- 
    Document   : Registration
    Created on : 28 Sept 2025, 9:50:53 pm
    Author     : soniy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>User registration</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h2>user Registration Form</h2>
        <form action="http://localhost:8080/WebApplication1/Registratio.jsp/Welcome.jsp" method="post">
            <label>username:</label>
            <input type="text" name="username" required><br><br>
            <label>email:</label>
            <input type="email" name="email" required><br><br>
            <label>password:</label>
            <input type="password" name="password" required><br><br>
            <label>mobile:</label>
            <input type="text" name="mobile" required><br><br>
            <label>age:</label>
            <input type="number" name="age" required><br><br>
            <label>selected course:</label>
            <select name="course" required><br><br>
                <option value="java">java development</option> 
                <option value="python">python development</option>
                <option value="web">web development</option>
                <input type="submit" value="Register">
            </select><br><br>
        </form>
    </body>
</html>
