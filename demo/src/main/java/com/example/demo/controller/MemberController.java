package com.example.demo.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.MemberVO;
import com.example.demo.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;



@Controller
@RequestMapping("/member/")
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/list")
	public String getList(Model model) {
		model.addAttribute("list", service.getList());
		return "/member/list";
	}
	
	@GetMapping("/read")
	public void read(MemberVO member, Model model) {
		model.addAttribute("member", service.read(member));
	}
	
	@GetMapping("/insert")
	public void insert(MemberVO member, Model model) {
		
	}
	
	@PostMapping("/insert")
	public String insert(MemberVO member) {
		service.insert(member);
		return "redirect:/member/list";
	}
	
	@GetMapping("/update")
	public void update(MemberVO member, Model model) {
		member =  service.read(member);
		model.addAttribute("member", member);
	}
	
	@PostMapping("/update")
	public String update(MemberVO member) {
		service.update(member);
		return "redirect:/member/read?m_id=" + member.getM_id();
	}
	
	@GetMapping("/delete")
	public String delete(MemberVO member) {
		service.delete(member);
		return "redirect:/member/list";
	}
	
	@GetMapping("/login")
	public void login() {

	}
	
	@PostMapping("/login")
	@ResponseBody
	public MemberVO loginChk(HttpServletRequest request, MemberVO member) {
		String m_id = request.getParameter("m_id");
		String m_passwd = request.getParameter("m_passwd");
		MemberVO tmp = new MemberVO();
		tmp.setM_id(m_id);
		tmp.setM_passwd(m_passwd);
		member = service.login(tmp);
		System.out.println(member);
		if(member.getM_id().equals(m_id)) {
			return member;
		} else {
			return null;
		}
	}
	
	@GetMapping("/ajax")
	public void ajax() {
		System.out.println("ajax ??????!");
	} 
	
	static int cnt=0; // ?????? ?????? ??????
	
	@PostMapping("/ajax")
	@ResponseBody	// ????????? ????????????. ????????? jsp??? ?????? ????????? ????????? ??????.
	public String ajaxResult() {
		System.out.println("ajax ??????!" + cnt);
		return ++cnt+"??????!";//????????? ???????????? 
	}
	
	@GetMapping("/ajaxsearch")
	public void ajaxsearch() {
		System.out.println("ajax ??????!");
	} 
	
	@PostMapping("/ajaxsearch")
	@ResponseBody	// ????????? ????????????. ????????? jsp??? ?????? ????????? ????????? ??????.
	public MemberVO ajaxResult(HttpServletRequest request) { //????????? member ????????? vo??? ????????? ????????????
		String m_id = request.getParameter("m_id");
		MemberVO member = new MemberVO();
		member.setM_id(m_id);
		member = service.read(member);
		System.out.println(member);
		System.out.println("ajax ??????!" + cnt++);
		return member; 
	}
	
}
