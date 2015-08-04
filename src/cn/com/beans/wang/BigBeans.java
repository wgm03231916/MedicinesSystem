package cn.com.beans.wang;

import cn.com.beans.CustomerBean;
import cn.com.beans.EmployeeBean;
import cn.com.beans.GoodsBean;
import cn.com.beans.GoodsSaleBean;
import cn.com.beans.HouseCapacityBean;
import cn.com.beans.JTGoodsBean;
import cn.com.beans.OperatorBean;
import cn.com.beans.OrderRelationBean;
import cn.com.beans.SaleRelationBean;
import cn.com.beans.WarehouseBean;

public class BigBeans {
	private GoodsBean gb;
	private EmployeeBean eb;
	private CustomerBean cb;
	private WarehouseBean wb;
	private OperatorBean ob;
	private JTGoodsBean jtb;
	private HouseCapacityBean hcb;
	private OrderRelationBean orb;
	private GoodsSaleBean gsb;
	private SaleRelationBean srb;
	
	public GoodsBean getGb() {
		return gb;
	}
	public void setGb(GoodsBean gb) {
		this.gb = gb;
	}
	public EmployeeBean getEb() {
		return eb;
	}
	public void setEb(EmployeeBean eb) {
		this.eb = eb;
	}
	public CustomerBean getCb() {
		return cb;
	}
	public void setCb(CustomerBean cb) {
		this.cb = cb;
	}
	public WarehouseBean getWb() {
		return wb;
	}
	public void setWb(WarehouseBean wb) {
		this.wb = wb;
	}
	public OperatorBean getOb() {
		return ob;
	}
	public void setOb(OperatorBean ob) {
		this.ob = ob;
	}
	public JTGoodsBean getJtb() {
		return jtb;
	}
	public void setJtb(JTGoodsBean jtb) {
		this.jtb = jtb;
	}
	public HouseCapacityBean getHcb() {
		return hcb;
	}
	public void setHcb(HouseCapacityBean hcb) {
		this.hcb = hcb;
	}
	public OrderRelationBean getOrb() {
		return orb;
	}
	public void setOrb(OrderRelationBean orb) {
		this.orb = orb;
	}
	public GoodsSaleBean getGsb() {
		return gsb;
	}
	public void setGsb(GoodsSaleBean gsb) {
		this.gsb = gsb;
	}
	public SaleRelationBean getSrb() {
		return srb;
	}
	public void setSrb(SaleRelationBean srb) {
		this.srb = srb;
	}
	public String toString(){
		return this.wb.getWarehouse_name();
	}
	
}
