package com.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.TCatelog;
import com.pojo.TGoods;
import com.pojo.TOrder;
import com.pojo.TOrderitem;
import com.pojo.TUser;
import com.service.TCatelogService;
import com.service.TGoodsService;
import com.service.TOrderService;
import com.service.TOrderitemService;
import com.util.Cart;
 
@Controller
@RequestMapping("/buy")
public class BuyController {
	@Autowired
    private TGoodsService tGoodsService;
	@Autowired
	private TOrderService tOrderService;
	@Autowired
	private TOrderitemService tOrderitemService;
	@Autowired
	private TCatelogService tCatelogService;
	@RequestMapping("/addToCart")
	public String addToCart(HttpServletRequest req, HttpServletResponse res) throws Exception {
		init(req);
		int goods_id = Integer.parseInt(req.getParameter("goods_id"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		TGoods goods = tGoodsService.queryTGoodsById(goods_id);
		TOrderitem orderItem = new TOrderitem();
		orderItem.setGoods(goods);
		orderItem.setGoods_quantity(quantity);
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		cart.addGoods(goods_id, orderItem);
		session.setAttribute("cart", cart);
		req.setAttribute("message", "");
		req.setAttribute("path", "qiantai/cart/mycart.jsp");
		return "/common/success.jsp";
		

	}
	
 
	@RequestMapping("/orderSubmit")
	public String orderSubmit(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		String songhuodizhi = req.getParameter("songhuodizhi");
		String fukuanfangshi = req.getParameter("fukuanfangshi");
		HttpSession session = req.getSession();
		init(req);
		 

			
		   Cart cart = (Cart) session.getAttribute("cart");
		   TUser user = (TUser) session.getAttribute("user");

		   TOrder order = new TOrder();
		   String oid = String.valueOf(new Date().getTime());
			order.setId(oid);
			order.setBianhao(new SimpleDateFormat("yyyyMMddhhmmss")
					.format(new Date()));
			order.setShijian(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(new Date()));
			order.setZhuangtai("no");
			order.setSonghuodizhi(songhuodizhi);
			order.setFukuanfangshi(fukuanfangshi);
			order.setJine(cart.getTotalPrice());
			order.setUserId(user.getId());
			order.setZhuangtai("未付款");
			tOrderService.insertTOrder(order);

			for (Iterator it = cart.getItems().values().iterator(); it.hasNext();) {
				TOrderitem orderItem = (TOrderitem) it.next();
				String id = String.valueOf(new Date().getTime());
				orderItem.setId(id);
				orderItem.setOrderId(oid);
				orderItem.setGoodsId(orderItem.getGoods().getId());
				orderItem.setGoodsQuantity(new Long(orderItem.getGoods_quantity()));
				tOrderitemService.insertTOrderitem(orderItem);
			}
			cart.getItems().clear();
			session.setAttribute("cart", cart);

			req.setAttribute("order", order);
 
			return "/qiantai/order/orderSubmit.jsp";

	}
	@RequestMapping("/myorder")
	public String myorder(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		HttpSession session = req.getSession();
		TUser user = (TUser) session.getAttribute("user");
		init(req);
		TOrder order = new TOrder();
		order.setUserId(user.getId());
		List list = tOrderService.queryTOrderList(order);
		req.setAttribute("orderList", list);
		return "/qiantai/order/myorder.jsp";
	}
	@RequestMapping("/orderDetail")
	public String orderDetail(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		init(req);
		String order_id = req.getParameter("order_id");
		TOrderitem item = new TOrderitem();
		item.setOrderId(order_id);
		List<TOrderitem> itemList = tOrderitemService.queryTOrderitemList(item);
		if(itemList!=null && itemList.size()>0){
			for (TOrderitem tOrderitem : itemList) {
				tOrderitem.setGoods(tGoodsService.queryTGoodsById(tOrderitem.getGoodsId().intValue()));
			}
		}
		req.setAttribute("orderItemList", itemList);
        return "/qiantai/order/orderDetail.jsp";
	}
	
	@RequestMapping("/orderDetail1")
	public void orderDetail1(HttpServletRequest req, HttpServletResponse res)
	   throws Exception {
		String order_id = req.getParameter("order_id");
		TOrderitem item = new TOrderitem();
		item.setOrderId(order_id);
		List<TOrderitem> itemList = tOrderitemService.queryTOrderitemList(item);
		if(itemList!=null && itemList.size()>0){
			for (TOrderitem tOrderitem : itemList) {
				tOrderitem.setGoods(tGoodsService.queryTGoodsById(tOrderitem.getGoodsId().intValue()));
			}
		}
		req.setAttribute("orderItemList",itemList);
		req.setAttribute("gsize", itemList.size() );
		req.setAttribute("oid", order_id );
		req.getRequestDispatcher("/qiantai/order/orderDetail1.jsp").forward(req,
				res);
 }
	
	
 
	@RequestMapping("/updateZT")
	public String updateZT(HttpServletRequest req,HttpServletResponse res) throws Exception 
	{
		init(req);
		String orderid=req.getParameter("orderid");
		int zt=Integer.parseInt(req.getParameter("zt"));
		
        String zts = "未付款";
		if(zt==2){
			zts = "已付款";
		}
		if(zt==3){
			zts = "已取消";
		}
		if(zt==4){
			zts = "确认收货";
		}
		TOrder order = tOrderService.queryTOrderById(orderid);
		
		order.setZhuangtai(zts);
		tOrderService.updateTOrder(order);
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "buy/myorder");
		return "/common/success.jsp";
		
	}
	
	
	private void init(HttpServletRequest req){
		try {
			 TCatelog catelog = new TCatelog();
			  catelog.setFid(0L);
			  List<TCatelog> oneCatelogList = tCatelogService.queryTCatelogList(catelog);
				List<TCatelog> twoCatelogList = new ArrayList<TCatelog>();
				if(oneCatelogList!=null && oneCatelogList.size()>0){
					TCatelog one = oneCatelogList.get(0);
					TCatelog query = new TCatelog();
					query.setFid(one.getId());
					twoCatelogList = tCatelogService.queryTCatelogList(query);
					if(twoCatelogList!=null && twoCatelogList.size()>0){
						TGoods tgood = new TGoods();
						tgood.setCatelogId(twoCatelogList.get(0).getId());
						List list = tGoodsService.queryTGoodsList(tgood);
						req.setAttribute("goodsList",list );
					}
				}
				req.setAttribute("oneList", oneCatelogList);
				req.setAttribute("twoList", twoCatelogList);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		
	}
}
