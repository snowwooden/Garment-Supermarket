package com.service;
import java.util.List;
import com.pojo.TAdmin;

public interface TAdminService
{
        public List<TAdmin> queryTAdminList(TAdmin tAdmin) throws Exception;
 
	public int insertTAdmin(TAdmin tAdmin) throws Exception ;
	
	public int deleteTAdmin(int id) throws Exception ;
	
	public int updateTAdmin(TAdmin tAdmin) throws Exception ;
	
	public TAdmin queryTAdminById(int id) throws Exception ;

}
