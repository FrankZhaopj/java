package com.zhaopj.java.date;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		//初始化当前时间
		Date date = new Date();
		//时间戳
		System.out.println(date.getTime());
		//时间格式化(12小时)
		SimpleDateFormat sfd1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");
		//时间格式化(24小时)
		SimpleDateFormat sfd2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		System.out.println(sfd1.format(date));
		System.out.println(sfd2.format(date));
		ParsePosition pp = new ParsePosition(8);
		
		String a = "2027-09-13 15:23:33";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    ParsePosition pos = new ParsePosition(0);
	    Date strtodate;
	    strtodate = formatter.parse(a, pos);
	    System.out.println(formatter.format(strtodate));
		
	}

}
