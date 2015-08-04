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

import cn.com.beans.EmployeeBean;
import cn.com.beans.GetGoodsSaleWarehouseCustomerViewBean;
import cn.com.beans.GoodsSaleRelationViweBean;
import cn.com.beans.GoodsSaleWarehouseCustomerView;
import cn.com.beans.Supplier_1Number;
import cn.com.beans.UsesslessBean;
import cn.com.servers.statisticalReport.StatisticalServerInfImp;
import cn.com.util.DateChooser;
import cn.com.util.DateFormatUtil;
import cn.com.util.Globel;

public class ViewOfSalesmanProcurementStatistic extends JFrame {

	private JPanel contentPane;
	private JTextField time1TextField;
	private JTextField time2TextField;
	private JTable table;
	private JPanel panel_1;
	private DefaultTableModel dftModel1 = null;
	private DefaultTableModel dftModel2 = null;
	private JTable table_1;
	private StatisticalServerInfImp statisticalServerInfImp = null;
	private List<Object> list = null;
	private JComboBox comboBox = null;

	public ViewOfSalesmanProcurementStatistic() {
		setResizable(false);
		setTitle("\u4E1A\u52A1\u5458\u91C7\u8D2D\u7EDF\u8BA1");
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
		panel.setBackground(new Color(135, 206, 235));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("\u91C7\u8D2D\u65E5\u671F\uFF1A");
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
		
		JLabel label_1 = new JLabel("\u4E1A\u52A1\u5458\u540D\u79F0\uFF1A");
		panel.add(label_1);
		
		JButton button_1 = new JButton("\u7EDF\u8BA1");
		button_1.setBackground(new Color(135, 206, 235));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date1 = time1TextField.getText();
				String date2 = time2TextField.getText();
				String employee = (String)comboBox.getSelectedItem();
				GetGoodsSaleWarehouseCustomerViewBean ggwcv = new GetGoodsSaleWarehouseCustomerViewBean();
				ggwcv.setNum(1);
				ggwcv.setDate1(date1);
				ggwcv.setDate2(date2);
				ggwcv.setEmployee(employee);
				statisticalServerInfImp = new StatisticalServerInfImp();
				list = statisticalServerInfImp.getAllOfServers(ggwcv);
				if(list.size() == 0){
					showData2(list);
				}
				showData1(list);
			}
		}); 
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(135, 206, 235));
		panel.add(comboBox);
		statisticalServerInfImp = new StatisticalServerInfImp();
		UsesslessBean u = new UsesslessBean();
		u.setI(1);
		list = statisticalServerInfImp.getAllOfServers(u);
		comboBox.addItem("所有业务员");
		for(Object o:list){
			if(o instanceof EmployeeBean){
				EmployeeBean employeeBean = (EmployeeBean)o;
				comboBox.addItem(employeeBean.getEmployee_name().toString());
			}
		}
		panel.add(button_1);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.setBackground(new Color(135, 206, 235));
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewOfSalesmanProcurementStatistic.this.dispose();
			}
		});
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createTitledBorder("业务员业务信息列表"));
		table = new JTable();
		table.setBackground(new Color(135, 206, 235));
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(java.awt.event.MouseEvent e) {      
				  int row = table.getSelectedRow();
				  String id = (String)table.getValueAt(row, 3 );
				  Supplier_1Number supplier_1Number = new Supplier_1Number();
				  supplier_1Number.setNum(2);
				  supplier_1Number.setOrder_id(id);
				  statisticalServerInfImp = new StatisticalServerInfImp();
				  list = statisticalServerInfImp.getAllOfServers(supplier_1Number);
				  showData2(list);
			  }
		});
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(BorderFactory.createTitledBorder("业务员业务与商品关系列表"));
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));
		panel_2.add(scrollPane);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(135, 206, 235));
		scrollPane_1.setViewportView(table_1);
		setTitle1();
		setTitle2();
		Globel.setCenterByWindow(this);
		this.setVisible(true);
	}
	private void setTitle1() {
		Vector<String> title = new Vector<String>();
		title.add("开单日期");
		title.add("业务员");
		title.add("业务类型");
		title.add("单号");
		title.add("应付金额");
		title.add("仓库");
		title.add("客户名称");
		title.add("客户电话");
		title.add("备注");
		Vector date =new Vector();
		dftModel2 = new DefaultTableModel(date,title);
		table.setModel(dftModel2);
		
	}

	private void setTitle2() {
		
		Vector<String> title = new Vector<String>();
		title.add("商品编号");
		title.add("商品名称");
		title.add("单位");
		title.add("单价");
		title.add("数量");
		title.add("总金额");
		title.add("规格");
		title.add("批号");
		title.add("生产商");
		Vector date =new Vector();
		dftModel2 = new DefaultTableModel(date,title);
		table_1.setModel(dftModel2);
	}

	public void showData1(List<Object> list){
		
		Vector<String> title = new Vector<String>();
		title.add("开单日期");
		title.add("业务员");
		title.add("业务类型");
		title.add("单号");
		title.add("应付金额");
		title.add("仓库");
		title.add("客户名称");
		title.add("客户电话");
		title.add("备注");
		Vector date =new Vector();
		Vector row = null;
		for(Object o:list){
			if(o instanceof GoodsSaleWarehouseCustomerView){
				GoodsSaleWarehouseCustomerView g = (GoodsSaleWarehouseCustomerView)o;
				row = new Vector();
				row.add(g.getSale_date());
				row.add(g.getSale_People());
				row.add(g.getSale_Type());
				row.add(g.getSale_Id());
				row.add(g.getSale_Price());
				row.add(g.getWarehouse_Name());
				row.add(g.getCustomer_Name());
				row.add(g.getCustomer_Tel());
				row.add(g.getSale_Note());
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
		title.add("规格");
		title.add("批号");
		title.add("生产商");
		Vector date =new Vector();
		Vector row = null;
		for(Object o:list){
			if(o instanceof GoodsSaleRelationViweBean){
				row = new Vector();
				GoodsSaleRelationViweBean g = (GoodsSaleRelationViweBean)o;
				row.add(g.getGg_id());
				row.add(g.getGoods_Name());
				row.add(g.getGoods_Unit());
				row.add(g.getGoods_Setting());
				row.add(g.getSale_num());
				row.add(g.getSale_Price());
				row.add(g.getGoods_Spft());
				row.add(g.getGoods_Apvlunm());
				row.add(g.getGoods_Manufacture());
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