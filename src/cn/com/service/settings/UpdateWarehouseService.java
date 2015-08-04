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
			//获得仓库编号
			String id = this.uwd.getTextId().getText();
//			String id = this.ad.getTextName().getText();
			if(id.length() == 0){
				JOptionPane.showMessageDialog(null, "仓库编号不能为空", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			wb.setWarehouse_id(id);
			//获得仓库名称
			String name = this.uwd.getTextName().getText();
			if(name.length() == 0){
				JOptionPane.showMessageDialog(null, "仓库名称不能为空", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(name.length()>30){
				JOptionPane.showMessageDialog(null, "仓库名称长度不能大于30", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			wb.setWarehouse_name(name);
			//获得负责人
			String head = this.uwd.getTextHead().getText();
			wb.setWarehouse_head(head);
			//获得联系电话
			String tel = this.uwd.getTextTel().getText();
			wb.setWarehouse_tel(tel);
			//获得仓库地址
			String addr = this.uwd.getTextAddr().getText();
			wb.setWarehouse_addr(addr);
			//备注
			String note = this.uwd.getTextNote().getText();
			wb.setWarehouse_note(note);
			if(WareDAO.updateWarehouse(wb)){
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.uwd.dispose();
				wd=new WarehouseSetDialog(null, "系统设置",true, wb);
				this.wd.setTableData();
	
			}else{
				JOptionPane.showMessageDialog(null, "修改失败！");
			}
			
			
		}else if(cmd.equals("Exit")){
			WarehouseBean  wb  = new WarehouseBean();
			this.uwd.dispose();
			wd=new WarehouseSetDialog(null, "系统设置",true, wb);
			this.wd.setTableData();
		}
	}

}
