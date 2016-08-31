<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<div class="easyui-tabs" fit="true">
<div title="基本信息" fit="true">
	<table class="form-table">
		<tr>
			<th style="width:100px">名称</th>
			<td>${obj.name}</td>
		</tr>
		<tr>
			<th style="width:100px">系统角色</th>
			<td>${obj.systemText}</td>
		</tr>
		<tr>
			<th style="width:100px">描述</th>
			<td><pre>${obj.description}</pre></td>
		</tr>
	</table>
</div>
<div title="包含权限" fit="true">
	<table class="easyui-datagrid" fitColumns="true" fit="true" singleSelect="true"
		title="<span class='red'>${obj.name}</span>包含的权限"
		url="<c:url value='/sys/role/permissions'/>/${obj.id}" >
		<thead>
			<tr>
				<th field="module" showField="moduleName" width="50">模块</th>
				<th field="code" width="100">代码</th>
				<th field="name" width="100">名称</th>
				<th field="description" width="150">说明</th>
			</tr>
		</thead>
	</table>
</div>
<div title="授予用户" fit="true">
	<table class="easyui-datagrid" fitColumns="true" fit="true"
		title="<span class='red'>${obj.name}</span>被授予的用户"
		url="<c:url value='/sys/role/users'/>/${obj.id}" >
		<thead>
			<tr>
				<th sortable="true"  width="20"  align="center" field="id">ID</th>
				<th sortable="true"  width="80"  align="center" field="username">用户姓名</th>
				<th sortable="true"  width="80"  align="center" field="orgId" showField="orgName">所属机构</th>
				<th sortable="true"  width="40"  align="center" field="gender" formatter="WX.sys.gender.formatter" styler="WX.sys.gender.styler">性别</th>
				<th sortable="true"  width="40"  align="center" field="admin" formatter="WX.sys.admin.formatter" styler="WX.sys.admin.styler">管理员</th>
				<th sortable="true"  width="40"  align="center" field="enable" formatter="WX.sys.enable.formatter" styler="WX.sys.enable.styler">状态</th>
				<th sortable="true"  width="80"  align="center" field="idNumber" >身份证号</th>
				<th sortable="true"  width="80"  align="center" field="email" >电子邮件</th>
			</tr>
		</thead>
	</table>
</div>
</div>