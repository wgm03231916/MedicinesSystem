package cn.com.service.zhang;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;

import cn.com.view.zhang.SupSerachView;
import cn.com.view.zhang.SupplierImp;

public class SupSearchFrame implements ActionListener {
	 private SupplierImp sup;
	    
	 private SearchFrame_ActionListener_service sf;
	 public SupSearchFrame(SupplierImp sup){
	    	this.sup=sup;
	    	sf=new SearchFrame_ActionListener_service(sup);
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new SupSerachView(sup);
	}

}
