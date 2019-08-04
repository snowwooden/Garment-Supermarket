package com.mapper;
import com.pojo.TLiuyan;
import java.util.List;
import java.util.Map;
public interface TLiuyanMapper
{

	public List<TLiuyan> findTLiuyanList();
	
	public List<TLiuyan> query(Map<String,Object> inputParam);
	
	public int insertTLiuyan(TLiuyan tLiuyan);
	
	public int deleteTLiuyan(String id);
	
	public int updateTLiuyan(TLiuyan tLiuyan);
	
	public TLiuyan queryTLiuyanById(String id);

}
