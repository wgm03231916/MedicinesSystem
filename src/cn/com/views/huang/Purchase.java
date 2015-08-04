package cn.com.views.huang;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.com.beans.huang.BigAllBean;
import cn.com.daos.huang.MedicineDaoImp;


public class Purchase extends JDialog{
     public JPanel pnlMain;
     public JPanel pnlTop;
     public JPanel pnlButtom;
     public JButton btnSave;
     public JButton btnExit;
     public JLabel lblId;
     public JLabel lblId2;
     public JLabel lblName;
     public JLabel lblName2;
     public JLabel lblSpft;
     public JLabel lblSpft2;
     public JLabel lblUnit;
     public JLabel lblUnit2;
     public JLabel lblNum;
     public JLabel lblNum2;
     public JLabel lblApp;
     public JLabel lblApp2;
     public JLabel lblMenu;
     public JLabel lblNote;
     public JLabel lblMenu2;
     public JLabel lblNote2;
     public JLabel lblSet;
     public JLabel lblNo;
     public JLabel lblCount;
     public JLabel lblDate;
     public JLabel lblYuan;
     public JLabel lblYear;
     public JLabel lblMonth;
     public JTextField txtYuan;
     public JTextField txtCount;
     public JTextField txtYear;
     public JTextField txtMonth;
     public JTextField txtNo;
     public JTable tabView;
	 public DefaultTableModel dtmView;
	 public JScrollPane snpView;
	 public int row;
	 public appendGoods aps;
	 public String ID;
     //private Graphics g;
	 
