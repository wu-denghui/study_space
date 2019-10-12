package com.goodhealth.web.controller;


import com.goodhealth.web.entity.Member;
import com.goodhealth.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.goodhealth.comm.util.StringUtil;
import com.goodhealth.comm.util.encrypt.DESUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Objects;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model, String name, String password) {
        String error = null;
        Member member = null;
        model.addAttribute("name", name);
        model.addAttribute("password", password);
        if (!StringUtil.isNotNullString(name) && !StringUtil.isNotNullString(password)) {
            error = "账号密码不能为空";
            model.addAttribute("error", error);
            return "Display/login";
        }
        try {
            member = memberService.getMemberByName(name);
            if (Objects.isNull(member)) {
                error = "无效用户";
                model.addAttribute("error", error);
                return "Display/login";
            }
            if (password .equals(DESUtils.decode(member.getMemberPassword()))){
                HttpSession session = request.getSession();
                session.setAttribute("member", member);
                return "redirect:/goodhealth/index.jsp";
            } else {
                error = "密码错误，请重新输入";
                model.addAttribute("error", error);
                return "Display/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Display/login";
    }

    @RequestMapping("/adminLogin")
    public String mangerLogin(HttpServletRequest request, Model model,String name, String password) {
        String error = null;
        Member member = null;
        model.addAttribute("name", name);
        model.addAttribute("password", password);
        if (!StringUtil.isNotNullString(name) && !StringUtil.isNotNullString(password)) {
            error = "账号密码不能为空";
            model.addAttribute("error", error);
            return "Manger/login";
        }
        try {
            member = memberService.getMemberByName(name);
            if (Objects.isNull(member) || (Objects.nonNull(member) && 0 == member.getMemberStatus())) {
                error = "无效用户";
                model.addAttribute("error", error);
                return "Manger/login";
            }
            if (password.equals(DESUtils.decode(member.getMemberPassword()))) {
                HttpSession session = request.getSession(true);
                session.setAttribute("member", member);
                return "Manger/frame";
            } else {
                error = "密码错误，请重新输入";
                model.addAttribute("error", error);
                return "Manger/login";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Manger/login";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request, HttpServletResponse response, Model model,
                            Member member) {
        System.out.println(member);
        Member user = null;
        try {
            user=memberService.getMemberByName(member.getMemberName());
            if (Objects.nonNull(user)) {
                model.addAttribute("member", member);
                model.addAttribute("duplicateName", "该用户名已经被注册");
                return "Display/register";
            }
            String pass = member.getMemberPassword();
            String repas = request.getParameter("password2");
            System.out.println(repas);
            if (!pass.equals(member.getPassword2())){
                model.addAttribute("member", member);
                model.addAttribute("duplicateName", "前后密码不一致");
                return "Display/register";
            }
            member.setMemberPassword(DESUtils.encode(pass));
            member.setMemberStatus(0);
            memberService.addMember(member);
            HttpSession session = request.getSession(true);
            session.setAttribute("member", member);
            success(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return"redirect:/goodhealth/index.jsp";

    }

    @RequestMapping("/logout")
    public String exit(HttpSession session) {
        // 清除session
        session.invalidate();
        // 重定向到首页
        return "redirect:/goodhealth/index.jsp";
    }

    @RequestMapping("/adminLogout")
    public String adminExit(HttpSession session) {
        // 清除session
        session.invalidate();
        // 重定向到首页
        return "redirect:/login/adminLogin";
    }

    public void success(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print("<script> alert('注册成功,您已成功登录'); </script>");
            out.print("<script> window.location.href=' http://localhost:8080/goodhealth/index.jsp'  </script>");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
        }
    }
}
