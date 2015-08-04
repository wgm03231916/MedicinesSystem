package cn.com.ui.mouselistener.wang;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cn.com.ui.wang.OrderInfoFrame;

public class OrderInfoFrame_priceMessage_MouseListener implements MouseListener {
	private OrderInfoFrame of;
	public OrderInfoFrame_priceMessage_MouseListener(OrderInfoFrame of){
		this.of = of;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		OrderMouseListenerService ms = new OrderMouseListenerService(of);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
