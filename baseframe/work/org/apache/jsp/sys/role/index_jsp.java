package org.apache.jsp.sys.role;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import m.w.App;
import m.w.sys.util.Users;
import m.w.sys.util.Acls;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<head>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(function(){\r\n");
      out.write("\t\t\t$('#dg-role').wxgrid({\r\n");
      out.write("\t\t\t\turl       :'");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("',\r\n");
      out.write("\t\t\t\taddUrl    :'");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("',\r\n");
      out.write("\t\t\t\tupdateUrl :'");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("',\r\n");
      out.write("\t\t\t\tdelUrl    :'");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("',\r\n");
      out.write("\t\t\t\tlookUrl   :'");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("',\r\n");
      out.write("\t\t\t\teditDlg   :'#dlg-role',\r\n");
      out.write("\t\t\t\teditForm  :'#fm-role',\r\n");
      out.write("\t\t\t\tsearcher  : '#s-role',\r\n");
      out.write("\t\t\t\ttoolbarx : [\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\ttext:'|'\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t,{\r\n");
      out.write("\t\t\t\t\t\tid:'bt-role-permissions',\r\n");
      out.write("\t\t\t\t\t\ttext:'维护角色授权',\r\n");
      out.write("\t\t\t\t\t\ticonCls:'icon-wrench',\r\n");
      out.write("\t\t\t\t\t\thandler:function(){\r\n");
      out.write("\t\t\t\t\t\t\tvar row = $('#dg-role').datagrid('getSelected');\r\n");
      out.write("\t\t\t\t\t\t\tif (row){\r\n");
      out.write("\t\t\t\t\t\t\t\t$('#dlg-role-def').dialog({title:'维护角色授权'}).dialog('open').dialog('refresh', '");
      if (_jspx_meth_c_005furl_005f5(_jspx_page_context))
        return;
      out.write("/'+row.id);\r\n");
      out.write("\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttitle:'<span class=\"blue\">提示</span>',\r\n");
      out.write("\t\t\t\t\t\t\t\t\tmsg:'请先<span class=\"blue\">选择记录</span>后再进行维护角色授权。'\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t,{\r\n");
      out.write("\t\t\t\t\t\tid:'bt-role-users',\r\n");
      out.write("\t\t\t\t\t\ttext:'维护用户角色',\r\n");
      out.write("\t\t\t\t\t\ticonCls:'icon-user',\r\n");
      out.write("\t\t\t\t\t\thandler:function(){\r\n");
      out.write("\t\t\t\t\t\t\tvar row = $('#dg-role').datagrid('getSelected');\r\n");
      out.write("\t\t\t\t\t\t\tif (row){\r\n");
      out.write("\t\t\t\t\t\t\t\t$('#dlg-role-def').dialog({title:'维护用户角色'}).dialog('open').dialog('refresh', '");
      if (_jspx_meth_c_005furl_005f6(_jspx_page_context))
        return;
      out.write("/'+row.id);\r\n");
      out.write("\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttitle:'<span class=\"blue\">提示</span>',\r\n");
      out.write("\t\t\t\t\t\t\t\t\tmsg:'请先<span class=\"blue\">选择记录</span>后再进行维护用户角色。'\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t]\r\n");
 if(!m.w.App.isRoot()){ 
      out.write("\r\n");
      out.write("\t\t\t\t,onSelect:function(rowIndex, rowData){\r\n");
      out.write("\t\t\t\t\tif(rowData.system=='YES'){\r\n");
      out.write("\t\t\t\t\t\t$('#bt-role-permissions').linkbutton('disable');\r\n");
      out.write("\t\t\t\t\t\t$('#dg-role-update').linkbutton('disable');\r\n");
      out.write("\t\t\t\t\t\t$('#dg-role-del').linkbutton('disable');\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t$('#bt-role-permissions').linkbutton('enable');\r\n");
      out.write("\t\t\t\t\t\t$('#dg-role-update').linkbutton('enable');\r\n");
      out.write("\t\t\t\t\t\t$('#dg-role-del').linkbutton('enable');\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
}
      out.write("\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"easyui-layout\" fit=\"true\">\r\n");
      out.write("\t\t<div region=\"north\" border=\"false\">\r\n");
      out.write("\t\t\t<div class=\"subtitle\">角色管理</div>\r\n");
      out.write("\t\t\t<div class=\"toolbar\">\r\n");
      out.write("\t\t\t\t<input id=\"s-role\" class=\"easyui-searchbox\" style=\"width:500px\"\r\n");
      out.write("\t\t\t\t\tdata-options=\"prompt:'请输入要查询的值',menu:'#sroleMenu'\"></input>\r\n");
      out.write("\t\t\t\t<div id=\"sroleMenu\" style=\"width:120px\">\r\n");
      out.write("\t\t\t\t\t<div data-options=\"name:'lk_name'\">查询名称</div>\r\n");
      out.write("\t\t\t\t\t<div data-options=\"name:'in_id'\">查询ID</div>\r\n");
      out.write("\t\t\t\t\t<div data-options=\"name:'lk_description'\">查询描述</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div region=\"center\" border=\"false\" style=\"padding:0 5px 5px 5px\">\r\n");
      out.write("\t\t\t<table id=\"dg-role\" title=\"角色管理\">\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th sortable=\"true\"  width=\"50\"  align=\"center\" field=\"id\">ID</th>\r\n");
      out.write("\t\t\t\t\t\t<th sortable=\"true\"  width=\"200\"  align=\"left\" field=\"name\">名称</th>\r\n");
      out.write("\t\t\t\t\t\t<th sortable=\"true\"  width=\"50\"   align=\"center\" field=\"system\" showField=\"systemText\">系统角色</th>\r\n");
      out.write("\t\t\t\t\t\t<th sortable=\"true\"  width=\"400\"  align=\"left\" field=\"description\">描述</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"easyui-dialog\" closed=\"true\" id=\"dlg-role\" title=\"角色管理\" style=\"width:800px;height:500px;position:relative\"></div>\r\n");
      out.write("\t<div class=\"easyui-dialog\" closed=\"true\" id=\"dlg-role-def\" style=\"width:800px;height:500px;position:relative\"></div>\r\n");
      out.write("</body>\r\n");
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
    // /sys/role/index.jsp(7,16) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/sys/role/items");
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
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /sys/role/index.jsp(8,16) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/sys/role/add");
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
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f2.setParent(null);
    // /sys/role/index.jsp(9,16) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/sys/role/update");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f3.setParent(null);
    // /sys/role/index.jsp(10,16) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/sys/role/delete");
    int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
    if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f4 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f4.setParent(null);
    // /sys/role/index.jsp(11,16) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f4.setValue("/sys/role/view");
    int _jspx_eval_c_005furl_005f4 = _jspx_th_c_005furl_005f4.doStartTag();
    if (_jspx_th_c_005furl_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f5 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f5.setParent(null);
    // /sys/role/index.jsp(26,86) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f5.setValue("/sys/role/permission");
    int _jspx_eval_c_005furl_005f5 = _jspx_th_c_005furl_005f5.doStartTag();
    if (_jspx_th_c_005furl_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f6 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f6.setParent(null);
    // /sys/role/index.jsp(42,86) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f6.setValue("/sys/role/user");
    int _jspx_eval_c_005furl_005f6 = _jspx_th_c_005furl_005f6.doStartTag();
    if (_jspx_th_c_005furl_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f6);
    return false;
  }
}
