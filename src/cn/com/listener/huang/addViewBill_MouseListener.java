package cn.com.listener.huang;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cn.com.views.huang.appendGoods;

public class addViewBill_MouseListener implements MouseListener {
     private appendGoods app;
     public addViewBill_MouseListener(appendGoods app){
    	 this.app=app;
     }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
             
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		app.lblBillGoods.setOpaque(true);
		app.lblBillGoods.setBackground(Color.white);
		app.setTabData();

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
		app.lblBillGoods.setOpaque(true);
		app.lblBillGoods.setBackground(null);
	}

}
