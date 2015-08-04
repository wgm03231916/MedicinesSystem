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

import cn.com.beans.zhang.BigAllBean;
import cn.com.daos.zhang.MedicineDAOImpl;
import cn.com.daos.zhang.MedicineDAoInf;
import cn.com.service.zhang.AddSupplierService;


public class SuppManagerImp extends JFrame{
	private  JPanel pnlMain;
	private JLabel label;
	private JTextField jText;
	private JTable tabView;
	private DefaultTableModel dtmView;
	private JScrollPane snpView;
	private JButton AddBtn;
	private JButton delBtn;
	private JButton updBtn;
	private JButton seaBtn;
	private JButton seaBtn1;
	private SuppManagerImp smi;;
	public  SuppManagerImp(){
		pnlMain = new JPanel(null);
		label = new JLabel("请输入供货商相关信息:");
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
		jText = new JTextField();
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
		label.setBounds(70, 90, 150, 30);
		jText.setBounds(210, 90, 280, 30);
		seaBtn1.setBounds(500, 90, 80,30);
		
		AddBtn.addActionListener(new AddSupplierService(this));
		updBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				updBtn_actionPerformed(e);
					 
			}
			
		});
		
		delBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				delBtn_actionPerformed(e);
			}

			
			
		});

		
		snpView.getViewport().add(tabView);
		snpView.setBounds(10, 140, 800,570);
		pnlMain.add(snpView);
		pnlMain.add(AddBtn);
		pnlMain.add(delBtn);
		pnlMain.add(updBtn);
		pnlMain.add(seaBtn);
		pnlMain.add(seaBtn1);
		pnlMain.add(label);
		pnlMain.add(jText);
		this.add(pnlMain);
		setTableData();
		this.setVisible(true);
	}
	
	private void updBtn_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = tabView.getSelectedRow();
		BigAllBean id = (BigAllBean)tabView.getValueAt(row, 1);
		AddSupplierView upd = new AddSupplierView(this,id);
	}
	
	private void delBtn_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = tabView.getSelectedRow();
		BigAllBean id = (BigAllBean)tabView.getValueAt(row, 1);
		//AddSupplierView del = new AddSupplierView(this,id);
		MedicineDAoInf dao=new MedicineDAOImpl();
		if(dao.delSupplierInfo(id)){
			setTableData();
			
		}
	}

	public void setTableData() {
		// TODO Auto-generated method stub
		Vector<String> title=new Vector<String>();
		title.add("编号");
		title.add("供货商名称");
		title.add("联系人");
		title.add("联系电话");
		title.add("联系地址");
		title.add("备注");
		Vector data=new Vector();
		dtmView=new DefaultTableModel(data,title);
		Vector row =null;
		MedicineDAoInf mdao=new MedicineDAOImpl();
		List<BigAllBean> list=mdao.getAllSupplierInfo();
		for(BigAllBean b:list){
			row=new Vector();
			row.add(b.getSb().getSupplier_id());
			row.add(b);
			row.add(b.getSb().getSupplier_contact());
			row.add(b.getSb().getSupplier_tel());
			row.add(b.getSb().getSupplier_addr());
			row.add(b.getSb().getSupplier_note());
			dtmView.addRow(row);
		}
		this.tabView.setModel(this.dtmView);
	}

}
