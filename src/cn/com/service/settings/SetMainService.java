package cn.com.service.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cn.com.beans.CustomerBean;
import cn.com.beans.EmployeeBean;
import cn.com.beans.GoodsBean;
import cn.com.beans.SupplierBean;
import cn.com.beans.WarehouseBean;
import cn.com.views.settings.CustomerSetDialog;
import cn.com.views.settings.EmployeeSetDialog;
import cn.com.views.settings.GoodsInfoDialog;
import cn.com.views.settings.SetMainFrame;
import cn.com.views.settings.SupplierSetDialog;
import cn.com.views.settings.WarehouseSetDialog;

public class SetMainService implements ActionListener,MouseListener {
	
//	private SetMainFrame sf;
	private WarehouseBean wb;
	private GoodsBean gb;
	private SupplierBean sb;
	private CustomerBean cb;
	private EmployeeBean eb;
//	public SetMainService(SetMainFrame sf){
//		this.sf = sf;

//	}


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
		if(command.equals("Goods")){
			new GoodsInfoDialog(null,"商品信息",true,gb);
		}else if(command.equals("Warehouse")){
			new WarehouseSetDialog(null,"仓库设置",true,wb);
		}else if(command.equals("Supplier")){
			new SupplierSetDialog(null,"供货商设置",true,sb);
		}else if(command.equals("Customer")){
			new CustomerSetDialog(null,"客户设置",true,cb);
		}
		else if(command.equals("Employee")){
			new EmployeeSetDialog(null,"员工设置",true,eb);
		}
			
	}
}
