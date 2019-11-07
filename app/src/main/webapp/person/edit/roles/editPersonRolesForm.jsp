    <!DOCTYPE html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html xmlns:th="http://www.thymeleaf.org">
    <head lang="en">
        <title>Edit Person Roles</title>
        <link rel="stylesheet" type="text/css" href="/css/sample.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script src="/js/sample.js"></script>
    </head>
    <body>
        <table style="width:100%" class="w3-table-all, w3-table-all w3-centered">
            <tr>
                <th style="width:45%">Title</th>
                <th colspan="2">Actions</th>
            </tr>
            <c:forEach items="${personroles}" var="item">
            <!-- <c:out value="${item}"/>  -->
            <tr>
                <td>${item}</td>
                <td colspan="2">
                    <form action="/person/edit/roles/delete/${item.id}">
                        <input type="hidden" value=${personid} name="personid"/>
                        <input type="hidden" value="${item.id}" name="id"/>
                        <input type="submit" value="DELETE"/>
                    </form>
                </td>
            </tr>
            </c:forEach>
            <c:forEach items="${roles}" var="role">
            <tr>
                <td>${role}</td>
                <td colspan="2">
                    <form action="/person/edit/roles/add/${role.id}">
                        <input type="hidden" value=${personid} name="personid"/>
                        <input type="hidden" value="${role.id}" name="id"/>
                        <input type="hidden" value="${role.role}" name="role"/>
                        <input type="submit" value="ADD"/>
                    </form>
                </td>
            </tr>
            </c:forEach>
        </table>
        
    </body>
    </html>