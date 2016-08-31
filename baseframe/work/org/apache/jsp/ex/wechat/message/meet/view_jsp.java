package org.apache.jsp.ex.wechat.message.meet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import m.w.App;
import m.w.sys.util.Users;
import m.w.sys.util.Acls;

public final class view_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("wx:datetime", m.w.tags.DateTag.class, "datetime", new Class[] {java.util.Date.class});
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

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

      out.write("<div style=\"width:686px;height:382px\">\r\n");
      out.write("\t<table class=\"form-table\" width=\"98%\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th style=\"width:100px\">标题</th>\r\n");
      out.write("\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th style=\"width:100px\">模板类型</th>\r\n");
      out.write("\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.typeText}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th style=\"width:100px\">发送到</th>\r\n");
      out.write("\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.groupsText}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th style=\"width:100px\">内容</th>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<table class=\"form-table\" width=\"98%\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"width:100px\">正文:</th>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.msgContent}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"width:100px\">会议时间:</th>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.msgTime}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"width:100px\">会议地点:</th>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.msgLocation}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"width:100px\">参会人员:</th>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.msgAddress}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"width:100px\">备注:</th>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.msgRemark}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th style=\"width:100px\">描述</th>\r\n");
      out.write("\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.describe}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th style=\"width:100px\">优先级</th>\r\n");
      out.write("\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.priorityText}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th style=\"width:100px\">状态</th>\r\n");
      out.write("\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.statusText}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th style=\"width:100px\">控制标志</th>\r\n");
      out.write("\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.controlText}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th style=\"width:100px\">总条数</th>\r\n");
      out.write("\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.count}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th style=\"width:100px\">录入人</th>\r\n");
      out.write("\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${obj.inputName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th style=\"width:100px\">录入时间</th>\r\n");
      out.write("\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wx:datetime(obj.onTime)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
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
}
