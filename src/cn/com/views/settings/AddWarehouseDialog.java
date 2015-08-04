package cn.com.views.settings;

import java.awt.Dialog;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import cn.com.service.settings.AddWarehouseService;

public class AddWarehouseDialog extends JDialog{
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblHead;
	private JLabel lblTel;
	private JLabel lblAddr;
	private JLabel lblNote;
	private JTextField textId;
	private JTextField textName;
	private JTextField textHead;
	private JTextField textTel;
	private JTextField textAddr;
	private JTextField textNote;
	private JButton btnSave;
	private JButton btnExit;
	private WarehouseSetDialog wd;
	public AddWarehouseDialog(WarehouseSetDialog wd){
		this.wd = wd;
	}
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
	public JTextField getTextHead() {
		return textHead;
	}
	public void setTextHead(JTextField textHead) {
		this.textHead = textHead;
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
	public AddWarehouseDialog(WarehouseSetDialog wd,String title,boolean model) {
		super(wd,title,model);
		lblId = new JLabel("仓库编号*：");
		lblName = new JLabel("仓库名称*：");
		lblHead = new JLabel("负责人：");
		lblTel = new JLabel("联系电话：");
		lblAddr = new JLabel("仓库地址：");
		lblNote = new JLabel("备注：");
		textId = new JTextField();
		textName = new JTextField();
		textHead = new JTextField();
		textTel = new JTextField();
		textAddr = new JTextField();
		textNote = new JTextField();
		btnSave = new JButton("保存");
		btnExit = new JButton("退出");
		
		lblId.setBounds(37, 10, 72, 23);
		getContentPane().add(lblId);
		
		lblName.setBounds(37, 50, 72, 23);
		getContentPane().add(lblName);
		
		lblHead.setBounds(47, 90, 58, 23);
		getContentPane().add(lblHead);
		
		lblTel.setBounds(37, 130, 72, 23);
		getContentPane().add(lblTel);
		
		lblAddr.setBounds(37, 170, 72, 23);
		getContentPane().add(lblAddr);
		
		lblNote.setBounds(60, 210, 49, 23);
		getContentPane().add(lblNote);
		
	
		textId.setBounds(119, 11, 213, 21);
		getContentPane().add(textId);
		textId.setColumns(10);
		

		textName.setColumns(10);
		textName.setBounds(119, 51, 213, 21);
		getContentPane().add(textName);
		
		textHead.setColumns(10);
		textHead.setBounds(119, 91, 213, 21);
		getContentPane().add(textHead);
		
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
		init();
	}
	private void init() {
		// TODO Auto-generated method stub
		this.setTitle("增加仓库");
		this.setSize(415, 345);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(getOwner());
		this.setResizable(false);
		getContentPane().setLayout(null);
	
		
		
		
		AddWarehouseService ads = new AddWarehouseService(this,wd);
		btnSave.setActionCommand("Save");
		btnExit.setActionCommand("Exit");
		
		btnSave.addActionListener(ads);
		btnExit.addActionListener(ads);
		
		this.setVisible(true);
	}

}
