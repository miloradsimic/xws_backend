package booking_site.xws_proj;

import java.util.Base64;

public class AppUtils {
	
	public static String getUsernameFromBasic(String encoded){
		
		String base64 = encoded.substring(encoded.indexOf(" ")+1, encoded.length());
		
		System.out.println(base64);
		
		String decoded = new String(Base64.getDecoder().decode(base64));

		System.out.println(decoded);
		String username = decoded.substring(0, decoded.indexOf(":"));

		System.out.println(username);
		return username;
	}

	public static String getPasswordFromBasic(String encoded){
		
		String base64 = encoded.substring(encoded.indexOf(" ")+1, encoded.length());
		
		String decoded = new String(Base64.getDecoder().decode(base64));
		
		String password = decoded.substring(decoded.indexOf(":")+1, decoded.length());

		System.out.println(password);
		return password;
	}


}
