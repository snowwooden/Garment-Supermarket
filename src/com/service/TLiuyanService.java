package com.service;
import java.util.List;
import com.pojo.TLiuyan;

public interface TLiuyanService
{
        public List<TLiuyan> queryTLiuyanList(TLiuyan tLiuyan) throws Exception;
 
	public int insertTLiuyan(TLiuyan tLiuyan) throws Exception ;
	
	public int deleteTLiuyan(String id) throws Exception ;
	
	public int updateTLiuyan(TLiuyan tLiuyan) throws Exception ;
	
	public TLiuyan queryTLiuyanById(String id) throws Exception ;

}
