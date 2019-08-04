package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Pinglun;
import com.pojo.TCatelog;
import com.pojo.TGoods;
import com.service.PinglunService;
import com.service.TCatelogService;
import com.service.TGoodsService;
 
@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
    private TGoodsService tGoodsService;
	@Autowired
	private TCatelogService tCatelogService;
	
	@Autowired
	private PinglunService pinglunService;
	@RequestMapping("/goodsAdd")
	public String goodsAdd(TGoods tGoods,HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		tGoodsService.insertTGoods(tGoods);
    	req.setAttribute("message", "操作成功");
		req.setAttribute("path", "goods/goodsMana");
		return "/common/success.jsp";
	}
	
	@RequestMapping("/goodsUpdate")
	public String goodsUpdate(TGoods tGoods,HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		tGoodsService.updateTGoods(tGoods);
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "goods/goodsMana");
		return "/common/success.jsp";
	}
	
	
	
	@RequestMapping("/goodsDel")
	public String goodsDel(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		int id=Integer.parseInt(req.getParameter("id"));
		tGoodsService.deleteTGoods(id);
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "goods/goodsMana");
		return "/common/success.jsp";
	}
	
	@RequestMapping("/goodsMana")
	public String goodsMana(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		List goodsList= tGoodsService.queryTGoodsList(new TGoods());
		req.setAttribute("goodsList", goodsList);
		return "/admin/goods/goodsMana.jsp";
	}
	
	
	
	
	@RequestMapping("/goodsEditPre")  
	public String goodsEditPre(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		int id=Integer.parseInt(req.getParameter("id"));
		req.setAttribute("goods",tGoodsService.queryTGoodsById(id));
		return "/admin/goods/goodsEdit.jsp";
	}
	
	@RequestMapping("/goodsDetailHou")  
	public String goodsDetailHou(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		int id=Integer.parseInt(req.getParameter("id"));
		req.setAttribute("goods",tGoodsService.queryTGoodsById(id));
		return "/admin/goods/goodsDetailHou.jsp";
	}
	 
	@RequestMapping("/goodsByCatelog")  
	public String goodsByCatelog(HttpServletRequest req,HttpServletResponse res) throws  Exception
	{
		int catelog_id=Integer.parseInt(req.getParameter("catelog_id"));
		req.setAttribute("catelog_id",catelog_id);
		req.setAttribute("fid",0);
		 
		String sorts= req.getParameter("sorts") ;
		
		 TCatelog catelog = new TCatelog();
		 catelog.setFid(0L);
		  List<TCatelog> oneCatelogList = tCatelogService.queryTCatelogList(catelog);
		  
	 
		List<TCatelog> twoCatelogList = new ArrayList<TCatelog>();
		List<TGoods> goodsList = new ArrayList<TGoods>();
		
		catelog = new TCatelog();
		 catelog.setFid(new Long(catelog_id));
		 twoCatelogList = tCatelogService.queryTCatelogList(catelog);
		 if(tCatelogService.queryTCatelogById(catelog_id)!=null){
			 req.setAttribute("names",tCatelogService.queryTCatelogById(catelog_id).getName());
		 }
		
		req.setAttribute("oneList", oneCatelogList);
		req.setAttribute("twoList", twoCatelogList);
		
		TGoods goods = new TGoods();
		goods.setCatelogId(new Long(catelog_id));
		goods.setSorts(sorts);
		goodsList = tGoodsService.queryTGoodsList1(goods);
		req.setAttribute("goodsList", goodsList);
		req.setAttribute("qtype","goodsByCatelog");
		return "/qiantai/plist.jsp";
	}
	
	@RequestMapping("/goodsindex")  
	public String goodsindex(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
	 
		 TCatelog catelog = new TCatelog();
		 catelog.setFid(0L);
		  List<TCatelog> oneCatelogList = tCatelogService.queryTCatelogList(catelog);
 
		List<TCatelog> twoCatelogList = new ArrayList<TCatelog>();
		TGoods tGoods = new TGoods();
		tGoods.setCatelogId(0l);
		List<TGoods> goodsList = tGoodsService.queryTGoodsList(tGoods);
 
		req.setAttribute("names", "全部");
		req.setAttribute("oneList", oneCatelogList);
		req.setAttribute("twoList", twoCatelogList);
		req.setAttribute("goodsList", goodsList);
 
		req.setAttribute("qtype","goodsindex");
		
		return "/qiantai/plist.jsp";
	}
	
	
	
	@RequestMapping("/goodsByCatelog1")  
	public String goodsByCatelog1(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		int catelog_id=Integer.parseInt(req.getParameter("catelog_id")==null?"0":req.getParameter("catelog_id"));
		int fid=Integer.parseInt(req.getParameter("fid")==null?"0":req.getParameter("fid"));
		String sorts= req.getParameter("sorts") ;
		
	 
		 TCatelog catelog = new TCatelog();
		 catelog.setFid(0L);
		  List<TCatelog> oneCatelogList = tCatelogService.queryTCatelogList(catelog);
		  
		List<TCatelog> twoCatelogList = new ArrayList<TCatelog>();
 
		TGoods tGoods = new TGoods();
		tGoods.setCatelogId(new Long(catelog_id));
		tGoods.setSorts(sorts);
		List<TGoods> goodsList = tGoodsService.queryTGoodsList(tGoods);
		
		
		catelog = new TCatelog();
		catelog.setFid(new Long(fid));
		twoCatelogList = tCatelogService.queryTCatelogList(catelog);
		  
		req.setAttribute("oneList", oneCatelogList);
		req.setAttribute("twoList", twoCatelogList);
		req.setAttribute("names",tCatelogService.queryTCatelogById(catelog_id).getName());
		req.setAttribute("goodsList",goodsList );
		
 
		req.setAttribute("qtype","goodsByCatelog1");
		
		req.setAttribute("catelog_id",catelog_id);
		req.setAttribute("fid",fid);
		
		return "/qiantai/plist.jsp";
	}
	
	
	
	@RequestMapping("/goodsByName")  
	public String goodsByName(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		
		String name=req.getParameter("queryname");
		
		
		 TCatelog catelog = new TCatelog();
		 catelog.setFid(0L);
		  List<TCatelog> oneCatelogList = tCatelogService.queryTCatelogList(catelog);
		  
		List<TCatelog> twoCatelogList = new ArrayList<TCatelog>();
 
		req.setAttribute("oneList", oneCatelogList);
		req.setAttribute("twoList", twoCatelogList);
		req.setAttribute("names", name);
		
		TGoods tGoods = new TGoods();
		tGoods.setMingcheng(name);
		List<TGoods> goodsList = tGoodsService.queryTGoodsList(tGoods);
		req.setAttribute("goodsList",goodsList);
		
 
		req.setAttribute("qtype","goodsByCatelog1");
		req.setAttribute("catelog_id","0");
		req.setAttribute("fid","0");
		
		return "/qiantai/plist.jsp";
	}
	
	@RequestMapping("/goodsDetailQian")  
	public String goodsDetailQian(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		int id=Integer.parseInt(req.getParameter("id"));
		int cid=Integer.parseInt(req.getParameter("cid"));
		TCatelog cl = tCatelogService.queryTCatelogById(cid);
		
		 TCatelog catelog = new TCatelog();
		 catelog.setFid(0L);
		  List<TCatelog> oneCatelogList = tCatelogService.queryTCatelogList(catelog);
		  
	 
		 List<TCatelog> twoCatelogList = new ArrayList<TCatelog>();
		 if(oneCatelogList!=null && oneCatelogList.size()>0){
			 catelog = new TCatelog();
			 catelog.setFid(new Long(cl.getFid()));
			twoCatelogList = tCatelogService.queryTCatelogList(catelog);
		 }
		 req.setAttribute("oneList", oneCatelogList);
		 req.setAttribute("twoList", twoCatelogList);
		TGoods goods = tGoodsService.queryTGoodsById(id);
		req.setAttribute("goods",goods);
		
		goods.setViewcount(goods.getViewcount()+1);
		tGoodsService.updateTGoods(goods);
	    Pinglun pl = new Pinglun();
	    pl.setGid(goods.getId());
		 req.setAttribute("pinglunList", pinglunService.queryPinglunList(pl));
		return "/qiantai/goods/goodsDetailQian.jsp";
		
	}
}
