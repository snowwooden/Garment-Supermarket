package com.service;
import java.util.List;
import com.pojo.TCatelog;

public interface TCatelogService
{
        public List<TCatelog> queryTCatelogList(TCatelog tCatelog) throws Exception;
        
    
 
	public int insertTCatelog(TCatelog tCatelog) throws Exception ;
	
	public int deleteTCatelog(int id) throws Exception ;
	
	public int updateTCatelog(TCatelog tCatelog) throws Exception ;
	
	public TCatelog queryTCatelogById(int id) throws Exception ;

}
