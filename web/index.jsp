<%--
  Created by IntelliJ IDEA.
  User: wenka
  Date: 17-9-9
  Time: 下午9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="get" action="${pageContext.request.contextPath}/users/login.do">

        <label>
            用户名：<input type="text" name="username"><br/>
        </label>

        <label>
            密码：<input type="password" name="password"><br/>
        </label>
        
        <label>
            <input type="submit" value="登陆">
        </label>
    </form>
</body>
</html>
