package net.slqmy.tss_slimebot.event.listener;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.slqmy.tss_core.util.LogUtil;
import org.jetbrains.annotations.NotNull;

public class ReadyListener implements EventListener {
  @Override
  public void onEvent(@NotNull GenericEvent event) {
	if (event instanceof ReadyEvent) {
	  LogUtil.log("Slime bot is logged in and ready!");
	}
  }
}
