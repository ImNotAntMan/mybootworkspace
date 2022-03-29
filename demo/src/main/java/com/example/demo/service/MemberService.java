package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.MemberVO;

public interface MemberService {

	public List<MemberVO> getList();
	
	public MemberVO read(MemberVO member);
	
	public void update(MemberVO member);
	
	public void delete(MemberVO member);

	public void insert(MemberVO member);
	
	public MemberVO login(MemberVO member);
}
