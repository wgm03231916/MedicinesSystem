package cn.com.ui.mouselistener.wang;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cn.com.ui.wang.AddGoodsFrame;

public class AddGoodsFrame_joinGoods_MouseListener implements MouseListener {
	private AddGoodsFrame af;
	public AddGoodsFrame_joinGoods_MouseListener(AddGoodsFrame af){
		this.af = af;
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		AddGoodsFrameMouseService ms = new AddGoodsFrameMouseService(af);
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
