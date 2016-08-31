package m.w.message.domain;

import java.util.Map;

import m.w.core.service.Wrapable;
/**
 * 包含模板项的
 *
 */
public interface TemplateTypeable extends Wrapable{
	/**
     * 字典项到字典显示的映射
     * @return
     */
    public Map<String, String> getTemplateFieldMap();
	
}
