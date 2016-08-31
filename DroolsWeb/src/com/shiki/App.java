package com.shiki;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.shiki.init.Initializers;

import org.nutz.ioc.impl.PropertiesProxy;
import org.nutz.lang.Times;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;

public abstract class App {
    private static Log log = Logs.get();

    private static boolean inited = false;

    private static NutConfig cfg;
    private static Properties prop;
    
    /** 应用启动时间 */
    private static Date startupTime;

    /** 应用启动时间串 */
    private static String ver;

    /** 应用启动时间串 */
    private static String build;
    
    /** 初始化应用相关设置 */
    public static void init(NutConfig config) {
        if (inited) {
            return;
        }
        log.info("开始初始化App...");
        cfg = config;
        prop = cfg.getIoc().get(PropertiesProxy.class, "config").toProperties();

        Initializers.doInit();
        
        log.info("App初始化完毕！");
        startupTime = new Date(System.currentTimeMillis());
        ver = Times.format(new SimpleDateFormat("yyyyMMddHHmmss"), startupTime);
        build = Times.format(new SimpleDateFormat("yyyy-MM-dd"), startupTime);
        inited = true;
    }
    
    /**
     * 获取配置NutConfig信息
     * 
     * @return
     */
    public static NutConfig getConfig() {
        return cfg;
    }

    /**
     * 当前应用的根路径
     * 
     * @return
     */
    public static String getAppRoot() {
        return cfg.getAppRoot();
    }

    /**
     * 当前应用的主页
     * 
     * @return
     */
    public static String getHomepage() {
        return prop.getProperty("app.homepage", "/index");
    }
    
    /**
     * 当前应用的名称
     * 
     * @return
     */
    public static String getAppName() {
        return prop.getProperty("app.name", "MyApp");
    }

    /**
     * 是否自动创建数据库表
     * 
     * @return
     */
    public static boolean isAutoCreatTable() {
        return Boolean.parseBoolean(prop.getProperty("app.isAutoCreateTable", "false"));
    }

    /**
     * 是否强制创建数据库表
     * 
     * @return
     */
    public static boolean isForceCreatTable() {
        return Boolean.parseBoolean(prop.getProperty("app.isForceCreateTable", "false"));
    }

    /**
     * 是否开发模式
     * 
     * @return
     */
    public static boolean isDev() {
        return Boolean.parseBoolean(prop.getProperty("app.isDev", "false"));
    }
    
    
    /*
     * 当前的版本号
     */
    public static String ver(){
        return prop.getProperty("app.ver", ver);
    }
    
    public static String build(){
        return prop.getProperty("app.build", build);
    }

}
