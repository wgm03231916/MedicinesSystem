package cn.com.service.zhang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.com.view.zhang.OperatorManaView;
import cn.com.view.zhang.OperatorView;

public class OperatorImpService implements ActionListener {
	OperatorView ov;
	private OperatorImpServiceListener service;
	public OperatorImpService(OperatorView ov) {
		// TODO Auto-generated constructor stub
		this.ov = ov;
		service = new OperatorImpServiceListener(ov);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new OperatorManaView();
	}

}
