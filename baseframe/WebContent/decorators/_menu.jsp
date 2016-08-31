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
	<a href="<c:url value='/hr/employee/index'/>" class="easyui-linkbutton" plain="true">员工档案</a>
	<a href="<c:url value='/hr/contract/index'/>" class="easyui-linkbutton" plain="true">合同档案</a>
	<a href="#" class="easyui-menubutton" menu="#menu-worklog">工作日志</a>

	<wx:hp name="oa:worktype:list">
	<a href="#" class="easyui-menubutton" menu="#menu-worktype">项目管理</a>
	</wx:hp>
	
	<wx:hap name="proj:#">
	<a href="#" class="easyui-menubutton" menu="#menu-proj">工程进度</a>
	</wx:hap>

	<wx:hap name="sys:#">
	<a href="#" class="easyui-menubutton" menu="#menu-sys">系统管理</a>
	</wx:hap>
</div>

<div id="menu-worklog" class="easyui-menu" style="width:150px">
	<div href="<c:url value='/oa/worklog/index'/>"><shiro:principal property="username"/>的工作日志</div>
<wx:hp name="oa:worklog:audit">
	<div href="<c:url value='/oa/worklog/audit'/>">所有工作日志</div>
</wx:hp>
</div>

<div id="menu-worktype" class="easyui-menu" style="width:150px">
	<div href="<c:url value='/oa/worktype/index'/>" class="easyui-linkbutton" plain="true">基本信息</div>
	<div href="<c:url value='/oa/workallocate/index'/>" class="easyui-linkbutton" plain="true">项目分配</div>
</div>

<div id="menu-proj" class="easyui-menu" style="width:150px">
	<div href="<c:url value='/ztjs/ppms/plan-major/index'/>"  class="easyui-linkbutton" plain="true">节点执行情况</div>
</div>

<div id="menu-sys" class="easyui-menu" style="width:150px">
	<wx:hp name="sys:user:index">
	<div href="<c:url value='/sys/user/index'/>">用户管理</div>
	</wx:hp>
	<wx:hp name="sys:org:index">
	<div href="<c:url value='/sys/org/index'/>">机构管理</div>
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
	<div href="<c:url value='/ztjs/sys/auth/position'/>">岗位授权</div>
	<div href="<c:url value='/ztjs/sys/auth/project'/>">工程授权</div>
</div>
