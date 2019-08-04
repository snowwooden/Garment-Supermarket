package com.service;
import java.util.List;
import com.pojo.TUser;

public interface TUserService
{
        public List<TUser> queryTUserList(TUser tUser) throws Exception;
 
	public int insertTUser(TUser tUser) throws Exception ;
	
	public int deleteTUser(String id) throws Exception ;
	
	public int updateTUser(TUser tUser) throws Exception ;
	
	public TUser queryTUserById(String id) throws Exception ;

}
