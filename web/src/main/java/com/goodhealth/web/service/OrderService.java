/**
 * 
 */
package com.goodhealth.web.service;

import com.goodhealth.web.entity.Orders;
import com.goodhealth.web.entity.Member;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author 24663
 * @date 2019年1月4日
 * @Description
 */
public interface OrderService {
  
	  void   addOrder(Orders order)throws Exception;

	  List< Orders> findOnesOrder(Integer memberId);

	  Page<Orders> findByPage(Integer index);

	  List< Orders> findOnesUnpaidOrder(Member member);

	  Page< Orders> findOnesCompletedOrder(Member member, int index);

	  Orders  findOrderById(String id);

	  Page<Orders> findByMember(Member member, int index);
	
}
