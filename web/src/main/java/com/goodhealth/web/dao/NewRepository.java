/**
 * 
 */
package com.goodhealth.web.dao;

import com.goodhealth.web.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 24663
 * @date 2019年1月10日
 * @Description
 */
public interface NewRepository  extends  JpaRepository<News, Integer>
,JpaSpecificationExecutor<News>{
	
    News   findByNewTitle(String name);

}
