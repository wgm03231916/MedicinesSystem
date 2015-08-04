package cn.com.service.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import cn.com.beans.CustomerBean;
import cn.com.daos.settings.CustomerDAOImpl;
import cn.com.daos.settings.CustomerDAOInf;
import cn.com.views.settings.AddCustomerDialog;
import cn.com.views.settings.CustomerSetDialog;
import cn.com.views.settings.UpdateCustomerDialog;



public class CustomerSetService implements ActionListener,MouseListener {
	private CustomerSetDialog cd;
	private CustomerDAOInf  CusDAO;
	public CustomerSetService(CustomerSetDialog cd ){
		this.cd = cd;
		CusDAO = new CustomerDAOImpl();
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
			 cd.dispose();
			 new AddCustomerDialog(cd,"增加仓库",true);
		}else if(command.equals("Update")){
			//获取表和所选行
			JTable table = cd.getTable();
			int rowIndex = table.getSelectedRow();
			//判断表中是否有数据或者用户是否选择了一行信息
			if(table.getModel().getRowCount()>0&&rowIndex>=0){
				//获取要编辑的对象
				CustomerBean cb = (CustomerBean)table.getModel().getValueAt(rowIndex, 1);
//				UpdateGoodsDialog ud = new UpdateGoodsDialog(gb,gd);
				cd.dispose();
			 new UpdateCustomerDialog(cd,"修改仓库",true,cb);
				
			}else{
				JOptionPane.showMessageDialog(null, "没有选择要操作的对象!");
			}
		}else if(command.equals("Del")){
			//获取表和所选行
			JTable table = cd.getTable();
			int rowIndex = table.getSelectedRow();
			//判断表中是否有数据或者用户是否选择了一行信息
			if(table.getModel().getRowCount()>0&&rowIndex>=0){
				//获取要编辑的对象
				CustomerBean cb = (CustomerBean)table.getModel().getValueAt(rowIndex, 1);
				int result = JOptionPane.showConfirmDialog(cd, "确认要删除"+cb+"及其相关信息么？");
				if(result == JOptionPane.YES_OPTION){
					if(CusDAO.deleteCustomer(cb)){
						JOptionPane.showMessageDialog(null, "操作成功！");
						cd.setTableData();
					}
				}
			}else{
				JOptionPane.showMessageDialog(null, "没有选择要操作的对象!");
			}
		}else if(command.equals("Exit")){
			this.cd.dispose();
		}
	}

}

