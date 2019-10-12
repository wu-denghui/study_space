/**
 * 
 */
package com.goodhealth.web.dao;

import com.goodhealth.web.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 24663
 * @date 2019年2月25日
 * @Description
 */
public interface OrderItemRepository   extends  JpaRepository<OrderItem, String>,
JpaSpecificationExecutor<OrderItem>{
	

}
