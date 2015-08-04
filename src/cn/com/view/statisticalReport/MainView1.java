package cn.com.view.statisticalReport;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import cn.com.beans.CustomerBean;
import cn.com.beans.EmployeeBean;
import cn.com.beans.GoodsBean;
import cn.com.beans.SupplierBean;
import cn.com.beans.WarehouseBean;
import cn.com.ui.wang.GoodsMarketFrame;
import cn.com.ui.wang.OrderInfoFrame;
import cn.com.util.Globel;
import cn.com.view.zhang.ChangePriceView;
import cn.com.view.zhang.OperatorView;
import cn.com.view.zhang.SupplierImp;
import cn.com.views.huang.BuyInView;
import cn.com.views.huang.BuyOutView;
import cn.com.views.settings.CustomerSetDialog;
import cn.com.views.settings.EmployeeSetDialog;
import cn.com.views.settings.GoodsInfoDialog;
import cn.com.views.settings.SupplierSetDialog;
import cn.com.views.settings.WarehouseSetDialog;
import cn.com.window.storagement.JFrameLoss;
import cn.com.window.storagement.JFramePasttime;
import cn.com.window.storagement.JFrameStorage;
import cn.com.window.storagement.JFrameTransfer;

public class MainView1 extends JFrame {

	private JPanel contentPane;
	private JPanel panel = null;
	private JPanel pane2 = null;
	private JPanel pane3 = null;
	private JPanel pane4 = null;
	private JPanel pane5 = null;
	private JPanel pane6 = null;
	private GoodsBean gb;
	private WarehouseBean wb;
	private CustomerBean cb;
	private SupplierBean sb;
	private EmployeeBean eb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView1 frame = new MainView1();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView1() {
		setResizable(false);
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
		setTitle("\u533B\u836F\u9500\u552E\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(1190, 700));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel navigationBarPnl = new JPanel();
		contentPane.add(navigationBarPnl, BorderLayout.NORTH);
		navigationBarPnl.setLayout(new GridLayout(1, 8, 0, 0));
		panel = getJPanel1();
		pane2 = getJPanel2();
		pane3 = getJPanel3();
		pane4 = getJPanel4();
		pane5 = getJPanel5();
		pane6 = getJPanel6();
		
		contentPane.add(panel, BorderLayout.CENTER);//
		
		JButton inGoodsBtn = new JButton("进货管理");
		inGoodsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane1();
				panel.setVisible(true);
				pane2.setVisible(false);
				pane3.setVisible(false);
				pane4.setVisible(false);
				pane5.setVisible(false);
				pane6.setVisible(false);
			}

			
		});
		inGoodsBtn.setFont(new Font("宋体", Font.PLAIN, 25));
		navigationBarPnl.add(inGoodsBtn);
		
		JButton outGoodsBtn = new JButton("\u9500\u552E\u7BA1\u7406");
		outGoodsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane2();
				pane2.setVisible(true);
				panel.setVisible(false);
				pane3.setVisible(false);
				pane4.setVisible(false);
				pane5.setVisible(false);
				pane6.setVisible(false);
			}
		});
		outGoodsBtn.setFont(new Font("宋体", Font.PLAIN, 25));
		navigationBarPnl.add(outGoodsBtn);
		
		JButton stockBtn = new JButton("\u5E93\u5B58\u7BA1\u7406");
		stockBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane3();
				pane3.setVisible(true);
				panel.setVisible(false);
				pane2.setVisible(false);
				pane4.setVisible(false);
				pane5.setVisible(false);
				pane6.setVisible(false);
			}
		});
		stockBtn.setFont(new Font("宋体", Font.PLAIN, 25));
		navigationBarPnl.add(stockBtn);
		
		JButton statisticBtn = new JButton("\u7EDF\u8BA1\u62A5\u8868");
		statisticBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane4();
				pane4.setVisible(true);
				panel.setVisible(false);
				pane2.setVisible(false);
				pane3.setVisible(false);
				pane5.setVisible(false);
				pane6.setVisible(false);
			}
		});
		statisticBtn.setFont(new Font("宋体", Font.PLAIN, 25));
		navigationBarPnl.add(statisticBtn);
		
		JButton dailyBtn = new JButton("\u65E5\u5E38\u7BA1\u7406");
		dailyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane5();
				pane5.setVisible(true);
				panel.setVisible(false);
				pane2.setVisible(false);
				pane3.setVisible(false);
				pane4.setVisible(false);
				pane6.setVisible(false);
			}
		});
		dailyBtn.setFont(new Font("宋体", Font.PLAIN, 25));
		navigationBarPnl.add(dailyBtn);
		
		JButton systemBtn = new JButton("\u7CFB\u7EDF\u8BBE\u7F6E");
		systemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane6();
				pane6.setVisible(true);
				panel.setVisible(false);
				pane2.setVisible(false);
				pane3.setVisible(false);
				pane4.setVisible(false);
				pane5.setVisible(false);
			}
		});
		systemBtn.setFont(new Font("宋体", Font.PLAIN, 25));
		navigationBarPnl.add(systemBtn);
		
		JButton exitBtn = new JButton("\u9000 \u51FA");
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitBtn.setFont(new Font("宋体", Font.PLAIN, 25));
		navigationBarPnl.add(exitBtn);
		Globel.setCenterByWindow(this);
		this.setVisible(true);
	}
	private void setContentPane1() {
		// TODO Auto-generated method stub
		contentPane.add(panel, BorderLayout.CENTER);
	}
	private void setContentPane2() {
		// TODO Auto-generated method stub
		contentPane.add(pane2, BorderLayout.CENTER);
	}
	private void setContentPane3() {
		// TODO Auto-generated method stub
		contentPane.add(pane3, BorderLayout.CENTER);
	}
	private void setContentPane4() {
		// TODO Auto-generated method stub
		contentPane.add(pane4, BorderLayout.CENTER);
	}
	private void setContentPane5() {
		// TODO Auto-generated method stub
		contentPane.add(pane5, BorderLayout.CENTER);
	}
	private void setContentPane6() {
		contentPane.add(pane6, BorderLayout.CENTER);
	}
	private JPanel getJPanel1(){
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 222, 179));
		pane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 222, 179));
		pane.add(panel_2);
		
		JLabel label = new JLabel("进   货   管   理");
		label.setFont(new Font("宋体", Font.PLAIN, 36));
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 222, 179));
		pane.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 5, 0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		panel_3.add(lblNewLabel);
		
		JButton button_1 = new JButton("\u91C7\u8D2D\u8FDB\u8D27");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BuyInView(null,0,0);
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 25));
		button_1.setBackground(new Color(218, 112, 214));
		panel_3.add(button_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("仿宋", Font.BOLD, 17));
		panel_3.add(lblNewLabel_2);
		
		JButton button = new JButton("\u5F80\u6765\u8D26\u52A1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewOfSupplierStatistic();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 25));
		button.setBackground(new Color(218, 112, 214));
		panel_3.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(245, 222, 179));
		pane.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(245, 222, 179));
		pane.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 5, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel_5.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_5.add(lblNewLabel_3);
		
		JButton button_3 = new JButton("\u91C7\u8D2D\u9000\u8D27");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BuyOutView(null,0,0);
			}
		});
		button_3.setFont(new Font("宋体", Font.PLAIN, 25));
		button_3.setBackground(new Color(218, 112, 214));
		panel_5.add(button_3);
		
		JLabel label_1 = new JLabel("");
		panel_5.add(label_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		panel_5.add(lblNewLabel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(245, 222, 179));
		pane.add(panel_6);
		return pane;
	}
	private JPanel getJPanel2(){
		JPanel pane2 = new JPanel();
		pane2.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 222, 179));
		pane2.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 222, 179));
		pane2.add(panel_2);
		
		JLabel label = new JLabel("销   售   管   理");
		label.setFont(new Font("宋体", Font.PLAIN, 36));
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 222, 179));
		pane2.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 5, 0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		panel_3.add(lblNewLabel);
		
		JButton button_1 = new JButton("\u5546\u54C1\u9500\u552E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GoodsMarketFrame();
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 25));
		button_1.setBackground(new Color(218, 112, 214));
		panel_3.add(button_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("仿宋", Font.BOLD, 17));
		panel_3.add(lblNewLabel_2);
		
		JButton button = new JButton("\u5F80\u6765\u8D26\u52A1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OrderInfoFrame();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 25));
		button.setBackground(new Color(218, 112, 214));
		panel_3.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(245, 222, 179));
		pane2.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(245, 222, 179));
		pane2.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 5, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel_5.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("");
		panel_5.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("\u5F53\u524D\u5E93\u5B58\u67E5\u8BE2");
		btnNewButton.setBackground(new Color(218, 112, 214));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 26));
		panel_5.add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("");
		panel_5.add(lblNewLabel_7);
		
		JLabel lblNewLabel_5 = new JLabel("");
		panel_5.add(lblNewLabel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(245, 222, 179));
		pane2.add(panel_6);
		return pane2;
		
	}
	private JPanel getJPanel3(){
		JPanel pane3 = new JPanel();
		pane3.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 222, 179));
		pane3.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 222, 179));
		pane3.add(panel_2);
		
		JLabel label = new JLabel("库   存   管   理");
		label.setFont(new Font("宋体", Font.PLAIN, 36));
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 222, 179));
		pane3.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 5, 0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		panel_3.add(lblNewLabel);
		
		JButton button_1 = new JButton("\u5E93\u5B58\u8C03\u62E8");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("hello");
				new JFrameTransfer();
