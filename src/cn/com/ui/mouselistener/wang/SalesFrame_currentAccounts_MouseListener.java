package cn.com.ui.mouselistener.wang;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cn.com.ui.wang.SalesFrame;

public class SalesFrame_currentAccounts_MouseListener implements MouseListener {
	private SalesFrame sf;
	public SalesFrame_currentAccounts_MouseListener(SalesFrame sf){
		this.sf = sf;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		SalesFrameMouseListenerService ms = new SalesFrameMouseListenerService(sf);
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
