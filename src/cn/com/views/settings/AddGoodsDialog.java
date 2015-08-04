package cn.com.views.settings;

import java.awt.Dialog;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import cn.com.beans.GoodsBean;
import cn.com.service.settings.AddGoodsService;

public class AddGoodsDialog extends JDialog {
	private JLabel lblNo;
	private JLabel lblName;
	private JLabel lblType;
	private JLabel lblCodes;
	private JLabel lblUnit;
	private JLabel lblSpft;
	private JLabel lblApvlunm;
	private JLabel lblSetting;
	private JLabel lblPrice;
	private JLabel lblManufacture;
	private JLabel lblNote;
	private JTextField textNO;
	private JTextField textName;
	private JTextField textType;
	private JTextField textTel;
	private JTextField textCodes;
	private JComboBox cbxUnit;
	private JTextField textSpft;
	private JTextField textApvlunm;
	private JTextField textSetting;
	private JTextField textPrice;
	private JTextField textManufacture;
	private JTextField textNote;
	private JButton btnSave;
	private JButton btnExit;
	private GoodsInfoDialog gd;
	
	public AddGoodsDialog(){
		
	}
	public AddGoodsDialog(GoodsInfoDialog gd){
		this.gd = gd;
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

	public JTextField getTextType() {
		return textType;
	}

	public void setTextType(JTextField textType) {
		this.textType = textType;
	}

	public JTextField getTextTel() {
		return textTel;
	}

	public void setTextTel(JTextField textTel) {
		this.textTel = textTel;
	}

	public JTextField getTextCodes() {
		return textCodes;
	}

	public void setTextCodes(JTextField textCodes) {
		this.textCodes = textCodes;
	}

	public JComboBox getCbxUnit() {
		return cbxUnit;
	}

	public void setCbxUnit(JComboBox cbxUnit) {
		this.cbxUnit = cbxUnit;
	}

	public JTextField getTextSpft() {
		return textSpft;
	}

	public void setTextSpft(JTextField textSpft) {
		this.textSpft = textSpft;
	}

	public JTextField getTextApvlunm() {
		return textApvlunm;
	}

	public void setTextApvlunm(JTextField textApvlunm) {
		this.textApvlunm = textApvlunm;
	}

	public JTextField getTextSetting() {
		return textSetting;
	}

	public void setTextSetting(JTextField textSetting) {
		this.textSetting = textSetting;
	}

	public JTextField getTextPrice() {
		return textPrice;
	}

	public void setTextPrice(JTextField textPrice) {
		this.textPrice = textPrice;
	}

	public JTextField getTextManufacture() {
		return textManufacture;
	}

	public void setTextManufacture(JTextField textManufacture) {
		this.textManufacture = textManufacture;
	}

	public JTextField getTextNote() {
		return textNote;
	}

	public void setTextNote(JTextField textNote) {
		this.textNote = textNote;
	}

	
	public AddGoodsDialog(GoodsInfoDialog gd,String title,boolean model) {
		super(gd,title,model);
		lblNo = new JLabel("商品编号*：");
		lblName = new JLabel("商品名称*：");
		lblType = new JLabel("所属类别：");
		lblCodes = new JLabel("商品条码：");
		lblUnit = new JLabel("商品单位：");
		lblSpft = new JLabel("商品规格：");
		lblApvlunm = new JLabel("批准文号：");
		lblSetting = new JLabel("预设进价：");
		lblPrice = new JLabel("预设售价：");
		lblManufacture = new JLabel("生产厂商：");
		lblNote = new JLabel("备注：");
		textNO = new JTextField();
		textName = new JTextField();
		textType = new JTextField();
		textCodes = new JTextField();
		cbxUnit = new JComboBox();
		textSpft = new JTextField();
		textApvlunm = new JTextField();
		textSetting = new JTextField();
		textPrice = new JTextField();
		textManufacture = new JTextField();
		textNote = new JTextField();
		btnSave = new JButton("保存");
		btnExit = new JButton("退出");
		init();
	}

	
	private void init() {
		// TODO Auto-generated method stub
		this.setTitle("增加商品");
		this.setSize(625, 394);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(getOwner());
		this.setResizable(false);
		getContentPane().setLayout(null);
		
		lblNo.setBounds(50, 20, 72, 15);
		getContentPane().add(lblNo);
		textNO.setBounds(142, 20, 118, 21);
		getContentPane().add(textNO);
		textNO.setColumns(10);
		lblName.setBounds(333, 20, 72, 15);
		getContentPane().add(lblName);
		textName.setBounds(403, 20, 118, 21);
		getContentPane().add(textName);
		textName.setColumns(10);
		lblType.setBounds(50, 60, 72, 15);
		getContentPane().add(lblType);
		textType.setBounds(141, 60, 118, 21);
		getContentPane().add(textType);
		textType.setColumns(10);
		
		lblCodes.setBounds(333, 60, 66, 15);
		getContentPane().add(lblCodes);
		textCodes.setBounds(403, 60, 118, 21);
		getContentPane().add(textCodes);
		textCodes.setColumns(10);
		
		lblUnit.setBounds(50, 102, 72, 15);
		getContentPane().add(lblUnit);
		cbxUnit.setBounds(141, 102, 119, 21);
		getContentPane().add(cbxUnit);
		cbxUnit.addItem("盒");
		cbxUnit.addItem("瓶");
		cbxUnit.addItem("支");
		cbxUnit.addItem("包");

		lblApvlunm.setBounds(333, 102, 72, 15);
		getContentPane().add(lblApvlunm);
		textApvlunm.setBounds(403, 102, 118, 21);
		getContentPane().add(textApvlunm);
		textApvlunm.setColumns(10);
		
		lblSpft.setBounds(50, 140, 72, 15);
		getContentPane().add(lblSpft);
		textSpft.setBounds(141, 140, 118, 21);
		getContentPane().add(textSpft);
		textSpft.setColumns(10);
			
		lblSetting.setBounds(333, 140, 72, 15);
		getContentPane().add(lblSetting);
		textSetting.setBounds(403, 137, 118, 21);
		getContentPane().add(textSetting);
		textSetting.setColumns(10);
		
		lblPrice.setBounds(333, 180, 72, 15);
		getContentPane().add(lblPrice);
		textPrice.setBounds(403, 180, 118, 21);
		getContentPane().add(textPrice);
		textPrice.setColumns(10);
		
		lblManufacture.setBounds(50, 180, 72, 15);
		getContentPane().add(lblManufacture);
		textManufacture.setBounds(141, 180, 165, 21);
		getContentPane().add(textManufacture);
		textManufacture.setColumns(10);
		
		lblNote.setBounds(74, 220, 43, 15);
		getContentPane().add(lblNote);
		textNote.setBounds(142, 217, 379, 68);
		getContentPane().add(textNote);
		textNote.setColumns(10);
		
		btnSave.setBounds(182, 303, 93, 41);
		getContentPane().add(btnSave);
		btnExit.setBounds(367, 303, 93, 41);
		getContentPane().add(btnExit);
		
		AddGoodsService ads = new AddGoodsService(this,gd);
		btnSave.setActionCommand("Save");
		btnExit.setActionCommand("Exit");
		
		btnSave.addActionListener(ads);
		btnExit.addActionListener(ads);
		this.setVisible(true);
	}
}
