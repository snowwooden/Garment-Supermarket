package com.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.pojo.TGoods;
import com.pojo.TOrderitem;

public class Cart
{

	protected Map<Integer, TOrderitem> items;

	public Cart()
	{

		if (items == null)
		{
			items = new HashMap<Integer, TOrderitem>();
		}
	}

	public void addGoods(Integer goodsId, TOrderitem orderItem)
	{

		if (items.containsKey(goodsId))
		{

			TOrderitem _orderitem = items.get(goodsId);
			_orderitem.setGoods_quantity(_orderitem.getGoods_quantity()+ orderItem.getGoods_quantity());
			items.put(goodsId, _orderitem);
		} 
		else
		{

			items.put(goodsId, orderItem);
		}
	}
	
	public void delGoods(Integer goodsId)
	{
		items.remove(goodsId);
	}
	

	public void updateCart(Integer goodsId, int quantity)
	{

		TOrderitem orderItem = items.get(goodsId);
		orderItem.setGoods_quantity(quantity);
		items.put(goodsId, orderItem);
	}

	public double getTotalPrice()
	{

		double totalPrice = 0;
		for (Iterator it = items.values().iterator(); it.hasNext();)
		{

			TOrderitem orderItem = (TOrderitem) it.next();
			TGoods goods = orderItem.getGoods();
			int quantity = orderItem.getGoods_quantity();
			totalPrice += goods.getShichangjia()* quantity;
		}
		return totalPrice;
	}

	public Map<Integer, TOrderitem> getItems()
	{
		return items;
	}

}
