<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<head>
	<script type="text/javascript">
		$(function(){
			var dictTypeId = -1;
			var dictTypeName = '';
			$('#dg-dicttype').edatagrid({
				url        : "<c:url value='/sys/dict/types'/>",
				saveUrl    : "<c:url value='/sys/dict/add'/>",
				updateUrl  : "<c:url value='/sys/dict/update'/>",
				destroyUrl : "<c:url value='/sys/dict/delete'/>",
				onSelect : function(rowIndex, rowData){
					dictTypeId = rowData.id;
					if(!dictTypeId){
						return;
					}
					dictTypeName = rowData.text;
					$('#dg-dictitem').edatagrid({
						title      : '<span class="red">' + rowData.text + '</span>字典项管理',
						url        : "<c:url value='/sys/dict/items'/>/"+rowData.id,
						saveUrl    : "<c:url value='/sys/dict/addItem'/>/"+rowData.id,
						updateUrl  : "<c:url value='/sys/dict/updateItem'/>",
						destroyUrl : "<c:url value='/sys/dict/deleteItem'/>"
					});
				}
			});
			
			$('#dg-dictitem').edatagrid({
				title      : '<span class="red">请选择某种字典类型</span>'
			});
		});
	</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="north" border="false">
			<div class="subtitle">字典管理</div>
			<div class="toolbar">

			</div>
		</div>
		<div region="west" border="false" style="width:500px;padding:0 5px 5px 5px; ">
			<table title="字典类型管理" id="dg-dicttype" toolbar="#tb-dicttype" fitColumns="true" fit="true" singleSelect="true">
				<thead>
					<tr>
						<th field="id" hidden="true">ID</th>
						<th field="code" width="100" editor="{type:'validatebox',options:{required:true}}">代码</th>
						<th field="text" width="100" editor="{type:'validatebox',options:{required:true}}">名称</th>
						<th field="notes" width="150" editor="text">说明</th>
						<th field="orders" width="50" editor="{type:'numberbox',options:{required:true}}" align="right">排序</th>
					</tr>
				</thead>
			</table>
		</div>
		<div region="center" border="false" style="padding:0 5px 5px 5px">
			<table id="dg-dictitem" toolbar="#tb-dictitem" fitColumns="true" fit="true" singleSelect="true">
				<thead>
					<tr>
						<th field="id" hidden="true">ID</th>
						<th field="typeId" hidden="true">typeID</th>
						<th field="text" width="200" editor="{type:'validatebox',options:{required:true}}">名称</th>
						<th field="notes" width="200" editor="text">说明</th>
						<th field="orders" width="50" editor="{type:'numberbox',options:{required:true}}" align="right">排序</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<div id="tb-dicttype">
		<a class="easyui-linkbutton" iconCls="icon-add"    href="#" plain="true" onclick="javascript:$('#dg-dicttype').edatagrid('addRow')">新增</a>
		<a class="easyui-linkbutton" iconCls="icon-save"   href="#" plain="true" onclick="javascript:$('#dg-dicttype').edatagrid('saveRow')">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" href="#" plain="true" onclick="javascript:$('#dg-dicttype').edatagrid('cancelRow')">取消</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" href="#" plain="true" onclick="javascript:$('#dg-dicttype').edatagrid('destroyRow')">删除</a>
		<a class="easyui-linkbutton" iconCls="icon-reload" href="#" plain="true" onclick="javascript:$('#dg-dicttype').edatagrid('reload')">刷新</a>
		<a class="easyui-linkbutton" iconCls="icon-resync" href="#" plain="true" onclick="javascript:WX.sys.dict.reload()" style="color:red">刷新缓存</a>
	</div>
	<div id="tb-dictitem">
		<a class="easyui-linkbutton" iconCls="icon-add"    href="#" plain="true" onclick="javascript:$('#dg-dictitem').edatagrid('addRow')">新增</a>
		<a class="easyui-linkbutton" iconCls="icon-save"   href="#" plain="true" onclick="javascript:$('#dg-dictitem').edatagrid('saveRow')">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" href="#" plain="true" onclick="javascript:$('#dg-dictitem').edatagrid('cancelRow')">取消</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" href="#" plain="true" onclick="javascript:$('#dg-dictitem').edatagrid('destroyRow')">删除</a>
		<a class="easyui-linkbutton" iconCls="icon-reload" href="#" plain="true" onclick="javascript:$('#dg-dictitem').edatagrid('reload')">刷新</a>
	</div>
</body>