package com.shop.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class ItemRepositoryTest {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Test
	@DisplayName("상품 저장 테스트")
	public void createItemTest() {
		Item item = new Item();
		item.setItemNm("테스트아이템");
		item.setPrice(1000000);
		item.setItemDetail("상세설명");
		item.setItemSellStatus(ItemSellStatus.SELL);
		item.setStockNumber(100);
		item.setRegTime(LocalDateTime.now());
		item.setUpdateTime(LocalDateTime.now());
		Item savedItem = itemRepository.save(item);
		System.out.println(savedItem.toString());
	}
}