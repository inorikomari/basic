if(!WX.app) WX.app = {};

if(!WX.app.assets) WX.app.assets = {};

WX.app.assets.user_change = function(){
	var t = $('#empCode-tree').combotree('tree'); 
	var node = t.tree('getSelected');  
	if(null!=node.attributes.type&&'employee'==node.attributes.type){
		$('#empName').val(node.text);
		var p = WX.app.assets.getUserDept(t, node);
		$('#departmentName').val(p.text);
		$('#departmentId').val(p.id);
	}else{
		$.messager.show({
			title   :'<span class="red">请选择员工</span>',
			msg     : '请选择员工',
			timeout : 10000
		});
		$('#empCode-tree').combotree('clear');
		$('#empName').val('');
		$('#departmentName').val('');
		$('#departmentId').val('');
	}
};

WX.app.assets.user_select = function(){
	var t = $('#empCode-tree').combotree('tree'); 
	var node = t.tree('getSelected');  
	if(null!=node.attributes.type&&'employee'==node.attributes.type){
		$('#empName').val(node.text);
		var p = WX.app.assets.getUserDept(t, node);
		$('#departmentName').val(p.text);
		$('#departmentId').val(p.id);
	}else{
		$.messager.show({
			title   :'<span class="red">请选择员工</span>',
			msg     : '请选择员工',
			timeout : 10000
		});
		$('#empCode-tree').combotree('clear');
		$('#empName').val('');
		$('#departmentName').val('');
		$('#departmentId').val('');
	}
};

WX.app.assets.getUserDept = function(t, node){
	var p = t.tree('getParent',node.target);
	if(null!=p.attributes.type&&'org'==p.attributes.type){
		return p;
	}else{
		return WX.app.assets.getUserDept(t, p);
	}
};

WX.app.assets.isChange = function(){
	var t = $('#empCode-tree').combotree('tree'); 
	var node = t.tree('getSelected');  
	var code_n = node.id;
	var name_n = $('#empName').val();
	var code = $('#empCode_').val();
	var name = $('#empName_').val();
	if(code_n!=code&&name_n!=name)
		return true;
	else
		return false;
};

WX.app.assets.changeuser = function(){
	var wxgrid = 'dg-assets-manage';
	var dlgbutton = [
	  			{
					id:wxgrid+'-dlg-save1',
					text:'保存并关闭',
					iconCls:'icon-save1',
					handler:function(){
						if(WX.app.assets.isChange()){
							$('#'+wxgrid).wxgrid('submitForm',1);
						}else{
							$.messager.show({
								title   :'<span class="red">使用者没有变更</span>',
								msg     : '使用者没有变更',
								timeout : 10000
							});
						}
					}
				}
			];
	var editDlgOpts = null;
	var opts = $('#'+wxgrid).datagrid('options');
	var row = $('#'+wxgrid).datagrid('getSelected');
	if (row){
		var _editDlgOpts = opts.editDlgOpts || {};
		if(!editDlgOpts){
			editDlgOpts = $.extend({},
				$(opts.editDlg).dialog('options'), _editDlgOpts,
				{toolbar:dlgbutton}
			);
		}
		$(opts.editDlg).dialog(editDlgOpts).dialog('open').dialog('refresh', opts.changeUrl+'/'+row.id);
	} else {
		$.messager.show({
			title:'<span class="blue">提示</span>',
			msg:'请先<span class="blue">选择记录</span>后再打开。'
		});
	}
};

WX.app.assets.change = function(type){
	if(1==type){
		$('#assets_div_1').hide();
		$('#assets_div_2').show();
		$('#assets_button_1').hide();
		$('#assets_button_2').show();
	}else{
		$('#assets_div_1').show();
		$('#assets_div_2').hide();
		$('#assets_button_1').show();
		$('#assets_button_2').hide();
	}
};

