package cn.com.listener.huang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.com.views.huang.AddNewType;

public class Acction_Frame implements ActionListener {
    private AddNewType at;
    public Acction_Frame(AddNewType at){
    	  this.at=at;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
            at.Allation(e);
	}

}
