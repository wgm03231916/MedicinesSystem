package cn.com.service.zhang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.com.beans.zhang.BigAllBean;
import cn.com.view.zhang.AddSupplierView;
import cn.com.view.zhang.SuppManagerImp;


public class AddSupplierService implements ActionListener {
	private  SuppManagerImp smi;
	private BigAllBean bean;
	
	private AddSupplierServicListener service;

	public AddSupplierService(SuppManagerImp smi) {
		this.smi = smi;
		
		service = new AddSupplierServicListener(smi);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new AddSupplierView(smi, null);
	}

}
