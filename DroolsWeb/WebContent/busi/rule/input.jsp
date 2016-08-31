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
	<hr />
	<div id="input_">
		<form id="propfm">
		</form>
	</div>
	<div id="result_" align="center"></div>
	<hr />
	<div align="center">
		<a class="easyui-linkbutton" id="deploy" data-options="iconCls:'icon-search'"> 计算得分</a>
	</div>
	<script type="text/javascript">
		$.ajax({
		  url: '<c:url value="/busi/rule/inputproperties"/>/${obj.modelId}',
		  cache: false,
		  processData: false,
		  success: function(data){
			var html = data.replace('null','');
		    $("#propfm").append(html);
		    $(".easyui-combobox").each(function(i,n){
				var obj = $(n);
				var data = obj.attr('data');
				if('none'!=data){
					var dt = data2obj(data);
					obj.combobox({
						valueField: 'id',
						textField: 'text',
						data:dt,
						required:true
					});
				}else{
					obj.combobox({
						required:true
					});
				}
			});
		  }
		}); 
		
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
	
	$("#deploy").bind("click",function(){
		$.ajax({
            cache: true,
            type: "POST",
            url:'<c:url value="/busi/rule/getscore" />/${obj.modelId}',
            data:$('#propfm').serialize(),
            async: false,
            success: function(data) {
            	var s = $.parseJSON(data);
            	$("#result_").html('<h1>得分:'+s.msg+'</h1>');
            }
        });
	});
	</script>
</body>
</html>