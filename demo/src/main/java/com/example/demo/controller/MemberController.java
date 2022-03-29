package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
