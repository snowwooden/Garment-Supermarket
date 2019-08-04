package com.mapper;
import com.pojo.TOrder;
import java.util.List;
import java.util.Map;
public interface TOrderMapper
{

	public List<TOrder> findTOrderList();
	public List<TOrder> report();
	public List<TOrder> query(Map<String,Object> inputParam);
	
	public int insertTOrder(TOrder tOrder);
	
	public int deleteTOrder(String id);
	
	public int updateTOrder(TOrder tOrder);
	
	public TOrder queryTOrderById(String id);

}
