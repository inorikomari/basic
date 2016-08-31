package m.w.message.domain;

import java.util.Map;

import m.w.core.service.Wrapable;

public interface Employeeable extends Wrapable{
	
	public Map<String, String> getEmployeeFieldMap();

}
