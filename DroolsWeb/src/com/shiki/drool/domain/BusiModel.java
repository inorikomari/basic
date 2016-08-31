package com.shiki.drool.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Default;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.shiki.domain.Constable;
import com.shiki.util.IdEntity;
import com.shiki.util.WrapSupport;

@Table("Busi_Model")
public class BusiModel extends WrapSupport implements IdEntity, Serializable, Constable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8596300222750011808L;
	
	@Override
	public Map<String, String> getConstFieldMap() {
        Map<String, String> fm = new HashMap<String, String>();
        fm.put("controlsType",  "controlsTypeText");
        fm.put("datatype", "datatypeText");
        fm.put("fieldType", "fieldTypeText");
        return fm;
	}
	
	@Id
	@Column("I_RECORDID")
	@Comment("记录编号")
	private Long id;
	
	@Column("C_ATTRIBUTE")
	@Comment("字段名称")
	@Name
	@ColDefine(notNull = true, type = ColType.VARCHAR, width = 20)
	private String attribute;
	
	@Column("C_DESCRIB")
	@Comment("字段中文名称")
	@ColDefine(notNull = true, type = ColType.VARCHAR, width = 50)
	private String describ;
	
	@Column("C_DATATYPE")
	@Comment("字段数据类型")
	@ColDefine(notNull = true, type = ColType.VARCHAR, width = 10)
	private String datatype;
	private String datatypeText;
	
	@Column("C_CONTROLSTYPE")
	@Comment("字段控件类型")
	@ColDefine(notNull = true, type = ColType.VARCHAR, width = 30)
	private String controlsType;
	private String controlsTypeText;
	
	@Column("C_CONTROLSCONTENT")
	@Comment("字段控件内容")
	@ColDefine(notNull = true, type = ColType.VARCHAR, width = 200)
	private String controlsContent;
	
	/**
	 * 是否条件字段
	 * 01:条件
	 * 02:得分
	 * 03:其他
	 */
	@Column("C_FIELDTYPE")
	@Comment("字段类型")
	@Default("01")
	@ColDefine(notNull = true, type = ColType.VARCHAR, width = 2)
	private String fieldType;
	private String fieldTypeText;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getDescrib() {
		return describ;
	}

	public void setDescrib(String describ) {
		this.describ = describ;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public String getControlsType() {
		return controlsType;
	}

	public void setControlsType(String controlsType) {
		this.controlsType = controlsType;
	}

	public String getControlsContent() {
		return controlsContent;
	}

	public void setControlsContent(String controlsContent) {
		this.controlsContent = controlsContent;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldTypeText() {
		return fieldTypeText;
	}

	public void setFieldTypeText(String fieldTypeText) {
		this.fieldTypeText = fieldTypeText;
	}

	public String getDatatypeText() {
		return datatypeText;
	}

	public void setDatatypeText(String datatypeText) {
		this.datatypeText = datatypeText;
	}

	public String getControlsTypeText() {
		return controlsTypeText;
	}

	public void setControlsTypeText(String controlsTypeText) {
		this.controlsTypeText = controlsTypeText;
	}

}
