package cn.com.daos.statisticalReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.beans.GetGoodsSaleWarehouseCustomerViewBean;
import cn.com.beans.JTGoodsSupplierView;
import cn.com.beans.Supplier_1Number;
import cn.com.beans.Supplier_2Date;
import cn.com.beans.UsesslessBean;
import cn.com.getdata.GetData;
import cn.com.getsql.GetSql;
import cn.com.util.DBUtil;

public class StatisticalDaoInfImp implements StatisticalDaoInf{
	@Override
	public List<Object> getAllOfDao(Object o) {
		
		List<Object> list = new ArrayList<Object>(); 
		Connection conn = DBUtil.getConnection();
		PreparedStatement stm = null;
		GetSql getSql = null;
		GetData getData = null;
		ResultSet rs = null;
		String sql = null;
		JTGoodsSupplierView jTGoodsSupplierView = null;
		
		if(o instanceof Supplier_2Date){
			Supplier_2Date supplier_2Date = (Supplier_2Date)o;
			getSql = new GetSql();
			getData = new GetData();
			if(supplier_2Date.getNum() == 1){
				sql = getSql.getSupplierConnectJTGoodsSql(supplier_2Date);
			}
			if(supplier_2Date.getNum() == 2){
				sql = getSql.getGSWJOViewSql(supplier_2Date);
			}
			if(supplier_2Date.getNum() == 3){
				sql = getSql.getGoodsSaleCustomerViewSql(supplier_2Date);
			}
			try {
				stm = conn.prepareStatement(sql);
				rs = stm.executeQuery();
				if(supplier_2Date.getNum() == 1){
					list = getData.getSupplierConnectJTGoodsData(rs);
				}
				if(supplier_2Date.getNum() == 2){
					list = getData.getGSWJOViewData(rs);
				}
				if(supplier_2Date.getNum() == 3){
					list = getData.getGoodsSaleCustomerViewData(rs);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBUtil.free(stm,conn);
			}
		}
		if(o instanceof Supplier_1Number){
			Supplier_1Number supplier_1Number = (Supplier_1Number)o;
			getSql = new GetSql();
			getData = new GetData();
			if(supplier_1Number.getNum() == 0){
				sql = getSql.getGoodsJTGoodsOrderRelationViewSql(supplier_1Number);
			}
			if(supplier_1Number.getNum() == 1){
				sql = getSql.getGoodsSaleRelationViewSql(supplier_1Number);
			}
			if(supplier_1Number.getNum() == 2){
				sql = getSql.getGoodsSaleRelationViweSql(supplier_1Number);
			}
			try {
				stm = conn.prepareStatement(sql);
				rs = stm.executeQuery();
				if(supplier_1Number.getNum() == 0){
					list = getData.getGoodsJTGoodsOrderRelationViewData(rs);
				}
				if(supplier_1Number.getNum() == 1){
					list = getData.getGoodsSaleRelationViewData(rs);
				}
				if(supplier_1Number.getNum() == 2){
					list = getData.getGoodsSaleRelationViweData(rs);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBUtil.free(stm,conn);
			}
		}
		if(o instanceof UsesslessBean){
			UsesslessBean u = (UsesslessBean)o;
			getSql = new GetSql();
			getData = new GetData();
			if(u.getI() == 1){
				sql = getSql.getEmployeeSql(o);
			}
			if(u.getI() == 2){
				sql = getSql.getCustomerSql(o);
			}
			if(u.getI() == 3){
				sql = getSql.getSupplierSql(o);
			}
			try {
				if(conn!= null){
					conn.close();
				}
				conn = DBUtil.getConnection();
				stm = conn.prepareStatement(sql);
				rs = stm.executeQuery();
				if(u.getI() == 1){
					list = getData.getEmployeeData(rs);
				}
				if(u.getI() == 2){
					list = getData.getCustomerData(rs);
				}
				if(u.getI() == 3){
					list = getData.getSupplierData(rs);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBUtil.free(stm,conn);
			}
		
		}
		if(o instanceof GetGoodsSaleWarehouseCustomerViewBean){
			GetGoodsSaleWarehouseCustomerViewBean ggwcv = (GetGoodsSaleWarehouseCustomerViewBean)o;
			
			getSql = new GetSql();
			getData = new GetData();
			if(ggwcv.getNum() == 1){
				sql = getSql.getggwcvSql(ggwcv);
			}
			if(ggwcv.getNum() == 2){
				sql = getSql.getXSql(ggwcv);
			}
			if(ggwcv.getNum() == 3){
				sql = getSql.getYSql(ggwcv);
			}
			try {
				if(conn != null){
					conn.close();
				}
				conn = DBUtil.getConnection();
				stm = conn.prepareStatement(sql);
				rs = stm.executeQuery();
				if(ggwcv.getNum() == 1){
					list = getData.getggwcvData(rs);
				}
				if(ggwcv.getNum() == 2){
					list = getData.getGoodsSaleCustomerViewData(rs);
				}
				if(ggwcv.getNum() == 3){
					list = getData.getSupplierConnectJTGoodsData(rs);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBUtil.free(stm,conn);
			}
		}
			return list;
	}
}
