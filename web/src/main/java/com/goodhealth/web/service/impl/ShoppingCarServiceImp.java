/**
 * 
 */
package com.goodhealth.web.service.impl;


import com.goodhealth.web.dao.ShoppingCarRepository;
import com.goodhealth.web.entity.Drug;
import com.goodhealth.web.entity.Member;
import com.goodhealth.web.entity.Shoppingcar;
import com.goodhealth.web.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
 * @date 2019年1月3日
 * @Description
 */
@Service
public class ShoppingCarServiceImp implements ShoppingCarService {
	
	@Autowired
     private   ShoppingCarRepository   shoppingCarRepository;
	
	/* (non-Javadoc)
	 * @see ShoppingCarService#addRecord(Shoppingcar)
	 */
	@Override
	@CacheEvict(value = "shoppingCar")
	public void addRecord(Shoppingcar record) throws Exception {
		this.shoppingCarRepository.save(record);
	}

	/* (non-Javadoc)
	 * @see ShoppingCarService#isHas(int, int)
	 */
	@Override
	public Shoppingcar isHas(final Member member, final Drug drug) throws Exception {
		Specification<Shoppingcar>  spec=new Specification<Shoppingcar>(){
			@Override
			public Predicate toPredicate(Root<Shoppingcar> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate  pre=cb.and(cb.equal(root.get("member"), member),cb.equal(root.get("drug"), drug));
				return pre;
			}
		};
		List<Shoppingcar> record=this.shoppingCarRepository.findAll(spec);
		return record.size()>0 ? record.get(0):null;
	}

	/* (non-Javadoc)
	 * @see ShoppingCarService#getOnesShoppingCarList(Member)
	 */
	@Override
	@Cacheable(value = "shoppingCar")
	public List<Shoppingcar> getOnesShoppingCarList(final Member member) throws Exception {
		Sort sort=new Sort(Direction.DESC, "recordId");
		Specification<Shoppingcar> spec=new  Specification<Shoppingcar>() {
			@Override
			public Predicate toPredicate(Root<Shoppingcar> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return  cb.equal(root.get("member"), member);
			}
		};
		List<Shoppingcar> list = this.shoppingCarRepository.findAll(spec,sort);
		return list;
	}

	/* (non-Javadoc)
	 * @see ShoppingCarService#getShoppingCarById(int)
	 */
	@Override
	public Shoppingcar getShoppingCarById(int id) throws Exception {
		Shoppingcar  record=this.shoppingCarRepository.getOne(id);
		return record;
	}

	/* (non-Javadoc)
	 * @see ShoppingCarService#deleteShoppingCar(int)
	 */
	@Override
	public void deleteShoppingCar(int id) throws Exception {
		this.shoppingCarRepository.deleteById(id);
	}

}
