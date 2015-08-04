package cn.com.service.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import cn.com.beans.WarehouseBean;
import cn.com.daos.settings.WarehouseDAOImpl;
import cn.com.daos.settings.WarehouseDAOInf;
import cn.com.views.settings.UpdateWarehouseDialog;
import cn.com.views.settings.WarehouseSetDialog;

public class UpdateWarehouseService implements ActionListener,KeyListener{
	private UpdateWarehouseDialog uwd;
	private WarehouseBean wb;
	private WarehouseDAOInf WareDAO;
	private WarehouseSetDialog wd;
	public UpdateWarehouseService (UpdateWarehouseDialog uwd,WarehouseSetDialog wd,WarehouseBean wb){
		this.uwd = uwd;
		this.wd = wd;
		this.wb = wb;
		WareDAO = new WarehouseDAOImpl();
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
			WarehouseBean  wb  = new WarehouseBean();
			//��òֿ���
			String id = this.uwd.getTextId().getText();
//			String id = this.ad.getTextName().getText();
			if(id.length() == 0){
				JOptionPane.showMessageDialog(null, "�ֿ��Ų���Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			wb.setWarehouse_id(id);
			//��òֿ�����
			String name = this.uwd.getTextName().getText();
			if(name.length() == 0){
				JOptionPane.showMessageDialog(null, "�ֿ����Ʋ���Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(name.length()>30){
				JOptionPane.showMessageDialog(null, "�ֿ����Ƴ��Ȳ��ܴ���30", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			wb.setWarehouse_name(name);
			//��ø�����
			String head = this.uwd.getTextHead().getText();
			wb.setWarehouse_head(head);
			//�����ϵ�绰
			String tel = this.uwd.getTextTel().getText();
			wb.setWarehouse_tel(tel);
			//��òֿ��ַ
			String addr = this.uwd.getTextAddr().getText();
			wb.setWarehouse_addr(addr);
			//��ע
			String note = this.uwd.getTextNote().getText();
			wb.setWarehouse_note(note);
			if(WareDAO.updateWarehouse(wb)){
				JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
				this.uwd.dispose();
				wd=new WarehouseSetDialog(null, "ϵͳ����",true, wb);
				this.wd.setTableData();
	
			}else{
				JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�");
			}
			
			
		}else if(cmd.equals("Exit")){
			WarehouseBean  wb  = new WarehouseBean();
			this.uwd.dispose();
			wd=new WarehouseSetDialog(null, "ϵͳ����",true, wb);
			this.wd.setTableData();
		}
	}

}
