/**
 * 
 */
package com.goodhealth.web.service.impl;

import com.goodhealth.web.dao.OrderItemRepository;
import com.goodhealth.web.service.OrderItemService;
import com.goodhealth.web.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 24663
 * @date 2019年2月25日
 * @Description
 */
@Service
public class OrderItemServiceImp  implements OrderItemService {

	
	@Autowired
	private OrderItemRepository itemRepository;
	
	/* (non-Javadoc)
	 * @see OrderItemService#saveItem()
	 */
	@Override
	public void saveItem(OrderItem item) throws Exception {
		itemRepository.save(item);
	}
	
	

}