//				new ViewOfGoodsProcurementStatistic();
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 25));
		button_1.setBackground(new Color(218, 112, 214));
		panel_3.add(button_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("仿宋", Font.BOLD, 17));
		panel_3.add(lblNewLabel_2);
		
		JButton button = new JButton("\u8FC7\u671F\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JFramePasttime();
//				new ViewOfSupplierStatistic();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 25));
		button.setBackground(new Color(218, 112, 214));
		panel_3.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(245, 222, 179));
		pane3.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(245, 222, 179));
		pane3.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 5, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel_5.add(lblNewLabel_4);
		
		JButton button_3 = new JButton("\u62A5\u635F\u62A5\u6EA2");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JFrameLoss();
//				new ViewOfCosumerSaleStatistic();
			}
		});
		button_3.setFont(new Font("宋体", Font.PLAIN, 25));
		button_3.setBackground(new Color(218, 112, 214));
		panel_5.add(button_3);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_5.add(lblNewLabel_3);
		
		JButton button_2 = new JButton("\u5E93\u5B58\u53D8\u52A8");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JFrameStorage();
//				new ViewOfSalesmanProcurementStatistic();
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 25));
		button_2.setBackground(new Color(218, 112, 214));
		panel_5.add(button_2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		panel_5.add(lblNewLabel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(245, 222, 179));
		pane3.add(panel_6);
		return pane3;
		
	}
	private JPanel getJPanel4(){
		JPanel pane4 = new JPanel();
		pane4.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 222, 179));
		pane4.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 222, 179));
		pane4.add(panel_2);
		
		JLabel label = new JLabel("统   计   报   表");
		label.setFont(new Font("宋体", Font.PLAIN, 36));
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 222, 179));
		pane4.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 5, 0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		panel_3.add(lblNewLabel);
		
		JButton button_1 = new JButton("\u5546\u54C1\u91C7\u8D2D\u7EDF\u8BA1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewOfGoodsProcurementStatistic();
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 25));
		button_1.setBackground(new Color(218, 112, 214));
		panel_3.add(button_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("仿宋", Font.BOLD, 17));
		panel_3.add(lblNewLabel_2);
		
		JButton button = new JButton("\u4F9B\u5E94\u5546\u4F9B\u8D27\u7EDF\u8BA1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewOfSupplierStatistic();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 25));
		button.setBackground(new Color(218, 112, 214));
		panel_3.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(245, 222, 179));
		pane4.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(245, 222, 179));
		pane4.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 5, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel_5.add(lblNewLabel_4);
		
		JButton button_3 = new JButton("\u5BA2\u6237\u9500\u552E\u7EDF\u8BA1");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewOfCosumerSaleStatistic();
			}
		});
		button_3.setFont(new Font("宋体", Font.PLAIN, 25));
		button_3.setBackground(new Color(218, 112, 214));
		panel_5.add(button_3);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_5.add(lblNewLabel_3);
		
		JButton button_2 = new JButton("\u4E1A\u52A1\u5458\u91C7\u8D2D");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewOfSalesmanProcurementStatistic();
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 25));
		button_2.setBackground(new Color(218, 112, 214));
		panel_5.add(button_2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		panel_5.add(lblNewLabel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(245, 222, 179));
		pane4.add(panel_6);
		return pane4;
		
	}
	private JPanel getJPanel5(){
		JPanel pane5 = new JPanel();
		pane5.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 222, 179));
		pane5.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 222, 179));
		pane5.add(panel_2);
		
		JLabel label = new JLabel("日   常   管   理");
		label.setFont(new Font("宋体", Font.PLAIN, 36));
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 222, 179));
		pane5.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 5, 0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		panel_3.add(lblNewLabel);
		
		JButton button_1 = new JButton("\u4F9B\u5E94\u5546\u7BA1\u7406");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SupplierImp();
