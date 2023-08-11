package net.slqmy.tss_slimebot;

import net.slqmy.tss_core.shaded.net.dv8tion.jda.api.JDA;
import net.slqmy.tss_core.shaded.net.dv8tion.jda.api.JDABuilder;
import net.slqmy.tss_core.shaded.net.dv8tion.jda.api.entities.Activity;
import net.slqmy.tss_core.util.DebugUtil;
import net.slqmy.tss_slimebot.event.listener.ReadyListener;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class TSSSlimeBotPlugin extends JavaPlugin {

  @Override
  public void onEnable() {
	YamlConfiguration config = (YamlConfiguration) getConfig();

	config.options().copyDefaults();
	saveDefaultConfig();

	String botToken = config.getString("discord-bot-token");

	JDABuilder jdaBuilder = JDABuilder
			.createDefault(botToken)
			.setActivity(Activity.playing("on The Slimy Swamp!"))
			.addEventListeners(new ReadyListener());

	JDA jda;

	try {
	  jda = jdaBuilder
			  .build()
			  .awaitReady();
	} catch (InterruptedException exception) {
	  DebugUtil.handleException("An unexpected error occurred while creating the JDA object!", exception);
	}


  }
}
