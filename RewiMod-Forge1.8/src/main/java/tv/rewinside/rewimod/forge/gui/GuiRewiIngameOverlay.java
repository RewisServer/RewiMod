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

import java.text.SimpleDateFormat;
import java.util.Date;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.EnumChatFormatting;
import tv.rewinside.rewimod.core.RewiMod;

public class GuiRewiIngameOverlay extends Gui {

	private final Minecraft mc;
	private final int fontHeight;
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

	private final EnumChatFormatting text = EnumChatFormatting.DARK_PURPLE;
	private final EnumChatFormatting colon = EnumChatFormatting.DARK_GRAY;
	private final EnumChatFormatting value = EnumChatFormatting.GOLD;

	private long oldPing = -1;

	public GuiRewiIngameOverlay() {
		this.mc = Minecraft.getMinecraft();
		this.fontHeight = this.mc.fontRendererObj.FONT_HEIGHT;
	}

	public void drawOverlay() {
		String timeText = RewiMod.getInstance().getMessages().getMessage("gui.overlay.time");
		ServerData serverData = this.mc.getCurrentServerData();
		long ping = serverData != null ? serverData.pingToServer : -1;

		super.drawString(this.mc.fontRendererObj, this.text + "FPS" + this.colon + ": " + this.value + Minecraft.getDebugFPS(), 5, this.fontHeight / 2 + 1, 0xF);
		super.drawString(this.mc.fontRendererObj, this.text + timeText + this.colon + ": " + this.value + this.dateFormat.format(new Date(System.currentTimeMillis())), 5, this.fontHeight + 5, 0xF);
		super.drawString(this.mc.fontRendererObj, this.text + "X" + this.colon + ": " + this.value + Math.round(this.mc.thePlayer.posX * 100d) / 100d, 5, this.fontHeight * 2 + 5, 0xF);
		super.drawString(this.mc.fontRendererObj, this.text + "Y" + this.colon + ": " + this.value + Math.round(this.mc.thePlayer.posY * 100d) / 100d, 5, this.fontHeight * 3 + 5, 0xF);
		super.drawString(this.mc.fontRendererObj, this.text + "Z" + this.colon + ": " + this.value + Math.round(this.mc.thePlayer.posZ * 100d) / 100d, 5, this.fontHeight * 4 + 5, 0xF);
		if (!Minecraft.getMinecraft().isSingleplayer()) {
			super.drawString(this.mc.fontRendererObj, this.text + "Ping" + this.colon + ": " + this.value + (ping != -1 ? ping : this.oldPing != -1 ? this.oldPing : ".."), 5, this.fontHeight * 5 + 5, 0xF);
		}

		if (ping != -1) {
			this.oldPing = ping;
		}
	}

}
