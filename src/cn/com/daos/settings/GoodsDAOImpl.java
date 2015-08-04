package cn.com.daos.settings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.beans.GoodsBean;
import cn.com.util.DBUtil;

public class GoodsDAOImpl implements GoodsDAOInf{

	@Override
	public List<GoodsBean> getAllGoodsInfo() {
		// TODO Auto-generated method stub
		List<GoodsBean> list = new ArrayList<GoodsBean>();
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql="select * from Goods";
		GoodsBean gb=null;
		try {
			stm=conn.prepareStatement(sql);
			rs=stm.executeQuery();
			while(rs.next()){
				gb=new GoodsBean();
				gb.setGoods_id(rs.getString("Goods_id"));
				gb.setGoods_Name(rs.getString("Goods_Name"));
				gb.setGoods_type(rs.getString("Goods_type"));
				gb.setGoods_codes(rs.getString("Goods_codes"));
				gb.setGoods_unit(rs.getString("Goods_unit"));
				gb.setGoods_spft(rs.getString("Goods_spft"));
				gb.setGoods_Apvlnum(rs.getString("Goods_Apvlunm"));
				gb.setGoods_setting(rs.getFloat("Goods_setting"));
				gb.setGoods_price(rs.getFloat("Goods_price"));
				gb.setGood_manufacture(rs.getString("Goods_manufacture"));
				gb.setGoods_note(rs.getString("Goods_note"));
				list.add(gb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBUtil.free(rs, stm, conn);
		}
		
		return list;
	}

	@Override
	public boolean insertGoods(GoodsBean gb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		String sql = "insert into Goods values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, gb.getGoods_id());
			stm.setString(2, gb.getGoods_Name());
			stm.setString(3, gb.getGoods_type());
			stm.setString(4, gb.getGoods_codes());
			stm.setString(5, gb.getGoods_unit());
			stm.setString(6, gb.getGoods_spft());
			stm.setString(7, gb.getGoods_Apvlnum());
			stm.setFloat(8, gb.getGoods_setting());
			stm.setFloat(9, gb.getGoods_price());
			stm.setString(10, gb.getGood_manufacture());
			stm.setString(11, gb.getGoods_note());
			
			int len = stm.executeUpdate();
			if(len > 0){
				bool = true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			DBUtil.free(stm, conn);
		}
		return bool;
	}

	@Override
	public boolean deleteGoods(GoodsBean gb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		String sql = "delete from Goods where Goods_id = ?";
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, gb.getGoods_id());
			
			int len = stm.executeUpdate();
			if(len > 0){
				bool = true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			DBUtil.free(stm, conn);
		}
		return bool;
	}

	@Override
	public boolean updateGoods(GoodsBean gb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		String sql = "update Goods set Goods_Name=?,Goods_type=?,Goods_codes=?,Goods_unit=?," +
				"Goods_spft=?,Goods_Apvlunm=?,Goods_setting=?,Goods_price=?,Goods_manufacture=?,Goods_note=? where Goods_id=?";
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, gb.getGoods_Name());
			stm.setString(2, gb.getGoods_type());
			stm.setString(3, gb.getGoods_codes());
			stm.setString(4, gb.getGoods_unit());
			stm.setString(5, gb.getGoods_spft());
			stm.setString(6, gb.getGoods_Apvlnum());
			stm.setFloat(7, gb.getGoods_setting());
			stm.setFloat(8, gb.getGoods_price());
			stm.setString(9, gb.getGood_manufacture());
			stm.setString(10, gb.getGoods_note());
			stm.setString(11, gb.getGoods_id());
			
			int len = stm.executeUpdate();
			if(len > 0){
				bool = true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			DBUtil.free(stm, conn);
		}
		return bool;
	}

	@Override
	public  List<GoodsBean> queryGoods(String s) {
		// TODO Auto-generated method stub
		List<GoodsBean> list = new ArrayList<GoodsBean>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		ResultSet rs = null;
		String sql = "select * from Goods where Goods_id like ? or Goods_name like ?";
		GoodsBean gb=null;
		try {
			stm=conn.prepareStatement(sql);
			stm.setString(1, "%"+s+"%");
			stm.setString(2, "%"+s+"%");
			rs=stm.executeQuery();
			while(rs.next()){
				gb=new GoodsBean();
				gb.setGoods_id(rs.getString("Goods_id"));
				gb.setGoods_Name(rs.getString("Goods_Name"));
				gb.setGoods_type(rs.getString("Goods_type"));
				gb.setGoods_codes(rs.getString("Goods_codes"));
				gb.setGoods_unit(rs.getString("Goods_unit"));
				gb.setGoods_spft(rs.getString("Goods_spft"));
				gb.setGoods_Apvlnum(rs.getString("Goods_Apvlunm"));
				gb.setGoods_setting(rs.getFloat("Goods_setting"));
				gb.setGoods_price(rs.getFloat("Goods_price"));
				gb.setGood_manufacture(rs.getString("Goods_manufacture"));
				gb.setGoods_note(rs.getString("Goods_note"));
				list.add(gb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBUtil.free(rs, stm, conn);
		}
		return list;
	}

	@Override
	public boolean isExistIbfoById(String id) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		String sql = "select * from Goods where Goods_id=?";
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, id);
			int len = stm.executeUpdate();
			if(len > 0){
				bool = true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			DBUtil.free(stm, conn);
		}
		return bool;
	}

}
