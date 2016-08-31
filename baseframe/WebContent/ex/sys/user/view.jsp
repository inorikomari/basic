<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<div class="easyui-tabs" fit="true">
<div title="基本信息" fit="true">
	<table class="form-table">
		<tr>
			<th style="width:100px">用户姓名</th>
			<td>${obj.username}</td>
			<th style="width:100px">性别</th>
			<td><c:if test="${obj.gender}">男</c:if><c:if test="${!obj.gender}">女</c:if></td>
		</tr>
		<tr>
			<th>管理员</th>
			<td><c:if test="${obj.admin}">管理员</c:if><c:if test="${!obj.admin}">非管理员</c:if></td>
			<th>状态</th>
			<td><c:if test="${obj.enable}">可用</c:if><c:if test="${!obj.enable}">禁用</c:if></td>
		</tr>
		<tr>
			<th>身份证号</th>
			<td>${obj.idNumber}</td>
			<th>电子邮件</th>
			<td>${obj.email}</td>
		</tr>
	</table>
	<table id="dg-sys-user-attas-view"></table>
	<input type="hidden" id="sys-user-attaIds-view" value="${obj.attaIds}"/>
	<script>WX.sys.fileattas('#dg-sys-user-attas-view','#sys-user-attaIds-view');</script>
</div>
<div title="用户角色" fit="true">
	<table class="easyui-datagrid" fitColumns="true" fit="true" singleSelect="true"
		url="<c:url value='/sys/user/roles'/>/${obj.id}" >
		<thead>
			<tr>
				<th sortable="true"  width="50"  align="center" field="id">ID</th>
				<th sortable="true"  width="200"  align="left" field="name">名称</th>
				<th sortable="true"  width="400"  align="left" field="description">描述</th>
			</tr>
		</thead>
	</table>
</div>
</div>