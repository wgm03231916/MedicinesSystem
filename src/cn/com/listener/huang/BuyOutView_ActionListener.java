package cn.com.listener.huang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.com.views.huang.AccountItemFrame;
import cn.com.views.huang.AccountItemFrame2;

public class BuyOutView_ActionListener implements ActionListener {
	 private AccountItemFrame2 af;
	    public BuyOutView_ActionListener(AccountItemFrame2 af){
	    	this.af=af;
	    }
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
	          af.btnSureAction(e);
		}

}
