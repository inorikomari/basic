<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<head>
	<title>模型管理</title>
	<script type="text/javascript">
		$(function(){
			$('#dg-busirule').edatagrid({
				pagination : true,
				rownumbers : true,
				pageSize   : 20,
				pageList   : [10,20,30,40,50,100,200],
				url        : "<c:url value='/busi/rule/items'/>",
				saveUrl    : "<c:url value='/busi/rule/add'/>",
				updateUrl  : "<c:url value='/busi/rule/update'/>",
				destroyUrl : "<c:url value='/busi/rule/delete'/>"
			});
			
			$(".fieldEdit").bind('click',function(){
				var row = $('#dg-busirule').datagrid('getSelected');
				if (row){
					$('#dlg-rule-def').dialog({title:'规则字段维护'}).dialog('open').dialog('refresh', '<c:url value="/busi/rule/field"/>/'+row.id);
				}else{
					$.messager.show({
						title:'<span class="blue">提示</span>',
						msg:'请先<span class="blue">选择记录</span>后再进行规则字段维护。'
					});
				}
			});
			
			$(".ruleDefine").bind('click',function(){
				var row = $('#dg-busirule').datagrid('getSelected');
				if (row){
					$('#dlg-rule-def').dialog({title:'规则定义'}).dialog('open').dialog('refresh', '<c:url value="/busi/rule/define"/>/'+row.id);
				}else{
					$.messager.show({
						title:'<span class="blue">提示</span>',
						msg:'请先<span class="blue">选择记录</span>后再进行规则定义。'
					});
				}
			});
		});
	</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="center" border="false">
			<table id="dg-busirule" toolbar="#tb-busirule" fitColumns="true" fit="true" singleSelect="true">
				<thead>
					<tr>
						<th field="id" hidden="true">ID</th>
						<th field="modelId" width="100" editor="{type:'validatebox',options:{required:true}}">模型编号</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<div id="tb-busirule">
		<a class="easyui-linkbutton" iconCls="icon-add"    href="#" plain="true" onclick="javascript:$('#dg-busirule').edatagrid('addRow')">新增</a>
		<a class="easyui-linkbutton" iconCls="icon-save"   href="#" plain="true" onclick="javascript:$('#dg-busirule').edatagrid('saveRow')">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" href="#" plain="true" onclick="javascript:$('#dg-busirule').edatagrid('cancelRow')">取消</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" href="#" plain="true" onclick="javascript:$('#dg-busirule').edatagrid('destroyRow')">删除</a>
		<a class="easyui-linkbutton fieldEdit" iconCls="icon-edit" href="#" plain="true">规则字段维护</a>
		<a class="easyui-linkbutton ruleDefine" iconCls="icon-edit" href="#" plain="true">规则定义</a>
	</div>
	<div class="easyui-dialog" closed="true" id="dlg-rule-def" style="width:650px;height:550px;position:relative"></div>
</body>