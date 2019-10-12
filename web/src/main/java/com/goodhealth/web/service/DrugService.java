/**
 * 
 */
package com.goodhealth.web.service;


import com.goodhealth.web.entity.Drug;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author 24663
 * @date 2019年1月2日
 * @Description
 */
public interface DrugService {
	
	Drug findById(int id);

	List<Drug> findByCondition(String key, String value);

	List<Drug> findByProducer(String producer);

	List<Drug> findAll();

	Page<Drug> findByPage(int index);

	List<Drug> findHalfPriceDrug();

	List<Drug> findDrugListByLikeName(String name);

	void   addDrug(Drug drug);

	Drug findDrugByName(String name);

	void  deleteDrugById(int id)throws  Exception;

}
