package cn.com.windowlistener.storage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cn.com.window.storagement.JFrameTransfer;
import cn.com.windowservicer.storage.TransferFrameService;
import cn.com.windowservicer.storage.TransferTabService;

public class Transfer_tab_listener implements MouseListener {
	private JFrameTransfer jFtransfer;
	private TransferTabService tranTab;
	
	public Transfer_tab_listener(JFrameTransfer jFtransfer) {
		this.jFtransfer =  jFtransfer;
		tranTab = new TransferTabService(jFtransfer);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		tranTab.getAction(e);
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
