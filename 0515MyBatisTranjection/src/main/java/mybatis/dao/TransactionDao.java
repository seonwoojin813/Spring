package mybatis.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TransactionDao {
	@Autowired
	private SimpleJdbcInsert template;

	@Transactional
	public void insert() {
		template.withTableName("goods");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 5000);
	    map.put("name", "	beer");
	    map.put("manufacture", "독일");
	    map.put("price", 5000);
	    
	    template.execute(map);
	}
}
