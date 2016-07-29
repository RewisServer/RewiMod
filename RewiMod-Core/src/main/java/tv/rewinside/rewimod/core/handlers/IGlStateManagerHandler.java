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
package tv.rewinside.rewimod.core.handlers;

public interface IGlStateManagerHandler {

	/**
	 * Colors the bounded texture
	 *
	 * @param r the red color value
	 * @param g the green color value
	 * @param b the blue color value
	 * @see tv.rewinside.rewimod.core.handlers.ITextureHandler#bindTexture(java.lang.String)
	 */
	public void color(float r, float g, float b);

}
