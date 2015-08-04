package cn.com.listener.huang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.com.views.huang.AccountItemFrame;

public class BuyInView_ActionListener implements ActionListener {
    private AccountItemFrame af;
    public BuyInView_ActionListener(AccountItemFrame af){
    	this.af=af;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
          af.btnSureAction(e);
	}

}
