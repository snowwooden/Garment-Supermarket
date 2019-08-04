package com.service;
import java.util.List;
import com.pojo.TOrder;

public interface TOrderService
{
        public List<TOrder> queryTOrderList(TOrder tOrder) throws Exception;
 
	public int insertTOrder(TOrder tOrder) throws Exception ;
	
	public int deleteTOrder(String id) throws Exception ;
	
	public int updateTOrder(TOrder tOrder) throws Exception ;
	
	public TOrder queryTOrderById(String id) throws Exception ;
	 public List<TOrder> report() throws Exception;
}
