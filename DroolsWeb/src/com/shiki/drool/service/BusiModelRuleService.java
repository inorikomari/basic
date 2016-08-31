package com.shiki.drool.service;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.kie.api.KieBase;
import org.kie.api.definition.type.FactType;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;

import com.shiki.drool.domain.BusiModel;
import com.shiki.drool.domain.BusiModelAttr;
import com.shiki.drool.domain.BusiModelRule;
import com.shiki.drool.domain.BusiModelRuleItem;
import com.shiki.drool.domain.BusiModelRuleWeighted;
import com.shiki.drool.pojo.Options;
import com.shiki.dto.Result;
import com.shiki.util.IdService;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * BusiModelRule
 *
 */
@IocBean(fields="dao")
public class BusiModelRuleService extends IdService<BusiModelRule> {

	public Object fields(String mid) {
		List<BusiModelAttr> list = dao().query(BusiModelAttr.class, Cnd.where("modelId","=",mid),null);
    	if(list.isEmpty())
    		return list;
    	Set<String> atts = new HashSet<String>();
    	for(BusiModelAttr attr:list){
    		atts.add(attr.getAttribute());
    	}
    	List<BusiModel> mlist = dao().query(BusiModel.class, Cnd.where("attribute","IN",atts), null);
    	return mlist;
	}

	public Object fieldList(String modelid) {
		List<BusiModelAttr> list = dao().query(BusiModelAttr.class, Cnd.where("modelId","=",modelid),null);
    	if(list.isEmpty())
    		return list;
    	Set<String> atts = new HashSet<String>();
    	for(BusiModelAttr attr:list){
    		atts.add(attr.getAttribute());
    	}
    	List<BusiModel> mlist = dao().query(BusiModel.class, Cnd.where("attribute","IN",atts).and("fieldType","=","01"), null);
    	List<Options> options = new ArrayList<Options>();
    	for(BusiModel b:mlist)
    		options.add(new Options(b.getAttribute(),b.getDescrib()));
    	return options;
	}

	public Object gradeList(String modelid) {
		List<BusiModelAttr> list = dao().query(BusiModelAttr.class, Cnd.where("modelId","=",modelid),null);
    	if(list.isEmpty())
    		return list;
    	Set<String> atts = new HashSet<String>();
    	for(BusiModelAttr attr:list){
    		atts.add(attr.getAttribute());
    	}
    	List<BusiModel> mlist = dao().query(BusiModel.class, Cnd.where("attribute","IN",atts).and("fieldType","=","02"), null);
    	List<Options> options = new ArrayList<Options>();
    	for(BusiModel b:mlist)
    		options.add(new Options(b.getAttribute(),b.getDescrib()));
    	return options;
	}

