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

import cn.com.beans.CustomerBean;
import cn.com.daos.settings.CustomerDAOImpl;
import cn.com.daos.settings.CustomerDAOInf;
import cn.com.service.settings.CustomerSetService;

public class CustomerSetDialog extends JDialog {
	private JLabel lblCustomer;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDel;
	private JButton btnExit;
	private JTextField textCustomer;
	private JTable table;
	private DefaultTableModel dtm;
	private CustomerDAOInf CusDAO;
	private CustomerBean cb;

	public JTextField gettextCustomer() {
		return textCustomer;
	}

	public void settextCustomer(JTextField textCustomer) {
		this.textCustomer = textCustomer;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public CustomerSetDialog(Frame f, String title, boolean model,CustomerBean cb) {
		super(f, title, model);
		getContentPane().setBackground(new Color(245, 222, 179));
		this.cb = cb;
		lblCustomer = new JLabel("������ؿͻ���Ϣ���в�ѯ(�ͻ���š�����)��");
		textCustomer = new JTextField();
		btnAdd = new JButton("����");
		btnAdd.setBackground(new Color(245, 222, 179));
		btnUpdate = new JButton("�޸�");
		btnUpdate.setBackground(new Color(245, 222, 179));
		btnDel = new JButton("ɾ��");
		btnDel.setBackground(new Color(245, 222, 179));
		btnExit = new JButton("�˳�");
		btnExit.setBackground(new Color(245, 222, 179));
		table = new JTable();
		table.setBackground(new Color(245, 222, 179));
		CusDAO = new CustomerDAOImpl();

		init();

	}

	private void init() {
		// TODO Auto-generated method stub
		this.setTitle("�ͻ�����");
		getContentPane().setLayout(null);
		this.setSize(829, 428);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(getOwner());
		this.setResizable(false);
		getContentPane().setLayout(null);
		setTableData();

		btnAdd.setBounds(20, 20, 93, 30);
		getContentPane().add(btnAdd);

		btnUpdate.setBounds(150, 20, 93, 30);
		getContentPane().add(btnUpdate);

		btnDel.setBounds(280, 20, 93, 30);
		getContentPane().add(btnDel);

		btnExit.setBounds(410, 20, 93, 30);
		getContentPane().add(btnExit);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 90, 786, 288);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		scrollPane.setBorder(BorderFactory.createTitledBorder("�ͻ��б�"));
		// tableѡ��ģʽ
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// �ر��Զ�������ʽ
		// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		lblCustomer.setBounds(30, 65, 300, 15);
		getContentPane().add(lblCustomer);

		textCustomer.setBounds(330, 63, 156, 20);
		getContentPane().add(textCustomer);
		textCustomer.setColumns(10);
		textCustomer.addKeyListener(new KeyListener() {
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
		CustomerSetService cs = new CustomerSetService(this);
		btnAdd.setActionCommand("Add");
		btnUpdate.setActionCommand("Update");
		btnDel.setActionCommand("Del");
		btnExit.setActionCommand("Exit");

		table.addMouseListener(cs);

		btnAdd.addActionListener(cs);
		btnUpdate.addActionListener(cs);
		btnDel.addActionListener(cs);
		btnExit.addActionListener(cs);

		this.setVisible(true);
	}

	public void setTableData() {
		// TODO Auto-generated method stub
		Vector<String> title = new Vector<String>();
		title.add("���");
		title.add("�ͻ����");
		title.add("�ͻ�����");
		title.add("��ϵ��");
		title.add("��ϵ�绰");
		title.add("�ͻ���ַ");
		title.add("��ע");
		Vector data = new Vector();

		Vector row = null;
		dtm = new DefaultTableModel(data, title);
		List<CustomerBean> list = CusDAO.getAllCustomerInfo();
		int i = 1;
		for (CustomerBean cb : list) {
			row = new Vector();
			row.add(i);
			row.add(cb);
			row.add(cb.getCustomer_name());
			row.add(cb.getCustomer_contact());
			row.add(cb.getCustomer_tel());
			row.add(cb.getCustomer_addr());
			row.add(cb.getCustomer_note());

			data.add(row);
			i++;
		}

		table.setModel(dtm);
	}

	private void test(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		String s = this.textCustomer.getText();
		String msg2 = s + c;
		if (s.length() == 0) {
			setTableData();
		} else {
			Vector<String> title = new Vector<String>();
			title.add("���");
			title.add("�ͻ����");
			title.add("�ͻ�����");
			title.add("��ϵ��");
			title.add("��ϵ�绰");
			title.add("�ͻ���ַ");
			title.add("��ע");
			Vector data = new Vector();

			Vector row = null;
			dtm = new DefaultTableModel(data, title);
			List<CustomerBean> list = CusDAO.queryCustomer(msg2);
			int i = 1;
			for (CustomerBean cb : list) {
				row = new Vector();
				row.add(i);
				row.add(cb);
				row.add(cb.getCustomer_name());
				row.add(cb.getCustomer_contact());
				row.add(cb.getCustomer_tel());
				row.add(cb.getCustomer_addr());
				row.add(cb.getCustomer_note());

				data.add(row);
				i++;
			}
			this.table.setModel(dtm);
		}
	}

}
