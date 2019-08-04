package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.TCatelog;
import com.pojo.TGoods;
import com.service.TCatelogService;
import com.service.TGoodsService;
 
@Controller
public class IndexController {
	@Autowired
    private TGoodsService tGoodsService;
	@Autowired
	private TCatelogService tCatelogService;
	@RequestMapping(value="/index")
	public String index(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
        req.getSession().setAttribute("catelogList", tCatelogService.queryTCatelogList(new TCatelog()));
        TCatelog catelog = new TCatelog();
		 catelog.setFid(0L);
		  List<TCatelog> oneCatelogList = tCatelogService.queryTCatelogList(catelog);
		List<TCatelog> twoCatelogList = new ArrayList<TCatelog>();
		if(oneCatelogList!=null && oneCatelogList.size()>0){
			TCatelog one = oneCatelogList.get(0);
			 catelog = new TCatelog();
			 catelog.setFid(new Long(one.getId()));
			 twoCatelogList = tCatelogService.queryTCatelogList(catelog);
			 
			if(twoCatelogList!=null && twoCatelogList.size()>0){
				TGoods tGoods = new TGoods();
				tGoods.setCatelogId(twoCatelogList.get(0).getId());
				List<TGoods> goodsList = tGoodsService.queryTGoodsList(tGoods);
				req.setAttribute("goodsList",goodsList);
			}
		}
	    List<TGoods> glist = tGoodsService.paihang();
	    
	    List<TGoods> topxlist = new ArrayList<TGoods>();
	    if(glist!=null && glist.size()>0){
	    	for (TGoods goods : glist) {
	    		TGoods good = tGoodsService.queryTGoodsById(goods.getId().intValue());
	    		good.setXl(goods.getXl());
	    		topxlist.add(good);
			}
	    }
		req.setAttribute("newList", tGoodsService.queryTGoodsList(new TGoods())); //新上架
		req.setAttribute("topxlList", topxlist);//推荐商品
		req.setAttribute("oneList", oneCatelogList);
		req.setAttribute("twoList", twoCatelogList);
		req.getSession().setAttribute("cateList", oneCatelogList);
		return "qiantai/index.jsp";
	}
	 
}
