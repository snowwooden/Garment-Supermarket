package com.mapper;
import com.pojo.TUser;
import java.util.List;
import java.util.Map;
public interface TUserMapper
{

	public List<TUser> findTUserList();
	
	public List<TUser> query(Map<String,Object> inputParam);
	
	public int insertTUser(TUser tUser);
	
	public int deleteTUser(String id);
	
	public int updateTUser(TUser tUser);
	
	public TUser queryTUserById(String id);

}
