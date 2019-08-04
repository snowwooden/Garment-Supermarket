package com.service;
import java.util.List;
import com.pojo.Wenzhang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import com.mapper.WenzhangMapper;
@Service
public class WenzhangServiceImpl implements WenzhangService
{
        
        @Autowired
	private WenzhangMapper wenzhangMapper;


	public List<Wenzhang> queryWenzhangList(Wenzhang wenzhang) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(wenzhang!=null){
			map.put("zhiding", wenzhang.getZhiding());
			map.put("uid", wenzhang.getUid());
			map.put("state", wenzhang.getState());
		}
		
		List<Wenzhang> getWenzhang = wenzhangMapper.query(map);
		return getWenzhang;
	}

	public int insertWenzhang(Wenzhang wenzhang) throws Exception {
		
		return wenzhangMapper.insertWenzhang(wenzhang);
	}

	public int deleteWenzhang(int id) throws Exception {
		return wenzhangMapper.deleteWenzhang(id);
	}

	public int updateWenzhang(Wenzhang wenzhang) throws Exception {
		return wenzhangMapper.updateWenzhang(wenzhang);
	}
	
	public Wenzhang queryWenzhangById(int id) throws Exception {
		return wenzhangMapper.queryWenzhangById(id);
	}
 
}
