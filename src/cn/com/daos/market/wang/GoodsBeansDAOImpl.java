package cn.com.daos.market.wang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.beans.CustomerBean;
import cn.com.beans.GoodsBean;
import cn.com.beans.GoodsSaleBean;
import cn.com.beans.HouseCapacityBean;
import cn.com.beans.OrderRelationBean;
import cn.com.beans.SaleRelationBean;
import cn.com.beans.wang.BigBeans;
import cn.com.util.DBUtil;

public class GoodsBeansDAOImpl implements GoodsBeansDAOInf {

	@Override
	public List<BigBeans> getAllGoodsinfo() {
		// TODO Auto-generated method stub
		List<BigBeans> list = new ArrayList<BigBeans>();
		Connection conn=cn.com.util.DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql = "select * from goodsHouseCapacity";
		BigBeans bb = null;
		GoodsBean gb = null;
		HouseCapacityBean hcb = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			
			while(rs.next()){
				gb = new GoodsBean();
				bb = new BigBeans();
				hcb = new HouseCapacityBean();
				bb.setGb(gb);
				bb.setHcb(hcb);
				bb.getGb().setGoods_id(rs.getString("Goods_id"));
				bb.getGb().setGoods_Name(rs.getString("Goods_Name"));
				bb.getGb().setGoods_type(rs.getString("Goods_type"));
				bb.getGb().setGoods_codes(rs.getString("Goods_codes"));
				bb.getGb().setGoods_unit(rs.getString("Goods_unit"));
				bb.getGb().setGoods_spft(rs.getString("Goods_spft"));
				bb.getGb().setGoods_Apvlnum(rs.getString("Goods_Apvlunm"));
				
				bb.getGb().setGoods_price(rs.getFloat("Goods_price"));
				bb.getGb().setGood_manufacture(rs.getString("Goods_manufacture"));
				bb.getGb().setGoods_note(rs.getString("Goods_note"));
				bb.getHcb().setGoods_num(rs.getInt("Goods_num"));
				
				list.add(bb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, stm, conn);
		}
		return list;
	}

