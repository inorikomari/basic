<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<head>
	<script type="text/javascript">
		$(function(){
			$('#dg-employee').edatagrid({
<% if(!m.w.App.isRoot()){ %>
				editing    : false,
<%}%>
				idField    : 'id',
				pagination : true,
				rownumbers : true,
				pageSize   : 20,
				pageList   : [10,20,30,40,50,100,200],
				url        : "<c:url value='/wechat/employee/items'/>",
				saveUrl    : "<c:url value='/wechat/employee/add'/>",
				updateUrl  : "<c:url value='/wechat/employee/update'/>",
				destroyUrl : "<c:url value='/wechat/employee/delete'/>",
				onHeaderContextMenu: function(e, field){
					WX.defaultDataGridHeaderContextMenu('dg-employee', e, field);
				}
			});
			$('#s-employee').searchbox({  
			    searcher:function(value,name){
			    	$('#dg-employee').edatagrid('reload', eval("({" + name + " : '" + value + "'})"));
			    }
			});
			$('#searchDept').bind('click',function(){
				var s = $('#sgroups').combobox('getValue');
				$('#dg-employee').edatagrid('reload', eval("({eq_groups : '" + s + "'})"));
			});
		});
	</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="north" border="false">
			<div class="subtitle">员工管理</div>
			<div class="toolbar">
				<input id="s-employee" class="easyui-searchbox" style="width:500px"
					data-options="prompt:'请输入要查询的值',menu:'#semployeeMenu'"></input>
				<div id="semployeeMenu" style="width:120px">
					<div data-options="name:'eq_id'">查询id</div>
					<div data-options="name:'lk_certNo'">查询身份证号</div>
					<div data-options="name:'lk_name'">查询姓名</div>
				</div>
			</div>
		</div>
		<div region="center" border="false">
			<table id="dg-employee" toolbar="#tb-employee" fitColumns="true" fit="true" singleSelect="true">
				<thead>
					<tr>
						<th field="id" width="50" editor="{type:'numberbox',options:{required:true}}">ID</th>
						<th field="certNo" width="200" editor="{type:'validatebox',options:{required:true}}">身份证号</th>
						<th field="name" width="50" editor="{type:'validatebox',options:{required:true}}">姓名</th>
						<th field="groups" showField="groupsText" width="50" editor="{type:'combobox',options:{url:'<c:url value="/sys/dict/dicts/department" />'}}">部门</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<div id="tb-employee">
<% if(m.w.App.isRoot()){ %>
		<a class="easyui-linkbutton" iconCls="icon-add"    href="#" plain="true" onclick="javascript:$('#dg-employee').edatagrid('addRow')">新增</a>
		<a class="easyui-linkbutton" iconCls="icon-save"   href="#" plain="true" onclick="javascript:$('#dg-employee').edatagrid('saveRow')">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-redo" href="#" plain="true" onclick="javascript:$('#dg-employee').edatagrid('cancelRow')">回退</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" href="#" plain="true" onclick="javascript:$('#dg-employee').edatagrid('destroyRow')">删除</a>
		<a class="easyui-linkbutton" iconCls="icon-resync" href="#" plain="true" onclick="javascript:WX.app.employee.reload()" style="color:red">刷新缓存</a>
<%}%>
		<a class="easyui-linkbutton" iconCls="icon-reload" href="#" plain="true" onclick="javascript:$('#dg-employee').edatagrid('reload')">刷新</a>
		<input name="lk_groups" id="sgroups" class="easyui-combobox query" data-options="multiple:false,editable:false,url:'<c:url value="/sys/dict/dicts/department"/>'"></input>
		<a id="searchDept" class="easyui-linkbutton" iconCls="icon-search" href="#" plain="true">查询</a>
		
	</div>
</body>