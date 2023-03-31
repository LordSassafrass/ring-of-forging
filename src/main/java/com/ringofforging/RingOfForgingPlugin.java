package com.ringofforging;

import com.google.inject.Provides;
import javax.inject.Inject;

import com.ringofforging.overlay.ForgingOverlay;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import java.util.Optional;

@Slf4j
@PluginDescriptor(
	name = "Ring Of Forging Notifier"
)
public class RingOfForgingPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private RingOfForgingConfig config;

	@Inject private ForgingOverlay forgingOverlay;

	@Inject private OverlayManager overlayManager;

	private boolean forgingPresent = true;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Ring of Forging Plugin started!");
		overlayManager.add(forgingOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Ring of Forging Plugin stopped!");
		overlayManager.remove(forgingOverlay);
	}

	@Subscribe
	public void onGameTick(GameTick event) {
		final ItemContainer equipment = client.getItemContainer(InventoryID.EQUIPMENT);
		if (Optional.ofNullable(equipment).isPresent()) {
			this.forgingPresent = !equipment.contains(2568);
		}
	}

	@Provides
	RingOfForgingConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RingOfForgingConfig.class);
	}

	public boolean isForgingPresent() {
		return forgingPresent;
	}

	private void setForgingPresent(boolean forgingPresent) {
		this.forgingPresent = forgingPresent;
	}
}
