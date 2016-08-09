<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head></head>
<body>
<h1>Admin Login</h1>

<s:form action="Welcome" validate="true">
	<s:textfield name="emailid" label="Email:" size="20"/>
	<s:password name="pass" label="Password:" />
	<s:submit/> 
</s:form>

</body>
</html>