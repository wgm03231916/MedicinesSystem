package cn.com.views.huang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import cn.com.beans.EmployeeBean;
import cn.com.beans.HouseCapacityBean;
import cn.com.beans.JTGoodsBean;
import cn.com.beans.OrderRelationBean;
import cn.com.beans.huang.BigAllBean;
import cn.com.daos.huang.MedicineDaoImp;
import cn.com.listener.huang.BuyViewFrame_ActionListener;
import cn.com.listener.huang.addOldGoods_MouseListener;
import cn.com.util.DateChooser;
import cn.com.util.DateFormatUtil;
import cn.com.util.Globel;



public class BuyInView extends JFrame{
	   private JPanel pnlMain;
       private JTextArea txtSupply;
	   private JLabel lblTitle;
	   private JLabel lblNum;
	   private JLabel lblSupply;
	   private JLabel lblHouse;
	   private JButton btnSearch;
	   private JComboBox jcbHouse;
	   private JComboBox jcbPeople;
	   private DefaultComboBoxModel dcmPeople;
	   private DefaultComboBoxModel dcmHouse;
	   private JLabel lblDate;
	   private JTextField txtDate;
	  // private JButton btnDateSearch;
	   public  JButton btnOldGoods;
	   public  JButton btnNewGoods;
	   private JLabel lblPayAble;
	   private JLabel lblPaid;
	   private JLabel lblPeople;
	   private JLabel lblOrginal;
	   private JLabel lblNote;
	   private JTextArea txtPayAble;
	   private JTextArea txtPaid;
	   private JTextArea txtOrginal;
	   private JTextArea txtNote;
	   private JButton btnKeep;
	   private JButton btnExit;
	   public JTable tabView;
	   public DefaultTableModel dtmView;
	   public JScrollPane snpView;
	   public static Object o;
	   private JLabel lblDDH;
	   public JTable tab;
	   public int row;
	   public int col;
	   public String msg;
	   public String msg2;
	   public BuyInView(){
	   	getContentPane().setBackground(new Color(222, 184, 135));
		   
	   }
	   //JDesktopPane dnlC;
       public BuyInView(JTable tab,int row,int col){
    	   this.tab=tab;
		   this.col=col;
		   this.row=row;
    	   //dnlC=new JDesktopPane();
    	   pnlMain=new JPanel(null);
    	   txtSupply=new JTextArea((String)o);
    	   jcbHouse=new JComboBox();
    	   jcbPeople=new JComboBox();
    	   dcmPeople=new DefaultComboBoxModel();
    	   dcmHouse=new DefaultComboBoxModel();
    	   txtDate=new JTextField(DateFormatUtil.getTime(new Date()));
   	       DateChooser dateChooser1 = DateChooser.getInstance("yyyy-MM-dd");
   	       dateChooser1.register(txtDate);
    	   txtPayAble=new JTextArea();  
    	   txtPaid=new JTextArea();
    	   txtOrginal=new JTextArea();
    	   txtNote=new JTextArea();
    	   lblTitle=new JLabel("采购进货");
    	   lblNum=new JLabel("单号：");
    	   lblSupply=new JLabel("供货商：");
    	   btnSearch=new JButton("搜索");
    	   lblHouse=new JLabel("收货仓库:");
    	   lblDate=new JLabel("进货日期:");
    	   //btnDateSearch=new JButton("日历");
    	   btnOldGoods=new JButton("老商品添加");
    	   btnNewGoods=new JButton("新商品添加");
    	   lblPayAble=new JLabel("应付金额：");
    	   lblPaid=new JLabel("实付金额：");
    	   lblPeople=new JLabel("经办人：");
    	   lblOrginal=new JLabel("原始单号：");
    	   lblNote=new JLabel("备  注：");
    	   btnKeep=new JButton("保存");
    	   btnExit=new JButton("退出");
    	   SimpleDateFormat d1=new SimpleDateFormat("yyyyMMdd");
    	   SimpleDateFormat d2=new SimpleDateFormat("HHmmss");
           String s1=d1.format(new Date());
           String s2=d2.format(new Date());
    	   lblDDH=new JLabel("CJ"+s1+s2);
    	   tabView=new JTable(){
    		   @Override
    		public boolean isCellEditable(int row, int column) {
    			// TODO Auto-generated method stub
    			return false;
    		}
    	   };
    	   snpView=new JScrollPane();
    	   init();
       }
	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(750, 480);
		Globel.setCenterByWindow(this);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {  
			  UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");  
			 }catch (Exception ex) {  
			      ex.printStackTrace();  
			 }
		this.setTitle("采购进货");
		getContentPane().add(pnlMain);
		pnlMain.add(lblTitle);
		pnlMain.add(lblNum);
		pnlMain.add(lblSupply);
		pnlMain.add(txtSupply);
		pnlMain.add(btnSearch);
		pnlMain.add(lblHouse);
		pnlMain.add(jcbHouse);
		pnlMain.add(lblDate);
		pnlMain.add(txtDate);
		//pnlMain.add(btnDateSearch);
		pnlMain.add(btnOldGoods);
		pnlMain.add(btnNewGoods);
		pnlMain.add(lblNote);
		pnlMain.add(lblOrginal);
		pnlMain.add(lblPaid);
		pnlMain.add(lblPayAble);
		pnlMain.add(lblPeople);
		pnlMain.add(txtPayAble);
		pnlMain.add(txtPaid);
		pnlMain.add(txtOrginal);
		pnlMain.add(txtNote);
		pnlMain.add(jcbPeople);
		pnlMain.add(btnKeep);
		pnlMain.add(btnExit);
		pnlMain.add(lblDDH);
		lblTitle.setFont(new Font("Dialog", 1, 15));
		lblTitle.setBounds(300, 20, 150, 30);
		lblNum.setFont(new Font("Dialog", 1, 15));
		lblNum.setBounds(475, 20, 60, 30);
		lblNum.setForeground(Color.red);
		lblDDH.setForeground(Color.red);
		lblDDH.setBounds(530, 20, 150, 30);
		lblSupply.setBounds(35, 80,60, 20);
		lblHouse.setBounds(310, 80, 70, 20);
		jcbHouse.setBounds(380, 80, 90, 20);
		txtSupply.setBounds(100, 80,130 ,20);
		lblDate.setBounds(490, 80, 100, 20);
		txtDate.setBounds(550, 80, 100, 20);
		//btnDateSearch.setBounds(650, 80, 70, 20);
		btnSearch.setBounds(240, 80, 60, 20);
		btnOldGoods.setBounds(30, 120, 110, 30);
		btnNewGoods.setBounds(150, 120, 110, 30);
		lblPayAble.setBounds(20, 360, 80, 20);
		txtPayAble.setBounds(90, 360, 70, 20);
		lblPaid.setBounds(180, 360,80, 20);
		txtPaid.setBounds(250, 360, 70, 20);
		lblPeople.setBounds(340, 360, 70, 20);
		jcbPeople.setBounds(400, 360, 70, 20);
		lblOrginal.setBounds(480, 360, 80, 20);
		txtOrginal.setBounds(550, 360, 130, 20);
		lblNote.setBounds(20, 400, 80, 20);
		txtNote.setBounds(70, 400, 220, 20);
		btnKeep.setBounds(330, 400, 60, 20);
		btnExit.setBounds(430, 400, 60, 20);
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BuyInView.this.dispose();
			}
		});
		snpView.setViewportView(tabView);
		snpView.setBounds(20, 160, 700,180);
		pnlMain.add(snpView);
		btnOldGoods.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.gray));
		btnNewGoods.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.gray));
		setTableData2();
		//btnDateSearch.addActionListener(new DateFrame_ActionListener(this));
		btnSearch.setBackground(Color.blue);
