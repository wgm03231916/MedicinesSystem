package cn.com.service.zhang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.com.beans.EmployeeBean;
import cn.com.beans.zhang.BigAllBean;
import cn.com.view.zhang.OperatorManaView;
import cn.com.view.zhang.UdpOperatorView;

public class UpdOperatorService implements ActionListener {
	private  OperatorManaView operator;
	private BigAllBean bean;
	private EmployeeBean eb;
	
	private UpdOperatorServicListener service;

	public UpdOperatorService(OperatorManaView operator,EmployeeBean eb) {
		// TODO Auto-generated constructor stub
		this.operator = operator;
		this.eb = eb;
		service = new UpdOperatorServicListener(operator);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new UdpOperatorView(operator,eb);
	}

}
