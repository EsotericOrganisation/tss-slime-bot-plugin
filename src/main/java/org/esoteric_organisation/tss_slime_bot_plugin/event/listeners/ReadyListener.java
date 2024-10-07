package org.esoteric_organisation.tss_slime_bot_plugin.event.listeners;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.esoteric_organisation.tss_core_plugin.util.LogUtil;
import org.jetbrains.annotations.NotNull;

public class ReadyListener implements EventListener {
	@Override
	public void onEvent(@NotNull GenericEvent event) {
		if (event instanceof ReadyEvent) {
			LogUtil.log("Slime bot is logged in and ready!");
		}
	}
}
