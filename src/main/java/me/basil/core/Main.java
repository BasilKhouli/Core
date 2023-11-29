package me.basil.core;

import me.basil.core.commands.*;
import me.basil.core.commands.messaging.MessageCommand;
import me.basil.core.commands.messaging.ReplyCommand;
import me.basil.core.commands.moderation.PunishCommand;
import me.basil.core.commands.moderation.VanishCommand;
import me.basil.core.commands.utility.FeedCommand;
import me.basil.core.commands.utility.FlyCommand;
import me.basil.core.commands.utility.HealCommand;
import me.basil.core.enchantments.AutoSmeltingEnchantment;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // EVENTS
        Bukkit.getPluginManager().registerEvents(new Events(), this);
        // COMMANDS
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("config").setExecutor(new ConfigCommand(this));
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("vanish").setExecutor(new VanishCommand(this));
        getCommand("punish").setExecutor(new PunishCommand());
        getCommand("message").setExecutor(new MessageCommand());
        getCommand("reply").setExecutor(new ReplyCommand());

        // ENCHANTMENTS
//        AutoSmeltingEnchantment autoSmeltingEnchantment = new AutoSmeltingEnchantment();
//        Bukkit.getPluginManager().registerEvents(autoSmeltingEnchantment, this);
//        registerEnchantment(autoSmeltingEnchantment);

    }

    private void registerEnchantment (Enchantment enchantment) {
        try {
          Field field = Enchantment.class.getDeclaredField("acceptingNew");
          field.setAccessible(true);
          field.set(null, true);
          Enchantment.registerEnchantment(enchantment);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
