package fr.eni.encheres.messages;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class BundleUtil {
	private static Locale locale = Locale.ENGLISH;
	private static ResourceBundle messages = ResourceBundle.getBundle("fr.formation.vote.messages.messages",locale);

	public static String getMessage(String key) {
		return messages.getString(key);
	}
	
	public static String getMessage(String key,Object... params) {
		return MessageFormat.format(messages.getString(key), params);
	}
}
