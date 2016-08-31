<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html style="height:100%" lang='zh-CN' xml:lang='zh-CN' xmlns='http://www.w3.org/1999/xhtml'>
<head>
<%@ include file="/common/include/_includes.jsp"%>
<%
	String basePath = request.getContextPath();
%>
<title>Drool</title>
</head>
<body>
	<div id="tt" class="easyui-tabs" style="width:100%;height:100%;" fit="true">    
    <div title="考察项管理">  
    	<iframe scrolling='auto' frameborder='0'  src='<c:url value="/busi/model/index" />' style='width:100%;height:100%;'></iframe>
    </div>  
    <div title="模型管理">  
    	 <iframe scrolling='auto' frameborder='0'  src='<c:url value="/busi/rule/index" />' style='width:100%;height:100%;'></iframe>
    </div>  
    <div title="模型运行">  
    	 <iframe scrolling='auto' frameborder='0'  src='<c:url value="/busi/rule/deploy" />' style='width:100%;height:100%;'></iframe>
    </div>
	</div>  
</body>
</html>