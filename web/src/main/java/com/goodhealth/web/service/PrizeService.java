/**
 * 
 */
package com.goodhealth.web.service;

import com.goodhealth.web.entity.Prize;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author 24663
 * @date 2019年1月8日
 * @Description
 */
public interface PrizeService {
	
	  List<Prize> findAll();

	  Page<Prize>  findByPage(int index);

	 void   addPrize(Prize prize);
	 
	 void  deletePrizeById(int id);
	 
	 Prize  findById(int id);
	 
	 List<Prize> findPrizeByNameLike(String name);

}