//		btnOldGoods.setBorder(null);
//		btnNewGoods.setBorder(null);
		btnOldGoods.addMouseListener(new addOldGoods_MouseListener(this));
		//btnNewGoods.addMouseListener(new addNewGoods_MouseListener(this));
		btnSearch.addActionListener(new BuyViewFrame_ActionListener(this));
		btnNewGoods.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//new AddNewGoods();
				   new AddGoodsDialog();
			}
		});
		btnKeep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 
				 if(BuyInView.this.tabView.getSelectedRow()!=0){
					 JOptionPane.showMessageDialog(null, "单据中没有业务发生不能保存！", "提示", JOptionPane.INFORMATION_MESSAGE);
				 }
				 else{
				 BigAllBean big=new BigAllBean();
				 JTGoodsBean jb=new JTGoodsBean();
				 HouseCapacityBean hb=new HouseCapacityBean();
				 OrderRelationBean ob=new OrderRelationBean();
				 big.setJb(jb);
				 big.setOb(ob);
				 big.setHc(hb);
				 /***
				  * 先插JTGoods
				  * 再插入HouseCapacity
				  * 最后OrderRelation
				  */
				 big.getJb().setOrder_id(BuyInView.this.lblDDH.getText().toString());
				 big.getJb().setSupplier_id(BuyInView.this.tab.getValueAt(row, col-1).toString());
				 big.getJb().setOrder_type("采购进货");
				 System.out.println("+++++++"+msg);
				 big.getJb().setWarehouse_id(msg);
				 big.getJb().setOrder_date(BuyInView.this.txtDate.getText().toString());
				 big.getJb().setOrder_price(Float.parseFloat(BuyInView.this.tabView.getValueAt(0, 9).toString()));
				 big.getJb().setOrder_head(msg2);
				 big.getJb().setOrder_note(BuyInView.this.txtNote.getText().toString());
				 big.getHc().setWarehouse_id(msg);
				 big.getHc().setGoods_id(BuyInView.this.tabView.getValueAt(0, 5).toString());
				 big.getHc().setGoods_num(Integer.parseInt(BuyInView.this.tabView.getValueAt(0, 8).toString()));
				 big.getOb().setOrder_id(BuyInView.this.lblDDH.getText().toString());
				 big.getOb().setGoods_id(BuyInView.this.tabView.getValueAt(0, 5).toString());
				 big.getOb().setWarehouse_id(msg);
				 big.getOb().setGoods_num(Integer.parseInt(BuyInView.this.tabView.getValueAt(0, 8).toString()));
				 big.getOb().setOrder_price(Float.parseFloat(BuyInView.this.tabView.getValueAt(0, 9).toString()));
				 big.getOb().setGoods_validity(BuyInView.this.tabView.getValueAt(0, 6).toString());
				 MedicineDaoImp dao=new MedicineDaoImp();
				 boolean boolJT=dao.addCJGoodsInfo(big);//插入数据到进退货订单表;
				 boolean boolOB=dao.addCJGoodsInfo2(big);
				 boolean bool=dao.isExistByGoodsIdAndHouseID(big);//判定商品是否存在
				 if(bool){
					 //更新库存数  数据加1
					 boolean boolUP=dao.UpdateHouseData(big);
					 if(boolJT&&boolOB&&boolUP){
						 if(JOptionPane.YES_OPTION==JOptionPane.showConfirmDialog(null, "单据保存后不能被修改是否保存", "提示",JOptionPane.YES_NO_OPTION)){
							 Vector<String> title=new Vector<String>();
								title.add("商品名称");
								title.add("单位");
								title.add("产品规格");
								title.add("批准文号");
								title.add("生产厂商");
								title.add("产品编号");
								title.add("有效期");
								title.add("单价");
								title.add("数量");
								title.add("总金额");
								Vector data=new Vector();
								dtmView=new DefaultTableModel(data,title);
								BuyInView.this.tabView.setModel(BuyInView.this.dtmView);
						 }
					 }
				 }else{
					 //插入数据到 库存表中
					 boolean boolHC=dao.addCJGoodsInfo1(big);
					 if(boolJT&&boolOB&&boolHC){
						 if(JOptionPane.YES_OPTION==JOptionPane.showConfirmDialog(null, "单据保存后不能被修改是否保存", "提示",JOptionPane.YES_NO_OPTION)){
							 Vector<String> title=new Vector<String>();
								title.add("商品名称");
								title.add("单位");
								title.add("产品规格");
								title.add("批准文号");
								title.add("生产厂商");
								title.add("产品编号");
								title.add("有效期");
								title.add("单价");
								title.add("数量");
								title.add("总金额");
								Vector data=new Vector();
								dtmView=new DefaultTableModel(data,title);
								BuyInView.this.tabView.setModel(BuyInView.this.dtmView);
						 }
					 }
				 }
				
				 
			}
			}
		});
		jcbPeople.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				msg2=(String)dcmPeople.getSelectedItem();
				//System.out.println(msg2);
			}
		});
		jcbHouse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				msg=(String)dcmHouse.getSelectedItem();
				MedicineDaoImp dao=new MedicineDaoImp();
				List<BigAllBean> list=dao.getWareHouseByHouseName(msg);
				for(BigAllBean b:list){
					  msg=b.getWb().getWarehouse_id().toString();
				}
			}
		});

		setComHData();
		this.jcbHouse.setModel(dcmHouse);
		
		setComPData();
		this.jcbPeople.setModel(dcmPeople);
		
		//this.setModal(true);
		
		this.setVisible(true);
	}
	private void setTableData2() {
		// TODO Auto-generated method stub
		Vector<String> title=new Vector<String>();
		title.add("商品名称");
		title.add("单位");
		title.add("产品规格");
		title.add("批准文号");
		title.add("生产厂商");
		title.add("产品编号");
		title.add("有效期");
		title.add("单价");
		title.add("数量");
		title.add("总金额");
		Vector data=new Vector();
		dtmView=new DefaultTableModel(data,title);
		this.tabView.setModel(this.dtmView);
	}
	private void setComPData() {
		// TODO Auto-generated method stub
		MedicineDaoImp mdao=new MedicineDaoImp();
		List<EmployeeBean> list=mdao.getEmployeeInfo();
		for(EmployeeBean b:list){
			this.dcmPeople.addElement(b.getEmployee_name());
		}
	}
	private void setComHData() {
		// TODO Auto-generated method stub
		MedicineDaoImp mdao=new MedicineDaoImp();
		List<BigAllBean> list=mdao.getHouseRootData();
		for(BigAllBean b:list){
			
			this.dcmHouse.addElement(b.getWb().getWarehouse_name());
			
			//System.out.println(msg);
			//System.out.println(b);
		}
	}
	public void BtnSupply(ActionEvent e) {
		// TODO Auto-generated method stub
		new AccountItemFrame();
		this.dispose();
	}
	public void BtnDateS(ActionEvent e) {
		// TODO Auto-generated method stub
		DateChooser dateChooser2 = DateChooser.getInstance("yyyy-MM-dd");
		JLabel showDate2 = new JLabel("单击选择日期");
		dateChooser2.register(showDate2);
		JDialog jf = new JDialog();
		jf.getContentPane().add(showDate2, BorderLayout.SOUTH);
		jf.pack();
		 
		jf.setLocationRelativeTo(null);
 
		jf.setVisible(true);
 
		jf.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
 
	}
	
}
