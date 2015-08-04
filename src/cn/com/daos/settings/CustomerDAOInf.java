package cn.com.daos.settings;

import java.util.List;

import cn.com.beans.CustomerBean;

public interface CustomerDAOInf {
	public List<CustomerBean> getAllCustomerInfo();
	public boolean insertCustomer(CustomerBean cb);
	public boolean deleteCustomer(CustomerBean cb);
	public boolean updateCustomer(CustomerBean cb);
	public List<CustomerBean> queryCustomer(String s);
	boolean isExistIbfoById(String id);

}
