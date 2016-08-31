package com.shiki.drool.service;

import org.nutz.ioc.loader.annotation.IocBean;

import com.shiki.drool.domain.BusiModelRuleWeighted;
import com.shiki.dto.Result;
import com.shiki.util.IdService;

@IocBean(fields="dao")
public class BusiModelRuleWeightedService extends IdService<BusiModelRuleWeighted> {

	public Result savescore(String attributes, String weighteds, String modelId) {
		String[] attrs = attributes.split(",");
		String[] wts = weighteds.split(",");
		for(int i=0;i<attrs.length;i++){
			BusiModelRuleWeighted w = new BusiModelRuleWeighted();
			w.setAttribute(attrs[i]);
			w.setValues(wts[i]);
			w.setModelId(modelId);
			save(w);
		}
		return Result.ok();
	}

}
