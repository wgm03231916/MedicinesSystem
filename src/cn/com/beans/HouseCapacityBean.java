package cn.com.beans;

public class HouseCapacityBean {
    private String Warehouse_id;
    private String Goods_id;
    private int Goods_num;
	public String getWarehouse_id() {
		return Warehouse_id;
	}
	public void setWarehouse_id(String warehouse_id) {
		Warehouse_id = warehouse_id;
	}
	public String getGoods_id() {
		return Goods_id;
	}
	public void setGoods_id(String goods_id) {
		Goods_id = goods_id;
	}
	public int getGoods_num() {
		return Goods_num;
	}
	public void setGoods_num(int goods_num) {
		Goods_num = goods_num;
	}
}
