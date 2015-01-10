<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Add items to the checklist</title>
</head>
<body>
          <form:form modelAttribute="checklist">
                <label for="checklistInput">New Checklist Item Title: </label>
                <form:input path="itemTitle" id="itemTitleInput"/>
                 <form:errors class="text-error" path="itemTitle"></form:errors>
                  <label for="checklistInput">New Checklist Item Description: </label>
                <form:textarea path="itemDescription" id="itemDescriptionInput" rows="5" cols="30"/>
                 <form:errors class="text-error" path="itemDescription"></form:errors>
                <br>
                <button type="submit" value="Submit" id="createChecklistItem">Create</button>
          </form:form>
</body>
</html>
