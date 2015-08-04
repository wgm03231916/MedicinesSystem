package cn.com.service.zhang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.com.beans.GoodsBean;
import cn.com.view.zhang.ChangePriceView;
import cn.com.view.zhang.ChangeProductPrice;

public class ChangePriceViewService implements ActionListener {
	ChangePriceView cpv;
	//BigAllBean bean;
	GoodsBean bean;
	private ChangePriceViewServiceListener service;
	public ChangePriceViewService(ChangePriceView cpv){
		this.cpv = cpv;
		
		service = new ChangePriceViewServiceListener(cpv);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new ChangeProductPrice(cpv,bean);
	}

}
