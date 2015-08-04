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
import javax.swing.table.DefaultTableModel;

import cn.com.beans.EmployeeBean;
import cn.com.beans.zhang.BigAllBean;
import cn.com.daos.zhang.MedicineDAOImpl;
import cn.com.daos.zhang.MedicineDAoInf;
import cn.com.service.zhang.AddOperatorService;




public class OperatorManaView extends JFrame{
	private  JPanel pnlMain;
	private JLabel label;
	private JTable tabView;
	private DefaultTableModel dtmView;
	private JScrollPane snpView;
	private JButton AddBtn;
	private JButton delBtn;
	private JButton updBtn;
	private JButton seaBtn;
	private JButton seaBtn1;
	
	public  OperatorManaView(){
		pnlMain = new JPanel(null);
		AddBtn = new JButton("增加");
		delBtn = new JButton("删除");
		updBtn = new JButton("修改");
		seaBtn = new JButton("查找");
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
		this.setTitle("员工信息");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(615, 370);
		
		AddBtn.setBounds(50, 30, 80,30);
		delBtn.setBounds(180, 30, 80, 30);
		updBtn.setBounds(310, 30, 80, 30);
		seaBtn.setBounds(440, 30, 80, 30);
		
		AddBtn.addActionListener(new AddOperatorService(this));
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
		snpView.setBounds(0, 80, 600,370);
		pnlMain.add(snpView);
		pnlMain.add(AddBtn);
		pnlMain.add(delBtn);
		pnlMain.add(updBtn);
		pnlMain.add(seaBtn);
		this.add(pnlMain);
		setTableData();
		this.setVisible(true);
	}
	private void updBtn_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = tabView.getSelectedRow();
		String id = (String)tabView.getValueAt(row, 0);
		String name = (String)tabView.getValueAt(row, 1);
		String title = (String)tabView.getValueAt(row, 2);
		String tel = (String)tabView.getValueAt(row, 3);
		String addre = (String)tabView.getValueAt(row, 4);
		String note = (String)tabView.getValueAt(row,5);
		//AddSupplierView del = new AddSupplierView(this,id);
		MedicineDAoInf dao=new MedicineDAOImpl();
		EmployeeBean ob = new EmployeeBean();
		ob.setEmployee_id(id);
		ob.setEmployee_name(name);
		ob.setEmployee_title(title);
		ob.setEmployee_tel(tel);
		ob.setEmployee_addr(addre);
		ob.setEmployee_note(note);
		UdpOperatorView uov = new UdpOperatorView(this,ob);
	}
	private void delBtn_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = tabView.getSelectedRow();
		String id = (String)tabView.getValueAt(row, 0);
		String name = (String)tabView.getValueAt(row, 1);
		String title = (String)tabView.getValueAt(row, 2);
		String tel = (String)tabView.getValueAt(row, 3);
		String addre = (String)tabView.getValueAt(row, 4);
		String note = (String)tabView.getValueAt(row,5);
		//AddSupplierView del = new AddSupplierView(this,id);
		MedicineDAoInf dao=new MedicineDAOImpl();
		EmployeeBean ob = new EmployeeBean();
		ob.setEmployee_id(id);
		ob.setEmployee_name(name);
		ob.setEmployee_title(title);
		ob.setEmployee_tel(tel);
		ob.setEmployee_addr(addre);
		ob.setEmployee_note(note);
		
		if(dao.delOperatorInfo(ob)){
			setTableData();
			
		}
	}

	public  void setTableData() {
		// TODO Auto-generated method stub
		Vector<String> title=new Vector<String>();
		title.add("编号");
		title.add("员工姓名");
		title.add("职位");
		title.add("联系电话");
		title.add("联系地址");
		title.add("备注");
		Vector data=new Vector();
		dtmView=new DefaultTableModel(data,title);
		Vector row =null;
		MedicineDAoInf mdao=new MedicineDAOImpl();
		List<BigAllBean> list=mdao.getAllOperatorInfo();
		for(BigAllBean b:list){
			row=new Vector();
			row.add(b.getEb().getEmployee_id());
			row.add(b.getEb().getEmployee_name());
			row.add(b.getEb().getEmployee_title());
			row.add(b.getEb().getEmployee_tel());
			row.add(b.getEb().getEmployee_addr());
			row.add(b.getEb().getEmployee_note());
			dtmView.addRow(row);
		}
		this.tabView.setModel(this.dtmView);
	}
}
