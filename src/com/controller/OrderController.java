package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.TGoods;
import com.pojo.TOrder;
import com.pojo.TOrderitem;
import com.service.TGoodsService;
import com.service.TOrderService;
import com.service.TOrderitemService;
 
@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private TOrderService tOrderService;
	@Autowired
	private TOrderitemService tOrderitemService;
	
	@Autowired
	private TGoodsService tGoodsService;
	
	@RequestMapping(value="/orderDel")
	public String orderDel(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		String id=req.getParameter("id");
		
		tOrderService.deleteTOrder(id);
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "order/orderMana");
        return "/common/success.jsp";
		
	}
	
	@RequestMapping(value="/login")
	public String login(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		 
		return "/qiantai/userinfo/login.jsp";
	}
	
	@RequestMapping(value="/register")
	public String register(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		return "/qiantai/userinfo/userReg.jsp";
	}
	
	@RequestMapping(value="/mygouwuche")
	public String mygouwuche(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		return "/qiantai/cart/mycart.jsp";
	}
	
	@RequestMapping(value="/orderMana")
	public String orderMana(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		List orderList= tOrderService.queryTOrderList(new TOrder());
		req.setAttribute("orderList", orderList);
		return "/admin/order/orderMana.jsp";
	}
	
	@RequestMapping(value="/report")
	public String report(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		List<TOrder> orderList= tOrderService.report();
	 
		req.setAttribute("title", "销量排行榜(Top 5)");
		String items="";
		String score="";
		if(orderList!=null && orderList.size()>0){
			for (TOrder order : orderList) {
				items = items + "'"+order.getMingcheng()+"',";
				score = score + order.getNums() + ",";
			}
			items = items.substring(0, items.length()-1);
			score = score.substring(0, score.length()-1);
		
		}
		req.setAttribute("items", items);
		req.setAttribute("score", score);
		return "/admin/order/report1.jsp";
	}
	
 
	
	@RequestMapping(value="/orderShouli")
	public String orderShouli(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		String id=req.getParameter("id");
		TOrder order = tOrderService.queryTOrderById(id);
		String kddh=req.getParameter("kddh");
		order.setKddh(kddh);
		order.setZhuangtai("已发货");
		tOrderService.updateTOrder(order);
		
		TOrderitem orderitem = new TOrderitem();
		orderitem.setOrderId(id);
		List<TOrderitem> list = tOrderitemService.queryTOrderitemList(orderitem);
		if(list!=null && list.size()>0){
			for (TOrderitem torderItem : list) {
				TGoods tgoods = tGoodsService.queryTGoodsById(torderItem.getGoodsId().intValue());
				torderItem.setGoods(tgoods);
				tgoods.setKucun(tgoods.getKucun()-orderitem.getGoods_quantity());
				tGoodsService.updateTGoods(tgoods);
			}
		}
		req.setAttribute("msg", "操作成功");
		return "/common/add_success.jsp";
	}

}
