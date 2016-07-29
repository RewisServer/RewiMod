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

public class CoordinateUtil {

	/**
	 * @throws UnsupportedOperationException
	 */
	private CoordinateUtil() {
		throw new UnsupportedOperationException("Cannot instantiate helper class!");
	}

	/**
	 * Checks if the given Coordinates are inbetween the other given Coordinates
	 *
	 * @param x1 the <i>x</i> boundary of the outer coordinates
	 * @param y1 the <i>y</i> boundary of the outer coordinates
	 * @param x2 the <i>x</i> boundary of the coordinate that should be checked
	 * @param y2 the <i>y</i> boundary of the coordinate that sohould be checked
	 * @param width the <i>width</i> of the object
	 * @param height the <i>height</i> of the object
	 * @return wether the second pair of coordinates is inbetween the first pair of coordinates
	 */
	public static boolean inbetween(int x1, int y1, int x2, int y2, int width, int height) {
		return x2 >= x1
				&& y2 >= y1
				&& x2 < x1 + width
				&& y2 < y1 + height;
	}
}