	public Result generatedrl(String modelid) throws IOException, TemplateException {
		List<BusiModelAttr> list = dao().query(BusiModelAttr.class, Cnd.where("modelId","=",modelid),null);
    	Set<String> atts = new HashSet<String>();
    	for(BusiModelAttr attr:list){
    		atts.add(attr.getAttribute());
    	}
    	List<BusiModel> attr = dao().query(BusiModel.class, Cnd.where("attribute","IN",atts));
		List<BusiModelRuleItem> ri = dao().query(BusiModelRuleItem.class, Cnd.where("modelId","=",modelid).asc("ruleId").asc("conditionId"));
		List<BusiModelRuleWeighted> rw = dao().query(BusiModelRuleWeighted.class, Cnd.where("modelId","=",modelid).asc("ruleId").asc("conditionId"));
		Configuration cfg = new Configuration();  
        cfg.setDirectoryForTemplateLoading(new File(getClass().getResource("/template").getPath()));  
        cfg.setObjectWrapper(new DefaultObjectWrapper());  
  
        /* 获取模板文件 */  
        Template template = cfg.getTemplate("rules.ftl");
        /* 模板数据 */  
        Map<String, Object> root = new HashMap<String, Object>();  
        
        /* 字段定义 */
        Collection<Map<String, String>> properties = new HashSet<Map<String, String>>();  
        root.put("properties", properties);
        
        List<BusiModel> weightedAttrList = new ArrayList<BusiModel>();
        
        Map<String,String> datatypemap = new HashMap<String, String>();
        for(BusiModel b:attr){
        	datatypemap.put(b.getAttribute(), b.getDatatype());
        	Map<String, String> attrmap = new HashMap<String, String>();  
        	attrmap.put("name", b.getAttribute());  
        	attrmap.put("type", b.getDatatype());
        	properties.add(attrmap);
        	if("02".equals(b.getFieldType())){
        		weightedAttrList.add(b);
        		Map<String, String> attrwtmap = new HashMap<String, String>();  
        		attrwtmap.put("name", b.getAttribute()+"wt");  
        		attrwtmap.put("type", "Double");
            	properties.add(attrwtmap);
        	}
        }
        Map<String, String> attrmap = new HashMap<String, String>(); 
    	attrmap.put("name", "weightedscore_");  
    	attrmap.put("type", "Double");
    	properties.add(attrmap);
    	
    	/* 条件定义 */
    	Collection<Map<String, String>> rules = new HashSet<Map<String, String>>(); 
    	root.put("rules", rules);
    	Map<String,String> groups = new HashMap<String,String>();
    	for(BusiModelRuleItem r:ri){
    		groups.put(r.getRuleId(), "");
    	}
    	
    	for(String sub:groups.keySet()){
    		String when = "rm:RuleModel(";
    		String then = "";
    		for(BusiModelRuleItem r:ri){
    			if(sub.equals(r.getRuleId())){
    				if("then".equals(r.getConditionType())){
    					then+="rm.set"+r.getAttribute().substring(0, 1).toUpperCase()+r.getAttribute().substring(1, r.getAttribute().length())
    							+"(rm.get"+r.getAttribute().substring(0, 1).toUpperCase()+r.getAttribute().substring(1, r.getAttribute().length())
    							+"()"+r.getExpression()+r.getValues()+");";
    				}else{
    					String relations = r.getRelation()!=null?r.getRelation():"";
    					String values = datatypemap.get(r.getAttribute()).endsWith("String")?"\""+r.getValues()+"\"":r.getValues();
    					when+=relations+r.getAttribute()+r.getExpression()+values;
    				}
    			}
    		}
    		Map<String, String> rulemap = new HashMap<String, String>();  
    		rulemap.put("rule_no", "rs-"+sub);  
    		rulemap.put("when", when+");");
    		rulemap.put("then", then);
    		rules.add(rulemap);
    	}
    	
    	/* 加权条件定义 */
    	Collection<Map<String, String>> weights = new HashSet<Map<String, String>>(); 
    	root.put("weights", weights);
    	Map<String,String> groupswt = new HashMap<String,String>();
    	for(BusiModelRuleWeighted r:rw){
    		groupswt.put(r.getRuleId(), "");
    	}
    	
    	for(String sub:groupswt.keySet()){
    		String when = "rm:RuleModel(";
    		String then = "";
    		for(BusiModelRuleWeighted r:rw){
    			if(sub.equals(r.getRuleId())){
    				if("then".equals(r.getConditionType())){
    					then+="rm.set"+r.getAttribute().substring(0, 1).toUpperCase()+r.getAttribute().substring(1, r.getAttribute().length())+"wt"
    							+"("+r.getValues()+");";
    				}else{
    					String relations = r.getRelation()!=null?r.getRelation():"";
    					String values = datatypemap.get(r.getAttribute()).endsWith("String")?"\""+r.getValues()+"\"":r.getValues();
    					when+=relations+r.getAttribute()+r.getExpression()+values;
    				}
    			}
    		}
    		Map<String, String> rulemap = new HashMap<String, String>();  
    		rulemap.put("rule_no", "wt-"+sub);  
    		rulemap.put("when", when+");");
    		rulemap.put("then", then);
    		rules.add(rulemap);
    	}
    	
    	/* 评分加权 */
    	String wtdstr = "rm.setWeightedscore_((";
    	for(BusiModel w:weightedAttrList){
    		wtdstr+="rm.get"+w.getAttribute().substring(0, 1).toUpperCase()+w.getAttribute().substring(1, w.getAttribute().length())+"()*"
    				+"rm.get"+w.getAttribute().substring(0, 1).toUpperCase()+w.getAttribute().substring(1, w.getAttribute().length())+"wt()+";
    	}
    	wtdstr=wtdstr.substring(0, wtdstr.length()-1)+")/"+weightedAttrList.size()+");";
    	root.put("weighted", wtdstr);
    	
    	Writer out = new StringWriter();  
        template.process(root, out);  
        
        
        BusiModelRule b = dao().fetch(BusiModelRule.class, modelid);
        b.setContent(out.toString());
        dao().update(b);
        return Result.ok();
	}

