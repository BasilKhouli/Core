package me.basil.core;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import me.basil.core.commands.gui.FriendsGUICommand;
import me.basil.core.commands.gui.ProfileGUICommand;
import me.basil.core.commands.messaging.MessageCommand;
import me.basil.core.commands.messaging.ReplyCommand;
import me.basil.core.commands.moderation.PunishCommand;
import me.basil.core.commands.moderation.VanishCommand;
import me.basil.core.commands.utility.*;
import me.basil.core.listeners.FriendsGUIListener;
import me.basil.core.listeners.PlayerJoinListener;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.UUID;

public final class Main extends JavaPlugin implements Listener {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection players;

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        client = new MongoClient();
        database = client.getDatabase("profile");
        players = database.getCollection("players");



        // LISTENERS
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new FriendsGUIListener(), this);


        // COMMANDS
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("config").setExecutor(new ConfigCommand(this));
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("vanish").setExecutor(new VanishCommand(this));
        getCommand("punish").setExecutor(new PunishCommand());
        getCommand("message").setExecutor(new MessageCommand());
        getCommand("reply").setExecutor(new ReplyCommand());
        getCommand("profile").setExecutor(new ProfileGUICommand());
        getCommand("friends").setExecutor(new FriendsGUICommand());
        getCommand("friend").setExecutor(new FriendSystemCommand());

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
