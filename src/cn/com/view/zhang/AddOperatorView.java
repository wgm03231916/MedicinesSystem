package cn.com.view.zhang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.com.beans.EmployeeBean;
import cn.com.beans.zhang.BigAllBean;
import cn.com.daos.zhang.MedicineDAOImpl;
import cn.com.daos.zhang.MedicineDAoInf;

public class AddOperatorView extends JFrame{
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
	 EmployeeBean eb;;
	 private OperatorManaView omv;
	
	 public AddOperatorView(OperatorManaView omv){
		 this.omv = omv;
		 
		 pnlMain = new JPanel(null);
		 
		 btnSure = new JButton("保存");
		 btnExit = new JButton("退出");
		 
		 labSupId = new JLabel("编         号:");
		
		 jtSupId = new JTextField();
		 
		 labSupName = new JLabel("员工姓名:");
		 
		 jtSupName = new JTextField();
		 
		 labSupCon = new JLabel("所任职务:");
		 
		 jtSupCon = new JTextField();
		 
		 labSupPhone = new JLabel("联系电话:");
		
		 jtSupPhone = new JTextField();
		 
		 labSupAddre = new JLabel("联系地址:");
		 
		 jtSupAddre = new JTextField();
		 
		 labSupNote = new JLabel("备         注:");
		 
		 jtSupNote = new JTextField();
		 
		/* if(bean == null){
			 setDate();
		 }else{
			this.jtSupId.setText(bean.getSb().getSupplier_id()) ;
			this.jtSupName.setText(bean.getSb().getSupplier_name());
			this.jtSupCon.setText(bean.getSb().getSupplier_contact());
			this.jtSupPhone.setText(bean.getSb().getSupplier_tel());
			this.jtSupAddre.setText(bean.getSb().getSupplier_addr());
			this.jtSupNote.setText(bean.getSb().getSupplier_note());
		 }*/
		
		 init();
		 
	 }

	private void setDate() {
		// TODO Auto-generated method stub
		String employee_id = jtSupId.getText();
		String employee_name = jtSupName.getText();
		String employee_title = jtSupCon.getText();
		String employee_addr = jtSupAddre.getText();
		String employee_tel = jtSupPhone.getText();
		String employee_note = jtSupNote.getText();
		bean = new BigAllBean();
		eb = new EmployeeBean();
		bean.setEb(eb);
		eb.setEmployee_id(employee_id);
		eb.setEmployee_name(employee_name);
		eb.setEmployee_title(employee_title);
		eb.setEmployee_tel(employee_tel);
		eb.setEmployee_addr(employee_addr);
		eb.setEmployee_note(employee_note);
		MedicineDAoInf dao=new MedicineDAOImpl();
		//List<BigAllBean> list=dao.getAllSupplierInfo();
		if(dao.addOperatorInfo(bean)){
			//JOptionPane.sho("新增成功");
			omv.setTableData();
			this.dispose();
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
					setDate();
				 
			}
			
		});
		btnExit.addActionListener(new ActionListener() {
			
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

