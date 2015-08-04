package cn.com.service.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import cn.com.beans.WarehouseBean;
import cn.com.daos.settings.WarehouseDAOImpl;
import cn.com.daos.settings.WarehouseDAOInf;
import cn.com.views.settings.AddGoodsDialog;
import cn.com.views.settings.AddWarehouseDialog;
import cn.com.views.settings.UpdateGoodsDialog;
import cn.com.views.settings.UpdateWarehouseDialog;
import cn.com.views.settings.WarehouseSetDialog;


public class WarehouseSetService implements ActionListener,MouseListener {
	private WarehouseSetDialog wd;
	private WarehouseDAOInf  WareDAO;
	public WarehouseSetService(WarehouseSetDialog wd){
		this.wd = wd;
		WareDAO = new WarehouseDAOImpl();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if(command.equals("Add")){
			 wd.dispose();
			 new AddWarehouseDialog(wd,"增加仓库",true);
		}else if(command.equals("Update")){
			//获取表和所选行
			JTable table = wd.getTable();
			int rowIndex = table.getSelectedRow();
			
			//判断表中是否有数据或者用户是否选择了一行信息
			if(table.getModel().getRowCount()>0&&rowIndex>=0){
				//获取要编辑的对象
				WarehouseBean wb = (WarehouseBean)table.getModel().getValueAt(rowIndex, 1);
//				UpdateGoodsDialog ud = new UpdateGoodsDialog(gb,gd);
				wd.dispose();
			 new UpdateWarehouseDialog(wd,"修改仓库",true,wb);
			}else{
				JOptionPane.showMessageDialog(null, "没有选择要操作的对象!");
			}
		}else if(command.equals("Del")){
			//获取表和所选行
			JTable table = wd.getTable();
			int rowIndex = table.getSelectedRow();
		
			//判断表中是否有数据或者用户是否选择了一行信息
			if(table.getModel().getRowCount()>0&&rowIndex>=0){
				//获取要编辑的对象
				WarehouseBean wb = (WarehouseBean)table.getModel().getValueAt(rowIndex, 1);
				int result = JOptionPane.showConfirmDialog(wd, "确认要删除"+wb+"及其相关信息么？");
				if(result == JOptionPane.YES_OPTION){
					if(WareDAO.deleteWarehouse(wb)){
						JOptionPane.showMessageDialog(null, "操作成功！");
						wd.setTableData();
					}
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "没有选择要操作的对象!");
			}
		}else if(command.equals("Exit")){
			this.wd.dispose();
		}
	}

}
