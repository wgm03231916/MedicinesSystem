package cn.com.windowlistener.storage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cn.com.window.storagement.InfoFrame;
import cn.com.windowservicer.storage.InfoFrame_btn_Service;

public class InfoFrame_btn_mouseListener implements MouseListener {
	private InfoFrame inF;
	private InfoFrame_btn_Service inBtn;
	
	public InfoFrame_btn_mouseListener(InfoFrame inF) {
		this.inF = inF;
		inBtn = new InfoFrame_btn_Service(inF);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		inBtn.getAction(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
