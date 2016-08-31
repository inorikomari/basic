<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html style="height:100%" lang='zh-CN' xml:lang='zh-CN' xmlns='http://www.w3.org/1999/xhtml'>
<head>
<%@ include file="/common/include/_includes.jsp"%>
<%
	String basePath = request.getContextPath();
%>
<title>Drool</title>
<script type="text/javascript">
	$(function(){
		$(".addRule").bind("click",function(){
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
			
			var html = '<br /><div id="rule-'+rulenxt+'" style="border:1px solid gray"><span>规则'+rulenxt+':</span><br />'
			+'<input class="easyui-combobox" name="rule-'+rulenxt+'-fd-1" id="rule-'+rulenxt+'-fd-1" style="width:100px" />'
			+'<input class="easyui-combobox" name="rule-'+rulenxt+'-op-1" id="rule-'+rulenxt+'-op-1" style="width:80px" />'
			+'<input class="easyui-combobox" name="rule-'+rulenxt+'-kv-1" id="rule-'+rulenxt+'-kv-1" style="width:120px" />'
			+'<a class="easyui-linkbutton addEx" id="rule-'+rulenxt+'-btn" ruleno="'+rulenxt+'" exno="1" > 添加条件</a><br /><span>评分项:</span><br />'
			+'<input class="easyui-combobox" name="rule-'+rulenxt+'-sc-1" id="rule-'+rulenxt+'-sc-1" style="width:100px" />'
			+'<input class="easyui-combobox" name="rule-'+rulenxt+'-ca-1" id="rule-'+rulenxt+'-ca-1" style="width:80px" />'
			+'<input class="easyui-numberbox" name="rule-'+rulenxt+'-va-1" id="rule-'+rulenxt+'-va-1" style="width:80px" />';
			$("#rules").append(html);
			rebuEx(rulenxt,1);
			$("#rule-"+rulenxt+"-btn").linkbutton({
				iconCls:'icon-add'
			});
			$("#rule-"+rulenxt+"-sc-1").combobox({
				url:'<c:url value="/gradeList"/>',
				editable:false,
				required:true
			});
			$("#rule-"+rulenxt+"-ca-1").combobox({
				url:'<c:url value="/countOperators"/>',
				editable:false,
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
				addExF(ruleno,nxt);
				rebuEx(ruleno,nxt);
			});
		});
		
		$(".saveRule").bind("click",function(){
			var rules = $("#rules");
			var rulenxt = 0;
			var sr = '';
			rules.children().each(function(i,n){
				var obj = $(n);
				if(obj.attr('id')!=null){
					sr +='rule "'+obj.attr('id')+'" when p:'+$("#pojo").attr('name')+' (';
					var rule = $("#rule-"+obj.attr('id').substr(5));
					var tag = false;;
					rule.children().each(function(ind,nod){
						var field = $(nod);
						if(field.attr('id')!=null&&-1==field.attr('id').indexOf('btn')){
							if(!tag){
								if(-1!=field.attr('class').indexOf('combobox')){
									sr +=' ' + field.combobox('getValue') + ' ';
								}else{
									sr +=' ' + field.val() + ' ';
								}
							}else{
								sr+=$('#'+field.combobox('getValue')).attr('setm')+'(p.'+$('#'+field.combobox('getValue')).attr('getm')+'() ';
								tag = false;
							}
						}else if(field.attr('id')!=null&&-1!=field.attr('id').indexOf('btn')){
							sr+='); then p.';
							tag = true;
						}
					});
					sr+=' ); end ';
				}
			});
			
			sr = 'import '+ $("#pojo").attr('package') +';'+sr;
			
			var data = {rulestr:sr};
			$.post('<c:url value="/rulestr" />',data,function(result){
				if(result.success){
					$.messager.show({
						title   : '<span class="green">保存成功</span>',
						msg     : result.msg || '保存成功',
						timeout : 3000,
						showType: 'fade'
					});
				}
			},'json');
		});
		
		$(".cacuRule").bind("click",function(){
			$.ajax({
                cache: true,
                type: "POST",
                url:'<c:url value="/deploy" />',
                data:$('#d-form').serialize(),
                async: false,
                success: function(data) {
                	var s = $.parseJSON(data);
                	$("#_result").html(s.msg);
                }
            });
		});
		
		$(".addEx").bind("click",function(){
			var ruleno = $("#"+this.id).attr('ruleno');
			var nxt = parseInt($("#"+this.id).attr('exno'))+1;
			$("#"+this.id).attr('exno',nxt);
			addExF(ruleno,nxt);
			rebuEx(ruleno,nxt);
		});
		
		function addExF(ruleno,nxt){
			var html = '<input class="easyui-combobox" name="rule-'+ruleno+'-lo-'+nxt+'" id="rule-'+ruleno+'-lo-'+nxt+'" style="width:50px" /><br />'
			+'<input class="easyui-combobox" name="rule-'+ruleno+'-fd-'+nxt+'" id="rule-'+ruleno+'-fd-'+nxt+'" style="width:100px" />'
			+'<input class="easyui-combobox" name="rule-'+ruleno+'-op-'+nxt+'" id="rule-'+ruleno+'-op-'+nxt+'" style="width:80px" />'
			+'<input class="easyui-combobox" name="rule-'+ruleno+'-kv-'+nxt+'" id="rule-'+ruleno+'-kv-'+nxt+'" style="width:120px" />';
			$(html).insertBefore("#rule-"+ruleno+"-btn");
		}
		
		function rebuEx(ruleno,nxt){
			$("#rule-"+ruleno+"-lo-"+nxt).combobox({
				url:'<c:url value="/logical"/>',
				editable:false,
				required:true
			});
			$("#rule-"+ruleno+"-fd-"+nxt).combobox({
				url:'<c:url value="/fieldList"/>',
				editable:false,
				required:true,
				onSelect:function(rec){
					var cid = this.id;
					selectProperty(rec,cid);
				}
			});
			$("#rule-"+ruleno+"-op-"+nxt).combobox({
				url:'<c:url value="/operators"/>',
				editable:false,
				required:true
			});
			$("#rule-"+ruleno+"-kv-"+nxt).combobox({
				editable:true,
				required:true
			});
		}
		
		function selectProperty(rec,cid){
			var o = $('#'+$('#'+rec.id).attr('id'));
			var t = $('#'+cid.replace('fd','kv'));
			var url = o.attr('url');
			if('none'!=url){
				url = '<%=basePath%>'+ url;
				t.combobox('reload', url);
			}else{
				url = '';
				t.combobox('loadData', url);
			}
			return true;
		}
		
	});
</script>
</head>
<body>
	<div>
		<form id="d-form" action="<c:url value="/deploy"/>" method="post">
			
		</form>
	</div>
	<div id="_result"></div>
	<div align="center">
		<input type="hidden" name="rulestr" id="rulestr"/>
		<a class="easyui-linkbutton addRule" data-options="iconCls:'icon-add'"> 添加规则</a>
		<a class="easyui-linkbutton saveRule" data-options="iconCls:'icon-save'"> 生成规则</a>
		<a class="easyui-linkbutton cacuRule" data-options="iconCls:'icon-save'">计算得分</a>
	</div>
	<hr />
	<div id="_property"></div>
	<div id="rules">

	</div>
	<br /><br /><br /><br />
	<script type="text/javascript">
		$.ajax({
		  url: '<c:url value="/properties"/>/',
		  cache: false,
		  processData: false,
		  success: function(data){
			var html = data.replace('null','');
		    $("#_property").append(html);
		  }
		}); 
		
		$.ajax({
		  url: '<c:url value="/inputproperties"/>/',
		  cache: false,
		  processData: false,
		  success: function(data){
			var html = data.replace('null','');
		    $("#d-form").append(html);
		  }
		}); 
	</script>
</body>
</html>