     public Purchase(int a,appendGoods app){
    	 this.row=a;
    	 this.aps=app;
    	 //System.out.println("aps="+aps);
    	 pnlMain=new JPanel(new GridLayout(2,1));
    	 pnlTop=new JPanel(null);
    	 pnlButtom=new JPanel(null);
    	 snpView=new JScrollPane();
    	 btnSave=new JButton("����");
    	 btnExit=new JButton("�˳�");
    	 lblId=new JLabel("��Ʒ��ţ�");
    	 lblId2=new JLabel(aps.tabView.getValueAt(row, 0).toString());
    	 lblName=new JLabel("��Ʒ���ƣ�");
    	 lblName2=new JLabel(aps.tabView.getValueAt(row, 1).toString());
    	 lblSpft=new JLabel("����ͺţ�");
    	 lblSpft2=new JLabel(aps.tabView.getValueAt(row, 3).toString());
    	 lblUnit=new JLabel("��        λ��");
    	 lblUnit2=new JLabel(aps.tabView.getValueAt(row, 2).toString());
    	 lblNum=new JLabel("��ǰ��棺");
    	 lblNum2=new JLabel(aps.tabView.getValueAt(row, 5).toString()+aps.tabView.getValueAt(row, 2).toString());
    	 lblApp=new JLabel("��׼�ĺţ�");
    	 lblApp2=new JLabel("��ҩ׼��");
    	 lblMenu=new JLabel("�������̣�");
    	 lblMenu2=new JLabel(aps.tabView.getValueAt(row, 6).toString());
    	 lblNote=new JLabel("��        ע��");
    	 lblNote2=new JLabel();
    	 lblSet=new JLabel("�ο����ۣ�");
    	 lblCount=new JLabel("��Ʒ���ţ�");
    	 lblNo=new JLabel("��        ����");
    	 lblDate=new JLabel("��Ч������");
    	 lblYear=new JLabel("��");
    	 lblMonth=new JLabel("��");
    	 lblYuan=new JLabel("Ԫ");
    	 txtYuan=new JTextField(aps.tabView.getValueAt(row, 4).toString());
    	 txtCount=new JTextField();
    	 txtYear=new JTextField();
    	 txtMonth=new JTextField();
    	 txtNo=new JTextField();
    	 tabView=new JTable(){
     		   @Override
     		public boolean isCellEditable(int row, int column) {
     			// TODO Auto-generated method stub
     			return false;
     		}
     	   };
     	   setHistoryData();
     	  // System.out.println("row="+row);
    	 init();
     }
	private void setHistoryData() {
		// TODO Auto-generated method stub
		Vector<String> title=new Vector<String>();
		title.add("��������");
		title.add("���ݱ��");
		title.add("����");
		title.add("����");
		title.add("�ϼƽ��");
		title.add("��Ʒ���");
		title.add("��Ч��");
		
		Vector data=new Vector();
		dtmView=new DefaultTableModel(data,title);
		MedicineDaoImp dao=new MedicineDaoImp();
		Vector Row =null;
		ID=aps.tabView.getValueAt(row, 0).toString();
		List<BigAllBean> list=dao.getHistoryInfoByGoodsID(ID);
		for(BigAllBean b:list){
			Row=new Vector();
			Row.add(b.getJb().getOrder_date());
			Row.add(b.getOb().getOrder_id());
			Row.add(b.getGb().getGoods_setting());
			Row.add(b.getOb().getGoods_num());
			Row.add(b.getOb().getOrder_price());
			Row.add(b.getGb().getGoods_id());
			Row.add(b.getOb().getGoods_validity());
			dtmView.addRow(Row);	
		}
			this.tabView.setModel(this.dtmView);
	}
	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("��Ʒ��Ϣ���ɹ�������");
		this.setSize(510,500);
		this.setModal(true);
		pnlTop.setBorder(BorderFactory.createTitledBorder("��Ʒ��Ϣ"));
		pnlButtom.setBorder(BorderFactory.createTitledBorder("����Ʒ�ɹ�������ʷ"));
		pnlTop.add(lblId);
		lblId.setBounds(10, 20, 90, 20);
		lblId2.setForeground(Color.blue);
		pnlTop.add(lblId2);
		lblId2.setBounds(80, 20, 150, 20);
		//lblId2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
		pnlTop.add(lblName);
		lblName.setBounds(250, 20, 90, 20);
		lblName2.setForeground(Color.red);
		lblName2.setBounds(320, 20, 150, 20);
		//lblName2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
		pnlTop.add(lblName2);
		pnlTop.add(lblSpft);
		lblSpft.setBounds(10, 50, 90, 20);
		lblSpft2.setForeground(Color.blue);
		lblSpft2.setBounds(80, 50, 150, 20);
		pnlTop.add(lblSpft2);
		//lblSpft2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
		pnlTop.add(lblUnit);
		lblUnit.setBounds(250, 50, 90, 20);
		lblUnit2.setBounds(320, 50, 150, 20);
		lblUnit2.setForeground(Color.blue);
		pnlTop.add(lblUnit2);
		pnlTop.add(lblNum);
		lblNum.setBounds(10, 80, 90, 20);
		lblNum2.setForeground(Color.red);
		lblNum2.setBounds(80, 80, 150, 20);
		//lblNum2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
		pnlTop.add(lblNum2);
		pnlTop.add(lblApp);
		lblApp.setBounds(250, 80, 90, 20);
		lblApp2.setBounds(320, 80, 150, 20);
		lblApp2.setForeground(Color.blue);
		pnlTop.add(lblApp2);
		pnlTop.add(lblMenu);
		lblMenu.setBounds(10, 110, 90, 20);
		lblMenu2.setBounds(80, 110, 150, 20);
		lblMenu2.setForeground(Color.blue);
		//lblMenu2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
		pnlTop.add(lblMenu2);
		pnlTop.add(lblNote);
		lblNote.setBounds(250, 110, 90, 20);
		lblNote2.setBounds(320, 110, 150, 20);
		pnlTop.add(lblNote2);
		pnlTop.add(lblSet);
		lblSet.setBounds(10, 140, 90, 20);
		pnlTop.add(lblCount);
		lblCount.setBounds(250, 140, 70, 20);
		pnlTop.add(lblNo);
		lblNo.setBounds(10, 170, 90, 20);
		txtNo.setBounds(80, 170, 90, 20);
		pnlTop.add(lblDate);
		pnlTop.add(lblYear);
		pnlTop.add(lblMonth);
		pnlTop.add(lblYuan);
		lblYuan.setBounds(190, 140, 30, 20);
		lblDate.setBounds(250, 170, 90, 20);
		pnlTop.add(txtYuan);
		txtYuan.setBounds(80, 140, 100, 20);
		pnlTop.add(txtCount);
		txtCount.setBounds(320, 140, 80, 20);
		pnlTop.add(txtYuan);
		pnlTop.add(txtYear);
		txtYear.setBounds(320, 170, 50, 20);
		lblYear.setBounds(375, 170, 20, 20);
		txtMonth.setBounds(390, 170, 30, 20);
		lblMonth.setBounds(425, 170, 20, 20);
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 135, 450, 5);
		pnlTop.add(separator);

		pnlTop.add(txtMonth);
		pnlTop.add(txtNo);
		pnlTop.add(btnSave);
		btnSave.setBounds(140, 200, 60, 20);
		btnExit.setBounds(250, 200, 60, 20);
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Purchase.this.dispose() ;
			}
		});
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vector<String> title=new Vector<String>();
				//System.out.println(aps);
				title.add("��Ʒ����");
				title.add("��λ");
				title.add("����");
				title.add("����");
				title.add("�ܽ��");
				title.add("��Ʒ����");
				title.add("��Ч����");
				Vector data=new Vector();
				aps.dtmView2=new DefaultTableModel(data,title);
				Vector row =null;
				row=new Vector();
				row.add(Purchase.this.lblName2.getText().toString());
				row.add(Purchase.this.lblUnit2.getText().toString());
				row.add(Purchase.this.txtYuan.getText().toString());
				row.add(Purchase.this.txtNo.getText().toString());
				row.add(Float.parseFloat(Purchase.this.txtYuan.getText().toString())*(Float.parseFloat(Purchase.this.txtNo.getText().toString())));
				
				row.add(Purchase.this.txtCount.getText().toString());
				row.add(Purchase.this.txtYear.getText().toString()+"-"+Purchase.this.txtMonth.getText().toString());
				aps.dtmView2.addRow(row);
				aps.tabView2.setModel(aps.dtmView2);
				Purchase.this.dispose();
			}
			
		});
		pnlTop.add(btnExit);
		pnlMain.add(pnlTop);
		pnlMain.add(pnlButtom);
		pnlButtom.add(snpView);
		snpView.getViewport().add(tabView);
		snpView.setBounds(10,20, 480,180);
		this.add(pnlMain);
		this.setVisible(true);
	}
//	public static void main(String[] args) {
//		new Purchase();
//	}
}
