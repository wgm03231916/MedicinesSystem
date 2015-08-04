package cn.com.windowlistener.storage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cn.com.window.storagement.AppendGoods;
import cn.com.windowservicer.storage.AppendGoods_tab_service;

public class AppendGoods_tab_listener implements MouseListener {
	private AppendGoods appgood;
	private AppendGoods_tab_service aptservice;
	
	public AppendGoods_tab_listener(AppendGoods appgood) {
		this.appgood = appgood;
		aptservice = new AppendGoods_tab_service(appgood);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		aptservice.getAction(e);
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
