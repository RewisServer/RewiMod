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
package tv.rewinside.rewimod.forge;

import java.awt.Point;
import java.net.UnknownHostException;
import lombok.Getter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.network.OldServerPinger;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.lwjgl.opengl.Display;
import tv.rewinside.rewimod.core.RewiMod;
import tv.rewinside.rewimod.core.gui.ButtonFactory;
import tv.rewinside.rewimod.forge.handlers.FontRendererObjHandler;
import tv.rewinside.rewimod.forge.handlers.GlStateManagerHandler;
import tv.rewinside.rewimod.forge.handlers.GuiHandler;
import tv.rewinside.rewimod.forge.handlers.TextureHandler;
import tv.rewinside.rewimod.forge.listener.ChatListener;
import tv.rewinside.rewimod.forge.listener.ConnectListener;
import tv.rewinside.rewimod.forge.listener.GuiListener;
import tv.rewinside.rewimod.forge.listener.RenderListener;

@Mod(modid = "%MOD_ID%", name = "%MOD_NAME%", version = "%MOD_VERSION%", canBeDeactivated = RewiMod.DEACTIVATEABLE, certificateFingerprint = RewiMod.FINGERPRINT)
public class RewiForgeMod extends RewiMod {

	@Getter private final FontRendererObjHandler fontRendererObjHandler = new FontRendererObjHandler();
	@Getter private final TextureHandler textureHandler = new TextureHandler();
	@Getter private final GuiHandler guiHandler = new GuiHandler();
	@Getter private final GlStateManagerHandler glStateManagerHandler = new GlStateManagerHandler();
	@Getter private final ButtonFactory defaultButtonFactory = new ButtonFactory("textures/gui/widgets.png", 200, 20, new Point(0, 46), new Point(0, 66), new Point(0, 86));

	@Getter private final OldServerPinger pinger = new OldServerPinger();

	@EventHandler
	public void init(FMLInitializationEvent event) {
		super.initialize(
				Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode(),
				Minecraft.getMinecraft().getVersion(),
				Minecraft.getMinecraft().getSession().getPlayerID(),
				Minecraft.getMinecraft().getSession().getUsername()
		);
	}

	@Mod.EventHandler
	public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
		super.onFingerprintViolation();
	}

	@Override
	protected void registerEvents() {
		MinecraftForge.EVENT_BUS.register(new GuiListener());
		MinecraftForge.EVENT_BUS.register(new ChatListener());
		MinecraftForge.EVENT_BUS.register(new ConnectListener());
		MinecraftForge.EVENT_BUS.register(new RenderListener());
	}

	@Override
	public void connectToServer(String name, String host, int port, boolean isLan) {
		FMLClientHandler.instance().setupServerList();
		ServerData data = new ServerData(name == null ? host : name, host + ":" + port, isLan);

		try {
			this.pinger.ping(data);
		} catch (UnknownHostException ex) {
			LOGGER.warn("Tried to connect to an unknown host!", ex);
			return;
		}

		FMLClientHandler.instance().connectToServer(Minecraft.getMinecraft().currentScreen, data);
	}

	@Override
	public String getModId() {
		return "%MOD_ID%";
	}

	@Override
	public String getName() {
		return "%MOD_NAME%";
	}

	@Override
	public String getVersion() {
		return "%MOD_VERSION%";
	}

	@Override
	public void setDisplayTitle(String displayTitle) {
		Display.setTitle(displayTitle);
	}

}
