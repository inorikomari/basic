<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<div>
	<table class="form-table">
		<tr>
			<th style="width:100px">名称</th>
			<td><input name="lk_title" style="width:120px" class="query"></input></td>
		</tr>
		<tr>
			<th style="width:100px">模板类型</th>
			<td><input name="in_type" style="width:120px" class="easyui-combobox query" data-options="multiple:true,editable:false,required:true,url:'<c:url value="/wechat/template/list"/>'"></input></td>
		</tr>
		<tr>
			<th style="width:100px">优先级</th>
			<td><input name="in_priority" class="easyui-combobox query" data-options="multiple:true,editable:false,url:'<c:url value="/sys/const/options/PushBatch/priority"/>'"></input></td>
		</tr>
		<tr>
			<th style="width:100px">状态</th>
			<td><input name="in_status" class="easyui-combobox query" data-options="multiple:true,editable:false,url:'<c:url value="/sys/const/options/PushBatch/status"/>'"></input></td>
		</tr>
		<tr>
			<th style="width:100px">控制标志</th>
			<td><input name="in_control" class="easyui-combobox query" data-options="multiple:true,editable:false,url:'<c:url value="/sys/const/options/PushBatch/control"/>'"></input></td>
		</tr>
		<tr>
			<th style="width:100px">录入日期</th>
			<td>从<input name="ge_onTime" style="width:120px" class="easyui-datebox query"></input>
				到<input name="le_onTime" style="width:120px" class="easyui-datebox query"></input></td>
		</tr>
	</table>
</div>