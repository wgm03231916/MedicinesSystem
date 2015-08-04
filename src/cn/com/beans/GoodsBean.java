package cn.com.beans;
/***
 *  Goods_Id	Number		Primary key	Not null 	商品编号
    Goods_Name	Varchar2()	50		Not null	商品名称
	Goods_type	Varchar2()	100		Not null 	所属类别
	Goods_codes	Varchar2()	50		Not null	商品条码
	Goods_unit	Varchar2()	20		Not null	商品单位
	Goods_spft	Varchar2()	50		Not null	商品规格
	Good_Apvlnum	Varchar2()	50		Not null	批准文号
	Goods_setting	number			Not null	预设进价
	Goods_price	number			Not null	预设售价
	Good_manufacture	Varchar2()	100		Not null	生产厂商
	Good_note	Varchar2()	200			备注

 * @author admin
 *
 */
public class GoodsBean {
    private String Goods_id;
    private String Goods_Name;
    private String Goods_type;
    private String Goods_codes;
    private String Goods_unit;
    private String Goods_spft;
    private String Goods_Apvlnum;
    private float Goods_setting;
    private float Goods_price;
    private String Good_manufacture;
    private String Goods_note;
	public String getGoods_id() {
		return Goods_id;
	}
	public void setGoods_id(String goods_id) {
		Goods_id = goods_id;
	}
	public String getGoods_Name() {
		return Goods_Name;
	}
	public void setGoods_Name(String goods_Name) {
		Goods_Name = goods_Name;
	}
	public String getGoods_type() {
		return Goods_type;
	}
	public void setGoods_type(String goods_type) {
		Goods_type = goods_type;
	}
	public String getGoods_codes() {
		return Goods_codes;
	}
	public void setGoods_codes(String goods_codes) {
		Goods_codes = goods_codes;
	}
	public String getGoods_unit() {
		return Goods_unit;
	}
	public void setGoods_unit(String goods_unit) {
		Goods_unit = goods_unit;
	}
	public String getGoods_spft() {
		return Goods_spft;
	}
	public void setGoods_spft(String goods_spft) {
		Goods_spft = goods_spft;
	}
	public String getGoods_Apvlnum() {
		return Goods_Apvlnum;
	}
	public void setGoods_Apvlnum(String goods_Apvlnum) {
		Goods_Apvlnum = goods_Apvlnum;
	}
	public float getGoods_setting() {
		return Goods_setting;
	}
	public void setGoods_setting(float goods_setting) {
		Goods_setting = goods_setting;
	}
	public float getGoods_price() {
		return Goods_price;
	}
	public void setGoods_price(float goods_price) {
		Goods_price = goods_price;
	}
	public String getGood_manufacture() {
		return Good_manufacture;
	}
	public void setGood_manufacture(String good_manufacture) {
		Good_manufacture = good_manufacture;
	}
	public String getGoods_note() {
		return Goods_note;
	}
	public void setGoods_note(String goods_note) {
		Goods_note = goods_note;
	}
	@Override
	public String toString() {
		return Goods_id;
	}
	
}
