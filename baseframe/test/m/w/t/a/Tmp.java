package m.w.t.a;

import m.w.sys.shiro.ShiroDbRealm;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

public class Tmp {
    public static void main(String[] args) {
        DefaultWebSecurityManager sm = new DefaultWebSecurityManager();
        DefaultWebSubjectFactory subjectFactory = new DefaultWebSubjectFactory();
        sm.setSubjectFactory(subjectFactory);
        
        Authenticator authenticator = null;
        
        sm.setAuthenticator(authenticator); 
        Authorizer authorizer = null;
        sm.setAuthorizer(authorizer);
        
        RememberMeManager rememberMeManager = new CookieRememberMeManager();

        sm.setRememberMeManager(rememberMeManager);
        
        EnterpriseCacheSessionDAO sessionDAO = new EnterpriseCacheSessionDAO();

        DefaultWebSessionManager wsm = new DefaultWebSessionManager();
        wsm.setSessionDAO(sessionDAO);

        ShiroDbRealm realm = new ShiroDbRealm();
        CredentialsMatcher credentialsMatcher = new CredentialsMatcher() {
            @Override
            public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
                Object principal = info.getPrincipals().iterator().next();
                return false;
            }
        };
        realm.setCredentialsMatcher(credentialsMatcher);

    }

}
