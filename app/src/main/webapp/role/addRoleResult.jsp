    <!DOCTYPE html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html xmlns:th="http://www.thymeleaf.org">
    <head lang="en">
        <title>Spring Framework Guru</title>
    </head>
    <body>
        <c:if test="${result}">
            <h1>The Role:${role} has been added</h1>
        </c:if>
        <c:if test="!${result}">
            <h1>The Role:${role} already exist in the database</h1>
        </c:if>
        <li><a href="roles">Go back to Roles</a></li>
    </body>
    </html>