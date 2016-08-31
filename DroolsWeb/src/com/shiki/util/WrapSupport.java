package com.shiki.util;

import com.shiki.domain.Constable;


public abstract class WrapSupport implements Wrapable {

    @Override
    public void wrap() {
        Class<?> clazz = getClass();
        if (Clazzs.hasInterface(clazz, Constable.class)) {
            Consts.wrap((Constable)this);
        }
    }
}
