package cn.com.beans;

public class GoodsJTGoodsOrderRelationView {
	private String Order_id;
	private String Goods_Id;
	private String Goods_Name;
	private String Goods_Unit;
	private float Goods_Setting;
	private int Goods_Num;
	private float Order_price;
	private String Goods_Spft;
	private String Goods_Manufacture;
	private String Goods_Validity;
	public String getOrder_id() {
		return Order_id;
	}
	public void setOrder_id(String order_id) {
		Order_id = order_id;
	}
	public String getGoods_Id() {
		return Goods_Id;
	}
	public void setGoods_Id(String goods_Id) {
		Goods_Id = goods_Id;
	}
	public String getGoods_Name() {
		return Goods_Name;
	}
	public void setGoods_Name(String goods_Name) {
		Goods_Name = goods_Name;
	}
	public String getGoods_Unit() {
		return Goods_Unit;
	}
	public void setGoods_Unit(String goods_Unit) {
		Goods_Unit = goods_Unit;
	}
	public float getGoods_Setting() {
		return Goods_Setting;
	}
	public void setGoods_Setting(float goods_Setting) {
		Goods_Setting = goods_Setting;
	}
	public int getGoods_Num() {
		return Goods_Num;
	}
	public void setGoods_Num(int goods_Num) {
		Goods_Num = goods_Num;
	}
	public float getOrder_price() {
		return Order_price;
	}
	public void setOrder_price(float order_price) {
		Order_price = order_price;
	}
	public String getGoods_Spft() {
		return Goods_Spft;
	}
	public void setGoods_Spft(String goods_Spft) {
		Goods_Spft = goods_Spft;
	}
	public String getGoods_Manufacture() {
		return Goods_Manufacture;
	}
	public void setGoods_Manufacture(String goods_Manufacture) {
		Goods_Manufacture = goods_Manufacture;
	}
	public String getGoods_Validity() {
		return Goods_Validity;
	}
	public void setGoods_Validity(String goods_Validity) {
		Goods_Validity = goods_Validity;
	}
	@Override
	public String toString() {
		return "GoodsJTGoodsOrderRelationView [Order_id=" + Order_id
				+ ", Goods_Id=" + Goods_Id + ", Goods_Name=" + Goods_Name
				+ ", Goods_Unit=" + Goods_Unit + ", Goods_Setting="
				+ Goods_Setting + ", Goods_Num=" + Goods_Num + ", Order_price="
				+ Order_price + ", Goods_Spft=" + Goods_Spft
				+ ", Goods_Manufacture=" + Goods_Manufacture
				+ ", Goods_Validity=" + Goods_Validity + "]";
	}
	
	
}
