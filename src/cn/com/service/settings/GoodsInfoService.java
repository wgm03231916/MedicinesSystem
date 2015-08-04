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
	public GoodsInfoService(GoodsInfoDialog gd){//gd待dispose
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
			 new AddGoodsDialog(gd,"增加商品",true);
		}else if(command.equals("Update")){
			//获取表和所选行
			JTable table = gd.getTable();
			int rowIndex = table.getSelectedRow();
			
			//判断表中是否有数据或者用户是否选择了一行信息
			if(table.getModel().getRowCount()>0&&rowIndex>=0){
				//获取要编辑的对象
				GoodsBean gb = (GoodsBean)table.getModel().getValueAt(rowIndex, 1);
//				UpdateGoodsDialog ud = new UpdateGoodsDialog(gb,gd);
	            gd.dispose();
				new UpdateGoodsDialog(gd,"修改商品",true,gb);
				
			}else{
				JOptionPane.showMessageDialog(null, "没有选择要操作的对象!");
			}
		}else if(command.equals("Del")){
			//获取表和所选行
			JTable table = gd.getTable();
			int rowIndex = table.getSelectedRow();
		
			//判断表中是否有数据或者用户是否选择了一行信息
			if(table.getModel().getRowCount()>0&&rowIndex>=0){
				//获取要编辑的对象
				GoodsBean gb = (GoodsBean)table.getModel().getValueAt(rowIndex, 1);
				int result = JOptionPane.showConfirmDialog(gd, "确认要删除"+gb+"及其相关信息么？");
				if(result == JOptionPane.YES_OPTION){
					if(GoodsDAO.deleteGoods(gb)){
						JOptionPane.showMessageDialog(null, "操作成功！");
						gd.setTableData();
					}
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "没有选择要操作的对象!");
			}
		}else if(command.equals("Exit")){
			this.gd.dispose();
		}
		
		
	}
}
