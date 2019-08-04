package com.service;
import java.util.List;
import com.pojo.TGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import com.mapper.TGoodsMapper;
@Service
public class TGoodsServiceImpl implements TGoodsService
{
        
        @Autowired
	private TGoodsMapper tGoodsMapper;


	public List<TGoods> queryTGoodsList(TGoods tGoods) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(tGoods!=null){
			map.put("catelogId", tGoods.getCatelogId());
			map.put("mingcheng", tGoods.getMingcheng());
			map.put("sorts", tGoods.getSorts());
		}
		
		List<TGoods> getTGoods = tGoodsMapper.query(map);
		return getTGoods;
	}
	
	public List<TGoods> queryTGoodsList1(TGoods tGoods) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(tGoods!=null){
			map.put("catelogId", tGoods.getCatelogId());
			map.put("mingcheng", tGoods.getMingcheng());
			map.put("sorts", tGoods.getSorts());
		}
		List<TGoods> getTGoods = tGoodsMapper.query1(map);
		return getTGoods;
	}
	public List<TGoods> paihang() throws Exception {
		 
		List<TGoods> getTGoods = tGoodsMapper.paihang();
		return getTGoods;
	}
	public int insertTGoods(TGoods tGoods) throws Exception {
		
		return tGoodsMapper.insertTGoods(tGoods);
	}

	public int deleteTGoods(int id) throws Exception {
		return tGoodsMapper.deleteTGoods(id);
	}

	public int updateTGoods(TGoods tGoods) throws Exception {
		return tGoodsMapper.updateTGoods(tGoods);
	}
	
	public TGoods queryTGoodsById(int id) throws Exception {
		return tGoodsMapper.queryTGoodsById(id);
	}
 
}
