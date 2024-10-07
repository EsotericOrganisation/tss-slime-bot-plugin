package org.esoteric_organisation.tss_slime_bot_plugin;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.esoteric_organisation.tss_core_plugin.util.DebugUtil;
import org.esoteric_organisation.tss_slime_bot_plugin.event.listeners.ReadyListener;

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
