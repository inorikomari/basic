<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<head>
	<script type="text/javascript">
		$(function(){
			$('#dg-template').edatagrid({
<% if(!m.w.App.isRoot()){ %>
				editing    : false,
<%}%>
				idField    : 'id',
				pagination : true,
				rownumbers : true,
				pageSize   : 20,
				pageList   : [10,20,30,40,50,100,200],
				url        : "<c:url value='/wechat/template/types'/>",
				saveUrl    : "<c:url value='/wechat/template/add'/>",
				updateUrl  : "<c:url value='/wechat/template/update'/>",
				destroyUrl : "<c:url value='/wechat/template/delete'/>",
				onHeaderContextMenu: function(e, field){
					WX.defaultDataGridHeaderContextMenu('dg-template', e, field);
				}
			});
			$('#s-template').searchbox({  
			    searcher:function(value,name){
			    	$('#dg-template').edatagrid('reload', eval("({" + name + " : '" + value + "'})"));
			    }
			});
		});
	</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="north" border="false">
			<div class="subtitle">模板类型管理</div>
		</div>
		<div region="center" border="false">
			<table id="dg-template" toolbar="#tb-template" fitColumns="true" fit="true" singleSelect="true">
				<thead>
					<tr>
						<th field="id" width="50" editor="{type:'numberbox',options:{required:true}}">ID</th>
						<th field="text" width="50" editor="{type:'validatebox',options:{required:true}}">名称</th>
						<th field="path" width="200" editor="{type:'validatebox',options:{required:true}}">路径</th>
						<th field="txid" width="200" editor="{type:'validatebox',options:{required:true}}" align="center">模板id</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<div id="tb-template">
<% if(m.w.App.isRoot()){ %>
		<a class="easyui-linkbutton" iconCls="icon-add"    href="#" plain="true" onclick="javascript:$('#dg-template').edatagrid('addRow')">新增</a>
		<a class="easyui-linkbutton" iconCls="icon-save"   href="#" plain="true" onclick="javascript:$('#dg-template').edatagrid('saveRow')">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-redo" href="#" plain="true" onclick="javascript:$('#dg-template').edatagrid('cancelRow')">回退</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" href="#" plain="true" onclick="javascript:$('#dg-template').edatagrid('destroyRow')">删除</a>
		<a class="easyui-linkbutton" iconCls="icon-resync" href="#" plain="true" onclick="javascript:WX.app.template.reload()" style="color:red">刷新缓存</a>
<%}%>
		<a class="easyui-linkbutton" iconCls="icon-reload" href="#" plain="true" onclick="javascript:$('#dg-template').edatagrid('reload')">刷新</a>
	</div>
</body>