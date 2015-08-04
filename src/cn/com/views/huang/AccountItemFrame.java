package cn.com.views.huang;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.com.beans.huang.BigAllBean;
import cn.com.daos.huang.MedicineDaoImp;
import cn.com.listener.huang.BuyInView_ActionListener;
import cn.com.views.settings.AddSupplierDialog;



public class AccountItemFrame extends JFrame{
	    private JPanel pnlMain;
	    private JTable tabView;
		private DefaultTableModel dtmView;
		private JScrollPane snpView;
		private JButton btnSure;
		private JButton btnExit;
		private JLabel lblSearchHouse;
		private JTextField txtSearch;
		private JButton btnSAll;
		private BuyInView biv;
	    public AccountItemFrame(){
	    	pnlMain=new JPanel(null);
	    	txtSearch=new JTextField();
	    	btnSAll=new JButton("新增");
	    	btnSure=new JButton("确定");
	    	btnExit=new JButton("退出");
	    	lblSearchHouse=new JLabel("查找供货商：");
	    	
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
			this.setSize(600, 285);
			snpView.getViewport().add(tabView);
			snpView.setBounds(10, 10, 580,180);
			this.add(pnlMain);
			pnlMain.add(snpView);
			pnlMain.add(btnSure);
			pnlMain.add(btnExit);
			pnlMain.add(lblSearchHouse);
			pnlMain.add(txtSearch);
			pnlMain.add(btnSAll);
			btnSure.setBounds(400, 200, 60, 30);
			btnExit.setBounds(480, 200, 60, 30);
			lblSearchHouse.setBounds(30, 200, 110, 30);
			txtSearch.setBounds(120, 200, 150, 30);
			btnSAll.setBounds(280, 200, 70, 30);
			txtSearch.setToolTipText("输入编号，名称，联系人，电话，地址查询");
			btnSure.addActionListener(new BuyInView_ActionListener(this));
			btnSAll.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new AddSupplierDialog(null, "添加供货商", true);
				}
			});
			btnExit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 int rowIndex=tabView.getSelectedRow();
					 int colIndex=tabView.getSelectedColumn();
					 if(colIndex!=1){
						 JOptionPane.showMessageDialog(null, "请选择供货商！", "错误",
									JOptionPane.ERROR_MESSAGE);
					 }else{
					 biv.o=tabView.getValueAt(rowIndex, colIndex); 
					 //System.out.println(biv.o);
					 new BuyInView(tabView,rowIndex,colIndex);
					 dispose();
					 }
				}
			});
			txtSearch.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
					SearchAll(e);
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					//SearchAll(e);
				}
			});
			//this.setModal(true);
			setTableData();
			this.setVisible(true);
		}
		protected void SearchAll(KeyEvent e) {
			// TODO Auto-generated method stub
			
			char c=e.getKeyChar();
			String s=this.txtSearch.getText();
			String msg=s+c;
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
			MedicineDaoImp dao=new MedicineDaoImp();
			List<BigAllBean> list=dao.getSupplierInfoByAll(msg);
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
			//System.out.println(msg);
		}
		private void setTableData() {
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
			MedicineDaoImp mdao=new MedicineDaoImp();
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
		public void btnSureAction(ActionEvent e) {
			// TODO Auto-generated method stub
			 int rowIndex=this.tabView.getSelectedRow();
			 int colIndex=this.tabView.getSelectedColumn();
			 if(colIndex!=1){
				 JOptionPane.showMessageDialog(null, "请选择供货商！", "系统提示",
							JOptionPane.INFORMATION_MESSAGE);
			 }else{
				 biv.o=this.tabView.getValueAt(rowIndex, colIndex); 
				 //System.out.println(biv.o);
				 new BuyInView(tabView,rowIndex,colIndex);
				 this.dispose();
			 }
			 
		}
}
