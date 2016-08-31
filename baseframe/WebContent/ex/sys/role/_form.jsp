<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<div style="padding-top:30px;">
	<table class="form-table">
		<tr>
			<th style="width:100px">名称</th>
			<td><input name="name" value="${obj.name}" style="width:95%" class="easyui-validatebox" data-options="required:true,validType:'blength[1,50]'"/></td>
		</tr>
<% if(m.w.App.isRoot()){ %>
		<tr>
			<th style="width:100px">系统角色</th>
			<td><input  name="system" value="${obj.system}" class="easyui-combobox" data-options="required:true,url:'<c:url value="/sys/const/options/Role/system"/>'"></td>
		</tr>
<%}%>
		<tr>
			<th style="width:100px">描述</th>
			<td><textarea name="description" style="width:95%;height:250px">${obj.description}</textarea></td>
		</tr>
	</table>
</div>
<input type="hidden" name="id"       value="${obj.id}"/>
<% if(!m.w.App.isRoot()){ %>
<input type="hidden" name="system"   value="NO"/>
<%}%>