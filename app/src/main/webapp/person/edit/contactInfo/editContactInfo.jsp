    <!DOCTYPE html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html xmlns:th="http://www.thymeleaf.org">
    <head lang="en">
        <title>View Person</title>
        <link rel="stylesheet" type="text/css" href="/css/sample.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body>
        <table style="width:100%" class="w3-table-all, w3-table-all w3-centered">
            <tr>
                <th class="w3-center">Contact Type</th>
                <th class="w3-center">Contact Information</th>
                <th colspan="2" class="w3-center">Actions</th> 
            </tr>
            <c:forEach items="${person.contactInfo}" var="contact">
            <!-- <c:out value="${item}"/>  -->
            <form action="delete/${person.id}">
            <tr>
                <input type="hidden" value="${contact.id}" name="id"/>
                <input type="hidden" value="${contact.contactType}" name="contactType"/>
                <input type="hidden" value="${contact.contactInfo}" name="contactInfo"/>
                <td><p>${contact.contactType}</p></td>
                <td><p>${contact.contactInfo}</p></td>
                <!-- <td><a href="edit/${contact.id}">Edit</a></td> -->
                <!-- <td><a href="delete/${contact.id}">Delete</a></td> -->
                <td colspan="2">
                    <input type="submit" value="DELETE"/>
                </td>
            </tr>
            </form>
            </c:forEach>
            <tr>
                <form action="add">
                    <input type="hidden" name="personid" value="${person.id}"/>
                    <td><select name="contactType">
                        <c:forEach items="${contactTypes}" var="contacttype">
                            <option value="${contacttype.contactType}">${contacttype.contactType}
                            </option>
                        </c:forEach>
                    </select></td>
                    <td>
                        <input type="text" name="contactInfo" placeholder="Enter proper info" />
                    </td>
                    <td>
                        <input type="submit" value="ADD"/>
                    </td>
                    <td>
                        <input type="reset" value="RESET"/>
                    </td>
                </form>
            </tr>
        </table>
        
    </body>
    </html>