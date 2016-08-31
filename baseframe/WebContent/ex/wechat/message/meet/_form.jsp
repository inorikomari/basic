<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<div style="width:686px;height:382px">
	<input type="hidden" name="id" value="${obj.id}"/>
	<input type="hidden" name="status" value="${obj.status}"/>
	<input type="hidden" name="inputName" value="${obj.inputName}"/>
	<input type="hidden" name="onTime" value="${wx:datetime(obj.onTime)}"/>
	<input type="hidden" name="count" value="${obj.count}"/>
	<input type="hidden" name="type" value="${obj.type}"/>
	<table class="form-table" width="98%">
		<tr>
			<th style="width:100px">标题</th>
			<td><input name="title" style="width:95%" value="${obj.title}" class="easyui-validatebox" data-options="required:true,validType:'blength[1,50]'"/></td>
		</tr>
		<!-- <tr>
			<th style="width:100px">模板类型</th>
			<td><input name="type" id="temtype" value="${obj.type}" style="width:200px" class="easyui-combobox" data-options="editable:false,required:true,
			url:'<c:url value="/wechat/template/list"/>',onSelect:function(){
					var i = $('#temtype').combobox('getText');
					WX.app.message.changetype(i);
				}"/></td>
		</tr> -->
		<tr>
			<th style="width:100px">发送到</th>
			<td><input name="groups" id="groups-tree" class="easyui-combotree" style="width:540px" data-options="multiple:true,required:true,url:'<c:url value="/wechat/message/tree"/>',
						onLoadSuccess:function(){
							var s = '${obj.groups}';
							if(''!=s&&null!=s){
					        	$('#groups-tree').combotree('setValues',s.split(','));
					        }
					    }" /></td>
		</tr>
		<tr>
			<th style="width:100px">内容</th>
			<td>
				<table class="form-table" width="98%">
					<tr>
						<th>正文:</th>
						<td><textarea rows="3" cols="70" name="msgContent" class="easyui-validatebox" data-options="required:true,validType:'blength[1,2000]'">${obj.msgContent}</textarea></td>
					</tr>
					<tr>
						<th>会议时间:</th>
						<td><input name="msgTime" style="width:95%" value="${obj.msgTime}" class="easyui-validatebox" data-options="required:true,validType:'blength[1,2000]'"/></td>
					</tr>
					<tr>
						<th>会议地点:</th>
						<td><input name="msgLocation" style="width:95%" value="${obj.msgLocation}" class="easyui-validatebox" data-options="required:true,validType:'blength[1,2000]'"/></td>
					</tr>
					<tr>
						<th>参会人员:</th>
						<td><input name="msgAddress" style="width:95%" value="${obj.msgAddress}" class="easyui-validatebox" data-options="required:true,validType:'blength[1,2000]'"/></td>
					</tr>
					<tr>
						<th>备注:</th>
						<td><input name="msgRemark" style="width:95%" value="${obj.msgRemark}" class="easyui-validatebox" data-options="validType:'blength[1,2000]'"/></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<th style="width:100px">备注</th>
			<td><textarea rows="3" cols="87" name="describe" class="easyui-validatebox" data-options="validType:'blength[1,2000]'">${obj.describe}</textarea></td>
		</tr>
		<tr>
			<th style="width:100px">优先级</th>
			<td><input name="priority" value="${obj.priority}" style="width:200px" class="easyui-combobox" data-options="editable:false,required:true,url:'<c:url value="/sys/const/options/PushBatch/priority"/>'"></td>
		</tr>
		<tr>
			<th style="width:100px">控制标志</th>
			<td><input name="control" value="${obj.control}" style="width:200px" class="easyui-combobox" data-options="editable:false,required:true,url:'<c:url value="/sys/const/options/PushBatch/control"/>'"></td>
		</tr>
		<c:if  test="${obj != null && obj.id != null}">
			<tr>
				<th style="width:100px">发送条数</th>
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
		</c:if>
	</table>