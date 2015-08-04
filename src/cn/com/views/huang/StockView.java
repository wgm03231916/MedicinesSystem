package cn.com.views.huang;

import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;



import cn.com.listener.huang.MainFranme_ActionListener;
import cn.com.listener.huang.StockFrame_ActionListener;

public class StockView extends JFrame {
     private JPanel pnlMain;
     private JButton btnBuyIn;
     private JButton btnBuyOut;
     private JButton btnAccounts;
     private JButton btnSearch;
     private StockView sk;
     private JDesktopPane dnlC;
	public JPanel getPnlMain() {
		return pnlMain;
	}
	public void setPnlMain(JPanel pnlMain) {
		this.pnlMain = pnlMain;
	}
	public JButton getBtnBuyIn() {
		return btnBuyIn;
	}
	public void setBtnBuyIn(JButton btnBuyIn) {
		this.btnBuyIn = btnBuyIn;
	}
	public JButton getBtnBuyOut() {
		return btnBuyOut;
	}
	public void setBtnBuyOut(JButton btnBuyOut) {
		this.btnBuyOut = btnBuyOut;
	}
	public JButton getBtnAccounts() {
		return btnAccounts;
	}
	public void setBtnAccounts(JButton btnAccounts) {
		this.btnAccounts = btnAccounts;
	}
	public JButton getBtnSearch() {
		return btnSearch;
	}
	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}
     public StockView(){
    	 //sk=new StockView();
    	 pnlMain=new JPanel(null);
    	 dnlC = new JDesktopPane();
    	 btnBuyIn=new JButton("采购进货");
    	 btnBuyOut=new JButton("采购退货");
    	 btnAccounts=new JButton("往来账务");
    	 btnSearch=new JButton("库存查询");
    	 init();
     }
	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(200, 300);
		pnlMain.add(btnBuyOut);
		pnlMain.add(btnBuyIn);
		pnlMain.add(btnAccounts);
		pnlMain.add(btnSearch);
		btnBuyIn.setBounds(40, 30, 120, 30);
		btnBuyOut.setBounds(40, 80, 120, 30);
		btnAccounts.setBounds(40, 130, 120, 30);
		btnSearch.setBounds(40, 180, 120, 30);
		btnBuyIn.addActionListener(new StockFrame_ActionListener(this));
		btnBuyOut.addActionListener(new StockFrame_ActionListener(this));
		btnAccounts.addActionListener(new StockFrame_ActionListener(this));
		btnSearch.addActionListener(new StockFrame_ActionListener(this));
		this.add(pnlMain);
		this.setVisible(true);
	}
	
}
