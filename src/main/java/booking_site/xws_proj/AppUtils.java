package booking_site.xws_proj;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class AppUtils {

	public static String getUsernameFromBasic(String encoded) {

		if (encoded == null || !encoded.startsWith("Basic")) {
			return "";
		}

		String base64 = encoded.substring(encoded.indexOf(" ") + 1, encoded.length());

		String decoded = new String(Base64.getDecoder().decode(base64));

		String username = decoded.substring(0, decoded.indexOf(":"));

		return username;
	}

	public static String getPasswordFromBasic(String encoded) {

		if (encoded == null || !encoded.startsWith("Basic")) {
			return "";
		}

		String base64 = encoded.substring(encoded.indexOf(" ") + 1, encoded.length());

		String decoded = new String(Base64.getDecoder().decode(base64));

		String password = decoded.substring(decoded.indexOf(":") + 1, decoded.length());

		return password;
	}

	public static String encryptBasic(String email, String password) {
		String credentials = email + ":" + password;
		String encoded = "";
		try {
			encoded = Base64.getEncoder().encodeToString(credentials.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}

		return "Basic " + encoded;
	}

}
