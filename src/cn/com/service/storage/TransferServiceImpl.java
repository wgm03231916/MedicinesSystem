package cn.com.service.storage;

import java.util.List;

import cn.com.beans.liu.EmployeeBeans;
import cn.com.beans.liu.HouseCapacityBeans;
import cn.com.beans.liu.MoveBeans;
import cn.com.beans.liu.WarehouseBeans;
import cn.com.beans.view.liu.TransferView;
import cn.com.daos.storage.TransferdaoImpl;
import cn.com.daos.storage.TransferdaoInf;

public class TransferServiceImpl implements TransferServiceInf{
	private TransferdaoInf trsDAO;
	
	public TransferServiceImpl() {
		trsDAO = new TransferdaoImpl();
	}

	@Override
	public boolean addMovesServiceInf(MoveBeans movesb) {
		// TODO Auto-generated method stub
		
		return trsDAO.addMoves(movesb);
	}

	@Override
	public List<TransferView> getAccountServiceInf(TransferView transferV) {
		// TODO Auto-generated method stub
		return trsDAO.getAccount(transferV);
	}

	@Override
	public TransferView getChooseServiceInf(TransferView transferV) {
		// TODO Auto-generated method stub
		return trsDAO.getChoose(transferV);
	}

	//@Override
//	public boolean searchMovesByNoServiceInf(MoveBeans moveb) {
//		// TODO Auto-generated method stub
//		if(trsDAO.searchMovesByNo(moveb)) {
//			moveb.getMove_id().substring(10);
//		}else {
//			 
//		}
////if(trsDAO.searchMovesByNo(movesb)) {
////			
////			
////			//txt_billNo.setText(s);
////		}else {
////			Date now = new Date();
////			SimpleDateFormat simpl = new SimpleDateFormat("yyyyMMdd");
////			String s = "DB" + simpl.format(now) +"000";
////		}
//		return false;
//	}


	@Override
	public boolean updateHouseCapacityServiceInf(HouseCapacityBeans houseb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<WarehouseBeans> getAllwarehouseServiceInf() {
		// TODO Auto-generated method stub
		return trsDAO.getAllwarehouse();
		
	}

	@Override
	public List<EmployeeBeans> getAllEmp() {
		// TODO Auto-generated method stub
		return trsDAO.getAllEmp();
	}

	@Override
	public String ismoveId(String moveId) {
		// TODO Auto-generated method stub
		String move_id = moveId;
		MoveBeans moveb = new MoveBeans();
		moveb.setMove_id(moveId);
		if(trsDAO.searchMovesByNo(moveb)) {
			String s1=moveId.substring(0,10);
			//String s2 = moveId.substring(10);
			int num = Integer.parseInt(moveId.substring(10));
			List<MoveBeans> mlist = trsDAO.getAllMoves();
			for(MoveBeans m:mlist) {
				
				String s = m.getMove_id();
				String s2 = s.substring(0,10);
				System.out.println(s);
				if(s1.equals(s2)) {
					int num2  = Integer.parseInt(s.substring(10));
					if(num2 >= num) {
						num = num2+1;
						System.out.println(num);
					}
					System.out.println(num);
					moveId = s1+String.format("%04d",num);
					move_id=moveId;
					System.out.println(move_id);
					
				}
			}
		}
		return move_id;
	}

	@Override
	public List<MoveBeans> searchMovesServiceInf(String date1, String date2) {
		
		// TODO Auto-generated method stub
		return trsDAO.searchMoves(date1, date2);
	}

	@Override
	public List<TransferView> getGoodsByMid(MoveBeans movesb) {
		// TODO Auto-generated method stub
		return trsDAO.getGoodsByMid(movesb);
	}
	

}
