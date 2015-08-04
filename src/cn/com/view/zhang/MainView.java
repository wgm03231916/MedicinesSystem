package cn.com.view.zhang;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



import cn.com.service.zhang.MainChangePriceService;
import cn.com.service.zhang.MainOperatorService;
import cn.com.service.zhang.MainViewService;

public class MainView extends JFrame{
	private JLabel lbltext;
	private JPanel pnlMain;
	private JButton supManege;
	private JButton moneyManege;
	private JButton operaterManege;
	private JButton customerMansge;
	private JButton ChangePrice;

	public MainView(){
		pnlMain = new JPanel(null);
		lbltext = new JLabel("日常管理");
		Font font = new  Font("楷书",Font.BOLD, 28);
		lbltext.setFont(font);
		supManege = new JButton("供应商管理");
		moneyManege = new JButton("财务报表管理");
		operaterManege = new JButton("业务员管理");
		customerMansge = new JButton("客户综合管理");
		ChangePrice = new JButton("商品均价修改");
		
		
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(750, 480);
		
		lbltext.setBounds(300, 60,120, 30);
		supManege.setBounds(200, 160, 120, 30);
		moneyManege.setBounds(200, 240, 120, 30);
		operaterManege.setBounds(400, 160, 120, 30);
		customerMansge.setBounds(400,240, 120, 30);
		ChangePrice.setBounds(400, 320, 120, 30);
		supManege.addActionListener(new MainViewService(this));
		operaterManege.addActionListener(new MainOperatorService(this));
		ChangePrice.addActionListener(new MainChangePriceService(this));
		pnlMain.add(lbltext);
		pnlMain.add(supManege);
		pnlMain.add(moneyManege);
		pnlMain.add(operaterManege);
		pnlMain.add(customerMansge);
		pnlMain.add(ChangePrice);
		
		this.add(pnlMain);
		this.setVisible(true);
	}
	public static void main(String[] args){
		new MainView();
		
	}

}