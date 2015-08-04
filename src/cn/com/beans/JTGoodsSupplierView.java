package cn.com.beans;

public class JTGoodsSupplierView {
	private String Supplier_Name;
	private String Order_date;
	private String Order_Id;
	private String Order_Type;
	private float Order_price;
	private String Order_head;
	private String Order_Note;
	public String getSupplier_Name() {
		return Supplier_Name;
	}
	public void setSupplier_Name(String supplier_Name) {
		Supplier_Name = supplier_Name;
	}
	public String getOrder_date() {
		return Order_date;
	}
	public void setOrder_date(String order_date) {
		Order_date = order_date;
	}
	public String getOrder_Id() {
		return Order_Id;
	}
	public void setOrder_Id(String order_Id) {
		Order_Id = order_Id;
	}
	public String getOrder_Type() {
		return Order_Type;
	}
	public void setOrder_Type(String order_Type) {
		Order_Type = order_Type;
	}
	public float getOrder_price() {
		return Order_price;
	}
	public void setOrder_price(float order_price) {
		Order_price = order_price;
	}
	public String getOrder_head() {
		return Order_head;
	}
	public void setOrder_head(String order_head) {
		Order_head = order_head;
	}
	public String getOrder_Note() {
		return Order_Note;
	}
	public void setOrder_Note(String order_Note) {
		Order_Note = order_Note;
	}
	@Override
	public String toString() {
		return "JTGoodsSupplierView [Supplier_Name=" + Supplier_Name
				+ ", Order_date=" + Order_date + ", Order_Id=" + Order_Id
				+ ", Order_Type=" + Order_Type + ", Order_price=" + Order_price
				+ ", Order_head=" + Order_head + ", Order_Note=" + Order_Note
				+ "]";
	}
	
	
}
