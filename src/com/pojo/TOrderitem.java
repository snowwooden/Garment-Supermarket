package com.pojo;
public class TOrderitem
{
 
	public TOrderitem(){
  
	}
	 
	private String id;
        
         
	private String orderId;
        
         
	private Long goodsId;
        
         
	private Long goodsQuantity;
        
    private TGoods goods;
    private int goods_quantity;
    
    
	public TGoods getGoods() {
		return goods;
	}

	public void setGoods(TGoods goods) {
		this.goods = goods;
	}

	public int getGoods_quantity() {
		return goods_quantity;
	}

	public void setGoods_quantity(int goodsQuantity) {
		goods_quantity = goodsQuantity;
	}

	public String getId(){
		return this.id;
	}
 
	public void setId(String id){
		this.id = id;
	}
		
         
	public String getOrderId(){
		return this.orderId;
	}
 
	public void setOrderId(String orderId){
		this.orderId = orderId;
	}
		
         
	public Long getGoodsId(){
		return this.goodsId;
	}
 
	public void setGoodsId(Long goodsId){
		this.goodsId = goodsId;
	}
		
         
	public Long getGoodsQuantity(){
		return this.goodsQuantity;
	}
 
	public void setGoodsQuantity(Long goodsQuantity){
		this.goodsQuantity = goodsQuantity;
	}
		
            
}
