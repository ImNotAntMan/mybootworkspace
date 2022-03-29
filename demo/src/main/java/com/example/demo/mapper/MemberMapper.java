package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.MemberVO;

@Mapper
public interface MemberMapper {
	
	public List<MemberVO> getList();
	
	public MemberVO read(MemberVO member);
	
	public void insert(MemberVO member);
	
	public void update(MemberVO member);
	
	public void delete(MemberVO member);
	
	public MemberVO login(MemberVO member);
}
