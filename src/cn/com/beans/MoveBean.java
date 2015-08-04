package cn.com.beans;

public class MoveBean {
     private String Move_id;
     private String Out_name;
     private String In_name;
     private String Move_date;
     private String Move_people;
     private String Move_note;
     private int Move_number;
     private String Goods_id;
     
	public String getGoods_id() {
		return Goods_id;
	}
	public void setGoods_id(String goods_id) {
		Goods_id = goods_id;
	}
	public int getMove_number() {
		return Move_number;
	}
	public void setMove_number(int i) {
		Move_number = i;
	}
	public String getMove_id() {
		return Move_id;
	}
	public void setMove_id(String move_id) {
		Move_id = move_id;
	}
	public String getOut_name() {
		return Out_name;
	}
	public void setOut_name(String out_name) {
		Out_name = out_name;
	}
	public String getIn_name() {
		return In_name;
	}
	public void setIn_name(String in_name) {
		In_name = in_name;
	}
	public String getMove_date() {
		return Move_date;
	}
	public void setMove_date(String move_date) {
		Move_date = move_date;
	}
	public String getMove_people() {
		return Move_people;
	}
	public void setMove_people(String move_people) {
		Move_people = move_people;
	}
	public String getMove_note() {
		return Move_note;
	}
	public void setMove_note(String move_note) {
		Move_note = move_note;
	}
}
