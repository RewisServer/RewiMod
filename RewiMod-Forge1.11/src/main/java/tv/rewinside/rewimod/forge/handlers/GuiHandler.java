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
package tv.rewinside.rewimod.forge.handlers;

import net.minecraft.client.gui.Gui;
import tv.rewinside.rewimod.core.gui.IGui;
import tv.rewinside.rewimod.core.handlers.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public void drawTexturedModalRect(IGui guiObject, int x, int y, int textureX, int textureY, int width, int height) {
		Gui gui = (Gui) guiObject;
		gui.drawTexturedModalRect(x, y, textureX, textureY, width, height);
	}

	@Override
	public void drawModalRectWithCustomSizedTexture(int x, int y, int textureX, int textureY, int width, int height, int textureWidth, int textureHeight) {
		Gui.drawModalRectWithCustomSizedTexture(x, y, textureX, textureY, width, height, textureWidth, textureHeight);
	}

}
