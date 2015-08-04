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
import javax.swing.table.DefaultTableModel;

import cn.com.beans.wang.BigBeans;
import cn.com.daos.market.wang.GoodsBeansDAOImpl;

public class CustomersPriceFrame extends JFrame {
	
	private JPanel pnlMain;
	private JScrollPane scrollPane;
	private JPanel pnlN;
	private JTable tabView;
	private DefaultTableModel dtmView;
	private JLabel lblText;
	private JTable jtbMessage;
	private GoodsBeansDAOImpl gbdi;
	
	public CustomersPriceFrame(){
		pnlMain = new JPanel();
		getContentPane().add(pnlMain, BorderLayout.CENTER);
		pnlN = new JPanel(null);
		scrollPane = new JScrollPane();
		gbdi = new GoodsBeansDAOImpl();
		
		lblText = new JLabel("�ͻ�������Ϣ");
		Font font = new  Font("����",Font.BOLD, 28);
		lblText.setFont(font);
		
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
		title.add("��Ʒ���");
		title.add("��Ʒ����");
		title.add("��λ");
		title.add("��������");
		title.add("�����ܽ��");
		title.add("�������");
		title.add("��Ʒ���");
		title.add("��������");
		title.add("��ע");
		
		Vector data = new Vector();
		Vector row = null;
		
       List<BigBeans> list = gbdi.getAllCustomerPrice();
		
		for(BigBeans bb : list){
			row = new Vector();
			
			row.add(bb.getGb().getGoods_id());
			row.add(bb.getGb().getGoods_Name());
			row.add(bb.getGb().getGoods_unit());
			row.add(bb.getSrb().getSale_num());
			row.add(bb.getSrb().getSale_price());
			row.add(bb.getHcb().getGoods_num());
			row.add(bb.getGb().getGoods_spft());
			row.add(bb.getGb().getGood_manufacture());
			row.add(bb.getGb().getGoods_note());
		
			data.add(row);
		}
		dtmView = new DefaultTableModel(data,title);
		jtbMessage.setModel(dtmView);
	}
	

}
