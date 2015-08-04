package cn.com.windowservicer.storage;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import cn.com.window.storagement.InfoFrame;

public class InfoFrame_btn_Service {
	private InfoFrame inF;
	
	public InfoFrame_btn_Service(InfoFrame inF) {
		this.inF = inF;
	}
	public void getAction(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==inF.getBtnConfirm()) {
			confirm();
			
		}
		if(obj==inF.getBtnExit()) {
			InfoFrame.flag = 0;
			inF.dispose();

		}
	}
	private void confirm() {
		// TODO Auto-generated method stub
		float warehouseNum = Float.parseFloat(inF.getLblStockValue().getText());
		float number = Float.parseFloat(inF.getTxtAmount().getText());
		if(warehouseNum<number) {
			new JOptionPane().showMessageDialog(null, "库存量少于调拨量", "系统信息", JOptionPane.INFORMATION_MESSAGE);
		}else {
			InfoFrame.flag = 1;
			inF.dispose();
		}
	}
}
