package com.service;
import java.util.List;
import com.pojo.TCatelog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import com.mapper.TCatelogMapper;
@Service
public class TCatelogServiceImpl implements TCatelogService
{
        
        @Autowired
	private TCatelogMapper tCatelogMapper;


	public List<TCatelog> queryTCatelogList(TCatelog tCatelog) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(tCatelog!=null){
			map.put("fid", tCatelog.getFid());
		}
		
		List<TCatelog> getTCatelog = tCatelogMapper.query(map);
		return getTCatelog;
	}
 
	public int insertTCatelog(TCatelog tCatelog) throws Exception {
		
		return tCatelogMapper.insertTCatelog(tCatelog);
	}

	public int deleteTCatelog(int id) throws Exception {
		return tCatelogMapper.deleteTCatelog(id);
	}

	public int updateTCatelog(TCatelog tCatelog) throws Exception {
		return tCatelogMapper.updateTCatelog(tCatelog);
	}
	
	public TCatelog queryTCatelogById(int id) throws Exception {
		return tCatelogMapper.queryTCatelogById(id);
	}
 
}
