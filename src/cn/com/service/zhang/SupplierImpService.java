package cn.com.service.zhang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import cn.com.view.zhang.SuppManagerImp;
import cn.com.view.zhang.SupplierImp;

public class SupplierImpService implements ActionListener {
	private  SupplierImp supi;
	
	private SupplierImpServiceListener service;

	public SupplierImpService(SupplierImp supi) {
		this.supi = supi;
		
		service = new SupplierImpServiceListener(supi);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new SuppManagerImp();
	}

}
