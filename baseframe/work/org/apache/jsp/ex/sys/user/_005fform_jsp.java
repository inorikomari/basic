package org.apache.jsp.ex.sys.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import m.w.App;
import m.w.sys.util.Users;
import m.w.sys.util.Acls;

public final class _005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("wx:checked", m.w.tags.CheckTag.class, "checked", new Class[] {boolean.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(4);
    _jspx_dependants.add("/common/include/_includes.jsp");
    _jspx_dependants.add("/common/include/_imports.jsp");
    _jspx_dependants.add("/common/include/_taglibs.jsp");
    _jspx_dependants.add("/WEB-INF/META-INF/wx.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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

      out.write("<div style=\"padding-top:30px;\" style=\"border:1px solid red\">\r\n");
      out.write("\t<table class=\"form-table\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th style=\"width:100px\">用户姓名</th>\r\n");
      out.write("\t\t\t<td><input name=\"username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.username}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" style=\"width:180px\" class=\"easyui-validatebox\" data-options=\"required:true,validType:'blength[1,50]'\"/></td>\r\n");
      out.write("\t\t\t<th style=\"width:100px\">性别</th>\r\n");
      out.write("\t\t\t<td>男<input type=\"radio\" name=\"gender\" value=\"true\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wx:checked(obj.gender)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false));
      out.write("/> 女<input type=\"radio\" name=\"gender\" value=\"false\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wx:checked(!obj.gender)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false));
      out.write("/></td>\r\n");
      out.write("\t\t</tr>\r\n");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("<tr>\r\n");
      out.write("\t\t\t<th>单位/部门</th>\r\n");
      out.write("\t\t\t<td colspan=\"3\"><input id=\"orgTree\" name=\"department\" class=\"easyui-combobox\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.department}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" data-options=\"required:true,url:'");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("'\"\r\n");
      out.write("\t\t\t style=\"width:300px;\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>管理员</th>\r\n");
      out.write("\t\t\t<td>管理员<input type=\"radio\" name=\"admin\" value=\"true\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wx:checked(obj.admin)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false));
      out.write("/> 非管理员<input type=\"radio\" name=\"admin\" value=\"false\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wx:checked(!obj.admin)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false));
      out.write("/></td>\r\n");
      out.write("\t\t\t<th>状态</th>\r\n");
      out.write("\t\t\t<td>可用<input type=\"radio\" name=\"enable\" value=\"true\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wx:checked(obj.enable)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false));
      out.write("/> 禁用<input type=\"radio\" name=\"enable\" value=\"false\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wx:checked(!obj.enable)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false));
      out.write("/></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>身份证号</th>\r\n");
      out.write("\t\t\t<td><input type=\"text\" name=\"idNumber\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.idNumber}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" style=\"width:180px\" class=\"easyui-validatebox\" data-options=\"validType:'blength[18,18]'\"/></td>\r\n");
      out.write("\t\t\t<th>电子邮件</th>\r\n");
      out.write("\t\t\t<td><input type=\"text\" name=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.email}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" style=\"width:180px\" class=\"easyui-validatebox\" data-options=\"validType:'blength[1,50]'\"/></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<table id=\"dg-sys-user-attas\"></table>\r\n");
      out.write("</div>\r\n");
      out.write("<input type=\"hidden\" name=\"id\"       value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("<input type=\"hidden\" id=\"sys-user-attaIds\" name=\"attaIds\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.attaIds}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("<script>\r\n");
      out.write("WX.sys.fileattas('#dg-sys-user-attas','#sys-user-attaIds',true);\r\n");
      out.write("</script>");
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

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /ex/sys/user/_form.jsp(11,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty obj}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<tr>\r\n");
        out.write("\t\t\t<th>用户口令</th>\r\n");
        out.write("\t\t\t<td><input type=\"password\" name=\"password\" id=\"use_password\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.password}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" style=\"width:180px\" class=\"easyui-validatebox\" data-options=\"required:true,validType:'blength[1,50]'\"/></td>\r\n");
        out.write("\t\t\t<th>确认口令</th>\r\n");
        out.write("\t\t\t<td><input type=\"password\" name=\"repassword\" style=\"width:180px\" class=\"easyui-validatebox\" required=\"required\" validType=\"equals['#use_password']\"/></td>\r\n");
        out.write("\t\t</tr>\r\n");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /ex/sys/user/_form.jsp(21,140) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/sys/dict/dicts/department");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }
}
