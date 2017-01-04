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
import tv.rewinside.rewimod.core.gui.CoreGuiActions;

public enum RewiButtonConnectType {
	MINECRAFT("Minecraft"),
	TEAMSPEAK("Teamspeak");

	@Getter private final String name;

	/**
	 * Constructer of the RewiButtonConnect class
	 *
	 * @param name the name of the type
	 */
	private RewiButtonConnectType(String name) {
		this.name = name;
	}

	/**
	 * Determines what to do if a button was clicked
	 */
	public void click() {
		if (this == MINECRAFT) {
			CoreGuiActions.clickButtonRewiConnect();
		} else if (this == TEAMSPEAK) {
			CoreGuiActions.clickButtonTeamspeakConnect();
		}
	}

}
