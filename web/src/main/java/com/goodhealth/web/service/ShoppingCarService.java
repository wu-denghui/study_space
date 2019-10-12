/**
 * 
 */
package com.goodhealth.web.service;


import com.goodhealth.web.entity.Drug;
import com.goodhealth.web.entity.Member;
import com.goodhealth.web.entity.Shoppingcar;

import java.util.List;

/**
 * @author 24663
 * @date 2019年1月3日
 * @Description
 */
public interface ShoppingCarService {
	
	
	void   addRecord(Shoppingcar record)throws Exception;

	Shoppingcar  isHas(Member member, Drug drug)throws Exception;

	List<Shoppingcar> getOnesShoppingCarList(Member member) throws Exception;

	Shoppingcar  getShoppingCarById(int id)throws Exception;

	void  deleteShoppingCar(int id)throws Exception;

}
