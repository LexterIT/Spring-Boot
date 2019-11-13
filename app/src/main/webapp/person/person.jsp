    <!DOCTYPE html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html xmlns:th="http://www.thymeleaf.org">
    <head lang="en">
        <title>View Person</title>
        <link rel="stylesheet" type="text/css" href="/css/sample.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body>
        <ul>
            <li><a href="#">Person</a></li>
            <li><a href="/role/roles">Roles</a></li>
            <li style="float:right"><a href="addPersonForm">Add Person</a></li>
        </ul>
        <!-- <form action="addPersonForm"> 
            <input type="submit" value="Add New Person" style="float:right"/>
        </form> -->
        <table style="width:100%" class="w3-table-all">
            <tr>
                <th style="width:40%">Name</th>
                <th colspan="3" class="w3-center" >Actions</th>
            </tr>
            <c:forEach items="${people}" var="person">
            <!-- <c:out value="${item}"/>  -->
            <tr>
                <td>${person.name}</td>
                <td class="w3-center"><form action="${person.id}">
                    <input type="submit" value="VIEW"/></form></td>
                <td class="w3-center"><form action="edit/${person.id}">
                    <input type="submit" value="EDIT"/></form></td>
                <td class="w3-center"><form action="delete/${person.id}">
                    <input type="submit" value="DELETE"/></form></td>
            </tr>
            </c:forEach>
        </table>
        
    </body>
    </html>