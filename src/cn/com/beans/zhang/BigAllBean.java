package cn.com.beans.zhang;

import cn.com.beans.EmployeeBean;
import cn.com.beans.GoodsBean;
import cn.com.beans.HouseCapacityBean;
import cn.com.beans.JTGoodsBean;
import cn.com.beans.OperatorBean;
import cn.com.beans.OrderRelationBean;
import cn.com.beans.SaleRelationBean;
import cn.com.beans.SupplierBean;
import cn.com.beans.WarehouseBean;

public class BigAllBean {
	private SupplierBean sb ;
	private GoodsBean gb;
	private OperatorBean ob;
	private EmployeeBean eb;
	private SaleRelationBean sr;
	private WarehouseBean wb;
	private JTGoodsBean jt;
	private HouseCapacityBean h;
	private OrderRelationBean or;
	public OrderRelationBean getOr() {
		return or;
	}
	public void setOr(OrderRelationBean or) {
		this.or = or;
	}
	public HouseCapacityBean getH() {
		return h;
	}
	public void setH(HouseCapacityBean h) {
		this.h = h;
	}
	public JTGoodsBean getJt() {
		return jt;
	}
	public void setJt(JTGoodsBean jt) {
		this.jt = jt;
	}
	public WarehouseBean getWb() {
		return wb;
	}
	public void setWb(WarehouseBean wb) {
		this.wb = wb;
	}
	public SaleRelationBean getSr() {
		return sr;
	}
	public void setSr(SaleRelationBean sr) {
		this.sr = sr;
	}
	public EmployeeBean getEb() {
		return eb;
	}
	public void setEb(EmployeeBean eb) {
		this.eb = eb;
	}
	public SupplierBean getSb() {
		return sb;
	}
	public void setSb(SupplierBean sb) {
		this.sb = sb;
	}
	public GoodsBean getGb() {
		return gb;
	}
	public void setGb(GoodsBean gb) {
		this.gb = gb;
	}
	public OperatorBean getOb() {
		return ob;
	}
	public void setOb(OperatorBean ob) {
		this.ob = ob;
	}
	
	public String toString(){
		return sb.toString();
	}
	
	
}
