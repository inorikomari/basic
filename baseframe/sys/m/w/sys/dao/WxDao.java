package m.w.sys.dao;

import org.nutz.dao.impl.NutDao;

/**
 * 对基本的增加、修改、删除记录系统日志
 * @author WenWu
 *
 */
public class WxDao extends NutDao {

    @Override
    public <T> T insert(T obj) {
        T t = super.insert(obj);
        return t;
    }

    @Override
    public int update(Object obj) {
        int cnt = super.update(obj);
        return cnt;
    }

    @Override
    public int delete(Class<?> classOfT, long id) {
        int cnt = super.delete(classOfT, id);
        return cnt;
    }

    @Override
    public int delete(Object obj) {
        int cnt = super.delete(obj);
        return cnt;
    }
    
}
