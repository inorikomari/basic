package com.shiki.drool.module;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.DELETE;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;

import com.shiki.BasicModule;
import com.shiki.drool.domain.BusiModelAttr;
import com.shiki.drool.domain.BusiModelRule;
import com.shiki.drool.domain.BusiModelRuleItem;
import com.shiki.drool.domain.BusiModelRuleWeighted;
import com.shiki.drool.service.BusiModelAttrService;
import com.shiki.drool.service.BusiModelRuleItemService;
import com.shiki.drool.service.BusiModelRuleService;
import com.shiki.drool.service.BusiModelRuleWeightedService;
import com.shiki.drool.service.BusiModelService;
import com.shiki.dto.DataGrid;
import com.shiki.dto.Result;

import freemarker.template.TemplateException;

@At("/busi/rule")
@IocBean
public class BusiModelRuleModule extends BasicModule {
	private static final String PS = "/busi/rule";
    private static final String NM = "评分模型";
    
    @Inject
    private BusiModelRuleService busiModelRuleService;
    
    @Inject
    private BusiModelService busiModelService;
    
    @Inject
    private BusiModelAttrService busiModelAttrService;
    
    @Inject
    private BusiModelRuleItemService busiModelRuleItemService;
    
    @Inject
    private BusiModelRuleWeightedService busiModelRuleWeightedService;
    
    @At
    @Ok("jsp:"+PS+"/index")
    public void index() {

    }
    
    @At
    @Ok("jsp:"+PS+"/deploy")
    public void deploy(){
    	
    }
    
    /** 列表 */
    @At({"/items/"})
    public DataGrid items() {
        return busiModelRuleService.datagrid(true);
    }
    
    @At({"/items1/"})
    public DataGrid items1() {
        return busiModelRuleService.datagrid(Cnd.where("content","<>","null"));
    }
    
    /** 新增 */
    @At
    @POST
    public Result add(@Param("..") BusiModelRule rule) {
        return busiModelRuleService.insert(rule, NM+"新建成功", NM+"新建失败");
    }
    
    /** 修改 */
    @At
    @POST
    public Result update(@Param("..") BusiModelRule rule) {
        return busiModelRuleService.update(rule, NM+"更新成功", NM+"更新失败");
    }
    
    /** 按主键删除 */
    @At("/delete/?")
    @DELETE
    public Result delete(Long id) {
        return busiModelRuleService.delete(id, NM+"删除成功", NM+"删除失败");
    }
    
    @At("/field/list/?")
	public Object fieldList(String modelid){
    	return busiModelRuleService.fieldList(modelid);
    }
    
	@At("/grade/list/?")
	public Object gradeList(String modelid){
		return busiModelRuleService.gradeList(modelid);
	}
	
	@At
	public Result saverule(@Param("..") BusiModelRuleItem item){
		return busiModelRuleItemService.insert(item, NM+"新建成功", NM+"新建失败");
	}
	
	@At
	public Result saveweights(@Param("..") BusiModelRuleWeighted weights){
		return busiModelRuleWeightedService.insert(weights, NM+"新建成功", NM+"新建失败");
	}
	
	@At
	public Result savescore(@Param("attribute") String attributes, @Param("weighted") String weighteds, @Param("modelId") String modelId){
		return busiModelRuleWeightedService.savescore(attributes, weighteds, modelId);
	}
	
	@At("/generatedrl/?")
	public Result generatedrl(String modelid) throws IOException, TemplateException{
		return busiModelRuleService.generatedrl(modelid);
	}
	
	@At("/truncaterules/?")
	public Result truncaterules(String modelid){
		return busiModelRuleService.truncaterules(modelid);
	}
	
	@At("/getscore/?")
	public Result getscore(String modelid, @Param("ids")String ids, @Param("values")String values) throws Exception{
		return busiModelRuleService.getscore(modelid, ids, values);
	}
	
	@At("/properties/?")
	public Object properties(String modelid, HttpServletResponse rp) throws IOException{
    	String html = busiModelRuleService.properties(modelid);
    	if(null==html)
    		return null;
		rp.setContentType("text/html");
		rp.getWriter().write(html);
		rp.getWriter().flush();
		return null;
	}
	
	@At("/inputproperties/?")
	public Object inputproperties(String modelid, HttpServletResponse rp) throws IOException{
		String html = busiModelRuleService.inputproperties(modelid);
		if(null==html)
			return null;
		rp.setContentType("text/html");
		rp.getWriter().write(html);
		rp.getWriter().flush();
		return null;
	}
	
	@At("/existrules/?")
	public Object existrule(String modelid, HttpServletResponse rp) throws IOException{
		String html = busiModelRuleService.existrules(modelid);
		if(null==html)
			return null;
		rp.setContentType("text/html");
		rp.getWriter().write(html);
		rp.getWriter().flush();
		return null;
	}
	
	@At("/existweights/?")
	public Object existweights(String modelid, HttpServletResponse rp) throws IOException{
		String html = busiModelRuleService.existweights(modelid);
		if(null==html)
			return null;
		rp.setContentType("text/html");
		rp.getWriter().write(html);
		rp.getWriter().flush();
		return null;
	}
	
	@At("/weighted/?")
	public Object weighted(String modelid, HttpServletResponse rp) throws IOException{
		String html = busiModelRuleService.weighted(modelid);
		if(null==html)
			return null;
		rp.setContentType("text/html");
		rp.getWriter().write(html);
		rp.getWriter().flush();
		return null;
	}
	
    @At("/define/?")
    @Ok("jsp:"+PS+"/define")
    public Object define(Long id){
    	BusiModelRule r = busiModelRuleService.fetch(id);
    	List<BusiModelAttr> list = busiModelAttrService.query(Cnd.where("modelId","=",r.getModelId()),null);
    	if(list.isEmpty())
    		return null;
        return r;
    }
    
    @At("/field/?")
    @Ok("jsp:"+PS+"/field")
    public Object field(Long id){
        return busiModelRuleService.fetch(id);
    }
    
    @At("/input/?")
    @Ok("jsp:"+PS+"/input")
    public Object input(Long id){
        return busiModelRuleService.fetch(id);
    }
    
    @At("/fields/?")
    public Object fields(String mid){
        return busiModelRuleService.fields(mid);
    }
    
    @At("/addFields/?")
    @POST
    public Result addFields(String mid, @Param("fieldIds")String fieldIds){
        return busiModelAttrService.addFields(mid, fieldIds);
    }
    
    @At("/delFields/?")
    @POST
    public Result delFields(String mid, @Param("fieldIds")String fieldIds){
        return busiModelAttrService.delFields(mid, fieldIds);
    }
}
