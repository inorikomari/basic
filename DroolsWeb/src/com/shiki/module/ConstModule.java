package com.shiki.module;


import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;

import com.shiki.BasicModule;
import com.shiki.util.Consts;

@At("/sys/const")
@IocBean
public class ConstModule extends BasicModule {
    @At
    public void reload(){
        Consts.reload();
    }
    
    @At("/options/?/?")
    public Object options(String clazz, String fild){
        return Consts.options(clazz+"."+fild);
    }
}
