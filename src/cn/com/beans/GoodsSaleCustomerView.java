package cn.com.beans;

public class GoodsSaleCustomerView {
	private String Customer_Name;
	private String Sale_date;
	private String Sale_Id;
	private String Sale_Type;
	private float Sale_Price;
	private String Sale_People;
	private String Sale_Note;
	public String getCustomer_Name() {
		return Customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}
	public String getSale_date() {
		return Sale_date;
	}
	public void setSale_date(String sale_date) {
		Sale_date = sale_date;
	}
	public String getSale_Id() {
		return Sale_Id;
	}
	public void setSale_Id(String sale_Id) {
		Sale_Id = sale_Id;
	}
	public String getSale_Type() {
		return Sale_Type;
	}
	public void setSale_Type(String sale_Type) {
		Sale_Type = sale_Type;
	}
	public float getSale_Price() {
		return Sale_Price;
	}
	public void setSale_Price(float sale_Price) {
		Sale_Price = sale_Price;
	}
	public String getSale_People() {
		return Sale_People;
	}
	public void setSale_People(String sale_People) {
		Sale_People = sale_People;
	}
	public String getSale_Note() {
		return Sale_Note;
	}
	public void setSale_Note(String sale_Note) {
		Sale_Note = sale_Note;
	}
	@Override
	public String toString() {
		return "GoodsSaleCustomerView [Customer_Name=" + Customer_Name
				+ ", Sale_date=" + Sale_date + ", Sale_Id=" + Sale_Id
				+ ", Sale_Type=" + Sale_Type + ", Sale_Price=" + Sale_Price
				+ ", Sale_People=" + Sale_People + ", Sale_Note=" + Sale_Note
				+ "]";
	}
	
	
}
