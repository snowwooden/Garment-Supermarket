package com.service;
import java.util.List;
import com.pojo.TLiuyan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import com.mapper.TLiuyanMapper;
@Service
public class TLiuyanServiceImpl implements TLiuyanService
{
        
        @Autowired
	private TLiuyanMapper tLiuyanMapper;


	public List<TLiuyan> queryTLiuyanList(TLiuyan tLiuyan) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(tLiuyan!=null){
			 
		}
		
		List<TLiuyan> getTLiuyan = tLiuyanMapper.query(map);
		return getTLiuyan;
	}

	public int insertTLiuyan(TLiuyan tLiuyan) throws Exception {
		
		return tLiuyanMapper.insertTLiuyan(tLiuyan);
	}

	public int deleteTLiuyan(String id) throws Exception {
		return tLiuyanMapper.deleteTLiuyan(id);
	}

	public int updateTLiuyan(TLiuyan tLiuyan) throws Exception {
		return tLiuyanMapper.updateTLiuyan(tLiuyan);
	}
	
	public TLiuyan queryTLiuyanById(String id) throws Exception {
		return tLiuyanMapper.queryTLiuyanById(id);
	}
 
}
