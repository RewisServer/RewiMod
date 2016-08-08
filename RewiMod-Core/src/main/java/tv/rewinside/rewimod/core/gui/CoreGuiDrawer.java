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

import tv.rewinside.rewimod.core.RewiMod;
import tv.rewinside.rewimod.core.gui.objects.IGuiButton;
import tv.rewinside.rewimod.core.handlers.IFontRendererObjHandler;
import tv.rewinside.rewimod.core.handlers.IGlStateManagerHandler;
import tv.rewinside.rewimod.core.handlers.IGuiHandler;
import tv.rewinside.rewimod.core.handlers.ITextureHandler;
import tv.rewinside.rewimod.core.util.CoordinateUtil;
import tv.rewinside.rewimod.core.util.RewiButtonConnectType;

public class CoreGuiDrawer {

	/**
	 * @throws UnsupportedOperationException
	 */
	private CoreGuiDrawer() {
		throw new UnsupportedOperationException("Cannot instantiate helper class!");
	}

	/**
	 * Draws a text with the given transparency
	 *
	 * @param text the text
	 * @param xPos the <i>x</i> coordinate of the text
	 * @param yPos the <i>y</i> coordinate of the text
	 * @param transparency the transparency in percent
	 * @param shadow whether the text should have a shadow or not
	 */
	public static void drawTransparentString(String text, int xPos, int yPos, int transparency, boolean shadow) {
		if (transparency > 100 || transparency < 0) throw new IllegalArgumentException("Transparency can not be " + transparency + "%");

		int i = 0xF | (int) ((transparency / 100d) * 255) << 24;

		getGlStateManager().pushMatrix();
		getGlStateManager().enableBlend();
		if (shadow) {
			getFontRendererObjHandler().drawStringWithShadow(text, xPos, yPos, i);
		} else {
			getFontRendererObjHandler().drawString(text, xPos, yPos, i);
		}
		getGlStateManager().disableAlpha();
		getGlStateManager().disableBlend();
		getGlStateManager().popMatrix();
	}

	/**
	 * Draws a small button with the youtube logo on it
	 *
	 * @param button the representating button
	 * @param visible wether the button is visible or not
	 * @param xPos the <i>x</i> coordinate of the button
	 * @param yPos the <i>y</i> coordinate of the button
	 * @param mouseX the <i>x</i> coordinate of the cursor
	 * @param mouseY the <i>y</i> coordinate of the cursor
	 * @param width the <i>width</i> of the button
	 * @param height the <i>height</i> of the button
	 */
	public static void drawButtonYoutube(IGuiButton button, boolean visible, int xPos, int yPos, int mouseX, int mouseY, int width, int height) {
		if (!visible) return;

		boolean isHovered = CoordinateUtil.inbetween(xPos, yPos, mouseX, mouseY, width, height);

		RewiMod.getInstance().getDefaultButtonFactory().drawButton(button, xPos, yPos, width, isHovered ? ButtonFactory.ButtonState.HOVERED : ButtonFactory.ButtonState.ENABLED);

		getTextureHandler().bindModTexture("textures/misc/youtube256.png");
		getGlStateManager().color(1.0F, 1.0F, 1.0F);

		drawCustomSizeRect(xPos + 3, yPos + 3, 0, 0, 14, 14);
	}

	/**
	 * Draws a small button with the twitter logo on it
	 *
	 * @param button the representating button
	 * @param visible wether the button is visible or not
	 * @param xPos the <i>x</i> coordinate of the button
	 * @param yPos the <i>y</i> coordinate of the button
	 * @param mouseX the <i>x</i> coordinate of the cursor
	 * @param mouseY the <i>y</i> coordinate of the cursor
	 * @param width the <i>width</i> of the button
	 * @param height the <i>height</i> of the button
	 */
	public static void drawButtonTwitter(IGuiButton button, boolean visible, int xPos, int yPos, int mouseX, int mouseY, int width, int height) {
		if (!visible) return;

		boolean isHovered = CoordinateUtil.inbetween(xPos, yPos, mouseX, mouseY, width, height);

		RewiMod.getInstance().getDefaultButtonFactory().drawButton(button, xPos, yPos, width, isHovered ? ButtonFactory.ButtonState.HOVERED : ButtonFactory.ButtonState.ENABLED);

		getTextureHandler().bindModTexture("textures/misc/twitter256.png");
		getGlStateManager().color(1.0F, 1.0F, 1.0F);

		drawCustomSizeRect(xPos + 3, yPos + 3, 0, 0, 14, 14);
	}

