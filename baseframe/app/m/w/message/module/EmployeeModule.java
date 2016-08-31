package m.w.message.module;

import org.nutz.dao.Cnd;
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
import m.w.message.domain.Employee;
import m.w.message.service.EmployeeService;
import m.w.message.util.Employees;

@At("/wechat/employee")
@IocBean
public class EmployeeModule extends BasicModule  {
    @Inject
    private EmployeeService employeeService;
    
    @At
    @Ok("jsp:/wechat/employee/index")
    public void index() {

    }
    
    @At
    public DataGrid items() {
        return employeeService.datagrid(true,(Cnd)Cnd.limit().asc("groups").desc("id"));
    }
    
    @At
    @POST
    public Result add(@Param("..") Employee type) {
        return employeeService.insert(type, null, null);
    }

    @At
    @POST
    public Result update(@Param("..") Employee type) {
        return employeeService.update(type, null, null);
    }

    @At("/delete/?")
    @DELETE
    public Result delete(Long id) {
        return employeeService.delete(id, null, null);
    }
    
    @At
    public Result reload(){
    	return Employees.reload() ? Result.ok() : Result.err();
    }
    
}
