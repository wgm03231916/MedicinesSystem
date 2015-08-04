package cn.com.beans.huang;

import cn.com.beans.GoodsBean;
import cn.com.beans.HouseCapacityBean;
import cn.com.beans.JTGoodsBean;
import cn.com.beans.OrderRelationBean;
import cn.com.beans.SupplierBean;
import cn.com.beans.WarehouseBean;

public class BigAllBean {
     private SupplierBean sb;
     private WarehouseBean wb;
     private JTGoodsBean jb;
     private GoodsBean gb;
     private HouseCapacityBean hc;
     private OrderRelationBean ob;
	public GoodsBean getGb() {
		return gb;
	}
	public void setGb(GoodsBean gb) {
		this.gb = gb;
	}
	public HouseCapacityBean getHc() {
		return hc;
	}
	public void setHc(HouseCapacityBean hc) {
		this.hc = hc;
	}
	public OrderRelationBean getOb() {
		return ob;
	}
	public void setOb(OrderRelationBean ob) {
		this.ob = ob;
	}
	public JTGoodsBean getJb() {
		return jb;
	}
	public void setJb(JTGoodsBean jb) {
		this.jb = jb;
	}
	public SupplierBean getSb() {
		return sb;
	}
	public void setSb(SupplierBean sb) {
		this.sb = sb;
	}
	public WarehouseBean getWb() {
		return wb;
	}
	public void setWb(WarehouseBean wb) {
		this.wb = wb;
	}
//	public String toString(){
//		return this.wb.getWarehouse_name();
//	}
	
}
