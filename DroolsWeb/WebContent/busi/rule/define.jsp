<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html style="height:100%" lang='zh-CN' xml:lang='zh-CN' xmlns='http://www.w3.org/1999/xhtml'>
<head>
<%@ include file="/common/include/_includes.jsp"%>
<%
	String basePath = request.getContextPath();
%>
<title>Drool</title>
</head>
<body>
<c:if test="${obj!=null }">
	<div align="right">
		<a class="easyui-linkbutton" id="addrule" data-options="iconCls:'icon-add'"> 添加规则</a>
	</div>
	<hr />
	<div id="_property"></div>
	<div id="rules">

	</div>
	<br/>
	<br/>
	<hr />
	<div align="right">
		<a class="easyui-linkbutton" id="addweights" data-options="iconCls:'icon-add'"> 添加加权规则</a>
	</div>
	<hr />
	<div id="weights"></div>
	<br />
	<hr />
	<div align="center">
		<a class="easyui-linkbutton" id="saverule" data-options="iconCls:'icon-save'"> 生成模型</a>
	</div>
	<!--
	<div id="scores" style="border:2px solid gray;padding-top: 10px;padding-left: 10px;padding-bottom: 10px" >
		<form id="scoresfm"/>
	</div>
	 -->
	<br /><br /><br /><br />
	<script type="text/javascript">
	//添加规则方法
	$("#addrule").bind("click",function(){
		var rules = $("#rules");
		var rulenxt = 0;
		rules.children().each(function(i,n){
			var obj = $(n);
			if(obj.attr('id')!=null){
				var cur = obj.attr('id').substr(5);
				if(rulenxt<cur)
					rulenxt = cur;
			}
		});
		rulenxt = parseInt(rulenxt)+1;
		
		var html = '<br/><div id="rule-'+rulenxt+'" style="border:2px solid gray;padding-top: 10px;padding-left: 10px;padding-bottom: 10px">'
		+'<span><b>规则'+rulenxt+':&nbsp;</b></span><form id="rule-'+rulenxt+'-fm-1"><input type="hidden" name="ruleId" value="'+rulenxt+'" /><input type="hidden" name="conditionId" value="1" /><input type="hidden" name="modelId" value="${obj.modelId}" />'
		+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-combobox" name="attribute" id="rule-'+rulenxt+'-fd-1" style="width:150px" />&nbsp;'
		+'<input class="easyui-combobox" name="expression" id="rule-'+rulenxt+'-op-1" style="width:80px" />&nbsp;'
		+'<input class="easyui-combobox" name="values" id="rule-'+rulenxt+'-kv-1" style="width:150px" />&nbsp;</form>'
		+'<a class="easyui-linkbutton addEx" id="rule-'+rulenxt+'-btn" ruleno="'+rulenxt+'" exno="1" >添加条件</a><br /><hr width="95%"/><span><b>评分项:</b></span><br />'
		+'<form id="rule-'+rulenxt+'-sfm-1"><input type="hidden" name="ruleId" value="'+rulenxt+'" /><input type="hidden" name="conditionId" value="999" /><input type="hidden" name="conditionType" value="then" />'
		+'<input type="hidden" name="modelId" value="${obj.modelId}" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-combobox" name="attribute" id="rule-'+rulenxt+'-sc-1" style="width:150px" />&nbsp;'
		+'<input class="easyui-combobox" name="expression" id="rule-'+rulenxt+'-ca-1" style="width:80px" />&nbsp;'
		+'<input class="easyui-combobox" name="values" id="rule-'+rulenxt+'-va-1" style="width:150px" /></form>'
		+'<a class="easyui-linkbutton addSc" id="rule-'+rulenxt+'-score-btn" ruleno="'+rulenxt+'" exno="1" >添加评分项</a><br /></div>';
		$("#rules").append(html);
		rebuEx('rule',rulenxt,1);
		$("#rule-"+rulenxt+"-btn").linkbutton({
			iconCls:'icon-add'
		});
		$("#rule-"+rulenxt+"-score-btn").linkbutton({
			iconCls:'icon-add'
		});
		$("#rule-"+rulenxt+"-sc-1").combobox({
			url:'<c:url value="/busi/rule/grade/list/"/>${obj.modelId}',
			editable:false,
			required:true
		});
		$("#rule-"+rulenxt+"-ca-1").combobox({
			url:'<c:url value="/countOperators"/>',
			editable:false,
			required:true
		});
		$("#rule-"+rulenxt+"-va-1").combobox({
			required:true
		});
		$("#rule-"+rulenxt+"-va-1").numberbox({
			min:0,
			precision:1,
			required:true,
			missingMessage:'请输入一个数字值'
		});
		$("#rule-"+rulenxt+"-btn").bind("click",function(){
			var ruleno = $("#"+this.id).attr('ruleno');
			var nxt = parseInt($("#"+this.id).attr('exno'))+1;
			$("#"+this.id).attr('exno',nxt);
			addExF('rule',ruleno,nxt);
			rebuEx('rule',ruleno,nxt);
		});
		$("#rule-"+rulenxt+"-score-btn").bind("click",function(){
			var ruleno = $("#"+this.id).attr('ruleno');
			var nxt = parseInt($("#"+this.id).attr('exno'))+1;
			$("#"+this.id).attr('exno',nxt);
			addScF(ruleno,nxt);
			rebuSc(ruleno,nxt);
		});
	});
	
	$("#addweights").bind("click",function(){
		var weights = $("#weights");
		var wtnxt = 0;
		weights.children().each(function(i,n){
			var obj = $(n);
			if(obj.attr('id')!=null){
				var cur = obj.attr('id').substr(8);
				if(wtnxt<cur)
					wtnxt = cur;
			}
		});
		wtnxt = parseInt(wtnxt)+1;
		
		var html = '<br/><div id="weights-'+wtnxt+'" style="border:2px solid gray;padding-top: 10px;padding-left: 10px;padding-bottom: 10px">'
		+'<span><b>加权规则'+wtnxt+':&nbsp;</b></span><form id="weights-'+wtnxt+'-fm-1"><input type="hidden" name="ruleId" value="'+wtnxt+'" /><input type="hidden" name="conditionId" value="1" /><input type="hidden" name="modelId" value="${obj.modelId}" />'
		+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-combobox" name="attribute" id="weights-'+wtnxt+'-fd-1" style="width:150px" />&nbsp;'
		+'<input class="easyui-combobox" name="expression" id="weights-'+wtnxt+'-op-1" style="width:80px" />&nbsp;'
		+'<input class="easyui-combobox" name="values" id="weights-'+wtnxt+'-kv-1" style="width:150px" />&nbsp;</form>'
		+'<a class="easyui-linkbutton addWtEx" id="weights-'+wtnxt+'-btn" ruleno="'+wtnxt+'" exno="1" >添加条件</a><br /><hr width="95%"/><span><b>加权项:</b></span><br />'
		+'<form id="weights-'+wtnxt+'-sfm-1"><input type="hidden" name="ruleId" value="'+wtnxt+'" /><input type="hidden" name="conditionId" value="999" /><input type="hidden" name="conditionType" value="then" />'
		+'<input type="hidden" name="modelId" value="${obj.modelId}" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-combobox" name="attribute" id="weights-'+wtnxt+'-sc-1" style="width:150px" />&nbsp;'
		+'<b> * 权系数:</b>&nbsp;'
		+'<input class="easyui-combobox" name="values" id="weights-'+wtnxt+'-va-1" style="width:150px" /></form>'
		+'<a class="easyui-linkbutton addWtSc" id="weights-'+wtnxt+'-score-btn" ruleno="'+wtnxt+'" exno="1" >添加加权项</a><br /></div>';
		$("#weights").append(html);
		rebuEx('weights',wtnxt,1);
		$("#weights-"+wtnxt+"-btn").linkbutton({
			iconCls:'icon-add'
		});
		$("#weights-"+wtnxt+"-score-btn").linkbutton({
			iconCls:'icon-add'
		});
		$("#weights-"+wtnxt+"-sc-1").combobox({
			url:'<c:url value="/busi/rule/grade/list/"/>${obj.modelId}',
			editable:false,
			required:true
		});
		$("#weights-"+wtnxt+"-ca-1").combobox({
			url:'<c:url value="/countOperators"/>',
			editable:false,
			required:true
		});
		$("#weights-"+wtnxt+"-va-1").combobox({
			required:true,
			validType:'number'
		});
		$("#weights-"+wtnxt+"-btn").bind("click",function(){
			var ruleno = $("#"+this.id).attr('ruleno');
			var nxt = parseInt($("#"+this.id).attr('exno'))+1;
			$("#"+this.id).attr('exno',nxt);
			addExF('weights',ruleno,nxt);
			rebuEx('weights',ruleno,nxt);
		});
		$("#weights-"+wtnxt+"-score-btn").bind("click",function(){
			var ruleno = $("#"+this.id).attr('ruleno');
			var nxt = parseInt($("#"+this.id).attr('exno'))+1;
			$("#"+this.id).attr('exno',nxt);
			addWtScF(ruleno,nxt);
		});
	});
	
	//保存规则
	$("#saverule").bind("click",function(){
		$.ajax({
            cache: true,
            type: "POST",
            url:'<c:url value="/busi/rule/truncaterules/" />${obj.modelId}'
        });
		var suc = true;
		$("form").each(function(i,n){
			var obj = $(n);
			var url = '';
			if(obj.attr('id')!=null){
				if(-1==obj.attr('id').indexOf('weights')){
					url = '<c:url value="/busi/rule/saverule" />';
				}else{
				//	url = '<c:url value="/busi/rule/savescore" />';
					url = '<c:url value="/busi/rule/saveweights" />';
				}
				$.ajax({
	                cache: true,
	                type: "POST",
	                url:url,
	                dataType:'json',
	                data:obj.serialize(),
	                async: false,
	                success:function(result){
	    				if(!result.success){
	    					suc = false;
	    				}
	    			}
	            });
			}
		});
		if(suc){
			$.ajax({
                cache: true,
                type: "POST",
                url:'<c:url value="/busi/rule/generatedrl/" />${obj.modelId}',
                dataType:'json',
                async: false,
                success:function(result){
    				if(result.success){
    					$.messager.show({
    						title   : '<span class="green">保存成功</span>',
    						msg     : '模型规则保存成功',
    						timeout : 3000,
    						showType: 'fade'
    					});
    				}
    			}
            });
			
			$('#dlg-rule-def').dialog('close');
		}else{
			$.messager.show({
				title   : '<span class="red">保存失败</span>',
				msg     : '模型规则保存失败',
				timeout : 3000,
				showType: 'fade'
			});
		}
	});
	
	//添加条件
	function addExF(type,ruleno,nxt){
		var html = '<form id="'+type+'-'+ruleno+'-fm-'+nxt+'"><input type="hidden" name="ruleId" value="'+ruleno+'" /><input type="hidden" name="conditionId" value="'+nxt+'" /><input type="hidden" name="modelId" value="${obj.modelId}" />'
		+'<input class="easyui-combobox" name="relation" id="'+type+'-'+ruleno+'-lo-'+nxt+'" style="width:53px" />&nbsp;'
		+'<input class="easyui-combobox" name="attribute" id="'+type+'-'+ruleno+'-fd-'+nxt+'" style="width:150px" />&nbsp;'
		+'<input class="easyui-combobox" name="expression" id="'+type+'-'+ruleno+'-op-'+nxt+'" style="width:80px" />&nbsp;'
		+'<input class="easyui-combobox" name="values" id="'+type+'-'+ruleno+'-kv-'+nxt+'" style="width:150px" /></form>';
		$(html).insertBefore("#"+type+"-"+ruleno+"-btn");
	}
	
	//添加评分项
	function addScF(ruleno,nxt){
		var html = '<form id="rule-'+ruleno+'-sfm-'+nxt+'"><input type="hidden" name="ruleId" value="'+ruleno+'" /><input type="hidden" name="conditionId" value="999" /><input type="hidden" name="conditionType" value="then" />'
		+'<input type="hidden" name="modelId" value="${obj.modelId}" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-combobox" name="attribute" id="rule-'+ruleno+'-sc-'+nxt+'" style="width:150px" />&nbsp;'
		+'<input class="easyui-combobox" name="expression" id="rule-'+ruleno+'-ca-'+nxt+'" style="width:80px" />&nbsp;'
		+'<input class="easyui-combobox" name="values" id="rule-'+ruleno+'-va-'+nxt+'" style="width:150px" /></form>';
		$(html).insertBefore("#rule-"+ruleno+"-score-btn");
	}
	
	function addWtScF(ruleno,nxt){
		var html = '<form id="weights-'+ruleno+'-sfm-'+nxt+'"><input type="hidden" name="ruleId" value="'+ruleno+'" /><input type="hidden" name="conditionId" value="999" /><input type="hidden" name="conditionType" value="then" />'
		+'<input type="hidden" name="modelId" value="${obj.modelId}" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-combobox" name="attribute" id="weights-'+ruleno+'-sc-'+nxt+'" style="width:150px" />&nbsp;'
		+'<b> * 权系数:</b>&nbsp;'
		+'<input class="easyui-combobox" name="values" id="weights-'+ruleno+'-va-'+nxt+'" style="width:150px" /></form>';
		$(html).insertBefore("#weights-"+ruleno+"-score-btn");
		$("#weights-"+ruleno+"-sc-"+nxt).combobox({
			url:'<c:url value="/busi/rule/grade/list/"/>${obj.modelId}',
			editable:false,
			required:true
		});
		$("#weights-"+ruleno+"-va-"+nxt).combobox({
			required:true
		});
	}
	
	//重建条件控件
	function rebuEx(type,ruleno,nxt){
		$("#"+type+"-"+ruleno+"-lo-"+nxt).combobox({
			url:'<c:url value="/logical"/>',
			editable:false,
			required:true
		});
		$("#"+type+"-"+ruleno+"-fd-"+nxt).combobox({
			url:'<c:url value="/busi/rule/field/list/"/>${obj.modelId}',
			editable:false,
			required:true,
			onSelect:function(rec){
				var cid = this.id;
				selectProperty(rec,cid);
			}
		});
		$("#"+type+"-"+ruleno+"-op-"+nxt).combobox({
			url:'<c:url value="/operators"/>',
			editable:false,
			required:true
		});
		$("#"+type+"-"+ruleno+"-kv-"+nxt).combobox({
			editable:true,
			required:true
		});
	}
	
	//重建评分控件
	function rebuSc(ruleno,nxt){
		$("#rule-"+ruleno+"-sc-"+nxt).combobox({
			url:'<c:url value="/busi/rule/grade/list/"/>${obj.modelId}',
			editable:false,
			required:true
		});
		$("#rule-"+ruleno+"-ca-"+nxt).combobox({
			url:'<c:url value="/countOperators"/>',
			editable:false,
			required:true
		});
		$("#rule-"+ruleno+"-va-"+nxt).combobox({
			required:true
		});
	}
	
	function buildExistRules(){
		$(".easyui-linkbutton").linkbutton({});
	    $(".addSc").bind("click",function(){
			var ruleno = $("#"+this.id).attr('ruleno');
			var nxt = parseInt($("#"+this.id).attr('exno'))+1;
			$("#"+this.id).attr('exno',nxt);
			addScF(ruleno,nxt);
			rebuSc(ruleno,nxt);
		});
	    $(".addEx").bind("click",function(){
			var ruleno = $("#"+this.id).attr('ruleno');
			var nxt = parseInt($("#"+this.id).attr('exno'))+1;
			$("#"+this.id).attr('exno',nxt);
			addExF('rule',ruleno,nxt);
			rebuEx('rule',ruleno,nxt);
		});
	    
	    $(".addWtSc").bind("click",function(){
			var ruleno = $("#"+this.id).attr('ruleno');
			var nxt = parseInt($("#"+this.id).attr('exno'))+1;
			$("#"+this.id).attr('exno',nxt);
			addWtScF(ruleno,nxt);
		});
	    $(".addWtEx").bind("click",function(){
			var ruleno = $("#"+this.id).attr('ruleno');
			var nxt = parseInt($("#"+this.id).attr('exno'))+1;
			$("#"+this.id).attr('exno',nxt);
			addExF('weights',ruleno,nxt);
			rebuEx('weights',ruleno,nxt);
		});
	    
	    $(".easyui-combobox").each(function(i,n){
			var obj = $(n);
			if(obj.attr('id')!=null){
				if(-1!=obj.attr('id').indexOf('-fd-')){
					obj.combobox({
						url:'<c:url value="/busi/rule/field/list/"/>${obj.modelId}',
						editable:false,
						required:true,
						onSelect:function(rec){
							var cid = this.id;
							selectProperty(rec,cid);
						}
					});
				}else if(-1!=obj.attr('id').indexOf('-op-')){
					obj.combobox({
						url:'<c:url value="/operators"/>',
						editable:false,
						required:true
					});
				}else if(-1!=obj.attr('id').indexOf('-lo-')){
					obj.combobox({
						url:'<c:url value="/logical"/>',
						editable:false,
						required:true
					});
				}else if(-1!=obj.attr('id').indexOf('-sc-')){
					obj.combobox({
						url:'<c:url value="/busi/rule/grade/list/"/>${obj.modelId}',
						editable:false,
						required:true
					});
				}else if(-1!=obj.attr('id').indexOf('-ca-')){
					obj.combobox({
						url:'<c:url value="/countOperators"/>',
						editable:false,
						required:true
					});
				}else{
					if('none'!=obj.attr('data')){
						var dd = data2obj(obj.attr('data'));
						obj.combobox({
							valueField: 'id',
							textField: 'text',
							data:dd,
							required:true
						});
					}else{
						obj.combobox({
							required:true
						});
					}
				}
			}
		});
	}
	
	function selectProperty(rec,cid){
		var o = $('#'+$('#'+rec.id).attr('id'));
		var t = $('#'+cid.replace('fd','kv'));
		var data = o.attr('data');
		if('none'!=data){
			var obj = data2obj(data);
			t.combobox({
				valueField: 'id',
				textField: 'text',
				data:obj,
				required:true
			});
		}
	}
	
	function data2obj(data){
		var obj = new Array();
		var arr = data.split(",");
		for(var i=0;i<arr.length;i++){
			var p = arr[i].split(":");
			var d = {id:p[0],text:p[1]};
			obj.push(d);
		}
		return obj;
	}
	
		$.ajax({
			url:'<c:url value="/busi/rule/properties/"/>${obj.modelId}',
		  	cache: false,
		 	processData: false,
		  	success: function(data){
			var html = data.replace('null','');
		    $("#_property").append(html);
		  }
		});
		
		$.ajax({
			url:'<c:url value="/busi/rule/existrules/"/>${obj.modelId}',
		  	cache: false,
		 	processData: false,
		  	success: function(data){
			var html = data.replace('null','');
		    $("#rules").append(html);
		  }
		});
		
		$.ajax({
			url:'<c:url value="/busi/rule/existweights/"/>${obj.modelId}',
		  	cache: false,
		 	processData: false,
		  	success: function(data){
			var html = data.replace('null','');
		    $("#weights").append(html);
		    buildExistRules();
		  }
		});
		
		
//		$.ajax({
//			url:'<c:url value="/busi/rule/weighted/"/>${obj.modelId}',
//		  	cache: false,
//		 	processData: false,
//		  	success: function(data){
//				var html = data.replace('null','');
//				$("#scoresfm").html(html);
//				var scfm = $("#scoresfm");
//				scfm.children().each(function(i,n){
//					var obj = $(n);
//					if('weighted'==obj.attr('id')){
//						obj.numberbox({
//							min:0,
//							precision:2,
//							required:true,
//							missingMessage:'请输入一个数字值'
//						});
//					}
//				});
//		  }
//		});
	</script>
</c:if>
<c:if test="${obj==null }">
	<div align="center">
		<h1><span style="color:red">请先定义规则字段</span></h1>
	</div>
</c:if>
</body>
</html>