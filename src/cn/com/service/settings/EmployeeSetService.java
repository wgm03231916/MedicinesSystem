package cn.com.service.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import cn.com.beans.EmployeeBean;
import cn.com.daos.settings.EmployeeDAOImpl;
import cn.com.daos.settings.EmployeeDAOInf;
import cn.com.views.settings.AddEmployeeDialog;
import cn.com.views.settings.EmployeeSetDialog;
import cn.com.views.settings.UpdateEmployeeDialog;



public class EmployeeSetService implements ActionListener,MouseListener {
	private EmployeeSetDialog ed;
	private EmployeeDAOInf  EmpDAO;
	public EmployeeSetService(EmployeeSetDialog ed){
		this.ed = ed;
		EmpDAO = new EmployeeDAOImpl();
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
			ed.dispose();
			 new AddEmployeeDialog(ed,"增加仓库",true);
		}else if(command.equals("Update")){
			//获取表和所选行
			JTable table = ed.getTable();
			int rowIndex = table.getSelectedRow();
			//判断表中是否有数据或者用户是否选择了一行信息
			if(table.getModel().getRowCount()>0&&rowIndex>=0){
				//获取要编辑的对象
				EmployeeBean eb = (EmployeeBean)table.getModel().getValueAt(rowIndex, 1);
//				UpdateGoodsDialog ud = new UpdateGoodsDialog(gb,gd);
				ed.dispose();
	
			 new UpdateEmployeeDialog(ed,"修改仓库",true,eb);
				
			}else{
				JOptionPane.showMessageDialog(null, "没有选择要操作的对象!");
			}
		}else if(command.equals("Del")){
			//获取表和所选行
			JTable table = ed.getTable();
			int rowIndex = table.getSelectedRow();
			//判断表中是否有数据或者用户是否选择了一行信息
			if(table.getModel().getRowCount()>0&&rowIndex>=0){
				//获取要编辑的对象
				EmployeeBean eb = (EmployeeBean)table.getModel().getValueAt(rowIndex, 1);
				int result = JOptionPane.showConfirmDialog(ed, "确认要删除"+eb+"及其相关信息么？");
				if(result == JOptionPane.YES_OPTION){
					if(EmpDAO.deleteEmployee(eb)){
						JOptionPane.showMessageDialog(null, "操作成功！");
						ed.setTableData();
					}
				}
			}else{
				JOptionPane.showMessageDialog(null, "没有选择要操作的对象!");
			}
		}else if(command.equals("Exit")){
			this.ed.dispose();
		}
	}

}


