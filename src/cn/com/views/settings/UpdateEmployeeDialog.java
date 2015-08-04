package cn.com.views.settings;

import java.awt.Dialog;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cn.com.beans.EmployeeBean;
import cn.com.service.settings.UpdateEmployeeService;

public class UpdateEmployeeDialog extends JDialog{
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblTitle;
	private JLabel lblTel;
	private JLabel lblAddr;
	private JLabel lblNote;
	private JTextField textId;
	private JTextField textName;
	private JTextField textTitle;
	private JTextField textTel;
	private JTextField textAddr;
	private JTextField textNote;
	private JButton btnSave;
	private JButton btnExit;
	private EmployeeSetDialog ed;
	private EmployeeBean eb;
	
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
	public JTextField gettextTitle() {
		return textTitle;
	}
	public void settextTitle(JTextField textTitle) {
		this.textTitle = textTitle;
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
	public UpdateEmployeeDialog(EmployeeSetDialog ed,String title,boolean model,EmployeeBean eb) {
		super(ed,title,model);
		this.eb = eb;
		lblId = new JLabel("员工编号*：");
		lblName = new JLabel("员工名称*：");
		lblTitle = new JLabel("所属职位：");
		lblTel = new JLabel("联系电话：");
		lblAddr = new JLabel("员工地址：");
		lblNote = new JLabel("备注：");
		textId = new JTextField();
		textName = new JTextField();
		textTitle = new JTextField();
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
		this.setTitle("修改员工");
		this.setSize(415, 345);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(getOwner());
		this.setResizable(false);
		getContentPane().setLayout(null);
		
		lblId.setBounds(37, 10, 78, 23);
		getContentPane().add(lblId);
		
		lblName.setBounds(37, 50, 78, 23);
		getContentPane().add(lblName);
		
		lblTitle.setBounds(37, 90, 68, 23);
		getContentPane().add(lblTitle);
		
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
		
		textTitle.setColumns(10);
		textTitle.setBounds(119, 91, 213, 21);
		getContentPane().add(textTitle);
		
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
	
		
		
		
		UpdateEmployeeService ups = new UpdateEmployeeService(this,ed,eb);
		btnSave.setActionCommand("Save");
		btnExit.setActionCommand("Exit");
		
		btnSave.addActionListener(ups);
		btnExit.addActionListener(ups);
		
	}
	private void initData() {
		// TODO Auto-generated method stub
		this.textId.setText(eb.getEmployee_id());
		this.textName.setText(eb.getEmployee_name());
		this.textTitle.setText(eb.getEmployee_title());
		this.textTel.setText(eb.getEmployee_tel());
		this.textAddr.setText(eb.getEmployee_addr());
		this.textNote.setText(eb.getEmployee_note());
		this.setVisible(true);
	}

}
