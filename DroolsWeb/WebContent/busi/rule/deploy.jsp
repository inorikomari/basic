<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<head>
	<title>模型管理</title>
	<script type="text/javascript">
		$(function(){
			$('#dg-busirule').edatagrid({
				pagination : true,
				rownumbers : true,
				editable   : false,
				pageSize   : 20,
				pageList   : [10,20,30,40,50,100,200],
				url        : "<c:url value='/busi/rule/items1'/>",
			});
			
			$(".ruleDeploy").bind('click',function(){
				var row = $('#dg-busirule').datagrid('getSelected');
				if (row){
					$('#dlg-rule-dep').dialog({title:'模型运行'}).dialog('open').dialog('refresh', '<c:url value="/busi/rule/input"/>/'+row.id);
				}else{
					$.messager.show({
						title:'<span class="blue">提示</span>',
						msg:'请先<span class="blue">选择记录</span>后再进行模型运行。'
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
		<a class="easyui-linkbutton ruleDeploy" iconCls="icon-edit" href="#" plain="true">模型运行</a>
	</div>
	<div class="easyui-dialog" closed="true" id="dlg-rule-dep" style="width:650px;height:550px;position:relative"></div>
</body>