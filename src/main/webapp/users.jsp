<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Users</h2>
<p>Current User is ${param.get("userId") == null ? 'Unknown' : param.get("userId") == '1' ? 'Admin' : 'User'}</p>
<hr>
<%
	java.util.Enumeration params = request.getParameterNames();
	while(params.hasMoreElements()) {
	String paramName = (String) params.nextElement();
	String paramValue = request.getParameter(paramName);
%>

<h5><%=paramName%>
	has a value
	<%=paramValue%></h5>

<%
	}
%>
<hr>

</body>
</html>
