package com.shiki.drool.domain;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.shiki.util.IdEntity;

@Table("BUSI_MODEL_RULE")
public class BusiModelRule implements IdEntity, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3135828294705946513L;
	
	@Id
	@Column("I_RECORDID")
    @Comment("记录编号")
	private Long id;
	
	@Column("C_MODELID")
	@Comment("模型编号")
	@Name
	@ColDefine(notNull = true, type = ColType.VARCHAR, width = 20)
	private String modelId;
	
	@Column("C_RULECONTENT")
	@Comment("模板内容")
	@ColDefine(type = ColType.VARCHAR, width = 1024)
	private String content;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
