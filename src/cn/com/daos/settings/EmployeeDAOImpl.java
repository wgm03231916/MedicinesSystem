package cn.com.daos.settings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.beans.EmployeeBean;
import cn.com.util.DBUtil;

public class EmployeeDAOImpl implements EmployeeDAOInf{

	@Override
	public List<EmployeeBean> getAllEmployeeInfo() {
		// TODO Auto-generated method stub
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement stm = null;
		String sql = "select * from Employee";
		EmployeeBean eb = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				eb = new EmployeeBean();
				eb.setEmployee_id(rs.getString("Employee_id"));
				eb.setEmployee_name(rs.getString("Employee_name"));
				eb.setEmployee_title(rs.getString("Employee_title"));
				eb.setEmployee_tel(rs.getString("Employee_tel"));
				eb.setEmployee_addr(rs.getString("Employee_addr"));
				eb.setEmployee_note(rs.getString("Employee_note"));

				list.add(eb);
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
	public boolean insertEmployee(EmployeeBean eb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm =null;
		String sql = "insert into Employee values(?,?,?,?,?,?)";
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, eb.getEmployee_id());
			stm.setString(2, eb.getEmployee_name());
			stm.setString(3, eb.getEmployee_title());
			stm.setString(4, eb.getEmployee_tel());
			stm.setString(5, eb.getEmployee_addr());
			stm.setString(6, eb.getEmployee_note());
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
	public boolean deleteEmployee(EmployeeBean eb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		String sql = "delete from Employee where Employee_id = ?";
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, eb.getEmployee_id());
			
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
	public boolean updateEmployee(EmployeeBean eb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm =null;
		String sql = "update Employee set Employee_name=?,Employee_title=?,Employee_tel=?,Employee_addr=?,Employee_note=? where Employee_id=?";
		try {
			stm = conn.prepareStatement(sql);
			
			stm.setString(1, eb.getEmployee_name());
			stm.setString(2, eb.getEmployee_title());
			stm.setString(3, eb.getEmployee_tel());
			stm.setString(4, eb.getEmployee_addr());
			stm.setString(5, eb.getEmployee_note());
			stm.setString(6, eb.getEmployee_id());
			
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
	public List<EmployeeBean> queryEmployee(String s) {
		// TODO Auto-generated method stub
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		ResultSet rs = null;
		String sql = "select * from Employee where Employee_id like ? or Employee_name like ?";
		EmployeeBean eb=null;
		try {
			stm=conn.prepareStatement(sql);
			stm.setString(1, "%"+s+"%");
			stm.setString(2, "%"+s+"%");
			rs=stm.executeQuery();
			while(rs.next()){
				eb=new EmployeeBean();
				eb.setEmployee_id(rs.getString("Employee_id"));
				eb.setEmployee_name(rs.getString("Employee_name"));
				eb.setEmployee_title(rs.getString("Employee_title"));
				eb.setEmployee_tel(rs.getString("Employee_tel"));
				eb.setEmployee_addr(rs.getString("Employee_addr"));
				eb.setEmployee_note(rs.getString("Employee_note"));
				
				list.add(eb);
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
		String sql = "select * from Employee where Employee_id = ?";
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
