/**
 * 
 */
package com.goodhealth.web.dao;

import com.goodhealth.web.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 24663
 * @date 2019年1月4日
 * @Description
 */
public interface OrderRepository extends  JpaRepository<Orders, String>
,JpaSpecificationExecutor<Orders>{

	Orders  findByOrderId(String id);
	
}