	public Result truncaterules(String modelid) {
		List<BusiModelRuleItem> ri = dao().query(BusiModelRuleItem.class, Cnd.where("modelId","=",modelid));
		if(!ri.isEmpty()){
			for(BusiModelRuleItem b:ri){
				dao().delete(b);
			}
		}
		List<BusiModelRuleWeighted> rw = dao().query(BusiModelRuleWeighted.class, Cnd.where("modelId","=",modelid));
		if(!rw.isEmpty()){
			for(BusiModelRuleWeighted w:rw){
				dao().delete(w);
			}
		}
		return null;
	}

	public String properties(String modelid) {
		String basetag="<input type='hidden' ";
		StringBuffer html = new StringBuffer();
		List<BusiModelAttr> list = dao().query(BusiModelAttr.class, Cnd.where("modelId","=",modelid));
    	if(list.isEmpty())
    		return null;
    	Set<String> atts = new HashSet<String>();
    	for(BusiModelAttr attr:list){
    		atts.add(attr.getAttribute());
    	}
    	List<BusiModel> mlist = dao().query(BusiModel.class, Cnd.where("attribute","IN",atts), null);
    	int score_no = 0;
    	for(BusiModel b:mlist){
    		String data = b.getControlsContent();
    		if(null==data||"".equals(data))
    			data="none";
    		if("02".equals(b.getFieldType()))
    			score_no++;
			html.append(basetag+"id='"+b.getAttribute()+"' name='"+b.getAttribute()+"' desc='"+b.getDescrib()+"' data='"+data+"' fieldtype='"+b.getFieldType()+"' />");
    	}
    	html.append(basetag+"id='score_count' countno='"+score_no+"' />");
    	return html.toString();
	}

