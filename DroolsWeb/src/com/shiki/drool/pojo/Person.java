package com.shiki.drool.pojo;

import java.io.Serializable;

import com.shiki.annotation.DroolFields;
import com.shiki.annotation.DroolTables;

/**
 * 示例持卡客户评分计算
 * Person对象
 * 
 * */
@DroolTables(pojo="Person",describ="客户评分信息")
public class Person implements Serializable {

    //持卡客户年龄
	@DroolFields(column="age", describ="年龄", dict=true)
	private int age;
	
	//持卡客户年交易金额
	@DroolFields(column="tradeAmt", describ="年交易金额", dict=true)
	private double tradeAmt;
	
	//持卡客户学历
	@DroolFields(column="education", describ="学历", dict=true, url="/education")
	private String education;
	
	//持卡客户学历
	@DroolFields(column="avgDeposit", describ="年日均", dict=true)
	private double avgDeposit;
	
	//持卡客户评分计算
	@DroolFields(column = "score", describ="评分", isgrade=true, getMethod="getScore", setMethod="setScore")
	private double score = 0;

	public double getAvgDeposit() {
		return avgDeposit;
	}

	public void setAvgDeposit(double avgDeposit) {
		this.avgDeposit = avgDeposit;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getTradeAmt() {
		return tradeAmt;
	}

	public void setTradeAmt(double tradeAmt) {
		this.tradeAmt = tradeAmt;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}
	
	//学历常量定义
	public static final String UNDERGRADUATE_COURSE = "本科";
	public static final String POSTGRADUATE = "研究生";
	public static final String HIGH_SCHOOL = "高中生";
	
	private static final long serialVersionUID = 7494883482498337998L;
}
