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
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tv.rewinside.rewimod.core.RewiMod;
import tv.rewinside.rewimod.core.gui.CoreGuiDrawer;

public class GuiRewiIngameOverlay extends Gui {

	private final Minecraft mc;
	private final int fontHeight;
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

	private final TextFormatting text = TextFormatting.DARK_PURPLE;
	private final TextFormatting colon = TextFormatting.DARK_GRAY;
	private final TextFormatting value = TextFormatting.GOLD;

	public GuiRewiIngameOverlay() {
		this.mc = Minecraft.getMinecraft();
		this.fontHeight = this.mc.fontRendererObj.FONT_HEIGHT;
	}

	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.ALL && !this.mc.gameSettings.showDebugInfo) {
			this.drawOverlay();
		}
	}

	private void drawOverlay() {
		String timeText = RewiMod.getInstance().getMessages().getMessage("gui.overlay.time");

		CoreGuiDrawer.drawTransparentString(TextFormatting.GRAY + "RewiMod Alpha", 5, fontHeight / 2, 80, false);
		super.drawString(this.mc.fontRendererObj, text + "FPS" + colon + ": " + value + Minecraft.getDebugFPS(), 5, fontHeight * 2 + 5, 0xF);
		super.drawString(this.mc.fontRendererObj, text + timeText + colon + ": " + value + dateFormat.format(new Date(System.currentTimeMillis())), 5, fontHeight * 3 + 5, 0xF);
		super.drawString(this.mc.fontRendererObj,
				text + "X" + colon + ": " + value + (double) Math.round(this.mc.thePlayer.posX * 100d) / 100d
						+ text + " Y" + colon + ": " + value + (double) Math.round(this.mc.thePlayer.posY * 100d) / 100d
						+ text + " Z" + colon + ": " + value + (double) Math.round(this.mc.thePlayer.posZ * 100d) / 100d
				, 5, fontHeight * 4 + 5, 0xF);
	}

}
