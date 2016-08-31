<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<body>
	<div class="easyui-layout" fit="true">
		<div region="center" border="false">
			<table class="easyui-datagrid" id="dg-role-permissions${obj.id}" toolbar="#tb-role-permissions${obj.id}" fitColumns="true" fit="true" singleSelect="false"
				title="<span class='red'>${obj.name}</span>具有的权限"
				url="<c:url value='/sys/role/permissions'/>/${obj.id}" >
				<thead>
					<tr>
						<th field="id" hidden="true">ID</th>
						<th checkbox="true">选择</th>
						<th field="module" showField="moduleName" width="50">模块</th>
						<th field="code" width="100">代码</th>
						<th field="name" width="100">名称</th>
						<th field="description" width="150">说明</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<div id="tb-role-permissions${obj.id}">
		<a class="easyui-linkbutton" iconCls="icon-add"    href="#" plain="true" onclick="javascript:WX.sys.role.openAddPermissions(${obj.id})">新增权限</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" href="#" plain="true" onclick="javascript:WX.sys.role.delPermissions(${obj.id})">删除选定权限</a>
	</div>
	<div class="easyui-dialog" closed="true" cache="false"
		id="dlg-role-permissions${obj.id}"
		title="请选择要增加权限"
		style="width:800px;height:500px;position:relative">
		<table class="easyui-datagrid" id="dg-all-permissions${obj.id}" toolbar="#tb-all-permissions${obj.id}" fitColumns="true" fit="true" singleSelect="false" cache="false"
			url="<c:url value='/sys/permission/items'/>" >
			<thead>
				<tr>
					<th checkbox="true">选择</th>
					<th field="module" showField="moduleName" width="50">模块</th>
					<th field="code" width="100">代码</th>
					<th field="name" width="100">名称</th>
					<th field="description" width="150">说明</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="tb-all-permissions${obj.id}">
		<a class="easyui-linkbutton" iconCls="icon-add"    href="#" plain="true" onclick="javascript:WX.sys.role.addPermissions(${obj.id})">增加选定权限</a>
	</div>
</body>