WX.app.assets.type_select = function(){
	var tt = $('#assets-tree').combotree('tree'); 
	var node1 = tt.tree('getSelected'); 
	$('#pname').val(node1.text);
};

WX.app.assets.reload = function(callback){
	$.messager.progress({text:'正在刷新固定资产分类，请稍候...'});
	$.get(base+'/hr/fixedassets/reload',null,function(data){
		$.messager.progress('close');
		$.messager.show({
			title   : '<span class="green">成功刷新固定资产分类</span>',
			msg     : '成功刷新固定资产分类',
			timeout : 3000,
			showType: 'fade'
		});
		if(callback) callback();
	});
};

WX.app.assets.org_select = function(){
	var node = $('#tree_cont').tree('getSelected');
	var targetTableOption = {
			title	  :'固定资产登记',
			id        : 'dg-assets-manage',
			url       :base+'/hr/assets-manage/items2/'+node.id,
			addUrl    :base+'/hr/assets-manage/add',
			updateUrl :base+'/hr/assets-manage/update',
			delUrl    :base+'/hr/assets-manage/delete',
			lookUrl   :base+'/hr/assets-manage/view',
			editDlg   :'#dlg-assets-manage',
			editForm  :'#fm-assets-manage',
			query:{
				title:'查询固定资产登记表',
				form:base+'/hr/assets-manage/query',
				width:450,
				height:380,
				callback:function(){$('.easyui-searchbox').searchbox('setValue','');}
			},
			onLoadSuccess : function(data){
				$('#dg-assets-manage-add').linkbutton('enable');
				$('#dg-assets-manage-update').linkbutton('disable');
				$('#dg-assets-manage-del').linkbutton('disable');
			},
			onSelect : function(index, row){
				$('#dg-assets-manage-update').linkbutton('enable');
				$('#dg-assets-manage-del').linkbutton('enable');
			},
			onUnselect : function(index, row){
				$('#dg-assets-manage-update').linkbutton('disable');
				$('#dg-assets-manage-del').linkbutton('disable');
			}
		};
	$(function(){
		$('#dg-assets-manage').wxgrid(targetTableOption);
	});
};

WX.app.assets.assetstype_select = function(){
	var node = $('#tree_assets').tree('getSelected');
	var targetTableOption = {
			title	  :'固定资产登记',
			id        : 'dg-assets-manage',
			url       :base+'/hr/assets-manage/items/'+node.id,
			addUrl    :base+'/hr/assets-manage/add',
			updateUrl :base+'/hr/assets-manage/update',
			delUrl    :base+'/hr/assets-manage/delete',
			lookUrl   :base+'/hr/assets-manage/view',
			editDlg   :'#dlg-assets-manage',
			editForm  :'#fm-assets-manage',
			query:{
				title:'查询固定资产登记表',
				form:base+'/hr/assets-manage/query',
				width:450,
				height:380,
				callback:function(){$('.easyui-searchbox').searchbox('setValue','');}
			},
			onLoadSuccess : function(data){
				$('#dg-assets-manage-add').linkbutton('enable');
				$('#dg-assets-manage-update').linkbutton('disable');
				$('#dg-assets-manage-del').linkbutton('disable');
			},
			onSelect : function(index, row){
				$('#dg-assets-manage-update').linkbutton('enable');
				$('#dg-assets-manage-del').linkbutton('enable');
			},
			onUnselect : function(index, row){
				$('#dg-assets-manage-update').linkbutton('disable');
				$('#dg-assets-manage-del').linkbutton('disable');
			}
		};
	$(function(){
		$('#dg-assets-manage').wxgrid(targetTableOption);
	});
};

if(!WX.app.contract) WX.app.contract = {};

