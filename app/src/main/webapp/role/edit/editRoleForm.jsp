    <!DOCTYPE html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html xmlns:th="http://www.thymeleaf.org">
    <head lang="en">
        <title>Edit Role Form</title>
        <link rel="stylesheet" type="text/css" href="/css/sample.css">
    </head>
    <body><!-- 
        <h1>Update Role</h1>
        <div class="container">
            <form action="updateRole">
                <input type="hidden" name="id" value="${role.id}"/>
                <input type="text" name="role" value="${role.role}"/>
                <input type="submit" value="Update"/>
            </form>
        </div> -->
        <div id="container">
            <div id="title">Update Role</div>
            <div id="content">
            <form action="updateRole">
                <input type="hidden" name="id" value="${role.id}"/>
                <table>
                    <tr>
                        <td><p>Role Name</p></td>
                        <td><input type="text" name="role" value="${role.role}"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Update" style="float:right"/></td>
                    </tr>
                </table>
            </form>
            </div>
        </div>
    </body>
    </html>