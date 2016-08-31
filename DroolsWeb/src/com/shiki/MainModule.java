package com.shiki;



import com.shiki.AppSetup;

import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

@Ok("json")
@Fail("json")
@SetupBy(AppSetup.class)
@Modules(scanPackage = true)
@Encoding(input = "utf8", output = "utf8")
@IocBy(type = ComboIocProvider.class, args = {"*org.nutz.ioc.loader.json.JsonLoader",
    "ioc/",
    "*org.nutz.ioc.loader.annotation.AnnotationIocLoader",
    "com.shiki"})
public class MainModule {
    @At("/")
    @Ok("->:/index")
    public void index() {

    }
}
