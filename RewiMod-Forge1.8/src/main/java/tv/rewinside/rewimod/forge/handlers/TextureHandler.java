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
package tv.rewinside.rewimod.forge.handlers;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import tv.rewinside.rewimod.core.RewiMod;
import tv.rewinside.rewimod.core.handlers.ITextureHandler;

public class TextureHandler implements ITextureHandler {

	private final Map<String, ResourceLocation> cachedResources = new HashMap<>();

	@Override
	public void bindTexture(String textureLocation) {
		this.bind(this.cachedResources.getOrDefault("minecraft:" + textureLocation, new ResourceLocation(textureLocation)));
	}

	@Override
	public void bindModTexture(String textureLocation) {
		String modId = RewiMod.getInstance().getModId();
		this.bind(this.cachedResources.getOrDefault(modId + ":" + textureLocation, new ResourceLocation(modId, textureLocation)));
	}

	private void bind(ResourceLocation resLoc) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(resLoc);
		this.cachedResources.putIfAbsent(resLoc.getResourceDomain() + ":" + resLoc.getResourcePath(), resLoc);
	}

}
