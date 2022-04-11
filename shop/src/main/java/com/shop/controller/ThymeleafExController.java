package com.shop.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dto.ItemDTO;

@Controller
@RequestMapping(value="/thymeleaf")
public class ThymeleafExController {
	
	@GetMapping(value="/ex01")
	public String thymeleafExample01(Model model) {
		model.addAttribute("data", "타임리프 예제입니다.");
		return "thymeleafEx/thymeleafEx01";
	}

	@GetMapping(value="/ex02")
	public String thymeleafExample02(Model model) {
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItemDetail("상품상세설명");
		itemDTO.setItemNm("테스트상품01");
		itemDTO.setPrice(10000);
		itemDTO.setRegTime(LocalDateTime.now());
		
		model.addAttribute("itemDTO", itemDTO);
		return "thymeleafEx/thymeleafEx02";
	}
	
	@GetMapping(value="/ex03")
	public String thymeleafExample03(Model model) {
		List<ItemDTO> itemList = new ArrayList<>();
		
		for(int i = 1; i <= 10; i++) {
			ItemDTO itemDTO = new ItemDTO();
			itemDTO.setItemDetail("상품상세설명" + i);
			itemDTO.setItemNm("테스트상품" + i);
			itemDTO.setPrice(10000 + i);
			itemDTO.setRegTime(LocalDateTime.now());
			
			itemList.add(itemDTO);
		}
		
		model.addAttribute("itemList", itemList);
		return "thymeleafEx/thymeleafEx03";
	}
	
	@GetMapping(value="/ex07")
	public String thymeleafExample07() {
		return "thymeleafEx/thymeleafEx07";
	}
}
