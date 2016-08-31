package m.w;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import m.w.init.Initializers;
import m.w.sys.util.Users;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.nutz.ioc.impl.PropertiesProxy;
import org.nutz.lang.Streams;
import org.nutz.lang.Strings;
import org.nutz.lang.Times;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;
import org.quartz.Scheduler;

public abstract class App {
    private static Log log = Logs.get();

    private static boolean inited = false;

    private static NutConfig cfg;
    private static Properties prop;
    private static Properties up = new Properties();
    
    /** 应用启动时间 */
    private static Date startupTime;

    /** 应用启动时间串 */
    private static String ver;

    /** 应用启动时间串 */
    private static String build;
    
    private static final String SALT = "Wx.root.2014";
    private static final String SHA1 = "SHA-1";
    private static final String UP = "up.properties";
    private static final String RT = "rt";
    private static final String ROOT = "root";
    
    static Scheduler scheduler = null;
    
    public static Scheduler getScheduler(){
        return scheduler;
    }

    /** 初始化应用相关设置 */
    public static void init(NutConfig config) {
        if (inited) {
            return;
        }
        log.info("开始初始化App...");
        cfg = config;
        prop = cfg.getIoc().get(PropertiesProxy.class, "config").toProperties();
        try {
            up.load(Streams.fileIn(UP));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Initializers.doInit();
        
//        flowables = Clazzs.findImplements(Const.BASE_PACKAGE, Flowable.class);

        log.info("App初始化完毕！");
        startupTime = new Date(System.currentTimeMillis());
        ver = Times.format(new SimpleDateFormat("yyyyMMddHHmmss"), startupTime);
        build = Times.format(new SimpleDateFormat("yyyy-MM-dd"), startupTime);
        inited = true;
    }
    
    public static boolean isRootAccount(String name){
        return ROOT.equals(name);
    }
    
    public static boolean isMatchRoot(String name, String password){
        if(ROOT.equals(name) && !Strings.isBlank(password)){
            return new SimpleHash(SHA1, password, SALT).toString().equals(up.getProperty(RT));
        }
        return false;
    }
    
    public static boolean resetRoot(String oldPassword, String newPassword){
        if(!isMatchRoot(ROOT, oldPassword)){
            return false;
        }
        up.setProperty(RT, new SimpleHash(SHA1, newPassword, SALT).toString());
        try {
            up.store(Streams.fileOut(UP), "");
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean isRoot(){
        return ROOT.equals(Users.user().getUsername());
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
     * 没有用户时候默认管理员的登录名
     * 
     * @return
     */
    public static String getAdminName() {
        return prop.getProperty("app.admin.name", "admin");
    }

    /**
     * 没有用户时候默认管理员的口令
     * 
     * @return
     */
    public static String getAdminPassword() {
        return prop.getProperty("app.admin.password", "admin");
    }
    
    
    /**
     * 获取配置了的法定节假日
     * @return
     */
    public static String getHolidays() {
        return prop.getProperty("app.quartz.holidays");
    }
    
    public static String getWorkdays() {
        return prop.getProperty("app.quartz.workdays");
    }
    
    /**
     * 获取工作时间的上午开始时间
     * @return
     */
    public static String getAmBegin() {
        return prop.getProperty("app.quartz.am.begin", "08:00");
    }
    
    /**
     * 获取工作时间的上午结束，默认为12:00
     * @return
     */
    public static String getAmEnd() {
        return prop.getProperty("app.quartz.am.end", "12:00");
    }
    
    /**
     * 获取工作时间的下午开始时间，默认为14:00
     * @return
     */
    public static String getPmBegin() {
        return prop.getProperty("app.quartz.pm.begin", "14:00");
    }

    /**
     * 获取工作时间的下午结束时间，默认为18:00
     * @return
     */
    public static String getPmEnd() {
        return prop.getProperty("app.quartz.pm.end", "18:00");
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
    
    /**
     * 是否允许执行quartz的调度任务
     * @return
     */
    public static boolean isEnableScheduler() {
        return Boolean.parseBoolean(prop.getProperty("app.isEnableScheduler", "false"));
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
