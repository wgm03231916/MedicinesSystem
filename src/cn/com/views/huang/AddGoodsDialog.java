package cn.com.views.huang;

import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.com.beans.GoodsBean;
import cn.com.daos.huang.MedicineDaoImp;
import cn.com.listener.huang.AddGoodsFrame_ActionListener;



public class AddGoodsDialog extends JDialog {
	
	private JPanel pnlMain;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public JPanel getPnlMain() {
		return pnlMain;
	}
	public void setPnlMain(JPanel pnlMain) {
		this.pnlMain = pnlMain;
	}
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	public JTextField getTextField_1() {
		return textField_1;
	}
	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}
	public JTextField getTextField_2() {
		return textField_2;
	}
	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}
	public JTextField getTextField_3() {
		return textField_3;
	}
	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}
	public JTextField getTextField_4() {
		return textField_4;
	}
	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}
	public JTextField getTextField_5() {
		return textField_5;
	}
	public void setTextField_5(JTextField textField_5) {
		this.textField_5 = textField_5;
	}
	public JTextField getTextField_6() {
		return textField_6;
	}
	public void setTextField_6(JTextField textField_6) {
		this.textField_6 = textField_6;
	}
	public JTextField getTextField_7() {
		return textField_7;
	}
	public void setTextField_7(JTextField textField_7) {
		this.textField_7 = textField_7;
	}
	public JTextField getTextField_8() {
		return textField_8;
	}
	public void setTextField_8(JTextField textField_8) {
		this.textField_8 = textField_8;
	}
	public JTextField getTextField_9() {
		return textField_9;
	}
	public void setTextField_9(JTextField textField_9) {
		this.textField_9 = textField_9;
	}
	public JButton getBtnSearch() {
		return btnSearch;
	}
	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public DefaultComboBoxModel getDcmType() {
		return dcmType;
	}
	public void setDcmType(DefaultComboBoxModel dcmType) {
		this.dcmType = dcmType;
	}
	public DefaultComboBoxModel getDcmUnit() {
		return dcmUnit;
	}
	public void setDcmUnit(DefaultComboBoxModel dcmUnit) {
		this.dcmUnit = dcmUnit;
	}
	public JTextField getComboBox() {
		return comboBox;
	}
	public void setComboBox(JTextField comboBox) {
		this.comboBox = comboBox;
	}
	public JTextField getComboBox_1() {
		return comboBox_1;
	}
	public void setComboBox_1(JTextField comboBox_1) {
		this.comboBox_1 = comboBox_1;
	}
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JButton btnSearch;
	public String msg;
	
	public DefaultComboBoxModel dcmType;
	public DefaultComboBoxModel dcmUnit;
	public JTextField comboBox;
	public JTextField comboBox_1;
	public AddGoodsDialog(){
    	 pnlMain=new JPanel(null);
    	 comboBox = new JTextField();
    	 comboBox_1=new JTextField();
    	 dcmType=new DefaultComboBoxModel();
    	 dcmUnit=new DefaultComboBoxModel();
    	init();
    }
	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setSize(480,440);
		this.setTitle("增加商品");
		pnlMain.setBorder(BorderFactory.createTitledBorder("商品信息"));
		setTitle("增加商品");
		pnlMain.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("药剂类型：");
		lblNewLabel.setBounds(25, 14, 68, 25);
		pnlMain.add(lblNewLabel);
		
		JLabel label = new JLabel("商品编号：");
		label.setBounds(255, 14, 68, 25);
		pnlMain.add(label);
		
		JLabel label_1 = new JLabel("商品名称：");
		label_1.setBounds(25, 53, 68, 25);
		pnlMain.add(label_1);
		
		JLabel label_2 = new JLabel("商品条码：");
		label_2.setBounds(255, 53, 68, 25);
		pnlMain.add(label_2);
		
		JLabel label_3 = new JLabel("商品规格：");
		label_3.setBounds(25, 100, 68, 25);
		pnlMain.add(label_3);
		
		JLabel label_4 = new JLabel("商品单位：");
		label_4.setBounds(255, 100, 68, 25);
		pnlMain.add(label_4);
		
		JLabel label_5 = new JLabel("批准文号：");
		label_5.setBounds(25, 148, 68, 25);
		pnlMain.add(label_5);
		
		JLabel label_6 = new JLabel("预设进价：");
		label_6.setBounds(255, 148, 68, 25);
		pnlMain.add(label_6);
		
		JLabel label_7 = new JLabel("生产厂商：");
		label_7.setBounds(25, 196, 68, 25);
		pnlMain.add(label_7);
		
		JLabel label_8 = new JLabel("预设售价：");
		label_8.setBounds(255, 196, 68, 25);
		pnlMain.add(label_8);
		
		JLabel label_9 = new JLabel("所属类别：");
		label_9.setBounds(25, 245, 68, 25);
		pnlMain.add(label_9);
		
		JLabel lblNewLabel_1 = new JLabel("备注：");
		lblNewLabel_1.setBounds(30, 290, 54, 25);
		pnlMain.add(lblNewLabel_1);
		
		comboBox.setBounds(103, 16, 107, 21);
		//comboBox.addItemListener(new addType_ItemListener(this));
		pnlMain.add(comboBox);
		setTypeData();
		//this.comboBox.setModel(dcmType);
		
		
		
		textField = new JTextField();
		textField.setBounds(325, 16, 107, 21);
		pnlMain.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(103, 55, 107, 21);
		pnlMain.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(325, 55, 107, 21);
		pnlMain.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(103, 102, 107, 21);
		pnlMain.add(textField_3);
		
		this.comboBox_1.setBounds(325, 102, 107, 21);
		
		pnlMain.add(comboBox_1);
		setUnitData();
		//this.comboBox_1.setModel(dcmUnit);
		
		
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(103, 150, 107, 21);
		pnlMain.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(325, 150, 107, 21);
		pnlMain.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(103, 198, 142, 21);
		pnlMain.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(325, 198, 107, 21);
		pnlMain.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setBounds(74, 290, 328, 20);
		pnlMain.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9=new JTextField();
		textField_9.setBounds(103, 245, 80, 20);
		pnlMain.add(textField_9);
		btnSearch=new JButton("搜索");
		btnSearch.setBounds(185, 245, 70, 20);
		pnlMain.add(btnSearch);
		
		 btnNewButton = new JButton("保存");
		btnNewButton.setBounds(117, 347, 93, 35);
		pnlMain.add(btnNewButton);
		btnNewButton.addActionListener(new AddGoodsFrame_ActionListener(this));
		
		 btnNewButton_1 = new JButton("退出");
		btnNewButton_1.addActionListener(new AddGoodsFrame_ActionListener(this));
		btnNewButton_1.setBounds(272, 347, 93, 35);
		pnlMain.add(btnNewButton_1);
		this.add(pnlMain);
		this.setVisible(true);
	}
	private void setUnitData() {
		// TODO Auto-generated method stub
		//this.dcmUnit.addElement("");
		this.dcmUnit.addElement("增加新单位...");
		
		
	}
	private void setTypeData() {
		// TODO Auto-generated method stub
		this.dcmType.addElement("");
		
		this.dcmType.addElement("增加新类型...");
	}
