<%@ page import="java.util.Date" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="webapp.model.Question" %>
<%@ page import="webapp.model.Wrapper" %><%--
  Created by IntelliJ IDEA.
  User: vssmirnov
  Date: 01.11.2016
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>api.stackexhange</title>
  </head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="../../css/demo_page.css" rel="stylesheet" type="text/css" />
  <link href="../../css/demo_table.css" rel="stylesheet" type="text/css" />
  <link href="../../css/demo_table_jui.css" rel="stylesheet" type="text/css" />
  <link href="../../css/jquery-ui-1.8.24.custom.css" rel="stylesheet" type="text/css" media="all" />
  <script src="../../js/jquery.js" type="text/javascript"></script>
  <script src="../../js/jquery.dataTables.js" type="text/javascript"></script>
  <script type="text/javascript">
    $(document).ready(function () {
      $("#tableResult").dataTable({
        "sPaginationType": "full_numbers",
        "bJQueryUI": true
    })});
  </script>
  <form method="GET" action="/search">
    <table>
      <tr>
        <td><b> intitle </b></td>
        <td><input type = "text" name = "in title" /></td>
        <td><input type = "submit" name = "searchSubmit" value = "search"/></td>
      </tr>
    </table>
    <div id="demo_jui">
      <table id="tableResult" class="display">
        <thead>
        <tr>
          <th><u>title</u></th>
          <th><u>tags</u></th>
          <th><u>owner</u></th>
          <th><u>is_answered</u></th>
          <th><u>last_activity_date</u></th>
          <th><u>creation_date</u></th>
        </tr>
        </thead>
        <tbody>
        <%
          Wrapper<Question> param = (Wrapper<Question>)request.getAttribute("ResultMessage");
          if (param != null){
            Object[] questions = param.getItems();
            for (int i = 0; i < questions.length; i+=1){
        %>
        <tr>
          <%
            LinkedHashMap<String, Object> quest = (LinkedHashMap<String, Object>)questions[i];
          %>
          <td> <a href="<%=quest.get("link")%>"> <%=quest.get("title")%> </a> </td>
          <td> <%=quest.get("tags")%> </td>
          <%
            LinkedHashMap<String, Object> owner = (LinkedHashMap<String, Object>) quest.get("owner");
          %>
          <td> <a href="<%=owner.get("link")%>"> <%=owner.get("display_name")%> </a> </td>
          <td> <%=quest.get("is_answered")%> </td>
          <%
            Date lastActivityDate = new Date((Integer) quest.get("last_activity_date"));
          %>
          <td> <%=lastActivityDate%> </td>
          <%
            Date creationDate = new Date((Integer) quest.get("creation_date"));
          %>
          <td> <%=creationDate%> </td>
        </tr>
        <%
            }
          }
        %>
        </tbody>
      </table>
  </form>
  </body>
</html>
