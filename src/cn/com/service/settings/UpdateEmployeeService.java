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
			//获得员工编号
			String id = this.ued.getTextId().getText();
//			String id = this.ad.getTextName().getText();
			if(id.length() == 0){
				JOptionPane.showMessageDialog(null, "员工编号不能为空", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
		    eb.setEmployee_id(id);
			//获得员工名称
			String name = this.ued.getTextName().getText();
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
			String title = this.ued.gettextTitle().getText();
			eb.setEmployee_title(title);
			//获得联系电话
			String tel = this.ued.getTextTel().getText();
			eb.setEmployee_tel(tel);
			//获得供货商地址
			String addr = this.ued.getTextAddr().getText();
			eb.setEmployee_addr(addr);
			//备注
			String note = this.ued.getTextNote().getText();
			eb.setEmployee_name(note);
			if(EmpDAO.updateEmployee(eb)){
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.ued.dispose();
				ed=new EmployeeSetDialog(null, "系统设置",true, eb);
				this.ed.setTableData();
	
			}else{
				JOptionPane.showMessageDialog(null, "修改失败！");
			}
		}else if(cmd.equals("Exit")){
			EmployeeBean eb  = new EmployeeBean();
			this.ued.dispose();
			ed=new EmployeeSetDialog(null, "系统设置",true, eb);
			this.ed.setTableData();
		}
	
	}

}
 
