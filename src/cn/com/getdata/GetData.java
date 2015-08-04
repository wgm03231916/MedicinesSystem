package cn.com.getdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.beans.CustomerBean;
import cn.com.beans.EmployeeBean;
import cn.com.beans.GSWJOView;
import cn.com.beans.GoodsJTGoodsOrderRelationView;
import cn.com.beans.GoodsSaleCustomerView;
import cn.com.beans.GoodsSaleRelationView;
import cn.com.beans.GoodsSaleRelationViweBean;
import cn.com.beans.GoodsSaleWarehouseCustomerView;
import cn.com.beans.JTGoodsSupplierView;
import cn.com.beans.SupplierBean;

public class GetData {
	public List<Object> getSupplierConnectJTGoodsData(ResultSet rs){
		List<Object> list = new ArrayList<Object>();
		JTGoodsSupplierView jTGoodsSupplierView = null;
		try {
			while(rs.next()){
				jTGoodsSupplierView = new JTGoodsSupplierView();
				jTGoodsSupplierView.setSupplier_Name(rs.getString("Supplier_Name"));
				jTGoodsSupplierView.setOrder_date(rs.getString("Order_date"));
				jTGoodsSupplierView.setOrder_Id(rs.getString("Order_Id"));
				jTGoodsSupplierView.setOrder_Type(rs.getString("Order_Type"));
				jTGoodsSupplierView.setOrder_price(rs.getFloat("Order_price"));
				jTGoodsSupplierView.setOrder_head(rs.getString("Order_head"));
				jTGoodsSupplierView.setOrder_Note(rs.getString("Order_Note"));
		   
				list.add(jTGoodsSupplierView);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Object> getGoodsJTGoodsOrderRelationViewData(ResultSet rs){
		List<Object> list = new ArrayList<Object>();
		GoodsJTGoodsOrderRelationView goodsJTGoodsOrderRelationView = null;
		try {
			while(rs.next()){
				goodsJTGoodsOrderRelationView = new GoodsJTGoodsOrderRelationView();
				goodsJTGoodsOrderRelationView.setGoods_Id(rs.getString("gg_id"));
				goodsJTGoodsOrderRelationView.setGoods_Manufacture(rs.getString("Goods_Manufacture"));
				goodsJTGoodsOrderRelationView.setGoods_Name(rs.getString("Goods_Name"));
				goodsJTGoodsOrderRelationView.setGoods_Num(rs.getInt("Goods_Num"));
				goodsJTGoodsOrderRelationView.setGoods_Setting(rs.getFloat("Goods_Setting"));
				goodsJTGoodsOrderRelationView.setGoods_Spft(rs.getString("Goods_Spft"));
				goodsJTGoodsOrderRelationView.setGoods_Unit(rs.getString("Goods_Unit"));
				goodsJTGoodsOrderRelationView.setGoods_Validity(rs.getString("Goods_Validity"));
				goodsJTGoodsOrderRelationView.setOrder_id(rs.getString("jtorder_id"));
				goodsJTGoodsOrderRelationView.setOrder_price(rs.getFloat("oo_price"));
				list.add(goodsJTGoodsOrderRelationView);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Object> getGSWJOViewData(ResultSet rs) {
		List<Object> list = new ArrayList<Object>();
		GSWJOView gSWJOView = null;
		try {
			while(rs.next()){
				gSWJOView = new GSWJOView();
				gSWJOView.setOrder_Id(rs.getString("jto_id"));
				gSWJOView.setOrder_date(rs.getString("Order_date"));
				gSWJOView.setSupplier_Name(rs.getString("Supplier_Name"));
				gSWJOView.setGoods_Id(rs.getString("gg_id"));
				gSWJOView.setGoods_Name(rs.getString("Goods_Name"));
				gSWJOView.setGoods_Type(rs.getString("Goods_Type"));
				gSWJOView.setWarehouse_Name(rs.getString("Warehouse_Name"));
				gSWJOView.setGoods_Unit(rs.getString("Goods_Unit"));
				gSWJOView.setGoods_Validity(rs.getString("Goods_Validity"));
				gSWJOView.setGoods_Setting(rs.getFloat("Goods_Setting"));
				gSWJOView.setGoods_Num(rs.getInt("Goods_Num"));
				gSWJOView.setOrder_price(rs.getFloat("oo_price"));
				gSWJOView.setGoods_Spft(rs.getString("Goods_Spft"));
				gSWJOView.setOrder_head(rs.getString("Order_head"));
				gSWJOView.setGoods_Manufacture(rs.getString("Goods_Manufacture"));
				gSWJOView.setGoods_Apvlunm(rs.getString("Goods_Apvlunm"));
				list.add(gSWJOView);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Object> getGoodsSaleCustomerViewData(ResultSet rs) {
		List<Object> list = new ArrayList<Object>();
		GoodsSaleCustomerView goodsSaleCustomerView = null;
		try {
			while(rs.next()){
				goodsSaleCustomerView = new GoodsSaleCustomerView();
				goodsSaleCustomerView.setCustomer_Name(rs.getString("Customer_Name"));
				goodsSaleCustomerView.setSale_date(rs.getString("Sale_date"));
				goodsSaleCustomerView.setSale_Id(rs.getString("Sale_Id"));
				goodsSaleCustomerView.setSale_Type(rs.getString("Sale_Type"));
				goodsSaleCustomerView.setSale_Price(rs.getFloat("Sale_Price"));
				goodsSaleCustomerView.setSale_People(rs.getString("Sale_People"));
				goodsSaleCustomerView.setSale_Note(rs.getString("Sale_Note"));
				list.add(goodsSaleCustomerView);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Object> getGoodsSaleRelationViewData(ResultSet rs) {
		List<Object> list = new ArrayList<Object>();
		GoodsSaleRelationView goodsSaleRelationView = null;
		try {
			while(rs.next()){
				goodsSaleRelationView = new GoodsSaleRelationView();
				goodsSaleRelationView.setSale_Id(rs.getString("Sale_Id"));
				goodsSaleRelationView.setGoods_Id(rs.getString("gg_id"));
				goodsSaleRelationView.setGoods_Name(rs.getString("Goods_Name"));
				goodsSaleRelationView.setGoods_Unit(rs.getString("Goods_Unit"));
				goodsSaleRelationView.setGoods_Setting(rs.getString("Goods_Setting"));
				goodsSaleRelationView.setSale_num(rs.getInt("Sale_num"));
				goodsSaleRelationView.setSale_Price(rs.getFloat("Sale_Price"));
				goodsSaleRelationView.setGoods_Spft(rs.getString("Goods_Spft"));
				goodsSaleRelationView.setGoods_Apvlunm(rs.getString("Goods_Apvlunm"));
				goodsSaleRelationView.setGoods_Manufacture(rs.getString("Goods_Manufacture"));
				list.add(goodsSaleRelationView);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Object> getEmployeeData(ResultSet rs) {
		List<Object> list = new ArrayList<Object>();
		EmployeeBean employee = null;
		try {
			while(rs.next()){
				employee = new EmployeeBean();
				employee.setEmployee_id(rs.getString("Employee_Id"));
				employee.setEmployee_name(rs.getString("Employee_Name"));
				list.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Object> getggwcvData(ResultSet rs) {
		List<Object> list = new ArrayList<Object>();
		GoodsSaleWarehouseCustomerView g = null;
		try {
			while(rs.next()){
				g = new GoodsSaleWarehouseCustomerView();
				g.setSale_date(rs.getString("Sale_date"));
				g.setSale_Type(rs.getString("Sale_People"));
				g.setSale_People(rs.getString("Sale_Type"));
				g.setSale_Id(rs.getString("Sale_Id"));
				g.setSale_Price(rs.getFloat("Sale_Price"));
				g.setWarehouse_Name(rs.getString("Warehouse_Name"));
				g.setCustomer_Name(rs.getString("Customer_Name"));
				g.setCustomer_Tel(rs.getString("Customer_Tel"));
				g.setSale_Note(rs.getString("Sale_Note"));
				list.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Object> getGoodsSaleRelationViweData(ResultSet rs) {
		List<Object> list = new ArrayList<Object>();
		GoodsSaleRelationViweBean g = null;
		try {
			while(rs.next()){
				g = new GoodsSaleRelationViweBean();
				g.setSale_Id(rs.getString("Sale_Id"));
				g.setGg_id(rs.getString("gg_id"));
				g.setGoods_Name(rs.getString("Goods_Name"));
				g.setGoods_Unit(rs.getString("Goods_Unit"));
				g.setGoods_Setting(rs.getFloat("Goods_Setting"));
				g.setSale_num(rs.getInt("Sale_num"));
				g.setSale_Price(rs.getFloat("Sale_Price"));
				g.setGoods_Spft(rs.getString("Goods_Spft"));
				g.setGoods_Apvlunm(rs.getString("Goods_Apvlunm"));
				g.setGoods_Manufacture(rs.getString("Goods_Manufacture"));
				list.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Object> getCustomerData(ResultSet rs) {
		List<Object> list = new ArrayList<Object>();
		CustomerBean c = null;
		try {
			while(rs.next()){
				c = new CustomerBean();
				c.setCustomer_name(rs.getString("Customer_Name"));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Object> getSupplierData(ResultSet rs) {
		List<Object> list = new ArrayList<Object>();
		SupplierBean s = null;
		try {
			while(rs.next()){
				s = new SupplierBean();
				s.setSupplier_name(rs.getString("Supplier_Name"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
