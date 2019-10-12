/**
 * 
 */
package com.goodhealth.web.service.impl;

import com.goodhealth.web.dao.NewRepository;
import com.goodhealth.web.entity.News;
import com.goodhealth.web.service.NewsService;
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
 * @date 2019年1月10日
 * @Description
 */
@Service
public class NewsServiceImp implements NewsService {
		
		@Autowired
		private NewRepository newRepository;
		
		@Override
		public  List<News> findAll(){
			Sort  sort =new  Sort(Direction.DESC, "newId");
			List<News> p= newRepository.findAll(sort);
			return p;
		}

		@Override
		@Cacheable
		public Page<News> findByPage(Integer index) {
			Sort  sort =new  Sort(Direction.DESC, "newId");
			Pageable pageable = new PageRequest(index,5,sort);
			return newRepository.findAll(pageable);
		}

		@Override
		public List<News> findByLikeCondition(String key, String value) {
			Sort  sort =new  Sort(Direction.DESC, "newId");
			Specification<News>  spec=new  Specification<News>() {
				@Override
				public Predicate toPredicate(Root<News> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					Predicate  pre=cb.like(root.get(key).as(String.class), "%"+value+"%");
					return pre;
				}
			};
			return newRepository.findAll(spec,sort);
		}

		/* (non-Javadoc)
		 * @see NewsService#addNews(News)
		 */
		@Override
		@CacheEvict
		public void addNews(News news){
			this.newRepository.save(news);
			
		}



		/* (non-Javadoc)
		 * @see NewsService#deleteNewsById(int)
		 */
		@Override
		public void deleteNewsById(int id){
			this.newRepository.deleteById(id);
		}



		/* (non-Javadoc)
		 * @see NewsService#findNewsByName(java.lang.String)
		 */
		@Override
		public News findNewsByName(String name){
			return this.newRepository.findByNewTitle(name);
		}



		/* (non-Javadoc)
		 * @see NewsService#findById(int)
		 */
		@Override
		@Cacheable
		public News findById(int id){
			// TODO Auto-generated method stub
			return   this.newRepository.getOne(id);
		}
}
