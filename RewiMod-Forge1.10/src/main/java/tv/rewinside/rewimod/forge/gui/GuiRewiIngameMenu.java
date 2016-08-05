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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import tv.rewinside.rewimod.core.RewiMod;
import tv.rewinside.rewimod.core.gui.objects.IGuiButton;
import tv.rewinside.rewimod.core.util.CoordinateUtil;
import tv.rewinside.rewimod.forge.gui.objects.GuiRewiReportsButton;

public class GuiRewiIngameMenu extends GuiIngameMenu {

	private final Map<Integer, IGuiButton> buttons = new HashMap<>();

	@Override
	public void initGui() {
		this.buttons.clear();
		super.initGui();

		int lastId = super.buttonList.size();

		lastId += 100; //Mojang Nailed it

		super.buttonList.add(this.registerButton(new GuiRewiReportsButton(lastId + 2, this.width / 2 + 104, this.height / 4 + 56)));
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);

		for (Map.Entry entry : this.buttons.entrySet()) {
			GuiButton guiButton = (GuiButton) entry.getValue();

			if (CoordinateUtil.inbetween(guiButton.xPosition, guiButton.yPosition, mouseX, mouseY, guiButton.width, guiButton.height)) {
				((IGuiButton) guiButton).onClick(mouseButton);
			}
		}
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		String confirmMessage = RewiMod.getInstance().getMessages().getMessage("gui.confirmDisconnect");

		if (button.id == 1 && !button.displayString.equals(confirmMessage)) {
			button.displayString = confirmMessage;
			button.packedFGColour = RewiMod.getInstance().getConfirmDisconnectButtonColor();
			return;
		}

		super.actionPerformed(button);
	}

	private GuiButton registerButton(IGuiButton button) {
		GuiButton btn = (GuiButton) button;
		this.buttons.put(btn.id, button);

		return btn;
	}

}
