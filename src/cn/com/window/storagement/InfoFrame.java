package cn.com.window.storagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.com.beans.liu.GoodsBeans;
import cn.com.beans.liu.HouseCapacityBeans;
import cn.com.beans.liu.MoveBeans;
import cn.com.beans.liu.WarehouseBeans;
import cn.com.beans.view.liu.TransferView;
import cn.com.service.storage.TransferServiceImpl;
import cn.com.service.storage.TransferServiceInf;
import cn.com.windowlistener.storage.InfoFrame_btn_mouseListener;


@SuppressWarnings("serial")
public class InfoFrame extends JDialog {

	private JPanel contentPane;
	private JTextField txtAmount;
	private JLabel lblGoodInfo;
	private JLabel lblNumber;
	private JLabel lblNumberValue;
	private JLabel lblVersion;
	private JLabel lblVersionValue;
	private JLabel lblStock;
	private JLabel lblStockValue;
	private JLabel lblFirm;
	private JLabel lblFirmValue;
	private JLabel lblName;
	private JLabel lblUnit;
	private JLabel lblRegNumber;
	private JLabel lblRemark;
	private JLabel lblNameValue;
	private JLabel lblUnitValue;
	private JLabel lblRegNumberValue;
	private JLabel lblRemarkValue;
	private JLabel lblAmount;
	
	private JTabbedPane tabbedPane;
	private JPanel panel;
	
	private JButton btnConfirm;
	private JButton btnExit;
	private Label lblInfo;
	private JLabel lblAllStock;
	private JTable table;
	private GoodsBeans goodsb;
	private WarehouseBeans warehouseb;
	private TransferView vList;
	public static int flag;
	
	
    public TransferView getvList() {
    	if(flag==1) {
    		MoveBeans mob = new MoveBeans();
    		mob.setMove_number(Integer.parseInt(txtAmount.getText()));
    		vList.setMovesb(mob);
    		return vList;
    	}
		return null;
	}

	public JButton getBtnConfirm() {
		return btnConfirm;
	}

	public JButton getBtnExit() {
		return btnExit;
	}



	public JTextField getTxtAmount() {
		return txtAmount;
	}


	public JLabel getLblStockValue() {
		return lblStockValue;
	}

	//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InfoFrame frame = new InfoFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try{
					InfoFrame frame = new InfoFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * default constructor
	 */
	public InfoFrame() {
		setTitle("\u5546\u54C1\u4FE1\u606F\uFF08\u5E93\u5B58\u8C03\u62E8\uFF09");
		initObject();
		initJDialog();
		//drawLine(InfoFrame.this.getGraphics());
	}
	
	public InfoFrame(GoodsBeans goodsb, WarehouseBeans warehouseb) {
		// TODO Auto-generated constructor stub
		this();
		flag = 0;
		this.goodsb = goodsb;
		this.warehouseb = warehouseb;
		initList();
		initNumber();
	}
	//从数据库获得对象，从而对各个控件赋值
	private void initNumber() {
		// TODO Auto-generated method stub
		GoodsBeans gb = vList.getGoodsb();
		HouseCapacityBeans hb = vList.getHousecapb();
		
		lblNumberValue.setText(gb.getGoods_id());
		lblNameValue.setText(gb.getGoods_name());
		lblVersionValue.setText(gb.getGoods_spft());
		lblUnitValue.setText(gb.getGoods_unit());
		lblStockValue.setText(hb.getGoods_num()+"");
		lblRegNumberValue.setText(gb.getGoods_apvlnum());
		lblFirmValue.setText(gb.getGoods_manufacture());
		lblRemarkValue.setText(gb.getGoods_note());
		
		
	}
	//从数据库中获得数据
	private void initList() {
		// TODO Auto-generated method stub
		TransferServiceInf transfer = new TransferServiceImpl();
		TransferView transfView = new TransferView();
		transfView.setGoodsb(goodsb);
		transfView.setWarehouseb(warehouseb);
		vList =transfer.getChooseServiceInf(transfView);
	}

	@SuppressWarnings("unused")
	private void drawLine(Graphics g) {
		// 获得颜色
		Color oldColor = g.getColor();
		Color c = new Color(200,200,200);
		// 画线
		g.setColor(c);
		g.drawLine(38, 193, 300, 0);
		g.setColor(oldColor);
	}
	
	/**
	 * 对象初始化
	 */
	private void initObject(){
		/*
		 * 商品信息
		 */
		lblGoodInfo = new JLabel("\u5546\u54C1\u4FE1\u606F");
		lblNumber = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		lblNumberValue = new JLabel("");
		lblVersion = new JLabel("\u89C4\u683C\u578B\u53F7\uFF1A");
		lblVersionValue = new JLabel("");
		lblStock = new JLabel("\u5F53\u524D\u5E93\u5B58\uFF1A");
		lblStockValue = new JLabel("");
		lblFirm = new JLabel("\u751F\u4EA7\u5382\u5546\uFF1A");
		lblFirmValue = new JLabel("");
		lblName = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		lblUnit = new JLabel("\u5355    \u4F4D\uFF1A");
		lblRegNumber = new JLabel("\u6279\u51C6\u6587\u53F7\uFF1A");
		lblRemark = new JLabel("\u5907    \u6CE8\uFF1A");
		lblNameValue = new JLabel("");
		lblUnitValue = new JLabel("");
		lblRegNumberValue = new JLabel("");
		lblRemarkValue = new JLabel("");
		/*
		 * 商品批次信息
		 */
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel = new JPanel();
		lblInfo = new Label("\u53EF\u4EE5\u5728\u4E0B\u9762\u7684\u5217\u8868\u4E2D\u9009\u62E9\u4E0D\u540C\u6279\u6B21\u7684\u5546\u54C1");
		lblAllStock = new JLabel("\u5E93\u5B58\u6570\u91CF\uFF1A");
		table = new JTable();
		/*
		 * 中间显示的部分
		 */
		lblAmount = new JLabel("\u6570    \u91CF\uFF1A");
		txtAmount = new JTextField("1");
		
		// 按钮
		btnConfirm = new JButton("\u786E  \u5B9A");
		btnConfirm.addMouseListener(new InfoFrame_btn_mouseListener(this));

		btnExit = new JButton("\u9000  \u51FA");
		btnExit.addMouseListener(new InfoFrame_btn_mouseListener(this));
		// 按钮添加事件
		// ...
	}
	

