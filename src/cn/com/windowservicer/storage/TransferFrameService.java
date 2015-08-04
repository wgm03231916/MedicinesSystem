package cn.com.windowservicer.storage;

import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import cn.com.beans.liu.MoveBeans;
import cn.com.service.storage.TransferServiceImpl;
import cn.com.service.storage.TransferServiceInf;
import cn.com.window.storagement.AppendGoods;
import cn.com.window.storagement.JFrameTransfer;

public class TransferFrameService {
	private JFrameTransfer jFTransfer;
	private DefaultTableModel dtmView;
	private List<MoveBeans> mlist;
	
	public TransferFrameService(JFrameTransfer jFTransfer) {
		this.jFTransfer = jFTransfer;
		
	}
	public void getAction(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==jFTransfer.getBtn_add()) {
			add();
		}
		if(obj==jFTransfer.getBtn_change()) {
			
		}
		if(obj==jFTransfer.getBtn_del()) {
			
		}
		if(obj==jFTransfer.getBtn_sch()) {
			searchBydate();
		}
		if(obj==jFTransfer.getBtn_exit2() ) {
			jFTransfer.dispose();
		}
		if(obj==jFTransfer.getBtn_sure()) {
			addMove();
		}
		
	}
	private void addMove() {
		// TODO Auto-generated method stub
		String dbNo = jFTransfer.getTxt_billNo().getText();
		String house1 = jFTransfer.getDcm_from().getModel().getSelectedItem().toString();

		String house2 = jFTransfer.getDcm_go().getModel().getSelectedItem().toString();
		String date = jFTransfer.getTxtDate().getText();
		String gNo = (String)jFTransfer.getTab_goods().getValueAt(0, 0);
		if(house1.equals(house2)) {
			new JOptionPane().showMessageDialog(null, "调出仓库不能与调入仓库相同", "提示信息", JOptionPane.INFORMATION_MESSAGE);
		}else if("".equals(date)) {
			new JOptionPane().showMessageDialog(null, "调拨日期不为空", "提示信息", JOptionPane.INFORMATION_MESSAGE);
		}else if("".equals(gNo)) {
			new JOptionPane().showMessageDialog(null, "单据中没有业务发生", "提示信息", JOptionPane.INFORMATION_MESSAGE);
		}
		int number =Integer.parseInt((String)jFTransfer.getTab_goods().getValueAt(0, 0)) ;
		MoveBeans move = new MoveBeans();
		move.setMove_id(dbNo);
		move.setOut_name(house1);
		move.setIn_name(house2);
		move.setMove_date(date);
		move.setGoods_id(gNo);
		move.setMove_number(number);
		move.setMove_people((String)jFTransfer.getDcm_person().getModel().getSelectedItem());
		move.setMove_note(jFTransfer.getTxt_remark().getText());
		TransferServiceInf tfer = new TransferServiceImpl();
		if(tfer.addMovesServiceInf(move)) {
			new JOptionPane().showMessageDialog(null, "数据保存成功", "提示信息", JOptionPane.INFORMATION_MESSAGE);
			jFTransfer.tableModelinit();
			jFTransfer.txtBillNoinit();
			
		}
		
	}
	private void searchBydate() {
		// TODO Auto-generated method stub
		TransferServiceInf transfer = new TransferServiceImpl();
		mlist = transfer.searchMovesServiceInf(jFTransfer.getTxt_begin().getText(), jFTransfer.getTxt_end().getText());
		initTable1();
	}
	
	private void initTable1() {
		// TODO Auto-generated method stub
		//jFTransfer.getTab_list()
		Vector<String> title = new Vector<String>();
		title.add("调拨单号");
		title.add("调出仓库");
		title.add("调入仓库");
		title.add("调拨日期");
		title.add("经办人");
		title.add("备注");
		Vector data=new Vector();
		Vector v = null;
		for(MoveBeans m :mlist) {
			v = new Vector();
			v.add(m.getMove_id());
			v.add(m.getOut_name());
			v.add(m.getIn_name());
			v.add(m.getMove_date());
			v.add(m.getMove_people());
			v.add(m.getMove_note());
			data.add(v);
		}
		dtmView=new DefaultTableModel(data,title);
		jFTransfer.getTab_list().setModel(this.dtmView);
	}
	private void add() {
		// TODO Auto-generated method stub
		//WarehouseBeans warehoub = (WarehouseBeans) jFTransfer.getDcm_from().getModel().getSelectedItem();
		//System.out.println(warehoub.getWarehouse_name());
		AppendGoods append = new AppendGoods(jFTransfer);
		append.setVisible(true);
		
	}

}
