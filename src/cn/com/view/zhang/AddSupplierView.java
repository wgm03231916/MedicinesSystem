package cn.com.view.zhang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.com.beans.SupplierBean;
import cn.com.beans.zhang.BigAllBean;
import cn.com.daos.zhang.MedicineDAOImpl;
import cn.com.daos.zhang.MedicineDAoInf;

public class AddSupplierView extends JFrame{
	 private JPanel pnlMain;
	 private JLabel labSupId;
	 private JLabel labSupName;
	 private JLabel labSupAddre;
	 private JLabel labSupCon;
	 private JLabel labSupPhone;
	 private JLabel labSupNote;
	 private JTextField jtSupId;
	 private JTextField jtSupName;
	 private JTextField jtSupAddre;
	 private JTextField jtSupCon;
	 private JTextField jtSupPhone;
	 private JTextField jtSupNote;
	 
	 private JButton btnSure;
	 private JButton btnExit;
	 BigAllBean bean;
	 SupplierBean sb;
	 private SuppManagerImp smi;
	
	 public AddSupplierView(SuppManagerImp smi,BigAllBean bean){
		 this.smi = smi;
		 this.bean = bean;
		 pnlMain = new JPanel(null);
		 
		 btnSure = new JButton("保存");
		 btnExit = new JButton("退出");
		 
		 labSupId = new JLabel("编             号:");
		
		 jtSupId = new JTextField();
		 
		 labSupName = new JLabel("供货商名称:");
		 
		 jtSupName = new JTextField();
		 
		 labSupCon = new JLabel("联     系    人:");
		 
		 jtSupCon = new JTextField();
		 
		 labSupAddre = new JLabel("地             址:");
		
		 jtSupAddre = new JTextField();
		 
		 labSupPhone = new JLabel("电             话:");
		 
		 jtSupPhone = new JTextField();
		 
		 labSupNote = new JLabel("备             注:");
		 
		 jtSupNote = new JTextField();
		 
		 if(bean == null){
			 setDate();
		 }else{
			this.jtSupId.setText(bean.getSb().getSupplier_id()) ;
			this.jtSupName.setText(bean.getSb().getSupplier_name());
			this.jtSupCon.setText(bean.getSb().getSupplier_contact());
			this.jtSupPhone.setText(bean.getSb().getSupplier_tel());
			this.jtSupAddre.setText(bean.getSb().getSupplier_addr());
			this.jtSupNote.setText(bean.getSb().getSupplier_note());
		 }
		
		 init();
		 
	 }

	private void setDate() {
		// TODO Auto-generated method stub
		String SupId = jtSupId.getText();
		String SupName = jtSupName.getText();
		String SupCon = jtSupCon.getText();
		String SupAddre = jtSupAddre.getText();
		String SupPhone = jtSupPhone.getText();
		String SupNote = jtSupNote.getText();
		bean = new BigAllBean();
		sb = new SupplierBean();
		bean.setSb(sb);
		sb.setSupplier_id(SupId);
		sb.setSupplier_name(SupName);
		sb.setSupplier_contact(SupCon);
		sb.setSupplier_addr(SupAddre);
		sb.setSupplier_tel(SupPhone);
		sb.setSupplier_addr(SupAddre);
		MedicineDAoInf dao=new MedicineDAOImpl();
		//List<BigAllBean> list=dao.getAllSupplierInfo();
		if(dao.addSupplierInfo(bean)){
			//JOptionPane.sho("新增成功");
			smi.setTableData();
			this.dispose();
		}
	}
	private void showData() {
		// TODO Auto-generated method stub
		if(bean == null){
			setDate();
		}else{
			String SupId = jtSupId.getText();
			String SupName = jtSupName.getText();
			String SupCon = jtSupCon.getText();
			String SupAddre = jtSupAddre.getText();
			String SupPhone = jtSupPhone.getText();
			String SupNote = jtSupNote.getText();
			bean = new BigAllBean();
			sb = new SupplierBean();
			bean.setSb(sb);
			sb.setSupplier_id(SupId);
			sb.setSupplier_name(SupName);
			sb.setSupplier_contact(SupCon);
			sb.setSupplier_addr(SupAddre);
			sb.setSupplier_tel(SupPhone);
			sb.setSupplier_addr(SupAddre);
			MedicineDAoInf dao=new MedicineDAOImpl();
			//List<BigAllBean> list=dao.getAllSupplierInfo();
			if(dao.updateSupplierInfo(bean)){
				//JOptionPane.sho("新增成功");
				smi.setTableData();
				this.dispose();
			}
		}
	}
	private void init() {
		// TODO Auto-generated method stub
		if(bean == null){
			this.setTitle("增加供货商信息");
		}else{
			this.setTitle("修改供货商信息");
		}
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400, 500);
			
		labSupId.setBounds(10, 20,70, 30);
		jtSupId.setBounds(80, 20, 300, 30);
		
		labSupName.setBounds(10, 60, 70, 30);
		jtSupName.setBounds(80, 60,300, 30);
		
		labSupAddre.setBounds(10, 100, 70, 30);
		jtSupAddre.setBounds(80, 100,300, 30);
		
		labSupCon.setBounds(10, 140, 70, 30);
		jtSupCon.setBounds(80, 140,300, 30);
		
		labSupPhone.setBounds(10, 180, 70, 30);
		jtSupPhone.setBounds(80, 180,300, 30);
		
		labSupNote.setBounds(10,220, 70, 30);
		jtSupNote.setBounds(80, 220,300, 100);
		
		btnSure.setBounds(80, 350, 70,30);
		btnExit.setBounds(280, 350, 70,30);
		pnlMain.add(labSupId);
		pnlMain.add(jtSupId);
		
		pnlMain.add(labSupName);
		pnlMain.add(jtSupName);
		
		pnlMain.add(labSupCon);
		pnlMain.add(jtSupCon);
		
		pnlMain.add(labSupAddre);
		pnlMain.add(jtSupAddre);
		
		pnlMain.add(labSupPhone);
		pnlMain.add(jtSupPhone);
		
		pnlMain.add(labSupNote);
		pnlMain.add(jtSupNote);
		
		pnlMain.add(btnSure);
		pnlMain.add(btnExit);
		btnSure.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					showData();
				 
			}

			
			
		});
		btnExit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		
		});
		this.add(pnlMain);
		this.setVisible(true);
	}
}
