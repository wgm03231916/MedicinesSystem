package cn.com.window.storagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

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

public class JFrameLoss extends JFrame {

	private JPanel contentPane;
	private JPanel pnl_bill;
	private JPanel pnl_billtop;
	private JLabel lbl_billNo;
	private JTextField txt_billNo;
	private JLabel lbl_go;
	private JLabel lbl_date;
	private JPanel pnl_billmiddle;
	private JButton btn_add;
	private JButton btn_change;
	private Component btn_del;
	private JPanel pnl_billbuttom;
	private JTable tab_goods;
	private JTextField txt_remark;
	private JTable table;
	private JPanel pnl_situation;
	private JPanel pnl_top1;
	private JTable tab_list;
	private Component tab_goodsmag;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JFrameLoss frame = new JFrameLoss();
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
	public JFrameLoss() {
		super("商品报损报溢");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 656, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 3, 628, 365);
		contentPane.add(tabbedPane);
		
		pnl_bill = new JPanel();
		pnl_bill.setBorder(new EmptyBorder(2, 2, 2, 2));
		tabbedPane.addTab("报损/报溢", pnl_bill);
		pnl_bill.setLayout(null);
		
		pnl_billtop = new JPanel();
		pnl_billtop.setBounds(12, 0, 611, 63);
		pnl_bill.add(pnl_billtop);
		pnl_billtop.setLayout(null);
		
		lbl_billNo = new JLabel("\u5355\u53F7\uFF1A");
		lbl_billNo.setForeground(Color.RED);
		lbl_billNo.setBounds(394, 0, 36, 17);
		pnl_billtop.add(lbl_billNo);
		
		txt_billNo = new JTextField();
		txt_billNo.setForeground(Color.RED);
		txt_billNo.setBounds(428, -3, 116, 23);
		pnl_billtop.add(txt_billNo);
		txt_billNo.setColumns(10);
		
		JLabel lbl_from = new JLabel("\u5355\u636E\u7C7B\u578B");
		lbl_from.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lbl_from.setBounds(12, 37, 58, 17);
		pnl_billtop.add(lbl_from);
		
		lbl_go = new JLabel("\u4ED3\u5E93\u540D\u79F0");
		lbl_go.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lbl_go.setBounds(192, 37, 58, 17);
		pnl_billtop.add(lbl_go);
		
		lbl_date = new JLabel("\u65E5\u671F");
		lbl_date.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lbl_date.setBounds(375, 38, 58, 17);
		pnl_billtop.add(lbl_date);
		
		JComboBox dcm_from = new JComboBox();
		dcm_from.setBounds(77, 36, 96, 21);
		pnl_billtop.add(dcm_from);
		
		JComboBox dcm_go = new JComboBox();
		dcm_go.setBounds(260, 36, 96, 21);
		pnl_billtop.add(dcm_go);
		
		JComboBox dcm_date = new JComboBox();
		dcm_date.setBounds(438, 36, 106, 21);
		pnl_billtop.add(dcm_date);
		
		JLabel lbl_maintitle = new JLabel("\u5546\u54C1\u62A5\u635F");
		lbl_maintitle.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lbl_maintitle.setBounds(214, 1, 83, 22);
		pnl_billtop.add(lbl_maintitle);
		
		pnl_billmiddle = new JPanel(new FlowLayout(0));
		pnl_billmiddle.setBounds(12, 68, 611, 35);
		pnl_bill.add(pnl_billmiddle);
		
		btn_add = new JButton("\u6DFB\u52A0\u5546\u54C1");
		pnl_billmiddle.add(btn_add);
		
		btn_change = new JButton("\u4FEE\u6539\u5546\u54C1");
		pnl_billmiddle.add(btn_change);
		
		btn_del = new JButton("\u5220\u9664\u5546\u54C1");
		pnl_billmiddle.add(btn_del);
		
		pnl_billbuttom = new JPanel();
		pnl_billbuttom.setBounds(12, 126, 611, 226);
		pnl_bill.add(pnl_billbuttom);
		pnl_billbuttom.setLayout(null);
		
		
		String[] titles = {"商品名称","单位","产品规格","产品批号","有效期至","生产厂商","数量"};
		Object[][] goodsInfo=null;
		tab_goods = new JTable();
		tab_goods.setBounds(604, 0, -601, 158);
		
		
		JScrollPane scl_table = new JScrollPane(tab_goods);
		scl_table.setBounds(0, -23, 611, 158);
		pnl_billbuttom.add(scl_table);
		
