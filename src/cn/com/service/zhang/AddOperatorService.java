package cn.com.service.zhang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.com.beans.zhang.BigAllBean;
import cn.com.view.zhang.AddOperatorView;
import cn.com.view.zhang.OperatorManaView;

public class AddOperatorService implements ActionListener {
	private  OperatorManaView operator;
	private BigAllBean bean;
	
	private AddOperatorServicListener service;

	public AddOperatorService(OperatorManaView operator) {
		// TODO Auto-generated constructor stub
		this.operator = operator;
		service = new AddOperatorServicListener(operator);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new AddOperatorView(operator);
	}

}
