if(!WX.app.planmonthperformdetail) WX.app.planmonthperformdetail = {};

WX.app.planmonthperformdetail.getLagDays = function(date){
	var plan = $('#planDate').datebox('getValue');
	var over = $('#overDate').datebox('getValue');
	if(null!=plan&&null!=over){
		plan = plan.replace(/-/g,"/"); 
		over = over.replace(/-/g,"/"); 
		$('#detail-form-warning').val(false);
		if(Date.parse(over)-Date.parse(plan)>0){
			$('#lagDays').val((Date.parse(over)-Date.parse(plan))/(1000*60*60*24));
			$('#detail-form-warning').val(true);
		}else{
			$('#lagDays').val(0);
		}
	}else{
		$('#lagDays').val(0);
	}
};

WX.app.planmonthperformdetail.getWaringNews = function(value,row,index){
	if(value == false){
		return '<span class="green">正常</span>';
	}if(value == true){
		return '<span class="red">预警</span>';
	}
};

if(!WX.app.planmonthperformance) WX.app.planmonthperformance = {};

WX.app.planmonthperformance.stateFormatter = function(value,row,index){
	if(value == 3){
		return '<span class="green">消除预警</span>';
	}if(value == 9){
		return '<span class="red">预警</span>';
	}if(value == 7){
		return '<span class="blue">滞后</span>';
	}if(value == 1){
		return '<span class="green">已提交</span>';
	}if(value == 0){
		return '<span class="gray">草稿</span>';
	}
};

if(!WX.app.planmonth) WX.app.planmonth = {};

WX.app.planmonth.flowStateFormatter = function(value,row,index){
	switch(value){
		case 'Init':return '<span class="green">未启动</span>';
		case 'Runing':return '<span class="blue">进行中</span>';
		case 'Accepted':return '<span class="green">同意</span>';
		case 'Denied':return '<span class="red">拒绝</span>';
		case 'Rejected':return '<span class="red">驳回</span>';
		case 'Canceled':return '<span class="gray">取消</span>';
	}
};

WX.app.planmonth.choise = function(date){
	var plan = $('#monthdetail-fromda').datebox('getValue');
	var over = $('#monthdetail-toda').datebox('getValue');
	if(null!=plan&&null!=over){
		plan = plan.replace(/-/g,"/"); 
		over = over.replace(/-/g,"/"); 
		if(Date.parse(over)-Date.parse(plan)<=0){
			alert('开始时间结束时间设置错误！！！！！');
		}
	}
};
