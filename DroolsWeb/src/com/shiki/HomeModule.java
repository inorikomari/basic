package com.shiki;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.view.JspView;

import com.shiki.annotation.DroolFields;
import com.shiki.annotation.DroolTables;
import com.shiki.drool.Deploy;
import com.shiki.drool.pojo.Options;
import com.shiki.drool.pojo.Person;
import com.shiki.dto.Result;

public class HomeModule {

	@At
	public View index() {
		return new JspView("/index");
	}
	
	@At
	public Object deploy(@Param("..")Person obj,HttpServletRequest rq) throws Exception{
		File f = new File(rq.getSession().getServletContext().getRealPath("/rules")+"\\personscore.drl");
		Double d = Deploy.deploy(f,obj);
		return Result.ok("持卡客户评分:" + d);
	}

	public static void main(String[] args) {
	}

	@At
	@Ok("jsp:/error")
	public void error() {

	}
	
	@At
	public Object rulestr(String rulestr,HttpServletRequest rq) throws IOException{
		System.out.println(rulestr);
		OutputStreamWriter osw;
		File f,path;
		path = new File(rq.getSession().getServletContext().getRealPath("/rules"));
		if(!path.exists())
			path.mkdirs();
		f = new File("file://"+rq.getSession().getServletContext().getRealPath("/rules")+"/personscore.drl");
		osw = new OutputStreamWriter(new FileOutputStream(f));
		osw.write(rulestr,0,rulestr.length());  
		osw.flush(); 
		osw.close();
		return Result.ok();
	}
	
	@At
	public Object fieldList(){
		// 获取属性列表map
		List<Options> list = new ArrayList<Options>();
		Class<Person> person = Person.class;
		Field f_property[] = person.getDeclaredFields();
		DroolFields d;
		for (Field field1 : f_property) {
			d  = null;
			if (field1.isAnnotationPresent(DroolFields.class)){
				d = field1.getAnnotation(DroolFields.class);
				if(d.dict())
					list.add(new Options(d.column(),d.describ()));
			}
		}
		return list;
	}
	
	@At
	public Object gradeList(){
		List<Options> list = new ArrayList<Options>();
		Class<Person> person = Person.class;
		Field f_property[] = person.getDeclaredFields();
		DroolFields d;
		for (Field field1 : f_property) {
			d  = null;
			if (field1.isAnnotationPresent(DroolFields.class)){
				d = field1.getAnnotation(DroolFields.class);
				if(d.isgrade())
					list.add(new Options(d.column(),d.describ()));
			}
		}
		return list;
	}
	
	@At
	public Object countOperators(){
		List<Options> list = new ArrayList<Options>();
		list.add(new Options("+","增加"));
		list.add(new Options("-","减少"));
		return list;
	}
	
	@At
	public Object operators(){
		List<Options> list = new ArrayList<Options>();
		list.add(new Options(">","大于"));
		list.add(new Options("<","小于"));
		list.add(new Options("==","等于"));
		list.add(new Options("!=","不等于"));
		list.add(new Options(">=","大于等于"));
		list.add(new Options("<=","小于等于"));
		return list;
	}
	
	@At
	public Object logical(){
		List<Options> list = new ArrayList<Options>();
		list.add(new Options("&&","并且"));
		list.add(new Options("||","或者"));
		return list;
	}
	
	@At
	public Object education(){
		List<Options> list = new ArrayList<Options>();
		list.add(new Options("Person.POSTGRADUATE", Person.POSTGRADUATE));
		list.add(new Options("Person.UNDERGRADUATE_COURSE",Person.UNDERGRADUATE_COURSE));
		list.add(new Options("Person.HIGH_SCHOOL", Person.HIGH_SCHOOL));
		return list;
	}
	
	@At
	public Object properties(HttpServletResponse rp) throws IOException{
		String basetag="<input type='hidden' ";
		StringBuffer html = new StringBuffer();
		Class<Person> person = Person.class;
		Field f_property[] = person.getDeclaredFields();
		DroolFields d;
		for (Field field1 : f_property) {
			d = null;
			if (field1.isAnnotationPresent(DroolFields.class)) {
				d = field1.getAnnotation(DroolFields.class);
				if(d.dict()){
					html.append(basetag+"id='"+d.column()+"' name='"+d.column()+"' url='"+d.url()+"' />");
				}
				if(d.isgrade()){
					html.append(basetag+"id='"+d.column()+"' name='"+d.column()+"' getm='"+d.getMethod()+"' setm='"+d.setMethod()+"' />");
				}
			}
		}
		DroolTables t = person.getAnnotation(DroolTables.class);
		html.append(basetag+"id='pojo' name='"+t.pojo()+"' package='"+person.getPackage().getName()+"."+t.pojo()+"' />");
		rp.setContentType("text/html");
		rp.getWriter().write(html.toString());
		rp.getWriter().flush();
		return null;
	}
	
	@At
	public Object inputproperties(HttpServletResponse rp) throws IOException{
		String basetag="<input type='text' ";
		StringBuffer html = new StringBuffer();
		Class<Person> person = Person.class;
		Field f_property[] = person.getDeclaredFields();
		DroolFields d;
		for (Field field1 : f_property) {
			d = null;
			if (field1.isAnnotationPresent(DroolFields.class)) {
				d = field1.getAnnotation(DroolFields.class);
				if(d.dict()){
					html.append(d.describ()+":"+basetag+"id='in_"+d.column()+"' name='"+d.column()+"' /><br />");
				}
			}
		}
		rp.setContentType("text/html");
		rp.getWriter().write(html.toString());
		rp.getWriter().flush();
		return null;
	}


}