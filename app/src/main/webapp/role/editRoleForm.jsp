    <!DOCTYPE html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html xmlns:th="http://www.thymeleaf.org">
    <head lang="en">
        <title>Add Role Form</title>
        <link rel="stylesheet" type="text/css" href="/css/sample.css">
    </head>
    <body>
        <h1>Add Role</h1>
        <div class="container">
            <form action="updateRole">
                <input type="text" name="roleName" value="$(role.role)"/>
                <input type="submit" value="Update"/>
            </form>
        </div>
    </body>
    </html>