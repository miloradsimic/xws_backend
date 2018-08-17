package booking_site.xws_proj;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import booking_site.xws_proj.dto.request.UserLoginRequestDTO;

public class AppUtils {

	public static String getUsernameFromBasic(String encoded) {

		String base64 = encoded.substring(encoded.indexOf(" ") + 1, encoded.length());

		System.out.println(base64);

		String decoded = new String(Base64.getDecoder().decode(base64));

		System.out.println(decoded);
		String username = decoded.substring(0, decoded.indexOf(":"));

		System.out.println(username);
		return username;
	}

	public static String getPasswordFromBasic(String encoded) {

		String base64 = encoded.substring(encoded.indexOf(" ") + 1, encoded.length());

		String decoded = new String(Base64.getDecoder().decode(base64));

		String password = decoded.substring(decoded.indexOf(":") + 1, decoded.length());

		System.out.println(password);
		return password;
	}

	public static String encryptBasic(UserLoginRequestDTO user) {
		String credentials = user.email + ":" + user.password;
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
