package cn.com.listener.huang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.com.views.huang.BuyOutView;

public class TViewFrame_ActionListener implements ActionListener {
    private BuyOutView bov;
    public TViewFrame_ActionListener(BuyOutView bov){
    	this.bov=bov;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		bov.BtnSupply(e);
	}

}