	public String existrules(String modelid) {
		StringBuffer html = new StringBuffer();
		
		List<BusiModelAttr> list = dao().query(BusiModelAttr.class, Cnd.where("modelId","=",modelid),null);
    	Set<String> atts = new HashSet<String>();
    	for(BusiModelAttr attr:list){
    		atts.add(attr.getAttribute());
    	}
    	
    	List<BusiModel> mlist = dao().query(BusiModel.class, Cnd.where("attribute","IN",atts), null);
    	
    	Map<String, String> tmap = new HashMap<String, String>();
		for(BusiModel b:mlist)
			tmap.put(b.getAttribute(), b.getControlsContent());
		
		List<BusiModelRuleItem> ri = dao().query(BusiModelRuleItem.class, Cnd.where("modelId","=",modelid).asc("ruleId").asc("conditionId"));
		if(ri.isEmpty())
			return null;
		
		SortedMap<String,String> groups = new TreeMap<String,String>() ;
    	for(BusiModelRuleItem r:ri){
    		groups.put(r.getRuleId(), "");
    	}
    	//每条规则
    	for(String ruleId:groups.keySet()){
    		StringBuffer when = new StringBuffer("<br/><div id='rule-"+ruleId+"' style='border:2px solid gray;padding-top: 10px;padding-left: 10px;padding-bottom: 10px'>"
												+"<span><b>规则"+ruleId+":&nbsp;</b></span>&nbsp;&nbsp;");
    		StringBuffer then = new StringBuffer("<br /><hr width='95%'/><span><b>评分项:</b></span><br />");
    		int exno1=1,exno2=1;
    		for(BusiModelRuleItem r:ri){
    			if(ruleId.equals(r.getRuleId())){
    				if("then".equals(r.getConditionType())){
    					then.append("<form id='rule-"+ruleId+"-sfm-1'><input type='hidden' name='ruleId' value='"+ruleId+"' /><input type='hidden' name='conditionId' value='999' /><input type='hidden' name='conditionType' value='then' />"
    	    					+"<input type='hidden' name='modelId' value='"+modelid+"' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
    					then.append("<input class='easyui-combobox' name='attribute' id='rule-"+ruleId+"-sc-"+exno2+"' value='"+r.getAttribute()+"' style='width:150px' />&nbsp;");
    					then.append("<input class='easyui-combobox' name='expression' id='rule-"+ruleId+"-ca-"+exno2+"' value='"+r.getExpression()+"' style='width:80px' />&nbsp;");
    					then.append("<input class='easyui-combobox' name='values' id='rule-"+ruleId+"-va-"+exno2+"' data='none' value='"+r.getValues()+"' style='width:150px' />");
    					then.append("</form>");
    					exno2++;
    				}else{
    					when.append("<form id='rule-"+ruleId+"-fm-1'><input type='hidden' name='ruleId' value='"+ruleId+"' />" +
								"<input type='hidden' name='modelId' value='"+modelid+"' /><input type='hidden' name='conditionType' value='when' />");
    					if(null!=r.getRelation()&&!"".equals(r.getRelation()))
    						when.append("<input class='easyui-combobox' name='relation' id='rule-"+ruleId+"-lo-"+exno1+"' value='"+r.getRelation()+"' style='width:53px' />&nbsp;");
    					else
    						when.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
    					
    					String data = tmap.get(r.getAttribute());
    					if(null==data||"".equals(data))
    						data = "none";
    					
    					when.append("<input type='hidden' name='conditionId' value='"+r.getConditionId()+"' />");
    					when.append("<input class='easyui-combobox' name='attribute' id='rule-"+ruleId+"-fd-"+exno1+"' value='"+r.getAttribute()+"' style='width:150px' />&nbsp;");
    					when.append("<input class='easyui-combobox' name='expression' id='rule-"+ruleId+"-op-"+exno1+"' value='"+r.getExpression()+"' style='width:80px' />&nbsp;");
    					when.append("<input class='easyui-combobox' name='values' id='rule-"+ruleId+"-kv-"+exno1+"' data='"+data+"' value='"+r.getValues()+"' style='width:150px' />&nbsp;");
    					when.append("</form>");
    					exno1++;
    				}
    			}
    		}
    		when.append("<a class='easyui-linkbutton addEx' data-options='iconCls:\"icon-add\"' id='rule-"+ruleId+"-btn' ruleno='"+ruleId+"' exno='"+exno1+"' >添加条件</a>");
			then.append("<a class='easyui-linkbutton addSc' data-options='iconCls:\"icon-add\"' id='rule-"+ruleId+"-score-btn' ruleno='"+ruleId+"' exno='"+exno2+"' >添加评分项</a></div>");
			html.append(when);
			html.append(then);
    	}
		return html.toString();
	}
	
	public String existweights(String modelid) {
		StringBuffer html = new StringBuffer();
		
		List<BusiModelAttr> list = dao().query(BusiModelAttr.class, Cnd.where("modelId","=",modelid),null);
    	Set<String> atts = new HashSet<String>();
    	for(BusiModelAttr attr:list){
    		atts.add(attr.getAttribute());
    	}
    	
    	List<BusiModel> mlist = dao().query(BusiModel.class, Cnd.where("attribute","IN",atts), null);
    	
    	Map<String, String> tmap = new HashMap<String, String>();
		for(BusiModel b:mlist)
			tmap.put(b.getAttribute(), b.getControlsContent());
		
		List<BusiModelRuleWeighted> ri = dao().query(BusiModelRuleWeighted.class, Cnd.where("modelId","=",modelid).asc("ruleId").asc("conditionId"));
		if(ri.isEmpty())
			return null;
		
		SortedMap<String,String> groups = new TreeMap<String,String>() ;
    	for(BusiModelRuleWeighted r:ri){
    		groups.put(r.getRuleId(), "");
    	}
    	//每条规则
    	for(String ruleId:groups.keySet()){
    		StringBuffer when = new StringBuffer("<br/><div id='weights-"+ruleId+"' style='border:2px solid gray;padding-top: 10px;padding-left: 10px;padding-bottom: 10px'>"
												+"<span><b>加权规则"+ruleId+":&nbsp;</b></span>&nbsp;&nbsp;");
    		StringBuffer then = new StringBuffer("<br /><hr width='95%'/><span><b>加权项:</b></span><br />");
    		int exno1=1,exno2=1;
    		for(BusiModelRuleWeighted r:ri){
    			if(ruleId.equals(r.getRuleId())){
    				if("then".equals(r.getConditionType())){
    					then.append("<form id='weights-"+ruleId+"-sfm-1'><input type='hidden' name='ruleId' value='"+ruleId+"' /><input type='hidden' name='conditionId' value='999' /><input type='hidden' name='conditionType' value='then' />"
    	    					+"<input type='hidden' name='modelId' value='"+modelid+"' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
    					then.append("<input class='easyui-combobox' name='attribute' id='weights-"+ruleId+"-sc-"+exno2+"' value='"+r.getAttribute()+"' style='width:150px' />&nbsp;");
    					then.append("<b> * 权系数:</b>&nbsp;");
    					then.append("<input class='easyui-combobox' name='values' id='weights-"+ruleId+"-va-"+exno2+"' data='none' value='"+r.getValues()+"' style='width:150px' />");
    					then.append("</form>");
    					exno2++;
    				}else{
    					when.append("<form id='weights-"+ruleId+"-fm-1'><input type='hidden' name='ruleId' value='"+ruleId+"' />" +
								"<input type='hidden' name='modelId' value='"+modelid+"' /><input type='hidden' name='conditionType' value='when' />");
    					if(null!=r.getRelation()&&!"".equals(r.getRelation()))
    						when.append("<input class='easyui-combobox' name='relation' id='weights-"+ruleId+"-lo-"+exno1+"' value='"+r.getRelation()+"' style='width:53px' />&nbsp;");
    					else
    						when.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
    					
    					String data = tmap.get(r.getAttribute());
    					if(null==data||"".equals(data))
    						data = "none";
    					
    					when.append("<input type='hidden' name='conditionId' value='"+r.getConditionId()+"' />");
    					when.append("<input class='easyui-combobox' name='attribute' id='weights-"+ruleId+"-fd-"+exno1+"' value='"+r.getAttribute()+"' style='width:150px' />&nbsp;");
    					when.append("<input class='easyui-combobox' name='expression' id='weights-"+ruleId+"-op-"+exno1+"' value='"+r.getExpression()+"' style='width:80px' />&nbsp;");
    					when.append("<input class='easyui-combobox' name='values' id='weights-"+ruleId+"-kv-"+exno1+"' data='"+data+"' value='"+r.getValues()+"' style='width:150px' />&nbsp;");
    					when.append("</form>");
    					exno1++;
    				}
    			}
    		}
    		when.append("<a class='easyui-linkbutton addWtEx' data-options='iconCls:\"icon-add\"' id='weights-"+ruleId+"-btn' ruleno='"+ruleId+"' exno='"+exno1+"' >添加条件</a>");
			then.append("<a class='easyui-linkbutton addWtSc' data-options='iconCls:\"icon-add\"' id='weights-"+ruleId+"-score-btn' ruleno='"+ruleId+"' exno='"+exno2+"' >添加加权项</a></div>");
			html.append(when);
			html.append(then);
    	}
		return html.toString();
	}

	public String weighted(String modelid) {
		String html = new String();
		html += "<input type='hidden' name='modelId' value='"+modelid+"' /><b>&nbsp;得分</b> = ( ";
		List<BusiModelAttr> list = dao().query(BusiModelAttr.class, Cnd.where("modelId","=",modelid),null);
    	Set<String> atts = new HashSet<String>();
    	for(BusiModelAttr attr:list){
    		atts.add(attr.getAttribute());
    	}
    	List<BusiModel> attr = dao().query(BusiModel.class, Cnd.where("attribute","IN",atts).and("fieldType","=","02"));
		List<BusiModelRuleWeighted> rw = dao().query(BusiModelRuleWeighted.class, Cnd.where("modelId","=",modelid));
		Map<String,String> map = new HashMap<String, String>();
		for(BusiModel b:attr){
			map.put(b.getAttribute(), b.getDescrib());
		}
		if(!rw.isEmpty()){
			for(BusiModelRuleWeighted we:rw){
				html += "<b>"+map.get(we.getAttribute())+"</b> * "+"<input type='hidden' name='attribute' value='"+we.getAttribute()+"' id='"+we.getAttribute()+"'/>" +
						"<input class='easyui-numberbox' value='"+we.getValues()+"' name='weighted' style='width:30px' id='weighted'/> + ";
			}
			html = html.substring(0, html.length()-1) + ") / "+rw.size();
		}else{
	    	for(BusiModel b:attr){
	    		html += "<b>"+b.getDescrib()+"</b> * "+"<input type='hidden' name='attribute' value='"+b.getAttribute()+"' id='"+b.getAttribute()+"'/>" +
						"<input class='easyui-numberbox' value='1.0' name='weighted' style='width:30px' id='weighted'/> + ";
	    	}
	    	html = html.substring(0, html.length()-1) + " ) / "+attr.size();
		}
		return html;
	}

	public String inputproperties(String modelid) {
		String base = "<input class='easyui-combobox' ";
		String html = "<table width='98%'>";
		List<BusiModelAttr> list = dao().query(BusiModelAttr.class, Cnd.where("modelId","=",modelid),null);
    	Set<String> atts = new HashSet<String>();
    	for(BusiModelAttr attr:list){
    		atts.add(attr.getAttribute());
    	}
    	List<BusiModel> attr = dao().query(BusiModel.class, Cnd.where("attribute","IN",atts).and("fieldType","=","01"));
    	for(BusiModel b:attr){
    		String data = b.getControlsContent();
    		if(null==data||"".equals(data))
    			data="none";
    		html += "<tr><th style='width:150px' align='right'>"+b.getDescrib()+":</th>";
    		html += "<td><input type='hidden' name='ids' value='"+b.getAttribute()+"' />" + base + "name='values' style='width:150px' data='"+data+"'/>";
    		html += "</td></tr>";
    	}
    	html+="</table>";
		return html;
	}

	public Result getscore(String modelid, String ids, String values) throws Exception {
		String[] f = ids.split(",");
		String[] v = values.split(",",-1);
		
		String drl = dao().fetch(BusiModelRule.class, modelid).getContent();
		
		List<BusiModel> list = dao().query(BusiModel.class, Cnd.where("attribute","IN",f));
		Map<String, String> tmap = new HashMap<String, String>();
		for(BusiModel b:list)
			tmap.put(b.getAttribute(), b.getDatatype());
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newReaderResource((Reader) new StringReader(drl)), ResourceType.DRL);
        if(kbuilder.hasErrors())
        	System.out.println(kbuilder.getErrors());
        KieBase kbase = kbuilder.newKnowledgeBase();
		FactType factType = kbase.getFactType("com.drool.rules.score", "RuleModel");
		Object model = factType.newInstance();
		for(int i=0;i<f.length;i++){
			if (null == v[i] || v[i].equals(""))
				continue;
			
			String temp = tmap.get(f[i]);
			if (temp.equalsIgnoreCase("String"))
				factType.set(model, f[i], v[i]);
			if (temp.equalsIgnoreCase("Integer"))
				factType.set(model, f[i], Integer.parseInt(v[i]));
			if (temp.equalsIgnoreCase("Float"))
				factType.set(model, f[i], Float.parseFloat(v[i]));
		}
		KieSession ksession = kbase.newKieSession();
		
		ksession.insert(model);
		ksession.fireAllRules();
		
		System.out.println(factType.get(model, "weightedscore_"));
		return Result.ok(String.valueOf(factType.get(model, "weightedscore_")));
	}

}
