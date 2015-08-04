package cn.com.views.settings;

import java.awt.Dialog;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cn.com.beans.CustomerBean;
import cn.com.service.settings.UpdateCustomerService;

public class UpdateCustomerDialog extends JDialog{
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblContact;
	private JLabel lblTel;
	private JLabel lblAddr;
	private JLabel lblNote;
	private JTextField textId;
	private JTextField textName;
	private JTextField textContact;
	private JTextField textTel;
	private JTextField textAddr;
	private JTextField textNote;
	private JButton btnSave;
	private JButton btnExit;
	private CustomerSetDialog cd;
	private CustomerBean cb;
	
	public JTextField getTextId() {
		return textId;
	}
	public void setTextId(JTextField textId) {
		this.textId = textId;
	}
	public JTextField getTextName() {
		return textName;
	}
	public void setTextName(JTextField textName) {
		this.textName = textName;
	}
	public JTextField gettextContact() {
		return textContact;
	}
	public void setTextContact(JTextField textContact) {
		this.textContact = textContact;
	}
	public JTextField getTextTel() {
		return textTel;
	}
	public void setTextTel(JTextField textTel) {
		this.textTel = textTel;
	}
	public JTextField getTextAddr() {
		return textAddr;
	}
	public void setTextAddr(JTextField textAddr) {
		this.textAddr = textAddr;
	}
	public JTextField getTextNote() {
		return textNote;
	}
	public void setTextNote(JTextField textNote) {
		this.textNote = textNote;
	}
	public JButton getBtnSave() {
		return btnSave;
	}
	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}
	public JButton getBtnExit() {
		return btnExit;
	}
	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public UpdateCustomerDialog(CustomerSetDialog cd,String title,boolean model,CustomerBean cb) {
		super(cd,title,model);
		this.cb = cb;
		lblId = new JLabel("客户编号*：");
		lblName = new JLabel("客户名称*：");
		lblContact = new JLabel("联系人：");
		lblTel = new JLabel("联系电话：");
		lblAddr = new JLabel("客户地址：");
		lblNote = new JLabel("备注：");
		textId = new JTextField();
		textName = new JTextField();
		textContact = new JTextField();
		textTel = new JTextField();
		textAddr = new JTextField();
		textNote = new JTextField();
		btnSave = new JButton("保存");
		btnExit = new JButton("退出");
		init();
		initData();
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setTitle("修改客户");
		this.setSize(415, 345);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(getOwner());
		this.setResizable(false);
		getContentPane().setLayout(null);
		
		lblId.setBounds(37, 10, 78, 23);
		getContentPane().add(lblId);
		
		lblName.setBounds(37, 50, 78, 23);
		getContentPane().add(lblName);
		
		lblContact.setBounds(47, 90, 58, 23);
		getContentPane().add(lblContact);
		
		lblTel.setBounds(37, 130, 72, 23);
		getContentPane().add(lblTel);
		
		lblAddr.setBounds(37, 170, 78, 23);
		getContentPane().add(lblAddr);
		
		lblNote.setBounds(60, 210, 49, 23);
		getContentPane().add(lblNote);
		
	
		textId.setBounds(119, 11, 213, 21);
		getContentPane().add(textId);
		textId.setColumns(10);
		textId.setEditable(false);
		

		textName.setColumns(10);
		textName.setBounds(119, 51, 213, 21);
		getContentPane().add(textName);
		
		textContact.setColumns(10);
		textContact.setBounds(119, 91, 213, 21);
		getContentPane().add(textContact);
		
		textTel.setColumns(10);
		textTel.setBounds(119, 131, 213, 21);
		getContentPane().add(textTel);
		
		textAddr.setColumns(10);
		textAddr.setBounds(119, 171, 213, 21);
		getContentPane().add(textAddr);
		
		textNote.setColumns(10);
		textNote.setBounds(119, 211, 213, 38);
		getContentPane().add(textNote);
		
		btnSave.setBounds(118, 259, 93, 36);
		getContentPane().add(btnSave);
		
		btnExit.setBounds(239, 259, 93, 36);
		getContentPane().add(btnExit);
	
		
		
		
		UpdateCustomerService ups = new UpdateCustomerService(this,cd,cb);
		btnSave.setActionCommand("Save");
		btnExit.setActionCommand("Exit");
		
		btnSave.addActionListener(ups);
		btnExit.addActionListener(ups);
		
	}
	private void initData() {
		// TODO Auto-generated method stub
		this.textId.setText(cb.getCustomer_id());
		this.textName.setText(cb.getCustomer_name());
		this.textContact.setText(cb.getCustomer_contact());
		this.textTel.setText(cb.getCustomer_tel());
		this.textAddr.setText(cb.getCustomer_addr());
		this.textNote.setText(cb.getCustomer_note());
		this.setVisible(true);
	}

}
