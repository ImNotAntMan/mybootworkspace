package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.domain.MemberVO;
import com.example.demo.mapper.MemberMapper;
import com.example.demo.service.MemberService;

import lombok.extern.log4j.Log4j;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private MemberService service;

	//@Test
//	void contextLoads() {
//	}
	
	//@Test
	public void testRead() {
		MemberVO member = new MemberVO();
		member.setM_id("tiger");
		member = mapper.read(member);
		System.out.println(member);
	}
	
	//@Test
	public void testRead2() {
		MemberVO member = new MemberVO();
		member.setM_id("tiger");
		member = service.read(member);
		System.out.println(member);
	}
	
	//@Test
	public void testLogin() {
		MemberVO member = new MemberVO();
		member.setM_id("tiger");
		member.setM_passwd("1234");
		member = mapper.login(member);
		System.out.println("-------mapper-----------");
		System.out.println(member);
		
	}
	
	//@Test
	public void testServiceLogin() {
		MemberVO member = new MemberVO();
		member.setM_id("tiger");
		member.setM_passwd("1234");
		member = service.login(member);
		System.out.println("---------Service---------");
		System.out.println(member);
		
	}
	
	

}
