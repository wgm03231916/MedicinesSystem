package cn.com.windowservicer.storage;

import java.awt.event.MouseEvent;

import cn.com.window.storagement.JFrameLoss;
import cn.com.window.storagement.JFrameMain;
import cn.com.window.storagement.JFramePasttime;
import cn.com.window.storagement.JFrameStorage;
import cn.com.window.storagement.JFrameTransfer;

public class MainFrameMouseService {
	private JFrameMain jFmain;
	
	public MainFrameMouseService(JFrameMain jFmain) {
		this.jFmain = jFmain;
	}

	public void getAction(MouseEvent e){
		Object obj = e.getSource();
		if (obj ==  jFmain.getBtn_transfer()) {
			 tranfer();
		}
		if( obj == jFmain.getBtn_change()) {
			change();
		}
		if (obj ==  jFmain.getBtn_search()) {
			 search();
		}
		if (obj ==  jFmain.getBtn_loss()) {
			 loss();
		}
	}

	private void loss() {
		// TODO Auto-generated method stub
		JFrameLoss jFloss = new JFrameLoss();
		jFloss.setResizable(false);
		jFloss.setVisible(true);
	}

	private void search() {
		// TODO Auto-generated method stub
		JFramePasttime jFpast = new JFramePasttime();
		jFpast.setResizable(false);
		jFpast.setVisible(true);
	}

	private void change() {
		// TODO Auto-generated method stub
		JFrameStorage jFstorage = new JFrameStorage();
		jFstorage.setResizable(false);
		jFstorage.setVisible(true);
	}

	private void tranfer() {
		// TODO Auto-generated method stub
		JFrameTransfer jFtransfer = new JFrameTransfer();
		jFtransfer.setResizable(false);
		jFtransfer.setVisible(true);
	}
	
	
	
}
