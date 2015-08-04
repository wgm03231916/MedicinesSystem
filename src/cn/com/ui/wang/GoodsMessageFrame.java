package cn.com.ui.wang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.com.beans.wang.BigBeans;
import cn.com.daos.market.wang.GoodsBeansDAOImpl;

public class GoodsMessageFrame extends JFrame {
	private JPanel pnlMain;
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblType;
	private JLabel lblUnit;
	private JLabel lblInventory;
	private JLabel lblApvlnum;
	private JLabel lblManufacture;
	private JLabel lblNote;
	private JLabel lblPrice;
	private JLabel lblNum;
	private JLabel lblCodes;
	private JLabel lblValidity;
	private JLabel lblMoney;
	private JLabel lblText;
	private JTextField ttdId;
	private JTextField ttdName;
	private JTextField ttdType;
	private JTextField ttdUnit;
	private JTextField ttdInventory;
	private JTextField ttdApvlnum;
	private JTextField ttdManufacture;
	private JTextField ttdNote;
	private JTextField ttdPrice;
	private JTextField ttdNum;
	private JTextField ttdCodes;
	private JTextField ttdValidity;
	private JButton ensure;
	private JButton quit;
	private GoodsBeansDAOImpl gbdi;
	private List<BigBeans> list ;
	private AddGoodsFrame agf;
	private DefaultTableModel model = null;
	private JTable table;
	
	public GoodsMessageFrame(List<BigBeans> list, JTable table){
		this.table = table;
		pnlMain = new JPanel(null);
		lblMoney = new JLabel("元");
		lblValidity = new JLabel("有效期至：");
		lblCodes = new JLabel("商品条码：");
		lblNum = new JLabel("数        量：");
		lblPrice = new JLabel("售        价：");
		lblNote = new JLabel("备        注：");
		lblManufacture = new JLabel("生产厂商：");
		lblApvlnum = new JLabel("批准文号：");
		lblInventory = new JLabel("当前库存：");
		lblUnit = new JLabel("商品单位：");
		lblType = new JLabel("商品型号：");
		lblName = new JLabel("商品名称：");
		lblId = new JLabel("商品编号：");
		lblText = new JLabel("商品信息");
		ttdId = new JTextField(null);
		ttdName = new JTextField(null);
		ttdType = new JTextField(null);
		ttdUnit = new JTextField(null);
		ttdInventory = new JTextField(null);
		ttdApvlnum = new JTextField(null);
		ttdManufacture = new JTextField(null);
		ttdNote = new JTextField(null);
		ttdPrice = new JTextField(null);
		ttdNum = new JTextField(null);
		ttdCodes = new JTextField(null);
		ttdValidity = new JTextField(null);
		ensure = new JButton("确定");
		quit = new JButton("退出");
		gbdi = new GoodsBeansDAOImpl();
		this.list = list;
		init();
	}
	
	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(550, 350);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(getOwner());
		this.setResizable(false);
		setTextField();
		
