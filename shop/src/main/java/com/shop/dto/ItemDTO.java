package com.shop.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {

	private Long id;
	private String itemNm;
	private int price;
	private String itemDetail;
	private String sellStatus;
	private LocalDateTime regTime;
	private LocalDateTime updateTime;
	
}
