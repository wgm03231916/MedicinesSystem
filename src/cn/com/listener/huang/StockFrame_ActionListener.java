package cn.com.listener.huang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;



import javax.swing.JInternalFrame;

import cn.com.views.huang.BuyInView;
import cn.com.views.huang.BuyOutView;
import cn.com.views.huang.StockView;

public class StockFrame_ActionListener implements ActionListener {
    private StockView sk;
    
    private StockFrame_ActionListener_service sae;
    public StockFrame_ActionListener(StockView sk){
    	this.sk=sk;
    	sae=new StockFrame_ActionListener_service(sk);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		      Object o=e.getSource();
		      if(o==sk.getBtnBuyIn()){
		    	  new BuyInView(null,0,0);
			  //new BuyInView("采购进货", true, true, true);
//			  JInternalFrame jif=new JInternalFrame("采购进货",true,true,true);
//			  jif.setSize(750, 480);
//			  jif.setVisible(true);
			  
		  }else if(o==sk.getBtnBuyOut()){
			  new BuyOutView(null,0,0);
		  }
	}

}
