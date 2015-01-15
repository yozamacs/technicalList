<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Add items to the checklist</title>
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" rel="stylesheet"  type="text/css" />
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="newItems">
    <div class="span6">
        <h1 class="cntr">Add an item to the checklist</h1>
    </div>
    <div class="container">
      <form:form modelAttribute="checklist" class="form-horizontal">
          <fieldset>
             <div class="form-group">
                <label for="checklistInput">New Checklist Item Title: </label>
                <form:input path="itemTitle" id="itemTitleInput" class="form-control"/>
                <form:errors class="text-error" path="itemTitle"></form:errors>
             </div>
             <div class="form-group">
                <label for="checklistInput">New Checklist Item Description: </label>
                <form:textarea path="itemDescription" id="itemDescriptionInput" class="form-control"/>
                <form:errors class="text-error" path="itemDescription"></form:errors>
             </div>
             <div class="cntr">
                <button type="submit" value="Submit" id="createChecklistItem" class="btn btn-default">Create </button>
             </div>
          </fieldset>
      </form:form>
    </div>
</div>
</body>
</html>
