package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.MemberVO;
import com.example.demo.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public List<MemberVO> getList() {
		return mapper.getList();
	}
	
	@Override
	public MemberVO read(MemberVO member) {
		return mapper.read(member);
	}
	
	@Override
	public void insert(MemberVO member) {
		mapper.insert(member);
	}
	
	@Override
	public void update(MemberVO member) {
		mapper.update(member);
	}
	
	@Override
	public void delete(MemberVO member) {
		mapper.delete(member);
	}
	
	@Override
	public MemberVO login(MemberVO member) {
		return mapper.login(member);
	}
}
