package cn.com.windowlistener.storage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cn.com.window.storagement.JFrameMain;
import cn.com.windowservicer.storage.MainFrameMouseService;

public class MainFrame_btn_mouseListener implements MouseListener{
	private JFrameMain jFmain;
	private MainFrameMouseService ms ;
	
	public MainFrame_btn_mouseListener(JFrameMain jFmain) {
		this.jFmain = jFmain;
		ms = new MainFrameMouseService(jFmain);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		 ms.getAction(e);
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