//	public void AddTypeORUnit(ItemEvent e) {
//		// TODO Auto-generated method stub
//		if(this.comboBox.getSelectedIndex()==1){
//			new AddNewType(this);
//		}
//	}
	public void SaveORExit(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		GoodsBean gg=null;
		if(o==this.getBtnNewButton()){
             gg=new GoodsBean();
			 gg.setGoods_id(this.getTextField().getText().toString());
				//System.out.println("---------1111"+gg.getGoods_id());
			 gg.setGoods_Name(this.getTextField_1().getText().toString());
			 gg.setGoods_type(this.getTextField_9().getText());
			 gg.setGoods_codes(this.getTextField_2().getText());
			 gg.setGoods_unit(this.getComboBox_1().getText());
			 gg.setGoods_spft(this.getTextField_3().getText());
			 gg.setGoods_Apvlnum(this.getTextField_4().getText().toString());
		     gg.setGoods_setting(Float.parseFloat(this.getTextField_5().getText().toString()));
			 gg.setGoods_price(Float.parseFloat(this.getTextField_7().getText().toString()));
			 gg.setGood_manufacture(this.getTextField_6().getText().toString());
			 gg.setGoods_note(this.getTextField_8().getText().toString());
			 MedicineDaoImp dao=new MedicineDaoImp();
			 boolean bool=dao.addGoodsInfo(gg);
			 if(getTextField().getText().toString().equals("")||getTextField_8().getText().toString().equals("")
					 ||getTextField_1().getText().toString().equals("")||getComboBox_1().getText().toString().equals(""))
			 {
				 JOptionPane.showMessageDialog(null, "商品编号，名称，类别，单位必须填写！", "系统提示",
							JOptionPane.INFORMATION_MESSAGE);
			 }else if(bool==true){
				 JOptionPane.showMessageDialog(null, "保存成功！", "系统提示",
							JOptionPane.INFORMATION_MESSAGE);
				 this.dispose();
			 }
		}
		else if(o==this.getBtnNewButton_1()){
			 gg=new GoodsBean();
			 gg.setGoods_id(this.getTextField().getText().toString());
				//System.out.println("---------1111"+gg.getGoods_id());
			 gg.setGoods_Name(this.getTextField_1().getText().toString());
			 gg.setGoods_type(this.getTextField_9().getText());
			 gg.setGoods_codes(this.getTextField_2().getText());
			 gg.setGoods_unit(this.getComboBox_1().getText());
			 gg.setGoods_spft(this.getTextField_3().getText());
			 gg.setGoods_Apvlnum(this.getTextField_4().getText().toString());
		     gg.setGoods_setting(Float.parseFloat(this.getTextField_5().getText().toString()));
			 gg.setGoods_price(Float.parseFloat(this.getTextField_7().getText().toString()));
			 gg.setGood_manufacture(this.getTextField_6().getText().toString());
			 gg.setGoods_note(this.getTextField_8().getText().toString());
			 MedicineDaoImp dao=new MedicineDaoImp();
			 boolean bool=dao.addGoodsInfo(gg);
			 if(getTextField().getText().toString().equals("")||getTextField_8().getText().toString().equals("")
					 ||getTextField_1().getText().toString().equals("")||getComboBox_1().getText().toString().equals(""))
			 {
				 JOptionPane.showMessageDialog(null, "商品编号，名称，类别，单位必须填写！", "系统提示",
							JOptionPane.INFORMATION_MESSAGE);
			 }else if(bool==true){
				 
				 this.dispose();
			 }
		}
	}
	public JButton getBtnNewButton() {
		return btnNewButton;
	}
	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}
	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}
	public void setBtnNewButton_1(JButton btnNewButton_1) {
		this.btnNewButton_1 = btnNewButton_1;
	}
	
}
