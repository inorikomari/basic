if(!WX.app) WX.app = {};

if(!WX.app.message) WX.app.message = {};

WX.app.message.addfile = function(target){
	var editDlgOpts = null;
	var opts = $('#'+target).datagrid('options');
	var _editDlgOpts = opts.editDlgOpts || {};
	if(!editDlgOpts){
		editDlgOpts = $.extend({},
			$(opts.editDlg).dialog('options'), _editDlgOpts,
			{toolbar:opts.dlgButtons}
		);
	}
	$(opts.editDlg).dialog(editDlgOpts).dialog('open').dialog('refresh', opts.addFileUrl);
};

WX.app.message.levelFormatter = function(value,row,index){
	if(value == 0){
		return '<span class="red"><b>高</b></span>';
	}else if(value == 5){
		return '<span class="purple">普通</span>';
	}else{
		return '<span class="gray">低</span>';
	}
};

WX.app.message.statusFormatter = function(value,row,index){
	if(value == 0){
		return '<span class="green">已登记</span>';
	}else if(value == 1){
		return '<span class="red">待处理</span>';
	}else{
		return '<span class="blue">已处理</span>';
	}
};

WX.app.message.controlFormatter = function(value,row,index){
	if(value == 1){
		return '<span class="red">无效</span>';
	}else{
		return '<span class="green">有效</span>';
	}
};

WX.app.message.changetype = function(text){
	var info ='';
	if('会议通知'==text){
		info = '会议通知模板文件内容请按"<span style="color:red">身份证号|姓名|标题|内容|会议时间|会议地点|参与人员|备注</span>"格式正确填写数据';
	}else if('签约提醒'==text){
		info = '签约提醒模板文件内容请按"<span style="color:red">身份证号|姓名|标题|内容|服务名|有效期|备注</span>"格式正确填写数据';
	}
	$('#typeinfo').html(info);
};

WX.app.message.changestatus = function(status){
	var row = $('#dg-pushbatch').datagrid('getSelected');
	$.messager.confirm('<span class="red">确认</span>','是否真的<span class="red">提交处理</span>【'+row.title+'】？',function(r){
		if (r){
			$.post(base + '/wechat/message/changes/'+row.id+'/'+status, {}, function(result){
				if (result.success){
					$.messager.show({
						title:'<span class="green">提示</span>',
						msg:result.msg
					});
					$('#dg-pushbatch').datagrid('reload');
				} else {
					$.messager.show({
						title:'<span class="red">警告</span>',
						msg:result.msg
					});
				}
			},'json');
		}
	});
};

WX.app.message.changecontrol = function(){
	var row = $('#dg-pushbatch').datagrid('getSelected');
	var st,control;
	if(row.control==0){
		st = '无效';
		control = 1;
	}else{
		st = '有效';
		control = 0;
	}
	$.messager.confirm('<span class="red">确认</span>','是否真的将<span class="red">【'+row.title+'】</span>设置为'+st+'？',function(r){
		if (r){
			$.post(base + '/wechat/message/control/'+row.id+'/'+control, {}, function(result){
				if (result.success){
					$.messager.show({
						title:'<span class="green">提示</span>',
						msg:result.msg
					});
					$('#dg-pushbatch').datagrid('reload');
				} else {
					$.messager.show({
						title:'<span class="red">警告</span>',
						msg:result.msg
					});
				}
			},'json');
		}
	});
};

if(!WX.app.template) WX.app.template = {};
WX.app.template.reload = function(callback){
	$.messager.progress({text:'正在刷新模板类型缓存，请稍候...'});
	$.get(base+'/wechat/template/reload',null,function(data){
		$.messager.progress('close');
		$.messager.show({
			title   : '<span class="green">成功刷新模板类型缓存</span>',
			msg     : '成功刷新模板类型缓存',
			timeout : 3000,
			showType: 'fade'
		});
		if(callback) callback();
	});
};

if(!WX.app.employee) WX.app.employee = {};
WX.app.employee.reload = function(callback){
	$.messager.progress({text:'正在刷新员工信息缓存，请稍候...'});
	$.get(base+'/wechat/employee/reload',null,function(data){
		$.messager.progress('close');
		$.messager.show({
			title   : '<span class="green">成功刷新员工信息缓存</span>',
			msg     : '成功刷新员工信息缓存',
			timeout : 3000,
			showType: 'fade'
		});
		if(callback) callback();
	});
};
