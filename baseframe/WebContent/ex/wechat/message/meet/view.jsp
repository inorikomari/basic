<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
	<div style="width:686px;height:382px">
	<table class="form-table" width="98%">
		<tr>
			<th style="width:100px">标题</th>
			<td>${obj.title}</td>
		</tr>
		<tr>
			<th style="width:100px">模板类型</th>
			<td>${obj.typeText}</td>
		</tr>
		<tr>
			<th style="width:100px">发送到</th>
			<td>${obj.groupsText}</td>
		</tr>
		<tr>
			<th style="width:100px">内容</th>
			<td>
				<table class="form-table" width="98%">
					<tr>
						<th style="width:100px">正文:</th>
						<td>${obj.msgContent}</td>
					</tr>
					<tr>
						<th style="width:100px">会议时间:</th>
						<td>${obj.msgTime}</td>
					</tr>
					<tr>
						<th style="width:100px">会议地点:</th>
						<td>${obj.msgLocation}</td>
					</tr>
					<tr>
						<th style="width:100px">参会人员:</th>
						<td>${obj.msgAddress}</td>
					</tr>
					<tr>
						<th style="width:100px">备注:</th>
						<td>${obj.msgRemark}</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<th style="width:100px">描述</th>
			<td>${obj.describe}</td>
		</tr>
		<tr>
			<th style="width:100px">优先级</th>
			<td>${obj.priorityText}</td>
		</tr>
		<tr>
			<th style="width:100px">状态</th>
			<td>${obj.statusText}</td>
		</tr>
		<tr>
			<th style="width:100px">控制标志</th>
			<td>${obj.controlText}</td>
		</tr>
		<tr>
			<th style="width:100px">总条数</th>
			<td>${obj.count}</td>
		</tr>
		<tr>
			<th style="width:100px">录入人</th>
			<td>${obj.inputName}</td>
		</tr>
		<tr>
			<th style="width:100px">录入时间</th>
			<td>${wx:datetime(obj.onTime)}</td>
		</tr>
	</table>
</div>
