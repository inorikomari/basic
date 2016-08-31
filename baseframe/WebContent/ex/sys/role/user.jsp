<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<body>
	<div class="easyui-layout" fit="true">
		<div region="center" border="false">
			<table class="easyui-datagrid" id="dg-role-users${obj.id}" toolbar="#tb-role-users${obj.id}" fitColumns="true" fit="true" singleSelect="false"
				title="<span class='red'>${obj.name}</span>被授予的用户"
				url="<c:url value='/sys/role/users'/>/${obj.id}" >
				<thead>
					<tr>
						<th checkbox="true">选择</th>
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
	<div id="tb-role-users${obj.id}">
		<a class="easyui-linkbutton" iconCls="icon-add"    href="#" plain="true" onclick="javascript:WX.sys.role.openAddUsers(${obj.id})">新增用户</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" href="#" plain="true" onclick="javascript:WX.sys.role.delUsers(${obj.id})">删除选定用户</a>
	</div>
	<div class="easyui-dialog" closed="true" cache="false"
		id="dlg-role-users${obj.id}"
		title="请选择要被授权的用户"
		style="width:800px;height:500px;position:relative">
		<table class="easyui-datagrid" id="dg-all-users${obj.id}" toolbar="#tb-all-users${obj.id}" fitColumns="true" fit="true" singleSelect="false" cache="false"
			url="<c:url value='/sys/user/items'/>" >
			<thead>
				<tr>
					<th checkbox="true">选择</th>
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
	<div id="tb-all-users${obj.id}">
		<a class="easyui-linkbutton" iconCls="icon-add"    href="#" plain="true" onclick="javascript:WX.sys.role.addUsers(${obj.id})">增加选定用户</a>
	</div>
</body>