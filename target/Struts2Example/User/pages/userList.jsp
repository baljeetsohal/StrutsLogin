<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


  <head>
      <meta http-equiv="content-type" content="text/xhtml; charset=windows-1252" />
      <meta http-equiv="content-language" content="en-us" />
    
    </head>
   <body>


    <ul id="tabs">
<!--      <li><a href="Welcome">Create User</a> </li> 
  <li><a href="userlist">User list</a></li> -->
       
    </ul>
    <div id="User list"  class="tabcontent" >
  <div class="content" >
         <table border="1">
        <caption style="" >User List</caption>
      <tr>
	<th>ID</th>
	<th>FirstName</th>
	<th>LastName</th>
	<th>Department</th>
	<th>Email</th>
	<th>Password</th>
	<th>Operation</th>
</tr>
<s:iterator value="listUser" var="us">
	<tr><td><s:property value="id"/></td>
		<td><s:property value="first"/> </td>
		<td> <s:property value="last"/></td>
		<td><s:property value="dept"/></td>
		<td><s:property value="email"/></td>
		<td><s:property value="pass"/></td>
		<td><a href="update?id=<s:property value="id"/>">Edit</a></td>
		<td><a href="delete?id=<s:property value="id"/>">delete</a></td>
	</tr>	
</s:iterator>
         
         </table>
       </div> 
</div>



</body>
</html>