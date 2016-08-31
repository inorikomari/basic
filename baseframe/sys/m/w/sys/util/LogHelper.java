package m.w.sys.util;

import java.util.Calendar;

import m.w.core.util.Daos;
import m.w.sys.domain.SysLog;
import m.w.sys.domain.User;

import org.nutz.dao.Dao;
import org.nutz.mvc.Mvcs;

public class LogHelper {
	public static void saveLog(String action, String msg){
		Dao dao = Daos.dao();
		SysLog log = new SysLog();
		User user = Users.user();
		log.setAction(action);
		log.setMsg(msg);
		log.setUserId(user.getId());
		log.setUserName(user.getUsername());
		log.setOnTime(Calendar.getInstance().getTime());
		log.setIp(Mvcs.getReq().getRemoteHost());
		dao.insert(log);
	}
}
