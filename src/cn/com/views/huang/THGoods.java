package cn.com.views.huang;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.com.beans.huang.BigAllBean;
import cn.com.daos.huang.MedicineDaoImp;
import cn.com.listener.huang.THViewBill_MouseListener;

public class THGoods extends JDialog{
      private JPanel pnlMain;
      private JPanel pnlMainR;
      private JPanel pnlMainL;
      private JButton btnModify;
      private JButton btnDel;
      private JButton btnOk;
      private JButton btnCancel;
      private JLabel lblInfo1;
      private JLabel lblInfo2;
      private JLabel lblInfo3;
      private JLabel lblInfo4;
      private JLabel lblInfo5;
      private JTextField txtAddGoods;
      private JButton btnAddGoods;
      public JLabel lblListGoods;
      public  JLabel lblBillGoods;
      public JLabel lblNewlyGoods;
      public JTable tabView;
	  public DefaultTableModel dtmView;
	  public DefaultTableModel dtmView2;
	  public JScrollPane snpView; 
	  public JTable tabView2;
	  public JScrollPane snpView2; 
	  public BuyOutView biv;
	  public Purchase p;
//      private JPanel pnlMainN;
//      private JPanel pnlMainS;
      public THGoods(BuyOutView biv){
    	  this.biv=biv;
    	  pnlMain=new JPanel(new GridLayout(1,2));
    	  pnlMainR=new JPanel(null);
    	  pnlMainL=new JPanel(null);
    	  txtAddGoods=new JTextField();
    	  snpView=new JScrollPane();
    	  snpView2=new JScrollPane();
    	  btnAddGoods=new JButton("������ѡ��Ʒ");
    	  lblInfo1=new JLabel("����һ��");
    	  lblInfo2=new JLabel("��������Ʒ��Ż����Ʋ�ѯ,��ѯ������ӵ��ұ���ѡ��Ʒ");
    	  lblInfo3=new JLabel("��ʾ��");
    	  lblInfo4=new JLabel("������������˻�ǰ������˼Ӵ��������");
    	  lblInfo5=new JLabel("������Ʒ��Ż����Ʋ�ѯ��Ʒ��");
    	  //lblListGoods=new JLabel("��Ʒ�б�");
    	  lblBillGoods=new JLabel("��Ʒ�嵥");
    	 // lblNewlyGoods=new JLabel("�������");
    	  btnModify=new JButton("��  ��");
    	  btnDel=new JButton("ɾ  ��");
    	  btnOk=new JButton("ȷ  ��");
    	  btnCancel=new JButton("ȡ  ��");
    	  tabView=new JTable(){
   		   @Override
   		public boolean isCellEditable(int row, int column) {
   			// TODO Auto-generated method stub
   			return false;
   		}
   	   };
    	  tabView.setBackground(new Color(224, 255, 255));
   	tabView2=new JTable(){
		   @Override
		public boolean isCellEditable(int row, int column) {
			// TODO Auto-generated method stub
			return false;
		}
	   };
   	tabView2.setBackground(new Color(224, 255, 255));
   	   
//    	  pnlMainN=new JPanel(null);
//    	  pnlMainS=new JPanel(null);
   	   setTabData();
   	   setTabData2();
    	  init();
    	  
      }
	private void setTabData2() {
		// TODO Auto-generated method stub
		Vector<String> title=new Vector<String>();
		
		title.add("��Ʒ����");
		title.add("��λ");
		title.add("����");
		title.add("����");
		title.add("�ܽ��");
		title.add("��Ʒ����");
		title.add("��Ч����");
		Vector data=new Vector();
		dtmView2=new DefaultTableModel(data,title);
		Vector row =null;
		row=new Vector();
//		row.add(b.getGb().getGoods_id());
//		row.add(b.getGb().getGoods_Name());
//		row.add(b.getGb().getGoods_unit());
//		row.add(b.getGb().getGoods_spft());
//		row.add(b.getGb().getGoods_setting());
//		row.add(b.getHc().getGoods_num());
//		row.add(b.getGb().getGood_manufacture());
		//dtmView.addRow(row);
		this.tabView2.setModel(this.dtmView2);
	}
	public void setTabData() {
	// TODO Auto-generated method stub
		Vector<String> title=new Vector<String>();
		title.add("��Ʒ���");
		title.add("��Ʒ����");
		title.add("��λ");
		title.add("���");
		title.add("�ο�����");
		title.add("�����");
		title.add("��������");
		
		Vector data=new Vector();
		dtmView=new DefaultTableModel(data,title);
		MedicineDaoImp dao=new MedicineDaoImp();
		Vector row =null;
		List<BigAllBean> list=dao.getBillInfo();
		for(BigAllBean b:list){
			row=new Vector();
			row.add(b.getGb().getGoods_id());
			row.add(b.getGb().getGoods_Name());
			row.add(b.getGb().getGoods_unit());
			row.add(b.getGb().getGoods_spft());
			row.add(b.getGb().getGoods_setting());
			row.add(b.getHc().getGoods_num());
			row.add(b.getGb().getGood_manufacture());
			dtmView.addRow(row);	
		}
			this.tabView.setModel(this.dtmView);
}
	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("������Ʒ���ɹ�������");
		this.setSize(870,540);
		pnlMainR.setBorder(BorderFactory.createTitledBorder("��ѡ��Ʒ"));
		//pnlMainN.setBounds(10, 20, 410, 100);
		pnlMainL.setBorder(BorderFactory.createTitledBorder("��ѯ��Ʒ�б�"));
//		pnlMainL.add(pnlMainN,BorderLayout.NORTH);
//		pnlMainL.add(pnlMainS,BorderLayout.CENTER);
		pnlMain.add(pnlMainL);
		pnlMain.add(pnlMainR);
		pnlMainL.add(lblInfo1);
		pnlMainL.add(lblInfo2);
		pnlMainL.add(lblInfo3);
		pnlMainL.add(lblInfo4);
		pnlMainL.add(lblInfo5);
		pnlMainL.add(txtAddGoods);
		pnlMainL.add(btnAddGoods);
		pnlMainL.add(lblBillGoods);
		//pnlMainL.add(lblListGoods);
		//pnlMainL.add(lblNewlyGoods);
		pnlMainL.add(snpView);
		pnlMainR.add(snpView2);
		pnlMainR.add(btnModify);
		pnlMainR.add(btnDel);
		pnlMainR.add(btnOk);
		pnlMainR.add(btnCancel);
		btnModify.setBounds(10, 430, 80, 20);
		btnDel.setBounds(100,430,80, 20);
		btnOk.setBounds(190,430,80, 20);
		btnCancel.setBounds(280,430,80, 20);
		snpView2.setViewportView(tabView2);
		snpView2.setBounds(10,20, 410,390);
		snpView.setViewportView(tabView);
		snpView.setBounds(10,115, 410,370);
		lblInfo1.setBounds(10, 20, 60, 20);
		lblInfo1.setForeground(Color.red);
		lblInfo2.setBounds(60, 20, 360, 20);
		lblInfo3.setBounds(10, 45, 60, 20);
		lblInfo3.setForeground(Color.red);
		lblInfo4.setBounds(60, 45, 300, 20);
		lblInfo5.setBounds(10, 70, 190, 20);
		txtAddGoods.setBounds(200, 70, 100, 20);
		btnAddGoods.setBounds(305, 70, 115, 20);
		btnAddGoods.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.gray));
		lblBillGoods.setBounds(10, 95, 55, 20);
		lblBillGoods.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.blue));
		//lblListGoods.setBounds(67, 95, 55, 20);
		//lblListGoods.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.blue));
		//lblNewlyGoods.setBounds(124, 95, 55, 20);
		//lblNewlyGoods.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.blue));
		//lblNewlyGoods.addMouseListener(new addViewNewly_MouseListener(this));
		lblBillGoods.addMouseListener(new THViewBill_MouseListener(this));
		btnModify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 int rowIndex=tabView.getSelectedRow();
				 //System.out.println(rowIndex);
				 new Purchase2(rowIndex,THGoods.this);
			}
		});
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//JOptionPane.showConfirmDialog(null, "�Ƿ�ɾ������Ϣ", "����",JOptionPane.YES_NO_OPTION);
				if(JOptionPane.YES_OPTION==JOptionPane.showConfirmDialog(null, "�Ƿ�ɾ������Ϣ", "����",JOptionPane.YES_NO_OPTION)){
					int a=THGoods.this.tabView2.getSelectedRow();
					THGoods.this.dtmView2.removeRow(a);
				}
				
			}
		});
		txtAddGoods.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				AddGoods(e);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		tabView.addMouseListener(new MouseAdapter() {
			  
			 public void mouseClicked(MouseEvent e) {
				 if(e.getClickCount()==2){
					 int rowIndex=tabView.getSelectedRow();
					 //System.out.println(rowIndex);
					 new Purchase2(rowIndex,THGoods.this);
				 }
//				 int rowIndex=tabView.getSelectedRow();
//				 //System.out.println(rowIndex);
//				 new Purchase(rowIndex,appendGoods.this);
			 }
		});
		btnAddGoods.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int rowIndex=tabView.getSelectedRow();
				 //System.out.println(rowIndex);
				 new Purchase2(rowIndex,THGoods.this);
			}
		});
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Vector<String> title=new Vector<String>();
				System.out.println(biv);
				title.add("��Ʒ����");
				title.add("��λ");
				title.add("��Ʒ���");
				title.add("��׼�ĺ�");
				title.add("��������");
				title.add("��Ʒ���");
				title.add("��Ч��");
				title.add("����");
				title.add("����");
				title.add("�ܽ��");
				Vector data=new Vector();
				biv.dtmView=new DefaultTableModel(data,title);
				Vector row =null;
				row=new Vector();
				MedicineDaoImp dao=new MedicineDaoImp();
				String name=THGoods.this.tabView2.getValueAt(0, 0).toString();
				List<BigAllBean> list=dao.getAddGoodsInfo(name);
				for(BigAllBean b:list){
					row=new Vector();
					//System.out.println("-----------1");
					row.add(b.getGb().getGoods_Name());
					row.add(b.getGb().getGoods_unit());
					row.add(b.getGb().getGoods_spft());
					row.add(b.getGb().getGoods_Apvlnum());
					row.add(b.getGb().getGood_manufacture());
					row.add(b.getGb().getGoods_id());
					row.add(THGoods.this.tabView2.getValueAt(0, 6).toString()+"-01");
					row.add(b.getGb().getGoods_setting());
					row.add(THGoods.this.tabView2.getValueAt(0, 3).toString());
					row.add((b.getGb().getGoods_setting())*(Float.parseFloat(THGoods.this.tabView2.getValueAt(0, 3).toString())));
					biv.dtmView.addRow(row);
				}
				
				biv.tabView.setModel(biv.dtmView);
				THGoods.this.dispose();
			}
		});
		getContentPane().add(pnlMain);
		this.setModal(true);
		this.setVisible(true);
	}
	protected void AddGoods(KeyEvent e) {
		// TODO Auto-generated method stub

		char c=e.getKeyChar();
		String s=this.txtAddGoods.getText();
		String msg2=s+c;
		Vector<String> title=new Vector<String>();
		title.add("��Ʒ���");
		title.add("��Ʒ����");
		title.add("��λ");
		title.add("���");
		title.add("�ο�����");
		title.add("�����");
		title.add("��������");
		Vector data=new Vector();
		dtmView=new DefaultTableModel(data,title);
		Vector row =null;
		MedicineDaoImp dao=new MedicineDaoImp();
		List<BigAllBean> list=dao.getGoodsBillB(msg2);
		for(BigAllBean b:list){
			row=new Vector();
			row.add(b.getGb().getGoods_id());
			row.add(b.getGb().getGoods_Name());
			row.add(b.getGb().getGoods_unit());
			row.add(b.getGb().getGoods_spft());
			row.add(b.getGb().getGoods_setting());
			row.add(b.getHc().getGoods_num());
			row.add(b.getGb().getGood_manufacture());
			dtmView.addRow(row);
		}
		this.tabView.setModel(this.dtmView);
		//System.out.println(msg);
	}
}
