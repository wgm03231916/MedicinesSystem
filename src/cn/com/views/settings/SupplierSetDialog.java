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

import cn.com.beans.SupplierBean;
import cn.com.daos.settings.SupplierDAOImpl;
import cn.com.daos.settings.SupplierDAOInf;
import cn.com.service.settings.SupplierSetService;

public class SupplierSetDialog extends JDialog{
	private JLabel lblSupplier;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDel;
	private JButton btnExit;
	private JTextField textSupplier;
	private JTable table;
	private DefaultTableModel dtm;
	private SupplierDAOInf SupDAO;
	private SupplierBean sb;
	
	public JTextField getTextSupplier() {
		return textSupplier;
	}

	public void setTextSupplier(JTextField textSupplier) {
		this.textSupplier = textSupplier;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	public SupplierSetDialog(Frame f,String title,boolean model,SupplierBean sb) {
		super(f,title,model);
		getContentPane().setBackground(new Color(224, 255, 255));
		this.sb = sb;
		lblSupplier = new JLabel("输入相关供货商信息进行查询(供货商编号、名称)：");
		textSupplier = new JTextField();
		btnAdd = new JButton("增加");
		btnAdd.setBackground(new Color(224, 255, 255));
		btnUpdate = new JButton("修改");
		btnUpdate.setBackground(new Color(224, 255, 255));
		btnDel = new JButton("删除");
		btnDel.setBackground(new Color(224, 255, 255));
		btnExit = new JButton("退出");
		btnExit.setBackground(new Color(224, 255, 255));
	    table = new JTable();
	    table.setBackground(new Color(224, 255, 255));
	    SupDAO = new SupplierDAOImpl();
		
		init();
		
		
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setTitle("供货商设置");
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
		scrollPane.setBorder(BorderFactory.createTitledBorder("供货商列表"));
		//table选择模式
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//关闭自动调整格式
//	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
	    SupplierSetService ss= new SupplierSetService(this);
		btnAdd.setActionCommand("Add");
		btnUpdate.setActionCommand("Update");
		btnDel.setActionCommand("Del");
		btnExit.setActionCommand("Exit");

		
		lblSupplier.setBounds(30, 65, 300, 15);
		getContentPane().add(lblSupplier);
		
		textSupplier.setBounds(330, 63, 156, 20);
		getContentPane().add(textSupplier);
		textSupplier.setColumns(10);
		textSupplier.addKeyListener(new KeyListener() {
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
		
	
			
		table.addMouseListener(ss);
	
		btnAdd.addActionListener(ss);
		btnUpdate.addActionListener(ss);
		btnDel.addActionListener(ss);
		btnExit.addActionListener(ss);
	
		
		this.setVisible(true);
	}

	public void setTableData() {
		// TODO Auto-generated method stub
		Vector<String> title = new Vector<String>();
		title.add("序号");
		title.add("供货商编号");
		title.add("供货商名称");
		title.add("联系人");
		title.add("联系电话");
		title.add("供货商地址");
		title.add("备注");
		Vector data = new Vector();
	
		Vector row = null;
		dtm = new DefaultTableModel(data,title);
			List<SupplierBean> list = SupDAO.getAllSupplierInfo();
			int i = 1;
			for(SupplierBean sb :list){
				row = new Vector();
			    row.add(i);
				row.add(sb);
				row.add(sb.getSupplier_name());
				row.add(sb.getSupplier_contact());
				row.add(sb.getSupplier_tel());
				row.add(sb.getSupplier_addr());
				row.add(sb.getSupplier_note());
		
				data.add(row);
				i++;
			}
	
		
		table.setModel(dtm);
	}
	private void test(KeyEvent e) {
		// TODO Auto-generated method stub
		char c=e.getKeyChar();
		String s = this.textSupplier.getText();
		String msg2=s+c;
		if(s.length()==0){
			setTableData();
		}else{
		Vector<String> title = new Vector<String>();
		title.add("序号");
		title.add("供货商编号");
		title.add("供货商名称");
		title.add("联系人");
		title.add("联系电话");
		title.add("供货商地址");
		title.add("备注");
		Vector data = new Vector();
		
		Vector row = null;
		dtm = new DefaultTableModel(data,title);
			List<SupplierBean> list = SupDAO.querySupplier(msg2);
			int i = 1;
			for(SupplierBean sb :list){
				row = new Vector();
			    row.add(i);
				row.add(sb);
				row.add(sb.getSupplier_name());
				row.add(sb.getSupplier_contact());
				row.add(sb.getSupplier_tel());
				row.add(sb.getSupplier_addr());
				row.add(sb.getSupplier_note());
		
				data.add(row);
				i++;
			}
          this.table.setModel(dtm);
		}
	}

}
