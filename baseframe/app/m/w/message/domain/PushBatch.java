package m.w.message.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Default;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.SQL;
import org.nutz.dao.entity.annotation.Table;

import m.w.core.dao.IdEntity;
import m.w.sys.domain.Constable;
import m.w.sys.util.WrapSupport;

@Table("mmsg_push_batch")
public class PushBatch extends WrapSupport implements Serializable, IdEntity, Constable, TemplateTypeable, Employeeable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1536059258859395057L;

	@Override
	public Map<String, String> getConstFieldMap() {
		Map<String, String> fm = new HashMap<String, String>();
        fm.put("status",     "statusText");
        fm.put("control",     "controlText");
        fm.put("priority",     "priorityText");
        return fm;
	}
	
	@Override
	public Map<String, String> getTemplateFieldMap() {
		Map<String, String> fm = new HashMap<String, String>();
        fm.put("type",     "typeText");
        return fm;
	}
	
	@Override
	public Map<String, String> getEmployeeFieldMap() {
		Map<String, String> fm = new HashMap<String, String>();
        fm.put("groups",  "groupsText");
        return fm;
	}
	
	public PushBatch(){}

    public PushBatch(Long id) {
        this.id = id;
    }
    
    @Id(auto=false)
    @Column
    @Prev(@SQL("select seq_pbash.nextval from dual"))
    private Long id;
    
    /**
     * 标题
     */
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 50)
    private String title;
    
    /**
     * 模板类型
     */
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 10)
    private String type;
    private String typeText;
    
    /**
     * 接收方
     */
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 4000)
    private String groups;
    private String groupsText;
    
    /**
     * 消息内容-正文
     */
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 2000)
    private String msgContent;
    
    /**
     * 消息内容-
     */
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 2000)
    private String msgTime;
    
    /**
     * 消息内容-
     */
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 2000)
    private String msgLocation;
    
    /**
     * 消息内容-
     */
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 2000)
    private String msgAddress;
    
    /**
     * 消息内容-备注
     */
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 2000)
    private String msgRemark;
    
    /**
     * 消息内容-
     */
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 2000)
    private String msgField1;
    
    /**
     * 消息内容-
     */
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 2000)
    private String msgField2;
    
    /**
     * 消息内容-
     */
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 2000)
    private String msgField3;
    
    /**
     * 消息内容-
     */
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 2000)
    private String msgField4;
    
    /**
     * 消息内容-
     */
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 2000)
    private String msgField5;
    
    /**
     * 消息内容-
     */
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 2000)
    private String msgField6;
    
    /**
     * 状态
     * 0:已登记 
     * 1:待处理 
     * 2:已处理
     */
    @Column
    @ColDefine(type = ColType.INT)
    private Integer status;
    private String statusText;
    
    /**
     * 控制标志
     * 0:有效 
     * 1:无效
     */
    @Column
    @ColDefine(type = ColType.INT)
    @Default("0")
    private Integer control;
    private String controlText;
    
    /**
     * 优先级
     * 0:高
     * 5:普通
     * 9:低
     */
    @Column
    @ColDefine(type = ColType.INT)
    private Integer priority;
    private String priorityText;
    
    /**
     * 总条数
     */
    @Column
    @ColDefine(type = ColType.INT)
    @Default("0")
    private Integer count;
    
    /**
     * 备注
     */
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 2000)
    private String describe;
    
    /**
     * 录入人
     */
    @Column
    @Comment("录入人")
    @ColDefine(type = ColType.VARCHAR, width = 50)
    private String inputName;
    
    /**
     * 录入日期
     */
    @Column
    @Comment("录入日期")
    @ColDefine(type = ColType.DATE)
    private Date onTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public String getControlText() {
		return controlText;
	}

	public void setControlText(String controlText) {
		this.controlText = controlText;
	}

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public Date getOnTime() {
		return onTime;
	}

	public void setOnTime(Date onTime) {
		this.onTime = onTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public String getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(String msgTime) {
		this.msgTime = msgTime;
	}

	public String getMsgLocation() {
		return msgLocation;
	}

	public void setMsgLocation(String msgLocation) {
		this.msgLocation = msgLocation;
	}

	public String getMsgAddress() {
		return msgAddress;
	}

	public void setMsgAddress(String msgAddress) {
		this.msgAddress = msgAddress;
	}

	public String getMsgRemark() {
		return msgRemark;
	}

	public void setMsgRemark(String msgRemark) {
		this.msgRemark = msgRemark;
	}

	public String getMsgField1() {
		return msgField1;
	}

	public void setMsgField1(String msgField1) {
		this.msgField1 = msgField1;
	}

	public String getMsgField2() {
		return msgField2;
	}

	public void setMsgField2(String msgField2) {
		this.msgField2 = msgField2;
	}

	public String getMsgField3() {
		return msgField3;
	}

	public void setMsgField3(String msgField3) {
		this.msgField3 = msgField3;
	}

	public String getMsgField4() {
		return msgField4;
	}

	public void setMsgField4(String msgField4) {
		this.msgField4 = msgField4;
	}

	public String getMsgField5() {
		return msgField5;
	}

	public void setMsgField5(String msgField5) {
		this.msgField5 = msgField5;
	}

	public String getMsgField6() {
		return msgField6;
	}

	public void setMsgField6(String msgField6) {
		this.msgField6 = msgField6;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getControl() {
		return control;
	}

	public void setControl(Integer control) {
		this.control = control;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getPriorityText() {
		return priorityText;
	}

	public void setPriorityText(String priorityText) {
		this.priorityText = priorityText;
	}

	public String getTypeText() {
		return typeText;
	}

	public void setTypeText(String typeText) {
		this.typeText = typeText;
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
