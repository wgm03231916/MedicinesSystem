package cn.com.beans;

public class GoodsSaleRelationViweBean {
	
	private String Sale_Id;
	private String gg_id;
	private String Goods_Name;
	private String Goods_Unit;
	private float Goods_Setting;
	private int Sale_num;
	private float Sale_Price;
	private String Goods_Spft;
	private String Goods_Apvlunm;
	private String Goods_Manufacture;
	
	public String getSale_Id() {
		return Sale_Id;
	}
	public void setSale_Id(String sale_Id) {
		Sale_Id = sale_Id;
	}
	public String getGg_id() {
		return gg_id;
	}
	public void setGg_id(String gg_id) {
		this.gg_id = gg_id;
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
	public int getSale_num() {
		return Sale_num;
	}
	public void setSale_num(int sale_num) {
		Sale_num = sale_num;
	}
	public float getSale_Price() {
		return Sale_Price;
	}
	public void setSale_Price(float sale_Price) {
		Sale_Price = sale_Price;
	}
	public String getGoods_Spft() {
		return Goods_Spft;
	}
	public void setGoods_Spft(String goods_Spft) {
		Goods_Spft = goods_Spft;
	}
	public String getGoods_Apvlunm() {
		return Goods_Apvlunm;
	}
	public void setGoods_Apvlunm(String goods_Apvlunm) {
		Goods_Apvlunm = goods_Apvlunm;
	}
	public String getGoods_Manufacture() {
		return Goods_Manufacture;
	}
	public void setGoods_Manufacture(String goods_Manufacture) {
		Goods_Manufacture = goods_Manufacture;
	}
	@Override
	public String toString() {
		return "GoodsSaleRelationViweBean [Sale_Id=" + Sale_Id + ", gg_id="
				+ gg_id + ", Goods_Name=" + Goods_Name + ", Goods_Unit="
				+ Goods_Unit + ", Goods_Setting=" + Goods_Setting
				+ ", Sale_num=" + Sale_num + ", Sale_Price=" + Sale_Price
				+ ", Goods_Spft=" + Goods_Spft + ", Goods_Apvlunm="
				+ Goods_Apvlunm + ", Goods_Manufacture=" + Goods_Manufacture
				+ "]";
	}
	
	
}
