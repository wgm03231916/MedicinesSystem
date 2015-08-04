package cn.com.window.storagement;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.com.beans.liu.WarehouseBeans;
import cn.com.beans.view.liu.TransferView;
import cn.com.service.storage.TransferServiceImpl;
import cn.com.service.storage.TransferServiceInf;
import cn.com.windowlistener.storage.AppendGoods_tab_listener;


public class AppendGoods extends JDialog {
	private JPanel pnlMain;
	private JPanel pnlMainR;
	private JPanel pnlMainL;
	private JLabel lblInfo2;
	private JLabel lblInfo4;
	private JLabel lblInfo5;
	private JTextField txtAddGoods;
	private JButton btnAddGoods;
	private JLabel lblListGoods;
	private JLabel lblBillGoods;
	private JTable tabView;
	private DefaultTableModel dtmView;
	private JScrollPane snpView;
	private JTable tabView2;
	private JScrollPane snpView2;
	private WarehouseBeans warehouseb;
	private TransferView transferV;
	private List<TransferView> list;
	private JButton btn_change;

	private JButton btn_del;
	private JButton btn_sure;
	private JButton btn_cancle;
	private JFrameTransfer jFTransfer;

	// private JFrameTransfer jFtrans;
	// private JPanel pnlMainN;
	// private JPanel pnlMainS;
	public AppendGoods(JFrameTransfer jFTransfer) {
		// TODO Auto-generated constructor stub
		// ��ʼ������
		this();
		this.jFTransfer = jFTransfer;
		// ���ô�����������
		this.warehouseb = (WarehouseBeans)jFTransfer.getDcm_from().getModel().getSelectedItem();
		// ��ʼ��������ʾ
		setTabData();
		setTabData2();
		init();
	}