//				new ViewOfGoodsProcurementStatistic();
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 25));
		button_1.setBackground(new Color(218, 112, 214));
		panel_3.add(button_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("仿宋", Font.BOLD, 17));
		panel_3.add(lblNewLabel_2);
		
		JButton button = new JButton("\u8D22\u52A1\u62A5\u8868\u7BA1\u7406");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				new ViewOfSupplierStatistic();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 25));
		button.setBackground(new Color(218, 112, 214));
		panel_3.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(245, 222, 179));
		pane5.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(245, 222, 179));
		pane5.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 5, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel_5.add(lblNewLabel_4);
		
		JButton button_3 = new JButton("\u4E1A\u52A1\u5458\u7BA1\u7406");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OperatorView();
//				new ViewOfCosumerSaleStatistic();
			}
		});
		button_3.setFont(new Font("宋体", Font.PLAIN, 25));
		button_3.setBackground(new Color(218, 112, 214));
		panel_5.add(button_3);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_5.add(lblNewLabel_3);
		
		JButton button_2 = new JButton("\u5546\u54C1\u5747\u4EF7\u4FEE\u6539");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangePriceView();
//				new ViewOfSalesmanProcurementStatistic();
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 25));
		button_2.setBackground(new Color(218, 112, 214));
		panel_5.add(button_2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		panel_5.add(lblNewLabel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(245, 222, 179));
		pane5.add(panel_6);
		return pane5;
		
	}
	private JPanel getJPanel6(){
		JPanel pane6 = new JPanel();
		pane6.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 222, 179));
		pane6.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 222, 179));
		pane6.add(panel_2);
		
		JLabel label = new JLabel("系   统   设   置");
		label.setFont(new Font("宋体", Font.PLAIN, 36));
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 222, 179));
		pane6.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 5, 0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		panel_3.add(lblNewLabel);
		
		JButton button_1 = new JButton("\u5546\u54C1\u7BA1\u7406");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GoodsInfoDialog(null,"商品信息",true,gb);
