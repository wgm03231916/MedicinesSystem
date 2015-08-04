package cn.com.service.zhang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.com.view.zhang.ChangePriceView;
import cn.com.view.zhang.MainView;

public class MainChangePriceService implements ActionListener {
	MainView mv;
	private MainChangePriceServiceListener service;
	public MainChangePriceService(MainView mv){
		this.mv = mv;
		service = new MainChangePriceServiceListener(mv);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new ChangePriceView();
	}

}
