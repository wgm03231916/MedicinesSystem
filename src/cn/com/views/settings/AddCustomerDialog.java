package cn.com.views.settings;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import cn.com.service.settings.AddCustomerService;

public class AddCustomerDialog extends JDialog{
	private JLabel lblNo;
	private JLabel lblName;
	private JLabel lblContact;
	private JLabel lblTel;
	private JLabel lblAddress;
	private JLabel lblNote;
	private JTextField textNO;
	private JTextField textName;
	private JTextField textContact;
	private JTextField textTel;
	private JTextField textAddress;
	private JTextField textNote;
	private JButton btnSave;
	private JButton btnExit;
	private CustomerSetDialog cd;
	public AddCustomerDialog(CustomerSetDialog cd){
		this.cd = cd;
	}
	
	
	public JTextField getTextNO() {
		return textNO;
	}


	public void setTextNO(JTextField textNO) {
		this.textNO = textNO;
	}


	public JTextField getTextName() {
		return textName;
	}


	public void setTextName(JTextField textName) {
		this.textName = textName;
	}


	public JTextField getTextContact() {
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


	public JTextField getTextAddress() {
		return textAddress;
	}


	public void setTextAddress(JTextField textAddress) {
		this.textAddress = textAddress;
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
	public AddCustomerDialog(CustomerSetDialog cd,String title,boolean model) {
		super(cd,title,model);
		lblNo = new JLabel("客户编号*：");
		lblName = new JLabel("客户名称*：");
		lblContact = new JLabel("联系人：");
		lblTel = new JLabel("联系电话：");
		lblAddress = new JLabel("客户地址：");
		lblNote = new JLabel("备注：");
		textNO = new JTextField();
		textName = new JTextField();
		textContact = new JTextField();
		textTel = new JTextField();
		textAddress = new JTextField();
		textNote = new JTextField();
		btnSave = new JButton("保存");
		btnExit = new JButton("退出");
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setTitle("增加客户");
		this.setSize(425, 398);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(getOwner());
		this.setResizable(false);
		getContentPane().setLayout(null);
		
		lblNo.setBounds(50, 20, 72, 15);
		getContentPane().add(lblNo);
		lblName.setBounds(50, 60, 72, 15);
		getContentPane().add(lblName);
		lblContact.setBounds(61, 102, 61, 15);
		getContentPane().add(lblContact);
		lblTel.setBounds(50, 140, 72, 15);
		getContentPane().add(lblTel);
		lblAddress.setBounds(50, 180, 72, 15);
		getContentPane().add(lblAddress);
		lblNote.setBounds(74, 220, 43, 15);
		getContentPane().add(lblNote);
		
		textNO.setBounds(142, 17, 192, 21);
		getContentPane().add(textNO);
		textNO.setColumns(10);
		textName.setBounds(142, 57, 192, 21);
		getContentPane().add(textName);
		textName.setColumns(10);
		textContact.setColumns(10);
		textContact.setBounds(142, 99, 192, 21);
		getContentPane().add(textContact);
		textTel.setColumns(10);
		textTel.setBounds(142, 137, 192, 21);
		getContentPane().add(textTel);
		textAddress.setColumns(10);
		textAddress.setBounds(142, 177, 192, 21);
		getContentPane().add(textAddress);
		textNote.setBounds(142, 217, 192, 68);
		getContentPane().add(textNote);
		textNote.setColumns(10);
		
		btnSave.setBounds(109, 303, 93, 41);
		getContentPane().add(btnSave);
		btnExit.setBounds(232, 303, 93, 41);
		getContentPane().add(btnExit);
		
		AddCustomerService ads = new AddCustomerService(this,cd);
		btnSave.setActionCommand("Save");
		btnExit.setActionCommand("Exit");
		
		btnSave.addActionListener(ads);
		btnExit.addActionListener(ads);
		this.setVisible(true);
	}
}
