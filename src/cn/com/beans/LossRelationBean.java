package cn.com.beans;

public class LossRelationBean {
     private String LossRelation_id;
     private String Goods_id;
     private String Warehouse_id;
     private int Loss_num;
	public String getLossRelation_id() {
		return LossRelation_id;
	}
	public void setLossRelation_id(String lossRelation_id) {
		LossRelation_id = lossRelation_id;
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
	public int getLoss_num() {
		return Loss_num;
	}
	public void setLoss_num(int loss_num) {
		Loss_num = loss_num;
	}
}
