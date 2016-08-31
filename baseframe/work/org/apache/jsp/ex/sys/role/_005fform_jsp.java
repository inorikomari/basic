package org.apache.jsp.ex.sys.role;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import m.w.App;
import m.w.sys.util.Users;
import m.w.sys.util.Acls;

public final class _005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<div style=\"padding-top:30px;\">\r\n");
      out.write("\t<table class=\"form-table\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th style=\"width:100px\">名称</th>\r\n");
      out.write("\t\t\t<td><input name=\"name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" style=\"width:95%\" class=\"easyui-validatebox\" data-options=\"required:true,validType:'blength[1,50]'\"/></td>\r\n");
      out.write("\t\t</tr>\r\n");
 if(m.w.App.isRoot()){ 
      out.write("<tr>\r\n");
      out.write("\t\t\t<th style=\"width:100px\">系统角色</th>\r\n");
      out.write("\t\t\t<td><input  name=\"system\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.system}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"easyui-combobox\" data-options=\"required:true,url:'");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("'\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
}
      out.write("<tr>\r\n");
      out.write("\t\t\t<th style=\"width:100px\">描述</th>\r\n");
      out.write("\t\t\t<td><textarea name=\"description\" style=\"width:95%;height:250px\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.description}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</textarea></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</div>\r\n");
      out.write("<input type=\"hidden\" name=\"id\"       value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
 if(!m.w.App.isRoot()){ 
      out.write("<input type=\"hidden\" name=\"system\"   value=\"NO\"/>\r\n");
}
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
    // /ex/sys/role/_form.jsp(12,108) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/sys/const/options/Role/system");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }
}
