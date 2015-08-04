package cn.com.daos.settings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.beans.SupplierBean;
import cn.com.util.DBUtil;

public class SupplierDAOImpl implements SupplierDAOInf{

	@Override
	public List<SupplierBean> getAllSupplierInfo() {
		// TODO Auto-generated method stub
		List<SupplierBean> list = new ArrayList<SupplierBean>();
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql="select * from Supplier";
		SupplierBean sb=null;
		try {
			stm=conn.prepareStatement(sql);
			rs=stm.executeQuery();
			while(rs.next()){
				sb=new SupplierBean();
				sb.setSupplier_id(rs.getString("Supplier_id"));
				sb.setSupplier_name(rs.getString("Supplier_name"));
				sb.setSupplier_contact(rs.getString("Supplier_contact"));
				sb.setSupplier_tel(rs.getString("Supplier_tel"));
				sb.setSupplier_addr(rs.getString("Supplier_addr"));
				sb.setSupplier_note(rs.getString("Supplier_note"));
			
				list.add(sb);
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
	public boolean insertSupplier(SupplierBean sb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		String sql = "insert into Supplier values(?,?,?,?,?,?)";
		try {
			stm = conn.prepareStatement(sql);
			
			stm.setString(1, sb.getSupplier_id());
			stm.setString(2, sb.getSupplier_name());
			stm.setString(3, sb.getSupplier_contact());
			stm.setString(4, sb.getSupplier_tel());
			stm.setString(5, sb.getSupplier_addr());
			stm.setString(6, sb.getSupplier_note());
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
	public boolean deleteSupplier(SupplierBean sb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		String sql = "delete from Supplier where Supplier_id = ?";
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, sb.getSupplier_id());
			
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
	public boolean updateSupplier(SupplierBean sb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		String sql = "update Supplier set Supplier_name=?,Supplier_contact=?,Supplier_tel=?,Supplier_addr=?,Supplier_note=? where Supplier_id=?";
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, sb.getSupplier_name());
			stm.setString(2, sb.getSupplier_contact());
			stm.setString(3, sb.getSupplier_tel());
			stm.setString(4, sb.getSupplier_addr());
			stm.setString(5, sb.getSupplier_note());
			stm.setString(6, sb.getSupplier_id());
			
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
	public List<SupplierBean> querySupplier(String s) {
		// TODO Auto-generated method stub
		List<SupplierBean> list = new ArrayList<SupplierBean>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		ResultSet rs = null;
		String sql = "select * from Supplier where Supplier_id like ? or Supplier_name like ?";
		SupplierBean sb=null;
		try {
			stm=conn.prepareStatement(sql);
			stm.setString(1, "%"+s+"%");
			stm.setString(2, "%"+s+"%");
			rs=stm.executeQuery();
			while(rs.next()){
				sb=new SupplierBean();
				sb.setSupplier_id(rs.getString("Supplier_id"));
				sb.setSupplier_name(rs.getString("Supplier_name"));
				sb.setSupplier_contact(rs.getString("Supplier_contact"));
				sb.setSupplier_tel(rs.getString("Supplier_tel"));
				sb.setSupplier_addr(rs.getString("Supplier_addr"));
				sb.setSupplier_note(rs.getString("Supplier_note"));
			
				list.add(sb);
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
		String sql = "select * from Supplier where Supplier_id = ?";
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
