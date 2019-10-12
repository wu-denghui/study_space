package com.goodhealth.web.service.impl;

import com.goodhealth.web.entity.Member;
import com.goodhealth.web.service.MemberService;
import com.goodhealth.web.dao.MemberRepository;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author 24663
 * @date 2019年1月2日
 * @Description
 */
@Service
public class MemberServiceImp  implements MemberService {
	
	@Autowired
	private MemberRepository  memberRepository;


	/* (non-Javadoc)
	 * @see MemberService#getMemberByName(java.lang.String)
	 */
	@Override
	@Cacheable(value = "member")
	public Member getMemberByName(String name){
		return memberRepository.findByMemberName(name);
	}


	/* (non-Javadoc)
	 * @see MemberService#addMember(Member)
	 * CacheEvict 清除缓存，以保证缓存与数据库实时同步
	 */
	@Override
	@CacheEvict(value = "member")
	public void addMember(Member member){
		this.memberRepository.save(member);
	}


	/* (non-Javadoc)
	 * @see MemberService#getMemberById(int)
	 * 使用ehcache时，po类需要实现序列化，@Cacheable把方法的返回值添加到 Ehcache 中做缓存
	 */
	@Override
	@Cacheable(value = "member")
	public Member getMemberById(int id){
		// TODO Auto-generated method stub
		return this.memberRepository.getOne(id);
	}


	/* (non-Javadoc)
	 * @see MemberService#findAllByPage(int)
	 */
	@Override
	@Cacheable(value = "member")
	public Page<Member> findAllByPage(int index){
		Sort sort = new Sort(Sort.Direction.DESC,"memberId");
		Pageable   pageable= new PageRequest(index, 5,sort);
		Specification<Member>  spec=new  Specification<Member>() {
			@Override
			public Predicate toPredicate(Root<Member> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate  pre=cb.equal(root.get("memberStatus"), 0);
				return pre;
			}
		};
		Page<Member> p= this.memberRepository.findAll(spec,pageable);
		return p;
	}



	/* (non-Javadoc)
	 * @see MemberService#findListByLikeName(java.lang.String, int)
	 */
	@Override
	@Cacheable(value = "member")
	public List<Member> findListByLikeName(final String name){
		Specification<Member>  spec=new  Specification<Member>() {
			@Override
			public Predicate toPredicate(Root<Member> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate  pre=cb.like(root.get("memberName").as(String.class), "%"+name+"%");
				return pre;
			}
		};
		return memberRepository.findAll(spec);
	}

	@Override
	public void needLoginFail(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("<script> alert('请先登录'); </script>");
			out.print("<script> window.location.href=' http://localhost:8080/views/login'  </script>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

}
