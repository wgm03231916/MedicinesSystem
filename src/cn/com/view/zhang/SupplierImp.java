package cn.com.view.zhang;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
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
import cn.com.service.zhang.SupSearchFrame;
import cn.com.service.zhang.SupplierImpService;

public class SupplierImp extends JFrame{
	private  JTable tableView;
	public JTable getTableView() {
		return tableView;
	}

	public void setTableView(JTable tableView) {
		this.tableView = tableView;
	}

	public JTable getTableView1() {
		return tableView1;
	}

	public void setTableView1(JTable tableView1) {
		this.tableView1 = tableView1;
	}

	public DefaultTableModel getDtmView() {
		return dtmView;
	}

	public void setDtmView(DefaultTableModel dtmView) {
		this.dtmView = dtmView;
	}

	public DefaultTableModel getDtmView1() {
		return dtmView1;
	}

	public void setDtmView1(DefaultTableModel dtmView1) {
		this.dtmView1 = dtmView1;
	}

	public JScrollPane getSnpView() {
		return snpView;
	}

	public void setSnpView(JScrollPane snpView) {
		this.snpView = snpView;
	}

	public JScrollPane getSnpView1() {
		return snpView1;
	}

	public void setSnpView1(JScrollPane snpView1) {
		this.snpView1 = snpView1;
	}

	private  JTable tableView1;
	private DefaultTableModel dtmView;
	private DefaultTableModel dtmView1;
	private JScrollPane snpView;
	private JScrollPane snpView1;
	private JPanel pnlMain;
	private JPanel pnlMainT;
	private JPanel pnlMainR;
    private JPanel pnlMainL;
	private JLabel label;
	private JLabel labelManage;
	private JLabel labelName;
	public JLabel getLabelName() {
		return labelName;
	}

	public void setLabelName(JLabel labelName) {
		this.labelName = labelName;
	}

	public JLabel getLabelName1() {
		return labelName1;
	}

	public void setLabelName1(JLabel labelName1) {
		this.labelName1 = labelName1;
	}

	

	public JLabel getLabelPhone() {
		return labelPhone;
	}

	public void setLabelPhone(JLabel labelPhone) {
		this.labelPhone = labelPhone;
	}

	public JLabel getLabelPhone1() {
		return labelPhone1;
	}

	public void setLabelPhone1(JLabel labelPhone1) {
		this.labelPhone1 = labelPhone1;
	}

	public JLabel getLabelAddress() {
		return labelAddress;
	}

	public void setLabelAddress(JLabel labelAddress) {
		this.labelAddress = labelAddress;
	}

	public JLabel getLabelAddress1() {
		return labelAddress1;
	}
 
	public void setLabelAddress1(JLabel labelAddress1) {
		this.labelAddress1 = labelAddress1;
	}

	private JLabel labelName1;
	private JLabel labelContact;
	public JLabel getLabelContact() {
		return labelContact;
	}

	public void setLabelContact(JLabel labelContact) {
		this.labelContact = labelContact;
	}

	public JLabel getLabelContact1() {
		return labelContact1;
	}

	public void setLabelContact1(JLabel labelContact1) {
		this.labelContact1 = labelContact1;
	}

