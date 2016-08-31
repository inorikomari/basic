package m.w;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.view.JspView;
import org.nutz.mvc.view.ServerRedirectView;

@IocBean
public class HomeModule extends BasicModule {
    private static final Log log = Logs.get();

    @At
    @Fail(">>:/login")
    public View index() {
        return new JspView(App.getHomepage());
    }

    @At
    @Filters
    @GET
    public View login() {
        return new JspView("/login");
    }

    @At
    @Ok(">>:/login")
    public void logout(HttpSession session) {
        SecurityUtils.getSubject().logout();
    }

    @At
    @Fail("http:404")
    @Filters
    @POST
    public View login(@Param("username") String username,
                      @Param("password") String password,
                      @Param("rememberMe") boolean rememberMe,
                      HttpServletRequest request) {
        String referer = request.getHeader("Referer");

        if (Strings.isBlank(username) || Strings.isBlank(password)) {
            err("请输入用户名与口令");
            return new JspView("/login");
        }

        attr("username", username);
        attr("rememberMe", rememberMe);

        AuthenticationToken token = new UsernamePasswordToken(username,
                                                              password,
                                                              rememberMe,
                                                              request.getRemoteHost());
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            if(!Strings.isBlank(referer) && !referer.endsWith("/login")){
                return new ServerRedirectView(referer);
            }else{
                return new ServerRedirectView("/index");
            }
        }
        catch (LockedAccountException e) {
            log.info("验证失败:" + e.getMessage());
            info("验证失败:" + e.getMessage());
            return new JspView("/login");
        }
        catch (AuthenticationException e) {
            log.info("验证失败:" + e.getMessage());
            info("验证失败");
            return new JspView("/login");
        }
        catch (Exception e) {
            log.error("登录失败", e);
            info("登录失败");
            return new JspView("/login");
        }
    }

    @At
    @Ok("jsp:/error")
    public void error() {

    }
}