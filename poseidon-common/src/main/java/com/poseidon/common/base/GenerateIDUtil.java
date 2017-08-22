/**
 * 
 */
package com.poseidon.common.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @author XQ
 *
 */
public class GenerateIDUtil {

	/**
	 * 生成电商网点编号
	 * @param prefix 前缀
	 * @param date 包含的日期数据，如果为null，取当前日期
	 * @return string
	 */
	public static String createECnetpointID(String prefix, String mobile, Date date) {
		String rtnStr = "";
		String dateStr = "";
		String randomStr = "";
		String codeStr = "";
		Date dt = date;
		if (null == date) {
			dt = new Date();
		}
		try {
			dateStr = new SimpleDateFormat("yyMMdd").format(dt);
			mobile = mobile.trim();
			codeStr = numericToString(Long.parseLong(mobile), 32);
			randomStr = getRandomString(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		rtnStr = prefix + dateStr + codeStr + randomStr;
		return rtnStr;
	}
    
	/*
	 * 生成随机PSAM
	 */
	public static String createPsamID(String prefix, String mobile) {
		String billId = "";
		String time = "";
		String codeStr = "";
		StringBuilder digit = new StringBuilder();
		try {
			time = new SimpleDateFormat("yyMMdd").format(new Date());
			codeStr = numericToString(Long.parseLong(mobile), 32);
			String random = new Random().nextInt(100) + "";
			int len = random.length();
			if (len < 2) {
				for (int i=0;i<2-len;i++) {
					digit.append("0");
				}
			}
			char[] cs = random.toCharArray();
			for (char c : cs) {
				digit.append(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		billId = prefix + time + codeStr + digit.toString();
		return billId;
	}
	
	/**
	 * 生成8位随机字符串(字母、数字的组合)
	 * @param length
	 * @return
	 */
	private static String getRandomString(int length){
	    Random random=new Random();
	    StringBuffer sb=new StringBuffer();
	    for(int i=0;i<length;i++){
	       int number=random.nextInt(3);
	       long result=0;
	       switch(number){
	          case 0:
	              result=Math.round(Math.random()*25+65);
	              sb.append(String.valueOf((char)result));
	              break;
	         case 1:
	             result=Math.round(Math.random()*25+97);
	             sb.append(String.valueOf((char)result));
	             break;
	         case 2:     
	             sb.append(String.valueOf(new Random().nextInt(10)));
	             break;
	        }
	   
	     }
	     return sb.toString();
	 }
	
	final static char[] digits = {
	      '0', '1', '2', '3', '4', '5', '6', '7',
	      '8','9', 'A', 'B', 'C', 'D', 'E', 'F', 
	      'G', 'H','L', 'J', 'K','M', 'N',  'P',
	      'R', 'S', 'T', 'U', 'V', 'X', 'Y','Q'
	};
	
	private static String numericToString(long i, int system) {
	     long num = 0;
	     if (i < 0) {
	        num = ((long) 2 * 0x7fffffff) + i + 2;
	     } else {
	        num = i;
	     }
	     char[] buf = new char[32];
	     int charPos = 32;
		 while ((num / system) > 0) {
		     buf[--charPos] = digits[(int) (num % system)];
		     num /= system;
		 }
		 buf[--charPos] = digits[(int) (num % system)];
		 return new String(buf, charPos, (32 - charPos));
	}

	public static String getRandomLong(int length){
	    Random random=new Random();
	    StringBuffer sb=new StringBuffer();
	    for(int i=0;i<length;i++){
	       int number=random.nextInt(3);
	       switch(number){
	          case 0:
	        	  sb.append(String.valueOf(new Random().nextInt(10)));
	              break;
	         case 1:
	        	 sb.append(String.valueOf(new Random().nextInt(10)));
	             break;
	         case 2:     
	             sb.append(String.valueOf(new Random().nextInt(10)));
	             break;
	        }
	   
	     }
	     return sb.toString();
	}
	
	/**
	 * 随机uuid字符串
	 * @return
	 */
	public static String getUUID(){

		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-", "");
	}
	
	/**
	 * 自定义临时token字符串
	 * @return
	 * @deprecated
	 */
	public static String getTempUUID(){
		
		String uuid = "L"+System.currentTimeMillis()+getRandomLong(6);

		return uuid;
	}

	public static int getRandomInt(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}

	public static String genarateOrderId() {
		//---------------生成订单号 开始------------------------
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String currTime = simpleDateFormat.format(System.currentTimeMillis());
		//六位随机数
		String strRandom = getRandomInt(6) + "";
		// 此处用时间加随机数生成订单号
		String out_trade_no = currTime + strRandom;
		return out_trade_no;
	}

	public static void main(String[] args) {
		System.out.println(genarateOrderId());
	}
}
