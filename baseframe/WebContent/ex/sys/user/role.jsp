<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<body>
	<div class="easyui-layout" fit="true">
		<div region="center" border="false">
			<table class="easyui-datagrid" id="dg-user-roles${obj.id}" toolbar="#tb-user-roles${obj.id}" fitColumns="true" fit="true" singleSelect="false"
				title="<span class='red'>${obj.username}</span>拥有的角色"
				url="<c:url value='/sys/user/roles'/>/${obj.id}" >
				<thead>
					<tr>
						<th checkbox="true">选择</th>
						<th sortable="true"  width="50"  align="center" field="id">ID</th>
						<th sortable="true"  width="200"  align="left" field="name">名称</th>
						<th sortable="true"  width="400"  align="left" field="description">描述</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<div id="tb-user-roles${obj.id}">
		<a class="easyui-linkbutton" iconCls="icon-add"    href="#" plain="true" onclick="javascript:WX.sys.user.openAddRoles(${obj.id})">新增角色</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" href="#" plain="true" onclick="javascript:WX.sys.user.delRoles(${obj.id})">删除选定角色</a>
	</div>
	<div class="easyui-dialog" closed="true" cache="false"
		id="dlg-user-roles${obj.id}"
		title="请选择要被添加的角色"
		style="width:800px;height:500px;position:relative">
		<table class="easyui-datagrid" id="dg-all-roles${obj.id}" toolbar="#tb-all-roles${obj.id}" fitColumns="true" fit="true" singleSelect="false" cache="false"
			url="<c:url value='/sys/role/items'/>" >
			<thead>
				<tr>
					<th checkbox="true">选择</th>
					<th sortable="true"  width="50"  align="center" field="id">ID</th>
					<th sortable="true"  width="200"  align="left" field="name">名称</th>
					<th sortable="true"  width="400"  align="left" field="description">描述</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="tb-all-roles${obj.id}">
		<a class="easyui-linkbutton" iconCls="icon-add"    href="#" plain="true" onclick="javascript:WX.sys.user.addRoles(${obj.id})">增加选定角色</a>
	</div>
</body>