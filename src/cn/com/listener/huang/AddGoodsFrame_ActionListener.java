package cn.com.listener.huang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.com.views.huang.AddGoodsDialog;

public class AddGoodsFrame_ActionListener implements ActionListener {
    private AddGoodsDialog ad;
    public AddGoodsFrame_ActionListener(AddGoodsDialog ad){
    	this.ad=ad;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
           ad.SaveORExit(e);
	}

}
