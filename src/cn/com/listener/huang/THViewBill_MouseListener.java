package cn.com.listener.huang;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cn.com.views.huang.THGoods;

public class THViewBill_MouseListener implements MouseListener {
     private THGoods app;
     public THViewBill_MouseListener(THGoods app){
    	 this.app=app;
     }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
             
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		app.lblBillGoods.setOpaque(true);
		app.lblBillGoods.setBackground(Color.white);
		app.setTabData();
//		MedicineDaoImp dao=new MedicineDaoImp();
//		Vector row =null;
//		List<BigAllBean> list=dao.getBillInfo();
//		for(BigAllBean b:list){
//			row=new Vector();
//			row.add(b.getGb().getGoods_id());
//			row.add(b.getGb().getGoods_Name());
//			row.add(b.getGb().getGoods_unit());
//			row.add(b.getGb().getGoods_spft());
//			row.add(b.getGb().getGoods_setting());
//			row.add(b.getHc().getGoods_num());
//			row.add(b.getGb().getGood_manufacture());
//			app.dtmView.addRow(row);	
//		}
//		app.tabView.setModel(app.dtmView);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		app.lblBillGoods.setOpaque(true);
		app.lblBillGoods.setBackground(null);
	}

}