WX.app.contract.org_select = function(){
	var node = $('#tree_cont').tree('getSelected');
	$('#dg-contract').wxgrid({
		url       :base+'/hr/contract/items/'+node.id,
		addUrl    :base+'/hr/contract/add',
		updateUrl :base+'/hr/contract/update',
		delUrl    :base+'/hr/contract/delete',
		lookUrl   :base+'/hr/contract/view',
		editDlg   :'#dlg-contract',
		editForm  :'#fm-contract',
		query:{
			title:'查询合同档案',
			form:base+'/hr/contract/query',
			width:450,
			height:380,
			callback:function(){$('.easyui-searchbox').searchbox('setValue','');}
		}
	});
};

WX.app.contract.dateValidate = function(){
	var val = $('#timelimit').combobox('getText');
	if('是'==val){
		var endDate = $('#endDate').datebox('getValue');
		if(null==endDate||''==endDate){
			$.messager.show({
				title:'<span class="red">警告</span>',
				msg:'固定期限合同请填写合同截止日期'
			});
			$('#endDate').focus();
			return false;
		}
	}
	return true;
};

WX.app.contract.user_select = function(){
	var t = $('#empCode-tree').combotree('tree'); 
	var node = t.tree('getSelected');  
	if(null!=node.attributes.type&&'employee'==node.attributes.type){
		$('#empName').val(node.text);
	}else{
		$.messager.show({
			title   :'<span class="red">请选择员工</span>',
			msg     : '请选择员工',
			timeout : 10000
		});
		$('#empCode-tree').combotree('clear');
		$('#empName').val('');
	}
};

if(!WX.app.employee) WX.app.employee = {};

WX.app.employee.openupload = function(){
	$('#fileInput').click();
};

WX.app.employee.doupload= function(){
	$('#avatar-up').form('submit',{
		url : base + '/sys/file/xupload/file',
		success:function(result){
			result = $.parseJSON(result);
		}
	});
	alert($('#avatar-up').form);
};

WX.app.employee.transferSave = function(){
	$('#dg-transfers').edatagrid('saveRow');
	var row = $('#dg-transfers').datagrid('getSelected');
	if(0==row.action){
		$('#emp_state').combobox('setValue',1);
	}else if(1==row.action){
		$('#emp_state').combobox('setValue',2);
	}
	$('#dg-employee').datagrid('reload');
};

WX.app.employee.quickstate = function(state){
	var opt = $('#dg-employee').datagrid('options');
	var dg = $('#dg-employee');
	var param = {};
	if(3!=state)
		param['eq_state'] = state;
	else
		param['ne_state'] = state;
	dg.datagrid('load', param);
	if (opt.query.callback){
		opt.query.callback();
	}
};

WX.app.employee.quickdate = function(type){
	var opt = $('#dg-employee').datagrid('options');
	var dg = $('#dg-employee');
	var   now = new Date();   
	var firstday = new Date(now.getFullYear(),now.getMonth(),1);
	firstday = firstday.getFullYear() +'-'+ (firstday.getMonth()+1) +'-'+ firstday.getDate();
	var next = new Date(now.getFullYear(),now.getMonth()+1,1);   
	var lastday = new Date(next-86400000);
	lastday = lastday.getFullYear() +'-'+ (lastday.getMonth()+1) +'-'+ lastday.getDate();
	var param = {};
	if(1==type){
		param['ge_entryDate'] = firstday;
		param['le_entryDate'] = lastday;
	}else if(2==type){
		param['ge_exitDate'] = firstday;
		param['le_exitDate'] = lastday;
	}else{
		param['ge_birthday'] = firstday;
		param['le_birthday'] = lastday;
	}
	dg.datagrid('load', param);
	if (opt.query.callback){
		opt.query.callback();
	}
};

