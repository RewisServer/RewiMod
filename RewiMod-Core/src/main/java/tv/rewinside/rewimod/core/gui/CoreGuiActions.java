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

public class CoreGuiActions {

	/**
	 * @throws UnsupportedOperationException
	 */
	private CoreGuiActions() {
		throw new UnsupportedOperationException("Cannot instantiate helper class!");
	}

	/**
	 * Connects the player to RewisServer
	 */
	public static void clickButtonRewiConnect() {
		RewiMod.getInstance().connectToServer("mc.rewinside.tv", 25565);
	}

	/**
	 * Connects to the teamspeak server
	 */
	public static void clickButtonTeamspeakConnect() {
		RewiMod.getInstance().openUrl("ts3server://rewinside.tv");
	}

	/**
	 * Opens the browser to the Official RewiMod Website
	 */
	public static void clickButtonRewiModWebsite() {
		RewiMod.getInstance().openUrl("https://rewinside.tv/Thread/57412-Offiziell-RewiMod/");
	}

}
