package cn.com.window.storagement;


import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;

import cn.com.windowlistener.storage.MainFrame_btn_mouseListener;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class JFrameMain extends JFrame {
	private JButton btn_transfer;
	private JButton btn_search;
	private JButton btn_loss;
	private JButton btn_change;
	
	
	public JButton getBtn_transfer() {
		return btn_transfer;
	}


	public void setBtn_transfer(JButton btnTransfer) {
		btn_transfer = btnTransfer;
	}


	public JButton getBtn_search() {
		return btn_search;
	}


	public void setBtn_search(JButton btnSearch) {
		btn_search = btnSearch;
	}


	public JButton getBtn_loss() {
		return btn_loss;
	}


	public void setBtn_loss(JButton btnLoss) {
		btn_loss = btnLoss;
	}


	public JButton getBtn_change() {
		return btn_change;
	}


	public void setBtn_change(JButton btnChange) {
		btn_change = btnChange;
	}


	public JFrameMain() {
		super("ø‚¥Êπ‹¿Ì");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn_transfer = new JButton("\u4ED3\u5E93\u8C03\u62E8");
		btn_transfer.addMouseListener(new MainFrame_btn_mouseListener(this));
		btn_transfer.setBackground(Color.YELLOW);
		btn_transfer.setBounds(59, 73, 93, 23);
		getContentPane().add(btn_transfer);
		
		btn_search = new JButton("\u62A5\u635F\u62A5\u6EA2");
		btn_search.addMouseListener(new MainFrame_btn_mouseListener(this));
		btn_search.setBackground(Color.MAGENTA);
		btn_search.setBounds(59, 135, 93, 23);
		getContentPane().add(btn_search);
		
		btn_loss = new JButton("\u8FC7\u671F\u67E5\u8BE2");
		btn_loss.addMouseListener(new MainFrame_btn_mouseListener(this));
		btn_loss.setBackground(Color.RED);
		btn_loss.setBounds(225, 73, 93, 23);
		getContentPane().add(btn_loss);
		
		btn_change = new JButton("\u5E93\u5B58\u53D8\u52A8");
		btn_change.addMouseListener(new MainFrame_btn_mouseListener(this));
		btn_change.setForeground(new Color(0, 0, 0));
		btn_change.setBackground(new Color(0, 255, 255));
		btn_change.setBounds(225, 135, 93, 23);
		getContentPane().add(btn_change);
	}

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMain frame = new JFrameMain();
					frame.setSize(500, 300);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
