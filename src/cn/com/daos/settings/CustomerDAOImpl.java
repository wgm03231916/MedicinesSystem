package cn.com.daos.settings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.beans.CustomerBean;
import cn.com.util.DBUtil;

public class CustomerDAOImpl implements CustomerDAOInf {
	

	@Override
	public List<CustomerBean> getAllCustomerInfo() {
		// TODO Auto-generated method stub
		List<CustomerBean> list = new ArrayList<CustomerBean>();
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement stm = null;
		String sql = "select * from Customer";
		CustomerBean cb = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				cb = new CustomerBean();
				cb.setCustomer_id(rs.getString("Customer_id"));
				cb.setCustomer_name(rs.getString("Customer_name"));
				cb.setCustomer_contact(rs.getString("Customer_contact"));
				cb.setCustomer_tel(rs.getString("Customer_tel"));
				cb.setCustomer_addr(rs.getString("Customer_addr"));
				cb.setCustomer_note(rs.getString("Customer_note"));
				
				list.add(cb);
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
	public boolean insertCustomer(CustomerBean cb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm =null;
		String sql = "insert into Customer values(?,?,?,?,?,?)";
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, cb.getCustomer_id());
			stm.setString(2, cb.getCustomer_name());
			stm.setString(3, cb.getCustomer_contact());
			stm.setString(4, cb.getCustomer_tel());
			stm.setString(5, cb.getCustomer_addr());
			stm.setString(6, cb.getCustomer_note());
			int len = stm.executeUpdate();
			if(len > 0){
				bool = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(stm, conn);
		}
		return bool;
	
	}

	@Override
	public boolean deleteCustomer(CustomerBean cb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		String sql = "delete from Customer where Customer_id = ?";
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, cb.getCustomer_id());
			
			int len = stm.executeUpdate();
			if(len > 0){
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(stm, conn);
		}
		return bool;
	}

	@Override
	public boolean updateCustomer(CustomerBean cb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		String sql = "update Customer set Customer_name=?,Customer_contact=?,Customer_tel=?,Customer_addr=?,Customer_note=? where Customer_id=?";
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, cb.getCustomer_name());
			stm.setString(2, cb.getCustomer_contact());
			stm.setString(3, cb.getCustomer_tel());
			stm.setString(4, cb.getCustomer_addr());
			stm.setString(5, cb.getCustomer_note());
			stm.setString(6, cb.getCustomer_id());
			
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
	public List<CustomerBean> queryCustomer(String s) {
		// TODO Auto-generated method stub
		List<CustomerBean> list = new ArrayList<CustomerBean>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		ResultSet rs = null;
		String sql = "select * from Customer where Customer_id like ? or Customer_name like ?";
		CustomerBean cb=null;
		try {
			stm=conn.prepareStatement(sql);
			stm.setString(1, "%"+s+"%");
			stm.setString(2, "%"+s+"%");
			rs=stm.executeQuery();
			while(rs.next()){
				cb=new CustomerBean();
				cb.setCustomer_id(rs.getString("Customer_id"));
				cb.setCustomer_name(rs.getString("Customer_name"));
				cb.setCustomer_contact(rs.getString("Customer_contact"));
				cb.setCustomer_tel(rs.getString("Customer_tel"));
				cb.setCustomer_addr(rs.getString("Customer_addr"));
				cb.setCustomer_note(rs.getString("Customer_note"));
				
				list.add(cb);
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
		String sql = "select * from Customer where Customer_id = ?";
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
