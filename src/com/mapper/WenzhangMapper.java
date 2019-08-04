package com.mapper;
import java.util.List;
import java.util.Map;

import com.pojo.Wenzhang;
public interface WenzhangMapper
{

	public List<Wenzhang> findWenzhangList();
	
	public List<Wenzhang> query(Map<String,Object> inputParam);
	
	public int insertWenzhang(Wenzhang wenzhang);
	
	public int deleteWenzhang(int id);
	
	public int updateWenzhang(Wenzhang wenzhang);
	
	public Wenzhang queryWenzhangById(int id);

}
