package cn.com.views.huang;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import cn.com.listener.huang.MainFranme_ActionListener;





public class MainFrame extends JFrame {
    private JPanel jplMain;
    private JPanel jplMain1;
    private JPanel jplMain2;
    private JPanel jplMain3;
    private JLabel lbltitle;
    private JLabel lblUserName;
    public JPanel getJplMain() {
		return jplMain;
	}
	public void setJplMain(JPanel jplMain) {
		this.jplMain = jplMain;
	}
	public JPanel getJplMain1() {
		return jplMain1;
	}
	public void setJplMain1(JPanel jplMain1) {
		this.jplMain1 = jplMain1;
	}
	public JPanel getJplMain2() {
		return jplMain2;
	}
	public void setJplMain2(JPanel jplMain2) {
		this.jplMain2 = jplMain2;
	}
	public JPanel getJplMain3() {
		return jplMain3;
	}
	public void setJplMain3(JPanel jplMain3) {
		this.jplMain3 = jplMain3;
	}
	public JLabel getLbltitle() {
		return lbltitle;
	}
	public void setLbltitle(JLabel lbltitle) {
		this.lbltitle = lbltitle;
	}
	public JLabel getLblUserName() {
		return lblUserName;
	}
	public void setLblUserName(JLabel lblUserName) {
		this.lblUserName = lblUserName;
	}
	public JLabel getLblPwdUerPwd() {
		return lblPwdUerPwd;
	}
	public void setLblPwdUerPwd(JLabel lblPwdUerPwd) {
		this.lblPwdUerPwd = lblPwdUerPwd;
	}
	public JTextField getTxtUserName() {
		return txtUserName;
	}
	public void setTxtUserName(JTextField txtUserName) {
		this.txtUserName = txtUserName;
	}
	public JPasswordField getTxtPwd() {
		return txtPwd;
	}
	public void setTxtPwd(JPasswordField txtPwd) {
		this.txtPwd = txtPwd;
	}
	public JButton getBtnLogin() {
		return btnLogin;
	}
	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}
	public JButton getBtnReset() {
		return btnReset;
	}
	public void setBtnReset(JButton btnReset) {
		this.btnReset = btnReset;
	}
	private JLabel lblPwdUerPwd;
    private JTextField txtUserName;
    private JPasswordField txtPwd;
    private JButton btnLogin;
    private JButton btnReset;
    public MainFrame(){
    	jplMain=new JPanel(new BorderLayout());
    	txtUserName=new JTextField();
    	txtPwd=new JPasswordField();
    	jplMain1=new JPanel();
    	jplMain2=new JPanel(null);
    	jplMain3=new JPanel();
    	lbltitle=new JLabel("用户登录");
    	lblUserName=new JLabel("用户账号");
    	lblPwdUerPwd=new JLabel("用户密码");
    	btnLogin=new JButton("登录");
    	btnReset=new JButton("重置");
    	init();
    }
	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(300,250);
		jplMain1.add(lbltitle);
		jplMain2.add(lblUserName);
		jplMain2.add(lblPwdUerPwd);
		jplMain2.add(txtUserName);
		jplMain2.add(txtPwd);
		jplMain3.add(btnLogin);
		jplMain3.add(btnReset);
		btnLogin.addActionListener(new MainFranme_ActionListener(this));
		btnReset.addActionListener(new MainFranme_ActionListener(this));
//		btnLogin.setBounds(40,20 ,80 ,20 );
		txtUserName.setBounds(80, 35, 150, 30);
		txtPwd.setBounds(80, 85, 150, 30);
		lblPwdUerPwd.setBounds(20, 80, 80, 40);
		lblUserName.setBounds(20,30 ,80 ,40 );
		jplMain.add(jplMain1, BorderLayout.NORTH);
		jplMain.add(jplMain2, BorderLayout.CENTER);
		jplMain.add(jplMain3, BorderLayout.SOUTH);
		
		this.add(jplMain);
		this.setVisible(true);
	}

}
