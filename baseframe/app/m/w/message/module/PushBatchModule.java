package m.w.message.module;

import java.util.Calendar;

import m.w.BasicModule;
import m.w.core.dto.DataGrid;
import m.w.core.dto.Result;
import m.w.message.domain.PushBatch;
import m.w.message.service.EmployeeService;
import m.w.message.service.PushBatchService;
import m.w.message.service.PushDetailService;
import m.w.message.util.Employees;
import m.w.sys.domain.SysLog;
import m.w.sys.util.LogHelper;
import m.w.sys.util.Users;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.DELETE;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;

/**
 * PushBatch
 * 
 */
@At("/wechat/message")
@IocBean
public class PushBatchModule extends BasicModule {
	private static final String PS = "/wechat/message";
	private static final String NM = "消息推送批次";
	private static final String MEET = "/meet";
	private static final String FILE = "/file";
	
	@Inject
	private PushBatchService pushBatchService;

	@Inject
	private PushDetailService pushDetailService;
	
	@Inject
	private EmployeeService employeeService;

	/** 打开主页面 */
	@At
	@Ok("jsp:" + PS + "/index")
	public void index() {

	}

	@At
	@Ok("jsp:" + PS + "/meet")
	public void meet() {

	}
	
	@At
	@Ok("jsp:" + PS + "/file")
	public void file() {

	}
	
	@At
	@Ok("jsp:" + PS + "/sign")
	public void sign() {

	}

	/** 列表/查询数据获取 */
	@At
	public DataGrid items() {
		return pushBatchService.datagrid();
	}
	
	@At("/items/?")
	public DataGrid items(String type) {
		if("file".equals(type))
			return pushBatchService.datagrid(Cnd.where("groups","LIKE","文件上传%"));
		else
			return pushBatchService.datagrid(Cnd.where("type","=",type).and("groups","NOT LIKE","文件上传%"));
	}


	/** 打开增加页面 */
	@At
	@GET
	@Ok("jsp:/ex" + PS + MEET + "/add")
	public Object addmeet() {
		PushBatch obj = new PushBatch();
		obj.setStatus(0);
		obj.setControl(0);
		obj.setPriority(5);
		obj.setInputName(Users.user().getUsername());
		obj.setOnTime(Calendar.getInstance().getTime());
		obj.setType("1");
		return obj;
	}

	@At
	@GET
	@Ok("jsp:/ex" + PS + FILE + "/add")
	public Object addfile() {
		PushBatch obj = new PushBatch();
		obj.setStatus(0);
		obj.setControl(0);
		obj.setPriority(5);
		obj.setInputName(Users.user().getUsername());
		obj.setOnTime(Calendar.getInstance().getTime());
		return obj;
	}
	
	public static void main(String[] args) {
		String s="DEPT-23,19,22,DEPT-2120";
		System.out.println(s.replaceAll("DEPT-{1}[\\d]+", ""));
	}

	@At
    @POST
    public Result add(@Param("..") PushBatch pushBatch) throws Exception {
		pushBatchService.insert(pushBatch);
    	return pushBatchService.addBatch(pushBatch, employeeService.getPushList(pushBatch));
    }
	
	@At
    @POST
    @AdaptBy(type = UploadAdaptor.class, args = {"${app.root}/WEB-INF/tmp"})
    public Result uploadfile(@Param("..") PushBatch pushBatch, @Param("msgfile") TempFile file) throws Exception {
		if(file == null){
            return Result.err("没有上传任何文件");
        }
		pushBatch.setGroups("文件上传"+file.getMeta().getFileLocalName());
		pushBatchService.insert(pushBatch);
    	return pushBatchService.addBatch(pushBatch, employeeService.getPushList(pushBatch, file));
		
    }

	/** 打开修改页面 */
	@At("/updatemeet/?")
	@GET
	@Ok("jsp:/ex" + PS + MEET + "/update")
	public Object updatemeet(Long id) {
		return pushBatchService.view(id);
	}

	/** 修改 
	 * @throws Exception */
	@At
	@POST
	public Result update(@Param("..") PushBatch pushBatch) throws Exception {
		pushDetailService.delpid(pushBatch.getId());
		return pushBatchService.updateBatch(pushBatch, employeeService.getPushList(pushBatch));
	}
	
	/** 按主键删除 */
	@At("/delete/?")
	@DELETE
	public Result delete(Long id) {
		pushDetailService.delpid(id);
		LogHelper.saveLog(SysLog.ACTION_DELETE, "删除消息推送:【"+pushBatchService.fetch(id).getTitle()+"】。");
		return pushBatchService.delete(id, NM + "删除成功", NM + "删除失败");
	}

	/** 按主键批量删除 */
	@At
	@DELETE
	public Result xdelete(String ids) {
		return pushBatchService.xdelete(ids, NM + "删除成功", NM + "删除失败");
	}
	
	/** 查看 */
	@At("/viewmeet/?")
	@GET
	@Ok("jsp:/ex" + PS + MEET + "/view")
	public Object viewmeet(Long id) {
		return pushBatchService.view(id);
	}

	/** 打开查询条件页面 */
	@At
	@GET
	@Ok("jsp:/ex" + PS + MEET + "/query")
	public void querymeet() {

	}
	
	@At
	@GET
	@Ok("jsp:/ex" + PS + FILE + "/query")
	public void queryfile() {

	}

	/** 查看 */
	@At("/view/?")
	@GET
	@Ok("jsp:/ex" + PS + "/view")
	public Object view(Long id) {
		return pushBatchService.view(id);
	}

	/** 打开查询条件页面 */
	@At
	@GET
	@Ok("jsp:/ex" + PS + "/query")
	public void query() {

	}
	
    @At
    public Object tree() {
        return Employees.tree();
    }

	@At("/changes/?/?")
	@POST
	public Result changes(Long id, Integer status) {
		PushBatch obj = pushBatchService.fetch(id);
		obj.setStatus(status);
		LogHelper.saveLog(SysLog.ACTION_UPDATE, "修改消息推送:【"+obj.getTitle()+"】状态为【"+obj.getStatusText()+"】");
		return pushBatchService.update(obj, "提交处理成功", "提交处理失败");
	}

	@At("/control/?/?")
	@POST
	public Result control(Long id, Integer control) {
		PushBatch pushBatch = pushBatchService.fetch(id);
		pushBatch.setControl(control);
		LogHelper.saveLog(SysLog.ACTION_UPDATE, "修改消息推送:【"+pushBatch.getTitle()+"】状态为【"+pushBatch.getControlText()+"】");
		return pushBatchService.update(pushBatch, "控制标志修改成功", "控制标志修改失败");
	}

	/********************* detail ***********************/

}
