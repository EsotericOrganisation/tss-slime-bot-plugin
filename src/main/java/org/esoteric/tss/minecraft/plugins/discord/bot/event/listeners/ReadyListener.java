package org.esoteric.tss.minecraft.plugins.discord.bot.event.listeners;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.esoteric.tss.minecraft.plugins.core.util.LogUtil;
import org.jetbrains.annotations.NotNull;

public class ReadyListener implements EventListener {
	@Override
	public void onEvent(@NotNull GenericEvent event) {
		if (event instanceof ReadyEvent) {
			LogUtil.log("Slime bot is logged in and ready!");
		}
	}
}
