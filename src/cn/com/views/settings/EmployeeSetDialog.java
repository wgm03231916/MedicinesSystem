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

import cn.com.beans.EmployeeBean;
import cn.com.daos.settings.EmployeeDAOImpl;
import cn.com.daos.settings.EmployeeDAOInf;
import cn.com.service.settings.EmployeeSetService;

public class EmployeeSetDialog extends JDialog{
	private JLabel lblEmployee;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDel;
	private JButton btnExit;
	private JTextField textEmployee;
	private JTable table;
	private DefaultTableModel dtm;
	private EmployeeDAOInf EmpDAO;
	private EmployeeBean eb;
	
	public JTextField getTextEmployee() {
		return textEmployee;
	}

	public void setTextEmployee(JTextField textEmployee) {
		this.textEmployee = textEmployee;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	public EmployeeSetDialog(Frame f,String title,boolean model,EmployeeBean eb) {
		super(f,title,model);
		getContentPane().setBackground(new Color(240, 230, 140));
		this.eb = eb;
		lblEmployee = new JLabel("输入相关员工信息进行查询(员工编号、名称)：");
		textEmployee = new JTextField();
		btnAdd = new JButton("增加");
		btnAdd.setBackground(new Color(240, 230, 140));
		btnUpdate = new JButton("修改");
		btnUpdate.setBackground(new Color(240, 230, 140));
		btnDel = new JButton("删除");
		btnDel.setBackground(new Color(240, 230, 140));
		btnExit = new JButton("退出");
		btnExit.setBackground(new Color(240, 230, 140));
	    table = new JTable();
	    table.setBackground(new Color(240, 230, 140));
	    EmpDAO = new EmployeeDAOImpl();
		
		init();
		
		
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setTitle("员工设置");
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
		scrollPane.setBorder(BorderFactory.createTitledBorder("员工列表"));
		//table选择模式
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//关闭自动调整格式
//	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
	 
		lblEmployee.setBounds(30, 65, 300, 15);
		getContentPane().add(lblEmployee);
		
		textEmployee.setBounds(330, 63, 156, 20);
		getContentPane().add(textEmployee);
		textEmployee.setColumns(10);
		textEmployee.addKeyListener(new KeyListener() {
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
		
	    EmployeeSetService es= new EmployeeSetService(this);
		btnAdd.setActionCommand("Add");
		btnUpdate.setActionCommand("Update");
		btnDel.setActionCommand("Del");
		btnExit.setActionCommand("Exit");
			
		table.addMouseListener(es);
	
		btnAdd.addActionListener(es);
		btnUpdate.addActionListener(es);
		btnDel.addActionListener(es);
		btnExit.addActionListener(es);
	
		
		this.setVisible(true);
	}

	public void setTableData() {
		// TODO Auto-generated method stub
		Vector<String> title = new Vector<String>();
		title.add("序号");
		title.add("员工编号");
		title.add("员工名称");
		title.add("所属职位");
		title.add("联系电话");
		title.add("员工地址");
		title.add("备注");
		Vector data = new Vector();
	
		Vector row = null;
		dtm = new DefaultTableModel(data,title);
			List<EmployeeBean> list = EmpDAO.getAllEmployeeInfo();
			int i = 1;
			for(EmployeeBean eb :list){
				row = new Vector();
			    row.add(i);
				row.add(eb);
				row.add(eb.getEmployee_name());
				row.add(eb.getEmployee_title());
				row.add(eb.getEmployee_tel());
				row.add(eb.getEmployee_addr());
				row.add(eb.getEmployee_note());
		
				data.add(row);
				i++;
			}
	
		
		table.setModel(dtm);
	}
	private void test(KeyEvent e) {
		// TODO Auto-generated method stub
		char c=e.getKeyChar();
		String s = this.textEmployee.getText();
		String msg2=s+c;
		if(s.length()==0){
			setTableData();
		}else{
			Vector<String> title = new Vector<String>();
			title.add("序号");
			title.add("员工编号");
			title.add("员工名称");
			title.add("所属职位");
			title.add("联系电话");
			title.add("员工地址");
			title.add("备注");
			Vector data = new Vector();
		
			Vector row = null;
			dtm = new DefaultTableModel(data,title);
				List<EmployeeBean> list = EmpDAO.queryEmployee(msg2);
				int i = 1;
				for(EmployeeBean eb :list){
					row = new Vector();
				    row.add(i);
					row.add(eb);
					row.add(eb.getEmployee_name());
					row.add(eb.getEmployee_title());
					row.add(eb.getEmployee_tel());
					row.add(eb.getEmployee_addr());
					row.add(eb.getEmployee_note());
			
					data.add(row);
				i++;
			}
          this.table.setModel(dtm);
		}
	}

}
