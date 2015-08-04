package cn.com.daos.zhang;

import java.util.List;

import cn.com.beans.EmployeeBean;
import cn.com.beans.zhang.BigAllBean;



public interface MedicineDAoInf {
	List<BigAllBean> getAllSupplierInfo();
    List<BigAllBean> getAllOperatorInfo();
    List<BigAllBean> getSupplierInfoByAll();
    List<BigAllBean> getAllGoodsInfo();
    List<BigAllBean> getBillInfo();
    List<BigAllBean> getSupplier_GoodsInfo();
    List<BigAllBean> getGoodInfo(String mag);
    boolean addSupplierInfo(BigAllBean u);
    boolean addOperatorInfo(BigAllBean u);
    boolean updateSupplierInfo(BigAllBean u);
    boolean updateGoodsInfo(BigAllBean u);
    boolean updateOperatorInfo(BigAllBean u);
    boolean delSupplierInfo(BigAllBean u);
    boolean delOperatorInfo(EmployeeBean u);
}
