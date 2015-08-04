package cn.com.listener.huang;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import cn.com.beans.huang.BigAllBean;
import cn.com.daos.huang.MedicineDaoImp;
import cn.com.views.huang.appendGoods;

public class addViewNewly_MouseListener implements MouseListener {
	 private appendGoods app;
     public addViewNewly_MouseListener(appendGoods app){
    	 this.app=app;
     }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
        
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		app.lblNewlyGoods.setOpaque(true);
		app.lblNewlyGoods.setBackground(Color.white);
		Vector<String> title=new Vector<String>();
		title.add("商品编号");
		title.add("商品名称");
		title.add("数量");
		title.add("单价");
		title.add("单位");
		title.add("规格");
        title.add("进货日期");
		
		Vector data=new Vector();
		app.dtmView=new DefaultTableModel(data,title);
		MedicineDaoImp dao=new MedicineDaoImp();
		Vector row =null;
		List<BigAllBean> list=dao.getNewlyInfo();
		for(BigAllBean b:list){
			row=new Vector();
			row.add(b.getGb().getGoods_id());
			row.add(b.getGb().getGoods_Name());
			row.add(b.getOb().getGoods_num());
			row.add(b.getGb().getGoods_setting());
			row.add(b.getGb().getGoods_unit());
			row.add(b.getGb().getGoods_spft());
			row.add(b.getJb().getOrder_date());
			app.dtmView.addRow(row);	
		}
			app.tabView.setModel(app.dtmView);
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
		app.lblNewlyGoods.setOpaque(true);
		app.lblNewlyGoods.setBackground(null);
	}

}
