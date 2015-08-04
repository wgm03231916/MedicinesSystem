package cn.com.daos.settings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.beans.WarehouseBean;
import cn.com.util.DBUtil;

public class WarehouseDAOImpl implements WarehouseDAOInf{
	

	@Override
	public List<WarehouseBean> getAllWarehouseInfo() {
		// TODO Auto-generated method stub
		List<WarehouseBean> list = new ArrayList<WarehouseBean>();
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql="select * from Warehouse";
		WarehouseBean wb=null;
		try {
			stm=conn.prepareStatement(sql);
			rs=stm.executeQuery();
			while(rs.next()){
				wb=new WarehouseBean();
				wb.setWarehouse_id(rs.getString("Warehouse_id"));
				wb.setWarehouse_name(rs.getString("Warehouse_name"));
				wb.setWarehouse_head(rs.getString("Warehouse_head"));
				wb.setWarehouse_tel(rs.getString("Warehouse_tel"));
				wb.setWarehouse_addr(rs.getString("Warehouse_addr"));
				wb.setWarehouse_note(rs.getString("Warehouse_note"));
				list.add(wb);
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
	public boolean insertWarehouse(WarehouseBean wb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		String sql = "insert into Warehouse values(?,?,?,?,?,?)";
		try {
			stm = conn.prepareStatement(sql);
			
			stm.setString(1, wb.getWarehouse_id());
			stm.setString(2, wb.getWarehouse_name());
			stm.setString(3, wb.getWarehouse_head());
			stm.setString(4, wb.getWarehouse_tel());
			stm.setString(5, wb.getWarehouse_addr());
			stm.setString(6, wb.getWarehouse_note());
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
	public boolean deleteWarehouse(WarehouseBean wb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		String sql = "delete from Warehouse where Warehouse_id = ?";
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, wb.getWarehouse_id());
			
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
	public boolean updateWarehouse(WarehouseBean wb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		String sql = "update Warehouse set Warehouse_name=?,Warehouse_head=?,Warehouse_tel=?,Warehouse_addr=?,Warehouse_note=? where Warehouse_id=?";
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, wb.getWarehouse_name());
			stm.setString(2, wb.getWarehouse_head());
			stm.setString(3, wb.getWarehouse_tel());
			stm.setString(4, wb.getWarehouse_addr());
			stm.setString(5, wb.getWarehouse_note());
			stm.setString(6, wb.getWarehouse_id());
			
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
	public List<WarehouseBean> queryWarehouse(String s) {
		// TODO Auto-generated method stub
		List<WarehouseBean> list = new ArrayList<WarehouseBean>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		ResultSet rs = null;
		String sql = "select * from Warehouse where Warehouse_id like ? or Warehouse_name like ?";
		WarehouseBean wb=null;
		try {
			stm=conn.prepareStatement(sql);
			stm.setString(1, "%"+s+"%");
			stm.setString(2, "%"+s+"%");
			rs=stm.executeQuery();
			while(rs.next()){
				wb=new WarehouseBean();
				wb.setWarehouse_id(rs.getString("Warehouse_id"));
				wb.setWarehouse_name(rs.getString("Warehouse_name"));
				wb.setWarehouse_head(rs.getString("Warehouse_head"));
				wb.setWarehouse_tel(rs.getString("Warehouse_tel"));
				wb.setWarehouse_addr(rs.getString("Warehouse_addr"));
				wb.setWarehouse_note(rs.getString("Warehouse_note"));
				list.add(wb);
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
		String sql = "select * from Warehouse where Warehouse_id = ?";
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
