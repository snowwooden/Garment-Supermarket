package com.service;
import java.util.List;
import com.pojo.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import com.mapper.TUserMapper;
@Service
public class TUserServiceImpl implements TUserService
{
        
        @Autowired
	private TUserMapper tUserMapper;


	public List<TUser> queryTUserList(TUser tUser) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(tUser!=null){
			 map.put("id", tUser.getId());
			 map.put("loginname", tUser.getLoginname());
			 map.put("loginpw", tUser.getLoginpw());
		}
		
		List<TUser> getTUser = tUserMapper.query(map);
		return getTUser;
	}

	public int insertTUser(TUser tUser) throws Exception {
		
		return tUserMapper.insertTUser(tUser);
	}

	public int deleteTUser(String id) throws Exception {
		return tUserMapper.deleteTUser(id);
	}

	public int updateTUser(TUser tUser) throws Exception {
		return tUserMapper.updateTUser(tUser);
	}
	
	public TUser queryTUserById(String id) throws Exception {
		return tUserMapper.queryTUserById(id);
	}
 
}
