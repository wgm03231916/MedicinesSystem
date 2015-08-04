package cn.com.view.zhang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.com.beans.GoodsBean;
import cn.com.beans.zhang.BigAllBean;
import cn.com.daos.zhang.MedicineDAOImpl;
import cn.com.daos.zhang.MedicineDAoInf;

public class ChangeProductPrice extends JFrame{
	 private JPanel panel;
	 private JLabel labProduct;
	 private JLabel labProdId;
	 private JLabel labProdId1;
	 private JLabel labProdName;
	 private JLabel labProdName1;
	 private JLabel labProdCode;
	 private JLabel labProdCode1;
	 private JLabel labProdPrice;
	 private JLabel labProdPrice1;
	 private JLabel labNewPrice;
	 private JTextField text;
	 private JLabel unit;
	 private JLabel unit1;
	 
	 private JButton btnSure;
	 private JButton btnExit;
	ChangePriceView cpv;
	BigAllBean bean;
	GoodsBean gb;
	public ChangeProductPrice(ChangePriceView cpv, GoodsBean gb) {
		// TODO Auto-generated constructor stub
		this.cpv = cpv;
		this.gb = gb;
		panel = new JPanel(null);
		labProduct = new JLabel("库存商品信息");
		labProdId = new JLabel("商品编号:");
		labProdId1 = new JLabel();
		labProdName = new JLabel("商品名称:");
		labProdName1 = new JLabel();
		labProdCode = new JLabel("商品条码:");
		labProdCode1 = new JLabel();
		labProdPrice = new JLabel("当前价格:");
		labProdPrice1 = new JLabel();
		
		labNewPrice = new JLabel("新价格:");
		text = new JTextField();
		unit = new JLabel("元");
		unit1 = new JLabel("元");
		btnSure = new JButton("确定");
		btnExit = new JButton("取消");
		setData();
		init();
		this.labProdId1.setText(gb.getGoods_id());
		this.labProdName1.setText(gb.getGoods_Name());
		this.labProdCode1.setText(gb.getGoods_codes());
		this.labProdPrice1.setText(gb.getGoods_price()+"");
	}
	private void setData() {
		// TODO Auto-generated method stub
		String price = text.getText();
		String id = labProdId1.getText();
		String name= labProdName1.getText();
		String cods = labProdCode1.getText();
		String oldPrice = labProdPrice1.getText();
		bean = new BigAllBean();
		gb = new GoodsBean();
		bean.setGb(gb);
		gb.setGoods_price(Float.parseFloat(price));
		gb.setGoods_id(id);
		gb.setGoods_Name(name);
		gb.setGoods_codes(cods);
		gb.setGoods_price(Float.parseFloat(price));
		MedicineDAoInf dao=new MedicineDAOImpl();
		if(dao.updateGoodsInfo(bean)){
			cpv.setTableData();
		}
		
	}
	private void init() {
		// TODO Auto-generated method stub
		this.setTitle("修改当前库存均价");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 300);
		
		labProduct.setBounds(10, 10, 100, 30);
		labProdId.setBounds(30, 60, 80, 30);
		labProdId1.setBounds(100, 60, 80, 30);
		labProdName.setBounds(230, 60, 80, 30);
		labProdName1.setBounds(300, 60, 200, 30);
		labProdCode.setBounds(30, 100, 80, 30);
		labProdCode1.setBounds(100, 100, 120, 30);
		labProdPrice.setBounds(230, 100, 80, 30);
		labProdPrice1.setBounds(300, 100,40, 30);
		unit1.setBounds(340, 100, 50, 30);
		
		labNewPrice.setBounds(50, 150, 60, 30);
		text.setBounds(100, 155, 140,20);
		unit.setBounds(240, 150, 50, 30);
		
		btnSure.setBounds(100, 200, 60, 30);
		btnExit.setBounds(250, 200, 60, 30);
		
		
		panel.add(labProduct);
		panel.add(labProdId);
		panel.add(labProdId1);
		panel.add(labProdName);
		panel.add(labProdName1);
		panel.add(labProdCode);
		panel.add(labProdCode1);
		panel.add(labProdPrice);
		panel.add(labProdPrice1);
		panel.add(labNewPrice);
		panel.add(text);
		panel.add(unit);
		panel.add(unit1);
		panel.add(btnSure);
		panel.add(btnExit);
		btnSure.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setData();
				dispose();
			}
		
		});
		btnExit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
			
		});
		this.add(panel);
		this.setVisible(true);
	}
	
}

