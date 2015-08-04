package cn.com.beans;

public class Supplier_1Number {
	private int num;
	private String Order_id;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getOrder_id() {
		return Order_id;
	}
	public void setOrder_id(String order_id) {
		Order_id = order_id;
	}
	@Override
	public String toString() {
		return "Supplier_1Number [num=" + num + ", Order_id=" + Order_id + "]";
	}
	
	
	
}
