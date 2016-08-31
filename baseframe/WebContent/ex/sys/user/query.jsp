<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<div>
	<table class="form-table">
		<tr>
			<th style="width:60px">用户姓名</th>
			<td><input name="lk_username" style="width:120px" class="query"></input></td>
			<th style="width:60px">性别</th>
			<td>
				<select class="query" style="width:80px" name="eq_gender">
					<option value="" selected>所有</option>
					<option value="true">男</option>
					<option value="false">女</option>
				</select>
			</td>
		</tr>
		<tr>
			<th style="width:60px">管理员</th>
			<td>
				<select class="query" style="width:80px" name="eq_admin">
					<option value="" selected>所有</option>
					<option value="true">管理员</option>
					<option value="false">非管理员</option>
				</select>
			</td>
			<th style="width:60px">状态</th>
			<td>
				<select class="query" style="width:80px" name="eq_enable">
					<option value="" selected>所有</option>
					<option value="true">可用</option>
					<option value="false">禁用</option>
				</select>
			</td>
		</tr>
		<tr>
			<th style="width:60px">身份证号</th>
			<td><input name="lk_idNumber" style="width:120px" class="query"></input></td>
			<th style="width:60px">电子邮件</th>
			<td><input name="lk_email" style="width:120px" class="query"></input></td>
		</tr>
	</table>
</div>