WX.app.employee.org_select = function(){
	var node = $('#tree_emp').tree('getSelected');
	$('#dg-employee').wxgrid({
		url       :base+'/hr/employee/items/'+node.id,
		addUrl    :base+'/hr/employee/add',
		updateUrl :base+'/hr/employee/update',
		delUrl    :base+'/hr/employee/delete',
		lookUrl   :base+'/hr/employee/view',
		editDlg   :'#dlg-employee',
		editForm  :'#fm-employee',
		query:{
			title:'查询员工档案',
			form:base+'/hr/employee/query',
			width:450,
			height:380,
			callback:function(){$('.easyui-searchbox').searchbox('setValue','');}
		},
		toolbarx : [
					{text:'|'},{
						id:'dg-employee-state-1',
						text:'在职查询',
						iconCls:'icon-search',
						handler:function(){ WX.app.employee.quickstate(1);}
					},{
						id:'dg-employee-state-2',
						text:'离职查询',
						iconCls:'icon-search',
						handler:function(){ WX.app.employee.quickstate(2);}
					},{
						id:'dg-employee-state-3',
						text:'全部查询',
						iconCls:'icon-search',
						handler:function(){ WX.app.employee.quickstate(3);}
					},{text:'|'},{
						id:'dg-employee-qs-1',
						text:'本月入职',
						iconCls:'icon-search',
						handler:function(){ WX.app.employee.quickdate(1);}
					},{
						id:'dg-employee-qs-2',
						text:'本月离职',
						iconCls:'icon-search',
						handler:function(){ WX.app.employee.quickdate(2);}
					},{
						id:'dg-employee-qs-3',
						text:'本月生日',
						iconCls:'icon-search',
						handler:function(){ WX.app.employee.quickdate(3);}
					}
				]
	});
};

if(!WX.app.workallocate) WX.app.workallocate = {};

WX.app.workallocate.worktouser = function(){
	$('#tabs-allocate').tabs('getTab','按项目分配').panel('refresh', base+'/oa/workallocate/work');
};

WX.app.workallocate.usertowork = function(){
	$('#tabs-allocate').tabs('getTab','按人员分配').panel('refresh', base+'/oa/workallocate/user');
};

WX.app.workallocate.work_select = function(){
	var node = $('#tree_worktype').tree('getSelected');
	var type = 1;
	$('#dg-user').wxgrid({
		url       :base+'/oa/workallocate/items/'+node.id+'/'+type,
		addUrl    :'<c:url value="/oa/workallocate/add"/>',
		delUrl    :'<c:url value="/oa/workallocate/delete"/>',
		xtoolbar  :['dg-user-update','dg-user-look','dg-user-excel'],
		query:{
			title:'查询用户',
			form:'<c:url value="/oa/workallocate/query"/>',
			width:450,
			height:180,
			callback:function(){$('.easyui-searchbox').searchbox('setValue','');}
		}
	});
};

if(!WX.app.worklog) WX.app.worklog = {};
WX.app.worklog.statusFormatter = function(value,row,index){
	if(value == 1){
		return '<span class="red">已提交</span>';
	}else{
		return '<span class="green">草稿</span>';
	}
};
WX.app.worklog.placeFormatter = function(value,row,index){
	if(value == 0){
		return '公司';
	}else if(value == 1){
		return '客户单位';
	}else if(value == 2){
		return '外地';
	}else if(value == 3){
		return '在家';
	}else{
		return '其他';
	}
};

if(!WX.app.worktype) WX.app.worktype = {};
WX.app.worktype.reload = function(callback){
	$.messager.progress({text:'正在刷新分类，请稍候...'});
	$.get(base+'/oa/worktype/reload',null,function(data){
		$.messager.progress('close');
		$.messager.show({
			title   : '<span class="green">成功刷新分类</span>',
			msg     : '成功刷新分类',
			timeout : 3000,
			showType: 'fade'
		});
		if(callback) callback();
	});
};

