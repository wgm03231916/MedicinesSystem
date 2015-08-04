package cn.com.service.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import cn.com.beans.SupplierBean;
import cn.com.daos.settings.SupplierDAOImpl;
import cn.com.daos.settings.SupplierDAOInf;
import cn.com.views.settings.AddSupplierDialog;
import cn.com.views.settings.SupplierSetDialog;
import cn.com.views.settings.UpdateSupplierDialog;

public class SupplierSetService implements ActionListener,MouseListener {
	private SupplierSetDialog sd;
	private SupplierDAOInf  SupDAO;
	public SupplierSetService(SupplierSetDialog sd){
		this.sd = sd;
		SupDAO = new SupplierDAOImpl();
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
			 sd.dispose();
			 new AddSupplierDialog(sd,"���Ӳֿ�",true);
		}else if(command.equals("Update")){
			//��ȡ�����ѡ��
			JTable table = sd.getTable();
			int rowIndex = table.getSelectedRow();
			//�жϱ����Ƿ������ݻ����û��Ƿ�ѡ����һ����Ϣ
			if(table.getModel().getRowCount()>0&&rowIndex>=0){
				//��ȡҪ�༭�Ķ���
				SupplierBean sb = (SupplierBean)table.getModel().getValueAt(rowIndex, 1);
//				UpdateGoodsDialog ud = new UpdateGoodsDialog(gb,gd);
				sd.dispose();
	
			 new UpdateSupplierDialog(sd,"�޸Ĳֿ�",true,sb);
				
			}else{
				JOptionPane.showMessageDialog(null, "û��ѡ��Ҫ�����Ķ���!");
			}
		}else if(command.equals("Del")){
			//��ȡ�����ѡ��
			JTable table = sd.getTable();
			int rowIndex = table.getSelectedRow();
			//�жϱ����Ƿ������ݻ����û��Ƿ�ѡ����һ����Ϣ
			if(table.getModel().getRowCount()>0&&rowIndex>=0){
				//��ȡҪ�༭�Ķ���
				SupplierBean sb = (SupplierBean)table.getModel().getValueAt(rowIndex, 1);
				int result = JOptionPane.showConfirmDialog(sd, "ȷ��Ҫɾ��"+sb+"���������Ϣô��");
				if(result == JOptionPane.YES_OPTION){
					if(SupDAO.deleteSupplier(sb)){
						JOptionPane.showMessageDialog(null, "�����ɹ���");
						sd.setTableData();
					}
				}
			}else{
				JOptionPane.showMessageDialog(null, "û��ѡ��Ҫ�����Ķ���!");
			}
		}else if(command.equals("Exit")){
			this.sd.dispose();
		}
	}

}

