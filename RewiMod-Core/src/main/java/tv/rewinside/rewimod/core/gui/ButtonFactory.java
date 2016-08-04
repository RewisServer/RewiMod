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
package tv.rewinside.rewimod.core.gui;

import java.awt.Point;
import tv.rewinside.rewimod.core.RewiMod;

public class ButtonFactory {

	private final String buttonTexture;
	private final int width;
	private final int height;
	private final Point disabledStart;
	private final Point enabledStart;
	private final Point hoveredStart;

	/**
	 * Instantiates ButtonFactory
	 *
	 * @param buttonTexture the path to the buttons texture
	 * @param width the width of the button
	 * @param height the height of the button
	 * @param disabledStart the start point of the <i>disabled</i> texture
	 * @param enabledStart the start point of the <i>enabled</i> texture
	 * @param hoveredStart the start point of the <i>hovered</i> texture
	 */
	public ButtonFactory(String buttonTexture, int width, int height, Point disabledStart, Point enabledStart, Point hoveredStart) {
		this.buttonTexture = buttonTexture;
		this.width = width;
		this.height = height;
		this.disabledStart = disabledStart;
		this.enabledStart = enabledStart;
		this.hoveredStart = hoveredStart;
	}

	/**
	 * Generates and draws a Button
	 *
	 * @param gui the current Gui Element
	 * @param posX the <i>x</i> start position of the button
	 * @param posY the <i>y</i> start position of the button
	 * @param width the <i>width</i> of the button
	 * @param state the {@link tv.rewinside.rewimod.core.gui.ButtonFactory.ButtonState}
	 */
	public void drawButton(IGui gui, int posX, int posY, int width, ButtonState state) {
		Point startPoint = this.getStartPoint(state);
		RewiMod.getInstance().getTextureHandler().bindTexture(this.buttonTexture);
		RewiMod.getInstance().getGlStateManagerHandler().color(1.0F, 1.0F, 1.0F);

		if (width == this.width) {
			RewiMod.getInstance().getGuiHandler().drawTexturedModalRect(gui, posX, posY, (int) startPoint.getX(), (int) startPoint.getY(), width, this.height);
		} else if (width >= this.width) {
			//Left side
			RewiMod.getInstance().getGuiHandler().drawTexturedModalRect(gui, posX, posY, (int) startPoint.getX(), (int) startPoint.getY(), 3, this.height);

			//Middle
			int fullWidth = this.width - (2 * 3);
			int wholeTex = (width - (2 * 3)) / fullWidth;
			int startPos = posX + 3;

			for (int n = 0; n < wholeTex; n++) {
				RewiMod.getInstance().getGuiHandler().drawTexturedModalRect(gui, startPos, posY, (int) startPoint.getX() + 3, (int) startPoint.getY(), fullWidth, this.height);
				startPos += fullWidth;
			}

			//Right side
			RewiMod.getInstance().getGuiHandler().drawTexturedModalRect(gui, startPos, posY, (int) startPoint.getX() + this.width - 3, (int) startPoint.getY(), 3, this.height);
		} else {
			//Left side
			RewiMod.getInstance().getGuiHandler().drawTexturedModalRect(gui, posX, posY, (int) startPoint.getX(), (int) startPoint.getY(), 3, this.height);

			//Middle
			RewiMod.getInstance().getGuiHandler().drawTexturedModalRect(gui, posX + 3, posY, (int) startPoint.getX() + 3, (int) startPoint.getY(), width - 3, this.height);

			//Right side
			RewiMod.getInstance().getGuiHandler().drawTexturedModalRect(gui, posX + width - 3, posY, (int) startPoint.getX() + this.width - 3, (int) startPoint.getY(), 3, this.height);
		}
	}

	/**
	 * Gets the defined start point from the button state
	 *
	 * @param state the {@link tv.rewinside.rewimod.core.gui.ButtonFactory.ButtonState}
	 * @return the {@link java.awt.Point} with the start coordinates of the texture
	 */
	private Point getStartPoint(ButtonState state) {
		switch (state) {
			case DISABLED:
				return this.disabledStart;
			case ENABLED:
				return this.enabledStart;
			case HOVERED:
				return this.hoveredStart;
			default:
				return this.enabledStart;
		}
	}

	public static enum ButtonState {
		DISABLED,
		ENABLED,
		HOVERED;
	}

}
