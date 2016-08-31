package com.shiki.drool.module;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.DELETE;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;

import com.shiki.BasicModule;
import com.shiki.drool.domain.BusiModelAttr;
import com.shiki.drool.service.BusiModelAttrService;
import com.shiki.dto.DataGrid;
import com.shiki.dto.Result;

@At("/busi/attr")
@IocBean
public class BusiModelAttrModule extends BasicModule {
	private static final String PS = "/busi/attr";
    private static final String NM = "评分模型项";
    
    @Inject
    private BusiModelAttrService busiModelAttrService;
    
    @At
    @Ok("jsp:"+PS+"/index")
    public void index() {

    }
    
    /** 列表 */
    @At({"/items/"})
    public DataGrid items() {
        return busiModelAttrService.datagrid(true);
    }
    
    /** 新增 */
    @At
    @POST
    public Result add(@Param("..") BusiModelAttr attr) {
        return busiModelAttrService.insert(attr, NM+"新建成功", NM+"新建失败");
    }
    
    /** 修改 */
    @At
    @POST
    public Result update(@Param("..") BusiModelAttr attr) {
        return busiModelAttrService.update(attr, NM+"更新成功", NM+"更新失败");
    }
    
    /** 按主键删除 */
    @At("/delete/?")
    @DELETE
    public Result delete(Long id) {
        return busiModelAttrService.delete(id, NM+"删除成功", NM+"删除失败");
    }
}
