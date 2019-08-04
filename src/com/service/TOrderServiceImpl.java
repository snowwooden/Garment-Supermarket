package com.service;
import java.util.List;
import com.pojo.TOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import com.mapper.TOrderMapper;
@Service
public class TOrderServiceImpl implements TOrderService
{
        
        @Autowired
	private TOrderMapper tOrderMapper;


	public List<TOrder> queryTOrderList(TOrder tOrder) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(tOrder!=null){
			map.put("userId", tOrder.getUserId());
		}
		
		List<TOrder> getTOrder = tOrderMapper.query(map);
		return getTOrder;
	}
	public List<TOrder> report() throws Exception {
	 
		List<TOrder> getTOrder = tOrderMapper.report();
		return getTOrder;
	}
	

	public int insertTOrder(TOrder tOrder) throws Exception {
		
		return tOrderMapper.insertTOrder(tOrder);
	}

	public int deleteTOrder(String id) throws Exception {
		return tOrderMapper.deleteTOrder(id);
	}

	public int updateTOrder(TOrder tOrder) throws Exception {
		return tOrderMapper.updateTOrder(tOrder);
	}
	
	public TOrder queryTOrderById(String id) throws Exception {
		return tOrderMapper.queryTOrderById(id);
	}
 
}
