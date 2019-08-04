package com.service;
import java.util.List;
import com.pojo.TOrderitem;

public interface TOrderitemService
{
        public List<TOrderitem> queryTOrderitemList(TOrderitem tOrderitem) throws Exception;
 
	public int insertTOrderitem(TOrderitem tOrderitem) throws Exception ;
	
	public int deleteTOrderitem(int id) throws Exception ;
	
	public int updateTOrderitem(TOrderitem tOrderitem) throws Exception ;
	
	public TOrderitem queryTOrderitemById(int id) throws Exception ;

}
