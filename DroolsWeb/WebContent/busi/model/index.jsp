<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<head>
	<title>字段定义</title>
	<script type="text/javascript">
		$(function(){
			$('#dg-busimodel').edatagrid({
				pagination : true,
				rownumbers : true,
				pageSize   : 20,
				pageList   : [10,20,30,40,50,100,200],
				url        : "<c:url value='/busi/model/items'/>",
				saveUrl    : "<c:url value='/busi/model/add'/>",
				updateUrl  : "<c:url value='/busi/model/update'/>",
				destroyUrl : "<c:url value='/busi/model/delete'/>"
			});
			
			$.extend($.fn.validatebox.defaults.rules, {   
			    selOptions: {   
			        validator: function(value, param){
			        	if(-1!=value.indexOf(':'))
			            	return true;
			        	else
			        		return false;
			        },   
			        message: '请按照 01:wuhan,02:hankou 方式填写数据! '  
			    }   
			}); 
		});
	</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="center" border="false">
			<table id="dg-busimodel" toolbar="#tb-busimodel" fitColumns="true" fit="true" singleSelect="true">
				<thead>
					<tr>
						<th field="id" hidden="true">ID</th>
						<th field="attribute" width="50" editor="{type:'validatebox',options:{required:true}}">字段名称</th>
						<th field="describ" width="100" editor="{type:'validatebox',options:{required:true}}">中文名称</th>
						<th field="datatype" showField="datatypeText" width="50" editor="{type:'combobox',options:{required:true,url:'<c:url value="/sys/const/options/BusiModel/datatype"/>'}}">数据类型</th>
						<th field="controlsType" showField="controlsTypeText" width="50" editor="{type:'combobox',options:{required:true,url:'<c:url value="/sys/const/options/BusiModel/controlsType"/>'}}">控件类型</th>
						<th field="controlsContent" width="150" editor="{type:'validatebox',options:{validType:'selOptions[]'}}">控件内容</th>
						<th field="fieldType" showField="fieldTypeText" width="50" editor="{type:'combobox',options:{required:true,url:'<c:url value="/sys/const/options/BusiModel/fieldType"/>'}}">类型</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<div id="tb-busimodel">
		<a class="easyui-linkbutton" iconCls="icon-add"    href="#" plain="true" onclick="javascript:$('#dg-busimodel').edatagrid('addRow')">新增</a>
		<a class="easyui-linkbutton" iconCls="icon-save"   href="#" plain="true" onclick="javascript:$('#dg-busimodel').edatagrid('saveRow')">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" href="#" plain="true" onclick="javascript:$('#dg-busimodel').edatagrid('cancelRow')">取消</a>
	</div>
</body>