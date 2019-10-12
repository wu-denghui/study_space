/**
 * 
 */
package com.goodhealth.web.dao;

import com.goodhealth.web.entity.Shoppingcar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 24663
 * @date 2019年1月3日
 * @Description
 */
public interface ShoppingCarRepository extends JpaRepository<Shoppingcar, Integer> 
,JpaSpecificationExecutor<Shoppingcar>{

	
	
}
