package cn.com.service.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import cn.com.beans.EmployeeBean;
import cn.com.daos.settings.EmployeeDAOImpl;
import cn.com.daos.settings.EmployeeDAOInf;
import cn.com.views.settings.AddEmployeeDialog;
import cn.com.views.settings.EmployeeSetDialog;
import cn.com.views.settings.SupplierSetDialog;


public class AddEmployeeService implements ActionListener,KeyListener {
	private AddEmployeeDialog aed;
	private EmployeeDAOInf EmpDAO;
	private EmployeeSetDialog ed;
	public AddEmployeeService (AddEmployeeDialog aed,EmployeeSetDialog ed){
		this.aed = aed;
		this.ed = ed;
		EmpDAO = new EmployeeDAOImpl();
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
			EmployeeBean eb  = new EmployeeBean();
			//���Ա�����
			String id = this.aed.getTextNO().getText();
//			String id = this.ad.getTextName().getText();
			if(id.length() == 0){
				JOptionPane.showMessageDialog(null, "Ա����Ų���Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}if(EmpDAO.isExistIbfoById(id)){
				JOptionPane.showMessageDialog(null, "Ա������Ѵ���", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
		    eb.setEmployee_id(id);
			//���Ա������
			String name = this.aed.getTextName().getText();
			if(name.length() == 0){
				JOptionPane.showMessageDialog(null, "Ա�����Ʋ���Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(name.length()>20){
				JOptionPane.showMessageDialog(null, "Ա�����Ƴ��Ȳ��ܴ���20", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			eb.setEmployee_name(name);
			//�������ְλ
			String title = this.aed.getTextTitle().getText();
			eb.setEmployee_title(title);
			//�����ϵ�绰
			String tel = this.aed.getTextTel().getText();
			eb.setEmployee_tel(tel);
			//��ù����̵�ַ
			String addr = this.aed.getTextAddress().getText();
			eb.setEmployee_addr(addr);
			//��ע
			String note = this.aed.getTextNote().getText();
			eb.setEmployee_note(note);
			if(EmpDAO.insertEmployee(eb)){                                                                         
				JOptionPane.showMessageDialog(null, "�����ɹ���");
			}
			this.aed.dispose();
			ed=new EmployeeSetDialog(null, "ϵͳ����",true, eb);
			this.ed.setTableData();
		}else if(cmd.equals("Exit")){
			EmployeeBean eb  = new EmployeeBean();
			this.aed.dispose();
			ed=new EmployeeSetDialog(null, "ϵͳ����",true, eb);
			this.ed.setTableData();
		}
	
	}

}
 
