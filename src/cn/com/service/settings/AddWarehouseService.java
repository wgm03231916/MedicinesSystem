package cn.com.service.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import cn.com.beans.WarehouseBean;
import cn.com.daos.settings.WarehouseDAOImpl;
import cn.com.daos.settings.WarehouseDAOInf;
import cn.com.views.settings.AddWarehouseDialog;
import cn.com.views.settings.WarehouseSetDialog;


public class AddWarehouseService implements ActionListener,KeyListener {
	private AddWarehouseDialog awd;
	private WarehouseDAOInf WareDAO;
	private WarehouseSetDialog wd;
	public AddWarehouseService (AddWarehouseDialog awd,WarehouseSetDialog wd){
		this.awd = awd;
		this.wd = wd;
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
			String id = this.awd.getTextId().getText();
//			String id = this.ad.getTextName().getText();
			if(id.length() == 0){
				JOptionPane.showMessageDialog(null, "�ֿ��Ų���Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}if(WareDAO.isExistIbfoById(id)){
				JOptionPane.showMessageDialog(null, "�ֿ����Ѵ���", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			wb.setWarehouse_id(id);
			//��òֿ�����
			String name = this.awd.getTextName().getText();
			if(name.length() == 0){
				JOptionPane.showMessageDialog(null, "�ֿ����Ʋ���Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(name.length()>30){
				JOptionPane.showMessageDialog(null, "�ֿ����Ƴ��Ȳ��ܴ���30", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String regex="1([\\d]{10})|((\\+[0-9]{2,4})?\\(?[0-9]+\\)?-?)?[0-9]{7,8}";
			Pattern p = Pattern.compile(regex);
			 if(!p.matches(regex,this.awd.getTextTel().getText().toString())){
				 JOptionPane.showMessageDialog(null, "�绰���벻�����߼���", "����", JOptionPane.ERROR_MESSAGE);
					return;
			 }

			wb.setWarehouse_name(name);
			//��ø�����
			String head = this.awd.getTextHead().getText();
			wb.setWarehouse_head(head);
			//�����ϵ�绰
			String tel = this.awd.getTextTel().getText();
			wb.setWarehouse_tel(tel);
			//��òֿ��ַ
			String addr = this.awd.getTextAddr().getText();
			wb.setWarehouse_addr(addr);
			//��ע
			String note = this.awd.getTextNote().getText();
			wb.setWarehouse_note(note);
			if(WareDAO.insertWarehouse(wb)){                                                                         
				JOptionPane.showMessageDialog(null, "�����ɹ���");
			}
			this.awd.dispose();
			wd=new WarehouseSetDialog(null, "ϵͳ����",true, wb);
			this.wd.setTableData();
		}else if(cmd.equals("Exit")){
			WarehouseBean  wb  = new WarehouseBean();
			this.awd.dispose();
			wd=new WarehouseSetDialog(null, "ϵͳ����",true, wb);
			this.wd.setTableData();
		}
	
	}

}
