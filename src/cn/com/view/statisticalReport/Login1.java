package cn.com.view.statisticalReport;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import cn.com.util.Globel;

public class Login1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login1 dialog = new Login1();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login1() {
		setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
		setSize(new Dimension(334, 266));
		Globel.setCenterByWindow(this);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {  
			  UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");  
			 }catch (Exception ex) {  
			      ex.printStackTrace();  
			 }
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		contentPanel.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("\u533B\u836F\u9500\u552E\u7BA1\u7406\u7CFB\u7EDF");
		label.setBackground(new Color(176, 224, 230));
		label.setFont(new Font("Arial Unicode MS", Font.PLAIN, 17));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(176, 224, 230));
		contentPanel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label_1 = new JLabel("\u7BA1\u7406\u5458\u540D\u79F0\uFF1A");
		panel_1.add(label_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(15);
		
		JLabel label_3 = new JLabel("");
		panel_1.add(label_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(176, 224, 230));
		contentPanel.add(panel_2);
		
		JLabel label_2 = new JLabel("\u7BA1\u7406\u5458\u5BC6\u7801\uFF1A");
		panel_2.add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(15);
		panel_2.add(passwordField);
		
		JLabel label_4 = new JLabel("");
		panel_2.add(label_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(176, 224, 230));
		contentPanel.add(panel_3);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textField.getText().trim();
				String pwd = passwordField.getText(); 
//				System.out.println(user);
//				System.out.println(pwd);
				if(user.equals("admin") && pwd.equals("admin")){
					new MainView1();
					Login1.this.dispose();
				}else{
					JOptionPane.showMessageDialog(null, "管理员账号或密码有错！","提示",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button.setBackground(new Color(219, 112, 147));
		panel_3.add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_1.setBackground(new Color(219, 112, 147));
		panel_3.add(button_1);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

}
