
package com.hcl.api.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.StringJoiner;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.context.NoSuchMessageException;

import com.hcl.api.enums.BaseAppConstants;
import com.hcl.api.exception.ApplicationCustomException;

/**
 * Utility class for parsing the dates, other manipulations required in the
 * application
 * 
 * @author ArifKhan
 */
public class Utility {
	private static final Logger LOGGER = Logger.getLogger(Utility.class);

	/**
	 * This method is created to add days to a date.
	 * 
	 * 
	 * @return <code>Date</code> date after adding days
	 * @param date
	 *            date to be modified.
	 * @param noOfDays
	 *            days need to add
	 */
	public static Date addDaysToDate(final Date date, final int noOfDays) {
		final Calendar calender = Calendar.getInstance();
		calender.setTime(date);
		calender.add(Calendar.DATE, noOfDays);
		return calender.getTime();
	}

	/**
	 * Method is written to parse the date string to date Object with time
	 * 
	 * 
	 * 
	 * @param dateParam
	 *            date object are parameter
	 * @return String date is returned in string format with timezone
	 */
	public static String getCurrentDateTimeZone(final Date dateParam) {
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				BaseAppConstants.MM_DD_YYYY_HH_MM_SS_WITHZONE.getValue());
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone(BaseAppConstants.TIMEZONE_UTC.getValue()));
		try {
			return simpleDateFormat.format(dateParam);
		} catch (Exception e) {
			LOGGER.error("Exception while parsing date ", e);
		}
		return null;
	}

	/**
	 * This method is created for get the date difference
	 * 
	 * 
	 * @return <code>String</code> return difference
	 * @param startDate
	 *            passing start date
	 * @param endDate
	 *            passing end date
	 */
	public static String getDateDiff(Date startDate, Date endDate) {
		if (endDate != null && startDate != null) {
			try {
				long diff = endDate.getTime() - startDate.getTime();
				long diffDays = diff / (24 * 60 * 60 * 1000);
				return diffDays + " Days";
			} catch (Exception e) {
				LOGGER.error("Error in date parsing " + startDate, e);
			}
		}
		return null;
	}

	/**
	 * This method is created for get the date difference in days
	 * 
	 * 
	 * @return <code>String</code> return difference of date in days.
	 * @param startDate
	 *            passing start date
	 * @param endDate
	 *            passing end date
	 */
	public static int getDateDiffInDay(Date startDate, Date endDate) {
		if (endDate != null && startDate != null) {
			try {
				long diff = endDate.getTime() - startDate.getTime();
				long diffDays = diff / (24 * 60 * 60 * 1000);
				return Long.valueOf(diffDays).intValue();
			} catch (Exception e) {
				LOGGER.error("Error in date parsing " + startDate, e);
			}
		}
		return 0;
	}

	/**
	 * This method is created for get the date difference in hours
	 * 
	 * 
	 * @return <code>Double</code> return difference
	 * @param startDate
	 *            passing start date
	 * @param endDate
	 *            passing end date
	 */
	public static Double getDateDiffInHours(final Date startDate, final Date endDate) {
		try {
			if (startDate != null && endDate != null) {
				double diff = endDate.getTime() - startDate.getTime();
				double diffHours = diff / (60 * 60 * 1000);
				return diffHours;
			}
		} catch (Exception e) {
			LOGGER.error("Error in date parsing : ", e);
		}
		return null;
	}

	/**
	 * This method is created to get the 10 Digit random number
	 * 
	 * 
	 * @return String return 10 Digit random number
	 */
	public static String getRandomNumber() {
		Long number = (new Date().getTime()) / 1000;
		return number.toString();
	}

	/**
	 * parsing the date string into the date object
	 * 
	 * @author gauravk
	 * @date Jun 27, 2017
	 * @param dateParam
	 *            date string
	 * @return Date date object from string
	 */
	public static Date parseDate(final String dateParam) {
		final DateFormat df = new SimpleDateFormat(BaseAppConstants.MM_DD_YYYY.getValue());
		try {
			return df.parse(dateParam);
		} catch (final ParseException e) {
			LOGGER.error("Exception in date parsing " + dateParam, e);
			return null;
		}
	}

	/**
	 * parsing the date into the date string
	 * 
	 * @author gauravk
	 * @date Jun 27, 2017
	 * @param dateParam
	 *            date string
	 * @return Date date object from string
	 */
	public static String parseDateToDateFormat(final Date dateParam) {
		final DateFormat df = new SimpleDateFormat(BaseAppConstants.MM_DD_YYYY.getValue());
		if (dateParam != null) {
			return df.format(dateParam);
		}
		return null;
	}

	/**
	 * Method is written to parse the date string to date Object with time
	 * 
	 * @author gauravk
	 * @date Jun 27, 2017
	 * @param dateParam
	 *            date in string format
	 * @return Date date object with time
	 * @throws ApplicationCustomException
	 *             application custom exception message
	 * @throws NoSuchMessageException
	 *             no available properties error message
	 */
	public static Date parseStringToUTCDateTime(final String dateParam) {
		try {
			return new SimpleDateFormat(BaseAppConstants.MM_DD_YYYY_HH_MM_SS_WITHZONE.getValue()).parse(dateParam);
		} catch (Exception exception) {
			LOGGER.error("Inside parse date exception.", exception);
		}
		return null;
	}

	/**
	 * This method is for the parse date string to convert in to java 7 Date
	 * class object by using java 8 API.
	 * 
	 * 
	 * @param dateParam
	 * @return
	 * @throws NoSuchMessageException
	 * @throws ApplicationCustomException
	 */
	public static Date parseStringToUTCDateTimeJava8(final String dateParam)
			throws NoSuchMessageException, ApplicationCustomException {
		try {
			return Date
					.from(LocalDateTime
							.parse(dateParam,
									DateTimeFormatter
											.ofPattern(BaseAppConstants.MM_DD_YYYY_HH_MM_SS_WITHZONE.getValue()))
							.atZone(ZoneId.systemDefault()).toInstant());
		} catch (Exception e) {
			LOGGER.error("Inside parse date exception.", e);
			throw new ApplicationCustomException(BaseAppConstants.INVALID_DATE_FORMAT_MESSAGE.getValue());
		}
	}

	/**
	 * parsing the date object into the date string
	 * 
	 * 
	 * @return dateParam date string
	 * @param Date
	 *            date string from date object
	 */
	public static String parseUTCDateTimeToString(final Date dateParam) {
		if (dateParam != null) {
			final String dateFormatNow = BaseAppConstants.MM_DD_YYYY_HH_MM_SS_WITHZONE.getValue();
			final SimpleDateFormat sdf = new SimpleDateFormat(dateFormatNow);
			return sdf.format(dateParam);
		}
		return null;
	}

	/**
	 * parsing the date object into the date string by java 8 API.
	 * 
	 * 
	 * @return dateParam date string
	 * @param Date
	 *            date string from date object
	 */
	public static String parseUTCDateTimeToStringJava8(final Date dateParam) {
		if (dateParam != null) {
			final LocalDateTime date = dateParam.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			final DateTimeFormatter formatter = DateTimeFormatter
					.ofPattern(BaseAppConstants.MM_DD_YYYY_HH_MM_SS_WITHZONE.getValue());
			return date.format(formatter);
		}
		return null;
	}

	/**
	 * This method is used to remove a part from the string i.e. base string,
	 * 
	 * 
	 */
	public static String removeStringPart(String baseString, String part) {
		return baseString.replace(part, BaseAppConstants.BLANK.getValue());
	}

	/**
	 * This method is used to concat the strings to single string.
	 * 
	 * @return <code>String</code> concatenated string
	 * @param strings
	 *            array of strings
	 */
	public static String stringConcatanator(String... strings) {
		final StringBuilder stringBuilder = new StringBuilder();
		Arrays.asList(strings).stream().forEach(string -> stringBuilder.append(string));
		return stringBuilder.toString();
	}

	/**
	 * This method is used to concate the strings to single string with a
	 * seperator
	 * 
	 * @return <code>String</code> concatenated string
	 * @param strings
	 *            array of strings
	 */
	public static String stringConcatanatorWithSeparator(final String separator, final String... strings) {
		final StringJoiner stringJoiner = new StringJoiner(separator);
		Arrays.asList(strings).stream().forEach(string -> {
			if (string != null && !string.isEmpty()) {
				stringJoiner.add(string);
			}
		});
		stringJoiner.setEmptyValue(BaseAppConstants.NOT_AVAILABLE.getValue());
		return stringJoiner.toString();
	}

	/**
	 * This method is for validate the phone number.
	 * 
	 * @return <code>boolean</code> return true if phone number is valid.
	 * @param phoneNumber
	 *            phone number.
	 * @return
	 */
	public static boolean isValidPhoneNumber(final String phoneNumber) {
		if (phoneNumber != null && !phoneNumber.isEmpty() && phoneNumber.matches("\\d{10}")) {
			return true;
		}
		return false;
	}

	/**
	 * This method is create to get of timeMilis in date format.
	 * 
	 * @return <code>String</code> date of timeMilise
	 * @param timeInMilise
	 *            timeStampMilise of time.
	 * @return
	 */
	public static String getInDateFormat(final long timeInMilise) {
		if (timeInMilise != 0) {
			SimpleDateFormat sdf = new SimpleDateFormat(BaseAppConstants.MM_DD_YYYY_HH_MM_SS_WITHZONE.getValue());
			return sdf.format(timeInMilise);
		}
		return null;
	}
}
