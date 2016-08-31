package com.shiki.drool.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;

import com.shiki.drool.domain.BusiModelAttr;
import com.shiki.dto.Result;
import com.shiki.util.IdService;

/**
 * BusiModelAttr
 *
 */
@IocBean(fields="dao")
public class BusiModelAttrService extends IdService<BusiModelAttr>{

	public Result delFields(String mid, String fieldIds) {
		List<BusiModelAttr> list = this.query(Cnd.where("modelId","=",mid).and("attribute","IN",fieldIds), null);
		for(BusiModelAttr attr:list)
			this.delete(attr.getId());
        return Result.ok("删除字段成功！");
	}

	public Result addFields(String mid, String fieldIds) {
		List<BusiModelAttr> list = this.query(Cnd.where("modelId","=",mid), null);
		if(null == list){
			list = new ArrayList<BusiModelAttr>();
        }
        Set<String> old = new HashSet<String>();
        for(BusiModelAttr b : list){
            old.add(b.getAttribute());
        }
        for(String rid : Strings.splitIgnoreBlank(fieldIds, ",")){
            if(!old.contains(rid)){
            	BusiModelAttr attr = new BusiModelAttr();
            	attr.setModelId(mid);
            	attr.setAttribute(rid);
            	this.insert(attr);
            }
        }
		return Result.ok("添加字段成功！");
	}

}
