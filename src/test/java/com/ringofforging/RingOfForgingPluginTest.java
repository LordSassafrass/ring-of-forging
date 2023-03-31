package com.ringofforging;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class RingOfForgingPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(RingOfForgingPlugin.class);
		RuneLite.main(args);
	}
}