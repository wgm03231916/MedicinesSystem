package cn.com.beans.view.liu;

import cn.com.beans.liu.GoodsBeans;
import cn.com.beans.liu.HouseCapacityBeans;
import cn.com.beans.liu.MoveBeans;
import cn.com.beans.liu.OrderRelationBeans;
import cn.com.beans.liu.WarehouseBeans;

public class TransferView {
	//调拨仓库所用的JavaBean，做成视图，便于查询
	private GoodsBeans goodsb;
	private WarehouseBeans warehouseb;
	private MoveBeans movesb;
	private OrderRelationBeans orderb;
	private HouseCapacityBeans housecapb;
	
	public HouseCapacityBeans getHousecapb() {
		return housecapb;
	}
	public void setHousecapb(HouseCapacityBeans housecapb) {
		this.housecapb = housecapb;
	}
	public GoodsBeans getGoodsb() {
		return goodsb;
	}
	public void setGoodsb(GoodsBeans goodsb) {
		this.goodsb = goodsb;
	}
	public WarehouseBeans getWarehouseb() {
		return warehouseb;
	}
	public void setWarehouseb(WarehouseBeans warehouseb) {
		this.warehouseb = warehouseb;
	}
	public MoveBeans getMovesb() {
		return movesb;
	}
	public void setMovesb(MoveBeans movesb) {
		this.movesb = movesb;
	}
	public OrderRelationBeans getOrderb() {
		return orderb;
	}
	public void setOrderb(OrderRelationBeans orderb) {
		this.orderb = orderb;
	}

}
