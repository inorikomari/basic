package m.w.message.module;

import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.DELETE;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;

import m.w.BasicModule;
import m.w.core.dto.DataGrid;
import m.w.core.dto.Result;
import m.w.message.domain.TemplateType;
import m.w.message.service.TemplateTypeService;
import m.w.message.util.TemplateTypes;

@At("/wechat/template")
@IocBean
public class TemplateTypeModule extends BasicModule {
    @Inject
    private TemplateTypeService templateTypeService;
    
    @At
    @Ok("jsp:/wechat/template/index")
    public void index() {

    }
    
    @At
    public DataGrid types() {
        return templateTypeService.datagrid();
    }
    
    @At
    @POST
    public Result add(@Param("..") TemplateType type) {
        return templateTypeService.insert(type, null, null);
    }

    @At
    @POST
    public Result update(@Param("..") TemplateType type) {
        return templateTypeService.update(type, null, null);
    }

    @At("/delete/?")
    @DELETE
    public Result delete(Long id) {
        return templateTypeService.delete(id, null, null);
    }
    
    @At
    public Result reload(){
    	return TemplateTypes.reload() ? Result.ok() : Result.err();
    }
    
    
    @At("/list")
    public List<TemplateType> list(){
    	return TemplateTypes.types();
    }
    
}
