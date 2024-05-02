package classes;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Finance {
	public Finance() {
		//Empty Constructor
		
	}
	
	public static boolean verifyexpiry(String input) {
		//Format in yyyy-mm-dd can be compared lexograpically
		String currentdate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		if (currentdate.compareTo(input) <= 0) {
			return true;
		}
		return false;
	}
	
	public static boolean verifycard(String input) {
		try {
			//Format in ####-####-####-####
			String[] parts = input.split("-");
			for (int i = 0; i < parts.length; i++) {
				int num = Integer.parseInt(parts[i]);
			}
			//If not a number, will throw a numberformatexception
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static boolean verifytype(String input) {
		//Format is string (Not verifying whether company exists)
		if (input instanceof String) {
			return true;
		}
		return false;
	}
	
	public static boolean verifysecurity(String input) {
		try {
			//Format in ###
			if (input.length() == 3) {//Must be length 3
				int number = Integer.parseInt(input); //Must be numbers
			}
			//If not a number, will throw a numberformatexception
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static boolean verifyhash(Integer input) {
		//Verify if number
		if (input instanceof Integer) {
			return true;
		}
		return false;
	}
}
