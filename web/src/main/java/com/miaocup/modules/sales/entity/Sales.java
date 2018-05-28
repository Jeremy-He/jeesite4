/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.miaocup.modules.sales.entity;

import com.miaocup.modules.cm.entity.Coffee;
import com.miaocup.modules.cm.entity.Place;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;

/**
 * 限时促销配置Entity
 * @author yangkun
 * @version 2018-03-14
 */
@Table(name="t_sales", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="coffee_id", attrName="coffeeId", label="咖啡类型"),
		@Column(name="cm_model", attrName="cmModel", label="咖啡机型号"),
		@Column(name="dealer", attrName="dealer", label="经销商"),
		@Column(name="price", attrName="price", label="价格"),
		@Column(name="start_date", attrName="startDate", label="开始时间"),
		@Column(name="end_date", attrName="endDate", label="结束时间"),
		@Column(includeEntity=DataEntity.class),
	}, joinTable={
		@JoinTable(type=Type.LEFT_JOIN, entity=Coffee.class, alias="c",
				on="c.id = a.coffee_id",
				attrName="coffee", columns={@Column(includeEntity=Coffee.class)})
	}, orderBy="a.update_date DESC"
)
public class Sales extends DataEntity<Sales> {
	
	private static final long serialVersionUID = 1L;
	private String coffeeId;		// 咖啡类型
	private String cmModel;		// 咖啡机型号
	private String dealer;		// 经销商
	private Double price;		// 价格
	private Date startDate;		// 开始时间
	private Date endDate;		// 结束时间
	private Coffee coffee;

	public Coffee getCoffee() {
		return coffee;
	}

	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}
	@Length(min=0, max=64, message="咖啡类型长度不能超过 64 个字符")
	public String getCoffeeId() {
		return coffeeId;
	}

	public void setCoffeeId(String coffeeId) {
		this.coffeeId = coffeeId;
	}
	
	@Length(min=0, max=64, message="咖啡机型号长度不能超过 64 个字符")
	public String getCmModel() {
		return cmModel;
	}

	public void setCmModel(String cmModel) {
		this.cmModel = cmModel;
	}
	
	@Length(min=0, max=64, message="经销商长度不能超过 64 个字符")
	public String getDealer() {
		return dealer;
	}

	public void setDealer(String dealer) {
		this.dealer = dealer;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}