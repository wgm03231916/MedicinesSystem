package cn.com.listener.huang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import cn.com.views.huang.MainFrame;
import cn.com.views.huang.StockView;

//import cn.com.daos.CityDaoInf;

public class MainFranme_ActionListener implements ActionListener {
	private MainFrame mf;
	// private CityDaoInf dao;
	private MainFranme_ActionListener_Service service;

	public MainFranme_ActionListener(MainFrame mf) {
		this.mf = mf;
		// dao=new CityDaoInf();
		service = new MainFranme_ActionListener_Service(mf);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == mf.getBtnLogin()) {
			new StockView();
			mf.dispose();
		} else if (o == mf.getBtnReset()) {
			btnResetService(e);
		}
	}

	private void btnResetService(ActionEvent e) {
		// TODO Auto-generated method stub
		mf.getTxtUserName().setText("");
		mf.getTxtPwd().setText("");

	}
}
//	private void btnLoginService(ActionEvent e) {
//		// TODO Auto-generated method stub
//		BorrowDaoImp dao = new BorrowDaoImp();
//		UserBeans b = new UserBeans();
//		String msgName = mf.getTxtUserName().getText();
//		String msgPass = mf.getTxtPwd().getText();
//		if (msgName.equals(" ") || msgPass.equals(" ")) {
//			JOptionPane.showMessageDialog(null, "’À∫≈ªÚ√‹¬ÎŒ™ø’£°", "¥ÌŒÛ",
//					JOptionPane.ERROR_MESSAGE);
//
//		} else {
//			b.setUserName(msgName);
//			b.setUserPass(msgPass);
//			// System.out.println(dao.isExistByBorrowId(b));
//			
//			if (dao.isExistByBorrowId(b)) {
//				// System.out.println("0");
//				b = dao.getLocalInfo(b);
//				if (b.getUserStat() == 1) {
//					new ViewFrame();
//					mf.dispose();
//				} else if (b.getUserStat() == 2) {
//					new myFrameInfo(b);
//					mf.dispose();
//				}
//
//			} else {
//				JOptionPane.showMessageDialog(null, "’À∫≈ªÚ√‹¬Î ‰»Î¥ÌŒÛ£°", "¥ÌŒÛ",
//						JOptionPane.ERROR_MESSAGE);
//			}
//		}
//
//	}
//}
