package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import m.w.App;
import m.w.sys.util.Users;
import m.w.sys.util.Acls;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(4);
    _jspx_dependants.add("/common/include/_includes.jsp");
    _jspx_dependants.add("/common/include/_imports.jsp");
    _jspx_dependants.add("/common/include/_taglibs.jsp");
    _jspx_dependants.add("/WEB-INF/META-INF/wx.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html style=\"height:100%\" lang='zh-CN' xml:lang='zh-CN' xmlns='http://www.w3.org/1999/xhtml'>\r\n");
      out.write("<head>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "decorators/_head.jsp", out, false);
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("if(top.location!==self.location){\r\n");
      out.write("\ttop.location.href=self.location.href;\r\n");
      out.write("}\r\n");
      out.write("$(function(){\r\n");
      out.write("\tif(!$('#username').val()){\r\n");
      out.write("\t\t$('#username').focus();\r\n");
      out.write("\t}else if(!$('#password').val()){\r\n");
      out.write("\t\t$('#password').focus();\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\t$('#btn').focus();\r\n");
      out.write("\t}\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function doSubmit(){\r\n");
      out.write("\tif(!$('#username').val()){$('#username').focus(); return false;}\r\n");
      out.write("\tif(!$('#password').val()){$('#password').focus(); return false;}\r\n");
      out.write("\t$.messager.progress({\r\n");
      out.write("\t\ttitle: '系统登录',\r\n");
      out.write("\t\tmsg  : '<span style=\"color:green; font-weight:bold; padding:10px; font-size:14px\">'+$('#username').val()+'</span>您好：',\r\n");
      out.write("\t\ttext : '您现在正在登录到<span style=\"color:red; font-weight:bold; padding:5px;\">[");
      out.print(App.getAppName() );
      out.write("]</span>，请稍等...'\r\n");
      out.write("\t});\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"visibility:visible\">\r\n");
      out.write("\t<noscript><div align=\"center\" style=\"color:red;font-size:24px\">运行本系统必须 JavaScript 的支持。<br/>请开启浏览器的 JavaScript 功能，或更换其它支持 JavaScript 的浏览器！</div></noscript>\r\n");
      out.write("\t<div class=\"easyui-dialog\" style=\"width:500px;height:300px;background:#fafafa;overflow:hidden\"\r\n");
      out.write("\t\t\ttitle=\"系统登录\" closable=\"false\" border=\"false\">\r\n");
      out.write("\t\t<div class=\"header\" style=\"height:60px;\">\r\n");
      out.write("\t\t\t<div class=\"toptitle\">");
      out.print(App.getAppName() );
      out.write("登录</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div style=\"padding:60px 0;\">\r\n");
      out.write("\t\t\t<form id=\"loginForm\" action=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" method=\"post\" onsubmit=\"return doSubmit()\">\r\n");
      out.write("\t\t\t\t<div style=\"padding-left:150px\">\r\n");
      out.write("\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"3\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>登录帐号</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input tabindex=\"1\" id=\"username\" name=\"username\" style=\"width:150px\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${username}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"></input></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>登录密码</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input tabindex=\"2\" id=\"password\" type=\"password\" name=\"password\" style=\"width:150px\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${password}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"></input></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>记 住 我</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input tabindex=\"3\" id=\"rememberMe\" type=\"checkbox\" name=\"rememberMe\" value=\"true\"></input></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"btn\" tabindex=\"3\" class=\"login\" type=\"submit\" value=\"\" style=\"width:74px;height:21px;border:0\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\" align=\"center\"><div class=\"err\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_ERR_}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</div><div class=\"info\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_INFO_}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</div></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /login.jsp(41,32) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/login");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }
}
