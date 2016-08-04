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
import net.minecraft.client.gui.GuiMainMenu;
import tv.rewinside.rewimod.core.gui.objects.IGuiButton;
import tv.rewinside.rewimod.core.util.CoordinateUtil;
import tv.rewinside.rewimod.forge.gui.objects.GuiRewiConnectButton;
import tv.rewinside.rewimod.forge.gui.objects.GuiRewiModButton;

public class GuiRewiMainMenu extends GuiMainMenu {

	private final Map<Integer, IGuiButton> buttons = new HashMap<>();

	@Override
	public void initGui() {
		this.buttons.clear();
		super.initGui();

		int lastId = super.buttonList.size();

		super.buttonList.add(this.registerButton(new GuiRewiConnectButton(lastId++, this.width / 2 + 80, this.height / 4 + 72)));
		super.buttonList.add(this.registerButton(new GuiRewiModButton(lastId++, this.width / 2 + 104, this.height / 4 + 132)));
		super.buttonList.get(1).width = 177;
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

	private GuiButton registerButton(IGuiButton button) {
		GuiButton btn = (GuiButton) button;
		this.buttons.put(btn.id, button);

		return btn;
	}

}
