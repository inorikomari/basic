package m.w.message.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import m.w.core.dao.IdEntity;
import m.w.sys.domain.Dictable;
import m.w.sys.util.WrapSupport;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Table("mmsg_employee")
public class Employee extends WrapSupport implements Serializable, IdEntity, Dictable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6607000575243219023L;
	

	@Override
	public Map<String, String> getDictFieldMap() {
		Map<String, String> fm = new HashMap<String, String>();
        fm.put("groups",  "groupsText");
        return fm;
	}

	@Id(auto = false)
	@Column
	private Long id;

	@Name
	@Column
	@ColDefine(type = ColType.VARCHAR, width = 18)
	private String certNo;

	@Column
	@ColDefine(type = ColType.VARCHAR, width = 30)
	private String name;

	@Column
	@ColDefine(type = ColType.VARCHAR, width = 50)
	private String groups;
	private String groupsText;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroups() {
		return groups;
	}

	public void setGroups(String groups) {
		this.groups = groups;
	}

	public String getGroupsText() {
		return groupsText;
	}

	public void setGroupsText(String groupsText) {
		this.groupsText = groupsText;
	}
}
