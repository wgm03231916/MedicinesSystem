package cn.com.beans;

public class GetGoodsSaleWarehouseCustomerViewBean {
	private int num;
	private String date1;
	private String date2;
	private String employee;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "GetGoodsSaleWarehouseCustomerViewBean [num=" + num + ", date1="
				+ date1 + ", date2=" + date2 + ", employee=" + employee + "]";
	}
	
	
}



