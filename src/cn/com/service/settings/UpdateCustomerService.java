package cn.com.service.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import cn.com.beans.CustomerBean;
import cn.com.daos.settings.CustomerDAOImpl;
import cn.com.daos.settings.CustomerDAOInf;
import cn.com.views.settings.CustomerSetDialog;
import cn.com.views.settings.UpdateCustomerDialog;



public class UpdateCustomerService implements ActionListener,KeyListener {
	private UpdateCustomerDialog ucd;
	private CustomerDAOInf CusDAO;
	private CustomerSetDialog cd;
	private CustomerBean cb;
	public UpdateCustomerService (UpdateCustomerDialog ucd,CustomerSetDialog cd,CustomerBean cb){
		this.ucd = ucd;
		this.cd = cd;
		this.cb = cb;
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
			String id = this.ucd.getTextId().getText();
//			String id = this.ad.getTextName().getText();
			if(id.length() == 0){
				JOptionPane.showMessageDialog(null, "客户编号不能为空", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
		    cb.setCustomer_id(id);
			//获得客户名称
			String name = this.ucd.getTextName().getText();
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
			String contact = this.ucd.gettextContact().getText();
			cb.setCustomer_contact(contact);
			//获得联系电话
			String tel = this.ucd.getTextTel().getText();
			cb.setCustomer_tel(tel);
			//获得客户地址
			String addr = this.ucd.getTextAddr().getText();
			cb.setCustomer_addr(addr);
			//备注
			String note = this.ucd.getTextNote().getText();
			cb.setCustomer_note(note);
			if(CusDAO.updateCustomer(cb)){
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.ucd.dispose();
				cd=new CustomerSetDialog(null, "系统设置",true, cb);
				this.cd.setTableData();
	
			}else{
				JOptionPane.showMessageDialog(null, "修改失败！");
			}
		}else if(cmd.equals("Exit")){
			CustomerBean cb  = new CustomerBean();
			this.ucd.dispose();
			cd=new CustomerSetDialog(null, "系统设置",true, cb);
			this.cd.setTableData();
		}
	
	}

}
 

