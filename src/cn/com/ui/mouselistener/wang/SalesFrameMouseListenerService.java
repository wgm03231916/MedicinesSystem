package cn.com.ui.mouselistener.wang;

import cn.com.ui.wang.OrderInfoFrame;
import cn.com.ui.wang.SalesFrame;

public class SalesFrameMouseListenerService {
	
	private SalesFrame sf;
	
	public SalesFrameMouseListenerService(SalesFrame sf){
		this.sf = sf;
		dataReset();
	}
	public void dataReset(){
		new OrderInfoFrame();
		
	}
}
