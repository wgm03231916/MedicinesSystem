package cn.com.service.storage;

import java.util.List;

import cn.com.beans.liu.EmployeeBeans;
import cn.com.beans.liu.HouseCapacityBeans;
import cn.com.beans.liu.MoveBeans;
import cn.com.beans.liu.WarehouseBeans;
import cn.com.beans.view.liu.TransferView;



public interface TransferServiceInf {
	List<TransferView> getAccountServiceInf(TransferView transferV);
	TransferView getChooseServiceInf(TransferView transferV);
	List<MoveBeans> searchMovesServiceInf(String date1,String date2);
	boolean addMovesServiceInf(MoveBeans movesb);
	boolean updateHouseCapacityServiceInf(HouseCapacityBeans houseb);
	//boolean searchMovesByNoServiceInf(MoveBeans moveb);
	List<WarehouseBeans> getAllwarehouseServiceInf();
	List<EmployeeBeans> getAllEmp();
	String ismoveId(String move_id);
	List<TransferView> getGoodsByMid(MoveBeans movesb);
}
