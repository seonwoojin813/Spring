package kr.co.item.service;

import java.util.List;

import kr.co.item.domain.Item;

public interface ItemService {
	//전체 데이터를 가져오는 메소드
	public List<Item> allItem();
	//itemid를 이용해서 데이터 1개를 가져오는 메소드
	public Item getItem(int itemid);
	

}
