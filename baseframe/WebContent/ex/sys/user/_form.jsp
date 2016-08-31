<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<div style="padding-top:30px;" style="border:1px solid red">
	<table class="form-table">
		<tr>
			<th style="width:100px">用户姓名</th>
			<td><input name="username" value="${obj.username}" style="width:180px" class="easyui-validatebox" data-options="required:true,validType:'blength[1,50]'"/></td>
			<th style="width:100px">性别</th>
			<td>男<input type="radio" name="gender" value="true" ${wx:checked(obj.gender)}/> 女<input type="radio" name="gender" value="false" ${wx:checked(!obj.gender)}/></td>
		</tr>
<c:if test="${empty obj}">
		<tr>
			<th>用户口令</th>
			<td><input type="password" name="password" id="use_password" value="${obj.password}" style="width:180px" class="easyui-validatebox" data-options="required:true,validType:'blength[1,50]'"/></td>
			<th>确认口令</th>
			<td><input type="password" name="repassword" style="width:180px" class="easyui-validatebox" required="required" validType="equals['#use_password']"/></td>
		</tr>
</c:if>
		<tr>
			<th>单位/部门</th>
			<td colspan="3"><input id="orgTree" name="department" class="easyui-combobox" value="${obj.department}" data-options="required:true,url:'<c:url value="/sys/dict/dicts/department"/>'"
			 style="width:300px;">
			</td>
		</tr>
		<tr>
			<th>管理员</th>
			<td>管理员<input type="radio" name="admin" value="true" ${wx:checked(obj.admin)}/> 非管理员<input type="radio" name="admin" value="false" ${wx:checked(!obj.admin)}/></td>
			<th>状态</th>
			<td>可用<input type="radio" name="enable" value="true" ${wx:checked(obj.enable)}/> 禁用<input type="radio" name="enable" value="false" ${wx:checked(!obj.enable)}/></td>
		</tr>
		<tr>
			<th>身份证号</th>
			<td><input type="text" name="idNumber" value="${obj.idNumber}" style="width:180px" class="easyui-validatebox" data-options="validType:'blength[18,18]'"/></td>
			<th>电子邮件</th>
			<td><input type="text" name="email" value="${obj.email}" style="width:180px" class="easyui-validatebox" data-options="validType:'blength[1,50]'"/></td>
		</tr>
	</table>
	<table id="dg-sys-user-attas"></table>
</div>
<input type="hidden" name="id"       value="${obj.id}"/>
<input type="hidden" id="sys-user-attaIds" name="attaIds" value="${obj.attaIds}"/>
<script>
WX.sys.fileattas('#dg-sys-user-attas','#sys-user-attaIds',true);
</script>