package cn.com.view.zhang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.com.beans.GoodsBean;
import cn.com.beans.zhang.BigAllBean;
import cn.com.daos.zhang.MedicineDAOImpl;
import cn.com.daos.zhang.MedicineDAoInf;

public class ChangePriceView extends JFrame{
	private  JPanel pnlMain;
	private JLabel label;
	private JLabel label2;
	private JTextField jText;
	private JTextField jText2;
	private JTable tabView;
	private DefaultTableModel dtmView;
	private JScrollPane snpView;
	private JButton AddBtn;
	private JButton delBtn;
	private JButton updBtn;
	private JButton seaBtn;
	private JButton seaBtn1;
	
	public  ChangePriceView(){
		pnlMain = new JPanel(null);
		label = new JLabel("请选择仓库:");
		jText = new JTextField();
		label2 = new JLabel("请输入商品编号/名称:");
		jText2 = new JTextField();
		AddBtn = new JButton("增加");
		delBtn = new JButton("删除");
		updBtn = new JButton("修改");
		seaBtn = new JButton("查找");
		seaBtn1 = new JButton("查找");
		tabView=new JTable(){
 		   @Override
 		public boolean isCellEditable(int row, int column) {
 			// TODO Auto-generated method stub
 			return false;
 		}
 	   };
 	   snpView=new JScrollPane();
		
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(800, 600);
		
		AddBtn.setBounds(50, 30, 80,30);
		delBtn.setBounds(180, 30, 80, 30);
		updBtn.setBounds(310, 30, 80, 30);
		seaBtn.setBounds(440, 30, 80, 30);
		label.setBounds(30, 90, 150, 30);
		jText.setBounds(100, 90, 120, 30);
		label2.setBounds(300, 90, 150, 30);
		jText2.setBounds(430, 90,150, 30);
		seaBtn1.setBounds(600, 90, 80,30);
		
		snpView.getViewport().add(tabView);
		snpView.setBounds(0, 140, 800,570);
		pnlMain.add(snpView);
		pnlMain.add(AddBtn);
		pnlMain.add(delBtn);
		pnlMain.add(updBtn);
		pnlMain.add(seaBtn);
		pnlMain.add(seaBtn1);
		pnlMain.add(label);
		pnlMain.add(label2);
		pnlMain.add(jText);
		pnlMain.add(jText2);
		
		this.add(pnlMain);
		updBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				updBtn_actionPerformed(e);
					 
			}

			
			
		});
		
		setTableData();
		
		this.setVisible(true);
	}
	private void updBtn_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = tabView.getSelectedRow();
		String id = (String)tabView.getValueAt(row, 0);
		String name = (String)tabView.getValueAt(row, 1);
		String codes = (String)tabView.getValueAt(row, 3);
		String price = (String)tabView.getValueAt(row, 8);
		BigAllBean bean = new BigAllBean();
		GoodsBean gb = new GoodsBean();
		gb.setGoods_id(id);
		gb.setGoods_Name(name);
		gb.setGoods_codes(codes);
		gb.setGoods_price(Float.parseFloat(price));
		new ChangeProductPrice(this,gb);
	}
	public void setTableData() {
		// TODO Auto-generated method stub
		Vector<String> title=new Vector<String>();
		title.add("商品编号");
		title.add("商品名称");
		title.add("所属类别");
		title.add("商品条码");
		title.add("商品单位");
		title.add("商品规格");
		title.add("批准文号");
		title.add("预设进价");
		title.add("预设售价");
		title.add("生产厂商");
		title.add("备注");
		Vector data=new Vector();
		dtmView=new DefaultTableModel(data,title);
		this.tabView.setModel(this.dtmView);
		
		Vector row =null;
		MedicineDAoInf mdao=new MedicineDAOImpl();
		List<BigAllBean> list=mdao.getAllGoodsInfo();
		for(BigAllBean b:list){
			row=new Vector();
					row.add(b.getGb().getGoods_id());
					row.add(b.getGb().getGoods_Name());
					row.add(b.getGb().getGoods_type());
					row.add(b.getGb().getGoods_codes());
					row.add(b.getGb().getGoods_unit());
					row.add(b.getGb().getGoods_spft());
					row.add(b.getGb().getGoods_Apvlnum());
					row.add(b.getGb().getGoods_setting());
					row.add(b.getGb().getGoods_price());
					row.add(b.getGb().getGood_manufacture());
					row.add(b.getGb().getGoods_note());
					
					dtmView.addRow(row);
		}
		this.tabView.setModel(this.dtmView);
	}
}
