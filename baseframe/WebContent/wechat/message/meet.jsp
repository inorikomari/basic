<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/_includes.jsp"%>
<head>
	<script type="text/javascript">
		$(function(){
			$('#dg-pushbatch').wxgrid({
				url       :'<c:url value="/wechat/message/items/1"/>',
				addUrl    :'<c:url value="/wechat/message/addmeet"/>',
				updateUrl :'<c:url value="/wechat/message/updatemeet"/>',
				delUrl    :'<c:url value="/wechat/message/delete"/>',
				lookUrl	  :'<c:url value="/wechat/message/viewmeet"/>',
				editDlg   :'#dlg-pushbatch',
				editForm  :'#fm-pushbatch',
				xdlgtoolbar:['dg-pushbatch-dlg-save2'],
				query:{
					title:'查询会议通知推送批次',
					form:'<c:url value="/wechat/message/querymeet"/>',
					width:450,
					height:380,
					callback:function(){$('.easyui-searchbox').searchbox('setValue','');}
				},
				onLoadSuccess : function(data){
					$('#dg-message-sst').linkbutton('disable');
					$('#dg-message-sct').linkbutton('disable');
				},
				onSelect : function(index, row){
					if(row.status==2||row.status==1){
						$('#dg-message-sst').linkbutton('disable');
						$('#dg-message-sct').linkbutton('disable');
						$('#dg-pushbatch-update').linkbutton('disable');
						$('#dg-pushbatch-del').linkbutton('disable');
					}else{
						$('#dg-pushbatch-update').linkbutton('enable');
						$('#dg-pushbatch-del').linkbutton('enable');
						if(row.control==1){
							$('#dg-message-sst').linkbutton('disable');
							$('#dg-message-sct').linkbutton('enable');
						}else{
							$('#dg-message-sst').linkbutton('enable');
							$('#dg-message-sct').linkbutton('enable');
						}
					}
				},
				onUnselect : function(index, row){
					$('#dg-message-sst').linkbutton('disable');
					$('#dg-message-sct').linkbutton('disable');
				},
				dlgButtons:[
							{
								id:'dg-pushbatch-dlg-save1',
								text:'保存并关闭',
								iconCls:'icon-save1',
								handler:function(){
									$('#dg-pushbatch').wxgrid('submitForm',1);
								}
							},{
								id:'dg-pushbatch-dlg-save3',
								text:'保存并新建',
								iconCls:'icon-save3',
								handler:function(){
									$('#dg-pushbatch').wxgrid('submitForm',3);
								}
							}
						],
				toolbarx : [
							{text:'|'},{
								id:'dg-message-sst',
								text:'提交处理',
								iconCls:'icon-edit',
								handler:function(){ WX.app.message.changestatus(1);}
							},{
								id:'dg-message-sct',
								text:'控制标志变更',
								iconCls:'icon-edit',
								handler:function(){ WX.app.message.changecontrol();}
							}
						]
			});
		});
	</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="north" border="false">
			<div class="subtitle">会议通知推送批次列表</div>
		</div>
		<div region="center" border="false" style="padding:0 5px 5px 5px">
			<table id="dg-pushbatch" title="会议通知推送批次列表">
				<thead>
					<tr>
						<th sortable="true"  width="40"  align="left" field="title">名称</th>
						<th sortable="true"  width="15"  align="left" field="type" showField="typeText">模板类型</th>
						<th sortable="true"  width="10"  align="left" field="count">总条数</th>
						<th sortable="true"  width="60"  align="left" field="groups" showField="groupsText">发送到</th>
						<th sortable="true"  width="40"  align="left" field="describe">描述</th>
						<th sortable="true"  width="20"  align="left" field="onTime">录入时间</th>
						<th sortable="true"  width="15"  align="left" field="inputName">录入人</th>
						<th sortable="true"  width="10"  align="left" field="priority" showField="priorityText" formatter="WX.app.message.levelFormatter">优先级</th>
						<th sortable="true"  width="15"  align="left" field="status" showField="statusText" formatter="WX.app.message.statusFormatter">状态</th>
						<th sortable="true"  width="10"  align="left" field="control" showField="controlText" formatter="WX.app.message.controlFormatter">控制标志</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<div class="easyui-dialog" closed="true"
		id="dlg-pushbatch"
		title="会议通知推送批次"
		style="width:720px;height:450px;position:relative"></div>
</body>