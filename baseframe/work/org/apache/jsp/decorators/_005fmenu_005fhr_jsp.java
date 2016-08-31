package org.apache.jsp.decorators;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import m.w.sys.util.Users;

public final class _005fmenu_005fhr_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/WEB-INF/META-INF/wx.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fwx_005fhap_0026_005fname;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fwx_005fhap_0026_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fwx_005fhap_0026_005fname.release();
    _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<div class=\"header\">\r\n");
      out.write("\t<div style=\"padding:10px;text-align:right;\">\r\n");
      out.write("\t\t<span style=\"color:#ddd;padding-right:50px\">欢迎<span style=\"color:#fff\">");
      if (_jspx_meth_shiro_005fprincipal_005f0(_jspx_page_context))
        return;
      out.write("</span></span>\r\n");
      out.write("\t\t<a class=\"easyui-linkbutton\" data-options=\"plain:true, iconCls:'icon-password'\" onclick=\"WX.sys.openChpwd()\" style=\"color:#fff;padding-left:10px\">更改密码</a>\r\n");
      out.write("\t\t<a class=\"easyui-linkbutton\" data-options=\"plain:true, iconCls:'icon-exit'\" href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" style=\"color:#fff;padding-left:10px\">安全退出</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"toptitle\">");
      out.print(m.w.App.getAppName());
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"dlg-chpwd\" class=\"easyui-dialog\" style=\"width:300px;height:150px\" data-options=\"iconCls:'icon-password',resizable:false,modal:true, closed:true, title:'更改密码', buttons:'#dlg-chpwd-bts'\">\r\n");
      out.write("\t<div class=\"easyui-panel\" data-options=\"fit:true\">\r\n");
      out.write("\t\t<form id=\"fm-chpwd\" method=\"post\" action=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\">\r\n");
      out.write("\t\t\t<table class=\"form-table\">\r\n");
      out.write("\t\t\t\t<tr><td>旧 密 码</td><td><input type=\"password\" style=\"width:180px\" name=\"oldPassword\" id=\"chpwd_old_password\"/></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td>新 密 码</td><td><input type=\"password\" style=\"width:180px\" name=\"newPassword\" id=\"chpwd_new_password\"/></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td>确认密码</td><td><input type=\"password\" style=\"width:180px\" name=\"rePassword\"  id=\"chpwd_re_password\"/></td></tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<div id=\"dlg-chpwd-bts\">\r\n");
      out.write("\t\t\t<a class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-ok'\"     onclick=\"WX.sys.chpwd()\">确认</a>\r\n");
      out.write("\t\t\t<a class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-cancel'\" onclick=\"WX.sys.closeChpwd()\">取消</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div style=\"padding:2px 10px;\">\r\n");
      out.write("\t<a href=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\" class=\"easyui-linkbutton\" plain=\"true\">首页</a>\r\n");
      out.write("\t");
      if (_jspx_meth_wx_005fhap_005f0(_jspx_page_context))
        return;
      if (_jspx_meth_wx_005fhap_005f1(_jspx_page_context))
        return;
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"menu-msg\" class=\"easyui-menu\" style=\"width:150px\">\r\n");
      out.write("\t");
      if (_jspx_meth_wx_005fhp_005f0(_jspx_page_context))
        return;
      if (_jspx_meth_wx_005fhp_005f1(_jspx_page_context))
        return;
      out.write("<!-- \r\n");
      out.write("\t");
      if (_jspx_meth_wx_005fhp_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t -->\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"menu-sys\" class=\"easyui-menu\" style=\"width:150px\">\r\n");
      out.write("\t");
      if (_jspx_meth_wx_005fhp_005f3(_jspx_page_context))
        return;
      if (_jspx_meth_wx_005fhp_005f4(_jspx_page_context))
        return;
      if (_jspx_meth_wx_005fhp_005f5(_jspx_page_context))
        return;
      if (_jspx_meth_wx_005fhp_005f6(_jspx_page_context))
        return;
      if (_jspx_meth_wx_005fhp_005f7(_jspx_page_context))
        return;
      if (_jspx_meth_wx_005fhp_005f8(_jspx_page_context))
        return;
      out.write("</div>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_shiro_005fprincipal_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:principal
    org.apache.shiro.web.tags.PrincipalTag _jspx_th_shiro_005fprincipal_005f0 = (org.apache.shiro.web.tags.PrincipalTag) _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.get(org.apache.shiro.web.tags.PrincipalTag.class);
    _jspx_th_shiro_005fprincipal_005f0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fprincipal_005f0.setParent(null);
    // /decorators/_menu_hr.jsp(8,73) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fprincipal_005f0.setProperty("username");
    int _jspx_eval_shiro_005fprincipal_005f0 = _jspx_th_shiro_005fprincipal_005f0.doStartTag();
    if (_jspx_th_shiro_005fprincipal_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.reuse(_jspx_th_shiro_005fprincipal_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.reuse(_jspx_th_shiro_005fprincipal_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /decorators/_menu_hr.jsp(10,84) name = value type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/logout");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /decorators/_menu_hr.jsp(17,44) name = value type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/sys/user/chpwd");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f2.setParent(null);
    // /decorators/_menu_hr.jsp(32,10) name = value type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/index");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }

  private boolean _jspx_meth_wx_005fhap_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  wx:hap
    m.w.tags.HasAnyPermissionsTag _jspx_th_wx_005fhap_005f0 = (m.w.tags.HasAnyPermissionsTag) _005fjspx_005ftagPool_005fwx_005fhap_0026_005fname.get(m.w.tags.HasAnyPermissionsTag.class);
    _jspx_th_wx_005fhap_005f0.setPageContext(_jspx_page_context);
    _jspx_th_wx_005fhap_005f0.setParent(null);
    // /decorators/_menu_hr.jsp(33,1) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_wx_005fhap_005f0.setName("wechat:message:#");
    int _jspx_eval_wx_005fhap_005f0 = _jspx_th_wx_005fhap_005f0.doStartTag();
    if (_jspx_eval_wx_005fhap_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<a iconCls=\"icon-define\" class=\"easyui-menubutton\" menu=\"#menu-msg\">消息推送</a>\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_wx_005fhap_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_wx_005fhap_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fwx_005fhap_0026_005fname.reuse(_jspx_th_wx_005fhap_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fwx_005fhap_0026_005fname.reuse(_jspx_th_wx_005fhap_005f0);
    return false;
  }

  private boolean _jspx_meth_wx_005fhap_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  wx:hap
    m.w.tags.HasAnyPermissionsTag _jspx_th_wx_005fhap_005f1 = (m.w.tags.HasAnyPermissionsTag) _005fjspx_005ftagPool_005fwx_005fhap_0026_005fname.get(m.w.tags.HasAnyPermissionsTag.class);
    _jspx_th_wx_005fhap_005f1.setPageContext(_jspx_page_context);
    _jspx_th_wx_005fhap_005f1.setParent(null);
    // /decorators/_menu_hr.jsp(36,1) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_wx_005fhap_005f1.setName("sys:#");
    int _jspx_eval_wx_005fhap_005f1 = _jspx_th_wx_005fhap_005f1.doStartTag();
    if (_jspx_eval_wx_005fhap_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<a iconCls=\"icon-setting\" class=\"easyui-menubutton\" menu=\"#menu-sys\">系统管理</a>\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_wx_005fhap_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_wx_005fhap_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fwx_005fhap_0026_005fname.reuse(_jspx_th_wx_005fhap_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fwx_005fhap_0026_005fname.reuse(_jspx_th_wx_005fhap_005f1);
    return false;
  }

  private boolean _jspx_meth_wx_005fhp_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  wx:hp
    m.w.tags.HasPermissionTag _jspx_th_wx_005fhp_005f0 = (m.w.tags.HasPermissionTag) _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.get(m.w.tags.HasPermissionTag.class);
    _jspx_th_wx_005fhp_005f0.setPageContext(_jspx_page_context);
    _jspx_th_wx_005fhp_005f0.setParent(null);
    // /decorators/_menu_hr.jsp(42,1) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_wx_005fhp_005f0.setName("wechat:message:meet");
    int _jspx_eval_wx_005fhp_005f0 = _jspx_th_wx_005fhp_005f0.doStartTag();
    if (_jspx_eval_wx_005fhp_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<div href=\"");
        if (_jspx_meth_c_005furl_005f3(_jspx_th_wx_005fhp_005f0, _jspx_page_context))
          return true;
        out.write("\">会议通知</div>\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_wx_005fhp_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_wx_005fhp_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.reuse(_jspx_th_wx_005fhp_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.reuse(_jspx_th_wx_005fhp_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_wx_005fhp_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f3 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_wx_005fhp_005f0);
    // /decorators/_menu_hr.jsp(43,13) name = value type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/wechat/message/meet");
    int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
    if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
    return false;
  }

  private boolean _jspx_meth_wx_005fhp_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  wx:hp
    m.w.tags.HasPermissionTag _jspx_th_wx_005fhp_005f1 = (m.w.tags.HasPermissionTag) _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.get(m.w.tags.HasPermissionTag.class);
    _jspx_th_wx_005fhp_005f1.setPageContext(_jspx_page_context);
    _jspx_th_wx_005fhp_005f1.setParent(null);
    // /decorators/_menu_hr.jsp(45,1) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_wx_005fhp_005f1.setName("wechat:message:file");
    int _jspx_eval_wx_005fhp_005f1 = _jspx_th_wx_005fhp_005f1.doStartTag();
    if (_jspx_eval_wx_005fhp_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<div href=\"");
        if (_jspx_meth_c_005furl_005f4(_jspx_th_wx_005fhp_005f1, _jspx_page_context))
          return true;
        out.write("\">文件上传</div>\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_wx_005fhp_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_wx_005fhp_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.reuse(_jspx_th_wx_005fhp_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.reuse(_jspx_th_wx_005fhp_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_wx_005fhp_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f4 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_wx_005fhp_005f1);
    // /decorators/_menu_hr.jsp(46,13) name = value type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f4.setValue("/wechat/message/file");
    int _jspx_eval_c_005furl_005f4 = _jspx_th_c_005furl_005f4.doStartTag();
    if (_jspx_th_c_005furl_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
    return false;
  }

  private boolean _jspx_meth_wx_005fhp_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  wx:hp
    m.w.tags.HasPermissionTag _jspx_th_wx_005fhp_005f2 = (m.w.tags.HasPermissionTag) _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.get(m.w.tags.HasPermissionTag.class);
    _jspx_th_wx_005fhp_005f2.setPageContext(_jspx_page_context);
    _jspx_th_wx_005fhp_005f2.setParent(null);
    // /decorators/_menu_hr.jsp(49,1) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_wx_005fhp_005f2.setName("wechat:message:sign");
    int _jspx_eval_wx_005fhp_005f2 = _jspx_th_wx_005fhp_005f2.doStartTag();
    if (_jspx_eval_wx_005fhp_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<div href=\"");
        if (_jspx_meth_c_005furl_005f5(_jspx_th_wx_005fhp_005f2, _jspx_page_context))
          return true;
        out.write("\">签约提醒</div>\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_wx_005fhp_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_wx_005fhp_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.reuse(_jspx_th_wx_005fhp_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.reuse(_jspx_th_wx_005fhp_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_wx_005fhp_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f5 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_wx_005fhp_005f2);
    // /decorators/_menu_hr.jsp(50,13) name = value type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f5.setValue("/wechat/message/sign");
    int _jspx_eval_c_005furl_005f5 = _jspx_th_c_005furl_005f5.doStartTag();
    if (_jspx_th_c_005furl_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
    return false;
  }

  private boolean _jspx_meth_wx_005fhp_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  wx:hp
    m.w.tags.HasPermissionTag _jspx_th_wx_005fhp_005f3 = (m.w.tags.HasPermissionTag) _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.get(m.w.tags.HasPermissionTag.class);
    _jspx_th_wx_005fhp_005f3.setPageContext(_jspx_page_context);
    _jspx_th_wx_005fhp_005f3.setParent(null);
    // /decorators/_menu_hr.jsp(56,1) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_wx_005fhp_005f3.setName("sys:employee:index");
    int _jspx_eval_wx_005fhp_005f3 = _jspx_th_wx_005fhp_005f3.doStartTag();
    if (_jspx_eval_wx_005fhp_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<div href=\"");
        if (_jspx_meth_c_005furl_005f6(_jspx_th_wx_005fhp_005f3, _jspx_page_context))
          return true;
        out.write("\">员工管理</div>\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_wx_005fhp_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_wx_005fhp_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.reuse(_jspx_th_wx_005fhp_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.reuse(_jspx_th_wx_005fhp_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_wx_005fhp_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f6 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_wx_005fhp_005f3);
    // /decorators/_menu_hr.jsp(57,12) name = value type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f6.setValue("/wechat/employee/index");
    int _jspx_eval_c_005furl_005f6 = _jspx_th_c_005furl_005f6.doStartTag();
    if (_jspx_th_c_005furl_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f6);
    return false;
  }

  private boolean _jspx_meth_wx_005fhp_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  wx:hp
    m.w.tags.HasPermissionTag _jspx_th_wx_005fhp_005f4 = (m.w.tags.HasPermissionTag) _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.get(m.w.tags.HasPermissionTag.class);
    _jspx_th_wx_005fhp_005f4.setPageContext(_jspx_page_context);
    _jspx_th_wx_005fhp_005f4.setParent(null);
    // /decorators/_menu_hr.jsp(59,1) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_wx_005fhp_005f4.setName("sys:template:index");
    int _jspx_eval_wx_005fhp_005f4 = _jspx_th_wx_005fhp_005f4.doStartTag();
    if (_jspx_eval_wx_005fhp_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<div href=\"");
        if (_jspx_meth_c_005furl_005f7(_jspx_th_wx_005fhp_005f4, _jspx_page_context))
          return true;
        out.write("\">模板管理</div>\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_wx_005fhp_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_wx_005fhp_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.reuse(_jspx_th_wx_005fhp_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.reuse(_jspx_th_wx_005fhp_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_wx_005fhp_005f4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f7 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_wx_005fhp_005f4);
    // /decorators/_menu_hr.jsp(60,12) name = value type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f7.setValue("/wechat/template/index");
    int _jspx_eval_c_005furl_005f7 = _jspx_th_c_005furl_005f7.doStartTag();
    if (_jspx_th_c_005furl_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f7);
    return false;
  }

  private boolean _jspx_meth_wx_005fhp_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  wx:hp
    m.w.tags.HasPermissionTag _jspx_th_wx_005fhp_005f5 = (m.w.tags.HasPermissionTag) _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.get(m.w.tags.HasPermissionTag.class);
    _jspx_th_wx_005fhp_005f5.setPageContext(_jspx_page_context);
    _jspx_th_wx_005fhp_005f5.setParent(null);
    // /decorators/_menu_hr.jsp(62,1) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_wx_005fhp_005f5.setName("sys:user:index");
    int _jspx_eval_wx_005fhp_005f5 = _jspx_th_wx_005fhp_005f5.doStartTag();
    if (_jspx_eval_wx_005fhp_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<div href=\"");
        if (_jspx_meth_c_005furl_005f8(_jspx_th_wx_005fhp_005f5, _jspx_page_context))
          return true;
        out.write("\">用户管理</div>\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_wx_005fhp_005f5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_wx_005fhp_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.reuse(_jspx_th_wx_005fhp_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.reuse(_jspx_th_wx_005fhp_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_wx_005fhp_005f5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f8 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_wx_005fhp_005f5);
    // /decorators/_menu_hr.jsp(63,12) name = value type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f8.setValue("/sys/user/index");
    int _jspx_eval_c_005furl_005f8 = _jspx_th_c_005furl_005f8.doStartTag();
    if (_jspx_th_c_005furl_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f8);
    return false;
  }

  private boolean _jspx_meth_wx_005fhp_005f6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  wx:hp
    m.w.tags.HasPermissionTag _jspx_th_wx_005fhp_005f6 = (m.w.tags.HasPermissionTag) _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.get(m.w.tags.HasPermissionTag.class);
    _jspx_th_wx_005fhp_005f6.setPageContext(_jspx_page_context);
    _jspx_th_wx_005fhp_005f6.setParent(null);
    // /decorators/_menu_hr.jsp(65,1) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_wx_005fhp_005f6.setName("sys:dict:index");
    int _jspx_eval_wx_005fhp_005f6 = _jspx_th_wx_005fhp_005f6.doStartTag();
    if (_jspx_eval_wx_005fhp_005f6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<div href=\"");
        if (_jspx_meth_c_005furl_005f9(_jspx_th_wx_005fhp_005f6, _jspx_page_context))
          return true;
        out.write("\">字典管理</div>\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_wx_005fhp_005f6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_wx_005fhp_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.reuse(_jspx_th_wx_005fhp_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.reuse(_jspx_th_wx_005fhp_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_wx_005fhp_005f6, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f9 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f9.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_wx_005fhp_005f6);
    // /decorators/_menu_hr.jsp(66,12) name = value type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f9.setValue("/sys/dict/index");
    int _jspx_eval_c_005furl_005f9 = _jspx_th_c_005furl_005f9.doStartTag();
    if (_jspx_th_c_005furl_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f9);
    return false;
  }

  private boolean _jspx_meth_wx_005fhp_005f7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  wx:hp
    m.w.tags.HasPermissionTag _jspx_th_wx_005fhp_005f7 = (m.w.tags.HasPermissionTag) _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.get(m.w.tags.HasPermissionTag.class);
    _jspx_th_wx_005fhp_005f7.setPageContext(_jspx_page_context);
    _jspx_th_wx_005fhp_005f7.setParent(null);
    // /decorators/_menu_hr.jsp(68,1) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_wx_005fhp_005f7.setName("sys:permission:index");
    int _jspx_eval_wx_005fhp_005f7 = _jspx_th_wx_005fhp_005f7.doStartTag();
    if (_jspx_eval_wx_005fhp_005f7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<div href=\"");
        if (_jspx_meth_c_005furl_005f10(_jspx_th_wx_005fhp_005f7, _jspx_page_context))
          return true;
        out.write("\">权限资源</div>\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_wx_005fhp_005f7.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_wx_005fhp_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.reuse(_jspx_th_wx_005fhp_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.reuse(_jspx_th_wx_005fhp_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_wx_005fhp_005f7, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f10 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f10.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_wx_005fhp_005f7);
    // /decorators/_menu_hr.jsp(69,12) name = value type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f10.setValue("/sys/permission/index");
    int _jspx_eval_c_005furl_005f10 = _jspx_th_c_005furl_005f10.doStartTag();
    if (_jspx_th_c_005furl_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f10);
    return false;
  }

  private boolean _jspx_meth_wx_005fhp_005f8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  wx:hp
    m.w.tags.HasPermissionTag _jspx_th_wx_005fhp_005f8 = (m.w.tags.HasPermissionTag) _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.get(m.w.tags.HasPermissionTag.class);
    _jspx_th_wx_005fhp_005f8.setPageContext(_jspx_page_context);
    _jspx_th_wx_005fhp_005f8.setParent(null);
    // /decorators/_menu_hr.jsp(71,1) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_wx_005fhp_005f8.setName("sys:role:index");
    int _jspx_eval_wx_005fhp_005f8 = _jspx_th_wx_005fhp_005f8.doStartTag();
    if (_jspx_eval_wx_005fhp_005f8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<div href=\"");
        if (_jspx_meth_c_005furl_005f11(_jspx_th_wx_005fhp_005f8, _jspx_page_context))
          return true;
        out.write("\">角色管理</div>\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_wx_005fhp_005f8.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_wx_005fhp_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.reuse(_jspx_th_wx_005fhp_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fwx_005fhp_0026_005fname.reuse(_jspx_th_wx_005fhp_005f8);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f11(javax.servlet.jsp.tagext.JspTag _jspx_th_wx_005fhp_005f8, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f11 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f11.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_wx_005fhp_005f8);
    // /decorators/_menu_hr.jsp(72,12) name = value type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f11.setValue("/sys/role/index");
    int _jspx_eval_c_005furl_005f11 = _jspx_th_c_005furl_005f11.doStartTag();
    if (_jspx_th_c_005furl_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f11);
    return false;
  }
}
