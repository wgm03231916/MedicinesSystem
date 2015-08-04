package cn.com.daos.market.wang;

import java.util.List;

import cn.com.beans.GoodsBean;
import cn.com.beans.wang.BigBeans;



public interface GoodsBeansDAOInf {
	List<BigBeans> getAllGoodsinfo();
	public boolean deletegoods(BigBeans bb);
	public boolean updategoods(BigBeans bb);
	List<BigBeans> getAllMessage();
	List<BigBeans> getMessageById(GoodsBean gb);
	List<BigBeans> getAllCustomerMess();
	List<BigBeans> getAllCustomerPrice();
	public boolean deleteCustomerById(BigBeans bb);
	public boolean addOrderRelationManger(BigBeans b);
	public boolean addGoodsSaleManger(BigBeans bb);
	public boolean addGoodsManger(BigBeans bb);
	public boolean updateHouseCapacityMangerByNum(BigBeans bb);
	public boolean addCustomerManger(BigBeans bb);

}
