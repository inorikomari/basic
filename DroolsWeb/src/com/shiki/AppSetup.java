package com.shiki;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

public class AppSetup implements Setup {
    private static Log log = Logs.get();

    @Override
    public void init(NutConfig config) {
        log.info("开始初始化AppSetup...");
        App.init(config);

        ConvertUtils.register(new DateConverter(null), java.util.Date.class);

        log.info("AppSetup初始化完毕！");
    }

    @Override
    public void destroy(NutConfig config) {
        log.info("开始销毁AppSetup...");
        log.info("AppSetup销毁完毕！");
    }

}
