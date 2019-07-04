package kr.co.pk.service;

import java.util.List;

import kr.co.pk.domain.Item;

public interface ItemService {
    //테이블의 전체 데이터를 가져오는 메소드
	public List<Item> allItem();
	//테이블에서 데이터 1개를 찾아오는 메소드
	public Item getItem(int itemid);
	
}
