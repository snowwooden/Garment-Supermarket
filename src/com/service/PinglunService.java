package com.service;
import java.util.List;
import com.pojo.Pinglun;

public interface PinglunService
{
        public List<Pinglun> queryPinglunList(Pinglun pinglun) throws Exception;
        public List<Pinglun> queryWz(Pinglun pinglun) throws Exception;
        
	public int insertPinglun(Pinglun pinglun) throws Exception ;
	
	public int deletePinglun(int id) throws Exception ;
	
	public int updatePinglun(Pinglun pinglun) throws Exception ;
	
	public Pinglun queryPinglunById(int id) throws Exception ;

}
