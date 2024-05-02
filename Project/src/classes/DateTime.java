package classes;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.time.Duration;
import java.time.Instant;
public class DateTime {

	public DateTime() {

	}
	
	public static boolean verifybirthdate(String input) {
		//Format in yyyy-mm-dd
		String[] parts = input.split("/");
		if (parts[0].length() == 4) {
			if ((parts[1].length() == 2) && (parts[2].length() == 2)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean verifybirthdatestamp(Timestamp input) {
		//Verify if timestamp
		if (input instanceof Timestamp) {
			return true;
		}
		return false;
	}
	
	public static boolean verifyduration(Duration input) {
		//Verify if duration
		if (input instanceof Duration) {
			return true;
		}
		return false;
	}
	
	public static boolean verifyfutures1(Timestamp input) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		if (input.compareTo(timestamp) > 0) {//Input should be AFTER today's date
			return true;
		}
		return false;
	}
	
	public static boolean verifyfutures2(Timestamp input, int start, int end) {
		//Sets minimum day
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		cal.add(Calendar.DAY_OF_WEEK, start);
		timestamp.setTime(cal.getTime().getTime());
		timestamp = new Timestamp(cal.getTime().getTime());
		
		//Sets maximum day
		Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(timestamp2);
		cal2.add(Calendar.DAY_OF_WEEK, end);
		timestamp2.setTime(cal2.getTime().getTime());
		timestamp2 = new Timestamp(cal2.getTime().getTime());
		
		if ((input.compareTo(timestamp) > 0) && (input.compareTo(timestamp2) < 0)) {//Input should be between the two ranges
			return true;
		}
		return false;
	}
	
	public static boolean verifyfutures3(String input) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		//Timestamp ts = Timestamp.valueOf(input);
		String ts = timestamp.toString(); //Ts today should be BEFORE input
		if (ts.compareTo(input) < 0) {//Input should be AFTER today's date
			return true;
		}
		return false;
	}
	
	public static boolean verifyfutures4(String input, int start, int end) {
		//Sets minimum day
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		cal.add(Calendar.DAY_OF_WEEK, start);
		timestamp.setTime(cal.getTime().getTime());
		timestamp = new Timestamp(cal.getTime().getTime());
		String ts = timestamp.toString();
		
		//Sets maximum day
		Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(timestamp2);
		cal2.add(Calendar.DAY_OF_WEEK, end);
		timestamp2.setTime(cal2.getTime().getTime());
		timestamp2 = new Timestamp(cal2.getTime().getTime());
		String ts2 = timestamp2.toString();
		if ((input.compareTo(ts) > 0) && (input.compareTo(ts2) < 0)) {//Input should be between the two ranges
			return true;
		}
		return false;
	}
	
	public static boolean verifypast1(Timestamp input) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		if (input.compareTo(timestamp) < 0) {//Input should be BEFORE today's date
			return true;
		}
		return false;
	}
	
	public static boolean verifypast2(Timestamp input, int start, int end) {
		//Sets minimum day
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		cal.add(Calendar.DAY_OF_WEEK, -start);
		timestamp.setTime(cal.getTime().getTime());
		timestamp = new Timestamp(cal.getTime().getTime());
		
		//Sets maximum day
		Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(timestamp2);
		cal2.add(Calendar.DAY_OF_WEEK, -end);
		timestamp2.setTime(cal2.getTime().getTime());
		timestamp2 = new Timestamp(cal2.getTime().getTime());
		if ((input.compareTo(timestamp) < 0) && (input.compareTo(timestamp2) > 0)) {//Input should be between the two ranges
			return true;
		}
		return false;
	}
	
	public static boolean verifypast3(String input) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		//Timestamp ts = Timestamp.valueOf(input);
		String ts = timestamp.toString(); //Ts today should be BEFORE input
		if (ts.compareTo(input) < 0) {//Input should be before today's date
			return true;
		}
		return false;
	}
	
	public static boolean verifypast4(String input, int start, int end) {
		//Sets minimum day
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		cal.add(Calendar.DAY_OF_WEEK, start);
		timestamp.setTime(cal.getTime().getTime());
		timestamp = new Timestamp(cal.getTime().getTime());
		String ts = timestamp.toString();
		
		//Sets maximum day
		Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(timestamp2);
		cal2.add(Calendar.DAY_OF_WEEK, end);
		timestamp2.setTime(cal2.getTime().getTime());
		timestamp2 = new Timestamp(cal2.getTime().getTime());
		String ts2 = timestamp2.toString();
		System.out.println("input = " + input);
		System.out.println("start time = " + ts);
		System.out.println(ts2);
		if ((input.compareTo(ts) > 0) && (input.compareTo(ts2) < 0)) {//Input should be between the two ranges
			return true;
		}
		return false;
	}
}