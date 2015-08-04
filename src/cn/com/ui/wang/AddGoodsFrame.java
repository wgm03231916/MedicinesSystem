package cn.com.ui.wang;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.com.beans.wang.BigBeans;
import cn.com.daos.market.wang.GoodsBeansDAOImpl;
import cn.com.ui.mouselistener.wang.AddGoodsFrame_joinGoods_MouseListener;
/**
 * 商品销售中的添加商品
 * @author Administrator
 *
 */
public class AddGoodsFrame extends JFrame {
	private JPanel pnlMain;
	
	private JScrollPane scrollPane;
	private JScrollPane scrollP;
	private JPanel pnlN;
	private DefaultTableModel dtmView;
	private DefaultTableModel dtmView2;
	private DefaultTableModel model;
	private JLabel lblTextOne;
	private JLabel lblTextTwo;
	private JLabel lblTextThree;
	private JLabel lblTextFore;
	private JTextField ttdJoinGoods;
	private JButton joinGoods;
	private JTable tbeInventory;
	private JTable tbeJoinGoods;
	private JButton ensure;
	private JButton cancel;
	private JButton altGoods;
	private JButton delGoods;
	private GoodsBeansDAOImpl gbdi;
	private JTable table;

	
	public JTable getTbeJoinGoods() {
		return tbeJoinGoods;
	}

	public void setTbeJoinGoods(JTable tbeJoinGoods) {
		this.tbeJoinGoods = tbeJoinGoods;
	}

	public AddGoodsFrame(JTable table){
		this.table = table;
		pnlMain = new JPanel(null);
		getContentPane().add(pnlMain, BorderLayout.CENTER);
		pnlN = new JPanel(null);
		scrollPane = new JScrollPane();	
		scrollP = new JScrollPane();
		model = new DefaultTableModel();
		
		lblTextOne = new JLabel("查询商品列表");
		lblTextTwo = new JLabel("请输入商品编号,查询到商品后添加到右边所选商品");
		lblTextThree = new JLabel("输入商品编号：");
		lblTextFore = new JLabel("所选商品");
		ttdJoinGoods = new JTextField(null);
		joinGoods = new JButton("加入所选商品");
		tbeInventory = new JTable(){
			//使table不可被编辑
		public boolean isCellEditable(int row, int column)
            {
                return false;
            }
		};
		tbeInventory.setFillsViewportHeight(true);
		tbeJoinGoods = new JTable(){
			//使table不可被编辑
		public boolean isCellEditable(int row, int column)
            {
                return false;
            }
		};
		tbeJoinGoods.setFillsViewportHeight(true);
		ensure = new JButton("确定");
		cancel = new JButton("取消");
		altGoods = new JButton("修改");
		delGoods = new JButton("删除");
		gbdi = new GoodsBeansDAOImpl();
		

		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(950, 580);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(getOwner());
		this.setResizable(false);
		setTableData();
		setTable();
		lblTextOne.setBounds(10, 0, 120, 30);
		lblTextTwo.setBounds(30, 30, 300, 30);
		lblTextThree.setBounds(10, 60, 100, 30);
		lblTextFore.setBounds(490, 0, 120, 30);
		ttdJoinGoods.setBounds(110, 60, 180, 30);
		joinGoods.setBounds(300, 60, 120, 30);
		scrollPane.setBounds(10, 110, 450, 400);
		
		scrollP.setBounds(490, 40, 430, 400);
		ensure.setBounds(480, 460, 100, 30);
		cancel.setBounds(595, 460, 100, 30);
		altGoods.setBounds(710, 460, 100, 30);
		delGoods.setBounds(825, 460, 100, 30);

		joinGoods.addMouseListener(new AddGoodsFrame_joinGoods_MouseListener(this));
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddGoodsFrame.this.dispose() ;
			}
		});
		ensure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vector<String> title = new Vector<String>();
				title.add("商品名称");
				title.add("单位");
				title.add("预售价");
				title.add("数量");
				title.add("总价");
				title.add("产品批号");
				title.add("有效期至");
				
				Vector data = new Vector();
				Vector row = null;
				int ro = tbeJoinGoods.getSelectedRow();
				if(ro >= 0){
				String name = (String)tbeJoinGoods.getValueAt(ro, 0);
				String unit = (String)tbeJoinGoods.getValueAt(ro, 1);
				String price = (String)tbeJoinGoods.getValueAt(ro, 2);
				String num = (String)tbeJoinGoods.getValueAt(ro, 3);
				float snum = Integer.parseInt(num) * Float.parseFloat(price);
				String codes = (String)tbeJoinGoods.getValueAt(ro, 5);
				String validity = (String)tbeJoinGoods.getValueAt(ro, 6);

				
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
				
				
				AddGoodsFrame.this.dispose();
				}else{
					new JOptionPane().showMessageDialog(null, "请选择一条数据", "操作有误", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		scrollPane.getViewport().add(tbeInventory);
		scrollP.getViewport().add(tbeJoinGoods);
		//pnlMain.add(scrollPane);
		pnlMain.add(pnlN);
		pnlN.add(delGoods);
		pnlN.add(altGoods);
		pnlN.add(cancel);
		pnlN.add(ensure);
		pnlN.add(scrollP);
		pnlN.add(scrollPane);
		pnlN.add(ttdJoinGoods);
		pnlN.add(joinGoods);
		pnlN.add(lblTextFore);
		pnlN.add(lblTextThree);
		pnlN.add(lblTextTwo);
		pnlN.add(lblTextOne);
		this.add(pnlN);
		this.setVisible(true);
	}
	
	
	//压数据
	public void setTable(){
		Vector<String> title = new Vector<String>();
		title.add("商品名称");
		title.add("单位");
		title.add("预售价");
		title.add("数量");
		title.add("总价");
		title.add("产品批号");
		title.add("有效期至");
		
		Vector data = new Vector();
		dtmView2 = new DefaultTableModel(data,title);
		
		tbeJoinGoods.setModel(dtmView2);
	}

	public void setTableData(){
		Vector<String> title = new Vector<String>();
		title.add("商品编号");
		title.add("商品名称");
		title.add("单位");
		title.add("规格");
		title.add("预售价");
		title.add("库存量");
		title.add("生产厂商");
		
		Vector data = new Vector();
		Vector row = null;
		
		List<BigBeans> list = gbdi.getAllGoodsinfo();
		
		for(BigBeans bb : list){
			row = new Vector();
			
			row.add(bb.getGb().getGoods_id());
			row.add(bb.getGb().getGoods_Name());
			row.add(bb.getGb().getGoods_unit());
			row.add(bb.getGb().getGoods_spft());
			row.add(bb.getGb().getGoods_price());
			row.add(bb.getHcb().getGoods_num());
			row.add(bb.getGb().getGood_manufacture());
			
			data.add(row);
		}
		dtmView = new DefaultTableModel(data,title);
//		{
//			//使table不可被编辑
//			public boolean isCellEditable(int row, int column)
//            {
//                return false;
//            }
//		};
		tbeInventory.setModel(dtmView);
	}
	public JTextField getTextField() {
		return ttdJoinGoods;
	}

	public void setTextField(JTextField ttdJoinGoods) {
		this.ttdJoinGoods = ttdJoinGoods;
	}
	
}