WX.app.worktype.add = function(){
	var node = $('#tree_worktype').tree('getSelected');
	var _title = '增加分类';
	var _pid = null;

	if(node){
		 _title += '：上级【<span class="red">'+node.text+'</span>】';
		 _pid = node.id;
	}else{
		 _title += '：顶级';
	}
	$.messager.prompt(_title,'请输入新分类的名称',function(r){
		if(!r){
			return false;
		}
		var _type = null;
		if(_pid){
			_type = {name : r, pid : _pid, nu : 0};
		}else{
			_type = {name : r, nu : 0};
		}
		$.post(base + '/oa/worktype/add', _type, function(result){
			if (result.success){
				$.messager.show({
					title:'<span class="green">提示</span>',
					msg:result.msg || '添加分类成功'
				});
				$('#tree_worktype').tree('reload');
			} else {
				$.messager.show({
					title:'<span class="red">警告</span>',
					msg:result.msg || '添加分类失败'
				});
			}
		},'json');
	});
};

WX.app.worktype.rename = function(nodeId, nodeName){
	$.post(base + '/oa/worktype/rename',{id : nodeId, name : nodeName},function(result){
		if (result.success){
			$.messager.show({
				title:'<span class="green">提示</span>',
				msg:result.msg || '更新分类成功'
			});
		} else {
			$.messager.show({
				title:'<span class="red">警告</span>',
				msg:result.msg || '更新分类失败'
			});
			$('#tree_worktype').tree('reload');
		}
	},'json');
};

WX.app.worktype.del = function(){
	var node = $('#tree_worktype').tree('getSelected');
	if(node){
		$.messager.confirm('<span class="red">警告</span>','删除后不可恢复，是否真的<span class="red">删除</span>【'+node.text+'】？',function(r){
			if (r){
				$.delete_(base + '/oa/worktype/delete/'+node.id, {}, function(result){
					if (result.success){
						$.messager.show({
							title:'<span class="green">提示</span>',
							msg:result.msg || '删除分类成功'
						});
						$('#tree_worktype').tree('reload');
					} else {
						$.messager.show({
							title:'<span class="red">警告</span>',
							msg:result.msg || '删除分类失败'
						});
					}
				},'json');
			}
		});
	}
};
WX.app.worktype.move = function(target, source, point){
	var targetId = $(target).attr('node-id');
	var targetName = $(target).text();
	var sourceId = source.id;
	var sourceName = source.name;

	$.post(base + '/oa/worktype/move',{sourceId : sourceId, targetId : targetId, point : point},function(result){
		if (result.success){
			$.messager.show({
				title:'<span class="green">提示</span>',
				msg:result.msg || '移动分类成功'
			});
		} else {
			$.messager.show({
				title:'<span class="red">警告</span>',
				msg:result.msg || '移动分类失败'
			});
			$('#tree_worktype').tree('reload');
		}
	},'json');
};

WX.app.worktype.view = function(){
	if(!editNodeId) return;
	$('#tabs-worktype').tabs('getTab','基本信息').panel('refresh', base+'/oa/worktype/view/'+editNodeId);
};

WX.app.worktype.openUpdate = function(){
	if(!editNodeId) return;
	$('#tabs-worktype').tabs('getTab','编辑信息').panel('refresh', base+'/oa/worktype/update/'+editNodeId);
};

WX.app.worktype.update = function(){
	$('#fm-worktype').form('submit', {
		url : base + '/oa/worktype/update',
		onSubmit:function(){
			WX.kesync();
			var isValid = $(this).form('validate');
			if (isValid){
				$.messager.progress({text:'正在提交数据，请稍候...'});
			}
			return isValid;
		},
		success:function(result){
			$.messager.progress('close');
			if(result != null && result.isJSON()) {
				result = $.parseJSON(result);
			} else {
				$.messager.show({title : '<span class="red">警告</span>', msg : result});
				return false;
			}
			var msg = result.msg || result.detailMessage || '保存数据发生错误';
			if (result.success){
				$.messager.show({
					title   : '<span class="green">保存成功</span>',
					msg     : result.msg || '数据保存成功',
					timeout : 3000,
					showType: 'fade'
				});
			} else {
				$.messager.show({
					title   :'<span class="red">保存错误</span>',
					msg     : msg,
					timeout : 10000
				});
			}
		}
	});
};
