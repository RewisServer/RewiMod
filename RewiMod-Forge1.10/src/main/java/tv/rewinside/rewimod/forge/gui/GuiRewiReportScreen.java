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
package tv.rewinside.rewimod.forge.gui;

import net.minecraft.client.gui.GuiScreen;
import tv.rewinside.rewimod.core.util.Chatlog;
import tv.rewinside.rewimod.forge.RewiForgeMod;

import java.awt.Color;
import java.text.SimpleDateFormat;

public class GuiRewiReportScreen extends GuiScreen {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("[HH:mm]");

	@Override
	public void initGui() {
		super.initGui();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawDefaultBackground();

		int i = 0;
		for (Chatlog chatlog : RewiForgeMod.getInstance().getChatlogs()) {
			this.drawString(this.fontRendererObj, DATE_FORMAT.format(chatlog.getCreation()) + " - " + chatlog.getUser() + " - " + chatlog.getLink(), 12, 10 + 10 * i++, Color.ORANGE.getRGB());
		}
	}

}
