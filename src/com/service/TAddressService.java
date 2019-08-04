package com.service;
import java.util.List;
import com.pojo.TAddress;

public interface TAddressService
{
        public List<TAddress> queryTAddressList(TAddress tAddress) throws Exception;
 
	public int insertTAddress(TAddress tAddress) throws Exception ;
	
	public int deleteTAddress(int id) throws Exception ;
	
	public int updateTAddress(TAddress tAddress) throws Exception ;
	
	public TAddress queryTAddressById(int id) throws Exception ;

}
