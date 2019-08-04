package com.mapper;
import com.pojo.TCatelog;
import java.util.List;
import java.util.Map;
public interface TCatelogMapper
{

	public List<TCatelog> findTCatelogList();
	
	public List<TCatelog> query(Map<String,Object> inputParam);
 
	public int insertTCatelog(TCatelog tCatelog);
	
	public int deleteTCatelog(int id);
	
	public int updateTCatelog(TCatelog tCatelog);
	
	public TCatelog queryTCatelogById(int id);

}
