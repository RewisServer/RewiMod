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
package tv.rewinside.rewimod.forge.util;

import java.net.UnknownHostException;
import java.util.TimerTask;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.OldServerPinger;

public class ServerDataUpdater extends TimerTask {

	private final Minecraft mc;
	private final OldServerPinger serverPinger = new OldServerPinger();

	public ServerDataUpdater() {
		this.mc = Minecraft.getMinecraft();
	}

	@Override
	public void run() {
		if (this.mc.getCurrentServerData() == null) super.cancel();

		try {
			this.serverPinger.ping(this.mc.getCurrentServerData());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
