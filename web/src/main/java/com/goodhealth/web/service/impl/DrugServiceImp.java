/**
 * 
 */
package com.goodhealth.web.service.impl;


import com.goodhealth.web.dao.DrugRepository;
import com.goodhealth.web.entity.Drug;
import com.goodhealth.web.service.DrugService;
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
 * @date 2019年1月2日
 * @Description
 */
@Service
public class DrugServiceImp implements DrugService {
	
	@Autowired
	private DrugRepository drugRepository;
	

	@Override
	public  List<Drug> findByProducer(final String producer){
		Specification<Drug>  spec=new  Specification<Drug>() {
			@Override
			public Predicate toPredicate(Root<Drug> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate  pre=cb.like(root.get("drugProductor").as(String.class), "%"+producer+"%");
				return pre;
			}
		};
		return drugRepository.findAll(spec);
	}

	@Override
	@Cacheable
	public List<Drug> findAll(){
		return drugRepository.findAll();
	}

	@Override
	public Page<Drug> findByPage(int index) {
		Sort sort = new Sort(Direction.DESC,"drugId");
		Pageable pageable = new PageRequest(index,5,sort);
		return drugRepository.findAll(pageable);
	}


	/* (non-Javadoc)
	 * @see com.DrugService#findById(int)
	 */
	@Override
	public Drug findById(int id){
		Drug  drug=this.drugRepository.getOne(id);
		return drug;
	}

	@Override
	public List<Drug> findByCondition(String key, String value) {
		Sort  sort=new Sort(Direction.DESC,"drugId");
		Specification<Drug>  spec=new  Specification<Drug>() {
			@Override
			public Predicate toPredicate(Root<Drug> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate  pre=cb.like(root.get(key).as(String.class), "%"+value+"%");
				return pre;
			}
		};
		List<Drug> p= this.drugRepository.findAll(spec,sort);
		return p;
	}


	/* (non-Javadoc)
	 * @see com.DrugService#findDrugListByLikeName(java.lang.String)
	 */
	@Override
	public   List<Drug>  findDrugListByLikeName(final String name){
		Specification<Drug>  spec=new  Specification<Drug>() {
			@Override
			public Predicate toPredicate(Root<Drug> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate  pre=cb.like(root.get("drugName").as(String.class), "%"+name+"%");
				return pre;
			}
		};
		return drugRepository.findAll(spec);
	}


	/* (non-Javadoc)
	 * @see com.DrugService#findNewDrugPage(int)
	 */
	@Override
	@Cacheable
	public List<Drug> findHalfPriceDrug(){
		Sort  sort=new Sort(Direction.DESC,"drugId");
		Specification<Drug>  spec=new  Specification<Drug>() {
			@Override
			public Predicate toPredicate(Root<Drug> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate  pre=cb.equal(root.get("drugStatus"), 1);
				return pre;
			}
		};
		List<Drug> p= this.drugRepository.findAll(spec,sort);
		return p;
	}


	/* (non-Javadoc)
	 * @see com.DrugService#addDrug(com.Drug)
	 */
	@Override
	@CacheEvict
	public void addDrug(Drug drug){
		this.drugRepository.save(drug);
	}


	/* (non-Javadoc)
	 * @see com.DrugService#findDrugLikeName(java.lang.String)
	 */
	@Override
	public Drug findDrugByName(String name) {
		return   this.drugRepository.findByDrugName(name);
	}


	/* (non-Javadoc)
	 * @see com.DrugService#deleteDrugById(int)
	 */
	@Override
	@CacheEvict
	public void deleteDrugById(int id) {
		this.drugRepository.deleteById(id);
	}

}
