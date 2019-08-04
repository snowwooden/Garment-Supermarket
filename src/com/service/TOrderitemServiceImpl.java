package com.service;
import java.util.List;
import com.pojo.TOrderitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import com.mapper.TOrderitemMapper;
@Service
public class TOrderitemServiceImpl implements TOrderitemService
{
        
        @Autowired
	private TOrderitemMapper tOrderitemMapper;


	public List<TOrderitem> queryTOrderitemList(TOrderitem tOrderitem) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(tOrderitem!=null){
			map.put("orderId", tOrderitem.getOrderId());
		}
		
		List<TOrderitem> getTOrderitem = tOrderitemMapper.query(map);
		return getTOrderitem;
	}

	public int insertTOrderitem(TOrderitem tOrderitem) throws Exception {
		
		return tOrderitemMapper.insertTOrderitem(tOrderitem);
	}

	public int deleteTOrderitem(int id) throws Exception {
		return tOrderitemMapper.deleteTOrderitem(id);
	}

	public int updateTOrderitem(TOrderitem tOrderitem) throws Exception {
		return tOrderitemMapper.updateTOrderitem(tOrderitem);
	}
	
	public TOrderitem queryTOrderitemById(int id) throws Exception {
		return tOrderitemMapper.queryTOrderitemById(id);
	}
 
}
