<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<head>
	<script type="text/javascript">
		$(function(){
			$('#dg-role').wxgrid({
				url       :'<c:url value="/sys/role/items"/>',
				addUrl    :'<c:url value="/sys/role/add"/>',
				updateUrl :'<c:url value="/sys/role/update"/>',
				delUrl    :'<c:url value="/sys/role/delete"/>',
				lookUrl   :'<c:url value="/sys/role/view"/>',
				editDlg   :'#dlg-role',
				editForm  :'#fm-role',
				searcher  : '#s-role',
				toolbarx : [
					{
						text:'|'
					}
					,{
						id:'bt-role-permissions',
						text:'维护角色授权',
						iconCls:'icon-wrench',
						handler:function(){
							var row = $('#dg-role').datagrid('getSelected');
							if (row){
								$('#dlg-role-def').dialog({title:'维护角色授权'}).dialog('open').dialog('refresh', '<c:url value="/sys/role/permission"/>/'+row.id);
							}else{
								$.messager.show({
									title:'<span class="blue">提示</span>',
									msg:'请先<span class="blue">选择记录</span>后再进行维护角色授权。'
								});
							}
						}
					}
					,{
						id:'bt-role-users',
						text:'维护用户角色',
						iconCls:'icon-user',
						handler:function(){
							var row = $('#dg-role').datagrid('getSelected');
							if (row){
								$('#dlg-role-def').dialog({title:'维护用户角色'}).dialog('open').dialog('refresh', '<c:url value="/sys/role/user"/>/'+row.id);
							}else{
								$.messager.show({
									title:'<span class="blue">提示</span>',
									msg:'请先<span class="blue">选择记录</span>后再进行维护用户角色。'
								});
							}
						}
					}
				]
<% if(!m.w.App.isRoot()){ %>
				,onSelect:function(rowIndex, rowData){
					if(rowData.system=='YES'){
						$('#bt-role-permissions').linkbutton('disable');
						$('#dg-role-update').linkbutton('disable');
						$('#dg-role-del').linkbutton('disable');
					}else{
						$('#bt-role-permissions').linkbutton('enable');
						$('#dg-role-update').linkbutton('enable');
						$('#dg-role-del').linkbutton('enable');
					}
				}
<%}%>
			});
		});
	</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="north" border="false">
			<div class="subtitle">角色管理</div>
			<div class="toolbar">
				<input id="s-role" class="easyui-searchbox" style="width:500px"
					data-options="prompt:'请输入要查询的值',menu:'#sroleMenu'"></input>
				<div id="sroleMenu" style="width:120px">
					<div data-options="name:'lk_name'">查询名称</div>
					<div data-options="name:'in_id'">查询ID</div>
					<div data-options="name:'lk_description'">查询描述</div>
				</div>
			</div>
		</div>
		<div region="center" border="false" style="padding:0 5px 5px 5px">
			<table id="dg-role" title="角色管理">
				<thead>
					<tr>
						<th sortable="true"  width="50"  align="center" field="id">ID</th>
						<th sortable="true"  width="200"  align="left" field="name">名称</th>
						<th sortable="true"  width="50"   align="center" field="system" showField="systemText">系统角色</th>
						<th sortable="true"  width="400"  align="left" field="description">描述</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<div class="easyui-dialog" closed="true" id="dlg-role" title="角色管理" style="width:800px;height:500px;position:relative"></div>
	<div class="easyui-dialog" closed="true" id="dlg-role-def" style="width:800px;height:500px;position:relative"></div>
</body>
