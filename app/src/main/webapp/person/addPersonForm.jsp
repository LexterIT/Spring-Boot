    <!DOCTYPE html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html xmlns:th="http://www.thymeleaf.org">
    <head lang="en">
        <title>Edit Person Form</title>
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
            <div id="title">Add Person</div>
            <div id="content">

            <form action="addPerson">
                <table>
                    <tr>
                        <td><p>First Name</p></td>
                        <td><input type="text" name="name.firstName"/></td>
                        <td><p>Middle Name</p></td>
                        <td><input type="text" name="name.midName"/></td>
                    </tr>
                    <tr>
                        <td><p>Last Name</p></td>
                        <td><input type="text" name="name.lastName"/></td>
                        <td><p>Suffix</p></td>
                        <td><input type="text" name="name.suffix"/></td>
                    </tr>
                    <tr>
                        <td><p>Street</p></td>
                        <td><input type="text" name="address.street"/>
                        </td>
                        <td><p>Barangay</p></td>
                        <td><input type="text" name="address.barangay"/></td>
                    </tr>
                    <tr>
                        <td><p>Municipality</p></td>
                        <td><input type="text" name="address.municipality" /></td>
                        <td><p>Zip Code</p></td>
                        <td><input type="text" name="address.zipCode"/></td>
                    </tr>
                    <tr>
                        <td class="w3-center"><p>Birthday</p></td>
                        <td><input type="date" name="birthday"/></td>
                        <td class="w3-center"><p>Date Hired</p></td>
                        <td><input type="date" name="dateHired"/></td>
                    </tr>
                    <tr>
                        <td><p>GWA</p></td>
                        <td><input type="number" name="gwa" value="1" step="0.01" min="1" max="5"/></td>
                        <td><p>Currently Employed</p></td>
                        <td>
                            <input type="radio" name="isCurEmp" value="true" checked> true<br>
                            <input type="radio" name="isCurEmp" value="false"> false<br>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="w3-center">
                            <button onclick="goBack()">Cancel</button></td>
                        <td colspan="2" class="w3-center">
                            <input type="submit" value="Add"/></td>
                    </tr>
                </table>
            </form>
            </div>
        </div>
    </body>
    </html>