//				new ViewOfGoodsProcurementStatistic();
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 25));
		button_1.setBackground(new Color(218, 112, 214));
		panel_3.add(button_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("仿宋", Font.BOLD, 17));
		panel_3.add(lblNewLabel_2);
		
		JButton button = new JButton("\u4ED3\u5E93\u8BBE\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WarehouseSetDialog(null,"仓库设置",true,wb);
//				new ViewOfSupplierStatistic();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 25));
		button.setBackground(new Color(218, 112, 214));
		panel_3.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(245, 222, 179));
		pane6.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel lblNewLabel_8 = new JLabel("");
		panel_4.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		panel_4.add(lblNewLabel_9);
		
		JButton btnNewButton_1 = new JButton("\u5458\u5DE5\u8BBE\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EmployeeSetDialog(null,"员工设置",true,eb);
			}
		});
		btnNewButton_1.setBackground(new Color(218, 112, 214));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 26));
		panel_4.add(btnNewButton_1);
		
		JLabel lblNewLabel_10 = new JLabel("");
		panel_4.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		panel_4.add(lblNewLabel_11);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(245, 222, 179));
		pane6.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 5, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel_5.add(lblNewLabel_4);
		
		JButton button_3 = new JButton("\u4F9B\u8D27\u8BBE\u7F6E");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				new ViewOfCosumerSaleStatistic();
				new SupplierSetDialog(null,"供货商设置",true,sb);
			}
		});
		button_3.setFont(new Font("宋体", Font.PLAIN, 25));
		button_3.setBackground(new Color(218, 112, 214));
		panel_5.add(button_3);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_5.add(lblNewLabel_3);
		
		JButton button_2 = new JButton("\u5BA2\u6237\u8BBE\u7F6E");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				new ViewOfSalesmanProcurementStatistic();
				new CustomerSetDialog(null,"客户设置",true,cb);
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 25));
		button_2.setBackground(new Color(218, 112, 214));
		panel_5.add(button_2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		panel_5.add(lblNewLabel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(245, 222, 179));
		pane6.add(panel_6);
		return pane6;
		
	}
}
