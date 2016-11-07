<%@ page import="java.util.Date" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="webapp.model.Question" %>
<%@ page import="webapp.model.Wrapper" %>
<%@ page import="webapp.model.ShallowUser" %><%--
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
        <td><b> in title </b></td>
        <td><input type = "text" name = "intitle" /></td>
        <td><input type = "submit" name = "searchSubmit" value = "search"/></td>
      </tr>
    </table>
    <div id="demo_jui">
      <table id="tableResult" class="display">
        <thead>
        <tr>
          <th><u>is answered</u></th>
          <th><u>title</u></th>
          <th><u>tags</u></th>
          <th><u>owner</u></th>
          <th><u>last activity date</u></th>
          <th><u>creation date</u></th>
        </tr>
        </thead>
        <tbody>
        <%
          Wrapper<Question> param = (Wrapper<Question>)request.getAttribute("ResultMessage");
          if (param != null){
            Object[] questions = param.getItems();
            for (int i = 0; i < questions.length; i+=1){
                Question quest = (Question)questions[i];
        %>
        <tr>
          <td align="center">
          <%
                if (quest.getAnswered()){
          %>
              <img src="../../img/isAnswered.png" width = 20>
          <%
                }
                else{
          %>
          <%
                }
          %>
          </td>
          <td> <a href="<%=quest.getLink()%>"> <%=quest.getTitle()%> </a> </td>
          <td> <%=String.join(",", quest.getTags())%> </td>
          <%
            ShallowUser owner = (ShallowUser) quest.getOwner();
            if (owner == null){
                owner = new ShallowUser();
          %>
            <td> <%=owner.getDisplayName()%> </a> </td>
          <%
            }
            else {
          %>
            <td> <a href="<%=owner.getLink()%>"> <%=owner.getDisplayName()%> </a> </td>
          <%
            }
          %>
          <td> <%=quest.getLastActivityDate()%> </td>
          <td> <%=quest.getCreationDate()%> </td>
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
