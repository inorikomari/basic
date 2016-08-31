<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<body>
	<table id="dg-busi-rule">
		<thead>
			<tr>
				<th checkbox="true">选择</th>
				<th sortable="true" width="300"  align="left" field="describ">中文名称</th>
				<th sortable="true" width="250"  align="left" field="attribute">名称</th>
			</tr>
		</thead>
	</table>
	<div id="tb-busi-rule">
		<a class="easyui-linkbutton openAddFields" iconCls="icon-add"    href="#" plain="true">新增字段</a>
		<a class="easyui-linkbutton delFields" iconCls="icon-remove" href="#" plain="true" >删除选定字段</a>
	</div>
	<div class="easyui-dialog" closed="true" cache="false"
		id="dlg-busi-rule"
		title="请选择要被添加的字段"
		style="width:500px;height:400px;position:relative">
		<table class="easyui-datagrid" id="dg-all-fields" toolbar="#tb-all-fields" fitColumns="true" fit="true" singleSelect="false" cache="false"
			url="<c:url value='/busi/model/items'/>" >
			<thead>
				<tr>
					<th checkbox="true">选择</th>
					<th sortable="true"  width="50"  align="left" field="describ">中文名称</th>
					<th sortable="true"  width="50"  align="left" field="attribute">名称</th>
					<th sortable="true"  width="50"  align="left" field="datatypeText">数据类型</th>
					<th sortable="true"  width="50"  align="left" field="controlsTypeText">控件类型</th>
					<th sortable="true"  width="50"  align="left" field="fieldTypeText">字段类型</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="tb-all-fields">
		<a class="easyui-linkbutton addFields" iconCls="icon-add"    href="#" plain="true">增加选定字段</a>
	</div>
	<script type="text/javascript">
	$(function(){
		$('#dg-busi-rule').datagrid({
			url       :"<c:url value='/busi/rule/fields/${obj.modelId}'/>",
			toolbar	  :"#tb-busi-rule",
			singleSelect:false
		});
		
		$(".addFields").bind('click',function(){
			var rid ='${obj.modelId}';
			var rows = $('#dg-all-fields').datagrid('getChecked');
			if(rows.length==0){
				$.messager.show({
					title:'<span class="red">请先选择要增加的字段</span>',
					msg: '请先选择要增加的字段'
				});
				return;
			}
			var attrs = [];
			$.each(rows, function(i, v){
				attrs.push(v.attribute);
			});
			$.post('<c:url value="/busi/rule/addFields/"/>' + rid,
				{fieldIds : attrs.join(',')},
				function(data){
					if(data.success){
						$('#dlg-busi-rule').dialog('close');
						$('#dg-all-fields').datagrid('unselectAll').datagrid('clearSelections');
						$('#dg-busi-rule').datagrid('reload');
						$.messager.show({
							title   : '<span class="green">增加字段成功</span>',
							msg     : '增加字段成功',
							timeout : 3000,
							showType: 'fade'
						});
					}else{
						$.messager.show({
							title:'<span class="red">增加字段失败</span>',
							msg: '增加字段失败'
						});
					}
				},
				'json'
			);
		});
		
		$(".openAddFields").bind('click',function(){
			var rid ='${obj.modelId}';
			$('#dlg-busi-rule').dialog('open');
		});
		
		$(".delFields").bind('click',function(){
			var rid = '${obj.modelId}';
			var rows = $('#dg-busi-rule').datagrid('getChecked');
			if(rows.length==0){
				$.messager.show({
					title:'<span class="red">请先选择要删除的字段</span>',
					msg: '请先选择要删除的字段'
				});
				return;
			}
			var ids = [];
			$.each(rows, function(i, v){
				ids.push(v.id);
			});
			$.post('<c:url value="/busi/rule/delFields/"/>' + rid,
				{fieldIds : ids.join(',')},
				function(data){
					if(data.success){
						$('#dg-busi-rule').datagrid('unselectAll').datagrid('clearSelections');
						$('#dg-busi-rule').datagrid('reload');
						$.messager.show({
							title   : '<span class="green">删除字段成功</span>',
							msg     : '删除字段成功',
							timeout : 3000,
							showType: 'fade'
						});
					}else{
						$.messager.show({
							title:'<span class="red">删除字段失败</span>',
							msg: '删除字段失败'
						});
					}
				},
				'json'
			);
		});
	});
</script>
</body>