		JLabel lbl_person = new JLabel("\u7ECF\u529E\u4EBA");
		lbl_person.setFont(new Font("宋体", Font.PLAIN, 14));
		lbl_person.setBounds(10, 149, 54, 15);
		pnl_billbuttom.add(lbl_person);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(63, 146, 69, 21);
		pnl_billbuttom.add(comboBox);
		
		JLabel lbl_remark = new JLabel("\u5907\u6CE8");
		lbl_remark.setFont(new Font("宋体", Font.PLAIN, 14));
		lbl_remark.setBounds(175, 149, 28, 15);
		pnl_billbuttom.add(lbl_remark);
		
		txt_remark = new JTextField();
		txt_remark.setBounds(209, 146, 373, 21);
		pnl_billbuttom.add(txt_remark);
		txt_remark.setColumns(10);
		
		JButton btn_sure = new JButton("\u786E\u5B9A");
		btn_sure.setBounds(280, 165, 93, 21);
		pnl_billbuttom.add(btn_sure);
		
		JButton btn_exit = new JButton("\u9000\u51FA");
		btn_exit.setBounds(406, 168, 93, 18);
		pnl_billbuttom.add(btn_exit);
		
		table = new JTable();
		table.setBounds(12, 128, 599, 155);
		pnl_bill.add(table);
		
		pnl_situation = new JPanel();
		pnl_situation.setBorder(new EmptyBorder(3, 3, 3, 3));
		tabbedPane.addTab("报损/报溢查询", pnl_situation);
		pnl_situation.setLayout(null);
		
		pnl_top1 = new JPanel();
		pnl_top1.setBounds(0, 0, 623, 43);
		pnl_situation.add(pnl_top1);
		pnl_top1.setLayout(null);
		
		JButton btn_search = new JButton("\u9AD8\u7EA7\u67E5\u8BE2");
		btn_search.setBounds(0, 14, 87, 23);
		pnl_top1.add(btn_search);
		
		JLabel lbl_time = new JLabel("\u62A5\u6EA2\u65F6\u95F4");
		lbl_time.setBounds(113, 18, 54, 15);
		pnl_top1.add(lbl_time);
		
		JComboBox dcm_pass = new JComboBox();
		dcm_pass.setBounds(165, 15, 81, 21);
		pnl_top1.add(dcm_pass);
		
		JLabel lbl_to = new JLabel("\u81F3");
		lbl_to.setBounds(262, 18, 12, 15);
		pnl_top1.add(lbl_to);
		
		JComboBox dcm_now = new JComboBox();
		dcm_now.setBounds(286, 15, 81, 21);
		pnl_top1.add(dcm_now);
		
		JButton btn_sch = new JButton("\u67E5\u8BE2");
		btn_sch.setBounds(469, 14, 65, 23);
		pnl_top1.add(btn_sch);
		
		JButton btn_exit2 = new JButton("\u9000\u51FA");
		btn_exit2.setBounds(546, 14, 65, 23);
		pnl_top1.add(btn_exit2);
		
		JPanel pnl_middle1 = new JPanel();
		pnl_middle1.setBounds(0, 57, 623, 277);
		pnl_situation.add(pnl_middle1);
		pnl_middle1.setLayout(null);
		
		JLabel lbl_title = new JLabel("\u5E93\u5B58\u62A5\u6EA2\u5217\u8868");
		lbl_title.setBounds(0, 0, 82, 17);
		pnl_middle1.add(lbl_title);
		
		tab_list = new JTable();
		tab_list.setBounds(0, 27, 611, 135);
		pnl_middle1.add(tab_list);
		
		tab_goodsmag = new JTable();
		tab_goodsmag.setBounds(0, 193, 611, 84);
		pnl_middle1.add(tab_goodsmag);
		
		JLabel lbl_goodsmsg = new JLabel("\u5355\u636E\u8BE6\u7EC6\u4FE1\u606F");
		lbl_goodsmsg.setBounds(10, 174, 105, 15);
		pnl_middle1.add(lbl_goodsmsg);
		this.setVisible(true);
	}

}
