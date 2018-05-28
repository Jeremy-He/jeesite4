/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.miaocup.modules.sales.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.miaocup.modules.sales.entity.SalesRaise;

/**
 * 加价购管理DAO接口
 * @author yangkun
 * @version 2018-03-14
 */
@MyBatisDao
public interface SalesRaiseDao extends CrudDao<SalesRaise> {
	
}