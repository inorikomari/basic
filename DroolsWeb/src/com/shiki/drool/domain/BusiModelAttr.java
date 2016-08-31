package com.shiki.drool.domain;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.shiki.util.IdEntity;

@Table("BUSI_MODEL_ATTR")
public class BusiModelAttr implements IdEntity, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8747450041387361434L;
	
	@Id
	@Column("I_RECORDID")
    @Comment("记录编号")
	private Long id;
	
	@Column("C_MODELID")
	@Comment("模型编号")
	@ColDefine(notNull = true, type = ColType.VARCHAR, width = 20)
	private String modelId;
	
	@Column("C_ATTRIBUTE")
	@Comment("字段名称")
	@ColDefine(notNull = true, type = ColType.VARCHAR, width = 20)
	private String attribute;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
}
