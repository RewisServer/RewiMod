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
package tv.rewinside.rewimod.forge.listener;

import net.minecraft.client.Minecraft;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tv.rewinside.rewimod.core.util.Chatlog;

public class ChatListener {

	@SubscribeEvent
	public void onChatReceive(ClientChatReceivedEvent event) {
		IChatComponent message = event.message;
		String sender = !message.getUnformattedText().isEmpty() ? message.getSiblings().get(0).getUnformattedText().trim() : "";

		if (Minecraft.getMinecraft().getCurrentServerData() == null) return;

		if (Chatlog.shouldCreateChatlog(message.getUnformattedText(), Minecraft.getMinecraft().getSession().getUsername(), sender, Minecraft.getMinecraft().getCurrentServerData().serverIP)) {
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/chatlog " + sender);
		}
	}

}
