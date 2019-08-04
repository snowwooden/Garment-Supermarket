package com.mapper;
import com.pojo.TGoods;
import java.util.List;
import java.util.Map;
public interface TGoodsMapper
{

	public List<TGoods> findTGoodsList();
	public List<TGoods> paihang();
	public List<TGoods> query(Map<String,Object> inputParam);
	public List<TGoods> query1(Map<String,Object> inputParam);
	public int insertTGoods(TGoods tGoods);
	
	public int deleteTGoods(int id);
	
	public int updateTGoods(TGoods tGoods);
	
	public TGoods queryTGoodsById(int id);

}
