package m.w.message.service;

import java.util.List;

import m.w.core.service.WxIdService;
import m.w.message.domain.PushDetail;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(fields="dao")
public class PushDetailService extends WxIdService<PushDetail>{

	/**
	 * 根据pid删除
	 * @param pid
	 */
	public void delpid(Long pid) {
		List<PushDetail> list = query(Cnd.where("pid","=",pid),null);
		for(PushDetail p:list)
			delete(p.getId());
	}

}
