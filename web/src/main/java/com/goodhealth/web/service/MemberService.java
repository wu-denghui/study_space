/**
 * 
 */
package com.goodhealth.web.service;

import com.goodhealth.web.entity.Member;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 24663
 * @date 2019年1月2日
 * @Description
 */
public interface MemberService {

	void needLoginFail(HttpServletRequest request, HttpServletResponse response);

	Member getMemberByName(String name);

	void  addMember(Member member);

	Member getMemberById(int id);
	
	Page<Member>   findAllByPage(int index);
	
	List<Member> findListByLikeName(String name);
}
