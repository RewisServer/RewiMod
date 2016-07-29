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

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public final class ManifestParser {

	private static Manifest manifest = null;

	/**
	 * @throws UnsupportedOperationException
	 */
	private ManifestParser() {
		throw new UnsupportedOperationException("Cannot instantiate helper class!");
	}

	/**
	 * Gets the Specification Title from Manifest
	 *
	 * @return the Specification-Title as String
	 */
	public static String getSpecificationTitle() {
		if (!checkLoaded()) return "Unknown";

		return manifest.getMainAttributes().getValue(Attributes.Name.SPECIFICATION_TITLE);
	}

	/**
	 * Gets the Specification Version from Manifest
	 *
	 * @return the Specification-Version as String
	 */
	public static String getSpecificationVersion() {
		if (!checkLoaded()) return "Unknown";

		return manifest.getMainAttributes().getValue(Attributes.Name.SPECIFICATION_VERSION);
	}

	/**
	 * Gets the Specification Vendor from Manifest
	 *
	 * @return the Specification-Vendor as String
	 */
	public static String getSpecificationVendor() {
		if (!checkLoaded()) return "Unknown";

		return manifest.getMainAttributes().getValue(Attributes.Name.SPECIFICATION_VENDOR);
	}

	/**
	 * Parses the Manifest File
	 *
	 * @return wether the parsing succeeded or failed
	 */
	private static boolean parse() {
		URLClassLoader cLoader = (URLClassLoader) ManifestParser.class.getClassLoader();

		try {
			URL url = cLoader.findResource("META-INF/MANIFEST.MF");
			manifest = new Manifest(url.openStream());
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * Checks if there is a Manifest file loaded
	 *
	 * @return wether there is a manifest file loaded or not
	 */
	private static boolean checkLoaded() {
		if (manifest == null) {
			return parse();
		}

		return true;
	}

}
