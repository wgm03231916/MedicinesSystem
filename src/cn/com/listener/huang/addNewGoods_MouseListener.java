package cn.com.listener.huang;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;

import cn.com.views.huang.BuyOutView;
import cn.com.views.huang.THGoods;
import cn.com.views.huang.appendGoods;

public class addNewGoods_MouseListener extends MouseAdapter {
     private BuyOutView bov;
     public addNewGoods_MouseListener(BuyOutView bov){
    	 this.bov=bov;
     }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
        
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		bov.btnOldGoods.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.gray));
		
		new THGoods(bov);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		bov.btnOldGoods.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.gray));
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
