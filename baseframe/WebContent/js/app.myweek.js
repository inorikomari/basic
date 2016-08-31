if(!WX.app.planweekperformancedetail) WX.app.planweekperformancedetail={};

WX.app.planweekperformancedetail.getLagDays = function(date){
	var plan = $('planDate').datebox('getValue');
	var over = $('overDate').datebox('getValue');
	
	if(null!=plan&&null!=over){
		plan = plan.replace(/-/g,"/");
		over = over.replace(/-/g,"/");
		
		$('#detail-form-warning').val(false);
		if(Date.parse(over)-Date.parse(plan)>0){
			$('#lagDays').val((Date.parse(over)-Date.parse(plan))/(1000*60*60*24));
			$('#detail-form-planWarn').val(true);
		}else{
			$('#lagDays').val(0);
		}		
	}else{
		$('#lagDays').val(0);
	}
};

WX.app.planweekperformancedetail.getWaringNews = function(value,row,index){
	if(value == false){
		return '<span class ="green">正常</span>';
	}else if(value == true){
		return '<span class = "red">预警</span>';
	}
};

if(!WX.app.planweekperformance) WX.app.planweekperformance = {};

WX.app.planweekperformance.stateFormatter = function(value,row,index){
	if(value == 3){
		return '<span class="green">消除预警</span>';
	}else if(value == 9){
		return '<span class="red">预警</span>';
	}else if(value == 7){
		return '<span class="blue">滞后</span>';
	}else if(value == 1){
		return '<span class="green">已提交</span>';
	}else if(value == 0){
		return '<span class="gray">草稿</span>';
	}
};

if(!WX.app.planweek) WX.app.planweek = {};

WX.app.planweek.flowStateFormatter = function(value,row,index){
	switch(value){
	case 'Init':return '<span class="green">未启动</span>';
	case 'Runing':return '<span class="blue">进行中</span>';
	case 'Accepted':return '<span class="green">同意</span>';
	case 'Denied':return '<span class="red">拒绝</span>';
	case 'Rejected':return '<span class="red">驳回</span>';
	case 'Canceled':return '<span class="gray">取消</span>';
	}
};

WX.app.planweek.choise = function(date){
	var plan = $('weekdetail-fromdate').datebox('getValue');
	var over = $('weekdetail-todate').datebox('getValue');
	if(null!=plan&&null!=over){
		plan = plan.replace(/-/g,"/"); 
		over = over.replace(/-/g,"/"); 
		if(Date.parse(over)-Date.parse(plan)<=0){
			alert('结束时间不能再开始时间之前！！！！！');
		}
	}
};










