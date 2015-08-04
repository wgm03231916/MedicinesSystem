package cn.com.ui.wang;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cn.com.ui.mouselistener.wang.SalesFrame_currentAccounts_MouseListener;
import cn.com.ui.mouselistener.wang.SalesFrame_goodsMarket_MouseListener;


public class SalesFrame extends JFrame {
	private JLabel lblText;
	private JPanel pnlMain;
	private JButton goodsMarket;
	private JButton goodsReturns;
	private JButton currentAccounts;

	public SalesFrame(){
		pnlMain = new JPanel(null);
		lblText = new JLabel("销售管理");
		Font font = new  Font("楷书",Font.BOLD, 28);
		lblText.setFont(font);
		goodsMarket = new JButton("商品销售");
		goodsReturns = new JButton("当前库存查询");
		currentAccounts = new JButton("往来账目");
		
		
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(750, 480);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(getOwner());
		this.setResizable(false);
		
		lblText.setBounds(300, 60,120, 30);
		goodsMarket.setBounds(120, 220, 120, 30);
		goodsReturns.setBounds(320, 220, 120, 30);
		currentAccounts.setBounds(520, 220, 120, 30);
		
		goodsMarket.addMouseListener(new SalesFrame_goodsMarket_MouseListener(this));
		currentAccounts.addMouseListener(new SalesFrame_currentAccounts_MouseListener(this));
		
		pnlMain.add(lblText);
		pnlMain.add(goodsMarket);
		pnlMain.add(goodsReturns);
		pnlMain.add(currentAccounts);
		
		this.add(pnlMain);
		this.setVisible(true);
	}
	
}
