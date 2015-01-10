<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<body>
	<h1>${message}</h1>
    <table>
    <thead>
    <tr><td>Title</td>
    <td>Description</td></tr>
    <thead>
    <c:forEach var="item" items="${checklistItems}">
           <tr><td>${item.itemTitle}</td>
           <td>${item.itemDescription}</td></tr>
    </c:forEach>
    </table>
    <br>
    <a href="checklistAdd" id="addItem">Add a Checklist Item</a>

</body>
</html>