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
		label = new JLabel("����ҵ��Ա����:");
		labelManage = new JLabel("Ա����Ϣ:");
		
		labelName = new JLabel("Ա������:");
		labelName1 = new JLabel();
		
		labelTitle = new JLabel("Ա��ְ��:");
		labelTitle1 = new JLabel();
		
		labelPhone = new JLabel("��ϵ�绰:");
		labelPhone1 = new JLabel();
		
		labelAddress = new  JLabel("��ַ:");
		labelAddress1 = new  JLabel();
		
		
		labelCope = new JLabel("�ҷ�Ӧ��:");
		labelCope1 = new JLabel();
		
		
		
		jText = new JTextField();
		search = new JButton("��ѯ");
		//search.addActionListener(new SupSearchFrame(this));
		OpratorManage = new JButton("ҵ��Ա����");
		OpratorManage.addActionListener(new OperatorImpService(this));
		account = new JButton("ҵ��Աҵ��");
		exit = new JButton("�˳�");
		setTabData();
	   	setTabData1();
		init();
	}

	private void setTabData1() {
		// TODO Auto-generated method stub
		Vector<String> title=new Vector<String>();
		
		title.add("���ݺ�");
		title.add("�ֿ�����");
		title.add("Ӧ�����");
		title.add("ʵ�����");
		title.add("������");
		title.add("��������");
		Vector data=new Vector();
		dtmView=new DefaultTableModel(data,title);
		this.tableView.setModel(this.dtmView);
	}

	private void setTabData() {
		// TODO Auto-generated method stub
		Vector<String> title=new Vector<String>();
		
		title.add("��Ʒ���");
		title.add("��Ʒ����");
		title.add("��λ");
		title.add("����");
		title.add("����");
		title.add("�ܽ��");
		Vector data=new Vector();
		dtmView1=new DefaultTableModel(data,title);
		this.tableView1.setModel(this.dtmView1);
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setTitle("ҵ��Ա��Ϣ");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1000, 600);
		this.setTitle("ҵ��Ա����");
		pnlMainL.setBorder(BorderFactory.createTitledBorder("���ݼ�¼"));
		pnlMainR.setBorder(BorderFactory.createTitledBorder("��ϸ����"));
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
