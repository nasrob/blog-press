package com.nasBoukehil.blogPress.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlogpressUtil {

	private static Logger logger = LoggerFactory.getLogger(BlogpressUtil.class);
	
	private static String elasticDateFormat = "MM-dd-yyyy'T'HH:mm:ss";
	private static String displayDateFormat = "MMMMM dd yyyy h:mm:ss a";
	private static final String ALPHA_NUMIRIC_STRING = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789";
	private static int randomNoLength = 10;
	
	private BlogpressUtil() {
	
	}
	
	/**
	 * format date in the given dateFormat
	 * @param inputDate
	 * @param dtFormat
	 * @return String
	 */
	private static String getFormattedDate(Date inputDate, DateFormat dtFormat) {
		if (inputDate != null) {
			return dtFormat.format(inputDate);
		} else {
			return "";
		}
	}
	
	/**
	 * get DateFormat object from date pattern
	 * @param dateFormatPattern
	 * @return DateFormat
	 */
	public static DateFormat getDateFormatObj(String dateFormatPattern) {
		DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);
		return dateFormat;		
	}
	
	/**	
	 * get formatted date for elastic search
	 * @param inputDate
	 * @return
	 */
	public static String getFormattedDateForElasticSearch(Date inputDate) {
		return getFormattedDate(inputDate, getDateFormatObj(elasticDateFormat));
	}
	
	/**
	 * 	
	 * @param currentDate
	 * @return
	 */
	public static String randomNumber(Date currentDate) {
		int count = randomNoLength;
		StringBuilder builder = new StringBuilder();
		while (count-- !=0) {
			int charchter = (int) (Math.random() * ALPHA_NUMIRIC_STRING.length());
			builder.append(ALPHA_NUMIRIC_STRING.charAt(charchter));
		}
		
		if (currentDate == null) {
			currentDate = new Date();
		}
		
		return builder.append(currentDate.getTime()).toString();
	}
	
	public static int parseInteger(String intStr) {
		int returnValue = 0;
		try {
			returnValue = Integer.parseInt(intStr);
		} catch (NumberFormatException ex) {
			logger.error("error occured while parsing integer " + intStr, ex.getMessage(), ex);
		}
		return returnValue;
	}
}
