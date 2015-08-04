package cn.com.view.statisticalReport;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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

import cn.com.beans.GSWJOView;
import cn.com.beans.Supplier_2Date;
import cn.com.daos.statisticalReport.StatisticalDaoInf;
import cn.com.daos.statisticalReport.StatisticalDaoInfImp;
import cn.com.servers.statisticalReport.StatisticalServerInfImp;
import cn.com.util.DateChooser;
import cn.com.util.DateFormatUtil;
import cn.com.util.Globel;

public class ViewOfGoodsProcurementStatistic extends JFrame {

	private JPanel contentPane;
	private JTextField time1TextField;
	private JTextField time2TextField;
	private JTable table;
	private JPanel panel_1;
	private DefaultTableModel dftModel1 = null;
	private StatisticalServerInfImp statisticalServerInfImp = null;
	private List<Object> list = null;
	
	public ViewOfGoodsProcurementStatistic() {
		setResizable(false);
		setTitle("\u4F9B\u8D27\u5546\u4F9B\u8D27\u7EDF\u8BA1");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		panel.setBackground(new Color(255, 250, 205));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("\u91C7\u8D2D\u65F6\u95F4\uFF1A");
		panel.add(lblNewLabel);
		
		time1TextField = new JTextField();
		time1TextField.setText("2000-01-01");
		
		DateChooser dateChooser1 = DateChooser.getInstance("yyyy-MM-dd");
		dateChooser1.register(time1TextField);
		
		panel.add(time1TextField);
		time1TextField.setColumns(16);
		
		JLabel label = new JLabel("\u81F3");
		panel.add(label);
		
		time2TextField = new JTextField();
		time2TextField.setText(DateFormatUtil.getTime(new Date()));
		
		DateChooser dateChooser2 = DateChooser.getInstance("yyyy-MM-dd");
		dateChooser2.register(time2TextField);
		
		panel.add(time2TextField);
		time2TextField.setColumns(16);
		
		JButton button_1 = new JButton("\u7EDF\u8BA1");
		button_1.setBackground(new Color(255, 250, 205));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date1 = time1TextField.getText();
				String date2 = time2TextField.getText();
				Supplier_2Date supplier_2Date = new Supplier_2Date();
				supplier_2Date.setNum(2);
				supplier_2Date.setDate1(date1);
				supplier_2Date.setDate2(date2);
				statisticalServerInfImp = new StatisticalServerInfImp();
				list = statisticalServerInfImp.getAllOfServers(supplier_2Date);
				showData1(list);
			}
		});
		panel.add(button_1);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.setBackground(new Color(255, 250, 205));
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewOfGoodsProcurementStatistic.this.dispose();
			}
		});
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));//
		table = new JTable();
		table.setBackground(new Color(255, 250, 205));
		/*
		 * 列数太多时title显示不正常时用此函数
		 * */
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createTitledBorder("商品与订单关系列表"));
		scrollPane.setViewportView(table);
		panel_2.add(scrollPane);
		
		setTitle();
		Globel.setCenterByWindow(this);
		this.setVisible(true);
	}
public void showData1(List<Object> list){
		
		Vector<String> title = new Vector<String>();
		title.add("单号");
		title.add("日期");
		title.add("供货商");
		title.add("商品编号");
		title.add("商品名称");
		title.add("商品类别");
		title.add("仓库");
		title.add("单位");
		title.add("有效期");
		title.add("单价");
		title.add("数量");
		title.add("总金额");
		title.add("规格");
		title.add("经办人");
		title.add("生产厂商");
		title.add("批准文号");
		Vector date =new Vector();
		Vector row = null;
		StatisticalDaoInf dao = new StatisticalDaoInfImp();
		for(Object o:list){
			row = new Vector();
			if(o instanceof GSWJOView){
				GSWJOView g = (GSWJOView)o;
				row.add(g.getOrder_Id());
				row.add(g.getOrder_date());
				row.add(g.getSupplier_Name());
				row.add(g.getGoods_Id());
				row.add(g.getGoods_Name());
				row.add(g.getGoods_Type());
				row.add(g.getWarehouse_Name());
				row.add(g.getGoods_Unit());
				row.add(g.getGoods_Validity());
				row.add(g.getGoods_Setting());
				row.add(g.getGoods_Num());
				row.add(g.getOrder_price());
				row.add(g.getGoods_Spft());
				row.add(g.getOrder_head());
				row.add(g.getGoods_Manufacture());
				row.add(g.getGoods_Apvlunm());
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

	private void setTitle() {
		Vector<String> title = new Vector<String>();
		title.add("单号");
		title.add("日期");
		title.add("供货商");
		title.add("商品编号");
		title.add("商品名称");
		title.add("商品类别");
		title.add("仓库");
		title.add("单位");
		title.add("有效期");
		title.add("单价");
		title.add("数量");
		title.add("总金额");
		title.add("规格");
		title.add("经办人");
		title.add("生产厂商");
		title.add("批准文号");
		Vector date =new Vector();
		dftModel1 = new DefaultTableModel(date,title){
			public boolean isCellEditable(int row, int column) {
			    // TODO Auto-generated method stub
			    return false;//返回true表示能编辑，false表示不能编辑
			   } 
		};
		table.setModel(dftModel1);
	}

}
