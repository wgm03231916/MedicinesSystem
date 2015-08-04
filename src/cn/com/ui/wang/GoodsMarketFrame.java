package cn.com.ui.wang;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
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

import cn.com.beans.CustomerBean;
import cn.com.beans.GoodsBean;
import cn.com.beans.GoodsSaleBean;
import cn.com.beans.HouseCapacityBean;
import cn.com.beans.OrderRelationBean;
import cn.com.beans.wang.BigBeans;
import cn.com.daos.market.wang.GoodsBeansDAOImpl;
import cn.com.ui.mouselistener.wang.GoodsMarketFrame_addgoods_MouseListener;
import cn.com.util.DateChooser;
import cn.com.util.DateFormatUtil;

/**
 * 商品销售
 * @author Administrator
 *
 */
public class GoodsMarketFrame extends JFrame {
	private JPanel pnlMain;
	private JScrollPane scrollPane;
	private JPanel pnlN;
	private DefaultTableModel dtmView;
	private JLabel lblGoods;
	private JLabel lblName;
	private JLabel lblBox;
	private JLabel lblDate;
	private JLabel lblPay;
	private JLabel lblAgent;
	private JLabel lblOddNunmber;
	private JLabel lblStart;
	private JLabel lblNote;
	private JTextField ttdName;
	private JTextField ttdBox;
	private JButton addGoods;
	private JButton ent;
	private JButton off;
	private JTable tbeGoods;
	private JTextField ttdPay;
	private JTextField ttdAgent;
	private JTextField ttdOddNunmber;
	private JTextField ttdStart;
	private JTextField ttdNote;
	private JTextField ttdDate;
	private GoodsBeansDAOImpl gbdi;

	
	public JTable getTbeGoods() {
		return tbeGoods;
	}

	public void setTbeGoods(JTable tbeGoods) {
		this.tbeGoods = tbeGoods;
	}

	public GoodsMarketFrame(){
		pnlMain = new JPanel();
		getContentPane().add(pnlMain, BorderLayout.CENTER);
		pnlN = new JPanel(null);
		scrollPane = new JScrollPane();
		gbdi = new GoodsBeansDAOImpl();
		
		lblGoods = new JLabel("商品销售");
		Font font = new  Font("楷书",Font.BOLD, 22);
		lblGoods.setFont(font);
		lblName = new JLabel("客户名称：");
		lblBox = new JLabel("主仓库：");
		lblDate = new JLabel("销售日期：");
		ttdName = new JTextField(null);
		ttdBox = new JTextField(null);
		addGoods = new JButton("添加商品");
		tbeGoods = new JTable(){
			//使table不可被编辑
		public boolean isCellEditable(int row, int column)
            {
                return false;
            }
		};
		tbeGoods.setFillsViewportHeight(true);
		
		lblPay = new JLabel("应收金额：");
		lblAgent = new JLabel("经办人：");
		lblNote = new JLabel("备注：");
		ttdPay = new JTextField(null);
		ttdAgent = new JTextField(null);
		ttdNote = new JTextField(null);
		ent = new JButton("确定");
		off = new JButton("退出");
		ttdDate = new JTextField();
		ttdDate.setText(DateFormatUtil.getTime(new Date()));
		DateChooser dateChooser1 = DateChooser.getInstance("yyyy-MM-dd");
		dateChooser1.register(ttdDate);
	
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(getOwner());
		this.setResizable(false);
		
		setTableMessage();
		
		lblGoods.setBounds(420, 10,120, 30);
		lblName.setBounds(50, 40, 120, 30);
		lblBox.setBounds(350, 40, 120, 30);
		lblDate.setBounds(650, 40, 120, 30);
		ttdDate.setBounds(730, 40, 120, 30);
		ttdName.setBounds(120, 40, 200, 30);
		ttdBox.setBounds(420, 40, 200, 30);
		addGoods.setBounds(50, 80, 120, 30);
		scrollPane.setBounds(30, 120, 900, 300);
		lblPay.setBounds(30, 430, 120, 30);
		lblAgent.setBounds(240, 430, 120, 30);
		lblNote.setBounds(30, 480, 120, 30);
		ttdPay.setBounds(100, 430, 120, 30);
		ttdAgent.setBounds(300, 430, 120, 30);
		ttdNote.setBounds(80, 480, 500, 30);
		ent.setBounds(600, 480, 120, 30);
		off.setBounds(750, 480, 120, 30);
	
		
		addGoods.addMouseListener(new GoodsMarketFrame_addgoods_MouseListener(this));
		off.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GoodsMarketFrame.this.dispose() ;
			}
		});
		ent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String note = ttdNote.getText();
				String name = ttdName.getText();
				String date = ttdDate.getText();
				String box = ttdBox.getText();
				String agent = ttdAgent.getText();
				
				int ro = tbeGoods.getSelectedRow();
				if(ro >= 0){
				String gname = (String)tbeGoods.getValueAt(ro, 0);
				String unit = (String)tbeGoods.getValueAt(ro, 1);
				String price = (String)tbeGoods.getValueAt(ro, 2);
				String num = (String)tbeGoods.getValueAt(ro, 3);
				float snum = Integer.parseInt(num) * Float.parseFloat(price);
				String codes = (String)tbeGoods.getValueAt(ro, 5);
				String validity = (String)tbeGoods.getValueAt(ro, 6);
			
				
				BigBeans b =new BigBeans();
				GoodsBean gb = new GoodsBean();
				OrderRelationBean orb = new OrderRelationBean();
				CustomerBean cb = new CustomerBean();
				HouseCapacityBean hcb = new HouseCapacityBean();
				GoodsSaleBean gsb = new GoodsSaleBean();
				b.setGb(gb);
				b.setOrb(orb);
				b.setCb(cb);
				b.setHcb(hcb);
				b.setGsb(gsb);
				b.getGb().setGoods_Name(gname);
				b.getGb().setGoods_unit(unit);
				b.getGb().setGoods_price(Float.parseFloat(price));
				b.getOrb().setGoods_num(Integer.parseInt(num));
				b.getOrb().setOrder_price(snum);
				b.getGb().setGoods_codes(codes);
				b.getOrb().setGoods_validity(validity);
				b.getCb().setCustomer_name(name);
				b.getCb().setCustomer_note(note);
				b.getGsb().setSale_people(agent);
				b.getGsb().setSale_date(date);
				b.getHcb().setWarehouse_id(box);
				
				GoodsMarketFrame.this.dispose() ;
				}else{
					new JOptionPane().showMessageDialog(null, "请选择一条数据", "操作有误", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		scrollPane.getViewport().add(tbeGoods);
		pnlMain.add(pnlN);
		pnlN.add(ent);
		pnlN.add(off);
		pnlN.add(ttdNote);
		pnlN.add(ttdAgent);
		pnlN.add(ttdPay);
		pnlN.add(lblPay);
		pnlN.add(lblAgent);
		pnlN.add(lblNote);
		pnlN.add(scrollPane);
		pnlN.add(addGoods);
		pnlN.add(ttdBox);
		pnlN.add(ttdName);
		pnlN.add(lblGoods);
		pnlN.add(lblName);
		pnlN.add(lblBox);
		pnlN.add(lblDate);
		pnlN.add(ttdDate);
		
		this.add(pnlN);
		this.setVisible(true);
		
	}

	public void setTableMessage() {
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
		dtmView = new DefaultTableModel(data,title);
		
		tbeGoods.setModel(dtmView);
	}
	
	
}
