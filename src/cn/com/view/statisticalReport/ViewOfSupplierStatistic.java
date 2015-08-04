package cn.com.view.statisticalReport;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.com.beans.GetGoodsSaleWarehouseCustomerViewBean;
import cn.com.beans.GoodsJTGoodsOrderRelationView;
import cn.com.beans.JTGoodsSupplierView;
import cn.com.beans.SupplierBean;
import cn.com.beans.Supplier_1Number;
import cn.com.beans.Supplier_2Date;
import cn.com.beans.UsesslessBean;
import cn.com.daos.statisticalReport.StatisticalDaoInf;
import cn.com.daos.statisticalReport.StatisticalDaoInfImp;
import cn.com.servers.statisticalReport.StatisticalServerInfImp;
import cn.com.util.DateChooser;
import cn.com.util.DateFormatUtil;
import cn.com.util.Globel;

public class ViewOfSupplierStatistic extends JFrame {

	private JPanel contentPane;
	private JTextField time1TextField;
	private JTextField time2TextField;
	private JTable table;
	private JPanel panel_1;
	private DefaultTableModel dftModel1 = null;
	private DefaultTableModel dftModel2 = null;
	private JTable table_1;
	private String date1 = null;
	private String date2 = null;
	private Supplier_2Date supplier_2Date = null;
	private Supplier_1Number supplier_1Number = null;
	private StatisticalServerInfImp statisticalServerInfImp = null;
	private List<Object> list = null;
	private JComboBox comboBox = null;
	
	public ViewOfSupplierStatistic() {
		setResizable(false);
		setTitle("\u4F9B\u8D27\u5546\u4F9B\u8D27\u7EDF\u8BA1");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		com.sun.xml.internal.ws.util.pipe
//		com.jtattoo
//		com.jtattoo.plaf
//		com.jtattoo.plaf.acryl
//		com.jtattoo.plaf.acryl.icons
//		com.jtattoo.plaf.smart.SmartLookAndFeel
		try {  
			  UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");  
			 }catch (Exception ex) {  
			      ex.printStackTrace();  
			 }  

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(850, 550));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("\u67E5\u8BE2\u65F6\u95F4\uFF1A");
		panel.add(lblNewLabel);
		
		time1TextField = new JTextField();
		time1TextField.setEditable(false);
		time1TextField.setText("2000-01-01");
		
		DateChooser dateChooser1 = DateChooser.getInstance("yyyy-MM-dd");
		dateChooser1.register(time1TextField);
		
		panel.add(time1TextField);
		time1TextField.setColumns(16);
		
		JLabel label = new JLabel("\u81F3");
		panel.add(label);
		
		time2TextField = new JTextField();
		time2TextField.setEditable(false);
		time2TextField.setText(DateFormatUtil.getTime(new Date()));
		
		DateChooser dateChooser2 = DateChooser.getInstance("yyyy-MM-dd");
		dateChooser2.register(time2TextField);
		
		panel.add(time2TextField);
		time2TextField.setColumns(16);
		
		JLabel label_1 = new JLabel("\u4F9B\u8D27\u5546\u540D\u79F0\uFF1A");
		panel.add(label_1);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 239, 213));
		panel.add(comboBox);
		statisticalServerInfImp = new StatisticalServerInfImp();
		UsesslessBean u = new UsesslessBean();
		u.setI(3);
		list = statisticalServerInfImp.getAllOfServers(u);
		comboBox.addItem("所有供货商");
		for(Object o:list){
			if(o instanceof SupplierBean){
				SupplierBean s = (SupplierBean)o;
				comboBox.addItem(s.getSupplier_name());
			}
		}
		JButton button = new JButton("\u67E5\u627E");
		button.setBackground(new Color(255, 239, 213));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date1 = time1TextField.getText();
				String date2 = time2TextField.getText();
				String supplier = (String)comboBox.getSelectedItem();
				GetGoodsSaleWarehouseCustomerViewBean ggwcv = new GetGoodsSaleWarehouseCustomerViewBean();
				ggwcv.setNum(3);
				ggwcv.setDate1(date1);
				ggwcv.setDate2(date2);
				ggwcv.setEmployee(supplier);
				statisticalServerInfImp = new StatisticalServerInfImp();
				list = statisticalServerInfImp.getAllOfServers(ggwcv);
				if(list.size() == 0){
					showData2(list);
				}
				showData1(list);
			}
		});
		panel.add(button);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.setBackground(new Color(255, 239, 213));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewOfSupplierStatistic.this.dispose();
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createTitledBorder("往来账务列表"));
		table = new JTable();
		table.setBackground(new Color(255, 239, 213));
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(java.awt.event.MouseEvent e) {      
				  int row = table.getSelectedRow();
				  String id = (String)table.getValueAt(row, 2);
				  supplier_1Number = new Supplier_1Number();
				  supplier_1Number.setOrder_id(id);
				  statisticalServerInfImp = new StatisticalServerInfImp();
				  list = statisticalServerInfImp.getAllOfServers(supplier_1Number);
				  
				  showData2(list);
			  }
		});
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(BorderFactory.createTitledBorder("单据的详细信息"));
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));
		panel_2.add(scrollPane);
		panel_2.add(scrollPane_1) ;
		
		table_1 = new JTable();
		table_1.setBackground(new Color(255, 239, 213));
		scrollPane_1.setViewportView(table_1);
		setTitle1();
		setTitle2();
