package com.mapper;
 
import java.util.List;
import java.util.Map;

import com.pojo.Pinglun;
public interface PinglunMapper
{

	public List<Pinglun> findPinglunList();
	
	public List<Pinglun> query(Map<String,Object> inputParam);
	public List<Pinglun> queryWz(Map<String,Object> inputParam);
	
	public int insertPinglun(Pinglun pinglun);
	
	public int deletePinglun(int id);
	
	public int updatePinglun(Pinglun pinglun);
	
	public Pinglun queryPinglunById(int id);

}