	/**
	 * Draws a small button with the skin face of rewinside on it
	 *
	 * @param connectType the connect type
	 * @param button the representating button
	 * @param visible wether the button is visible or not
	 * @param xPos the <i>x</i> coordinate of the button
	 * @param yPos the <i>y</i> coordinate of the button
	 * @param mouseX the <i>x</i> coordinate of the cursor
	 * @param mouseY the <i>y</i> coordinate of the cursor
	 * @param width the <i>width</i> of the button
	 * @param height the <i>height</i> of the button
	 */
	public static void drawButtonRewiConnect(RewiButtonConnectType connectType, IGuiButton button, boolean visible, int xPos, int yPos, int mouseX, int mouseY, int width, int height) {
		if (!visible) return;

		boolean isHovered = CoordinateUtil.inbetween(xPos, yPos, mouseX, mouseY, width, height);

		RewiMod.getInstance().getDefaultButtonFactory().drawButton(button, xPos, yPos, width, isHovered ? ButtonFactory.ButtonState.HOVERED : ButtonFactory.ButtonState.ENABLED);

		getTextureHandler().bindModTexture("textures/misc/" + (connectType == RewiButtonConnectType.MINECRAFT ? "rewiHead16" : "teamspeak256") + ".png");
		getGlStateManager().color(1.0F, 1.0F, 1.0F);

		drawCustomSizeRect(xPos + 3, yPos + 3, 0, 0, 14, 14);
	}

	/**
	 * Draws a small button with the logo of the RewiMod on it
	 *
	 * @param button the representating button
	 * @param visible wether the button is visible or not
	 * @param xPos the <i>x</i> coordinate of the button
	 * @param yPos the <i>y</i> coordinate of the button
	 * @param mouseX the <i>x</i> coordinate of the cursor
	 * @param mouseY the <i>y</i> coordinate of the cursor
	 * @param width the <i>width</i> of the button
	 * @param height the <i>height</i> of the button
	 */
	public static void drawButtonRewiMod(IGuiButton button, boolean visible, int xPos, int yPos, int mouseX, int mouseY, int width, int height) {
		if (!visible) return;

		boolean isHovered = CoordinateUtil.inbetween(xPos, yPos, mouseX, mouseY, width, height);

		RewiMod.getInstance().getDefaultButtonFactory().drawButton(button, xPos, yPos, width, isHovered ? ButtonFactory.ButtonState.HOVERED : ButtonFactory.ButtonState.ENABLED);

		getTextureHandler().bindModTexture("textures/misc/rewimodlogo.png");
		getGlStateManager().color(isHovered ? .7F : 1.0F, 1.0F, 1.0F);

		drawCustomSizeRect(xPos + 4, yPos + 4, 0, 0, 12, 12);
	}

	/**
	 * Shortcut method for getting the GlStateManagerHandler
	 *
	 * @return the representation of the GlStateManagerHandler
	 */
	private static IGlStateManagerHandler getGlStateManager() {
		return RewiMod.getInstance().getGlStateManagerHandler();
	}

	/**
	 * Shortcut method for getting the GuiHandler
	 *
	 * @return the representation of the GuiHandler
	 */
	private static IGuiHandler getGuiHandler() {
		return RewiMod.getInstance().getGuiHandler();
	}

	/**
	 * Shortcut method for getting the TextureHandler
	 *
	 * @return the representation of the TextureHandler
	 */
	private static ITextureHandler getTextureHandler() {
		return RewiMod.getInstance().getTextureHandler();
	}

	/**
	 * Shortcut method for getting the FontRendererObjHandler
	 *
	 * @return the representation of the FontRendererObjHandler
	 */
	private static IFontRendererObjHandler getFontRendererObjHandler() {
		return RewiMod.getInstance().getFontRendererObjHandler();
	}

	/**
	 * Shortcut method for drawing a scaled textured rectangle
	 *
	 * @param xPos the <i>x</i> position of the rectangle to draw
	 * @param yPos the <i>y</i> position of the rectangle to draw
	 * @param texX the <i>x</i> boundary of the bounded texture
	 * @param texY the <i>y</i> boundary of the bounded texture
	 * @param width the <i>width</i> of the rectangle
	 * @param height the <i>height</i> of the rectangle
	 */
	private static void drawCustomSizeRect(int xPos, int yPos, int texX, int texY, int width, int height) {
		getGuiHandler().drawModalRectWithCustomSizedTexture(xPos, yPos, texX, texY, width, height, width, height);
	}

}
