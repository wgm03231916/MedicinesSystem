package cn.com.ui.mouselistener.wang;

import javax.swing.JTable;

import cn.com.ui.wang.AddGoodsFrame;
import cn.com.ui.wang.GoodsMarketFrame;


public class GoodsMarketFrameMouseService {
	
private GoodsMarketFrame gf;
	
	public GoodsMarketFrameMouseService(GoodsMarketFrame gf){
		this.gf = gf;
		dataReset();
	}
	
	public void dataReset(){
		JTable table = gf.getTbeGoods();
		new AddGoodsFrame(table);
	}
}
