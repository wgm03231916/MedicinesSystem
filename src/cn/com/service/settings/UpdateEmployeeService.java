package cn.com.service.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import cn.com.beans.EmployeeBean;
import cn.com.daos.settings.EmployeeDAOImpl;
import cn.com.daos.settings.EmployeeDAOInf;
import cn.com.views.settings.EmployeeSetDialog;
import cn.com.views.settings.UpdateEmployeeDialog;


public class UpdateEmployeeService implements ActionListener,KeyListener {
	private UpdateEmployeeDialog ued;
	private EmployeeDAOInf EmpDAO;
	private EmployeeSetDialog ed;
	private EmployeeBean eb;
	public UpdateEmployeeService (UpdateEmployeeDialog ued ,EmployeeSetDialog ed,EmployeeBean eb){
		this.ued = ued;
		this.ed = ed;
		this.eb = eb;
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
			String id = this.ued.getTextId().getText();
//			String id = this.ad.getTextName().getText();
			if(id.length() == 0){
				JOptionPane.showMessageDialog(null, "Ա����Ų���Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
		    eb.setEmployee_id(id);
			//���Ա������
			String name = this.ued.getTextName().getText();
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
			String title = this.ued.gettextTitle().getText();
			eb.setEmployee_title(title);
			//�����ϵ�绰
			String tel = this.ued.getTextTel().getText();
			eb.setEmployee_tel(tel);
			//��ù����̵�ַ
			String addr = this.ued.getTextAddr().getText();
			eb.setEmployee_addr(addr);
			//��ע
			String note = this.ued.getTextNote().getText();
			eb.setEmployee_name(note);
			if(EmpDAO.updateEmployee(eb)){
				JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
				this.ued.dispose();
				ed=new EmployeeSetDialog(null, "ϵͳ����",true, eb);
				this.ed.setTableData();
	
			}else{
				JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�");
			}
		}else if(cmd.equals("Exit")){
			EmployeeBean eb  = new EmployeeBean();
			this.ued.dispose();
			ed=new EmployeeSetDialog(null, "ϵͳ����",true, eb);
			this.ed.setTableData();
		}
	
	}

}
 
