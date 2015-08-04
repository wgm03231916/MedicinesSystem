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
			//获得供货商编号
			String id = this.asd.getTextId().getText();
//			String id = this.ad.getTextName().getText();
			if(id.length() == 0){
				JOptionPane.showMessageDialog(null, "供货商编号不能为空", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}if(SupDAO.isExistIbfoById(id)){
				JOptionPane.showMessageDialog(null, "供货商编号已存在", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
		    sb.setSupplier_id(id);
			//获得供货商名称
			String name = this.asd.getTextName().getText();
			if(name.length() == 0){
				JOptionPane.showMessageDialog(null, "仓库名称不能为空", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(name.length()>30){
				JOptionPane.showMessageDialog(null, "仓库名称长度不能大于30", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			sb.setSupplier_name(name);
			//获得联系人
			String contact = this.asd.gettextContact().getText();
			sb.setSupplier_contact(contact);
			//获得联系电话
			String tel = this.asd.getTextTel().getText();
			sb.setSupplier_tel(tel);
			//获得供货商地址
			String addr = this.asd.getTextAddr().getText();
			sb.setSupplier_addr(addr);
			//备注
			String note = this.asd.getTextNote().getText();
			sb.setSupplier_note(note);
			if(SupDAO.insertSupplier(sb)){                                                                         
				JOptionPane.showMessageDialog(null, "新增成功！");
			}
			this.asd.dispose();
			sd=new SupplierSetDialog(null, "系统设置",true, sb);
			this.sd.setTableData();
		}else if(cmd.equals("Exit")){
			SupplierBean sb  = new SupplierBean();
			this.asd.dispose();
			sd=new SupplierSetDialog(null, "系统设置",true, sb);
			this.sd.setTableData();
		}
	
	}

}
 
