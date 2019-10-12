/**
 * 
 */
package com.goodhealth.web.service;

import com.goodhealth.web.entity.News;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author 24663
 * @date 2019年1月10日
 * @Description
 */
public interface NewsService {
	
	List<News> findAll();

	Page<News> findByPage(Integer index);

	List<News> findByLikeCondition(String key, String value);

	void addNews(News news);
	
	void deleteNewsById(int id);
	
	News findById(int id);
	
	News findNewsByName(String name);

}
