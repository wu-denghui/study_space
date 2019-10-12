/**
 * 
 */
package com.goodhealth.web.service.impl;

import com.goodhealth.web.dao.PrizeRepository;
import com.goodhealth.web.entity.Prize;
import com.goodhealth.web.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author 24663
 * @date 2019年1月8日
 * @Description
 */
@Service
public class PrizeServiceImp implements PrizeService {

	@Autowired
	private PrizeRepository prizeRepository;
	

	@Override
	public List<Prize> findAll() {
		return prizeRepository.findAll();
	}



/*	*//* (non-Javadoc)
	 * @see PrizeService#findListByLikeName(java.lang.String, int)
	 *//*
	@Override
	public Page<Prize> findListByLikeName(final String name, int index){
		Pageable   pageable= new PageRequest(index, 10);
		Specification<Prize>  spec=new  Specification<Prize>() {
			@Override
			public Predicate toPredicate(Root<Prize> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate  pre=cb.like(root.get("prizeName").as(String.class), "%"+name+"%");
				return pre;
			}
		};
		Page<Prize>  list=this.prizeRepository.findAll(spec,pageable);
		return list;
	}*/

	@Override
	@Cacheable
	public Page<Prize> findByPage(int index) {
		Sort sort = new Sort(Sort.Direction.DESC,"prizeId");
		Pageable pageable = new PageRequest(index,5,sort);
		return prizeRepository.findAll(pageable);
	}


	/* (non-Javadoc)
	 * @see PrizeService#addPrize(Prize)
	 */
	@Override
	@CacheEvict
	public void addPrize(Prize prize){
		this.prizeRepository.save(prize);
	}



	/* (non-Javadoc)
	 * @see PrizeService#deletePrizeById(int)
	 */
	@Override
	@CacheEvict
	public void deletePrizeById(int id){
		this.prizeRepository.deleteById(id);
	}



	/* (non-Javadoc)
	 * @see PrizeService#findPrizeByName(java.lang.String)
	 */
	@Override
	public List<Prize> findPrizeByNameLike(String name){
		Specification<Prize>  spec=new  Specification<Prize>() {
			@Override
			public Predicate toPredicate(Root<Prize> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate  pre=cb.like(root.get("prizeName").as(String.class), "%"+name+"%");
				return pre;
			}
		};
		return prizeRepository.findAll(spec);
	}



	/* (non-Javadoc)
	 * @see PrizeService#findById(int)
	 */
	@Override
	public Prize findById(int id){
		// TODO Auto-generated method stub
		return this.prizeRepository.getOne(id);
	}

	
}
