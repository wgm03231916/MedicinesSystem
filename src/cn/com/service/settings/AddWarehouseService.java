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
			//获得仓库编号
			String id = this.awd.getTextId().getText();
//			String id = this.ad.getTextName().getText();
			if(id.length() == 0){
				JOptionPane.showMessageDialog(null, "仓库编号不能为空", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}if(WareDAO.isExistIbfoById(id)){
				JOptionPane.showMessageDialog(null, "仓库编号已存在", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			wb.setWarehouse_id(id);
			//获得仓库名称
			String name = this.awd.getTextName().getText();
			if(name.length() == 0){
				JOptionPane.showMessageDialog(null, "仓库名称不能为空", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(name.length()>30){
				JOptionPane.showMessageDialog(null, "仓库名称长度不能大于30", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String regex="1([\\d]{10})|((\\+[0-9]{2,4})?\\(?[0-9]+\\)?-?)?[0-9]{7,8}";
			Pattern p = Pattern.compile(regex);
			 if(!p.matches(regex,this.awd.getTextTel().getText().toString())){
				 JOptionPane.showMessageDialog(null, "电话号码不符合逻辑！", "错误", JOptionPane.ERROR_MESSAGE);
					return;
			 }

			wb.setWarehouse_name(name);
			//获得负责人
			String head = this.awd.getTextHead().getText();
			wb.setWarehouse_head(head);
			//获得联系电话
			String tel = this.awd.getTextTel().getText();
			wb.setWarehouse_tel(tel);
			//获得仓库地址
			String addr = this.awd.getTextAddr().getText();
			wb.setWarehouse_addr(addr);
			//备注
			String note = this.awd.getTextNote().getText();
			wb.setWarehouse_note(note);
			if(WareDAO.insertWarehouse(wb)){                                                                         
				JOptionPane.showMessageDialog(null, "新增成功！");
			}
			this.awd.dispose();
			wd=new WarehouseSetDialog(null, "系统设置",true, wb);
			this.wd.setTableData();
		}else if(cmd.equals("Exit")){
			WarehouseBean  wb  = new WarehouseBean();
			this.awd.dispose();
			wd=new WarehouseSetDialog(null, "系统设置",true, wb);
			this.wd.setTableData();
		}
	
	}

}
