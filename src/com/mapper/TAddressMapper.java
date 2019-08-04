package com.mapper;
import com.pojo.TAddress;
import java.util.List;
import java.util.Map;
public interface TAddressMapper
{

	public List<TAddress> findTAddressList();
	
	public List<TAddress> query(Map<String,Object> inputParam);
	
	public int insertTAddress(TAddress tAddress);
	
	public int deleteTAddress(int id);
	
	public int updateTAddress(TAddress tAddress);
	
	public TAddress queryTAddressById(int id);

}
