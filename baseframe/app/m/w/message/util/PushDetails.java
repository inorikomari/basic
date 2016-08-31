package m.w.message.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import m.w.core.util.Daos;
import m.w.message.domain.PushDetail;

import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.alibaba.druid.support.json.JSONUtils;

public class PushDetails {
	private static Log log = Logs.get();

	private static Dao dao = Daos.dao();

	public static void insertInto(Long pid, String content) {
		PushDetail d = new PushDetail();
		d.setPid(pid);
		d.setContent(content);
		d.setState(0);
		dao.insert(d);
	}
	
	public static String getOpenId(String certno, String name){
		Sql sql = Sqls.create("select fs_openid from paf_mmsgbind where fs_certno=@certno and fs_custname=@name");
		sql.params().set("certno", certno);
		sql.params().set("name", name);
		sql.setCallback(new SqlCallback(){
    		@Override
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
    			String openid = "";
    			while(rs.next()){
    				openid  = rs.getString("fs_openid");//获取公司名称
    			}
    			return openid;
    		}
    	});
		dao.execute(sql);
		return sql.getObject(String.class);
	}

	public static int toPush(String content, String[] subTitle,String templateid, Long pid) {
		String[] s = content.split("\\|", -1);
		if (s.length - 2 != subTitle.length) {
			log.warn("字段数目不匹配:" + templateid + ":" + content);
			return -1;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> subMap1 = new HashMap<String, Object>();
		String openid = getOpenId(s[0], s[1]);
		if (null == openid || "".equals(openid)) {
			log.warn("未绑定:" + content);
			return -2;
		}
		map.put("touser", openid);
		map.put("template_id", templateid);
		map.put("url", "http://www.ccb.com/sa");
		map.put("topcolor", "#FF0000");
		for (int i = 0; i < subTitle.length; i++) {
			Map<String, String> m = new HashMap<String, String>();
			m.put("value", s[i + 2]);
			m.put("color", "#173177");
			subMap1.put(subTitle[i], m);
		}
		map.put("data", subMap1);
		String json = JSONUtils.toJSONString(map);
		
		insertInto(pid,json);
		return 0;
	}
}
