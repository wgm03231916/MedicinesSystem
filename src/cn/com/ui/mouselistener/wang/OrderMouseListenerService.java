package cn.com.ui.mouselistener.wang;

import cn.com.ui.wang.CustomersPriceFrame;
import cn.com.ui.wang.OrderInfoFrame;

public class OrderMouseListenerService {
	
	private OrderInfoFrame of;
	
	public OrderMouseListenerService(OrderInfoFrame of){
		this.of = of;
		dataReset();
	}

	private void dataReset() {
		// TODO Auto-generated method stub
		new CustomersPriceFrame();
	}
}
