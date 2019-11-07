    <!DOCTYPE html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html xmlns:th="http://www.thymeleaf.org">
    <head lang="en">
        <title>View Roles</title>
        <link rel="stylesheet" type="text/css" href="/css/sample.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script src="/js/sample.js"></script>
    </head>
    <body>
        <form action="addRoleForm"> 
            <input type="submit" value="Add New Role" style="float:right"/>
        </form>
        <table style="width:100%" class="w3-table-all, w3-table-all w3-centered">
            <tr>
                <th style="width:45%">Title</th>
                <th colspan="2">Actions</th>
            </tr>
            <c:forEach items="${roles}" var="item">
            <!-- <c:out value="${item}"/>  -->
            <tr>
                <td>${item}</td>
                <td><form action="edit/${item.id}">
                <input type="submit" value="EDIT"/></form></td>
                <td><form action="delete/${item.id}">
                <input type="submit" value="DELETE"/></form></td>
            </tr>
            </c:forEach>
        </table>
        
    </body>
    </html>