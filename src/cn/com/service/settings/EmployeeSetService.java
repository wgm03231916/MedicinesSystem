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
			 new AddEmployeeDialog(ed,"���Ӳֿ�",true);
		}else if(command.equals("Update")){
			//��ȡ�����ѡ��
			JTable table = ed.getTable();
			int rowIndex = table.getSelectedRow();
			//�жϱ����Ƿ������ݻ����û��Ƿ�ѡ����һ����Ϣ
			if(table.getModel().getRowCount()>0&&rowIndex>=0){
				//��ȡҪ�༭�Ķ���
				EmployeeBean eb = (EmployeeBean)table.getModel().getValueAt(rowIndex, 1);
//				UpdateGoodsDialog ud = new UpdateGoodsDialog(gb,gd);
				ed.dispose();
	
			 new UpdateEmployeeDialog(ed,"�޸Ĳֿ�",true,eb);
				
			}else{
				JOptionPane.showMessageDialog(null, "û��ѡ��Ҫ�����Ķ���!");
			}
		}else if(command.equals("Del")){
			//��ȡ�����ѡ��
			JTable table = ed.getTable();
			int rowIndex = table.getSelectedRow();
			//�жϱ����Ƿ������ݻ����û��Ƿ�ѡ����һ����Ϣ
			if(table.getModel().getRowCount()>0&&rowIndex>=0){
				//��ȡҪ�༭�Ķ���
				EmployeeBean eb = (EmployeeBean)table.getModel().getValueAt(rowIndex, 1);
				int result = JOptionPane.showConfirmDialog(ed, "ȷ��Ҫɾ��"+eb+"���������Ϣô��");
				if(result == JOptionPane.YES_OPTION){
					if(EmpDAO.deleteEmployee(eb)){
						JOptionPane.showMessageDialog(null, "�����ɹ���");
						ed.setTableData();
					}
				}
			}else{
				JOptionPane.showMessageDialog(null, "û��ѡ��Ҫ�����Ķ���!");
			}
		}else if(command.equals("Exit")){
			this.ed.dispose();
		}
	}

}


