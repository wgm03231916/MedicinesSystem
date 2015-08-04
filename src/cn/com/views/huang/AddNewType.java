package cn.com.views.huang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;

import cn.com.listener.huang.Acction_Frame;

public class AddNewType extends JDialog{
      private JPanel pnlMain;
      private JButton btnAdd;
      private JButton btnDel;
     // String msg;
      public JPanel getPnlMain() {
		return pnlMain;
	}
	public void setPnlMain(JPanel pnlMain) {
		this.pnlMain = pnlMain;
	}
	public JButton getBtnAdd() {
		return btnAdd;
	}
	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}
	public JButton getBtnDel() {
		return btnDel;
	}
	public void setBtnDel(JButton btnDel) {
		this.btnDel = btnDel;
	}
	public JButton getBtnSure() {
		return btnSure;
	}
	public void setBtnSure(JButton btnSure) {
		this.btnSure = btnSure;
	}
	public JButton getBtnExit() {
		return btnExit;
	}
	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}
	private JButton btnSure;
    private JButton btnExit;
    public AddGoodsDialog ad;
//      public AddNewType(String msg){
//    	   this.msg=msg;
//      }
      public AddNewType(AddGoodsDialog ad){
    	 // this.msg=msg;
    	  this.ad=ad;
    	  pnlMain=new JPanel(null);
    	  btnAdd=new JButton("添加");
    	  btnDel=new JButton("删除");
    	  btnSure=new JButton("确定");
    	  btnExit=new JButton("退出");
    	  init();
      }
	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("药剂类型");
		this.setModal(true);
		this.setSize(300,300);
		pnlMain.add(btnAdd);
		pnlMain.add(btnDel);
		
		pnlMain.add(btnSure);
		pnlMain.add(btnExit);
		btnAdd.setBounds(10,10,60,30);
		btnDel.setBounds(75, 10, 60, 30);
		btnSure.setBounds(140, 10, 60, 30);
		btnExit.setBounds(205, 10, 60, 30);
		btnExit.addActionListener(new Acction_Frame(this));
			
		this.add(pnlMain);
		this.setVisible(true);
	}
	public void Allation(ActionEvent e) {
		// TODO Auto-generated method stub
		   
		   Object o=e.getSource();
		   if(o==this.getBtnExit()){
			  // System.out.println("msg2："+msg);
			   //ad.msg="";
			  // ad.comboBox.getItemAt(0);
			   //ad.validate();
			   //ad.comboBox.getItemAt(0);
			  // ad.comboBox.setSelectedIndex(0);
	           this.dispose();
	           //ad.invalidate();
	           
		   }
	}
}