	public AppendGoods() {

		pnlMain = new JPanel(new GridLayout(1, 2));
		pnlMainR = new JPanel(null);
		pnlMainL = new JPanel(null);
		txtAddGoods = new JTextField();
		snpView = new JScrollPane();
		snpView2 = new JScrollPane();
		btnAddGoods = new JButton("������ѡ��Ʒ");
		lblInfo2 = new JLabel("��������Ʒ��Ż����Ʋ�ѯ,��ѯ������ӵ��ұ���ѡ��Ʒ");
		lblInfo4 = new JLabel("������µ���Ʒ��Ŀ������Ʒ�����б��У����");
		lblInfo5 = new JLabel("������Ʒ��Ż����Ʋ�ѯ��Ʒ��");
		lblListGoods = new JLabel("��Ʒ�б�");
		lblBillGoods = new JLabel("��Ʒ�嵥");
		tabView = new JTable() {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tabView.addMouseListener(new AppendGoods_tab_listener(this));
		tabView2 = new JTable() {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tabView2.addMouseListener(new AppendGoods_tab_listener(this));
		// pnlMainN=new JPanel(null);
		// pnlMainS=new JPanel(null);
		// setTabData();
		// setTabData2();
		// init();

	}

	

	private void setTabData2() {
		// TODO Auto-generated method stub
		Vector<String> title = new Vector<String>();
		title.add("��Ʒ���");
		title.add("��Ʒ����");
		title.add("��λ");
		title.add("��Ʒ���");
		title.add("��������");
		title.add("����");
		Vector row = new Vector();
		// row.add(transferV.getGoodsb().getGoods_name());
		// row.add(transferV.getGoodsb().getGoods_unit());
		// row.add(transferV.getGoodsb().getGoods_spft());
		// row.add(transferV.getMovesb().getMove_number());
		// row.add(transferV.getGoodsb().getGoods_apvlnum());
		// row.add(transferV.getGoodsb().getGoods_manufacture());
		dtmView = new DefaultTableModel(row, title);
		this.tabView2.setModel(this.dtmView);
	}

	private void setTabData() {
		// TODO Auto-generated method stub
		Vector<String> title = new Vector<String>();
		title.add("��Ʒ���");
		title.add("��Ʒ����");
		title.add("��λ");
		title.add("��Ʒ���");
		title.add("�����");
		title.add("��������");

		Vector data = new Vector();
		// transCom = new TransferFrame_combox_Service();
		// warehouseb = tfComItem.getWarehousb();
		TransferView tView = new TransferView();
		tView.setWarehouseb(warehouseb);
		TransferServiceInf tService = new TransferServiceImpl();
		list = tService.getAccountServiceInf(tView);
		Vector row = null;
		for (TransferView tv : list) {
			row = new Vector();
			row.add(tv.getGoodsb().getGoods_id());
			row.add(tv.getGoodsb().getGoods_name());
			row.add(tv.getGoodsb().getGoods_unit());
			row.add(tv.getGoodsb().getGoods_spft());
			row.add(tv.getHousecapb().getGoods_num());
			row.add(tv.getGoodsb().getGoods_manufacture());
			data.add(row);
		}
		dtmView = new DefaultTableModel(data, title);
		this.tabView.setModel(this.dtmView);
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("������Ʒ����������");
		this.setSize(870, 540);
		pnlMainR.setBorder(BorderFactory.createTitledBorder("��ѡ��Ʒ"));
		// pnlMainN.setBounds(10, 20, 410, 100);
		pnlMainL.setBorder(BorderFactory.createTitledBorder("��ѯ��Ʒ�б�"));
		// pnlMainL.add(pnlMainN,BorderLayout.NORTH);
		// pnlMainL.add(pnlMainS,BorderLayout.CENTER);
		pnlMain.add(pnlMainL);
		pnlMain.add(pnlMainR);
		pnlMainL.add(lblInfo2);
		pnlMainL.add(lblInfo4);
		pnlMainL.add(lblInfo5);
		pnlMainL.add(txtAddGoods);
		pnlMainL.add(btnAddGoods);
		pnlMainL.add(lblBillGoods);
		pnlMainL.add(lblListGoods);
		pnlMainL.add(snpView);
		pnlMainR.add(snpView2);
		snpView2.setViewportView(tabView2);
		snpView2.setBounds(10, 20, 410, 390);

		btn_change = new JButton("\u4FEE\u6539");
		btn_change.setBounds(10, 451, 93, 23);
		pnlMainR.add(btn_change);

		btn_del = new JButton("\u5220\u9664");
		btn_del.setBounds(113, 451, 93, 23);
		pnlMainR.add(btn_del);

		btn_sure = new JButton("\u786E\u5B9A");
		btn_sure.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int col = tabView2.getSelectedRow();
				if(col >= 0 ) {
					Vector<String> title = new Vector<String>();
					title.add("��Ʒ���");
					title.add("��Ʒ����");
					title.add("��λ");
					title.add("��Ʒ���");
					title.add("��������");
					title.add("����");
//					System.out.println(tabView2.getValueAt(col, 0));
					Vector data=new Vector();
					Vector row = new Vector();
					row.add(tabView2.getValueAt(col, 0));
					row.add(tabView2.getValueAt(col, 1));
					row.add(tabView2.getValueAt(col, 2));
					row.add(tabView2.getValueAt(col, 3));
					row.add(tabView2.getValueAt(col, 4));
					row.add(tabView2.getValueAt(col, 5));
					data.add(row);
					DefaultTableModel dtmView=new DefaultTableModel(data,title);
					jFTransfer.getTab_goods().setModel(dtmView); 
					AppendGoods.this.dispose();
				}else {
					new JOptionPane().showMessageDialog(null, "��ѡ����Ʒ", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
				
		});
		btn_sure.setBounds(224, 451, 93, 23);
		pnlMainR.add(btn_sure);

		btn_cancle = new JButton("\u53D6\u6D88");
		
		btn_cancle.setBounds(327, 451, 93, 23);
		pnlMainR.add(btn_cancle);
		snpView.setViewportView(tabView);
		snpView.setBounds(10, 115, 410, 370);
		lblInfo2.setBounds(60, 20, 360, 20);
		lblInfo4.setBounds(60, 45, 300, 20);
		lblInfo5.setBounds(10, 70, 190, 20);
		txtAddGoods.setBounds(200, 70, 100, 20);
		btnAddGoods.setBounds(305, 70, 115, 20);
		btnAddGoods.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0,
				Color.gray));
		lblBillGoods.setBounds(10, 95, 55, 20);
		lblBillGoods.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1,
				Color.blue));
		lblListGoods.setBounds(67, 95, 55, 20);
		lblListGoods.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1,
				Color.blue));
		getContentPane().add(pnlMain);
		this.setModal(true);

	}

	public JTable getTabView() {
		return tabView;
	}

	public JTable getTabView2() {
		return tabView2;
	}

	public WarehouseBeans getWarehouseb() {
		return warehouseb;
	}


}
