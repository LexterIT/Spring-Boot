    <!DOCTYPE html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html xmlns:th="http://www.thymeleaf.org">
    <head lang="en">
        <title>View Person Form</title>
        <link rel="stylesheet" type="text/css" href="/css/sample.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script>
        function goBack() {
          window.history.back()
        }
        </script>
    </head>
    <body>
        <!-- <h1>Update Person</h1> -->
        <div id="container">
            <div id="title">Person with ID:${person.id}</div>
            <div id="content">
                <input type="hidden" name="id" value="1"/>
                <table class="w3-table-all w3-centered">
                    <tr>
                        <td><h3>Name</h3></td>
                        <td colspan="3"><h4>${person.name}</h4></td>
                    </tr>
                    <tr>
                        <td><h3>Address</h3></td>
                        <td colspan="3"><h4>${person.address}</h4></td>
                    </tr>
                    <tr>
                        <td><h3>Birthday</h3></td>
                        <td><h4>${person.birthday}</h4></td>
                        <td><h3>Date Hired</h3></td>
                        <td><h4>${person.dateHired}</h4></td>
                    </tr>
                    <tr>
                        <td><h3>GWA</h3></td>
                        <td><h4>${person.gwa}</h4></td>
                        <td><h3>Currently Employed</h3></td>
                        <td><h4>${person.isCurEmp}</h4></td>
                    </tr>
                    <tr>
                        <td><h3>Contacts</h3></td>
                        <td colspan="3"><h4>${person.contactInfo}</h4></td>
                    </tr>
                    <tr>
                        <td><h3>Roles</h3></td>
                        <td colspan="3"><h4>${person.roles}</h4></td>
                    </tr>
                    <tr>
                        <td colspan="2"><form action="edit/contactInfo/${person.id}">
                            <input type="submit" value="Edit Contacts"/>
                        </form></td>
                        <td colspan="2"><form action="edit/roles/${person.id}">
                            <input type="submit" value="Edit Roles"/>
                        </form></td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
    </html>