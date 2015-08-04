package cn.com.getsql;

import cn.com.beans.GetGoodsSaleWarehouseCustomerViewBean;
import cn.com.beans.Supplier_1Number;
import cn.com.beans.Supplier_2Date;

public class GetSql {
	public String getSupplierConnectJTGoodsSql(Supplier_2Date supplier_2Date){
		String sql = null;
		String date1 = supplier_2Date.getDate1();
		String date2 = supplier_2Date.getDate2();
		sql = "select * from SupplierConnectJTGoods where "
				+ "Order_date >= to_date('"+date1+"','yyyy-mm-dd')"
				+ "and Order_date <= to_date('"+date2+"','yyyy-mm-dd')";
		return sql;
		
	}
	public String getGoodsJTGoodsOrderRelationViewSql(Supplier_1Number supplier_1Number){
		String sql = null;
		String s = supplier_1Number.getOrder_id();
		sql = "select * from GoodsJTGoodsOrderRelationView where jtorder_id='"+s+"'";
		return sql;
		
	}
	public String getGSWJOViewSql(Supplier_2Date supplier_2Date) {
		String sql = null;
		String date1 = supplier_2Date.getDate1();
		String date2 = supplier_2Date.getDate2();
//		sql = "select * from GSWJOView where "
//				+ "Order_date >= to_date('"+date1+"','yyyy-mm-dd')"
//				+ "and Order_date <= to_date('"+date2+"','yyyy-mm-dd')";
		sql = "select * from GSWJOView where "
				+ "Goods_Validity  >= to_date('"+date1+"','yyyy-mm-dd')";
		return sql;
	}
	public String getGoodsSaleCustomerViewSql(Supplier_2Date supplier_2Date) {
		String sql = null;
		String date1 = supplier_2Date.getDate1();
		String date2 = supplier_2Date.getDate2();
		sql = "select * from GoodsSaleCustomerView where "
				+ "Sale_date >= to_date('"+date1+"','yyyy-mm-dd')"
				+ "and Sale_date <= to_date('"+date2+"','yyyy-mm-dd')";
		return sql;
	}
	public String getGoodsSaleRelationViewSql(Supplier_1Number supplier_1Number) {
		String sql = null;
		String s = supplier_1Number.getOrder_id();
		sql = "select * from GoodsSaleRelationView where Sale_Id='"+s+"'";
		return sql;
	}
	public String getEmployeeSql(Object o) {
		
		return "select * from Employee";
	}
	public String getggwcvSql(GetGoodsSaleWarehouseCustomerViewBean ggwcv) {

		String sql = null;
		String date1 = ggwcv.getDate1();
		String date2 = ggwcv.getDate2();
		if(ggwcv.getEmployee().equals("所有业务员")){
			sql = "select * from GoodsSaleWarehouseCustomerView where "
					+ "Sale_date >= to_date('"+date1+"','yyyy-mm-dd')"
					+ "and Sale_date <= to_date('"+date2+"','yyyy-mm-dd')";
		}else{
			sql = "select * from GoodsSaleWarehouseCustomerView where "
					+ "Sale_date >= to_date('"+date1+"','yyyy-mm-dd')"
					+ "and Sale_date <= to_date('"+date2+"','yyyy-mm-dd') and Sale_People = '"+ggwcv.getEmployee()+"'";
		}
		return sql;
	}
	public String getGoodsSaleRelationViweSql(Supplier_1Number supplier_1Number) {
		String sql = null;
		String s = supplier_1Number.getOrder_id();
		sql = "select * from GoodsSaleRelationViwe where Sale_Id='"+s+"'";
		return sql;
	}
	public String getCustomerSql(Object o) {
		
		return "select * from Customer";
	}
	public String getXSql(GetGoodsSaleWarehouseCustomerViewBean ggwcv) {
		String sql = null;
		String date1 = ggwcv.getDate1();
		String date2 = ggwcv.getDate2();
		if(ggwcv.getEmployee().equals("全部客户")){
			sql = "select * from GoodsSaleWarehouseCustomerView where "
					+ "Sale_date >= to_date('"+date1+"','yyyy-mm-dd')"
					+ "and Sale_date <= to_date('"+date2+"','yyyy-mm-dd')";
		}else{
			sql = "select * from GoodsSaleWarehouseCustomerView where "
					+ "Sale_date >= to_date('"+date1+"','yyyy-mm-dd')"
					+ "and Sale_date <= to_date('"+date2+"','yyyy-mm-dd') and Customer_Name = '"+ggwcv.getEmployee()+"'";
		}
		return sql;
	}
	public String getSupplierSql(Object o) {
		// TODO Auto-generated method stub
		return "select * from Supplier";
	}
	public String getYSql(GetGoodsSaleWarehouseCustomerViewBean ggwcv) {
		String sql = null;
		String date1 = ggwcv.getDate1();
		String date2 = ggwcv.getDate2();
		if(ggwcv.getEmployee().equals("所有供货商")){
			sql = "select * from SupplierConnectJTGoods where "
					+ "Order_date >= to_date('"+date1+"','yyyy-mm-dd')"
					+ "and Order_date <= to_date('"+date2+"','yyyy-mm-dd')";
		}else{
			sql = "select * from SupplierConnectJTGoods where "
					+ "Order_date >= to_date('"+date1+"','yyyy-mm-dd')"
					+ "and Order_date <= to_date('"+date2+"','yyyy-mm-dd') and Supplier_Name = '"+ggwcv.getEmployee()+"'";
		}
		return sql;
		
	}
	
}