	/**
	 * Create the frame.
	 */
	private void initJDialog() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 761, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblGoodInfo.setFont(new Font("宋体", Font.PLAIN, 14));
		lblGoodInfo.setBounds(32, 20, 69, 15);
		contentPane.add(lblGoodInfo);
		
		lblNumber.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNumber.setBounds(42, 51, 86, 15);
		contentPane.add(lblNumber);
		
		lblNumberValue.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNumberValue.setForeground(new Color(51, 102, 204));
		lblNumberValue.setBounds(132, 51, 203, 15);
		contentPane.add(lblNumberValue);
		
		lblVersion.setFont(new Font("宋体", Font.PLAIN, 14));
		lblVersion.setBounds(42, 87, 86, 15);
		contentPane.add(lblVersion);
		
		lblVersionValue.setFont(new Font("宋体", Font.PLAIN, 14));
		lblVersionValue.setForeground(new Color(51, 102, 204));
		lblVersionValue.setBounds(132, 87, 203, 15);
		contentPane.add(lblVersionValue);
		
		lblStock.setFont(new Font("宋体", Font.PLAIN, 14));
		lblStock.setBounds(42, 120, 86, 15);
		contentPane.add(lblStock);
		
		lblStockValue.setFont(new Font("宋体", Font.PLAIN, 14));
		lblStockValue.setForeground(new Color(255, 51, 102));
		lblStockValue.setBounds(132, 120, 203, 15);
		contentPane.add(lblStockValue);
		
		lblFirm.setFont(new Font("宋体", Font.PLAIN, 14));
		lblFirm.setBounds(42, 157, 86, 15);
		contentPane.add(lblFirm);
		
		lblFirmValue.setFont(new Font("宋体", Font.PLAIN, 14));
		lblFirmValue.setForeground(new Color(51, 102, 204));
		lblFirmValue.setBounds(132, 157, 203, 15);
		contentPane.add(lblFirmValue);
		
		lblName.setFont(new Font("宋体", Font.PLAIN, 14));
		lblName.setBounds(380, 51, 86, 15);
		contentPane.add(lblName);
		
		lblUnit.setFont(new Font("宋体", Font.PLAIN, 14));
		lblUnit.setBounds(380, 87, 86, 15);
		contentPane.add(lblUnit);
		
		lblRegNumber.setFont(new Font("宋体", Font.PLAIN, 14));
		lblRegNumber.setBounds(380, 120, 86, 15);
		contentPane.add(lblRegNumber);
		
		lblRemark.setFont(new Font("宋体", Font.PLAIN, 14));
		lblRemark.setBounds(380, 157, 86, 15);
		contentPane.add(lblRemark);
		
		lblNameValue.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNameValue.setForeground(new Color(255, 51, 102));
		lblNameValue.setBounds(466, 51, 217, 15);
		contentPane.add(lblNameValue);
		
		lblUnitValue.setFont(new Font("宋体", Font.PLAIN, 14));
		lblUnitValue.setForeground(new Color(51, 102, 204));
		lblUnitValue.setBounds(466, 87, 217, 15);
		contentPane.add(lblUnitValue);
		
		lblRegNumberValue.setFont(new Font("宋体", Font.PLAIN, 14));
		lblRegNumberValue.setForeground(new Color(51, 102, 204));
		lblRegNumberValue.setBounds(466, 120, 217, 15);
		contentPane.add(lblRegNumberValue);
		
		lblRemarkValue.setFont(new Font("宋体", Font.PLAIN, 14));
		lblRemarkValue.setForeground(new Color(51, 102, 204));
		lblRemarkValue.setBounds(466, 157, 217, 15);
		contentPane.add(lblRemarkValue);
		
		tabbedPane.setBounds(37, 288, 667, 204);
		contentPane.add(tabbedPane);
		
		tabbedPane.addTab("\u5546\u54C1\u6279\u6B21\u4FE1\u606F", null, panel, null);
		
		lblAmount.setFont(new Font("宋体", Font.PLAIN, 14));
		lblAmount.setBounds(42, 200, 86, 15);
		contentPane.add(lblAmount);
		
		txtAmount.setBounds(132, 197, 135, 21);
		contentPane.add(txtAmount);
		txtAmount.setColumns(10);
		
		btnConfirm.setBounds(209, 260, 93, 31);
		contentPane.add(btnConfirm);
		
		btnExit.setBounds(373, 260, 93, 31);
		contentPane.add(btnExit);
		
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(lblInfo, BorderLayout.NORTH);
		lblAllStock.setFont(new Font("宋体", Font.PLAIN, 14));
		panel.add(lblAllStock, BorderLayout.SOUTH);
		panel.add(table, BorderLayout.CENTER);
		this.setModal(true);
	}
}
