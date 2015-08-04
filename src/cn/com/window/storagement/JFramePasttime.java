package cn.com.window.storagement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JFramePasttime extends JFrame {

	private JPanel contentPane;
	private JTextField txt_day;
	private JTextField txt_goods;
	private JTable tab_pastgoods;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JFramePasttime frame = new JFramePasttime();
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public JFramePasttime() {
		super("药品过期查询");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 669, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_warning = new JButton("\u63D0\u9192");
		btn_warning.setBounds(0, 0, 93, 23);
		contentPane.add(btn_warning);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.setBounds(103, 0, 93, 23);
		contentPane.add(button_1);
		
		JLabel lbl_no1 = new JLabel("\u67E5\u8BE2\u8FD8\u6709");
		lbl_no1.setBounds(0, 29, 54, 15);
		contentPane.add(lbl_no1);
		
		txt_day = new JTextField();
		txt_day.setBounds(54, 26, 66, 21);
		contentPane.add(txt_day);
		txt_day.setColumns(10);
		
		JLabel lbl_no2 = new JLabel("\u5929\u5230\u671F");
		lbl_no2.setBounds(125, 29, 54, 15);
		contentPane.add(lbl_no2);
		
		JLabel lbl_no3 = new JLabel("\u4ED3\u5E93");
		lbl_no3.setBounds(220, 29, 35, 15);
		contentPane.add(lbl_no3);
		
		JComboBox dcm_house = new JComboBox();
		dcm_house.setBounds(267, 26, 66, 21);
		contentPane.add(dcm_house);
		
		JLabel lbl_no4 = new JLabel("\u5546\u54C1\u540D\u79F0/\u7F16\u53F7");
		lbl_no4.setBounds(366, 29, 86, 15);
		contentPane.add(lbl_no4);
		
		txt_goods = new JTextField();
		txt_goods.setBounds(454, 26, 66, 21);
		contentPane.add(txt_goods);
		txt_goods.setColumns(10);
		
		JButton btn_search = new JButton("\u67E5\u8BE2");
		btn_search.setBounds(548, 25, 93, 23);
		contentPane.add(btn_search);
		
		tab_pastgoods = new JTable();
		tab_pastgoods.setBounds(0, 68, 653, 419);
		contentPane.add(tab_pastgoods);
		this.setVisible(true);
	}

}
