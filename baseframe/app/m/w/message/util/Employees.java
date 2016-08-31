package m.w.message.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import m.w.core.dto.tree.Tree;
import m.w.core.dto.tree.TreeItem;
import m.w.core.util.Daos;
import m.w.message.domain.Employee;
import m.w.message.domain.Employeeable;
import m.w.sys.domain.DictItem;
import m.w.sys.util.Dicts;

import org.apache.commons.beanutils.BeanUtils;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;

public class Employees {
	private static Dao dao = Daos.dao();
	
	private static Tree tree;
    private static Map<String, Employee> map = new ConcurrentHashMap<String, Employee>();
    private static boolean inited = false;
    private static Map<String, String> code2Name = new HashMap<String, String>();
    private static Map<String, String> code2CertNo = new HashMap<String, String>();
    
    static{
        init();
    }
    
    private static void init() {
    	if (inited) {
            return;
        }
    	
    	List<Employee> es = dao.query(Employee.class, null);
    	String ids = "";
        tree = new Tree();
        for(Employee e : es){
        	ids+=e.getGroups()+",";
        	map.put(e.getId().toString(), e);
        	code2Name.put(e.getId().toString(), e.getName());
        	code2CertNo.put(e.getId().toString(), e.getCertNo());
        	TreeItem i = new TreeItem(e.getId().toString(), e.getName()+"[*"+e.getCertNo().substring(e.getCertNo().length()-4,e.getCertNo().length())+"]", "DEPT-"+e.getGroups());
        	i.addAttr("type", "employee");
        	i.open();
        	tree.addItem(i);
        }
        List<DictItem> items = dao.query(DictItem.class, Cnd.where("id","IN",ids.subSequence(0, ids.length()-1)));
        for (DictItem d : items) {
        	TreeItem i = new TreeItem("DEPT-"+d.getId(), d.getText());
        	i.addAttr("type", "dept");
            tree.addItem(i);
        }
        tree.build();
        inited = true;
    }
    
    public synchronized static boolean reload(){
        map.clear();
        inited = false;
        init();
        return true;
    }
    
    public synchronized static Tree tree() {
    	init();
        return tree;
    }
    
    public static String getText(String id){
        return code2Name.get(id);
    }
    
    public static String getCertNo(String id){
        return code2CertNo.get(id);
    }
    
    public static void wrap(Employeeable clazz){
        Map<String, String> fm = clazz.getEmployeeFieldMap();
        for(String fild : fm.keySet()){
            try {
                String value = BeanUtils.getProperty(clazz, fild);
                String[] keys = value.split(",");
				String txt = "";
				for(String s:keys){
					if(s.startsWith("DEPT-")){
						s = s.substring(5);
						txt+=Dicts.getText(s)+":";
					}else{
						if(null!=getText(s))
							txt+=getText(s)+"[*"+getCertNo(s).substring(getCertNo(s).length()-4,getCertNo(s).length())+"]"+",";
						else
							txt+=s+",";
					}
				}
				BeanUtils.setProperty(clazz, fm.get(fild), txt.substring(0, txt.lastIndexOf(",")));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
