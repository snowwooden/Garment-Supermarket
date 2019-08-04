package com.service;
import java.util.List;
import com.pojo.TGoods;

public interface TGoodsService
{
    public List<TGoods> queryTGoodsList(TGoods tGoods) throws Exception;
    public List<TGoods> queryTGoodsList1(TGoods tGoods) throws Exception;
    public List<TGoods> paihang() throws Exception;
	public int insertTGoods(TGoods tGoods) throws Exception ;
	
	public int deleteTGoods(int id) throws Exception ;
	
	public int updateTGoods(TGoods tGoods) throws Exception ;
	
	public TGoods queryTGoodsById(int id) throws Exception ;

}
