package cn.com.daos.settings;

import java.util.List;

import cn.com.beans.SupplierBean;


public interface SupplierDAOInf {
	public List<SupplierBean> getAllSupplierInfo();
	public boolean insertSupplier(SupplierBean sb);
	public boolean deleteSupplier(SupplierBean sb);
	public boolean updateSupplier(SupplierBean sb);
	public List<SupplierBean> querySupplier(String s);
	boolean isExistIbfoById(String id);


}
