package cn.com.service.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import cn.com.beans.SupplierBean;
import cn.com.daos.settings.SupplierDAOImpl;
import cn.com.daos.settings.SupplierDAOInf;
import cn.com.views.settings.AddSupplierDialog;
import cn.com.views.settings.CustomerSetDialog;
import cn.com.views.settings.SupplierSetDialog;

public class AddSupplierService implements ActionListener,KeyListener {
	private AddSupplierDialog asd;
	private SupplierDAOInf SupDAO;
	private SupplierSetDialog sd;
	public AddSupplierService (AddSupplierDialog asd,SupplierSetDialog sd){
		this.asd = asd;
		this.sd = sd;
		SupDAO = new SupplierDAOImpl();
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
			SupplierBean sb  = new SupplierBean();
			//��ù����̱��
			String id = this.asd.getTextId().getText();
//			String id = this.ad.getTextName().getText();
			if(id.length() == 0){
				JOptionPane.showMessageDialog(null, "�����̱�Ų���Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}if(SupDAO.isExistIbfoById(id)){
				JOptionPane.showMessageDialog(null, "�����̱���Ѵ���", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
		    sb.setSupplier_id(id);
			//��ù���������
			String name = this.asd.getTextName().getText();
			if(name.length() == 0){
				JOptionPane.showMessageDialog(null, "�ֿ����Ʋ���Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(name.length()>30){
				JOptionPane.showMessageDialog(null, "�ֿ����Ƴ��Ȳ��ܴ���30", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			sb.setSupplier_name(name);
			//�����ϵ��
			String contact = this.asd.gettextContact().getText();
			sb.setSupplier_contact(contact);
			//�����ϵ�绰
			String tel = this.asd.getTextTel().getText();
			sb.setSupplier_tel(tel);
			//��ù����̵�ַ
			String addr = this.asd.getTextAddr().getText();
			sb.setSupplier_addr(addr);
			//��ע
			String note = this.asd.getTextNote().getText();
			sb.setSupplier_note(note);
			if(SupDAO.insertSupplier(sb)){                                                                         
				JOptionPane.showMessageDialog(null, "�����ɹ���");
			}
			this.asd.dispose();
			sd=new SupplierSetDialog(null, "ϵͳ����",true, sb);
			this.sd.setTableData();
		}else if(cmd.equals("Exit")){
			SupplierBean sb  = new SupplierBean();
			this.asd.dispose();
			sd=new SupplierSetDialog(null, "ϵͳ����",true, sb);
			this.sd.setTableData();
		}
	
	}

}
 
