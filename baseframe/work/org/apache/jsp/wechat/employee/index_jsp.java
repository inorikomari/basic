package org.apache.jsp.wechat.employee;

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
      out.write("\t\t\t$('#dg-employee').edatagrid({\r\n");
 if(!m.w.App.isRoot()){ 
      out.write("\r\n");
      out.write("\t\t\t\tediting    : false,\r\n");
}
      out.write("\r\n");
      out.write("\t\t\t\tidField    : 'id',\r\n");
      out.write("\t\t\t\tpagination : true,\r\n");
      out.write("\t\t\t\trownumbers : true,\r\n");
      out.write("\t\t\t\tpageSize   : 20,\r\n");
      out.write("\t\t\t\tpageList   : [10,20,30,40,50,100,200],\r\n");
      out.write("\t\t\t\turl        : \"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\",\r\n");
      out.write("\t\t\t\tsaveUrl    : \"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\",\r\n");
      out.write("\t\t\t\tupdateUrl  : \"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\",\r\n");
      out.write("\t\t\t\tdestroyUrl : \"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\",\r\n");
      out.write("\t\t\t\tonHeaderContextMenu: function(e, field){\r\n");
      out.write("\t\t\t\t\tWX.defaultDataGridHeaderContextMenu('dg-employee', e, field);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$('#s-employee').searchbox({  \r\n");
      out.write("\t\t\t    searcher:function(value,name){\r\n");
      out.write("\t\t\t    \t$('#dg-employee').edatagrid('reload', eval(\"({\" + name + \" : '\" + value + \"'})\"));\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$('#searchDept').bind('click',function(){\r\n");
      out.write("\t\t\t\tvar s = $('#sgroups').combobox('getValue');\r\n");
      out.write("\t\t\t\t$('#dg-employee').edatagrid('reload', eval(\"({eq_groups : '\" + s + \"'})\"));\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"easyui-layout\" fit=\"true\">\r\n");
      out.write("\t\t<div region=\"north\" border=\"false\">\r\n");
      out.write("\t\t\t<div class=\"subtitle\">员工管理</div>\r\n");
      out.write("\t\t\t<div class=\"toolbar\">\r\n");
      out.write("\t\t\t\t<input id=\"s-employee\" class=\"easyui-searchbox\" style=\"width:500px\"\r\n");
      out.write("\t\t\t\t\tdata-options=\"prompt:'请输入要查询的值',menu:'#semployeeMenu'\"></input>\r\n");
      out.write("\t\t\t\t<div id=\"semployeeMenu\" style=\"width:120px\">\r\n");
      out.write("\t\t\t\t\t<div data-options=\"name:'eq_id'\">查询id</div>\r\n");
      out.write("\t\t\t\t\t<div data-options=\"name:'lk_certNo'\">查询身份证号</div>\r\n");
      out.write("\t\t\t\t\t<div data-options=\"name:'lk_name'\">查询姓名</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div region=\"center\" border=\"false\">\r\n");
      out.write("\t\t\t<table id=\"dg-employee\" toolbar=\"#tb-employee\" fitColumns=\"true\" fit=\"true\" singleSelect=\"true\">\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th field=\"id\" width=\"50\" editor=\"{type:'numberbox',options:{required:true}}\">ID</th>\r\n");
      out.write("\t\t\t\t\t\t<th field=\"certNo\" width=\"200\" editor=\"{type:'validatebox',options:{required:true}}\">身份证号</th>\r\n");
      out.write("\t\t\t\t\t\t<th field=\"name\" width=\"50\" editor=\"{type:'validatebox',options:{required:true}}\">姓名</th>\r\n");
      out.write("\t\t\t\t\t\t<th field=\"groups\" showField=\"groupsText\" width=\"50\" editor=\"{type:'combobox',options:{url:'");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("'}}\">部门</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"tb-employee\">\r\n");
 if(m.w.App.isRoot()){ 
      out.write("<a class=\"easyui-linkbutton\" iconCls=\"icon-add\"    href=\"#\" plain=\"true\" onclick=\"javascript:$('#dg-employee').edatagrid('addRow')\">新增</a>\r\n");
      out.write("\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-save\"   href=\"#\" plain=\"true\" onclick=\"javascript:$('#dg-employee').edatagrid('saveRow')\">保存</a>\r\n");
      out.write("\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-redo\" href=\"#\" plain=\"true\" onclick=\"javascript:$('#dg-employee').edatagrid('cancelRow')\">回退</a>\r\n");
      out.write("\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-remove\" href=\"#\" plain=\"true\" onclick=\"javascript:$('#dg-employee').edatagrid('destroyRow')\">删除</a>\r\n");
      out.write("\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-resync\" href=\"#\" plain=\"true\" onclick=\"javascript:WX.app.employee.reload()\" style=\"color:red\">刷新缓存</a>\r\n");
}
      out.write("<a class=\"easyui-linkbutton\" iconCls=\"icon-reload\" href=\"#\" plain=\"true\" onclick=\"javascript:$('#dg-employee').edatagrid('reload')\">刷新</a>\r\n");
      out.write("\t\t<input name=\"lk_groups\" id=\"sgroups\" class=\"easyui-combobox query\" data-options=\"multiple:false,editable:false,url:'");
      if (_jspx_meth_c_005furl_005f5(_jspx_page_context))
        return;
      out.write("'\"></input>\r\n");
      out.write("\t\t<a id=\"searchDept\" class=\"easyui-linkbutton\" iconCls=\"icon-search\" href=\"#\" plain=\"true\">查询</a>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>");
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
    // /wechat/employee/index.jsp(15,18) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/wechat/employee/items");
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
    // /wechat/employee/index.jsp(16,18) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/wechat/employee/add");
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
    // /wechat/employee/index.jsp(17,18) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/wechat/employee/update");
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
    // /wechat/employee/index.jsp(18,18) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/wechat/employee/delete");
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
    // /wechat/employee/index.jsp(56,98) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f4.setValue("/sys/dict/dicts/department");
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
    // /wechat/employee/index.jsp(71,118) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f5.setValue("/sys/dict/dicts/department");
    int _jspx_eval_c_005furl_005f5 = _jspx_th_c_005furl_005f5.doStartTag();
    if (_jspx_th_c_005furl_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
    return false;
  }
}
