package m.w.sys.domain;

import java.io.Serializable;
import java.util.Date;

import m.w.core.dao.IdEntity;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.SQL;
import org.nutz.dao.entity.annotation.Table;

@Table("Sys_Log")
public class SysLog implements Serializable, IdEntity{
    private static final long serialVersionUID = 693393492614433361L;
    
    public SysLog(){
        
    }
    
    public SysLog(Long id, Date onTime, Long userId, String userName,
			String msg, String ip, String companyName, String companyCode, 
			String departmentName, Long departmentId, String action) {
		super();
		this.id = id;
		this.onTime = onTime;
		this.userId = userId;
		this.userName = userName;
		this.msg = msg;
		this.ip = ip;
		this.companyName = companyName;
		this.companyCode = companyCode;
		this.departmentName = departmentName;
		this.departmentId = departmentId;
		this.action = action;
	}
    

	/** 插入 */
    public static final String ACTION_INSERT = "insert";
    /** 更新 */
    public static final String ACTION_UPDATE = "update";
    /** 删除 */
    public static final String ACTION_DELETE = "delete";
    /** 其它 */
    public static final String ACTION_OTHER = "other";
    /** 审批 */
    public static final String ACTION_AUDIT = "audit";
    
    // =========================================================================
    // 数据库字段
    // =========================================================================

    @Id(auto=false)
    @Column
    @Prev(@SQL("select seq_syslog.nextval from dual"))
    private Long id;

    @Column
    @ColDefine(notNull = true, type = ColType.DATE)
    private Date onTime;

    @Column
    @ColDefine(notNull = true, width = 50)
    private String action;
    
    @Column
    @ColDefine(notNull = true, type = ColType.INT, width = 16, precision = 0)
    private Long userId;

    @Column
    @ColDefine(notNull = true, width = 50)
    private String userName;

    @Column
    @ColDefine(type = ColType.VARCHAR, width = 4000)
    private String msg;
    
    @Column
    @ColDefine(notNull = true, width = 50)
    private String ip;
    
    @Column
    @ColDefine(notNull = true, width = 50)
    private String companyName;
    
    @Column
    @ColDefine(notNull = true, width = 50)
    private String companyCode;
    
    @Column
	@ColDefine(notNull = true, type = ColType.VARCHAR, width = 200)
	private String departmentName;

    @Column
	private Long departmentId;
    

    // =========================================================================
    // 生成方法
    // =========================================================================
    @Override
    public Long getId() {
        return id;
    }

    public Date getOnTime() {
        return onTime;
    }

    public void setOnTime(Date onTime) {
        this.onTime = onTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}


}
