package cn.com.daos.settings;

import java.util.List;

import cn.com.beans.WarehouseBean;


public interface WarehouseDAOInf {
	public List<WarehouseBean> getAllWarehouseInfo();
	public boolean insertWarehouse(WarehouseBean wb);
	public boolean deleteWarehouse(WarehouseBean wb);
	public boolean updateWarehouse(WarehouseBean wb);
	public List<WarehouseBean> queryWarehouse(String s);
	boolean isExistIbfoById(String id);

}
