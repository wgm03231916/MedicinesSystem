package cn.com.view.zhang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.com.beans.SupplierBean;
import cn.com.beans.zhang.BigAllBean;
import cn.com.daos.zhang.MedicineDAOImpl;
import cn.com.daos.zhang.MedicineDAoInf;




public class SupSerachView extends JFrame{
	
	private JPanel pnlMain;
	private JTable tabView;
	private DefaultTableModel dtmView;
	private JScrollPane snpView;
	private JButton btnSure;
	private JButton btnExit;
	public SupplierImp sup;
	private BigAllBean bean;
	private DefaultTableModel DfModel = null;
	
	public SupSerachView(SupplierImp sup){
		this.sup=sup;
		pnlMain=new JPanel(null);
    	btnSure=new JButton("ȷ��");
    	btnExit=new JButton("�˳�");
    	
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
		this.setTitle("��������Ϣ");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600, 285);
		snpView.getViewport().add(tabView);
		snpView.setBounds(10, 10, 580,180);
		this.add(pnlMain);
		pnlMain.add(snpView);
		pnlMain.add(btnSure);
		pnlMain.add(btnExit);
		btnSure.setBounds(400, 200, 60, 30);
		btnExit.setBounds(480, 200, 60, 30);
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		} );
		btnSure.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sup.getLabelName1().setText(bean.getSb().getSupplier_name());
				sup.getLabelContact1().setText(bean.getSb().getSupplier_contact());
				sup.getLabelPhone1().setText(bean.getSb().getSupplier_tel());
				sup.getLabelAddress1().setText(bean.getSb().getSupplier_addr());
				
				Vector<String> title=new Vector<String>();
				title.add("���ݺ�");
				title.add("�ֿ�����");
				title.add("Ӧ�����");
				//title.add("ʵ�����");
				title.add("������");
				title.add("��������");
				Vector data=new Vector();
				dtmView=new DefaultTableModel(data,title);
				sup.getTableView().setModel(sup.getDtmView());
				
				Vector row =null;
				MedicineDAoInf mdao=new MedicineDAOImpl();
				List<BigAllBean> list=mdao.getSupplier_GoodsInfo();
				
				for(BigAllBean b:list){
					row=new Vector();
							row.add(b.getJt().getOrder_id());
							row.add(b.getWb().getWarehouse_name());
							row.add(b.getJt().getOrder_price());
							row.add(b.getJt().getOrder_head());
							row.add(b.getJt().getOrder_type());
							
							sup.getDtmView().addRow(row);
							
				}
				sup.getTableView().setModel(sup.getDtmView());
				//this.tabView.setModel(this.dtmView);
				//DfModel = new DefaultTableModel();
				//sup.getTableView().setModel(DfModel);
				dispose();
				
			}
			
		});
		tabView.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(java.awt.event.MouseEvent e) {   
				  int row = tabView.getSelectedRow();
				  	String name = (String)tabView.getValueAt(row, 1);
					String con = (String)tabView.getValueAt(row, 2);
					String tel = (String)tabView.getValueAt(row, 3);
					String addre = (String)tabView.getValueAt(row, 4);
					 bean = new BigAllBean();
					SupplierBean gb = new SupplierBean();
					gb.setSupplier_name(name);
					gb.setSupplier_contact(con);
					gb.setSupplier_tel(tel);
					gb.setSupplier_addr(addre);
					bean.setSb(gb);
					System.out.println(bean.getSb().getSupplier_addr());
					 

			  }
		});

		setTableData();
		this.setVisible(true);
	}

	public void setTableData() { 
		// TODO Auto-generated method stub
		Vector<String> title=new Vector<String>();
		title.add("���");
		title.add("����������");
		title.add("��ϵ��");
		title.add("��ϵ�绰");
		title.add("��ϵ��ַ");
		title.add("��ע");
		Vector data=new Vector();
		dtmView=new DefaultTableModel(data,title);
		Vector row =null;
		MedicineDAoInf mdao=new MedicineDAOImpl();
		List<BigAllBean> list=mdao.getAllSupplierInfo();
		for(BigAllBean b:list){
			row=new Vector();
			row.add(b.getSb().getSupplier_id());
			row.add(b.getSb().getSupplier_name());
			row.add(b.getSb().getSupplier_contact());
			row.add(b.getSb().getSupplier_tel());
			row.add(b.getSb().getSupplier_addr());
			row.add(b.getSb().getSupplier_note());
			dtmView.addRow(row);
		}
		this.tabView.setModel(this.dtmView);
	}
	
}
