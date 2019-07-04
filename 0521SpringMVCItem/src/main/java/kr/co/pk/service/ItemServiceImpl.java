package kr.co.pk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pk.dao.ItemDao;
import kr.co.pk.domain.Item;


@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDao itemDao;

	@Override
	public List<Item> allItem() {
		return itemDao.allItem();
	}

	@Override 
	public Item getItem(int itemid) { 
	return itemDao.getItem(itemid); 
	} 
	
}
