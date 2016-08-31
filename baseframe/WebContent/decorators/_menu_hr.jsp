<%@page import="m.w.sys.util.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://wx.w.m/tags" prefix="wx" %>
<div class="header">
	<div style="padding:10px;text-align:right;">
		<span style="color:#ddd;padding-right:50px">欢迎<span style="color:#fff"><shiro:principal property="username"/></span></span>
		<a class="easyui-linkbutton" data-options="plain:true, iconCls:'icon-password'" onclick="WX.sys.openChpwd()" style="color:#fff;padding-left:10px">更改密码</a>
		<a class="easyui-linkbutton" data-options="plain:true, iconCls:'icon-exit'" href="<c:url value='/logout'/>" style="color:#fff;padding-left:10px">安全退出</a>
	</div>
	<div class="toptitle"><%=m.w.App.getAppName()%></div>
</div>

<div id="dlg-chpwd" class="easyui-dialog" style="width:300px;height:150px" data-options="iconCls:'icon-password',resizable:false,modal:true, closed:true, title:'更改密码', buttons:'#dlg-chpwd-bts'">
	<div class="easyui-panel" data-options="fit:true">
		<form id="fm-chpwd" method="post" action="<c:url value='/sys/user/chpwd'/>">
			<table class="form-table">
				<tr><td>旧 密 码</td><td><input type="password" style="width:180px" name="oldPassword" id="chpwd_old_password"/></td></tr>
				<tr><td>新 密 码</td><td><input type="password" style="width:180px" name="newPassword" id="chpwd_new_password"/></td></tr>
				<tr><td>确认密码</td><td><input type="password" style="width:180px" name="rePassword"  id="chpwd_re_password"/></td></tr>
			</table>
		</form>
		<div id="dlg-chpwd-bts">
			<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'"     onclick="WX.sys.chpwd()">确认</a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="WX.sys.closeChpwd()">取消</a>
		</div>
	</div>
</div>

<div style="padding:2px 10px;">
	<a href="<c:url value='/index'/>" class="easyui-linkbutton" plain="true">首页</a>
	<wx:hap name="wechat:message:#">
	<a iconCls="icon-define" class="easyui-menubutton" menu="#menu-msg">消息推送</a>
	</wx:hap>
	<wx:hap name="sys:#">
	<a iconCls="icon-setting" class="easyui-menubutton" menu="#menu-sys">系统管理</a>
	</wx:hap>
</div>

<div id="menu-msg" class="easyui-menu" style="width:150px">
	<wx:hp name="wechat:message:meet">
		<div href="<c:url value='/wechat/message/meet'/>">会议通知</div>
	</wx:hp>
	<wx:hp name="wechat:message:file">
		<div href="<c:url value='/wechat/message/file'/>">文件上传</div>
	</wx:hp>
	<!-- 
	<wx:hp name="wechat:message:sign">
		<div href="<c:url value='/wechat/message/sign'/>">签约提醒</div>
	</wx:hp>
	 -->
</div>

<div id="menu-sys" class="easyui-menu" style="width:150px">
	<wx:hp name="sys:employee:index">
	<div href="<c:url value='/wechat/employee/index'/>">员工管理</div>
	</wx:hp>
	<wx:hp name="sys:template:index">
	<div href="<c:url value='/wechat/template/index'/>">模板管理</div>
	</wx:hp>
	<wx:hp name="sys:user:index">
	<div href="<c:url value='/sys/user/index'/>">用户管理</div>
	</wx:hp>
	<wx:hp name="sys:dict:index">
	<div href="<c:url value='/sys/dict/index'/>">字典管理</div>
	</wx:hp>
	<wx:hp name="sys:permission:index">
	<div href="<c:url value='/sys/permission/index'/>">权限资源</div>
	</wx:hp>
	<wx:hp name="sys:role:index">
	<div href="<c:url value='/sys/role/index'/>">角色管理</div>
	</wx:hp>
</div>
