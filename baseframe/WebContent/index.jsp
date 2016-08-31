<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html style="height:100%" lang='zh-CN' xml:lang='zh-CN' xmlns='http://www.w3.org/1999/xhtml'>
<head>
<title><%=App.getAppName()%></title>
</head>
<body>
<shiro:authenticated>
欢迎<shiro:principal property="username"/>
</shiro:authenticated>
<shiro:guest>
您还没有登录，请先登录。
</shiro:guest>
</body>
</html>