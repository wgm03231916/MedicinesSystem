package cn.com.beans;

public class OrderRelationBean {
     private String Order_id;
     private String Goods_id;
     private String Warehouse_id;
     private int Goods_num;
     private float Order_price;
     private String Goods_validity;
	public String getOrder_id() {
		return Order_id;
	}
	public void setOrder_id(String order_id) {
		Order_id = order_id;
	}
	public String getGoods_id() {
		return Goods_id;
	}
	public void setGoods_id(String goods_id) {
		Goods_id = goods_id;
	}
	public String getWarehouse_id() {
		return Warehouse_id;
	}
	public void setWarehouse_id(String warehouse_id) {
		Warehouse_id = warehouse_id;
	}
	public int getGoods_num() {
		return Goods_num;
	}
	public void setGoods_num(int goods_num) {
		Goods_num = goods_num;
	}
	public float getOrder_price() {
		return Order_price;
	}
	public void setOrder_price(float order_price) {
		Order_price = order_price;
	}
	public String getGoods_validity() {
		return Goods_validity;
	}
	public void setGoods_validity(String goods_validity) {
		Goods_validity = goods_validity;
	}
}
