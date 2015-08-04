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

import cn.com.beans.WarehouseBean;
import cn.com.daos.settings.WarehouseDAOImpl;
import cn.com.daos.settings.WarehouseDAOInf;
import cn.com.service.settings.WarehouseSetService;

public class WarehouseSetDialog extends JDialog{
	private JLabel lblWarehouse;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDel;
	private JButton btnExit;
	private JTextField textWarehouse;
	private JTable table;
	private DefaultTableModel dtm;
	private WarehouseDAOInf WareDAO;
	private WarehouseBean wb;
	
	public JTextField getTextWarehouse() {
		return textWarehouse;
	}

	public void setTextWarehouse(JTextField textWarehouse) {
		this.textWarehouse = textWarehouse;
	}
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	public WarehouseSetDialog(Frame f,String title,boolean model,WarehouseBean wb) {
		super(f,title,model);
		getContentPane().setBackground(new Color(176, 224, 230));
		this.wb = wb;
		lblWarehouse = new JLabel("输入相关仓库信息进行查询(仓库编号、名称)：");
		textWarehouse = new JTextField();
		btnAdd = new JButton("增加");
		btnAdd.setBackground(new Color(176, 224, 230));
		btnUpdate = new JButton("修改");
		btnUpdate.setBackground(new Color(176, 224, 230));
		btnDel = new JButton("删除");
		btnDel.setBackground(new Color(176, 224, 230));
		btnExit = new JButton("退出");
		btnExit.setBackground(new Color(176, 224, 230));
	    table = new JTable();
	    table.setBackground(new Color(176, 224, 230));
	    WareDAO = new WarehouseDAOImpl();
		
		init();
		
		
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setTitle("仓库设置");
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
		scrollPane.setBorder(BorderFactory.createTitledBorder("仓库列表"));
		//table选择模式
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//关闭自动调整格式
//	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	 
		
		
		lblWarehouse.setBounds(30, 65, 280, 15);
		getContentPane().add(lblWarehouse);
		
		textWarehouse.setBounds(290, 63, 156, 20);
		getContentPane().add(textWarehouse);
		textWarehouse.setColumns(10);
		textWarehouse.addKeyListener(new KeyListener() {
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
	    WarehouseSetService ws= new WarehouseSetService(this);
		btnAdd.setActionCommand("Add");
		btnUpdate.setActionCommand("Update");
		btnDel.setActionCommand("Del");
		btnExit.setActionCommand("Exit");	
		table.addMouseListener(ws);
		
		btnAdd.addActionListener(ws);
		btnUpdate.addActionListener(ws);
		btnDel.addActionListener(ws);
		btnExit.addActionListener(ws);
	
		
		this.setVisible(true);
	}

	public void setTableData() {
		// TODO Auto-generated method stub
		Vector<String> title = new Vector<String>();
		title.add("序号");
		title.add("仓库编号");
		title.add("仓库名称");
		title.add("负责人");
		title.add("联系电话");
		title.add("仓库地址");
		title.add("备注");
		Vector data = new Vector();
	
		Vector row = null;
		dtm = new DefaultTableModel(data,title);
			List<WarehouseBean> list = WareDAO.getAllWarehouseInfo();
			int i = 1;
			for(WarehouseBean wb :list){
				row = new Vector();
			    row.add(i);
				row.add(wb);
				row.add(wb.getWarehouse_name());
				row.add(wb.getWarehouse_head());
				row.add(wb.getWarehouse_tel());
				row.add(wb.getWarehouse_addr());
				row.add(wb.getWarehouse_note());
		
				data.add(row);
				i++;
			}
	
		
		table.setModel(dtm);
	}
	private void test(KeyEvent e) {
		// TODO Auto-generated method stub
		char c=e.getKeyChar();
		String s = this.textWarehouse.getText();
		String msg2=s+c;
		if(s.length()==0){
			setTableData();
		}else{
		Vector<String> title = new Vector<String>();
		title.add("序号");
		title.add("仓库编号");
		title.add("仓库名称");
		title.add("负责人");
		title.add("联系电话");
		title.add("仓库地址");
		title.add("备注");
		Vector data = new Vector();
		
		Vector row = null;
		dtm = new DefaultTableModel(data,title);
			List<WarehouseBean> list = WareDAO.queryWarehouse(msg2);
			int i = 1;
			for(WarehouseBean wb :list){
				row = new Vector();
			    row.add(i);
				row.add(wb);
				row.add(wb.getWarehouse_name());
				row.add(wb.getWarehouse_head());
				row.add(wb.getWarehouse_tel());
				row.add(wb.getWarehouse_addr());
				row.add(wb.getWarehouse_note());

				data.add(row);
				i++;
			}
          this.table.setModel(dtm);
		}
	}

}
