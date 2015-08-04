package cn.com.service.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import cn.com.beans.SupplierBean;
import cn.com.daos.settings.SupplierDAOImpl;
import cn.com.daos.settings.SupplierDAOInf;
import cn.com.views.settings.SupplierSetDialog;
import cn.com.views.settings.UpdateSupplierDialog;

public class UpdateSupplierService implements ActionListener,KeyListener {
	private UpdateSupplierDialog upd;
	private SupplierDAOInf SupDAO;
	private SupplierSetDialog sd;
	private SupplierBean sb;
	public UpdateSupplierService (UpdateSupplierDialog upd,SupplierSetDialog sd,SupplierBean sb){
		this.upd = upd;
		this.sd = sd;
		this.sb = sb;
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
			String id = this.upd.getTextId().getText();
//			String id = this.ad.getTextName().getText();
			if(id.length() == 0){
				JOptionPane.showMessageDialog(null, "�����̱�Ų���Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
		    sb.setSupplier_id(id);
			//��ù���������
			String name = this.upd.getTextName().getText();
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
			String contact = this.upd.gettextContact().getText();
			sb.setSupplier_contact(contact);
			//�����ϵ�绰
			String tel = this.upd.getTextTel().getText();
			sb.setSupplier_tel(tel);
			//��ù����̵�ַ
			String addr = this.upd.getTextAddr().getText();
			sb.setSupplier_addr(addr);
			//��ע
			String note = this.upd.getTextNote().getText();
			sb.setSupplier_note(note);
			if(SupDAO.updateSupplier(sb)){
				JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
				this.upd.dispose();
				sd=new SupplierSetDialog(null, "ϵͳ����",true, sb);
				this.sd.setTableData();
	
			}else{
				JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�");
			}
		}else if(cmd.equals("Exit")){
			SupplierBean sb  = new SupplierBean();
			this.upd.dispose();
			sd=new SupplierSetDialog(null, "ϵͳ����",true, sb);
			this.sd.setTableData();
		}
	
	}

}
 

