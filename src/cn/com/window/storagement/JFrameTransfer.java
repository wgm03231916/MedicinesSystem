package cn.com.window.storagement;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.table.DefaultTableModel;

import cn.com.beans.liu.EmployeeBeans;
import cn.com.beans.liu.WarehouseBeans;
import cn.com.service.storage.TransferServiceImpl;
import cn.com.service.storage.TransferServiceInf;
import cn.com.util.DateChooser;
import cn.com.windowlistener.storage.TransferFrame_btn_mouseListener;
import cn.com.windowlistener.storage.Transfer_tab_listener;



public class JFrameTransfer extends JFrame {

	private JPanel contentPane;
	private JPanel pnl_bill;
	private JPanel pnl_situation;
	private JPanel pnl_billtop;
	private JPanel pnl_billmiddle;
	private JPanel pnl_billbuttom;
	private JLabel lbl_billNo;
	private JTextField txt_billNo;
	private JLabel lbl_go;
	private JLabel lbl_date;
	private JButton btn_del;
	private JButton btn_change;
	private JButton btn_add;
	private JTable table;
	private JTable tab_goods;
	private JTextField txt_remark;
	private JPanel pnl_top1;
	private JTable tab_list;
	private JTable tab_goodsmag;
	private DefaultComboBoxModel comb;
	private DefaultTableModel dtmView;
	private DefaultComboBoxModel combPerson;
	private JTextField txtDate;
	private JComboBox dcm_from;
	private JComboBox dcm_go;
	private WarehouseBeans warehouseb;
	private JTextField txt_begin;
	private JTextField txt_end;
	private JButton btn_sch;
	private JScrollPane sco_msg;
	private JScrollPane sco_list;
	private DefaultTableModel dtmView1;
	private DefaultTableModel dtmView2;
	private JTextField txt_moveId;
	private JButton btn_exit2;
	private JButton btn_sure;
	private JComboBox dcm_person;
	
	public JTextField getTxt_billNo() {
		return txt_billNo;
	}
	public JTable getTab_list() {
		return tab_list;
	}
	public JTable geTtab_goodsmag() {
		return tab_goodsmag;
	}

	public JTextField getTxt_begin() {
		return txt_begin;
	}

	public JTextField getTxt_end() {
		return txt_end;
	}

	public void setDcm_from(JComboBox dcmFrom) {
		dcm_from = dcmFrom;
	}
	
	public JTable getTab_goods() {
		return tab_goods;
	}
	public WarehouseBeans getWarehouseb() {
		return warehouseb;
	}

	public JComboBox getDcm_from() {
		return dcm_from;
	}

	public JButton getBtn_del() {
		return btn_del;
	}


	public JButton getBtn_change() {
		return btn_change;
	}

	public JButton getBtn_add() {
		return btn_add;
	}

	public JButton getBtn_sch() {
		return btn_sch;
	}
	
	
	public JTextField getTxt_moveId() {
		return txt_moveId;
	}
	public void setTxt_moveId(JTextField txtMoveId) {
		txt_moveId = txtMoveId;
	}
	
	public JButton getBtn_exit2() {
		return btn_exit2;
	}
	
	public JTextField getTxtDate() {
		return txtDate;
	}
	public JButton getBtn_sure() {
		return btn_sure;
	}
	
	public JComboBox getDcm_person() {
		return dcm_person;
	}
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JFrameTransfer frame = new JFrameTransfer();
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
	public JFrameTransfer() {
		super("仓库调拨");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 668, 430);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(3, 3, 3, 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 3, 642, 379);
		contentPane.add(tabbedPane);
		
		pnl_bill = new JPanel();
		pnl_bill.setBorder(new EmptyBorder(2, 2, 2, 2));
		tabbedPane.addTab("库存调拨单", pnl_bill);
		pnl_bill.setLayout(null);
		
		pnl_billtop = new JPanel();
		pnl_billtop.setBounds(12, 0, 615, 63);
		pnl_bill.add(pnl_billtop);
		pnl_billtop.setLayout(null);
		
		lbl_billNo = new JLabel("\u5355\u53F7\uFF1A");
		lbl_billNo.setForeground(Color.RED);
		lbl_billNo.setBounds(375, 6, 55, 17);
		pnl_billtop.add(lbl_billNo);
		
		txt_billNo = new JTextField();
		txtBillNoinit();
		txt_billNo.setEditable(false);
		txt_billNo.setForeground(Color.RED);
		txt_billNo.setBounds(428, 3, 116, 23);
		pnl_billtop.add(txt_billNo);
		txt_billNo.setColumns(10);
		
		JLabel lbl_from = new JLabel("\u8C03\u51FA\u4ED3\u5E93");
		lbl_from.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lbl_from.setBounds(12, 37, 58, 17);
		pnl_billtop.add(lbl_from);
		
		lbl_go = new JLabel("\u8C03\u5165\u4ED3\u5E93");
		lbl_go.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lbl_go.setBounds(192, 37, 58, 17);
		pnl_billtop.add(lbl_go);
		
