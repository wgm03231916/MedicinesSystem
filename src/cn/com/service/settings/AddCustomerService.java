package cn.com.service.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import cn.com.beans.CustomerBean;
import cn.com.daos.settings.CustomerDAOImpl;
import cn.com.daos.settings.CustomerDAOInf;
import cn.com.views.settings.AddCustomerDialog;
import cn.com.views.settings.CustomerSetDialog;
import cn.com.views.settings.WarehouseSetDialog;



public class AddCustomerService implements ActionListener,KeyListener {
	private AddCustomerDialog acd;
	private CustomerDAOInf CusDAO;
	private CustomerSetDialog cd;
	public AddCustomerService (AddCustomerDialog acd,CustomerSetDialog cd){
		this.acd = acd;
		this.cd = cd;
		CusDAO = new CustomerDAOImpl();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if(cmd.equals("Save")){
			CustomerBean cb  = new CustomerBean();
			//获得客户编号
			String id = this.acd.getTextNO().getText();
//			String id = this.ad.getTextName().getText();
			if(id.length() == 0){
				JOptionPane.showMessageDialog(null, "客户编号不能为空", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}if(CusDAO.isExistIbfoById(id)){
				JOptionPane.showMessageDialog(null, "客户编号已存在", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
		    cb.setCustomer_id(id);
			//获得客户名称
			String name = this.acd.getTextName().getText();
			if(name.length() == 0){
				JOptionPane.showMessageDialog(null, "客户名称不能为空", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(name.length()>20){
				JOptionPane.showMessageDialog(null, "客户名称长度不能大于20", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			cb.setCustomer_name(name);
			//获得联系人
			String contact = this.acd.getTextContact().getText();
			cb.setCustomer_contact(contact);
			//获得联系电话
			String tel = this.acd.getTextTel().getText();
			cb.setCustomer_tel(tel);
			//获得客户地址
			String addr = this.acd.getTextAddress().getText();
			cb.setCustomer_addr(addr);
			//备注
			String note = this.acd.getTextNote().getText();
			cb.setCustomer_note(note);
			if(CusDAO.insertCustomer(cb)){                                                                         
				JOptionPane.showMessageDialog(null, "新增成功！");
			}
			this.acd.dispose();
			cd=new CustomerSetDialog(null, "系统设置",true, cb);
			this.cd.setTableData();
		}else if(cmd.equals("Exit")){
			CustomerBean cb  = new CustomerBean();
			this.acd.dispose();
			cd=new CustomerSetDialog(null, "系统设置",true, cb);
			this.cd.setTableData();
			
		}
	
	}

}
 
