package com.ringofforging;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("ringofforgingnotifier")
public interface RingOfForgingConfig extends Config
{
	@ConfigItem(
			keyName = "scale",
			name = "Scale",
			description = "The scale of the ring of forging image.")
	default int scale() {
		return 1;
	}
}
