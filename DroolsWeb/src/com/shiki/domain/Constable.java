package com.shiki.domain;

import java.util.Map;

import com.shiki.util.Wrapable;


public interface Constable extends Wrapable{
    /**
     * 常量项到常量显示的映射
     * @return
     */
    public Map<String, String> getConstFieldMap();
}
