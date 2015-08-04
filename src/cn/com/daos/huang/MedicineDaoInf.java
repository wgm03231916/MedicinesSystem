package cn.com.daos.huang;

import java.util.List;

import cn.com.beans.EmployeeBean;
import cn.com.beans.GoodsBean;
import cn.com.beans.huang.BigAllBean;

public interface MedicineDaoInf {
    List<BigAllBean> getAllSupplierInfo();
    List<BigAllBean> getHouseRootData();
    List<BigAllBean> getSupplierInfoByAll(String msg);
    List<BigAllBean> getGoodsBillB(String msg);
    List<EmployeeBean> getEmployeeInfo();
    List<BigAllBean> getBillInfo2();
    List<BigAllBean> getBillInfo();
    List<BigAllBean> getNewlyInfo();
    boolean addGoodsInfo(GoodsBean g);
    List<BigAllBean> getHistoryInfoByGoodsID(String g);
    List<BigAllBean> getAddGoodsInfo(String name);
    boolean addCJGoodsInfo(BigAllBean g);
    boolean addCJGoodsInfo1(BigAllBean g);
    boolean addCJGoodsInfo2(BigAllBean g);
    boolean isExistByGoodsIdAndHouseID(BigAllBean g);
    boolean UpdateHouseData(BigAllBean g);
    boolean UpdateHouseData2(BigAllBean g);
    List<BigAllBean> getWareHouseByHouseName(String msg);
}
