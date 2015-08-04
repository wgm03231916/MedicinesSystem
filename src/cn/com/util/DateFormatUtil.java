package cn.com.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	public static String getTime(Date date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		return df.format(date);
	} 
}
