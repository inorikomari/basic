<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<head>
	<script type="text/javascript">
		$(function(){
			$('#dg-user').wxgrid({
				url       :'<c:url value="/sys/user/items"/>',
				addUrl    :'<c:url value="/sys/user/add"/>',
				updateUrl :'<c:url value="/sys/user/update"/>',
				delUrl    :'<c:url value="/sys/user/delete"/>',
				lookUrl   :'<c:url value="/sys/user/view"/>',
				editDlg   :'#dlg-user',
				editForm  :'#fm-user',
				searcher  : '#s-user',
				query:{
					title:'查询用户',
					form:'<c:url value="/sys/user/query"/>',
					width:450,
					height:180,
					callback:function(){$('.easyui-searchbox').searchbox('setValue','');}
				},
				toolbarx : [
					{
						text:'|'
					}
					,{
						id:'bt-user-roles',
						text:'维护用户角色',
						iconCls:'icon-role',
						handler:function(){
							var row = $('#dg-user').datagrid('getSelected');
							if (row){
								$('#dlg-user-def').dialog({title:'维护用户角色'}).dialog('open').dialog('refresh', '<c:url value="/sys/user/role"/>/'+row.id);
							}else{
								$.messager.show({
									title:'<span class="blue">提示</span>',
									msg:'请先<span class="blue">选择记录</span>后再进行维护用户角色。'
								});
							}
						}
					}
				]
			});
		});
	</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="north" border="false">
			<div class="subtitle">用户管理</div>
			<div class="toolbar">
				<input id="s-user" class="easyui-searchbox" style="width:500px"
					data-options="prompt:'请输入要查询的值',menu:'#ssMenu'"></input>
				<div id="ssMenu" style="width:120px">
					<div data-options="name:'lk_username'">查询姓名</div>
					<div data-options="name:'in_id'">查询ID</div>
					<div data-options="name:'lk_idNumber'">查询身份证号</div>
					<div data-options="name:'lk_email'">查询电子邮件</div>
				</div>
			</div>
		</div>
		<div region="center" border="false" style="padding:0 5px 5px 5px">
			<table id="dg-user" title="用户管理">
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
	<div class="easyui-dialog" closed="true"
		id="dlg-user"
		title="用户管理"
		style="width:800px;height:500px;position:relative"></div>
	<div class="easyui-dialog" closed="true" id="dlg-user-def" style="width:800px;height:500px;position:relative"></div>
</body>
