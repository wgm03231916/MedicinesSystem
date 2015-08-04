package cn.com.ui.wang;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cn.com.ui.mouselistener.wang.OrderInfoFrame_priceMessage_MouseListener;
import cn.com.ui.mouselistener.wang.OrderInfoFrame_sumOrder_MouseListener;

public class OrderInfoFrame extends JFrame {
	private JPanel pnlMain;
	private JButton sumOrder;
	private JButton priceMessage;
	
	
	public OrderInfoFrame(){
		pnlMain = new JPanel(null);
		sumOrder = new JButton("客户所有单据");
		priceMessage = new JButton("客户消费情况");
		
		
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(390, 230);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(getOwner());
		this.setResizable(false);
		
		sumOrder.setBounds(50, 80, 120, 30);
		priceMessage.setBounds(220, 80, 120, 30);
		
		
		sumOrder.addMouseListener(new OrderInfoFrame_sumOrder_MouseListener(this));
		priceMessage.addMouseListener(new OrderInfoFrame_priceMessage_MouseListener(this));
		
		pnlMain.add(sumOrder);
		pnlMain.add(priceMessage);
		
		
		this.add(pnlMain);
		this.setVisible(true);
	}
	
	
}
