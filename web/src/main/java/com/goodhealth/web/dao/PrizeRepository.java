/**
 * 
 */
package com.goodhealth.web.dao;

import com.goodhealth.web.entity.Prize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 24663
 * @date 2019年1月8日
 * @Description
 */
public interface PrizeRepository extends  JpaSpecificationExecutor<Prize> 
,JpaRepository<Prize, Integer>{

	Prize  findByPrizeName(String name);
	
}
