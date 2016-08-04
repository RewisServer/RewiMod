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
package tv.rewinside.rewimod.core.util;

import lombok.Getter;
import lombok.Setter;
import tv.rewinside.rewimod.core.gui.CoreGuiActions;

public enum RewiButtonConnectType {
	MINECRAFT("Minecraft"),
	TEAMSPEAK("Teamspeak");

	@Getter @Setter private static RewiButtonConnectType currentType = MINECRAFT;
	@Getter private String name;

	/**
	 * Constructer of the RewiButtonConnect class
	 *
	 * @param name the name of the type
	 */
	private RewiButtonConnectType(String name) {
		this.name = name;
	}

	/**
	 * Switches the connect type which is used for determining whether the client should connect to the minecraft or teamspeak server
	 *
	 * @return the new ConnectType
	 */
	public static RewiButtonConnectType switchType() {
		currentType = currentType == MINECRAFT ? TEAMSPEAK : MINECRAFT;

		return currentType;
	}

	/**
	 * Determines what to do if a defined button has been pressed
	 *
	 * @param mouseButton the mouse button which defines which mouse button has been clicked
	 */
	public static void handleInput(int mouseButton) {
		if (mouseButton == 0) {
			switch (getCurrentType()) {
				case MINECRAFT:
					CoreGuiActions.clickButtonRewiConnect();
					break;
				case TEAMSPEAK:
					CoreGuiActions.clickButtonTeamspeakConnect();
					break;
				default:
					break;
			}
		} else if (mouseButton == 1) {
			switchType();
		}
	}

}
