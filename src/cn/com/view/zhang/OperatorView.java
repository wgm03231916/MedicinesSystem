package cn.com.view.zhang;

import java.awt.ScrollPane;
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

import cn.com.service.zhang.OperatorImpService;
import cn.com.service.zhang.SupSearchFrame;
import cn.com.service.zhang.SupplierImpService;

public class OperatorView extends JFrame{
	private JTable tableView;
	private JTable tableView1;
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
	private JLabel labelName1;
	private JLabel labelContact;
	private JLabel labelContact1;
	private JLabel labelPhone;
	private JLabel labelPhone1;
	private JLabel labelAddress;
	private JLabel labelAddress1;
	private JLabel labelTitle;
	private JLabel labelTitle1;
	private JLabel labelCope;
	private JLabel labelCope1;
	private JTextField jText;
	private JButton search;
	private JButton OpratorManage;
	private JButton account;
	private JButton exit;
	public OperatorView(){
		pnlMain = new JPanel(null);
		pnlMainT = new JPanel(null);
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
	   	tableView1=new JTable(){
			   @Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		   };
		label = new JLabel("输入业务员姓名:");
		labelManage = new JLabel("员工信息:");
		
		labelName = new JLabel("员工姓名:");
		labelName1 = new JLabel();
		
		labelTitle = new JLabel("员工职务:");
		labelTitle1 = new JLabel();
		
		labelPhone = new JLabel("联系电话:");
		labelPhone1 = new JLabel();
		
		labelAddress = new  JLabel("地址:");
		labelAddress1 = new  JLabel();
		
		
		labelCope = new JLabel("我方应付:");
		labelCope1 = new JLabel();
		
		
		
		jText = new JTextField();
		search = new JButton("查询");
		//search.addActionListener(new SupSearchFrame(this));
		OpratorManage = new JButton("业务员管理");
		OpratorManage.addActionListener(new OperatorImpService(this));
		account = new JButton("业务员业绩");
		exit = new JButton("退出");
		setTabData();
	   	setTabData1();
		init();
	}

	private void setTabData1() {
		// TODO Auto-generated method stub
		Vector<String> title=new Vector<String>();
		
		title.add("单据号");
		title.add("仓库名称");
		title.add("应付金额");
		title.add("实付金额");
		title.add("经办人");
		title.add("单据类型");
		Vector data=new Vector();
		dtmView=new DefaultTableModel(data,title);
		this.tableView.setModel(this.dtmView);
	}

	private void setTabData() {
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
		this.setTitle("业务员信息");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1000, 600);
		this.setTitle("业务员管理");
		pnlMainL.setBorder(BorderFactory.createTitledBorder("单据记录"));
		pnlMainR.setBorder(BorderFactory.createTitledBorder("详细内容"));
		label.setBounds(50, 40, 160, 30);
		jText.setBounds(200, 40, 120,30);
		search.setBounds(340, 40, 80, 30);
		OpratorManage.setBounds(480, 40, 100, 30);
		account.setBounds(620, 40, 100, 30);
		exit.setBounds(780, 40, 80, 30);
		
		labelManage.setBounds(10, 70, 100, 30);
		labelName.setBounds(30, 90, 100, 30);
		labelName1.setBounds(120, 90, 100, 30);
		labelTitle.setBounds(250, 90, 100, 30);
		labelTitle1.setBounds(340, 90, 100, 30);
		labelPhone.setBounds(470, 90, 100, 30);
		labelPhone1.setBounds(560, 90, 100, 30);
		labelAddress.setBounds(690, 90, 100, 30);
		labelAddress1.setBounds(780, 90, 100, 30);
		labelCope.setBounds(30, 150, 100, 30);
		labelCope1.setBounds(120, 150, 100, 30);
		pnlMain.add(pnlMainL);
		pnlMain.add(pnlMainR);
		pnlMain.add(pnlMainT);
		pnlMainT.add(label);
		pnlMainT.add(jText);
		pnlMainT.add(search);
		pnlMainT.add(OpratorManage);
		pnlMainT.add(account);
		pnlMainT.add(exit);
		pnlMainT.add(labelManage);
		pnlMainT.add(labelName);
		pnlMainT.add(labelName1);
		pnlMainT.add(labelTitle);
		pnlMainT.add(labelTitle1);
		pnlMainT.add(labelPhone);
		pnlMainT.add(labelPhone1);
		pnlMainT.add(labelAddress);
		pnlMainT.add(labelAddress1);
		pnlMainT.add(labelCope);
		pnlMainT.add(labelCope1);
		pnlMainL.add(snpView);
		pnlMainR.add(snpView1);
		pnlMainT.setBounds(0, 0, 1000, 180);
		pnlMainL.setBounds(0, 200, 500, 480);
		pnlMainR.setBounds(500, 200, 500, 480);
		snpView1.getViewport().add(tableView1);
		snpView1.setBounds(0,20, 500,480);
		snpView.getViewport().add(tableView);
		snpView.setBounds(0,20, 500,480);
		this.add(pnlMain);
		this.setVisible(true);
}
}
