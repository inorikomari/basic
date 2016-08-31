package m.w.init.impl;

import m.w.init.Initializer;
import m.w.sys.domain.User;

import org.nutz.dao.Dao;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.Mvcs;

public class UserInitializer implements Initializer {
    private static Log log = Logs.get();

    @Override
    public void init() {
        log.debug("开始初始化用户...");
        Dao dao = Mvcs.getIoc().get(Dao.class);
        int count = dao.count(User.class);
        if (count == 0) {
            User admin = new User();
            admin.setUsername("sxjh");
            admin.setPassword("sxjh1234");
            admin.setAdmin(true);
            admin.setEnable(true);
            dao.insert(admin);
        }
        log.debug("用户初始化成功！");
    }

    @Override
    public String[] dependence() {
//        return new String[]{OrgInitializer.class.getName()};
    	return null;
    }

}
