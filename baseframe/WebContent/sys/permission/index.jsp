<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<head>
	<script type="text/javascript">
		$(function(){
			$('#dg-permission').edatagrid({
<% if(!m.w.App.isRoot()){ %>
				editing    : false,
<%}%>
				idField    : 'id',
				pagination : true,
				rownumbers : true,
				pageSize   : 20,
				pageList   : [10,20,30,40,50,100,200],
				url        : "<c:url value='/sys/permission/items'/>",
				saveUrl    : "<c:url value='/sys/permission/add'/>",
				updateUrl  : "<c:url value='/sys/permission/update'/>",
				destroyUrl : "<c:url value='/sys/permission/delete'/>",
				onHeaderContextMenu: function(e, field){
					WX.defaultDataGridHeaderContextMenu('dg-permission', e, field);
				}
			});
			$('#s-permission').searchbox({  
			    searcher:function(value,name){
			    	$('#dg-permission').edatagrid('reload', eval("({" + name + " : '" + value + "'})"));
			    }
			});
		});
	</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="north" border="false">
			<div class="subtitle">权限资源管理</div>
			<div class="toolbar">
				<input id="s-permission" class="easyui-searchbox" style="width:500px"
					data-options="prompt:'请输入要查询的值',menu:'#spermissionMenu'"></input>
				<div id="spermissionMenu" style="width:120px">
					<div data-options="name:'lk_code'">查询代码</div>
					<div data-options="name:'lk_name'">查询名称</div>
					<div data-options="name:'lk_description'">查询说明</div>
				</div>
			</div>
		</div>
		<div region="center" border="false">
			<table id="dg-permission" toolbar="#tb-permission" fitColumns="true" fit="true" singleSelect="true">
				<thead>
					<tr>
						<th field="id" width="50" hidden="true">ID</th>
						<th field="module" showField="moduleName" width="50" editor="{type:'combobox',options:{url:'<c:url value="/sys/const/options/Permission/module"/>'}}">模块</th>
						<th field="code" width="100" editor="{type:'validatebox',options:{required:true}}">代码</th>
						<th field="name" width="100" editor="{type:'validatebox',options:{required:true}}">名称</th>
						<th field="description" width="150" editor="text">说明</th>
						<th field="orders" width="50" editor="{type:'numberbox',options:{required:true}}" align="right">排序</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<div id="tb-permission">
<% if(m.w.App.isRoot()){ %>
		<a class="easyui-linkbutton" iconCls="icon-add"    href="#" plain="true" onclick="javascript:$('#dg-permission').edatagrid('addRow')">新增</a>
		<a class="easyui-linkbutton" iconCls="icon-save"   href="#" plain="true" onclick="javascript:$('#dg-permission').edatagrid('saveRow')">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-redo" href="#" plain="true" onclick="javascript:$('#dg-permission').edatagrid('cancelRow')">回退</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" href="#" plain="true" onclick="javascript:$('#dg-permission').edatagrid('destroyRow')">删除</a>
<%}%>
		<a class="easyui-linkbutton" iconCls="icon-reload" href="#" plain="true" onclick="javascript:$('#dg-permission').edatagrid('reload')">刷新</a>
	</div>
</body>