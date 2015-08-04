package cn.com.daos.settings;

import java.util.List;

import cn.com.beans.EmployeeBean;

public interface EmployeeDAOInf {
	public List<EmployeeBean> getAllEmployeeInfo();
	public boolean insertEmployee(EmployeeBean eb);
	public boolean deleteEmployee(EmployeeBean eb);
	public boolean updateEmployee(EmployeeBean eb);
	public List<EmployeeBean> queryEmployee(String s);
	boolean isExistIbfoById(String id);

}
