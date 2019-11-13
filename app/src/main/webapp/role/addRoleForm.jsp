    <!DOCTYPE html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html xmlns:th="http://www.thymeleaf.org">
    <head lang="en">
        <title>Add Role Form</title>
        <link rel="stylesheet" type="text/css" href="/css/sample.css">
    </head>
    <body>
        <div id="container">
            <div id="title">Add Role</div>
            <div id="content">
            <form action="addRole">
                <table>
                    <tr>
                        <td><p>Role Name</p></td>
                        <td><input type="text" name="role"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Add" style="float:right"/></td>
                    </tr>
                </table>
            </form>
            </div>
        </div>
    </body>
    </html>