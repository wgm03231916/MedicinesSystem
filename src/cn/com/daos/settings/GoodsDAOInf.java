package cn.com.daos.settings;

import java.util.List;

import cn.com.beans.GoodsBean;


public interface GoodsDAOInf {
	public List<GoodsBean> getAllGoodsInfo();
	public boolean insertGoods(GoodsBean gb);
	public boolean deleteGoods(GoodsBean gb);
	public boolean updateGoods(GoodsBean gb);
	public List<GoodsBean> queryGoods(String s);
	boolean isExistIbfoById(String id);
}
