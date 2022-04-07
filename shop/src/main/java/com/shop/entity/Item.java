package com.shop.entity;

import com.shop.constant.ItemSellStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="item")
@Setter
@Getter
@ToString
public class Item {

	@Id
	@Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	// 상품 코드
	
	@Column(nullable =  false, length = 50)
	private String itemNm;	// 상품 명
	
	@Column(name = "price", nullable = false)
	private int price;	// 상품 가격
	
	@Column(nullable = false)
	private int stockNumber;	// 상품 재고 수량
	
	@Lob
	@Column(nullable = false)
	private String itemDetail;	// 상품 상세 설명
	
	@Enumerated(EnumType.STRING)
	private ItemSellStatus itemSellStatus;	// 상품 판매 상태
	
	private LocalDateTime regTime;	// 상품 정보 등록 시간
	
	private LocalDateTime updateTime;	// 상품 정보 수정 시간
}
