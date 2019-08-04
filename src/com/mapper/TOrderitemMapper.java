package com.mapper;
import com.pojo.TOrderitem;
import java.util.List;
import java.util.Map;
public interface TOrderitemMapper
{

	public List<TOrderitem> findTOrderitemList();
	
	public List<TOrderitem> query(Map<String,Object> inputParam);
	
	public int insertTOrderitem(TOrderitem tOrderitem);
	
	public int deleteTOrderitem(int id);
	
	public int updateTOrderitem(TOrderitem tOrderitem);
	
	public TOrderitem queryTOrderitemById(int id);

}
