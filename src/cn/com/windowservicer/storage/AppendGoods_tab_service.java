package cn.com.windowservicer.storage;

import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import cn.com.beans.liu.GoodsBeans;
import cn.com.beans.view.liu.TransferView;
import cn.com.window.storagement.AppendGoods;
import cn.com.window.storagement.InfoFrame;

public class AppendGoods_tab_service {
	private AppendGoods appgood;
	private InfoFrame inF;

	public AppendGoods_tab_service(AppendGoods appgood) {
		this.appgood = appgood;
	}

	public void getAction(MouseEvent e) {
		Object obj = e.getSource();
		if (obj == appgood.getTabView()) {
			tab1Clicked(e);
		}
		if (obj == appgood.getTabView2()) {
			tab2Clicked(e);
		}
		
		
	}

	private void tab1Clicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int count = e.getClickCount();
		if(count==2) {
			int row = appgood.getTabView().getSelectedRow();
			//int col = appgood.getTabView().getSelectedColumn();
			String goods_id=(String)appgood.getTabView().getValueAt(row,0);
			GoodsBeans goods = new GoodsBeans();
			goods.setGoods_id(goods_id);
			inF = new InfoFrame(goods,appgood.getWarehouseb());
			inF.setVisible(true);
			//System.out.println(inF.getvList().getGoodsb().getGoods_id());
			initTable();
		}
	}

	private void initTable() {
		// TODO Auto-generated method stub
		Vector<String> title=new Vector<String>();
		title.add("商品编号");
		title.add("商品名称");
		title.add("单位");
		title.add("产品规格");
		title.add("生产厂商");
		title.add("数量");
		Vector data = new Vector();
		Vector row=new Vector();
		TransferView transferV = inF.getvList();
		row.add(transferV.getGoodsb().getGoods_id());
		row.add(transferV.getGoodsb().getGoods_name());
		row.add(transferV.getGoodsb().getGoods_unit());
		row.add(transferV.getGoodsb().getGoods_spft());
		row.add(transferV.getGoodsb().getGoods_manufacture());
		row.add(transferV.getMovesb().getMove_number());
		data.add(row);
		DefaultTableModel dtmView=new DefaultTableModel(data,title);
		appgood.getTabView2().setModel(dtmView);
	}

	private void tab2Clicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
