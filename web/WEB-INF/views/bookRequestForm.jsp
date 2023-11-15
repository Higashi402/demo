<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Book Request Form</title>
</head>
<body>
<form action="controller" method="post">
  <input type="hidden" name="command" value="bookrequestcommand">
  <input type="hidden" name="action" value="add">
  <label for="id">Book ID:</label>
  <input type="text" id="id" name="id" value="<%= request.getParameter("id") %>">
  <!-- Other form fields if needed -->
  <input type="submit" value="Add Book Request">
</form>
</body>
</html>