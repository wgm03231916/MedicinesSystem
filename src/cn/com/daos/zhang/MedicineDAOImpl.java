package cn.com.daos.zhang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.beans.EmployeeBean;
import cn.com.beans.GoodsBean;
import cn.com.beans.HouseCapacityBean;
import cn.com.beans.JTGoodsBean;
import cn.com.beans.OrderRelationBean;
import cn.com.beans.SaleRelationBean;
import cn.com.beans.SupplierBean;
import cn.com.beans.WarehouseBean;
import cn.com.beans.zhang.BigAllBean;
import cn.com.util.DBUtil;

public class MedicineDAOImpl implements MedicineDAoInf{

	@Override
	public List<BigAllBean> getAllSupplierInfo() {
		// TODO Auto-generated method stub
		List<BigAllBean> list=new ArrayList<BigAllBean>();
		Connection conn= DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql="select * from supplier";
		BigAllBean b=null;
		SupplierBean sb=null;
		try {
			stm=conn.prepareStatement(sql);
			rs=stm.executeQuery();
			
			while(rs.next()){
				sb=new SupplierBean();
				b=new BigAllBean();
				b.setSb(sb);
				b.getSb().setSupplier_id(rs.getString("Supplier_Id"));
				b.getSb().setSupplier_name(rs.getString("Supplier_Name"));
				b.getSb().setSupplier_contact(rs.getString("Supplier_Contact"));
				b.getSb().setSupplier_tel(rs.getString("Supplier_Tel"));
				b.getSb().setSupplier_addr(rs.getString("Supplier_Addr"));
				b.getSb().setSupplier_note(rs.getString("Supplier_Note"));
				list.add(b);
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
	public List<BigAllBean> getAllOperatorInfo() {
		// TODO Auto-generated method stub
		List<BigAllBean> list=new ArrayList<BigAllBean>();
		Connection conn= DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql="select * from Employee";
		BigAllBean b=null;
		EmployeeBean eb=null;
		try {
			stm=conn.prepareStatement(sql);
			rs=stm.executeQuery();
			
			while(rs.next()){
				eb=new EmployeeBean();
				b=new BigAllBean();
				b.setEb(eb);
				b.getEb().setEmployee_id(rs.getString("Employee_Id"));
				b.getEb().setEmployee_name(rs.getString("Employee_Name"));
				b.getEb().setEmployee_title(rs.getString("Employee_Title"));
				b.getEb().setEmployee_tel(rs.getString("Employee_Tel"));
				b.getEb().setEmployee_addr(rs.getString("Employee_Addr"));
				b.getEb().setEmployee_note(rs.getString("Employee_Note"));
				list.add(b);
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
	public List<BigAllBean> getSupplierInfoByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BigAllBean> getAllGoodsInfo() {
		// TODO Auto-generated method stub
		List<BigAllBean> list=new ArrayList<BigAllBean>();
		Connection conn= DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql="select * from Goods";
		BigAllBean b=null;
		GoodsBean gb=null;
		try {
			stm=conn.prepareStatement(sql);
			rs=stm.executeQuery();
			
			while(rs.next()){
				gb=new GoodsBean();
				b=new BigAllBean();
				b.setGb(gb);
				b.getGb().setGoods_id(rs.getString("Goods_id"));
				b.getGb().setGoods_Name(rs.getString("Goods_Name"));
				b.getGb().setGoods_type(rs.getString("Goods_type"));
				b.getGb().setGoods_codes(rs.getString("Goods_codes"));
				b.getGb().setGoods_unit(rs.getString("Goods_unit"));
				b.getGb().setGoods_spft(rs.getString("Goods_spft"));
				b.getGb().setGoods_Apvlnum(rs.getString("Goods_Apvlunm"));
				b.getGb().setGoods_setting(rs.getFloat("Goods_setting"));
				b.getGb().setGoods_price(rs.getFloat("Goods_price"));
				b.getGb().setGood_manufacture(rs.getString("Goods_manufacture"));
				b.getGb().setGoods_note(rs.getString("Goods_note"));
			
				
				list.add(b);
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
	public List<BigAllBean> getBillInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addSupplierInfo(BigAllBean u) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		String sql = "insert into supplier values(?,?,?,?,?,?)";
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, u.getSb().getSupplier_id());
			stm.setString(2, u.getSb().getSupplier_name());
			stm.setString(3,u.getSb().getSupplier_contact());
			stm.setString(4, u.getSb().getSupplier_tel());
			stm.setString(5, u.getSb().getSupplier_addr());
			stm.setString(6, u.getSb().getSupplier_note());
			int len = stm.executeUpdate();
			//System.out.println(len+"yyyyyyyyyyyyyyyyyyyy");
			
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
	public boolean updateSupplierInfo(BigAllBean u) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		String sql = "update supplier set Supplier_Id=?,Supplier_Name=?,Supplier_Contact=?,Supplier_Tel=?,Supplier_Addr=?,Supplier_Note=? where Supplier_Id=?";
		boolean bool = false;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, u.getSb().getSupplier_id());
			pstm.setString(2, u.getSb().getSupplier_name());
			pstm.setString(3, u.getSb().getSupplier_contact());
			pstm.setString(4, u.getSb().getSupplier_tel());
			pstm.setString(5, u.getSb().getSupplier_addr());
			pstm.setString(6, u.getSb().getSupplier_note());
			pstm.setString(7, u.getSb().getSupplier_id());
			
			int len = pstm.executeUpdate();
			if(len > 0) {
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.free(pstm, conn);
		}
		return bool;
	}

	@Override
	public boolean addOperatorInfo(BigAllBean u) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		String sql = "insert into Employee values(?,?,?,?,?,?)";
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, u.getEb().getEmployee_id());
			stm.setString(2, u.getEb().getEmployee_name());
			stm.setString(3,u.getEb().getEmployee_title());
			stm.setString(4, u.getEb().getEmployee_tel());
			stm.setString(5, u.getEb().getEmployee_addr());
			stm.setString(6, u.getEb().getEmployee_note());
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
	public boolean delSupplierInfo(BigAllBean u) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		String sql = "delete from supplier where Supplier_Id = ?";
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, u.getSb().getSupplier_id());
			
			
			
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

	public boolean delOperatorInfo(EmployeeBean u) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		String sql = "delete from Employee where Employee_Id = ?";
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, u.getEmployee_id());
			
			
			
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
	public boolean updateGoodsInfo(BigAllBean u) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "update Goods set Goods_Price=? where Goods_id=?";
		boolean bool = false;
		try {
			pstm = conn.prepareStatement(sql);
			
			pstm.setFloat(1, u.getGb().getGoods_price());
			pstm.setString(2, u.getGb().getGoods_id());
			
			
			int len = pstm.executeUpdate();
			if(len > 0) {
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.free(pstm, conn);
		}
		return bool;
	}

	@Override
	public boolean updateOperatorInfo(BigAllBean u) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "update Employee set Employee_Id=?,Employee_Name=?,Employee_Title=?,Employee_Tel=?,Employee_Addr=?,Employee_Note=? where Employee_Id=?";
		boolean bool = false;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,u.getEb().getEmployee_id());
			pstm.setString(2, u.getEb().getEmployee_name());
			pstm.setString(3, u.getEb().getEmployee_title());
			pstm.setString(4, u.getEb().getEmployee_tel());
			pstm.setString(5, u.getEb().getEmployee_addr());
			pstm.setString(6, u.getEb().getEmployee_note());
			pstm.setString(7,u.getEb().getEmployee_id());
			
			int len = pstm.executeUpdate();
			if(len > 0) {
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.free(pstm, conn);
		}
		return bool;
	}

	@Override
	public List<BigAllBean> getSupplier_GoodsInfo() {
		// TODO Auto-generated method stub
		List<BigAllBean> list=new ArrayList<BigAllBean>();
		Connection conn= DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql="select * from supplier_goods";
		BigAllBean b=null;
		SupplierBean sb=null;
		SaleRelationBean srb = null;
		JTGoodsBean jt = null;
		WarehouseBean wb = null;
		GoodsBean gb = null;
		HouseCapacityBean h=null;
		try {
			stm=conn.prepareStatement(sql);
			rs=stm.executeQuery();
			
			while(rs.next()){
				sb=new SupplierBean();
				jt=new JTGoodsBean();
				wb=new WarehouseBean();
				b=new BigAllBean();
				h=new HouseCapacityBean();
				b.setSb(sb);
				b.setGb(gb);
				b.setSr(srb);
				b.setWb(wb);
				b.setJt(jt);
				b.setH(h);
				b.getJt().setOrder_id(rs.getString("s_id"));
				b.getWb().setWarehouse_name(rs.getString("s_name"));
				System.out.println(rs.getFloat("s_price"));
				b.getJt().setOrder_price(rs.getFloat("s_price"));
				b.getJt().setOrder_head(rs.getString("s_people"));
				b.getJt().setOrder_type(rs.getString("s_type"));
				
				
				list.add(b);
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
	public List<BigAllBean> getGoodInfo(String mag) {
		// TODO Auto-generated method stub
		List<BigAllBean> list=new ArrayList<BigAllBean>();
		Connection conn= DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql="select g_id,g_name,g_unit,g_price,g_num,g_sum from good where g_order=? ";
		BigAllBean b=null;
		SupplierBean sb=null;
		SaleRelationBean srb = null;
		JTGoodsBean jt = null;
		WarehouseBean wb = null;
		GoodsBean gb = null;
		HouseCapacityBean h=null;
		OrderRelationBean or=null;
		try {
			stm=conn.prepareStatement(sql);
			stm.setString(1, mag);
			rs=stm.executeQuery();
			
			while(rs.next()){
				or=new OrderRelationBean();
				sb=new SupplierBean();
				jt=new JTGoodsBean();
				wb=new WarehouseBean();
				b=new BigAllBean();
				h=new HouseCapacityBean();
				gb=new GoodsBean();
				b.setOr(or);
				b.setSb(sb);
				b.setGb(gb);
				b.setSr(srb);
				b.setWb(wb);
				b.setJt(jt);
				b.setH(h);
				b.getGb().setGoods_id(rs.getString("g_id"));
				b.getGb().setGoods_Name(rs.getString("g_name"));
				//System.out.println(rs.getFloat("s_price"));
				b.getGb().setGoods_unit(rs.getString("g_unit"));
				b.getGb().setGoods_setting(rs.getFloat("g_price"));
				b.getOr().setGoods_num(rs.getInt("g_num"));
				
				b.getOr().setOrder_price(rs.getFloat("g_sum"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, stm, conn);
		}
		
		return list;
	}

	

}
