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
package tv.rewinside.rewimod.forge.gui.objects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import tv.rewinside.rewimod.core.gui.objects.IGuiButton;
import tv.rewinside.rewimod.forge.RewiForgeMod;
import tv.rewinside.rewimod.forge.gui.GuiRewiReportScreen;

public class GuiRewiReportsButton extends GuiButton implements IGuiButton {

	public GuiRewiReportsButton(int buttonId, int x, int y, int width) {
		super(buttonId, x, y, width, 20, RewiForgeMod.getInstance().getMessageHandler().getMessage("gui.chatlogHistory"));
	}

	@Override
	public void onClick(int mouseButton) {
		Minecraft.getMinecraft().displayGuiScreen(new GuiRewiReportScreen());
	}

}
