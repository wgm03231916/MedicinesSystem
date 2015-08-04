package cn.com.daos.storage;

import java.util.List;

import cn.com.beans.liu.EmployeeBeans;
import cn.com.beans.liu.HouseCapacityBeans;
import cn.com.beans.liu.MoveBeans;
import cn.com.beans.liu.WarehouseBeans;
import cn.com.beans.view.liu.TransferView;

public interface TransferdaoInf {
	//void List<TransferView> get
	List<TransferView> getAccount(TransferView transferV);
	TransferView getChoose(TransferView transferV);
	List<MoveBeans> searchMoves(String date1,String date2);
	List<MoveBeans> getAllMoves();
	boolean addMoves(MoveBeans movesb);
	boolean updateHouseCapacity(HouseCapacityBeans houseb);
	boolean searchMovesByNo(MoveBeans moveb);
	List<WarehouseBeans> getAllwarehouse();
	List<EmployeeBeans> getAllEmp();
	List<TransferView> getGoodsByMid(MoveBeans movesb);
	
}
