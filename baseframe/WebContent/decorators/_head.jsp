<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Pragma" Content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Expires" Content="0" />
<meta http-equiv="Content-Script-Type" Content="text/javascript" />
<title><%=m.w.App.getAppName()%> [<%=m.w.App.build()%>]</title>
<% if(m.w.App.isDev()){ %>
<link rel="stylesheet" href="<c:url value='/js/easyui/themes/default/easyui.css'/>?v=1.3.2" type="text/css" media="screen" />
<link rel="stylesheet" href="<c:url value='/js/easyui/themes/icon.css'/>?v=1.3.2" type="text/css" media="screen" />
<link rel="stylesheet" href="<c:url value='/js/kindeditor/themes/default/default.css'/>?v=4.1.5" type="text/css" media="screen" />
<link rel="stylesheet" href="<c:url value='/css/main.css'/>?v=<%=m.w.App.ver()%>" type="text/css" media="screen" />
<link rel="stylesheet" href="<c:url value='/css/icon.css'/>?v=<%=m.w.App.ver()%>" type="text/css" media="screen" />
<link rel="stylesheet" href="<c:url value='/js/lightbox/css/jquery.lightbox-0.5.css'/>?v=<%=m.w.App.ver()%>" type="text/css" media="screen" />
<script type="text/javascript" src="<c:url value='/js/core.js'/>?v=<%=m.w.App.ver()%>"></script>
<script type="text/javascript" src="<c:url value='/js/json/json2.js'/>?v=<%=m.w.App.ver()%>"></script>
<script type="text/javascript" src="<c:url value='/js/json/form2js.js'/>?v=<%=m.w.App.ver()%>"></script>
<script type="text/javascript" src="<c:url value='/js/json/js2form.js'/>?v=<%=m.w.App.ver()%>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.js'/>?v=1.8.0"></script>
<script type="text/javascript" src="<c:url value='/js/json/jquery.toObject.js'/>?v=<%=m.w.App.ver()%>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.extends.js'/>?v=<%=m.w.App.ver()%>"></script>
<script type="text/javascript" src="<c:url value='/js/easyui/jquery.easyui.min.js'/>?v=1.3.2"></script>
<script type="text/javascript" src="<c:url value='/js/easyui/locale/easyui-lang-zh_CN.js'/>?v=1.3.2"></script>
<script type="text/javascript" src="<c:url value='/js/easyui/extension/datagridview/datagrid-scrollview.js'/>?v=1.3.2"></script>
<script type="text/javascript" src="<c:url value='/js/easyui/extension/edatagrid/jquery.edatagrid.js'/>?v=1.3.2"></script>
<script type="text/javascript" src="<c:url value='/js/easyui/jquery.easyui.extends.js'/>?v=<%=m.w.App.ver()%>"></script>
<script type="text/javascript" src="<c:url value='/js/kindeditor/kindeditor-all.js'/>?v=4.1.5"></script>
<script type="text/javascript" src="<c:url value='/js/commons.js'/>?v=<%=m.w.App.ver()%>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.wxparser.js'/>?v=<%=m.w.App.ver()%>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.wxgrid.js'/>?v=<%=m.w.App.ver()%>"></script>
<script type="text/javascript" src="<c:url value='/js/app.sys.js'/>?v=<%=m.w.App.ver()%>"></script>
<script type="text/javascript" src="<c:url value='/js/app.ztjs.js'/>?v=<%=m.w.App.ver()%>"></script>
<script type="text/javascript" src="<c:url value='/js/app.mymonth.js'/>?v=<%=m.w.App.ver()%>"></script>
<script type="text/javascript" src="<c:url value='/js/app.myweek.js'/>?v=<%=m.w.App.ver()%>"></script>
<script type="text/javascript" src="<c:url value='/js/app.wechat.js'/>?v=<%=m.w.App.ver()%>"></script>
<script type="text/javascript" src="<c:url value='/js/lightbox/js/jquery.lightbox-0.5.js'/>?v=<%=m.w.App.ver()%>"></script>
<%}else{%>
<link rel="stylesheet" href="<c:url value='/wro/wx.css'/>?v=<%=m.w.App.ver()%>" type="text/css" media="screen" />
<script type="text/javascript" src="<c:url value='/wro/wx.js'/>?v=<%=m.w.App.ver()%>"></script>
<%}%>
<script type="text/javascript">
	var base = '${base}';
	var ke_uploadJson = '<c:url value="/sys/file/keupload"/>';
	var ke_fileManagerJson = '<c:url value="/sys/file/kebrowse"/>';
	$.parser.onComplete = function(cxt){
		WX.wxparser(cxt);
    	$('body').css('visibility','visible');
    	setTimeout(function(){
        	$('#loading-mask').remove();
    	},50);
	};
	$(function(){
    	$(window).resize(function(){
        	$('#mainlayout').layout('resize');
    	});
	});
</script>