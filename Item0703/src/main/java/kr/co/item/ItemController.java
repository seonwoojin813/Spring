package kr.co.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.item.domain.Item;
import kr.co.item.service.ItemService;

@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/allitem")
	public List<Item> allItem(){
		return itemService.allItem();
	}
	
	@RequestMapping("/getitem")
	public  Item getItem(@RequestParam("itemid") int itemid) {
		return itemService.getItem(itemid);
	}


}
