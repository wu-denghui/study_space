/**
 * 
 */
package com.goodhealth.web.service.impl;


import com.goodhealth.web.dao.OrderRepository;
import com.goodhealth.web.entity.Member;
import com.goodhealth.web.entity.Orders;
import com.goodhealth.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author 24663
 * @date 2019年1月4日
 * @Description
 */
@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	/* (non-Javadoc)
	 * @see OrderService#addOrder()
	 */
	@Override
	@CacheEvict
	public void addOrder(Orders order){
		this.orderRepository.save(order);
	}

	/* (non-Javadoc)
	 * @see OrderService#findOnesOrder(Member)
	 */
	@Override
	public List< Orders> findOnesOrder(Integer  memberId){
		Sort sort=new Sort(Direction.DESC, "orderId");
		Specification< Orders>  spec=new Specification<Orders>() {
			@Override
			public Predicate toPredicate(Root<Orders> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate pre=cb.and(cb.equal(root.get("orderStatus"), 1),cb.equal(root.get("memberId"), memberId));
				return pre;
			}
		};
		List< Orders> page=this.orderRepository.findAll(spec,sort);
		return  page ;
	}

	@Override
	@Cacheable
	public Page<Orders> findByPage(Integer index) {
		Sort sort=new Sort(Direction.DESC, "orderDate");
		Pageable pageable = new PageRequest(index,10,sort);
		Specification< Orders>  spec=new Specification<Orders>() {
			@Override
			public Predicate toPredicate(Root<Orders> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate pre=cb.equal(root.get("orderStatus"), 1);
				return pre;
			}
		};
		return orderRepository.findAll(spec,pageable);
	}

	@Override
	public List<Orders> findOnesUnpaidOrder(Member member) {
		Sort sort=new Sort(Direction.DESC, "orderId");
		Specification< Orders>  spec=new Specification<Orders>() {
			@Override
			public Predicate toPredicate(Root<Orders> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate pre=cb.and(cb.equal(root.get("orderStatus"), 0),cb.equal(root.get("memberId"), member.getMemberId()));
				return pre;
			}
		};
		List< Orders> page=this.orderRepository.findAll(spec,sort);
		return  page;
	}

	/* (non-Javadoc)
	 * @see OrderService#findOrderById(int)
	 */
	@Override
	public Orders findOrderById(String id){
		Orders  orders=this.orderRepository.findByOrderId(id);
		return orders;
	}

	@Override
	public Page<Orders> findByMember(Member member,int index) {
		Sort sort=new Sort(Direction.DESC, "orderId");
		Pageable pageable = new PageRequest(index,10,sort);
		Specification< Orders>  spec=new Specification<Orders>() {
			@Override
			public Predicate toPredicate(Root<Orders> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate pre=cb.and(cb.equal(root.get("orderStatus"), 1),cb.equal(root.get("memberId"), member.getMemberId()));
				return pre;
			}
		};
		return orderRepository.findAll(spec,pageable);
	}

	/* (non-Javadoc)
	 * @see OrderService#findOnesCompletedOrder(Member, int)
	 */
	@Override
	public Page<Orders> findOnesCompletedOrder(final Member member, int index){
		Sort sort=new Sort(Direction.DESC, "orderId");
		Pageable pageable=new PageRequest(index, 6,sort);
		Specification< Orders>  spec=new Specification<Orders>() {
			@Override
			public Predicate toPredicate(Root<Orders> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate pre=cb.and(cb.equal(root.get("orderStatus"), 1),cb.equal(root.get("memberId"), member.getMemberId()));
				return pre;
			}
		};
		Page< Orders> page=this.orderRepository.findAll(spec,pageable);
		return  page ;
	}
}
