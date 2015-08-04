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
			//�����Ʒ���
			String id = this.ud.getTextNO().getText();
//			String id = this.ad.getTextName().getText();
			if(id.length() == 0){
				JOptionPane.showMessageDialog(null, "��Ʒ��Ų���Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			gb.setGoods_id(id);
			//�����Ʒ����
			String name = this.ud.getTextName().getText();
			if(name.length() == 0){
				JOptionPane.showMessageDialog(null, "��Ʒ���Ʋ���Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(name.length()>30){
				JOptionPane.showMessageDialog(null, "��Ʒ���Ƴ��Ȳ��ܴ���30", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			gb.setGoods_Name(name);
			//�����Ʒ���
			String type = this.ud.getTextType().getText();
			gb.setGoods_type(type);
			//�����Ʒ����
			String codes = this.ud.getTextCodes().getText();
			gb.setGoods_codes(codes);
			//�����Ʒ��λ
			String unit = this.ud.getCbxUnit().getSelectedItem().toString();
			gb.setGoods_unit(unit);
			//�����Ʒ���
			String spft = this.ud.getTextSpft().getText();
			gb.setGoods_spft(spft);
			//�����׼�ĺ�
			String apvlunm = this.ud.getTextApvlunm().getText();
			gb.setGoods_Apvlnum(apvlunm);
			//���Ԥ�����
		
			String setting = this.ud.getTextSetting().getText();
			gb.setGoods_setting(Float.parseFloat(setting));
			//���Ԥ���ۼ�
			String price = this.ud.getTextPrice().getText();
			gb.setGoods_price(Float.parseFloat(price));
			//�����������
			String manufacture = this.ud.getTextManufacture().getText();
			gb.setGood_manufacture(manufacture);
			//��ע
			String note = this.ud.getTextNote().getText();
			gb.setGoods_note(note);
			if(GoodsDAO.updateGoods(gb)){
				JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
				
				
				this.ud.dispose();
				gd=new GoodsInfoDialog(null, "ϵͳ����",true, gb);
				this.gd.setTableData();
				
	
			}else{
				JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�");
			}
			
			
		}else if(cmd.equals("Exit")){
			GoodsBean  gb  = new GoodsBean();
			this.ud.dispose();
			gd=new GoodsInfoDialog(null, "ϵͳ����",true, gb);
			this.gd.setTableData();
		}
	
	}

}
