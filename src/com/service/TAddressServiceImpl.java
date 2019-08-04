package com.service;
import java.util.List;
import com.pojo.TAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import com.mapper.TAddressMapper;
@Service
public class TAddressServiceImpl implements TAddressService
{
        
        @Autowired
	private TAddressMapper tAddressMapper;


	public List<TAddress> queryTAddressList(TAddress tAddress) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(tAddress!=null){
			 map.put("uid", tAddress.getUid());
		}
		
		List<TAddress> getTAddress = tAddressMapper.query(map);
		return getTAddress;
	}

	public int insertTAddress(TAddress tAddress) throws Exception {
		
		return tAddressMapper.insertTAddress(tAddress);
	}

	public int deleteTAddress(int id) throws Exception {
		return tAddressMapper.deleteTAddress(id);
	}

	public int updateTAddress(TAddress tAddress) throws Exception {
		return tAddressMapper.updateTAddress(tAddress);
	}
	
	public TAddress queryTAddressById(int id) throws Exception {
		return tAddressMapper.queryTAddressById(id);
	}
 
}
