package com.service;
import java.util.List;
import com.pojo.TAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import com.mapper.TAdminMapper;
@Service
public class TAdminServiceImpl implements TAdminService
{
        
        @Autowired
	private TAdminMapper tAdminMapper;


	public List<TAdmin> queryTAdminList(TAdmin tAdmin) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(tAdmin!=null){
			map.put("username", tAdmin.getUsername());
			map.put("userpw", tAdmin.getUserpw());
		}
		
		List<TAdmin> getTAdmin = tAdminMapper.query(map);
		return getTAdmin;
	}

	public int insertTAdmin(TAdmin tAdmin) throws Exception {
		
		return tAdminMapper.insertTAdmin(tAdmin);
	}

	public int deleteTAdmin(int id) throws Exception {
		return tAdminMapper.deleteTAdmin(id);
	}

	public int updateTAdmin(TAdmin tAdmin) throws Exception {
		return tAdminMapper.updateTAdmin(tAdmin);
	}
	
	public TAdmin queryTAdminById(int id) throws Exception {
		return tAdminMapper.queryTAdminById(id);
	}
 
}
