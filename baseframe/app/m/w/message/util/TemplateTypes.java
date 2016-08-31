package m.w.message.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import m.w.core.util.Daos;
import m.w.message.domain.TemplateType;
import m.w.message.domain.TemplateTypeable;

import org.apache.commons.beanutils.BeanUtils;
import org.nutz.dao.Dao;
import org.nutz.log.Log;
import org.nutz.log.Logs;

/**
 * 模板类型操作类
 * @author zxp
 *
 */
public class TemplateTypes {
	private static Log log = Logs.get();

	private static List<TemplateType> types = new ArrayList<TemplateType>();
	private static Map<Long, TemplateType> map = new ConcurrentHashMap<Long, TemplateType>();
	private static boolean inited = false;
	
	static {
		init();
	}

	private synchronized static void init() {
		if (inited) {
			return;
		}
		log.debug("开始初始化模板类型缓存...");
		Dao dao = Daos.dao();
		List<TemplateType> templateTypes = dao.query(TemplateType.class,null);
		for (TemplateType type : templateTypes) {
			types.add(type);
			map.put(type.getId(), type);
		}
		inited = true;
		log.debug("模板类型初始化成功！");
	}
	
    public synchronized static boolean reload(){
    	types.clear();
        map.clear();
        inited = false;
        init();
        return true;
    }
    
    /**
     * 获取列表
     * @param id
     * @return
     */
	public static List<TemplateType> types() {
		return types;
	}
	
    /**
     * 获取模板名称
     * @param id
     * @return
     */
	public static String getText(String id) {
		try {
			return map.get(Long.parseLong(id)).getText();
		} catch (Exception e) {
			return id;
		}
	}
	
    /**
     * 获取模板txid
     * @param id
     * @return
     */
	public static String getTxid(String id) {
		try {
			return map.get(Long.parseLong(id)).getTxid();
		} catch (Exception e) {
			return id;
		}
	}
	
    /**
     * 获取模板对应类
     * @param id
     * @return
     */
	public static String getPath(String id) {
		try {
			return map.get(Long.parseLong(id)).getPath();
		} catch (Exception e) {
			return id;
		}
	}
    
	/**
	 * 包装模板类型项的显示
	 * 
	 * @param clazz
	 */
	public static void wrap(TemplateTypeable clazz) {
		Map<String, String> fm = clazz.getTemplateFieldMap();
		for (String key : fm.keySet()) {
			try {
				String kv = BeanUtils.getProperty(clazz, key);
				BeanUtils.setProperty(clazz, fm.get(key), getText(kv));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
