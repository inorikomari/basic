package m.w.sys.util;

import m.w.core.service.Wrapable;
import m.w.core.util.Clazzs;
import m.w.message.domain.Employeeable;
import m.w.message.domain.TemplateTypeable;
import m.w.message.util.Employees;
import m.w.message.util.TemplateTypes;
import m.w.sys.domain.Constable;
import m.w.sys.domain.Dictable;

public abstract class WrapSupport implements Wrapable {

    @Override
    public void wrap() {
        Class<?> clazz = getClass();
        if (Clazzs.hasInterface(clazz, Dictable.class)) {
            Dicts.wrap((Dictable)this);
        }
        if (Clazzs.hasInterface(clazz, Constable.class)) {
            Consts.wrap((Constable)this);
        }
        if (Clazzs.hasInterface(clazz, TemplateTypeable.class)) {
        	TemplateTypes.wrap((TemplateTypeable)this);
        }
        if (Clazzs.hasInterface(clazz, Employeeable.class)) {
        	Employees.wrap((Employeeable)this);
        }
    }
}
