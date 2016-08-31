package com.shiki.drool.module;

import com.shiki.dto.Result;


import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.DELETE;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;

import com.shiki.BasicModule;
import com.shiki.drool.domain.BusiModel;
import com.shiki.drool.service.BusiModelService;
import com.shiki.dto.DataGrid;

@At("/busi/model")
@IocBean
public class BusiModelModule extends BasicModule{
	private static final String PS = "/busi/model";
    private static final String NM = "评分项";
	
	@Inject
	private BusiModelService busiModelService;

    @At
    @Ok("jsp:"+PS+"/index")
    public void index() {

    }
    
    /** 列表 */
    @At({"/items/"})
    public DataGrid items() {
        return busiModelService.datagrid(true);
    }
    
    /** 新增 */
    @At
    @POST
    public Result add(@Param("..") BusiModel busiModel) {
        return busiModelService.insert(busiModel, NM+"新建成功", NM+"新建失败");
    }
    
    /** 修改 */
    @At
    @POST
    public Result update(@Param("..") BusiModel busiModel) {
        return busiModelService.update(busiModel, NM+"更新成功", NM+"更新失败");
    }
    
    /** 按主键删除 */
    @At("/delete/?")
    @DELETE
    public Result delete(Long id) {
        return busiModelService.delete(id, NM+"删除成功", NM+"删除失败");
    }
    
}
