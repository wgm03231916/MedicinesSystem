package cn.com.window.storagement;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JFrameStorage extends JFrame {

	private JPanel contentPane;
	private JTextField txt_m2;
	private JTextField txt_m3;
	private JTable tab1;
	private JTable table;
	private JTextField textField;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JFrameStorage frame = new JFrameStorage();
//					frame.setResizable(false);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public JFrameStorage() {
		super("库存商品变动查询");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 666, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel pnl_storage = new JPanel();
		tabbedPane.addTab("库存变动情况", null, pnl_storage, null);
		pnl_storage.setLayout(null);
		
		JPanel pnl_topS = new JPanel();
		pnl_topS.setBounds(0, 10, 635, 35);
		pnl_storage.add(pnl_topS);
		pnl_topS.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton btn_top1 = new JButton("\u67E5\u627E");
		pnl_topS.add(btn_top1);
		
		JButton btn_top2 = new JButton("\u67E5\u770B\u660E\u7EC6");
		pnl_topS.add(btn_top2);
		
		JButton btn_top3 = new JButton("\u5E93\u5B58\u6279\u6B21");
		pnl_topS.add(btn_top3);
		
		JButton btn_4 = new JButton("\u8FDB\u9000\u8D27\u53C2\u8003");
		pnl_topS.add(btn_4);
		
		JButton btn_5 = new JButton("\u9000\u8D27");
		pnl_topS.add(btn_5);
		
		JPanel pnl_middleS = new JPanel();
		pnl_middleS.setBounds(0, 49, 635, 42);
		pnl_storage.add(pnl_middleS);
		pnl_middleS.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lbl_m1 = new JLabel("\u4ED3\u5E93");
		pnl_middleS.add(lbl_m1);
		
		JComboBox dcm_m1 = new JComboBox();
		pnl_middleS.add(dcm_m1);
		
		JLabel lbl_m2 = new JLabel("\u5546\u54C1\u7C7B\u522B");
		pnl_middleS.add(lbl_m2);
		
		txt_m2 = new JTextField();
		pnl_middleS.add(txt_m2);
		txt_m2.setColumns(10);
		
		JLabel lbl_m3 = new JLabel("\u8F93\u5165\u5546\u54C1\u76F8\u5173\u4FE1\u606F\u67E5\u8BE2");
		pnl_middleS.add(lbl_m3);
		
		txt_m3 = new JTextField();
		pnl_middleS.add(txt_m3);
		txt_m3.setColumns(10);
		
		JButton btn_m1 = new JButton("\u67E5\u8BE2");
		pnl_middleS.add(btn_m1);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 105, 635, 335);
		pnl_storage.add(tabbedPane_1);
		
		JPanel pnl_sum = new JPanel();
		tabbedPane_1.addTab("库存商品汇总表", null, pnl_sum, null);
		pnl_sum.setLayout(new BorderLayout(0, 0));
		
		JScrollPane spl_sumlist = new JScrollPane();
		pnl_sum.add(spl_sumlist, BorderLayout.CENTER);
		
		tab1 = new JTable();
		spl_sumlist.setViewportView(tab1);
		
		JPanel pnl_msg = new JPanel();
		tabbedPane_1.addTab("库存商品明细表", null, pnl_msg, null);
		pnl_msg.setLayout(new BorderLayout(0, 0));
		
		JScrollPane spl_msg = new JScrollPane();
		pnl_msg.add(spl_msg, BorderLayout.CENTER);
		
		table = new JTable();
		spl_msg.setViewportView(table);
		
		JPanel pnl_goods = new JPanel();
		tabbedPane.addTab("商品变动情况", null, pnl_goods, null);
		pnl_goods.setLayout(new BorderLayout(0, 0));
		
		JPanel pnl_topG = new JPanel();
		pnl_goods.add(pnl_topG, BorderLayout.NORTH);
		pnl_topG.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton btn_searchG = new JButton("\u67E5\u770B\u660E\u7EC6");
		pnl_topG.add(btn_searchG);
		
		JButton btn_exit1 = new JButton("\u9000\u51FA");
		pnl_topG.add(btn_exit1);
		
		JPanel pnl_buttom = new JPanel();
		pnl_goods.add(pnl_buttom, BorderLayout.CENTER);
		pnl_buttom.setLayout(new BorderLayout(0, 0));
		
		JPanel pnl_middle = new JPanel();
		pnl_buttom.add(pnl_middle, BorderLayout.NORTH);
		pnl_middle.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel label = new JLabel("\u7EDF\u8BA1\u65F6\u95F4");
		pnl_middle.add(label);
		
		JComboBox comboBox = new JComboBox();
		pnl_middle.add(comboBox);
		
		JLabel label_1 = new JLabel("\u81F3");
		pnl_middle.add(label_1);
		
		JComboBox comboBox_1 = new JComboBox();
		pnl_middle.add(comboBox_1);
		
		JLabel label_2 = new JLabel("\u5546\u54C1\u540D\u79F0\u6216\u7F16\u53F7");
		pnl_middle.add(label_2);
		
		textField = new JTextField();
		pnl_middle.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		pnl_middle.add(button);
		
		JPanel panel_1 = new JPanel();
		pnl_buttom.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		this.setResizable(false);
		this.setVisible(true);
	}
}
