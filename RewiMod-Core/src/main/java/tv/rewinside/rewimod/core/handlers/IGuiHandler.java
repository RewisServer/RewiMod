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

import tv.rewinside.rewimod.core.gui.IGui;

public interface IGuiHandler {

	/**
	 * Draws a textured Rectangle
	 *
	 * @param guiObject The GuiObject that requested the draw
	 * @param x the <i>x</i> position of the rectangle to draw
	 * @param y the <i>y</i> position of the rectangle to draw
	 * @param textureX the <i>x</i> boundary of the bounded texture
	 * @param textureY the <i>y</i> boundary of the bounded texture
	 * @param width the <i>width</i> of the bounded texture
	 * @param height the <i>height</i> of the bounded texture
	 * @see tv.rewinside.rewimod.core.handlers.ITextureHandler#bindTexture(java.lang.String)
	 */
	public void drawTexturedModalRect(IGui guiObject, int x, int y, int textureX, int textureY, int width, int height);

	/**
	 * Draws a scaled textured rectangle
	 *
	 * @param x the <i>x</i> position ot the rectangle to draw
	 * @param y the <i>y</i> position of the rectangle to draw
	 * @param textureX the <i>x</i> boundary of the bounded texture
	 * @param textureY the <i>y</i> boundary of the bounded texture
	 * @param width the <i>width</i> of the rectangle
	 * @param height the <i>height</i> of the rectangle
	 * @param textureWidth the scaled <i>width</i> of the texture
	 * @param textureHeight the scaled <i>height</i> of the texture
	 * @see tv.rewinside.rewimod.core.handlers.ITextureHandler#bindTexture(java.lang.String)
	 */
	public void drawModalRectWithCustomSizedTexture(int x, int y, int textureX, int textureY, int width, int height, int textureWidth, int textureHeight);

}
