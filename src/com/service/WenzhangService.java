package com.service;
import java.util.List;
import com.pojo.Wenzhang;

public interface WenzhangService
{
        public List<Wenzhang> queryWenzhangList(Wenzhang wenzhang) throws Exception;
 
	public int insertWenzhang(Wenzhang wenzhang) throws Exception ;
	
	public int deleteWenzhang(int id) throws Exception ;
	
	public int updateWenzhang(Wenzhang wenzhang) throws Exception ;
	
	public Wenzhang queryWenzhangById(int id) throws Exception ;

}
