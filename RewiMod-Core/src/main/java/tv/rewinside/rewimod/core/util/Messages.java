/*
 * RewiMod, a Minecraft Client Enhancement
 * Copyright (C) rewinside.tv <https://rewinside.tv/>
 * Copyright (C) RewiMod team and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package tv.rewinside.rewimod.core.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import tv.rewinside.rewimod.core.RewiMod;

public class Messages {

	private final HashMap<String, String> messages = new HashMap<>();

	/**
	 * Loads the given Language
	 *
	 * @param locale the Locale
	 */
	public final void load(String locale) {
		if (locale != null) locale = locale.replace('-', '_');
		try {
			URL url = locale == null ? this.getDefaultLanguageFile() : this.getClass().getResource("/assets/rewimod/lang/" + locale + ".lang");

			if (url == null) {
				url = this.getDefaultLanguageFile();
			}

			InputStreamReader reader = new InputStreamReader(url.openStream());
			this.parse(new BufferedReader(reader));
		} catch (IOException ex) {
			RewiMod.LOGGER.fatal("Error while loading Language File", ex);
		}
	}

	/**
	 * Gets a Message
	 *
	 * @param key the key as defined in the selected language
	 * @return the message as defined in the selected language
	 */
	public String getMessage(String key) {
		return this.messages.get(key);
	}

	/**
	 * Parses the Language File
	 *
	 * @param reader a {@link java.io.BufferedReader} that representates the Language File
	 */
	private void parse(BufferedReader reader) {
		this.messages.clear();
		reader.lines().map(String::trim).filter(line -> !line.startsWith("#") && !line.isEmpty()).forEach(line -> {
			String[] splitted = line.split("=");

			//Do not process if there is only one element
			if (splitted.length >= 2) {
				String key = splitted[0].trim();
				String value;

				if (splitted.length == 2) {
					//Directly pass the String
					value = splitted[1].trim();
				} else {
					//Add '=' Back to Strings
					String[] newArray = new String[splitted.length - 1];
					System.arraycopy(splitted, 1, newArray, 0, newArray.length);
					value = String.join("=", newArray);
				}

				this.messages.put(key, value);
			}
		});
	}

	/**
	 * Gets te default language file
	 *
	 * @return the URL representating the language file
	 * @throws FileNotFoundException if the default language file could not be found
	 */
	private URL getDefaultLanguageFile() throws FileNotFoundException {
		URL url = this.getClass().getResource("/assets/rewimod/lang/de_DE.lang");

		if (url == null) {
			throw new FileNotFoundException("Could not find default language file!");
		}

		return url;
	}

}