		quit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GoodsMessageFrame.this.dispose() ;
			}
		});
		
		
		quit.setBounds(300, 240, 120, 30);
		ensure.setBounds(110, 240, 120, 30);
		ttdId.setBounds(90, 30, 120, 30);
		ttdName.setBounds(330, 30, 180, 30);
		ttdType.setBounds(90, 60, 120, 30);
		ttdUnit.setBounds(330, 60, 180, 30);
		ttdInventory.setBounds(90, 90, 120, 30);
		ttdApvlnum.setBounds(330, 90, 180, 30);
		ttdManufacture.setBounds(90, 120, 120, 30);
		ttdNote.setBounds(330, 120, 180, 30);
		ttdPrice.setBounds(90, 150, 120, 30);
		ttdNum.setBounds(330, 150, 180, 30);
		ttdCodes.setBounds(90, 180, 120, 30);
		ttdValidity.setBounds(330, 180, 180, 30);
		lblMoney.setBounds(220, 150, 50, 30);
		lblValidity.setBounds(260, 180, 120, 30);
		lblNum.setBounds(260, 150, 120, 30);
		lblNote.setBounds(260, 120, 120, 30);
		lblApvlnum.setBounds(260, 90, 120, 30);
		lblUnit.setBounds(260, 60, 120, 30);
		lblName.setBounds(260, 30, 120, 30);
		lblCodes.setBounds(20, 180, 120, 30);
		lblPrice.setBounds(20, 150, 120, 30);
		lblManufacture.setBounds(20, 120, 120, 30);
		lblInventory.setBounds(20, 90, 120, 30);
		lblType.setBounds(20, 60, 120, 30);
		lblId.setBounds(20, 30, 120, 30);
		lblText.setBounds(10, 0, 120, 30);
		
		if(list.size() > 0){
			
		
		ttdId.setText(list.get(0).getGb().getGoods_id());
		ttdName.setText(list.get(0).getGb().getGoods_Name());
		ttdType.setText(list.get(0).getGb().getGoods_type());
		ttdUnit.setText(list.get(0).getGb().getGoods_unit());
		ttdInventory.setText(list.get(0).getHcb().getGoods_num()+"");
		ttdApvlnum.setText(list.get(0).getGb().getGoods_Apvlnum());
		ttdManufacture.setText(list.get(0).getGb().getGood_manufacture());
		ttdNote.setText(list.get(0).getGb().getGoods_note());
		ttdPrice.setText(list.get(0).getGb().getGoods_price()+"");
		ttdCodes.setText(list.get(0).getGb().getGoods_codes());
		ttdValidity.setText(list.get(0).getOrb().getGoods_validity());
		
		}else{
			new JOptionPane().showMessageDialog(null, "请输入所以药品的商品编号", "操作有误", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		
		
		ensure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vector<String> title=new Vector<String>();
				title.add("商品名称");
				title.add("单位");
				title.add("预售价");
				title.add("数量");
				title.add("总价");
				title.add("产品批号");
				title.add("有效期至");
				
				Vector data = new Vector();
				Vector row = null;
				 String name = ttdName.getText();
				 String unit = ttdUnit.getText();
				 String price = ttdPrice.getText();
				 String num = ttdNum.getText();
				 float snum = Integer.parseInt(num) * Float.parseFloat(price);
				 String codes = ttdCodes.getText();
				 String validity = ttdValidity.getText();
				
					row = new Vector();
					
					row.add(name);
					row.add(unit);
					row.add(price);
					row.add(num);
					row.add(snum);
					row.add(codes);
					row.add(validity);
					
					data.add(row);
					model = new DefaultTableModel(data,title);
					table.setModel(model);
					
					GoodsMessageFrame.this.dispose();
				}
		});
		
		pnlMain.add(ensure);
		pnlMain.add(quit);
		pnlMain.add(ttdValidity);
		pnlMain.add(ttdCodes);
		pnlMain.add(ttdNum);
		pnlMain.add(ttdPrice);
		pnlMain.add(ttdNote);
		pnlMain.add(ttdManufacture);
		pnlMain.add(ttdApvlnum);
		pnlMain.add(ttdInventory);
		pnlMain.add(ttdUnit);
		pnlMain.add(ttdType);
		pnlMain.add(ttdName);
		pnlMain.add(ttdId);
		pnlMain.add(lblMoney);
		pnlMain.add(lblValidity);
		pnlMain.add(lblNum);
		pnlMain.add(lblNote);
		pnlMain.add(lblApvlnum);
		pnlMain.add(lblUnit);
		pnlMain.add(lblName);
		pnlMain.add(lblCodes);
		pnlMain.add(lblPrice);
		pnlMain.add(lblManufacture);
		pnlMain.add(lblInventory);
		pnlMain.add(lblType);
		pnlMain.add(lblId);
		pnlMain.add(lblText);
		this.add(pnlMain);
		this.setVisible(true);
	}

	public void setTextField() {
		// TODO Auto-generated method stub
		
	}
	
}
