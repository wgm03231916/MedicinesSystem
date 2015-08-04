package cn.com.daos.huang;

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
import cn.com.beans.SupplierBean;
import cn.com.beans.WarehouseBean;
import cn.com.beans.huang.BigAllBean;
import cn.com.util.DBUtil;

public class MedicineDaoImp implements MedicineDaoInf {

	@Override
	public List<BigAllBean> getAllSupplierInfo() {
		// TODO Auto-generated method stub
		List<BigAllBean> list=new ArrayList<BigAllBean>();
		Connection conn=DBUtil.getConnection();
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
	public List<BigAllBean> getHouseRootData() {
		// TODO Auto-generated method stub
		List<BigAllBean> list=new ArrayList<BigAllBean>();
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql="select * from Warehouse";
		BigAllBean b=null;
		WarehouseBean wb=null;
		try {
			stm=conn.prepareStatement(sql);
			rs=stm.executeQuery();
			while(rs.next()){
				wb=new WarehouseBean();
				b=new BigAllBean();
				b.setWb(wb);
				b.getWb().setWarehouse_id(rs.getString("Warehouse_id"));
				b.getWb().setWarehouse_name(rs.getString("Warehouse_name"));
				b.getWb().setWarehouse_head(rs.getString("Warehouse_head"));
				b.getWb().setWarehouse_tel(rs.getString("Warehouse_tel"));
				b.getWb().setWarehouse_addr(rs.getString("Warehouse_addr"));
				b.getWb().setWarehouse_note(rs.getString("Warehouse_note"));
				list.add(b);
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
	public List<BigAllBean> getSupplierInfoByAll(String msg) {
		// TODO Auto-generated method stub
		List<BigAllBean> list=new ArrayList<BigAllBean>();
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql="select * from Supplier where Supplier.Supplier_Id like ? or Supplier.Supplier_Name like ? or Supplier.Supplier_contact like ?" +
				"or Supplier.Supplier_tel like ? or Supplier.Supplier_addr like ?";
		BigAllBean b=null;
		SupplierBean sb=null;
		try {
			stm=conn.prepareStatement(sql);
			stm.setString(1,"%"+msg+"%");
			stm.setString(2,"%"+msg+"%");
			stm.setString(3,"%"+msg+"%");
			stm.setString(4,"%"+msg+"%");
			stm.setString(5,"%"+msg+"%");
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
			DBUtil.free(rs,stm, conn);
		}
		return list;
	}

	@Override
	public List<EmployeeBean> getEmployeeInfo() {
		// TODO Auto-generated method stub
		List<EmployeeBean> list=new ArrayList<EmployeeBean>();
		Connection conn=DBUtil.getConnection();
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
				//b=new BigAllBean();
				//b.setJb(jb);
				eb.setEmployee_id(rs.getString("Employee_Id"));
				eb.setEmployee_name(rs.getString("Employee_Name"));
				eb.setEmployee_title(rs.getString("Employee_Title"));
				eb.setEmployee_tel(rs.getString("Employee_Tel"));
				eb.setEmployee_addr(rs.getString("Employee_Addr"));
				eb.setEmployee_note(rs.getString("Employee_Note"));
				
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
	public List<BigAllBean> getBillInfo() {
		// TODO Auto-generated method stub
		List<BigAllBean> list=new ArrayList<BigAllBean>();
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql="select * from View_Bill2";
		BigAllBean b=null;
		GoodsBean gb=null;
		HouseCapacityBean hb=null;
		//OrderRelationBean ob=null;
		try {
			stm=conn.prepareStatement(sql);
			rs=stm.executeQuery();
			while(rs.next()){
				//jb=new JTGoodsBean();
				b=new BigAllBean();
				gb=new GoodsBean();
				hb=new HouseCapacityBean();
				//ob=new OrderRelationBean();
				b.setGb(gb);
				//b.setOb(ob);
				b.setHc(hb);
		        b.getGb().setGoods_id(rs.getString("Goods_id"));
		        b.getGb().setGoods_Name(rs.getString("Goods_name"));
		        b.getGb().setGoods_unit(rs.getString("Goods_unit"));
		        b.getGb().setGoods_spft(rs.getString("Goods_spft"));
		        b.getGb().setGoods_setting(rs.getFloat("Goods_price"));
		        b.getHc().setGoods_num(rs.getInt("Goods_num"));
		        b.getGb().setGood_manufacture(rs.getString("Goods_facture"));
		        list.add(b);
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
	public List<BigAllBean> getGoodsBillB(String msg) {
		// TODO Auto-generated method stub
		List<BigAllBean> list=new ArrayList<BigAllBean>();
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql="select * from view_Bill where Goods_id like ? or Goods_name like ?";
				
		BigAllBean b=null;
		GoodsBean gb=null;
		HouseCapacityBean hb=null;
		try {
			stm=conn.prepareStatement(sql);
			stm.setString(1,"%"+msg+"%");
			stm.setString(2,"%"+msg+"%");
			
			rs=stm.executeQuery();
			while(rs.next()){
				b=new BigAllBean();
				gb=new GoodsBean();
				hb=new HouseCapacityBean();
				//ob=new OrderRelationBean();
				b.setGb(gb);
				//b.setOb(ob);
				b.setHc(hb);
		        b.getGb().setGoods_id(rs.getString("Goods_id"));
		        b.getGb().setGoods_Name(rs.getString("Goods_name"));
		        b.getGb().setGoods_unit(rs.getString("Goods_unit"));
		        b.getGb().setGoods_spft(rs.getString("Goods_spft"));
		        b.getGb().setGoods_setting(rs.getFloat("Goods_price"));
		        b.getHc().setGoods_num(rs.getInt("Goods_num"));
		        b.getGb().setGood_manufacture(rs.getString("Goods_facture"));
		        list.add(b);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs,stm, conn);
		}
		return list;
	}

	@Override
	public List<BigAllBean> getNewlyInfo() {
		// TODO Auto-generated method stub
		List<BigAllBean> list=new ArrayList<BigAllBean>();
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql="select * from View_new";
		BigAllBean b=null;
		GoodsBean gb=null;
		OrderRelationBean ob=null;
		JTGoodsBean jb=null;
		//OrderRelationBean ob=null;
		try {
			stm=conn.prepareStatement(sql);
			rs=stm.executeQuery();
			while(rs.next()){
				//jb=new JTGoodsBean();
				b=new BigAllBean();
				gb=new GoodsBean();
				jb=new JTGoodsBean();
				ob=new OrderRelationBean();
				b.setGb(gb);
				b.setOb(ob);
				b.setJb(jb);
		        b.getGb().setGoods_id(rs.getString("new_id"));
		        b.getGb().setGoods_Name(rs.getString("new_name"));
		        b.getOb().setGoods_num(rs.getInt("new_num"));
		        b.getGb().setGoods_setting(rs.getFloat("new_price"));
		        b.getGb().setGoods_unit(rs.getString("new_unit"));
		        b.getGb().setGoods_spft(rs.getString("new_spft"));
		        b.getJb().setOrder_date(rs.getString("new_date"));
		        list.add(b);
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
	public boolean addGoodsInfo(GoodsBean g) {
		// TODO Auto-generated method stub
		boolean bool=false;
		Connection conn=DBUtil.getConnection();
		
		PreparedStatement stm=null;
		String sql="insert into goods (Goods_Id,Goods_Name,Goods_Type,Goods_Codes,Goods_Unit,Goods_Spft,Goods_Apvlunm,Goods_Setting,Goods_Price,Goods_Manufacture,Goods_Note)" +
				"values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			
			stm=conn.prepareStatement(sql);
//			System.out.println("---------"+g.getGoods_id());
//			System.out.println("---------"+g.getGoods_Name());
			stm.setString(1,g.getGoods_id());
			stm.setString(2, g.getGoods_Name());
			stm.setString(3,g.getGoods_type());
			stm.setString(4,g.getGoods_codes());
			stm.setString(5,g.getGoods_unit());
			stm.setString(6,g.getGoods_spft());
			stm.setString(7,g.getGoods_Apvlnum());
			stm.setFloat(8,g.getGoods_setting());
			stm.setFloat(9,g.getGoods_price());
			stm.setString(10,g.getGood_manufacture());
			stm.setString(11,g.getGoods_note());
			int len=stm.executeUpdate();
			//System.out.println("len:"+len);
			if(len>0){
				bool=true;
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
	public List<BigAllBean> getHistoryInfoByGoodsID(String g) {
		// TODO Auto-generated method stub
		List<BigAllBean> list=new ArrayList<BigAllBean>();
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql="select * from view_HisGoods where stock_id=?";
		BigAllBean b=null;
		GoodsBean gb=null;
		OrderRelationBean ob=null;
		JTGoodsBean jb=null;
		//OrderRelationBean ob=null;
		try {
			stm=conn.prepareStatement(sql);
			stm.setString(1,g);
			rs=stm.executeQuery();
			while(rs.next()){
				//jb=new JTGoodsBean();
				b=new BigAllBean();
				gb=new GoodsBean();
				jb=new JTGoodsBean();
				ob=new OrderRelationBean();
				b.setGb(gb);
				b.setOb(ob);
				b.setJb(jb);
		        b.getJb().setOrder_date(rs.getString("stock_date"));
		        b.getOb().setOrder_id(rs.getString("stock_no"));
		        b.getGb().setGoods_setting(rs.getFloat("stock_price"));
		        b.getOb().setGoods_num(rs.getInt("stock_num"));
		        b.getOb().setOrder_price(rs.getFloat("stock_sum"));
		        b.getGb().setGoods_id(rs.getString("stock_id"));
		        b.getOb().setGoods_validity(rs.getString("stock_useDate"));
		        list.add(b);
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
	public List<BigAllBean> getAddGoodsInfo(String name) {
		// TODO Auto-generated method stub
		List<BigAllBean> list=new ArrayList<BigAllBean>();
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql="select * from goods where goods_name=?";
		BigAllBean b=null;
		GoodsBean gb=null;
		
		try {
			stm=conn.prepareStatement(sql);
			stm.setString(1,name);
			rs=stm.executeQuery();
			while(rs.next()){
				
				b=new BigAllBean();
				gb=new GoodsBean();
				
				b.setGb(gb);
				
				b.getGb().setGoods_id(rs.getString("goods_id"));
		        b.getGb().setGoods_Name(rs.getString("goods_name"));
		        b.getGb().setGoods_unit(rs.getString("goods_unit"));
		        b.getGb().setGoods_spft(rs.getString("goods_spft"));
		        b.getGb().setGoods_Apvlnum(rs.getString("goods_Apvlunm"));
		        b.getGb().setGood_manufacture(rs.getString("goods_manufacture"));
		      
		        b.getGb().setGoods_setting(rs.getFloat("goods_setting"));

		        list.add(b);
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs,stm, conn);
		}
		return list;	        
	}

	@Override
	public boolean addCJGoodsInfo(BigAllBean g) {
		// TODO Auto-generated method stub
		boolean bool=false;
		Connection conn=DBUtil.getConnection();
		
		PreparedStatement stm=null;
		String sql="insert into JTGoods values(?,?,?,?,to_date(?,'yyyy-mm-dd'),?,?,?)";
		try {
			
			stm=conn.prepareStatement(sql);
			System.out.println("---------"+g.getJb().getOrder_type());
			System.out.println("---------"+g.getJb().getWarehouse_id());
			stm.setString(1,g.getJb().getOrder_id());
			stm.setString(2, g.getJb().getSupplier_id());
			stm.setString(3,g.getJb().getOrder_type());
			stm.setString(4,g.getJb().getWarehouse_id());
			stm.setString(5,g.getJb().getOrder_date());
			stm.setFloat(6,g.getJb().getOrder_price());
			stm.setString(7, g.getJb().getOrder_head());
			stm.setString(8,g.getJb().getOrder_note());
			int len=stm.executeUpdate();
			//System.out.println("len:"+len);
			if(len>0){
				bool=true;
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
	public boolean addCJGoodsInfo1(BigAllBean g) {
		// TODO Auto-generated method stub
		boolean bool=false;
		Connection conn=DBUtil.getConnection();
		
		PreparedStatement stm=null;
		String sql="insert into HouseCapacity values(?,?,?)";
		try {
			
			stm=conn.prepareStatement(sql);
//			System.out.println("---------"+g.getGoods_id());
//			System.out.println("---------"+g.getGoods_Name());
			stm.setString(1,g.getHc().getWarehouse_id());
			stm.setString(2, g.getHc().getGoods_id());
			stm.setInt(3,g.getHc().getGoods_num());
			
			int len=stm.executeUpdate();
			//System.out.println("len:"+len);
			if(len>0){
				bool=true;
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
	public boolean addCJGoodsInfo2(BigAllBean g) {
		// TODO Auto-generated method stub
		boolean bool=false;
		Connection conn=DBUtil.getConnection();
		
		PreparedStatement stm=null;
		String sql="insert into OrderRelation values(?,?,?,?,?,to_date(?,'yyyy-mm-dd'))";
		try {
			
			stm=conn.prepareStatement(sql);
//			System.out.println("---------"+g.getGoods_id());
//			System.out.println("---------"+g.getGoods_Name());
			stm.setString(1,g.getOb().getOrder_id());
			stm.setString(2, g.getOb().getGoods_id());
			stm.setString(3,g.getOb().getWarehouse_id());
			stm.setInt(4,g.getOb().getGoods_num());
			stm.setFloat(5,g.getOb().getOrder_price());
			stm.setString(6,g.getOb().getGoods_validity());
			
			int len=stm.executeUpdate();
			//System.out.println("len:"+len);
			if(len>0){
				bool=true;
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
	public List<BigAllBean> getBillInfo2() {
		// TODO Auto-generated method stub
		List<BigAllBean> list=new ArrayList<BigAllBean>();
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql="select * from View_Bill";
		BigAllBean b=null;
		GoodsBean gb=null;
		HouseCapacityBean hb=null;
		//OrderRelationBean ob=null;
		try {
			stm=conn.prepareStatement(sql);
			rs=stm.executeQuery();
			while(rs.next()){
				//jb=new JTGoodsBean();
				b=new BigAllBean();
				gb=new GoodsBean();
				hb=new HouseCapacityBean();
				//ob=new OrderRelationBean();
				b.setGb(gb);
				//b.setOb(ob);
				b.setHc(hb);
		        b.getGb().setGoods_id(rs.getString("Goods_id"));
		        b.getGb().setGoods_Name(rs.getString("Goods_name"));
		        b.getGb().setGoods_unit(rs.getString("Goods_unit"));
		        b.getGb().setGoods_spft(rs.getString("Goods_spft"));
		        b.getGb().setGoods_setting(rs.getFloat("Goods_price"));
		        b.getHc().setGoods_num(rs.getInt("Goods_num"));
		        b.getGb().setGood_manufacture(rs.getString("Goods_facture"));
		        list.add(b);
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
	public boolean isExistByGoodsIdAndHouseID(BigAllBean g) {
		// TODO Auto-generated method stub
		boolean bool=false;
		Connection conn=DBUtil.getConnection();
		PreparedStatement stm=null;
		ResultSet rs=null;
		String sql="select * from Housecapacity where  Warehouse_id=? and goods_id=? ";
		try {
			stm=conn.prepareStatement(sql);
			
			//System.out.println("123:"+g.getHc().getWarehouse_id());
			stm.setString(1, g.getHc().getWarehouse_id());
			stm.setString(2,g.getHc().getGoods_id());
			rs=stm.executeQuery();
			bool=rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public boolean UpdateHouseData(BigAllBean g) {
		// TODO Auto-generated method stub
		boolean bool=false;
		Connection conn=DBUtil.getConnection();
		PreparedStatement stm=null;
		String sql="update HouseCapacity set Goods_Num=Goods_Num+? where goods_id=? and Warehouse_id=?";
		try {
			stm=conn.prepareStatement(sql);
			stm.setInt(1,g.getHc().getGoods_num());
			stm.setString(2,g.getHc().getGoods_id());
			stm.setString(3, g.getHc().getWarehouse_id());
			int len=stm.executeUpdate();
			if(len>0){
				bool=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public boolean UpdateHouseData2(BigAllBean g) {
		// TODO Auto-generated method stub
		boolean bool=false;
		Connection conn=DBUtil.getConnection();
		PreparedStatement stm=null;
		String sql="update HouseCapacity set Goods_Num=Goods_Num-? where Warehouse_id=? and Goods_Id=?";
		try {
			stm=conn.prepareStatement(sql);
			stm.setInt(1,g.getHc().getGoods_num());
			stm.setString(2,g.getHc().getWarehouse_id());
			stm.setString(3,g.getHc().getGoods_id());
			int len=stm.executeUpdate();
			if(len>0){
				bool=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public List<BigAllBean> getWareHouseByHouseName(String msg) {
		// TODO Auto-generated method stub
		List<BigAllBean> list=new ArrayList<BigAllBean>();
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement stm=null;
		String sql="select *  from Warehouse where Warehouse_Name=?";
		BigAllBean b=null;
		WarehouseBean wb=null;
		//OrderRelationBean ob=null;
		//JTGoodsBean jb=null;
		//OrderRelationBean ob=null;
		try {
			stm=conn.prepareStatement(sql);
			stm.setString(1,msg);
			rs=stm.executeQuery();
			while(rs.next()){
				
				b=new BigAllBean();
				wb=new WarehouseBean();
				b.setWb(wb);
				b.getWb().setWarehouse_id(rs.getString("Warehouse_id"));
				b.getWb().setWarehouse_name(rs.getString("Warehouse_Name"));
				b.getWb().setWarehouse_head(rs.getString("Warehouse_Head"));
				b.getWb().setWarehouse_tel(rs.getString("Warehouse_Tel"));
				b.getWb().setWarehouse_addr(rs.getString("Warehouse_Addr"));
				b.getWb().setWarehouse_note(rs.getString("Warehouse_Note"));
			    list.add(b);
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs,stm, conn);
		}
		return list;	
	}

}

