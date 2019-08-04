package com.service;
import java.util.List;
import com.pojo.Pinglun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import com.mapper.PinglunMapper;
@Service
public class PinglunServiceImpl implements PinglunService
{
        
        @Autowired
	private PinglunMapper pinglunMapper;


	public List<Pinglun> queryPinglunList(Pinglun pinglun) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(pinglun!=null){
			map.put("gid", pinglun.getGid());
		}
		
		List<Pinglun> getPinglun = pinglunMapper.query(map);
		return getPinglun;
	}
	public List<Pinglun> queryWz(Pinglun pinglun) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(pinglun!=null){
			map.put("gid", pinglun.getGid());
		}
		List<Pinglun> getPinglun = pinglunMapper.queryWz(map);
		return getPinglun;
	}
	
	

	public int insertPinglun(Pinglun pinglun) throws Exception {
		
		return pinglunMapper.insertPinglun(pinglun);
	}

	public int deletePinglun(int id) throws Exception {
		return pinglunMapper.deletePinglun(id);
	}

	public int updatePinglun(Pinglun pinglun) throws Exception {
		return pinglunMapper.updatePinglun(pinglun);
	}
	
	public Pinglun queryPinglunById(int id) throws Exception {
		return pinglunMapper.queryPinglunById(id);
	}
 
}
