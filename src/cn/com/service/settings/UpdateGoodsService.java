package cn.com.service.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import cn.com.beans.GoodsBean;
import cn.com.daos.settings.GoodsDAOImpl;
import cn.com.daos.settings.GoodsDAOInf;
import cn.com.views.settings.GoodsInfoDialog;
import cn.com.views.settings.UpdateGoodsDialog;

public class UpdateGoodsService implements ActionListener,KeyListener {
	private UpdateGoodsDialog ud;
	private GoodsBean gb;
	private GoodsDAOInf GoodsDAO;
	private GoodsInfoDialog gd;
	public UpdateGoodsService (UpdateGoodsDialog ud,GoodsInfoDialog gd,GoodsBean gb){
		this.ud = ud;
		this.gd = gd;
		this.gb = gb;
		
		GoodsDAO = new GoodsDAOImpl();
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
			GoodsBean  gb  = new GoodsBean();
			//获得商品编号
			String id = this.ud.getTextNO().getText();
//			String id = this.ad.getTextName().getText();
			if(id.length() == 0){
				JOptionPane.showMessageDialog(null, "商品编号不能为空", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			gb.setGoods_id(id);
			//获得商品名称
			String name = this.ud.getTextName().getText();
			if(name.length() == 0){
				JOptionPane.showMessageDialog(null, "商品名称不能为空", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(name.length()>30){
				JOptionPane.showMessageDialog(null, "商品名称长度不能大于30", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			gb.setGoods_Name(name);
			//获得商品类别
			String type = this.ud.getTextType().getText();
			gb.setGoods_type(type);
			//获得商品条码
			String codes = this.ud.getTextCodes().getText();
			gb.setGoods_codes(codes);
			//获得商品单位
			String unit = this.ud.getCbxUnit().getSelectedItem().toString();
			gb.setGoods_unit(unit);
			//获得商品规格
			String spft = this.ud.getTextSpft().getText();
			gb.setGoods_spft(spft);
			//获得批准文号
			String apvlunm = this.ud.getTextApvlunm().getText();
			gb.setGoods_Apvlnum(apvlunm);
			//获得预设进价
		
			String setting = this.ud.getTextSetting().getText();
			gb.setGoods_setting(Float.parseFloat(setting));
			//获得预设售价
			String price = this.ud.getTextPrice().getText();
			gb.setGoods_price(Float.parseFloat(price));
			//获得生产厂商
			String manufacture = this.ud.getTextManufacture().getText();
			gb.setGood_manufacture(manufacture);
			//备注
			String note = this.ud.getTextNote().getText();
			gb.setGoods_note(note);
			if(GoodsDAO.updateGoods(gb)){
				JOptionPane.showMessageDialog(null, "修改成功！");
				
				
				this.ud.dispose();
				gd=new GoodsInfoDialog(null, "系统设置",true, gb);
				this.gd.setTableData();
				
	
			}else{
				JOptionPane.showMessageDialog(null, "修改失败！");
			}
			
			
		}else if(cmd.equals("Exit")){
			GoodsBean  gb  = new GoodsBean();
			this.ud.dispose();
			gd=new GoodsInfoDialog(null, "系统设置",true, gb);
			this.gd.setTableData();
		}
	
	}

}
