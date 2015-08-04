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
			//��ÿͻ����
			String id = this.acd.getTextNO().getText();
//			String id = this.ad.getTextName().getText();
			if(id.length() == 0){
				JOptionPane.showMessageDialog(null, "�ͻ���Ų���Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}if(CusDAO.isExistIbfoById(id)){
				JOptionPane.showMessageDialog(null, "�ͻ�����Ѵ���", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
		    cb.setCustomer_id(id);
			//��ÿͻ�����
			String name = this.acd.getTextName().getText();
			if(name.length() == 0){
				JOptionPane.showMessageDialog(null, "�ͻ����Ʋ���Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(name.length()>20){
				JOptionPane.showMessageDialog(null, "�ͻ����Ƴ��Ȳ��ܴ���20", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			cb.setCustomer_name(name);
			//�����ϵ��
			String contact = this.acd.getTextContact().getText();
			cb.setCustomer_contact(contact);
			//�����ϵ�绰
			String tel = this.acd.getTextTel().getText();
			cb.setCustomer_tel(tel);
			//��ÿͻ���ַ
			String addr = this.acd.getTextAddress().getText();
			cb.setCustomer_addr(addr);
			//��ע
			String note = this.acd.getTextNote().getText();
			cb.setCustomer_note(note);
			if(CusDAO.insertCustomer(cb)){                                                                         
				JOptionPane.showMessageDialog(null, "�����ɹ���");
			}
			this.acd.dispose();
			cd=new CustomerSetDialog(null, "ϵͳ����",true, cb);
			this.cd.setTableData();
		}else if(cmd.equals("Exit")){
			CustomerBean cb  = new CustomerBean();
			this.acd.dispose();
			cd=new CustomerSetDialog(null, "ϵͳ����",true, cb);
			this.cd.setTableData();
			
		}
	
	}

}
 
