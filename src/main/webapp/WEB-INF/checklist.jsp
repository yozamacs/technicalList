<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<title> Checklist </title>
 <link href="https://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" rel="stylesheet"  type="text/css" />
 <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css" />
 </head>
<body>
    <div class="span6">
	<h1 class="cntr">${message}</h1>
	</div>
	 <div class="container">
    <table class="table table-hover">
    <thead>
    <tr><td>Title</td>
    <td>Description</td></tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${checklistItems}">
           <tr><td>${item.itemTitle}</td>
           <td>${item.itemDescription}</td></tr>
    </c:forEach>
    </tbody>
    </table>
    <br>
    <div class="cntr">
    <a class="btn btn-default" href="checklistAdd.html" role="button">Add a Checklist Item</a>
    </div>
    </div>

</body>
</html>