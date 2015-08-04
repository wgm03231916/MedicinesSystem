package cn.com.beans;

public class JTGoodsBean {
    private String Order_id;
    private String Supplier_id;
    private String Order_type;
    private String Warehouse_id;
    private String Order_date;
    private float Order_price;
    private String Order_head;
    private String Order_note;
	public String getOrder_id() {
		return Order_id;
	}
	public void setOrder_id(String order_id) {
		Order_id = order_id;
	}
	public String getSupplier_id() {
		return Supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		Supplier_id = supplier_id;
	}
	public String getOrder_type() {
		return Order_type;
	}
	public void setOrder_type(String order_type) {
		Order_type = order_type;
	}
	public String getWarehouse_id() {
		return Warehouse_id;
	}
	public void setWarehouse_id(String warehouse_id) {
		Warehouse_id = warehouse_id;
	}
	public String getOrder_date() {
		return Order_date;
	}
	public void setOrder_date(String order_date) {
		Order_date = order_date;
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
	public String getOrder_note() {
		return Order_note;
	}
	public void setOrder_note(String order_note) {
		Order_note = order_note;
	}
	@Override
	public String toString() {
		return "JTGoodsBean [Order_id=" + Order_id + ", Supplier_id="
				+ Supplier_id + ", Order_type=" + Order_type
				+ ", Warehouse_id=" + Warehouse_id + ", Order_date="
				+ Order_date + ", Order_price=" + Order_price + ", Order_head="
				+ Order_head + ", Order_note=" + Order_note + "]";
	}
	
}
