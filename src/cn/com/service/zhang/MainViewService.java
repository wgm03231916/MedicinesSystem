package cn.com.service.zhang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.com.view.zhang.MainView;
import cn.com.view.zhang.SuppManagerImp;
import cn.com.view.zhang.SupplierImp;


public class MainViewService implements ActionListener {
	private MainView mf;
	
	private MainViewServiceListener service;

	public MainViewService(MainView mf) {
		this.mf = mf;
		
		service = new MainViewServiceListener(mf);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new SupplierImp();
	}

}
