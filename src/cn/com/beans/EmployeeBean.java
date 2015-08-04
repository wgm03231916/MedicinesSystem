package cn.com.beans;

public class EmployeeBean {
      private String Employee_id;
      private String Employee_name;
      private String Employee_title;
      private String Employee_tel;
      private String Employee_addr;
      private String Employee_note;
	public String getEmployee_id() {
		return Employee_id;
	}
	public void setEmployee_id(String employee_id) {
		Employee_id = employee_id;
	}
	public String getEmployee_name() {
		return Employee_name;
	}
	public void setEmployee_name(String employee_name) {
		Employee_name = employee_name;
	}
	public String getEmployee_title() {
		return Employee_title;
	}
	public void setEmployee_title(String employee_title) {
		Employee_title = employee_title;
	}
	public String getEmployee_tel() {
		return Employee_tel;
	}
	public void setEmployee_tel(String employee_tel) {
		Employee_tel = employee_tel;
	}
	public String getEmployee_addr() {
		return Employee_addr;
	}
	public void setEmployee_addr(String employee_addr) {
		Employee_addr = employee_addr;
	}
	public String getEmployee_note() {
		return Employee_note;
	}
	public void setEmployee_note(String employee_note) {
		Employee_note = employee_note;
	}
	@Override
	public String toString() {
		return Employee_id;
	}
	
}
