package cn.com.ui.mouselistener.wang;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cn.com.ui.wang.GoodsMarketFrame;
import cn.com.ui.wang.SalesFrame;
//商品销售的鼠标点击事件
public class SalesFrame_goodsMarket_MouseListener implements MouseListener {
	private SalesFrame mf;
	public SalesFrame_goodsMarket_MouseListener(SalesFrame mf){
		this.mf = mf;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		SalesFrameMouseService ms = new SalesFrameMouseService(mf);
		
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