		lbl_date = new JLabel("\u8C03\u62E8\u65E5\u671F");
		lbl_date.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lbl_date.setBounds(375, 38, 58, 17);
		pnl_billtop.add(lbl_date);
		
		dcm_from = new JComboBox();
		dcm_from.setModel(comboxinit());
		dcm_from.setBounds(77, 36, 96, 21);
		pnl_billtop.add(dcm_from);
		
		dcm_go = new JComboBox();
		dcm_go.setModel(comboxinit());
		dcm_go.setBounds(260, 36, 96, 21);
		pnl_billtop.add(dcm_go);
		
		txtDate = new JTextField();
		DateChooser date = DateChooser.getInstance("yyyy-MM-dd");
		date.register(txtDate);
		txtDate.setBounds(438, 36, 106, 21);
		pnl_billtop.add(txtDate);
		txtDate.setColumns(10);
		
		pnl_billmiddle = new JPanel(new FlowLayout(0));
		pnl_billmiddle.setBounds(12, 68, 611, 44);
		pnl_bill.add(pnl_billmiddle);
		
		btn_add = new JButton("\u6DFB\u52A0\u5546\u54C1");
		btn_add.addMouseListener(new TransferFrame_btn_mouseListener(this));
		pnl_billmiddle.add(btn_add);
		
		btn_change = new JButton("\u4FEE\u6539\u5546\u54C1");
		pnl_billmiddle.add(btn_change);
		
		btn_del = new JButton("\u5220\u9664\u5546\u54C1");
		pnl_billmiddle.add(btn_del);
		
		pnl_billbuttom = new JPanel();
		pnl_billbuttom.setBounds(12, 126, 611, 234);
		pnl_bill.add(pnl_billbuttom);
		pnl_billbuttom.setLayout(null);
		
		JScrollPane scl_table = new JScrollPane(tab_goods);
		scl_table.setBounds(0, 0, 611, 158);
		pnl_billbuttom.add(scl_table);
		
		tab_goods = new JTable();
		tableModelinit();
		tab_goods.setBounds(604, 0, -601, 158);
		scl_table.setViewportView(tab_goods);
		
		JLabel lbl_person = new JLabel("\u7ECF\u529E\u4EBA");
		lbl_person.setFont(new Font("宋体", Font.PLAIN, 14));
		lbl_person.setBounds(10, 171, 54, 15);
		pnl_billbuttom.add(lbl_person);
		
		dcm_person = new JComboBox();
		dcm_person.setModel(comPersoninit());
		dcm_person.setBounds(55, 168, 69, 21);
		pnl_billbuttom.add(dcm_person);
		
		JLabel lbl_remark = new JLabel("\u5907\u6CE8");
		lbl_remark.setFont(new Font("宋体", Font.PLAIN, 14));
		lbl_remark.setBounds(170, 171, 28, 15);
		pnl_billbuttom.add(lbl_remark);
		
		txt_remark = new JTextField();
		txt_remark.setBounds(209, 168, 373, 21);
		pnl_billbuttom.add(txt_remark);
		txt_remark.setColumns(10);
		
		btn_sure = new JButton("\u786E\u5B9A");
		btn_sure.addMouseListener(new TransferFrame_btn_mouseListener(this));
		btn_sure.setBounds(264, 193, 93, 23);
		pnl_billbuttom.add(btn_sure);
		
