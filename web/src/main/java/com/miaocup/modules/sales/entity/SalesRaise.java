/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.miaocup.modules.sales.entity;

import com.miaocup.modules.cm.entity.Coffee;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 加价购管理Entity
 * @author yangkun
 * @version 2018-03-14
 */
@Table(name="t_sales_raise", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="coffee_id", attrName="coffeeId", label="咖啡类型"),
		@Column(name="cm_model", attrName="cmModel", label="咖啡机型号"),
		@Column(name="dealer", attrName="dealer", label="经销商"),
		@Column(name="over_price", attrName="overPrice", label="满多少元"),
		@Column(name="add_price", attrName="addPrice", label="加多少元"),
		@Column(name="cups", attrName="cups", label="送多少杯"),
		@Column(name="count", attrName="count", label="数量"),
		@Column(name="start_date", attrName="startDate", label="开始时间"),
		@Column(name="end_date", attrName="endDate", label="结束时间"),
		@Column(includeEntity=DataEntity.class),
	}, joinTable={
		@JoinTable(type=Type.LEFT_JOIN, entity=Coffee.class, alias="c",
				on="c.id = a.coffee_id",
				attrName="coffee", columns={@Column(includeEntity=Coffee.class)})
	}, orderBy="a.update_date DESC"
)
public class SalesRaise extends DataEntity<SalesRaise> {
	
	private static final long serialVersionUID = 1L;
	private String coffeeId;		// 咖啡类型
	private String cmModel;		// 咖啡机型号
	private String dealer;		// 经销商
	private Double overPrice;		// 满多少元
	private Double addPrice;		// 加多少元
	private Integer cups;		// 送多少杯
	private Integer count;		// 数量
	private Date startDate;		// 开始时间
	private Date endDate;		// 结束时间
	private Coffee coffee;

	public Coffee getCoffee() {
		return coffee;
	}

	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}
	public SalesRaise() {
		this(null);
	}

	public SalesRaise(String id){
		super(id);
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
	
	public Double getOverPrice() {
		return overPrice;
	}

	public void setOverPrice(Double overPrice) {
		this.overPrice = overPrice;
	}
	
	public Double getAddPrice() {
		return addPrice;
	}

	public void setAddPrice(Double addPrice) {
		this.addPrice = addPrice;
	}
	
	public Integer getCups() {
		return cups;
	}

	public void setCups(Integer cups) {
		this.cups = cups;
	}
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
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