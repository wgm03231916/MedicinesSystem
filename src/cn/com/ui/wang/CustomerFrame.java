package cn.com.ui.wang;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.com.beans.wang.BigBeans;
import cn.com.daos.market.wang.GoodsBeansDAOImpl;

public class CustomerFrame extends JFrame {
	private JPanel pnlMain;
	private JScrollPane scrollPane;
	private JPanel pnlN;
	private JTable tabView;
	private DefaultTableModel dtmView;
	private JLabel lblText;
	private JTable jtbMessage;
	private JTextField jtfName;
	private GoodsBeansDAOImpl gbdi;
	
	public CustomerFrame(){
		pnlMain = new JPanel();
		getContentPane().add(pnlMain, BorderLayout.CENTER);
		pnlN = new JPanel(null);
		scrollPane = new JScrollPane();
		gbdi = new GoodsBeansDAOImpl();
		
		lblText = new JLabel("�ͻ����е���");
		Font font = new  Font("����",Font.BOLD, 28);
		lblText.setFont(font);
		
		jtfName = new JTextField(null);
		jtbMessage = new JTable(){
			//ʹtable���ɱ��༭
		public boolean isCellEditable(int row, int column)
            {
                return false;
            }
		};
		jtbMessage.setFillsViewportHeight(true);
		
		init();
		
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(950, 580);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(getOwner());
		this.setResizable(false);
		
		setTableMessage();
		lblText.setBounds(400,60,300,30);
		scrollPane.setBounds(20, 120, 900, 400);
		scrollPane.getViewport().add(jtbMessage);
		
		pnlMain.add(pnlN);
		pnlN.add(lblText);
		pnlN.add(scrollPane);
		
		this.add(pnlN);
		this.setVisible(true);
	}

	public void setTableMessage() {
		// TODO Auto-generated method stub
		Vector<String> title = new Vector<String>();
		title.add("�ͻ�����");
		title.add("����");
		title.add("����");
		title.add("Ӧ���ܽ��");
		title.add("������");
		title.add("��ע");
		
		Vector data = new Vector();
		Vector row = null;
		
       List<BigBeans> list = gbdi.getAllCustomerMess();
		
		for(BigBeans bb : list){
			row = new Vector();
			
			row.add(bb.getCb().getCustomer_name());
			row.add(bb.getGsb().getSale_date());
			row.add(bb.getGsb().getSale_id());
			row.add(bb.getSrb().getSale_price());
			row.add(bb.getGsb().getSale_people());
			row.add(bb.getGsb().getSale_note());
		
			data.add(row);
		}
		dtmView = new DefaultTableModel(data,title);
		jtbMessage.setModel(dtmView);
	}

}
