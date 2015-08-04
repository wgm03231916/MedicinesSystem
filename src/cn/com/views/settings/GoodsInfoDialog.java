package cn.com.views.settings;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import cn.com.beans.GoodsBean;
import cn.com.daos.settings.GoodsDAOImpl;
import cn.com.daos.settings.GoodsDAOInf;
import cn.com.service.settings.GoodsInfoService;

public class GoodsInfoDialog extends JDialog {
	private GoodsBean gb;
	private JLabel lblGoods;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDel;
	private JButton btnExit;
	private JTextField textGoods;
	private JTable table;
	private DefaultTableModel dtm;
	private GoodsDAOInf GoodsDAO;

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public GoodsInfoDialog(Frame f, String title, boolean model, GoodsBean gb) {
		super(f, title, model);
		getContentPane().setBackground(new Color(175, 238, 238));
		this.gb = gb;
		lblGoods = new JLabel("���������Ʒ��Ϣ���в�ѯ(��Ʒ��š�����)��");
		btnAdd = new JButton("����");
		btnAdd.setBackground(new Color(176, 224, 230));
		btnUpdate = new JButton("�޸�");
		btnUpdate.setBackground(new Color(176, 224, 230));
		btnDel = new JButton("ɾ��");
		btnDel.setBackground(new Color(176, 224, 230));
		btnExit = new JButton("�˳�");
		btnExit.setBackground(new Color(176, 224, 230));
		textGoods = new JTextField();
		table = new JTable();
		table.setBackground(new Color(176, 224, 230));
		GoodsDAO = new GoodsDAOImpl();
		init();
		// JCheckBox chckbxNewCheckBox = new JCheckBox("��ʾ������Ʒ");
		// chckbxNewCheckBox.setBounds(676, 65, 103, 23);
		// getContentPane().add(chckbxNewCheckBox);

	}

	private void init() {
		// TODO Auto-generated method stub
		
		this.setTitle("��Ʒ��Ϣ");
		this.setSize(845, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(getOwner());
		this.setResizable(false);
		getContentPane().setLayout(null);
		setTableData();

		lblGoods.setBounds(30, 74, 280, 20);
		getContentPane().add(lblGoods);
		textGoods.setBounds(320, 74, 156, 21);
		getContentPane().add(textGoods);
		textGoods.setColumns(10);
		
		textGoods.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
					test(e);
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		String s = this.textGoods.getText();

		

		btnAdd.setBounds(20, 23, 100, 34);
		getContentPane().add(btnAdd);
		btnUpdate.setBounds(150, 23, 100, 34);
		getContentPane().add(btnUpdate);
		btnDel.setBounds(280, 23, 100, 34);
		getContentPane().add(btnDel);
		btnExit.setBounds(410, 23, 100, 34);
		getContentPane().add(btnExit);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 94, 804, 357);
		getContentPane().add(scrollPane);

		scrollPane.setViewportView(table);

		// tableѡ��ģʽ
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// �ر��Զ�������ʽ
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		scrollPane.setBorder(BorderFactory.createTitledBorder("��Ʒ�б�"));
		
		GoodsInfoService gi = new GoodsInfoService(this);
		btnAdd.setActionCommand("Add");
		btnUpdate.setActionCommand("Update");
		btnDel.setActionCommand("Del");
		btnExit.setActionCommand("Exit");
		table.addMouseListener(gi);

		btnAdd.addActionListener(gi);
		btnUpdate.addActionListener(gi);
		btnDel.addActionListener(gi);
		btnExit.addActionListener(gi);

		this.setVisible(true);
		

	}

	public void setTableData() {
		// TODO Auto-generated method stub
		Vector<String> title = new Vector<String>();
		title.add("���");
		title.add("��Ʒ���");
		title.add("��Ʒ����");
		title.add("��������");
		title.add("��Ʒ����");
		title.add("��Ʒ��λ");
		title.add("��Ʒ���");
		title.add("��׼�ĺ�");
		title.add("Ԥ�����");
		title.add("Ԥ���ۼ�");
		title.add("��������");
		title.add("��ע");
		Vector data = new Vector();

		Vector row = null;
		dtm = new DefaultTableModel(data, title);
		List<GoodsBean> list = GoodsDAO.getAllGoodsInfo();
		int i = 1;
		for (GoodsBean gb : list) {
			row = new Vector();
			row.add(i);
			row.add(gb);
			row.add(gb.getGoods_Name());
			row.add(gb.getGoods_type());
			row.add(gb.getGoods_codes());
			row.add(gb.getGoods_unit());
			row.add(gb.getGoods_spft());
			row.add(gb.getGoods_Apvlnum());
			row.add(gb.getGoods_setting());
			row.add(gb.getGoods_price());
			row.add(gb.getGood_manufacture());
			row.add(gb.getGoods_note());

			data.add(row);
			i++;
		}

		table.setModel(dtm);
	}

	private void test(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		String s = this.textGoods.getText();
		if(s.length()==0){
			setTableData();
		}else{
			String msg2 = s + c;
			Vector<String> title = new Vector<String>();
			title.add("���");
			title.add("��Ʒ���");
			title.add("��Ʒ����");
			title.add("��������");
			title.add("��Ʒ����");
			title.add("��Ʒ��λ");
			title.add("��Ʒ���");
			title.add("��׼�ĺ�");
			title.add("Ԥ�����");
			title.add("Ԥ���ۼ�");
			title.add("��������");
			title.add("��ע");
			Vector data = new Vector();

			Vector row = null;
			dtm = new DefaultTableModel(data, title);
			List<GoodsBean> list = GoodsDAO.queryGoods(msg2);
			int i = 1;
			for (GoodsBean gb : list) {
				row = new Vector();
				row.add(i);
				row.add(gb);
				row.add(gb.getGoods_Name());
				row.add(gb.getGoods_type());
				row.add(gb.getGoods_codes());
				row.add(gb.getGoods_unit());
				row.add(gb.getGoods_spft());
				row.add(gb.getGoods_Apvlnum());
				row.add(gb.getGoods_setting());
				row.add(gb.getGoods_price());
				row.add(gb.getGood_manufacture());
				row.add(gb.getGoods_note());

				data.add(row);
				i++;
			
			}
			this.table.setModel(dtm);
		}
	}
	

}