	@Override
	public boolean deletegoods(BigBeans bb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql = "update goodsHouseCapacity set Goods_num=?,Goods_price=?,Goods_codes=?";
		
		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, bb.getHcb().getGoods_num());
			stm.setFloat(2, bb.getGb().getGoods_price());
			stm.setString(3, bb.getGb().getGoods_codes());
			int len = stm.executeUpdate();
			if(len > 0) {
				bool = true;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, stm, conn);
		}
		return bool;
	}

	@Override
	public boolean updategoods(BigBeans bb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql = "delete from goods where Goods_Name = ?";
		
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, bb.getGb().getGoods_Name());
			int len = stm.executeUpdate();
			if(len > 0){
				bool = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, stm, conn);
		}
		return bool;
	}

	@Override
	public List<BigBeans> getAllMessage() {
		// TODO Auto-generated method stub
		List<BigBeans> list = new ArrayList<BigBeans>();
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql = "select * from goodsOrderRelation";
		BigBeans bb = null;
		GoodsBean gb = null;
		OrderRelationBean orb = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			
			while(rs.next()){
				gb = new GoodsBean();
				bb = new BigBeans();
				orb = new OrderRelationBean();
				bb.setGb(gb);
				bb.setOrb(orb);
				bb.getGb().setGoods_id(rs.getString("Goods_id"));
				bb.getGb().setGoods_Name(rs.getString("Goods_Name"));
				bb.getGb().setGoods_type(rs.getString("Goods_type"));
				bb.getGb().setGoods_codes(rs.getString("Goods_codes"));
				bb.getGb().setGoods_unit(rs.getString("Goods_unit"));
				bb.getGb().setGoods_spft(rs.getString("Goods_spft"));
				bb.getGb().setGoods_Apvlnum(rs.getString("Goods_Apvlunm"));
				bb.getGb().setGoods_price(rs.getFloat("Goods_price"));
				bb.getGb().setGood_manufacture(rs.getString("Goods_manufacture"));
				bb.getGb().setGoods_note(rs.getString("Goods_note"));
				bb.getOrb().setOrder_id(rs.getString("Order_id"));
				bb.getOrb().setGoods_num(rs.getInt("Goods_num"));
				bb.getOrb().setOrder_price(rs.getFloat("Order_price"));
				bb.getOrb().setGoods_validity(rs.getString("Goods_validity"));
				
				list.add(bb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, stm, conn);
		}
		return list;
	}

	@Override
	public List<BigBeans> getMessageById(GoodsBean gsb) {
		// TODO Auto-generated method stub
		List<BigBeans> list = new ArrayList<BigBeans>();
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql = "select * from goodsOrderHouseCapacity where goods_id = ?";
		BigBeans bb = null;
		GoodsBean gb = null;
		OrderRelationBean orb = null;
		HouseCapacityBean hcb = null;
//		gb = new GoodsBean();
		gb=gsb;
		bb = new BigBeans();
		hcb = new HouseCapacityBean();
		orb = new OrderRelationBean();
		bb.setGb(gb);
		bb.setOrb(orb);
		bb.setHcb(hcb);
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, bb.getGb().getGoods_id());
			rs = stm.executeQuery();
			
			if(rs.next()){
				bb.getGb().setGoods_id(rs.getString("Goods_id"));
				bb.getGb().setGoods_Name(rs.getString("Goods_Name"));
				bb.getGb().setGoods_type(rs.getString("Goods_type"));
				bb.getGb().setGoods_unit(rs.getString("Goods_unit"));
				bb.getHcb().setGoods_num(rs.getInt("Goods_num"));
				bb.getGb().setGoods_Apvlnum(rs.getString("Goods_Apvlunm"));
				bb.getGb().setGood_manufacture(rs.getString("Goods_manufacture"));
				bb.getGb().setGoods_note(rs.getString("Goods_note"));
				bb.getGb().setGoods_price(rs.getFloat("Goods_price"));
				bb.getGb().setGoods_codes(rs.getString("Goods_codes"));
				bb.getOrb().setGoods_validity(rs.getString("Goods_validity"));
				
				
				list.add(bb);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, stm, conn);
		}
		return list;
	}

	@Override
	public List<BigBeans> getAllCustomerMess() {
		// TODO Auto-generated method stub
		List<BigBeans> list = new ArrayList<BigBeans>();
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql = "select * from customerGSaleRelation";
		BigBeans bb = null;
		CustomerBean cb = null;
		GoodsSaleBean gsb = null;
		SaleRelationBean srb = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			
			while(rs.next()){
				cb = new CustomerBean();
				bb = new BigBeans();
				gsb = new GoodsSaleBean();
				srb = new SaleRelationBean();
				bb.setCb(cb);
				bb.setGsb(gsb);
				bb.setSrb(srb);
				bb.getCb().setCustomer_name(rs.getString("Customer_name"));
				bb.getGsb().setSale_date(rs.getString("Sale_date"));
				bb.getGsb().setSale_id(rs.getString("Sale_id"));
				bb.getSrb().setSale_price(rs.getFloat("Sale_sumprice"));
				bb.getGsb().setSale_people(rs.getString("Sale_people"));
				bb.getGsb().setSale_note(rs.getString("Sale_note"));
				list.add(bb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, stm, conn);
		}
		return list;

	}

	@Override
	public List<BigBeans> getAllCustomerPrice() {
		// TODO Auto-generated method stub
		List<BigBeans> list = new ArrayList<BigBeans>();
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql = "select * from goodsHouseCapacitySale";
		BigBeans bb = null;
		GoodsBean gb = null;
		HouseCapacityBean hcb = null;
		SaleRelationBean srb = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			
			while(rs.next()){
				gb = new GoodsBean();
				bb = new BigBeans();
				hcb = new HouseCapacityBean();
				srb = new SaleRelationBean();
				bb.setGb(gb);
				bb.setHcb(hcb);
				bb.setSrb(srb);
				bb.getGb().setGoods_id(rs.getString("Goods_id"));
				bb.getGb().setGoods_Name(rs.getString("Goods_Name"));
				bb.getGb().setGoods_unit(rs.getString("Goods_unit"));
				bb.getSrb().setSale_num(rs.getInt("Sale_num"));
				bb.getSrb().setSale_price(rs.getFloat("Sale_price"));
				bb.getHcb().setGoods_num(rs.getInt("Goods_num"));
				bb.getGb().setGoods_spft(rs.getString("Goods_spft"));
				bb.getGb().setGood_manufacture(rs.getString("Goods_manufacture"));
				bb.getGb().setGoods_note(rs.getString("Goods_note"));
				list.add(bb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, stm, conn);
		}
		return list;

	}

	@Override
	public boolean deleteCustomerById(BigBeans bb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql = "update customerGSaleRelation set Customer_name=?";
		
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, bb.getCb().getCustomer_name());
			
			int len = stm.executeUpdate();
			if(len > 0) {
				bool = true;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, stm, conn);
		}
		return bool;
	}

	@Override
	public boolean addOrderRelationManger(BigBeans b) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql = "insert into goods values(?,?,to_date(?,'yyyy-MM-dd '))";
		
		
		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, b.getOrb().getGoods_num());
			stm.setFloat(2, b.getOrb().getOrder_price());
			stm.setString(3, b.getOrb().getGoods_validity());
			int len = stm.executeUpdate();
			if(len > 0) {
				bool = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, stm, conn);
		}
		return bool;
	}

	@Override
	public boolean addGoodsSaleManger(BigBeans b) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql = "insert into GoodsSale values(to_date(?,'yyyy-MM-dd '),?)";
	
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, b.getGsb().getSale_date());
			stm.setString(2, b.getGsb().getSale_people());
			int len = stm.executeUpdate();
			if(len > 0) {
				bool = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, stm, conn);
		}
		return bool;
	}

	@Override
	public boolean addGoodsManger(BigBeans b) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql = "insert into Goods values(?,?,?)";
		
	
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, b.getGb().getGoods_Name());
			stm.setString(2, b.getGb().getGoods_unit());
			stm.setString(3, b.getGb().getGoods_Apvlnum());
			
			int len = stm.executeUpdate();
			if(len > 0) {
				bool = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, stm, conn);
		}
		return bool;
	}

	@Override
	public boolean updateHouseCapacityMangerByNum(BigBeans b) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql = "update HouseCapacity set Goods_num=? ";
		
	
		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, b.getHcb().getGoods_num()-b.getOrb().getGoods_num());
			
			int len = stm.executeUpdate();
			if(len > 0) {
				bool = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, stm, conn);
		}
		return bool;
	}

	@Override
	public boolean addCustomerManger(BigBeans b) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql = "insert into Customer values(?,?)";
		
	
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, b.getCb().getCustomer_name());
			stm.setString(2, b.getCb().getCustomer_note());
			
			int len = stm.executeUpdate();
			if(len > 0) {
				bool = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, stm, conn);
		}
		return bool;
	}
	}