	private JLabel labelContact1;
	private JLabel labelPhone;
	private JLabel labelPhone1;
	private JLabel labelAddress;
	private JLabel labelAddress1;
	private JLabel labelCope;
	private JLabel labelCope1;
	private JTextField jText;
	private JButton search;
	private JButton supManage;
	private JButton account;
	private JButton exit;
	private BigAllBean bean;
	public SupplierImp(){
		pnlMain = new JPanel(null);
		pnlMainT = new JPanel(null);
		pnlMainT.setBackground(new Color(240, 248, 255));
		pnlMainR = new JPanel(null) ;
		pnlMainL = new JPanel(null) ;
		snpView = new JScrollPane();
		snpView1 = new JScrollPane();
		tableView=new JTable(){
	   		   @Override
	   		public boolean isCellEditable(int row, int column) {
	   			// TODO Auto-generated method stub
	   			return false;
	   		}
	   	   };
		tableView.setBackground(new Color(230, 230, 250));
	   	tableView1=new JTable(){
			   @Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		   };
	   	tableView1.setBackground(new Color(230, 230, 250));
		
		label = new JLabel("输入供货商名称或编号:");
		labelManage = new JLabel("供货商信息:");
		
		labelName = new JLabel("供货商名称:");
		labelName1 = new JLabel();
		
		labelContact = new JLabel("联    系    人:");
		labelContact1 = new JLabel();
		
		labelPhone = new JLabel("电            话:");
		labelPhone1 = new JLabel();
		
		labelAddress = new  JLabel("供货商地址:");
		labelAddress1 = new  JLabel();
		
		
		jText = new JTextField();
		search = new JButton("查询");
		search.setBackground(new Color(230, 230, 250));
		search.addActionListener(new SupSearchFrame(this));
		supManage = new  JButton("供货商管理");
		supManage.setBackground(new Color(230, 230, 250));
		supManage.addActionListener(new SupplierImpService(this));
		account = new JButton("供货商账务");
		account.setBackground(new Color(230, 230, 250));
		exit = new JButton("退出");
		exit.setBackground(new Color(230, 230, 250));
		
		tableView.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(java.awt.event.MouseEvent e) {   
				  int ow = tableView.getSelectedRow();
				  	String id = (String)tableView.getValueAt(ow, 0);
				  	Vector<String> title=new Vector<String>();
					
					title.add("商品编号");
					title.add("商品名称");
					title.add("单位");
					title.add("单价");
					title.add("数量");
					title.add("总金额");
					Vector data=new Vector();
					SupplierImp.this.dtmView=new DefaultTableModel(data,title);
					Vector row =null;
					MedicineDAoInf mdao=new MedicineDAOImpl();
					List<BigAllBean> list=mdao.getGoodInfo(id);
					for(BigAllBean b:list){
						row=new Vector();
						row.add(b.getGb().getGoods_id());
						row.add(b.getGb().getGoods_Name());
						row.add(b.getGb().getGoods_unit());
						row.add(b.getGb().getGoods_setting());
						row.add(b.getOr().getGoods_num());
						row.add(b.getOr().getOrder_price());
						SupplierImp.this.dtmView.addRow(row);
					}
					SupplierImp.this.tableView1.setModel(SupplierImp.this.dtmView);
					
//					bean = new BigAllBean();
//					SupplierBean gb = new SupplierBean();
//					gb.setSupplier_name(id);
//					
//					bean.setSb(gb);
					
					 

			  }
		});
		setTabData();
	   	setTabData1();
		init();
	}

	private void setTabData() {
		// TODO Auto-generated method stub
		Vector<String> title=new Vector<String>();
		
		title.add("单据号");
		title.add("仓库名称");
		title.add("应付金额");
		//title.add("实付金额");
		title.add("经办人");
		title.add("单据类型");
		Vector data=new Vector();
		dtmView=new DefaultTableModel(data,title);
		this.tableView.setModel(this.dtmView);
	}

	private void setTabData1() {
		// TODO Auto-generated method stub
		Vector<String> title=new Vector<String>();
		
		title.add("商品编号");
		title.add("商品名称");
		title.add("单位");
		title.add("单价");
		title.add("数量");
		title.add("总金额");
		Vector data=new Vector();
		dtmView1=new DefaultTableModel(data,title);
		this.tableView1.setModel(this.dtmView1);
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(970, 547);
		this.setTitle("供货商管理");
		pnlMainL.setBorder(BorderFactory.createTitledBorder("供货商供货情况"));
		//pnlMainN.setBounds(10, 20, 410, 100);
		pnlMainR.setBorder(BorderFactory.createTitledBorder("详细内容"));
		
		pnlMain.add(pnlMainL);
		pnlMain.add(pnlMainR);
		pnlMain.add(pnlMainT);
		pnlMainT.add(label);
		pnlMainT.add(jText);
		pnlMainT.add(search);
		pnlMainT.add(supManage);
		pnlMainT.add(account);
		pnlMainT.add(exit);
		pnlMainT.add(labelManage);
		pnlMainT.add(labelName);
		pnlMainT.add(labelName1);
		pnlMainT.add(labelContact);
		pnlMainT.add(labelContact1);
		pnlMainT.add(labelPhone);
		pnlMainT.add(labelPhone1);
		pnlMainT.add(labelAddress);
		pnlMainT.add(labelAddress1);
		
		pnlMainL.add(snpView);
		pnlMainR.add(snpView1);
		
		pnlMainT.setBounds(0, 0, 1000, 180);
		pnlMainL.setBounds(0, 200, 500, 480);
		pnlMainR.setBounds(500, 200, 500, 480);
		label.setBounds(50, 40, 160, 30);
		jText.setBounds(200, 40, 120,30);
		search.setBounds(340, 40, 80, 30);
		supManage.setBounds(480, 40, 100, 30);
		account.setBounds(620, 40, 100, 30);
		exit.setBounds(780, 40, 80, 30);
		
		labelManage.setBounds(10, 70, 100, 30);
		labelName.setBounds(100, 90, 100, 30);
		labelName1.setBounds(205, 90, 80, 30);
		labelContact.setBounds(600, 90, 80, 30);
		labelContact1.setBounds(685, 90, 60, 30);
		labelPhone.setBounds(100, 120, 100, 30);
		labelPhone1.setBounds(205, 120, 80, 30);
		labelAddress.setBounds(600, 120, 80, 30);
		labelAddress1.setBounds(685, 120, 80, 30);
		snpView1.setViewportView(tableView1);
		snpView1.setBounds(0,20, 500,480);
		snpView.setViewportView(tableView);
		snpView.setBounds(0,20, 500,480);
		getContentPane().add(pnlMain);
		this.setVisible(true);
	}
}

