package com.shiki.drool.service;

import org.nutz.ioc.loader.annotation.IocBean;

import com.shiki.drool.domain.BusiModel;
import com.shiki.util.IdService;

/**
 * BusiModel
 *
 */
@IocBean(fields="dao")
public class BusiModelService extends IdService<BusiModel>{

}