		JButton btn_exit = new JButton("\u9000\u51FA");
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameTransfer.this.dispose();
			}
		});
		btn_exit.setBounds(383, 193, 93, 23);
		pnl_billbuttom.add(btn_exit);
		
		table = new JTable();
		table.setBounds(12, 128, 599, 155);
		pnl_bill.add(table);
		
		pnl_situation = new JPanel();
		pnl_situation.setBorder(new EmptyBorder(3, 3, 3, 3));
		tabbedPane.addTab("库存调拨情况", pnl_situation);
		pnl_situation.setLayout(null);
		
		pnl_top1 = new JPanel();
		pnl_top1.setBounds(0, 0, 623, 43);
		pnl_situation.add(pnl_top1);
		pnl_top1.setLayout(null);
		
		JLabel lbl_time = new JLabel("\u8C03\u62E8\u65F6\u95F4");
		lbl_time.setBounds(113, 18, 54, 15);
		pnl_top1.add(lbl_time);
		
		JLabel lbl_to = new JLabel("\u81F3");
		lbl_to.setBounds(253, 18, 32, 15);
		pnl_top1.add(lbl_to);
		
		btn_sch = new JButton("\u67E5\u8BE2");
		btn_sch.addMouseListener(new TransferFrame_btn_mouseListener(this));
		btn_sch.setBounds(390, 14, 93, 23);
		pnl_top1.add(btn_sch);
		
		btn_exit2 = new JButton("\u9000\u51FA");
		btn_exit2.addMouseListener(new TransferFrame_btn_mouseListener(this));
		btn_exit2.setBounds(507, 14, 93, 23);
		pnl_top1.add(btn_exit2);
		
		txt_begin = new JTextField();
		DateChooser begin = DateChooser.getInstance("yyyy-MM-dd");
		begin.register(txt_begin);
		txt_begin.setBounds(177, 15, 66, 21);
		pnl_top1.add(txt_begin);
		txt_begin.setColumns(10);
		
		txt_end = new JTextField();
		DateChooser end = DateChooser.getInstance("yyyy-MM-dd");
		end.register(txt_end);
		txt_end.setBounds(284, 15, 74, 21);
		pnl_top1.add(txt_end);
		txt_end.setColumns(10);
		
		JPanel pnl_middle1 = new JPanel();
		pnl_middle1.setBounds(0, 57, 623, 277);
		pnl_situation.add(pnl_middle1);
		pnl_middle1.setLayout(null);
		
		JLabel lbl_title = new JLabel("\u4ED3\u5E93\u8C03\u62E8\u5217\u8868");
		lbl_title.setBounds(0, 0, 82, 17);
		pnl_middle1.add(lbl_title);
		
		
		
		sco_list = new JScrollPane();
		sco_list.setBounds(0, 27, 611, 135);
		pnl_middle1.add(sco_list);
		
		sco_msg = new JScrollPane();
		sco_msg.setBounds(0, 193, 611, 84);
		pnl_middle1.add(sco_msg);
		
		tab_goodsmag = new JTable();
		initTabmsg();
		tab_goodsmag.setBounds(0, 193, 611, 84);
		sco_msg.setViewportView(tab_goodsmag);
		
		tab_list = new JTable() {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tab_list.addMouseListener(new Transfer_tab_listener(this));
		initTableList();
		tab_list.setBounds(0, 27, 611, 135);
		sco_list.setViewportView(tab_list);
		
		
		JLabel lbl_goodsmsg = new JLabel("\u5355\u636E\u8BE6\u7EC6\u4FE1\u606F");
		lbl_goodsmsg.setBounds(10, 174, 105, 15);
		pnl_middle1.add(lbl_goodsmsg);
		
		txt_moveId = new JTextField();
		txt_moveId.setBounds(98, 171, 154, 21);
		pnl_middle1.add(txt_moveId);
		txt_moveId.setColumns(10);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public JTextField getTxt_remark() {
		return txt_remark;
	}
	private void initTabmsg() {
		// TODO Auto-generated method stub
		Vector<String> title = new Vector<String>();
		title.add("商品编号");
		title.add("商品名称");
		title.add("数量");
		title.add("单位");
		title.add("规格");
		title.add("生产厂商");
		Vector data=new Vector();
		dtmView2=new DefaultTableModel(data,title);
		this.tab_goodsmag.setModel(this.dtmView2);
	}
	
	public JComboBox getDcm_go() {
		return dcm_go;
	}
	private void initTableList() {
		// TODO Auto-generated method stub
		Vector<String> title = new Vector<String>();
		title.add("调拨单号");
		title.add("调出仓库");
		title.add("调入仓库");
		title.add("调拨日期");
		title.add("经办人");
		title.add("备注");
		Vector data=new Vector();
		dtmView1=new DefaultTableModel(data,title);
		this.tab_list.setModel(this.dtmView1);
	}
	public void txtBillNoinit() {
		// TODO Auto-generated method stub
		String moveId = "DB";
		Date now = new Date();
		SimpleDateFormat formatNow= new SimpleDateFormat("yyyyMMdd");
		moveId = moveId+formatNow.format(now)+"0001";
		TransferServiceInf transinf = new TransferServiceImpl();
		String move_id=transinf.ismoveId(moveId);
		txt_billNo.setText(move_id);		
		
	}

	private ComboBoxModel comPersoninit() {
		// TODO Auto-generated method stub
		combPerson = new DefaultComboBoxModel();
		TransferServiceInf transinf = new TransferServiceImpl();
		List<EmployeeBeans> plist = transinf.getAllEmp();
		for (EmployeeBeans  emp : plist) {
			combPerson.addElement(emp.getEmployee_name());
		}
		return combPerson;
	}

	public void tableModelinit() {
		// TODO Auto-generated method stub
		Vector<String> title = new Vector<String>();
		title.add("商品编号");
		title.add("商品名称");
		title.add("单位");
		title.add("产品规格");
		title.add("生产厂商");
		title.add("数量");
		Vector data=new Vector();
		dtmView=new DefaultTableModel(data,title);
		this.tab_goods.setModel(this.dtmView);
		
	}

	private DefaultComboBoxModel comboxinit() {
		// TODO Auto-generated method stub
		comb = new DefaultComboBoxModel();
		TransferServiceInf transinf = new TransferServiceImpl();
		List<WarehouseBeans> list = transinf.getAllwarehouseServiceInf();
		for (WarehouseBeans  wareh : list) {
			 comb.addElement(wareh);
		}
		return comb;
	}
}
