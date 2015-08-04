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
			 new AddCustomerDialog(cd,"���Ӳֿ�",true);
		}else if(command.equals("Update")){
			//��ȡ�����ѡ��
			JTable table = cd.getTable();
			int rowIndex = table.getSelectedRow();
			//�жϱ����Ƿ������ݻ����û��Ƿ�ѡ����һ����Ϣ
			if(table.getModel().getRowCount()>0&&rowIndex>=0){
				//��ȡҪ�༭�Ķ���
				CustomerBean cb = (CustomerBean)table.getModel().getValueAt(rowIndex, 1);
//				UpdateGoodsDialog ud = new UpdateGoodsDialog(gb,gd);
				cd.dispose();
			 new UpdateCustomerDialog(cd,"�޸Ĳֿ�",true,cb);
				
			}else{
				JOptionPane.showMessageDialog(null, "û��ѡ��Ҫ�����Ķ���!");
			}
		}else if(command.equals("Del")){
			//��ȡ�����ѡ��
			JTable table = cd.getTable();
			int rowIndex = table.getSelectedRow();
			//�жϱ����Ƿ������ݻ����û��Ƿ�ѡ����һ����Ϣ
			if(table.getModel().getRowCount()>0&&rowIndex>=0){
				//��ȡҪ�༭�Ķ���
				CustomerBean cb = (CustomerBean)table.getModel().getValueAt(rowIndex, 1);
				int result = JOptionPane.showConfirmDialog(cd, "ȷ��Ҫɾ��"+cb+"���������Ϣô��");
				if(result == JOptionPane.YES_OPTION){
					if(CusDAO.deleteCustomer(cb)){
						JOptionPane.showMessageDialog(null, "�����ɹ���");
						cd.setTableData();
					}
				}
			}else{
				JOptionPane.showMessageDialog(null, "û��ѡ��Ҫ�����Ķ���!");
			}
		}else if(command.equals("Exit")){
			this.cd.dispose();
		}
	}

}

