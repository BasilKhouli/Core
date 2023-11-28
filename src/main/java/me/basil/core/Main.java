package me.basil.core;

import me.basil.core.commands.*;
import me.basil.core.commands.messaging.MessageCommand;
import me.basil.core.commands.messaging.ReplyCommand;
import me.basil.core.commands.moderation.PunishCommand;
import me.basil.core.commands.moderation.VanishCommand;
import me.basil.core.commands.utility.FeedCommand;
import me.basil.core.commands.utility.FlyCommand;
import me.basil.core.commands.utility.HealCommand;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();


        Bukkit.getPluginManager().registerEvents(new Events(), this);
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("config").setExecutor(new ConfigCommand(this));
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("vanish").setExecutor(new VanishCommand(this));
        getCommand("punish").setExecutor(new PunishCommand());
        getCommand("message").setExecutor(new MessageCommand());
        getCommand("reply").setExecutor(new ReplyCommand());

    }

}
