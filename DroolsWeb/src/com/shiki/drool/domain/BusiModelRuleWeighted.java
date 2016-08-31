package com.shiki.drool.domain;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Default;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.shiki.util.IdEntity;

@Table("BUSI_MODEL_RULEWEIGHTED")
public class BusiModelRuleWeighted implements IdEntity, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 242063060304570462L;

	@Id
	@Column("I_RECORDID")
    @Comment("记录编号")
	private Long id;
	
	@Column("C_MODELID")
	@Comment("模型编号")
	@ColDefine(notNull = true, type = ColType.VARCHAR, width = 20)
	private String modelId;
	
	@Column("C_RULEID")
	@Comment("规则编号")
	@ColDefine(notNull = true, type = ColType.VARCHAR, width = 20)
	private String ruleId;
	
	@Column("C_CONDITIONID")
	@Comment("条件编号")
	@ColDefine(notNull = true, type = ColType.VARCHAR, width = 20)
	private String conditionId;
	
	@Column("C_CONDITIONTYPE")
	@Comment("条件标识")
	@Default("when")
	@ColDefine(notNull = true, type = ColType.VARCHAR, width = 20)
	private String conditionType;

	@Column("C_RELATION")
	@Comment("条件之间关系")
	@ColDefine(type = ColType.VARCHAR, width = 10)
	private String relation;
	
	@Column("C_ATTRIBUTE")
	@Comment("模型属性字段")
	@ColDefine(notNull = true, type = ColType.VARCHAR, width = 50)
	private String attribute;
	
	@Column("C_EXPRESSION")
	@Comment("条件表达式")
	@ColDefine( type = ColType.VARCHAR, width = 10)
	private String expression;

	@Column("C_VALUES")
	@Comment("条件判断值")
	@ColDefine(notNull = true, type = ColType.VARCHAR, width = 10)
	private String values;
	
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

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getConditionId() {
		return conditionId;
	}

	public void setConditionId(String conditionId) {
		this.conditionId = conditionId;
	}

	public String getConditionType() {
		return conditionType;
	}

	public void setConditionType(String conditionType) {
		this.conditionType = conditionType;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
	}

}
