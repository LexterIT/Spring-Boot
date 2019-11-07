    <!DOCTYPE html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html xmlns:th="http://www.thymeleaf.org">
    <head lang="en">
        <title>Update Result</title>
    </head>
    <body>
        <h1>The Person:${person.name} has been updated</h1>
        <li><a href="/person/person">Go back to Person</a></li>
    </body>
    </html>