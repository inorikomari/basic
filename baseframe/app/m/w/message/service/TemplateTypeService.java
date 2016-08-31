package m.w.message.service;

import m.w.core.service.WxIdService;
import m.w.message.domain.TemplateType;

import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(fields="dao")
public class TemplateTypeService extends WxIdService<TemplateType>{

}
