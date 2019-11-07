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
            <div id="title">Update Person</div>
            <div id="content">

            <form action="updatePerson">
                <input type="hidden" name="id" value="${person.id}"/>
                <table>
                    <tr>
                        <td class="w3-center"><p>First Name</p></td>
                        <td><input type="text" name="name.firstName" value="${person.name.firstName}"/></td>
                        <td class="w3-center"><p>Middle Name</p></td>
                        <td><input type="text" name="name.midName" value="${person.name.midName}"/></td>
                    </tr>
                    <tr>
                        <td class="w3-center"><p>Last Name</p></td>
                        <td><input type="text" name="name.lastName" value="${person.name.lastName}"/></td>
                        <td class="w3-center"><p>Suffix</p></td>
                        <td><input type="text" name="name.suffix" value="${person.name.suffix}"/></td>
                    </tr>
                    <tr>
                        <td class="w3-center"><p>Street</p></td>
                        <td><input type="text" name="address.street" value="${person.address.street}"/>
                        </td>
                        <td class="w3-center"><p>Barangay</p></td>
                        <td><input type="text" name="address.barangay" value="${person.address.barangay}"/></td>
                    </tr>
                    <tr>
                        <td class="w3-center"><p>Municipality</p></td>
                        <td><input type="text" name="address.municipality" value="${person.address.municipality}"/></td>
                        <td class="w3-center"><p>Zip Code</p></td>
                        <td><input type="text" name="address.zipCode" value="${person.address.zipCode}"/></td>
                    </tr>
                    <tr>
                        <td class="w3-center"><p>Birthday</p></td>
                        <td><input type="date" name="birthday" value="${person.birthday}"/></td>
                        <td class="w3-center"><p>Date Hired</p></td>
                        <td><input type="date" name="dateHired" value="${person.dateHired}"/></td>
                    </tr>
                    <tr>
                        <td class="w3-center"><p>GWA</p></td>
                        <td><input type="text" name="gwa" value="${person.gwa}"/></td>
                        <td class="w3-center"><p>Currently Employed</p></td>
                        <td class="w3-center"><c:choose>
                            <c:when test="$person{person.isCurEmp}">
                                <input type="radio" name="isCurEmp" value="true" checked> true
                                <input type="radio" name="isCurEmp" value="false"> false
                            </c:when> <c:otherwise>
                                <input type="radio" name="isCurEmp" value="true"> true
                                <input type="radio" name="isCurEmp" value=false checked> false
                            </c:otherwise>
                        </c:choose></td>
                    </tr>
                    <input type="hidden" name="roleUpdate" value="false"/>
                    <input type="hidden" name="contactUpdate" value="false"/>
                    <tr>
                        <td colspan="2" class="w3-center">
                            <button onclick="goBack()">Cancel</button></td>
                        <td colspan="2" class="w3-center">
                            <input type="submit" value="Update"/></td>
                    </tr>
                </table>
            </form>
            </div>
        </div>
    </body>
    </html>