package m.w.message.service;

import java.util.List;
import java.util.Map;

import m.w.core.dto.Result;
import m.w.core.service.WxIdService;
import m.w.message.domain.PushBatch;
import m.w.message.domain.Pushable;
import m.w.message.domain.WechatPushFactory;
import m.w.message.util.TemplateTypes;
import m.w.sys.domain.SysLog;
import m.w.sys.util.LogHelper;

import org.nutz.ioc.loader.annotation.IocBean;

/**
 * PushBatch
 *
 */
@IocBean(fields="dao")
public class PushBatchService extends WxIdService<PushBatch>{
	
	public Result updateBatch(PushBatch pushBatch, List<String> pushList) throws Exception{
		Pushable p = (Pushable) WechatPushFactory.getInstance(TemplateTypes.getPath(pushBatch.getType()), pushBatch, TemplateTypes.getTxid(pushBatch.getType()), pushList, "1");
		Result result;
		Map<String, Integer> map = p.generateData();
		int total = map.get("total");
		int success = map.get("success");
		int field = map.get("field");
		int bind = map.get("bind");
		if(success>0){
			pushBatch.setCount(success);
			String str = "修改消息推送成功【"+success+"/"+total+"】条。！";
			if(field>0){
				str += "字段不匹配【"+field+"】条。";
			}
			if(bind>0){
				str += "用户未绑定【"+bind+"】条。";
			}
			LogHelper.saveLog(SysLog.ACTION_UPDATE, "修改消息推送:【"+pushBatch.getTitle()+"】,成功【"+success+"】条,失败【"+(total-success)+"】条");
			result = Result.ok(str);
		}else{//一条都没成功的情况
			String str = "修改消息推送成功【"+success+"/"+total+"】条。！";
			if(field>0){
				str += "其中字段不匹配【"+field+"】条。";
			}
			if(bind>0){
				str += "用户未绑定【"+bind+"】条。";
			}
			result = Result.err(str);
		}
		update(pushBatch, "更新成功", "更新失败");
		return result;
	}
	
	public Result addBatch(PushBatch pushBatch, List<String> pushList) throws Exception {
		Pushable p = (Pushable) WechatPushFactory.getInstance(TemplateTypes.getPath(pushBatch.getType()), pushBatch, TemplateTypes.getTxid(pushBatch.getType()), pushList, "1");
		return getCount(p.generateData(), pushBatch);
	}
	
	public Result getCount(Map<String, Integer> map, PushBatch pushBatch){
		Result result;
		int total = map.get("total");
		int success = map.get("success");
		int field = map.get("field");
		int bind = map.get("bind");
		if(success>0){
			pushBatch.setCount(success);
			update(pushBatch);
			String str = "新建消息推送成功【"+success+"/"+total+"】条。！";
			if(field>0){
				str += "字段不匹配【"+field+"】条。";
			}
			if(bind>0){
				str += "用户未绑定【"+bind+"】条。";
			}
			LogHelper.saveLog(SysLog.ACTION_INSERT, "新增消息推送:【"+pushBatch.getTitle()+"】,成功【"+success+"】条,失败【"+(total-success)+"】条");
			result = Result.ok(str);
		}else{//一条都没成功的情况
			delete(pushBatch.getId());
			String str = "新建消息推送成功【"+success+"/"+total+"】条。！";
			if(field>0){
				str += "其中字段不匹配【"+field+"】条。";
			}
			if(bind>0){
				str += "用户未绑定【"+bind+"】条。";
			}
			result = Result.err(str);
		}
        return result;
	}


}
