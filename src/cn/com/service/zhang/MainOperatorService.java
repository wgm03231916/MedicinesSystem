package cn.com.service.zhang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.com.view.zhang.MainView;
import cn.com.view.zhang.OperatorView;
import cn.com.view.zhang.SupplierImp;

public class MainOperatorService implements ActionListener {
	private  MainView mv;
	
	private MainOperatorServiceListener service;

	public MainOperatorService(MainView mv) {
		this.mv = mv;
		
		service = new MainOperatorServiceListener(mv);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new OperatorView();
	}

}
