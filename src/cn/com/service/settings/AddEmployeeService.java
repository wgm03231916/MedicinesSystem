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
			//获得员工编号
			String id = this.aed.getTextNO().getText();
//			String id = this.ad.getTextName().getText();
			if(id.length() == 0){
				JOptionPane.showMessageDialog(null, "员工编号不能为空", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}if(EmpDAO.isExistIbfoById(id)){
				JOptionPane.showMessageDialog(null, "员工编号已存在", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
		    eb.setEmployee_id(id);
			//获得员工名称
			String name = this.aed.getTextName().getText();
			if(name.length() == 0){
				JOptionPane.showMessageDialog(null, "员工名称不能为空", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(name.length()>20){
				JOptionPane.showMessageDialog(null, "员工名称长度不能大于20", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			eb.setEmployee_name(name);
			//获得所属职位
			String title = this.aed.getTextTitle().getText();
			eb.setEmployee_title(title);
			//获得联系电话
			String tel = this.aed.getTextTel().getText();
			eb.setEmployee_tel(tel);
			//获得供货商地址
			String addr = this.aed.getTextAddress().getText();
			eb.setEmployee_addr(addr);
			//备注
			String note = this.aed.getTextNote().getText();
			eb.setEmployee_note(note);
			if(EmpDAO.insertEmployee(eb)){                                                                         
				JOptionPane.showMessageDialog(null, "新增成功！");
			}
			this.aed.dispose();
			ed=new EmployeeSetDialog(null, "系统设置",true, eb);
			this.ed.setTableData();
		}else if(cmd.equals("Exit")){
			EmployeeBean eb  = new EmployeeBean();
			this.aed.dispose();
			ed=new EmployeeSetDialog(null, "系统设置",true, eb);
			this.ed.setTableData();
		}
	
	}

}
 
