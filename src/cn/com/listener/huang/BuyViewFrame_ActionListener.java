package cn.com.listener.huang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.com.views.huang.BuyInView;

public class BuyViewFrame_ActionListener implements ActionListener {
    private BuyInView biv;
    public BuyViewFrame_ActionListener(BuyInView biv){
    	this.biv=biv;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
          biv.BtnSupply(e);
	}

}
