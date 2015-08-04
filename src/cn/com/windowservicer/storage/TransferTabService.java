package cn.com.windowservicer.storage;

import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import cn.com.beans.liu.GoodsBeans;
import cn.com.beans.liu.MoveBeans;
import cn.com.beans.view.liu.TransferView;
import cn.com.service.storage.TransferServiceImpl;
import cn.com.service.storage.TransferServiceInf;
import cn.com.window.storagement.JFrameTransfer;

public class TransferTabService {
	private JFrameTransfer jFtransfer;
	public TransferTabService(JFrameTransfer jFtransfer) {
		// TODO Auto-generated constructor stub
		this.jFtransfer = jFtransfer;
	}

	public void getAction(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj==jFtransfer.getTab_list()) {
			initTabgoods(e);
		}
	}

	private void initTabgoods(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount()==2) {
			int row = jFtransfer.getTab_list().getSelectedRow();
			// int col = appgood.getTabView().getSelectedColumn();
			String moveId = (String) jFtransfer.getTab_list().getValueAt(row, 0);
			MoveBeans moveb = new MoveBeans();
			moveb.setMove_id(moveId);
			jFtransfer.getTxt_moveId().setText(moveId);
			TransferServiceInf tranS = new TransferServiceImpl();
			List<TransferView> glist = tranS.getGoodsByMid(moveb);

			// TODO Auto-generated method stub
			Vector<String> title = new Vector<String>();
			title.add("商品编号");
			title.add("商品名称");
			title.add("数量");
			title.add("单位");
			title.add("规格");
			title.add("生产厂商");
			Vector data = new Vector();
			Vector row1 = null;
			GoodsBeans gb = null;
			MoveBeans mb = null;
			for(TransferView tV:glist) {
				row1 = new Vector();
				gb =  tV.getGoodsb();
				mb = tV.getMovesb();
				row1.add(gb.getGoods_id());
				row1.add(gb.getGoods_name());
				row1.add(mb.getMove_number());
				row1.add(gb.getGoods_unit());
				row1.add(gb.getGoods_spft());
				row1.add(gb.getGoods_manufacture());
				data.add(row1);
				
			}
			DefaultTableModel dtmView = new DefaultTableModel(data, title);
			jFtransfer.geTtab_goodsmag().setModel(dtmView);
		}
	}

}
