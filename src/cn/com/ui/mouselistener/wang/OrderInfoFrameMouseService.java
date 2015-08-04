package cn.com.ui.mouselistener.wang;

import cn.com.ui.wang.CustomerFrame;
import cn.com.ui.wang.OrderInfoFrame;

public class OrderInfoFrameMouseService {
	private OrderInfoFrame of; 
	
	public OrderInfoFrameMouseService(OrderInfoFrame of){
		this.of = of;
		dataReset();
	}

	public void dataReset() {
		// TODO Auto-generated method stub
		new CustomerFrame();
	}
	
}
