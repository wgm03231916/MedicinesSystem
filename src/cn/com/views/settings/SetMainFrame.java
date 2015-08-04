package cn.com.views.settings;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;

import cn.com.service.settings.SetMainService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetMainFrame extends JFrame {
	private JLabel lblTitle;
	private JButton btnGoods;
	private JButton btnWarehouse;
	private JButton btnSupplier;
	private JButton btnCustomer;
	private JButton btnEmployee;
	
	public SetMainFrame() {
		lblTitle = new JLabel("系统设置");
		btnGoods = new JButton("商品管理");
		btnWarehouse = new JButton("仓库设置");
		btnSupplier = new JButton("供货商设置");
		btnCustomer = new JButton("客户设置");
		btnEmployee = new JButton("员工设置");
		init();
		
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setTitle("系统设置");
		this.setSize(750, 480);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(getOwner());
		getContentPane().setLayout(null);
		
		lblTitle.setForeground(Color.RED);
		lblTitle.setFont(new Font("宋体", Font.BOLD, 30));
		lblTitle.setBounds(302, 96, 139, 29);
		getContentPane().add(lblTitle);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(270, 135, 189, 7);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(270, 148, 189, 7);
		getContentPane().add(separator_1);
		
		btnGoods.setBounds(241, 176, 100, 30);
		getContentPane().add(btnGoods);
		btnWarehouse.setBounds(385, 176, 100, 30);
		getContentPane().add(btnWarehouse);
		btnSupplier.setBounds(241, 242, 100, 30);
		getContentPane().add(btnSupplier);
		btnCustomer.setBounds(385, 242, 100, 30);
		getContentPane().add(btnCustomer);
		btnEmployee.setBounds(385, 306, 100, 30);
		getContentPane().add(btnEmployee);
		
		SetMainService sm = new SetMainService();
		btnGoods.setActionCommand("Goods");
		btnWarehouse.setActionCommand("Warehouse");
		btnSupplier.setActionCommand("Supplier");
		btnCustomer.setActionCommand("Customer");
		btnEmployee.setActionCommand("Employee");
		
		btnGoods.addActionListener(sm);
		btnWarehouse.addActionListener(sm);
		btnSupplier.addActionListener(sm);
		btnCustomer.addActionListener(sm);
		btnEmployee.addActionListener(sm);
		this.setVisible(true);
		
	}
}
