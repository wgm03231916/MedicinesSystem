package cn.com.ui.mouselistener.wang;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cn.com.ui.wang.GoodsMarketFrame;

//���ҩƷ��������¼�
public class GoodsMarketFrame_addgoods_MouseListener implements MouseListener {
	
	private GoodsMarketFrame gf;
	public GoodsMarketFrame_addgoods_MouseListener(GoodsMarketFrame gf){
		this.gf = gf;
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		GoodsMarketFrameMouseService ms = new GoodsMarketFrameMouseService(gf);
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
