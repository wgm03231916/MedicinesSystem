package cn.com.service.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import cn.com.beans.GoodsBean;
import cn.com.daos.settings.GoodsDAOImpl;
import cn.com.daos.settings.GoodsDAOInf;
import cn.com.views.settings.AddGoodsDialog;
import cn.com.views.settings.GoodsInfoDialog;
import cn.com.views.settings.UpdateGoodsDialog;

public class GoodsInfoService implements ActionListener,MouseListener {
	private GoodsInfoDialog gd;
	private GoodsDAOInf  GoodsDAO;
	public GoodsInfoService(GoodsInfoDialog gd){//gd��dispose
		this.gd = gd;
		GoodsDAO = new GoodsDAOImpl();
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
			 gd.dispose();
			 new AddGoodsDialog(gd,"������Ʒ",true);
		}else if(command.equals("Update")){
			//��ȡ�����ѡ��
			JTable table = gd.getTable();
			int rowIndex = table.getSelectedRow();
			
			//�жϱ����Ƿ������ݻ����û��Ƿ�ѡ����һ����Ϣ
			if(table.getModel().getRowCount()>0&&rowIndex>=0){
				//��ȡҪ�༭�Ķ���
				GoodsBean gb = (GoodsBean)table.getModel().getValueAt(rowIndex, 1);
//				UpdateGoodsDialog ud = new UpdateGoodsDialog(gb,gd);
	            gd.dispose();
				new UpdateGoodsDialog(gd,"�޸���Ʒ",true,gb);
				
			}else{
				JOptionPane.showMessageDialog(null, "û��ѡ��Ҫ�����Ķ���!");
			}
		}else if(command.equals("Del")){
			//��ȡ�����ѡ��
			JTable table = gd.getTable();
			int rowIndex = table.getSelectedRow();
		
			//�жϱ����Ƿ������ݻ����û��Ƿ�ѡ����һ����Ϣ
			if(table.getModel().getRowCount()>0&&rowIndex>=0){
				//��ȡҪ�༭�Ķ���
				GoodsBean gb = (GoodsBean)table.getModel().getValueAt(rowIndex, 1);
				int result = JOptionPane.showConfirmDialog(gd, "ȷ��Ҫɾ��"+gb+"���������Ϣô��");
				if(result == JOptionPane.YES_OPTION){
					if(GoodsDAO.deleteGoods(gb)){
						JOptionPane.showMessageDialog(null, "�����ɹ���");
						gd.setTableData();
					}
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "û��ѡ��Ҫ�����Ķ���!");
			}
		}else if(command.equals("Exit")){
			this.gd.dispose();
		}
		
		
	}
}
