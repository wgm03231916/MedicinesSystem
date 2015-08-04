package cn.com.windowlistener.storage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cn.com.window.storagement.JFrameTransfer;
import cn.com.windowservicer.storage.TransferFrameService;

public class TransferFrame_btn_mouseListener implements MouseListener{
	private JFrameTransfer jFtransfer;
	private TransferFrameService trans;
	
	public TransferFrame_btn_mouseListener(JFrameTransfer jFtransfer) {
		this.jFtransfer =  jFtransfer;
		trans = new TransferFrameService(jFtransfer);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		trans.getAction(e);
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
