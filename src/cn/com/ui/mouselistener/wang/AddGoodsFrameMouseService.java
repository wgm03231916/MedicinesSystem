package cn.com.ui.mouselistener.wang;

import java.util.List;

import javax.swing.JTable;

import cn.com.beans.GoodsBean;
import cn.com.beans.wang.BigBeans;
import cn.com.daos.market.wang.GoodsBeansDAOImpl;
import cn.com.ui.wang.AddGoodsFrame;
import cn.com.ui.wang.GoodsMessageFrame;

public class AddGoodsFrameMouseService {
	private AddGoodsFrame af;
	private GoodsBeansDAOImpl dao;
	private GoodsBean gsb;

	
	public AddGoodsFrameMouseService(AddGoodsFrame af){
		this.af = af;
		dataReset();
	}
	
	public void dataReset(){
		
		dao = new GoodsBeansDAOImpl();
		gsb = new GoodsBean();

		gsb.setGoods_id(af.getTextField().getText());
		JTable table = af.getTbeJoinGoods();
		List<BigBeans> list = dao.getMessageById(gsb);
		new GoodsMessageFrame(list,table);
	}
}