//		showData2();
		Globel.setCenterByWindow(this);
		this.setVisible(true);
	}
	private void setTitle2() {
		Vector<String> title = new Vector<String>();
		title.add("商品编号");
		title.add("商品名称");
		title.add("单位");
		title.add("单价");
		title.add("数量");
		title.add("总金额");
		title.add("产品规格");
		title.add("生产商");
		title.add("有效期至");
		Vector date =new Vector();
		dftModel2 = new DefaultTableModel(date,title);
		table_1.setModel(dftModel2);
	}

	private void setTitle1() {
		Vector<String> title = new Vector<String>();
		title.add("供货商品名称");
		title.add("日期");
		title.add("单号");
		title.add("内容摘要");
		title.add("应付金额");
		title.add("经办人");
		title.add("备注");
		Vector date =new Vector();
		dftModel1 = new DefaultTableModel(date,title);
		table.setModel(dftModel1);
	}

	public void showData1(List<Object> list){
		
		Vector<String> title = new Vector<String>();
		title.add("供货商品名称");
		title.add("日期");
		title.add("单号");
		title.add("内容摘要");
		title.add("应付金额");
		title.add("经办人");
		title.add("备注");
		Vector date =new Vector();
		Vector row = null;
		StatisticalDaoInf dao = new StatisticalDaoInfImp();
		for(Object o:list){//list = null;
			row = new Vector();
			if(o instanceof JTGoodsSupplierView){
				JTGoodsSupplierView jTGoodsSupplierView = (JTGoodsSupplierView)o;
				row.add(jTGoodsSupplierView.getSupplier_Name());
				row.add(jTGoodsSupplierView.getOrder_date());
				row.add(jTGoodsSupplierView.getOrder_Id());
				row.add(jTGoodsSupplierView.getOrder_Type());
				row.add(jTGoodsSupplierView.getOrder_price());
				row.add(jTGoodsSupplierView.getOrder_head());
				row.add(jTGoodsSupplierView.getOrder_Note());
				date.add(row);
			}
			
		}
		dftModel1 = new DefaultTableModel(date,title){
			public boolean isCellEditable(int row, int column) {
			    // TODO Auto-generated method stub
			    return false;//返回true表示能编辑，false表示不能编辑
			   } 
		};
		
		table.setModel(dftModel1);
	}
	public void showData2(List<Object> list){
		
		Vector<String> title = new Vector<String>();
		title.add("商品编号");
		title.add("商品名称");
		title.add("单位");
		title.add("单价");
		title.add("数量");
		title.add("总金额");
		title.add("产品规格");
		title.add("产品批号");
		title.add("有效期至");
		Vector date =new Vector();
		Vector row = null;
		for(Object o:list){
			row = new Vector();
			if(o instanceof GoodsJTGoodsOrderRelationView){
				GoodsJTGoodsOrderRelationView gJTOView = (GoodsJTGoodsOrderRelationView)o;
				row.add(gJTOView.getGoods_Id());
				row.add(gJTOView.getGoods_Name());
				row.add(gJTOView.getGoods_Unit());
				row.add(gJTOView.getGoods_Setting());
				row.add(gJTOView.getGoods_Num());
				row.add(gJTOView.getOrder_price());
				row.add(gJTOView.getGoods_Spft());
				row.add(gJTOView.getGoods_Manufacture());
				row.add(gJTOView.getGoods_Validity());
				date.add(row);
			}
		}
		dftModel2 = new DefaultTableModel(date,title){
			public boolean isCellEditable(int row, int column) {
			    // TODO Auto-generated method stub
			    return false;//返回true表示能编辑，false表示不能编辑
			   } 
		};
		
		table_1.setModel(dftModel2);
	}

}
