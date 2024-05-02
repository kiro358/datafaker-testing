package classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Internet {
	public static boolean verifydomainname(String input) {
		//Format in ssss.ssss where s can be any number of characters, after . must be letters
		String[] parts = input.split("\\.");
		if (parts.length == 2) {
			if (parts[1] instanceof String) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean verifystring(String input) {
		//Format in sos where s can be any number of characters, must be string
		if (input instanceof String) {
			return true;
		}
		return false;
	}
	
	public static boolean verifyemail(String input) {
		//Format in ssss@ss.ss where s can be any number of characters including dots
		try {
			String[] parts = input.split("@"); //verify there is an @
			String[] parts2 = parts[1].split("\\."); //verify atleast one dot after @ symbol.
			if (parts[parts.length - 1] instanceof String) { //verify text after the dot is type string and exists
				return true;
			}
			return false;
		}catch(ArrayIndexOutOfBoundsException exception) {//If array index issue, wrong form
			return false;
		}
	}
	
	public static boolean verifyimage(String input) {
		//Format in ssss.ss where s can be any number of characters including dots
		try {
			String[] parts = input.split("@"); //verify there is an @
			String[] parts2 = parts[1].split("\\."); //verify atleast one dot after @ symbol.
			if (parts[parts.length - 1] instanceof String) { //verify text after the dot is type string and exists
				return true;
			}
			return false;
		}catch(ArrayIndexOutOfBoundsException exception) {//If array index issue, wrong form
			return false;
		}
	}
	
	public static boolean verifyip4(String input) {
		//Format in sss.sss.sss.sss where each must be < 255 and > 0
		try {
			String[] parts = input.split("\\.");
			for (int i = 0; i < parts.length; i++) {
				int num = Integer.parseInt(parts[i]);
				if ((num < 0 ) || (num > 255)) { //Num is not 0-254
					return false;
				}
			}
			return true;
		}catch(NumberFormatException exception) {//If string cannot be converted to number, return exception
			return false;
		}
	}
	
	public static boolean verifyip4cidr(String input) {
		//Format in sss.sss.sss.sss/ss where each must be < 255 and > 0
		try {
			String[] parts = input.split("\\.");
			for (int i = 0; i < parts.length; i++) {
				if (i == (parts.length - 1)){
					String[] parts2 = parts[i].split("/");
					int num = Integer.parseInt(parts2[0]);
					if ((num < 0 ) || (num > 255)) { //Num is not 0-254
						return false;
					}
					num = Integer.parseInt(parts2[1]);
					if ((num < 0 ) || (num > 255)) { //Num is not 0-254
						return false;
					}
				}else {
					int num = Integer.parseInt(parts[i]);
					if ((num < 0 ) || (num > 255)) { //Num is not 0-254
						return false;
					}
				}	
			}
			return true;
		}catch(NumberFormatException exception) {//If string cannot be converted to number, return exception
			return false;
		}
	}
	
	public static boolean verifyipv6(String input) {
		//Format in ssss:ssss:ssss:ssss:ssss:ssss:ssss:ssss
		String[] parts = input.split(":"); //verify there are 8 strings
		if (parts.length == 8) {
			for(int i = 0; i < parts.length; i++) {
				if (parts[i] instanceof String) {
					
				}else {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean verifyipv6cidr(String input) {
		//Format in ssss:ssss:ssss:ssss:ssss:ssss:ssss:ssss/76
		String[] parts = input.split(":"); //verify there are 8 strings
		if (parts.length == 8) {
			for(int i = 0; i < parts.length; i++) {
				if (parts[i] instanceof String) {
					
				}else {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean verifymac(String input) {
		//Format in ssss:ssss:ssss:ssss:ssss:ssss
		String[] parts = input.split(":"); //verify there are 6 strings
		if (parts.length == 8) {
			for(int i = 0; i < parts.length; i++) {
				if ((parts[i] instanceof String) && (parts[i].length() == 2)) { //verify they are length 2
					
				}else {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean verifymacname(String input) {
		//Format in ssss:ssss:ssss:ssss:ssss:ssss
		String[] parts = input.split(":"); //verify there are 6 strings
		if (parts.length == 8) {
			for(int i = 1; i < parts.length; i++) {
				if ((parts[i] instanceof String) && (parts[i].length() == 2)) { //verify they are length 2
					
				}else {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean verifypassnum(String input) {
		//Format in ss where s is any number of strings
		Boolean flag = false;
		for (int i = 0; i < input.length(); i++){
		    char c = input.charAt(i);        
		    flag = Character.isDigit(c);
		    if (flag) {
		    	return true;
		    }
		}
		return false;
	}
	
	public static boolean verifypassnum2(String input, int num1, int num2) {
		//Format in ss where s is any number of strings
		if ((input.length() >= num1) && (input.length() <= num2)) {
			return true;
		}
		return false;
	}
	
	public static boolean verifypassnum3(String input, int num1, int num2) {
		//Format in ss where s is any number of strings
		if ((input.length() >= num1) && (input.length() <= num2)) {
			return true;
		}
		return false;
	}
	
	public static boolean verifypassnum4(String input, int num2, int num1, boolean cap, boolean special, boolean digit) {
		//Format in ss where s is any number of strings
		boolean flagd = false;
		boolean flagu = false;
		
		//num1 is max, num2 is min
		if (num1 == 0 && num2 == 0) { //If max is 0 and min is 0
			if (input.isEmpty()) { //String should be empty
				return true;
			}else {
				return false;
			}
		}
		if ((input.length() >= num2) && (input.length() <= num1)) {
			for (int i = 0; i < input.length(); i++){
			    char c = input.charAt(i);        
			    if (Character.isDigit(c)) {
			    	flagd = true;
			    }
			    if (Character.isUpperCase(c)) {
			    	flagu = true;
			    }
			}
			if (cap && special && digit) { //check if cap special and digit were required
				if (flagd && flagu) { //check if they were found
					return true; // return true
				}
				return false;
			}
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean verifyurl(String input) {
		//Format in www.sss.sss where s is any number of characters
		String[] parts = input.split("\\."); //split string by .
		if (parts[0].length() == 3) { //www
			if (parts[parts.length - 1] instanceof String) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean verifyuid(String input) {
		//Format in ssssssss-ssss-ssss-ssss-ssssssssssss
		String[] parts = input.split("-"); //split string by .
		if (parts[0].length() == 8) { //www
			if ((parts[1].length() == 4) && (parts[2].length() == 4) && (parts[3].length() == 4)){
				if ((parts[4].length() == 12)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean verifyport(int input) {
		if ((input >= 0) && (input <= 100000)){
			return true;
		}
		return false;
	}
}
