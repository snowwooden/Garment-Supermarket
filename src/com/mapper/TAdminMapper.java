package com.mapper;
import com.pojo.TAdmin;
import java.util.List;
import java.util.Map;
public interface TAdminMapper
{

	public List<TAdmin> findTAdminList();
	
	public List<TAdmin> query(Map<String,Object> inputParam);
	
	public int insertTAdmin(TAdmin tAdmin);
	
	public int deleteTAdmin(int id);
	
	public int updateTAdmin(TAdmin tAdmin);
	
	public TAdmin queryTAdminById(int id);

}
