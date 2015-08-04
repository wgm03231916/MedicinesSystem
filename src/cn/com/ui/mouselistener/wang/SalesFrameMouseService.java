package cn.com.ui.mouselistener.wang;

import cn.com.ui.wang.GoodsMarketFrame;
import cn.com.ui.wang.SalesFrame;

public class SalesFrameMouseService {
	private SalesFrame mf;
	
	public SalesFrameMouseService(SalesFrame mf){
		this.mf = mf;
		dataReset();
		
	}
	
	public void dataReset(){
		
		new GoodsMarketFrame();
		
	}
}
